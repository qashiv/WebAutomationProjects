package com.icici.forex.tests.cardrate;

import java.util.HashMap;

import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.icici.forex.pages.CardRateMasterPages;
import com.icici.forex.pages.CommonReusableMethods;
import com.icici.forex.pages.DashboardPage;
import com.icici.forex.utils.BaseAbstractTest;
import com.icici.forex.utils.CaptureScreenShotPage;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;

public class SCID_TM_001_Test extends BaseAbstractTest {

	/*@Scenario_Description:Maker add new Currency pair in Threshold Master and Checker accept the Request*/

	private DashboardPage dashboardPage;
	private CommonReusableMethods reusable;
	private CardRateMasterPages cardRateMasterPage;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "CardRate_TestData", executeColumn = "TUID", executeValue = "SCID_TM_001", dsUid = "TUID")

	public void addNewCurrencyPairInThresholdMaster(HashMap<String, String> args) {
		
		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = "Snapshots/SCID_TM_001";
		String toastMessage, verifyLoginPage;
		String verifyLoginPageByText = "Please Login to Continue";
		String checkerId = String.valueOf(args.get("Checker_UserId"));
		String makerId = String.valueOf(args.get("Maker_UserId"));
		String password = String.valueOf(args.get("Password"));
		String currencyPair = String.valueOf(args.get("IFRA Currency Pair"));
		String ThreshouldValue = String.valueOf(args.get("Threshold Percentage"));
		String comments = String.valueOf(args.get("Comments"));
		String approveOrReject = String.valueOf(args.get("Approve Or Reject"));

		test.log(Status.INFO, "Threshold Master Maker journey started...");
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
		dashboardPage.hoverCardRateMaster();
		cardRateMasterPage = new CardRateMasterPages(getDriver(), test);
		cardRateMasterPage.addUpdateCpyAndThresholdPercentage(currencyPair, ThreshouldValue);
		cs.takeScreenshot("ThresholdValueUpdated", report_path, "");
		reusable.logOut();

		/////// Card Rate Checker journey...
		verifyLoginPage = reusable.VerifyLoginPage();
		softAssert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		loginPage.loginApplication(checkerId, password);
		test.log(Status.INFO, "Checker logged in successfully");

		dashboardPage.clickHamburgerBtn();
		dashboardPage.hoverCardRateMaster();
		cardRateMasterPage.thresholdMasterApproval();
		cardRateMasterPage.approveOrRejectThresholdMaster(comments, approveOrReject);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Checker Approval Page Threshold Master " + toastMessage);
		cs.takeScreenshot("ThresholdMasterApproved", report_path, "");
		softAssert.assertAll();
		reusable.logOut();
		reusable.holdOn(1);

	}
}
