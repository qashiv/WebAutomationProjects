 package com.E2logy.gfhotel.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.E2logy.gfhotel.common.pages.CommonPage;
import com.E2logy.gfhotel.utilities.WebUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import lombok.Getter;

@Getter
public class BaseTest {
	
	private String url ;
	private String userName ;
	private String userPassword ;
	protected WebUtil webUtil;
	protected CommonPage reuseCode;
	
	private static ExtentReports extent;
	
	@BeforeSuite(groups="SmokeTest")
	public void beforeSuite() {
		System.out.println("Extent-Report Initialization");
		String date = new SimpleDateFormat("-dd-MM-yyyy__HH_mm_ss---").format(new Date());
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("test-output//ExtentReports//gfhotel"+date+".html");
		extent.attachReporter(spark);
	}
	@BeforeTest
	public void beforeTestTag() {
		System.out.println("Connect To The Data Base");
	}

	// @Parameters({"browser"})
	@BeforeClass(groups="SmokeTest")
	public void beforeTestCases() throws IOException{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("src\\test\\resources\\config.properties");
		prop.load(file);
		url = prop.getProperty("url"); 
		
		userName = prop.getProperty("userName");
		userPassword = prop.getProperty("userPassword");
		webUtil = WebUtil.getObject();
		webUtil.launchBrowser("chrome");
		webUtil.goToHitUrl(url);
	}
	//// data management

	// @Parameters({"username", "password"})
	@BeforeMethod(groups="SmokeTest")
	public void beforeMethod(Method mt) {
		ExtentTest extTest = extent.createTest(mt.getName());
		webUtil.setExtentTestObject(extTest);
		reuseCode = new CommonPage(webUtil);
		reuseCode.login(userName, userPassword);
	}
	@AfterMethod(groups="SmokeTest")
	public void afterMethod(ITestResult result, Method mt) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String snapshotPath = webUtil.takeSnapshot(mt.getName());
			webUtil.getExtentTestObject().addScreenCaptureFromPath(snapshotPath);
		}

		extent.flush();
	}	
	@AfterClass
	public void afterClass() {
		webUtil.quit();

	}

	@AfterTest
	public void afterTest() {
		System.out.println("Disconnect From The Data Base");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Extent-Report Finalization");
		extent.flush();
	}

}
