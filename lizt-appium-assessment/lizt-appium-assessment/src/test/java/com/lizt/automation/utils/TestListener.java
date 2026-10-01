package com.lizt.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	private static final ExtentReports REPORT = createReport();
	private static final ThreadLocal<ExtentTest> CURRENT = new ThreadLocal<>();

	private static ExtentReports createReport() {
		ExtentSparkReporter spark = new ExtentSparkReporter("reports/extent-report.html");
		spark.config().setDocumentTitle("Lizt Appium Test Report");
		spark.config().setReportName("Lizt Android Mobile Automation");
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		return report;
	}

	@Override
	public void onTestStart(ITestResult result) {
		CURRENT.set(REPORT.createTest(result.getMethod().getMethodName()));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		CURRENT.get().pass("PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String screenshot = "";
		Object instance = result.getInstance();
		if (instance instanceof com.lizt.automation.base.BaseTest base && base.getDriver() != null) {
			screenshot = ScreenshotUtil.capture(base.getDriver(), result.getMethod().getMethodName());
		}
		CURRENT.get().fail(result.getThrowable());
		if (!screenshot.isBlank() && !screenshot.startsWith("Screenshot failed")) {
			try {
				CURRENT.get().addScreenCaptureFromPath(screenshot);
			} catch (Exception ignored) {
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		CURRENT.get().skip("SKIPPED: " + result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		REPORT.flush();
	}
}
