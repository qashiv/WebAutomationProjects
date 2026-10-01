package com.icici.forex.tests.cardrate;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.icici.forex.pages.CardRateMasterPages;
import com.icici.forex.pages.CardRatePages;
import com.icici.forex.pages.CardRateReportsPages;
import com.icici.forex.pages.CommonReusableMethods;
import com.icici.forex.pages.DashboardPage;
import com.icici.forex.utils.BaseAbstractTest;
import com.icici.forex.utils.CaptureScreenShotPage;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;

public class CardRate_E2E extends BaseAbstractTest {

	private DashboardPage dashboardPage;
	private CommonReusableMethods reusable;
	private CardRateMasterPages cardRateMasterPages;
	private CardRatePages cardRatePages;
	private CardRateReportsPages cardRateReportsPages;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "CardRate_TestData", executeColumn = "TUID", executeValue = "CardRate_E2E", dsUid = "TUID")
	public void cardRateE2EFlow(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = "Snapshots/CardRate_E2E_Test";
		String toastMessage, verifyLoginPage, actRequestStatus;
		String verifyLoginPageByText = "Please Login to Continue";
		String makerId = String.valueOf(args.get("Maker_UserId"));
		String checkerId = String.valueOf(args.get("Checker_UserId"));
		String password = String.valueOf(args.get("Password"));
		String marketType = String.valueOf(args.get("Market Type"));
		String productName = String.valueOf(args.get("Product Name"));
		String productGeographyName = String.valueOf(args.get("Product Or Geography"));
		String marginCurrencyPair = String.valueOf(args.get("Currency Pair"));
		String marginType = String.valueOf(args.get("Margin Type"));
		String marginSlab = String.valueOf(args.get("Margin Slabs"));
		String bankSellingMargin = String.valueOf(args.get("Bank Selling Margin"));
		String bankBuyingMargin = String.valueOf(args.get("Bank Buying Margin"));
		String slabRangeFrom = String.valueOf(args.get("Slab Range From"));
		String slabRangeTo = String.valueOf(args.get("Slab Range To"));
		String comment = String.valueOf(args.get("Remark"));
		String acceptOrReject = String.valueOf(args.get("Approve Or Reject"));
		String IFRACurrencyPair = String.valueOf(args.get("IFRA Currency Pair"));
		String isJPMC = String.valueOf(args.get("is JPMC"));
		String JPMCCurrencyPair = String.valueOf(args.get("JPMC Currency Pair"));
		String isIFRA = String.valueOf(args.get("is IFRA"));
		String approveOrReject = String.valueOf(args.get("Approve Or Reject"));
		String IFRAFilePath = String.valueOf(args.get("IFRA File Path"));
		String JPMCFilePath = String.valueOf(args.get("JPMC File Path"));
		String approveOrRejectIDS = String.valueOf(args.get("Approve Or Reject IDS"));
		String cardRateType = String.valueOf(args.get("Card Rate Type"));
		String expRequestStatus = "Pending for approval";

		// Product Master

		test.log(Status.INFO, "Card Rate Maker is started");
		reusable = new CommonReusableMethods(getDriver(), test);
		test.log(Status.INFO, "Passed, URL opened successfully");
		reusable = new CommonReusableMethods(getDriver(), test);
		verifyLoginPage = reusable.VerifyLoginPage();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "Maker navigated on Login Page successfully");
		loginPage.loginApplication(makerId, password);
		test.log(Status.INFO, "Card Rate Maker logged in successfully");

		dashboardPage = new DashboardPage(getDriver(), test);
		dashboardPage.clickHamburgerBtn();
		reusable.holdOn(1);
		dashboardPage.hoverCardRateMaster();
		cardRateMasterPages = new CardRateMasterPages(getDriver(), test);
		cardRateMasterPages.goToProductMaster();
		cardRateMasterPages.updateProductOnProductMaster(marketType, productGeographyName, marginSlab, marginCurrencyPair,
				marginType, slabRangeFrom, slabRangeTo, bankSellingMargin, bankBuyingMargin);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Product Status on Product Master tab : " + toastMessage);
		reusable.logOut();
		verifyLoginPage = reusable.VerifyLoginPage();
		softAssert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "Maker navigated on Login Page successfully");
		loginPage.loginApplication(checkerId, password);

		dashboardPage.clickHamburgerBtn();
		dashboardPage.hoverCardRateMaster();
		reusable.holdOn(1);
		cardRateMasterPages.acceptOrRejectProductInProductMaster(marketType, comment, acceptOrReject);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Product Status on Product Master tab : " + toastMessage);
		reusable.logOut();
		/// Rate Source
		verifyLoginPage = reusable.VerifyLoginPage();
		softAssert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "Maker navigated on Login Page successfully");
		loginPage.loginApplication(makerId, password);
		test.log(Status.INFO, "Maker logged in successfully");

		dashboardPage.clickHamburgerBtn();
		dashboardPage.hoverCardRate();
		cardRatePages = new CardRatePages(getDriver(), test);
		cardRatePages.addRateSourceByAutoFetchIfraOrJpmc(marketType, isIFRA, IFRACurrencyPair, isJPMC,
				JPMCCurrencyPair);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Rate Source : " + toastMessage);
		cs.takeScreenshot("RateSourceAdded", report_path, "");

		cardRatePages.getMyRequestStatus().isElementPresent(EXPLICIT_TIMEOUT);
		cardRatePages.openMyRequest();
		cardRatePages.getTextPendingForApproval().isElementPresent(EXPLICIT_TIMEOUT);
		actRequestStatus = cardRatePages.getRequestStatus().getText();
		Assert.assertEquals(actRequestStatus, expRequestStatus, "Actual Request Status : " + actRequestStatus
				+ " and Expected Request Status : " + expRequestStatus + " are not matched");
		reusable.holdOn(1);
		reusable.logOut();
		test.log(Status.INFO, "Card Rate Maker updated rate source sucessfully");

		verifyLoginPage = reusable.VerifyLoginPage();
		softAssert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		loginPage.loginApplication(checkerId, password);
		test.log(Status.INFO, "Checker logged in successfully");

		dashboardPage.clickHamburgerBtn();
		dashboardPage.hoverCardRate();
		cardRatePages.approveOrRejectRateSource(comment, approveOrReject, marketType);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Checker Approval Page : " + toastMessage);
		cs.takeScreenshot("CheckerApprovalReport", report_path, "");
		reusable.logOut();

		/// Input Data Sheet

		verifyLoginPage = reusable.VerifyLoginPage();
		Assert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "Maker navigated on Login Page successfully");
		loginPage.loginApplication(makerId, password);
		test.log(Status.INFO, "Maker logged in successfully");
		dashboardPage.clickHamburgerBtn();
		dashboardPage.hoverCardRate();
		reusable.holdOn(1);
		cardRatePages = new CardRatePages(getDriver(), test);
		cardRatePages.uploadFilesOnInputDataSheet(marketType, IFRAFilePath, JPMCFilePath);

		reusable.logOut();
		test.log(Status.INFO, "Input datasheet updated sucessfully");

		verifyLoginPage = reusable.VerifyLoginPage();
		Assert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		loginPage.loginApplication(checkerId, password);
		test.log(Status.INFO, "Checker logged in successfully");

		dashboardPage.clickHamburgerBtn();
		dashboardPage.hoverCardRate();
		cardRatePages.approveOrRejectInputDataSheet(comment, approveOrRejectIDS, marketType);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Checker Approval Page Rate Source : " + toastMessage);
		reusable.holdOn(2);
		reusable.logOut();

		//// Card Rate Report

		verifyLoginPage = reusable.VerifyLoginPage();
		Assert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "Maker navigated on Login Page successfully");
		loginPage.loginApplication(makerId, password);
		test.log(Status.INFO, "Card Rate Maker logged in successfully");

		dashboardPage.clickHamburgerBtn();
		reusable.holdOn(1);
		dashboardPage.hoverCardRateReports();
		cardRateReportsPages = new CardRateReportsPages(getDriver(), test);
		cardRateReportsPages.verifyCardRatesReport(marketType, cardRateType, productName);
		softAssert.assertAll();
		reusable.holdOn(2);
		reusable.logOut();
	}
}
