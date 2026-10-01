package com.icici.forex.tests.cardrate;

import java.util.HashMap;

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

public class SCID_IDS003_IDS007_IDS011_Test extends BaseAbstractTest {
	/**
	 * @Scenario_Description: Maker updates the Input data sheet for domestic market
	 *                        and Checkers approves it
	 */

	private DashboardPage dashboardPage;
	private CardRatePages cardRatePages;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "CardRate_TestData", executeColumn = "TUID", executeValue = "SCID_IDS003_IDS007_IDS011", dsUid = "TUID")
	public void updateInputDataSheetForDomesticMarket(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = "Snapshots/SCID_IDS003_IDS007_IDS011_Test";
		String toastMessage, actRequestStatus, verifyLoginPage;
		String verifyLoginPageByText = "Please Login to Continue";
		String makerId = String.valueOf(args.get("Maker_UserId"));
		String password = String.valueOf(args.get("Password"));
		String marketType = String.valueOf(args.get("Market Type"));
		String IFRACurrencyPair = String.valueOf(args.get("IFRA Currency Pair"));
		String isIFRA = String.valueOf(args.get("is IFRA"));
		String isJPMC = String.valueOf(args.get("is JPMC"));
		String JPMCCurrencyPair = String.valueOf(args.get("JPMC Currency Pair"));
		String expRequestStatus = "Pending for approval";
		String checkerId = String.valueOf(args.get("Checker_UserId"));
		String comments = String.valueOf(args.get("Comments"));
		String approveOrReject = String.valueOf(args.get("Approve Or Reject"));
		String approveOrRejectIDS = String.valueOf(args.get("Approve Or Reject IDS"));
		String IFRAFilePath = "IFRA File Path";
		String JPMCFilePath = "JPMC File Path";

		/// Card Rate Maker Journey...
		test.log(Status.INFO, "Card Rate Maker journey started...");
		reusable = new CommonReusableMethods(getDriver(), test);
		verifyLoginPage = reusable.VerifyLoginPage();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "Maker navigated on Login Page successfully");
		loginPage.loginApplication(makerId, password);
		test.log(Status.INFO, "Maker logged in successfully");
		dashboardPage = new DashboardPage(getDriver(), test);
		dashboardPage.clickHamburgerBtn();
		reusable.holdOn(1);
		dashboardPage.hoverCardRate();
		cardRatePages = new CardRatePages(getDriver(), test);
		cardRatePages.addRateSourceByAutoFetch(marketType, IFRACurrencyPair, isJPMC, JPMCCurrencyPair, isIFRA,
				checkerId, password, comments, approveOrRejectIDS, makerId);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Rate Source : " + toastMessage);
		reusable.holdOn(1);
		cardRatePages.openMyRequest();
		actRequestStatus = cardRatePages.getRequestStatus().getAttribute("title");
		softAssert.assertEquals(actRequestStatus, expRequestStatus, "Actual Request Status : " + actRequestStatus
				+ " and Expected Request Status : " + expRequestStatus + " are not matched");
		cs.takeScreenshot("RateSourceAddedByAutoFetch", report_path, "");
		reusable.holdOn(2);
		reusable.logOut();
		test.log(Status.INFO, "Card Rate Maker updated rate source sucessfully");

		verifyLoginPage = reusable.VerifyLoginPage();
		softAssert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		loginPage.loginApplication(checkerId, password);
		test.log(Status.INFO, "Checker logged in successfully");

		dashboardPage.clickHamburgerBtn();
		dashboardPage.hoverCardRate();
		cardRatePages.approveOrRejectRateSource(comments, approveOrReject, marketType);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Checker Approval Page : " + toastMessage);
		reusable.holdOn(2);
		reusable.logOut();
		test.log(Status.INFO, "Card Rate Maker journey started...");
		verifyLoginPage = reusable.VerifyLoginPage();
		softAssert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "Maker navigated on Login Page successfully");
		loginPage.loginApplication(makerId, password);
		test.log(Status.INFO, "Maker logged in successfully");
		dashboardPage.clickHamburgerBtn();
		dashboardPage.hoverCardRate();
		reusable.holdOn(1);
		cardRatePages.uploadFilesOnInputDataSheet(marketType, IFRAFilePath, JPMCFilePath);
		reusable.holdOn(2);
		reusable.logOut();
		test.log(Status.INFO, "Input datasheet updated sucessfully");

		// card rate checker Journey

		verifyLoginPage = reusable.VerifyLoginPage();
		softAssert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		loginPage.loginApplication(checkerId, password);
		test.log(Status.INFO, "Checker logged in successfully");

		dashboardPage.clickHamburgerBtn();
		dashboardPage.hoverCardRate();
		cardRatePages.approveOrRejectInputDataSheet(comments, approveOrRejectIDS, marketType);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Checker Approval Page Rate Source : " + toastMessage);
		reusable.holdOn(2);
		reusable.logOut();
		softAssert.assertAll();
		reusable.holdOn(1);
	}
}
