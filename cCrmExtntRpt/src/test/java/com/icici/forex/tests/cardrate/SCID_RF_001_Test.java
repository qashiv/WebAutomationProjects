package com.icici.forex.tests.cardrate;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.icici.forex.pages.CardRatePages;
import com.icici.forex.pages.CommonReusableMethods;
import com.icici.forex.pages.DashboardPage;
import com.icici.forex.utils.BaseAbstractTest;
import com.icici.forex.utils.CaptureScreenShotPage;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;

public class SCID_RF_001_Test extends BaseAbstractTest {

	/**
	 * @Scenario_Description: Add new Daily/Hourly/Custom Rate refresh for
	 *                        domestic/IBG market and checker approves the rate
	 *                        refresh frequency
	 */

	private DashboardPage dashboardPage;
	private CardRatePages cardRatePages;
	private CommonReusableMethods reusable;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "CardRate_TestData", executeColumn = "TUID", executeValue = "SCID_RF_001", dsUid = "TUID")
	public void refreshrateconfiguration(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = "Snapshots/SCID_RF_001_Test";
		String toastMessage, actRequestStatus, verifyLoginPage;
		String verifyLoginPageByText = "Please Login to Continue";
		String makerId = String.valueOf(args.get("Maker_UserId"));
		String password = String.valueOf(args.get("Password"));
		String marketType = String.valueOf(args.get("Market Type"));
		String IFRACurrencyPair = String.valueOf(args.get("IFRA Currency Pair"));
		String isJPMC = String.valueOf(args.get("is JPMC"));
		String JPMCCurrencyPair = String.valueOf(args.get("JPMC Currency Pair"));
		String manualCurrencyPair = String.valueOf(args.get("Manual Currency Pair"));
		String expRequestStatus = "Pending for approval";
		String checkerId = String.valueOf(args.get("Checker_UserId"));
		String comments = String.valueOf(args.get("Comments"));
		String approveOrReject = String.valueOf(args.get("Approve Or Reject"));
		String refreshFrequency = String.valueOf(args.get("Refresh Frequency"));
		String customTime = String.valueOf(args.get("Custom Time"));
		String refreshTimeFrom = String.valueOf(args.get("Refresh Time From"));
		String refreshTimeTo = String.valueOf(args.get("Refresh Time To"));

		test.log(Status.INFO, "Card Rate Maker journey started...");
		reusable = new CommonReusableMethods(getDriver(), test);
		verifyLoginPage = reusable.VerifyLoginPage();
		SoftAssert softAssert = new SoftAssert();
		Assert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "Maker navigated on Login Page successfully");
		loginPage.loginApplication(makerId, password);
		test.log(Status.INFO, "Maker logged in successfully");

		dashboardPage = new DashboardPage(getDriver(), test);
		dashboardPage.clickHamburgerBtn();
		reusable.holdOn(1);
		dashboardPage.hoverCardRate();
		cardRatePages = new CardRatePages(getDriver(), test);
		cardRatePages.addRateSourceByAutoAndManualMode(marketType, IFRACurrencyPair, isJPMC, JPMCCurrencyPair,
				manualCurrencyPair);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Rate Source : " + toastMessage);
		cardRatePages.openMyRequest();
		cs.takeScreenshot("RateSourceAdded", report_path, "");
		actRequestStatus = cardRatePages.getRequestStatus().getText();
		softAssert.assertEquals(actRequestStatus, expRequestStatus, "Actual Request Status : " + actRequestStatus
				+ " and Expected Request Status : " + expRequestStatus + " are not matched");
		reusable.holdOn(1);
		reusable.logOut();
		verifyLoginPage = reusable.VerifyLoginPage();
		softAssert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "Checker navigated on Login Page successfully");
		loginPage.loginApplication(checkerId, password);
		test.log(Status.INFO, "Checker logged in successfully for rate source approval");
		dashboardPage.clickHamburgerBtn();
		dashboardPage.hoverCardRate();
		cardRatePages.approveOrRejectRateSource(comments, approveOrReject, marketType);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		cs.takeScreenshot("RateSourceApproved", report_path, "");
		test.log(Status.INFO, "Checker Approval Page Rate Source : " + toastMessage);
		reusable.holdOn(2);
		reusable.logOut();

		verifyLoginPage = reusable.VerifyLoginPage();
		softAssert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "Maker navigated on Login Page successfully");
		loginPage.loginApplication(makerId, password);
		test.log(Status.INFO, "Maker logged in successfully");

		dashboardPage.clickHamburgerBtn();
		reusable.holdOn(1);
		dashboardPage.hoverCardRate();
		cardRatePages.addRefreshRate(marketType, refreshFrequency, customTime, refreshTimeFrom, refreshTimeTo);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		cs.takeScreenshot("AddedRefreshRate", report_path, "");
		test.log(Status.INFO, "Rate Source : " + toastMessage);
		cardRatePages.getMyRequestStatus().isElementPresent(EXPLICIT_TIMEOUT);
		cardRatePages.openMyRequest();
		cardRatePages.getTextPendingForApproval().isElementPresent(EXPLICIT_TIMEOUT);
		cs.takeScreenshot("RafreshRateStatus", report_path, "");
		actRequestStatus = cardRatePages.getRequestStatus().getText();
		softAssert.assertEquals(actRequestStatus, expRequestStatus, "Actual Request Status : " + actRequestStatus
				+ " and Expected Request Status : " + expRequestStatus + " are not matched");
		reusable.holdOn(2);
		reusable.logOut();
		test.log(Status.INFO, "Card Rate Maker updated rate source sucessfully");

		verifyLoginPage = reusable.VerifyLoginPage();
		softAssert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		loginPage.loginApplication(checkerId, password);
		test.log(Status.INFO, "Checker logged in successfully");
		dashboardPage.clickHamburgerBtn();
		reusable.holdOn(1);
		dashboardPage.hoverCardRate();
		cardRatePages.approveOrRejectRefreshRate(comments, approveOrReject);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		cs.takeScreenshot("ApproveOrRejectRefreshRate", report_path, "");
		test.log(Status.INFO, "Checker Approval Page Refresh Rate : " + toastMessage);
		softAssert.assertAll();
		reusable.holdOn(2);
		reusable.logOut();
		reusable.holdOn(1);

	}
}
