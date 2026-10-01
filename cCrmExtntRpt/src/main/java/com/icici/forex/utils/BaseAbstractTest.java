package com.icici.forex.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentLoggerReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.icici.forex.pages.CommonReusableMethods;
import com.icici.forex.pages.LoginPage;
import com.qaprosoft.carina.core.foundation.dataprovider.core.DataProviderFactory;
import com.qaprosoft.carina.core.foundation.listeners.CarinaListener;
import com.qaprosoft.carina.core.foundation.report.testrail.ITestCases;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.Configuration.Parameter;
import com.qaprosoft.carina.core.foundation.utils.common.CommonUtils;
import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;

@Listeners({ CarinaListener.class })
public abstract class BaseAbstractTest implements ICustomTypePageFactory, ITestCases {

	Date d = new Date();
	protected static final Logger LOGGER = Logger.getLogger(BaseAbstractTest.class.getName());
	protected static final long EXPLICIT_TIMEOUT = Configuration.getLong(Parameter.EXPLICIT_TIMEOUT);

	public static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentLoggerReporter loggerReport;
	public static ExtentReports extent;
	public static String report_path, snapshotPath, project_report_path, isCustom_Screenshot,
			custom_project_report_directory;
	public static String opfolderpath, logFolderPath;
	public static String htmlString, htmlScreenshotList, logerFile;
	public static Properties prop;
	public LoginPage loginPage;
	public static String report;
	protected CommonReusableMethods reusable;

	@BeforeSuite(alwaysRun = true)
	private void onCarinaBeforeSuite() {
		// do nothing
	}

	@BeforeSuite
	// public ExtentReports startReport()
	public void startReport() {
		try {
			if (prop == null) {
				prop = new Properties();
			}
			String propFileName = "./src/main/resources/_config.properties";
			FileInputStream fis = new FileInputStream(new File(propFileName));
			if (fis != null) {
				prop.load(fis);
			}
			// get the property value and print it out
			project_report_path = System.getProperty("user.dir") + prop.getProperty("project_report_directory");
			isCustom_Screenshot = prop.getProperty("custom_screenshot").toLowerCase();
			getExtentReports();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void setUpTest(ITestResult result) throws InterruptedException {
		test = getExtentReports().createTest(result.getMethod().getQualifiedName());
		setExtentTest(test);
		loginPage = new LoginPage(getDriver());
		loginPage.open();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(EXPLICIT_TIMEOUT, TimeUnit.SECONDS);
		test = getTest();
		reusable = new CommonReusableMethods(getDriver(), test);

	}

	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) throws IOException, InterruptedException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
			Thread.sleep(3000);
			try {
				String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				TakesScreenshot ts = (TakesScreenshot) getDriver();
				File source = ts.getScreenshotAs(OutputType.FILE);
				String dest = "../TestFailedSnapshots/FailedScreenshot_" + dateName + ".png";
				FileUtils.copyFile(source,
						new File("./reports/TestFailedSnapshots/FailedScreenshot_" + dateName + ".png"));
				getTest().fail(
						"<details><summary><b><font color=red>" + "Click to view Test Failed Error details :"
								+ "</font></b></summary>" + exceptionMessage + "</details> \n",
						MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				getTest().log(Status.FAIL, MarkupHelper
						.createLabel(result.getName() + " Test case FAILED due to above issues:", ExtentColor.RED));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			String logText = result.getName() + " Test Case PASSED";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			getTest().log(Status.PASS, m);
		} else {
			String logText = "<b> Test Method " + result.getMethod().getMethodName() + " Skipped<b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
			getTest().log(Status.SKIP, m);
		}
		getTest().info(
				"<a  target=\"_blank\" href=../emailable-report.html>Click here to view Logs and Screenshots</a>");
		if (getDriver() != null) {
			quitDriver();
		}
		getExtentReports().flush();
	}

	@AfterSuite
	public void tearDown() {
		getExtentReports().flush();
	}

	@BeforeClass(alwaysRun = true)
	private void onCarinaBeforeClass() {
		// do nothing
	}

	@BeforeMethod(alwaysRun = true)
	private void onCarinaBeforeMethod() {
		// do nothing
	}

	@DataProvider(name = "DataProvider", parallel = true)
	public Object[][] createData(final ITestNGMethod testMethod, ITestContext context) {
		Annotation[] annotations = testMethod.getConstructorOrMethod().getMethod().getDeclaredAnnotations();
		Object[][] objects = DataProviderFactory.getDataProvider(annotations, context, testMethod);
		return objects;
	}

	@DataProvider(name = "SingleDataProvider")
	public Object[][] createDataSingleThread(final ITestNGMethod testMethod, ITestContext context) {
		Annotation[] annotations = testMethod.getConstructorOrMethod().getMethod().getDeclaredAnnotations();
		Object[][] objects = DataProviderFactory.getDataProvider(annotations, context, testMethod);
		return objects;
	}

	public void pause(long timeout) {
		CommonUtils.pause(timeout);
	}

	public void pause(Double timeout) {
		CommonUtils.pause(timeout);
	}

	public static String getReportName() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yy_HH_mm_ss");
		String d = sdf.format(new Date());
		String fileName = "ICICI_Forex" + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
		return fileName;
	}

	public static String getLoggerName() {
		Date d = new Date();
		String fileName = "ICICIForexLogs" + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".log";
		return fileName;
	}

	public synchronized static ExtentReports getExtentReports() {

		if (extent == null) {
			report = getReportName();
			report_path = project_report_path + "/" + report.substring(0, report.length() - 5);
			System.out.println("new path is : " + report_path);
			if (prop == null) {
				prop = new Properties();
			}
			opfolderpath = prop.getProperty("project_report_directory");
			logFolderPath = project_report_path;
			File file = new File(report_path);
			// Creating the directory

			// snapshotPath = ;
			htmlReporter = new ExtentHtmlReporter(report_path + file.separator + "ExtReport" + report);
			loggerReport = new ExtentLoggerReporter(report_path + file.separator + "logs");

			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.attachReporter(loggerReport);
			extent.setSystemInfo("OS", "Window");
			extent.setSystemInfo("Browser", "Chrome");
			extent.setSystemInfo("Environment", "QA");

			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setDocumentTitle("ICICI Forex DS Automation Report");
			htmlReporter.config().setReportName("ICICI Forex Trading Automation Report");
		}
		return extent;
	}

	public static ThreadLocal<ExtentTest> getExtentTest() {
		return extentTest;
	}

	public static void setExtentTest(ExtentTest test) {
		extentTest.set(test);
	}

	public static ExtentTest getTest() {
		return extentTest.get();
	}
}
