package com.icici.forex.tests.cardrate;

import java.util.HashMap;
import java.util.List;

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

public class SCID_CC_007_Test extends BaseAbstractTest {

	/*
	 * @Scenario_Description:To check currency conversion where If FC1 is G5, FC2 is
	 * not G5
	 */

	private DashboardPage dashboardPage;
	private CardRatePages cardRatePages;
	private CommonReusableMethods reusable;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "CardRate_TestData", executeColumn = "TUID", executeValue = "SCID_CC_007", dsUid = "TUID")
	public void testMakerAddRateSourceAndCheckerVerifies(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = "Snapshots/SCID_CC_007_Test";
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
		String FCINR_SellingCP = String.valueOf(args.get("FCINR Selling Currency Pair"));
		String rejectPendingRates = String.valueOf(args.get("Pending Request"));

		test.log(Status.INFO, "Curency Conversion journey started...");
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
				checkerId, password, comments, rejectPendingRates, makerId);
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

		reusable.logOut();
		test.log(Status.INFO, "Card Rate Maker journey started...");
		verifyLoginPage = reusable.VerifyLoginPage();
		reusable.holdOn(2);
		softAssert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "Maker navigated on Login Page successfully");
		loginPage.loginApplication(makerId, password);
		test.log(Status.INFO, "Maker logged in successfully");

		dashboardPage.clickHamburgerBtn();
		reusable.holdOn(1);
		dashboardPage.hoverCardRate();
		cardRatePages.goToInputDataSheet();
		cardRatePages.clickBtnFecthRates();
		reusable.holdOn(1);
		String msg = reusable.toastMessage();
		List<String> rates = null;
		try {
			if (msg.contains("Rates fetched successfully")) {
				reusable.holdOn(1);
				rates = cardRatePages.returnInterbankSellingRatesFCFCFromIDS(IFRACurrencyPair);
			}
			double rate1 = Double.parseDouble(rates.get(1));
			double rate2 = Double.parseDouble(rates.get(3));
			double expectedSellingRate = rate1 * rate2;
			String actSellingRate = cardRatePages.returnFCINRSellingRatesFromIDS(FCINR_SellingCP);// rajesg24
			double actualSellingRate = Double.parseDouble(actSellingRate);
			reusable.holdOn(1);
			double truncatedValue1 = reusable.truncateToTwoDecimalPlaces(actualSellingRate);
			double truncateValue2 = reusable.truncateToTwoDecimalPlaces(expectedSellingRate);
			if (truncatedValue1 == truncateValue2) {
				test.log(Status.PASS, "Passed, Actual Selling Rate : " + truncatedValue1
						+ " and Expected Selling Rate : " + truncateValue2 + " are matched.");
			} else {
				test.log(Status.FAIL, "Failed, Actual Selling Rate : " + truncatedValue1
						+ " and Expected Selling Rate : " + truncateValue2 + " are mismatched");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Problem occured while finding rates, so unable to find rates");
		}
		cs.takeScreenshot("VerifiedSellingRates", report_path, "");
		softAssert.assertAll();
		reusable.holdOn(2);
		reusable.logOut();
		reusable.holdOn(1);

	}
}
