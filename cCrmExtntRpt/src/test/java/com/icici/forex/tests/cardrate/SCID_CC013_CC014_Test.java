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

public class SCID_CC013_CC014_Test extends BaseAbstractTest {
	
	
	/*@Scenario_Description:For IBG_No restriction on decimal for IBR rates in input data sheet 
	 * and For IBG_Negative c/s point is allowed*/
	

	private DashboardPage dashboardPage;
	private CardRatePages cardRatePages;
	private CommonReusableMethods reusable;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "CardRate_TestData", executeColumn = "TUID", executeValue = "SCID_CC_013_SCID_CC_014", dsUid = "TUID")
	public void testMakerAddRateSourceAndCheckerVerifies(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = "Snapshots/SCID_CC_013_SCID_CC_014";
		String toastMessage, actRequestStatus, verifyLoginPage;
		String verifyLoginPageByText = "Please Login to Continue";
		String makerId = String.valueOf(args.get("Maker_UserId"));
		String password = String.valueOf(args.get("Password"));
		String marketType = String.valueOf(args.get("Market Type"));
		String IFRACurrencyPair = String.valueOf(args.get("IFRA Currency Pair"));
		String isJPMC = String.valueOf(args.get("is JPMC"));
		String isIFRA = String.valueOf(args.get("is IFRA"));
		String JPMCCurrencyPair = String.valueOf(args.get("JPMC Currency Pair"));
		String expRequestStatus = "Pending for approval";
		String checkerId = String.valueOf(args.get("Checker_UserId"));
		String comments = String.valueOf(args.get("Comments"));
		String approveOrReject = String.valueOf(args.get("Approve Or Reject"));
		String rejectPendingRates = String.valueOf(args.get("Pending Request"));

		test.log(Status.INFO, "Curency Conversion journey started...");
		test.log(Status.INFO, "Card Rate Maker journey started...");
		reusable = new CommonReusableMethods(getDriver(), test);
		verifyLoginPage = reusable.VerifyLoginPage();
		SoftAssert softAssert =new SoftAssert();
		softAssert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "Maker navigated on Login Page successfully");
		loginPage.loginApplication(makerId, password);
		test.log(Status.INFO, "Maker logged in successfully");

		dashboardPage = new DashboardPage(getDriver(), test);
		dashboardPage.clickHamburgerBtn();
		reusable.holdOn(1);
		dashboardPage.hoverCardRate();
		cardRatePages = new CardRatePages(getDriver(), test);
		cardRatePages.addRateSourceByAutoFetch(marketType, IFRACurrencyPair, isJPMC, JPMCCurrencyPair,isIFRA,checkerId,password,comments,rejectPendingRates,makerId);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Rate Source : " + toastMessage);
		
		cardRatePages.getMyRequestStatus().isElementPresent(EXPLICIT_TIMEOUT);
		cardRatePages.openMyRequest();
		cardRatePages.getTextPendingForApproval().isElementPresent(EXPLICIT_TIMEOUT);
		actRequestStatus = cardRatePages.getRequestStatus().getText();
		softAssert.assertEquals(actRequestStatus, expRequestStatus, "Actual Request Status : " + actRequestStatus
				+ " and Expected Request Status : " + expRequestStatus + " are not matched");
		cs.takeScreenshot("RateSourceAddedByAutoFetch", report_path, "");
	    reusable.holdOn(1);
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
		reusable.logOut();

		test.log(Status.INFO, "Card Rate Maker journey started...");
		verifyLoginPage = reusable.VerifyLoginPage();
		reusable.holdOn(2);
		softAssert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "Maker navigated on Login Page successfully");
		loginPage.loginApplication(makerId, password);
		test.log(Status.INFO, "Maker logged in successfully");
		dashboardPage.clickHamburgerBtn();
		dashboardPage.hoverCardRate();
		cardRatePages.goToInputDataSheet();
		cardRatePages.getBtnFetchRate().clickByJs();
		reusable.holdOn(1);
		String msg = reusable.toastMessage();
		boolean decimalLimit = false;
		if (msg.contains("Rates fetched successfully")) {
			reusable.holdOn(1);
			decimalLimit = cardRatePages.isNoDecimalLimit(IFRACurrencyPair);
		}
		test.log(Status.INFO, "No Restriction on Decimal for IBR Rates : " + decimalLimit);
		softAssert.assertTrue(decimalLimit, "There is Decimal Limit Detected");
		cs.takeScreenshot("VerifiedSellingRates", report_path, "");
		float negativeRates = cardRatePages.getCashSpotRate();
		test.log(Status.INFO, "Negative value is allowed : " + negativeRates);
		softAssert.assertAll();
		reusable.holdOn(2);
		reusable.logOut();
		reusable.holdOn(1);
	}
}
