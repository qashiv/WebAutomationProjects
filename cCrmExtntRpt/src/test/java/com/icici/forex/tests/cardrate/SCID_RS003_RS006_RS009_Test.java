package com.icici.forex.tests.cardrate;

import java.util.HashMap;

import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.icici.forex.pages.CardRatePages;
import com.icici.forex.pages.CommonReusableMethods;
import com.icici.forex.pages.DashboardPage;
import com.icici.forex.utils.BaseAbstractTest;
import com.icici.forex.utils.CaptureScreenShotPage;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;

public class SCID_RS003_RS006_RS009_Test extends BaseAbstractTest {

	/*
	 * @Scenario_Description:To verify the scenario where the maker fetch the rate
	 * source from IFRA and JPMC for some currency pair by Auto fetch and some by
	 * Manual fetch for domestic/IBG market and checker approves/Reject the rate
	 * source.
	 */

	private DashboardPage dashboardPage;
	private CardRatePages cardRatePages;
	private CommonReusableMethods reusable;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "CardRate_TestData", executeColumn = "TUID", executeValue = "SCID_RS003_RS006_RS009", dsUid = "TUID")
	public void testMakerAddRateSourceAndCheckerVerifies(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = "Snapshots/SCID_RS003_RS006_RS009_Test";
		String toastMessage, actRequestStatus, verifyLoginPage;
		String verifyLoginPageByText = "Please Login to Continue";
		String makerId = String.valueOf(args.get("Maker_UserId"));
		String password = String.valueOf(args.get("Password"));
		String marketType = String.valueOf(args.get("Market Type"));
		String IFRACurrencyPair = String.valueOf(args.get("IFRA Currency Pair"));
		String isJPMC = String.valueOf(args.get("is JPMC"));
		String JPMCCurrencyPair = String.valueOf(args.get("JPMC Currency Pair"));
		String isIFRA = String.valueOf(args.get("is IFRA"));
		String expRequestStatus = "Pending for approval";
		String checkerId = String.valueOf(args.get("Checker_UserId"));
		String comments = String.valueOf(args.get("Comments"));
		String approveOrReject = String.valueOf(args.get("Approve Or Reject"));

		test.log(Status.INFO, "Card Rate Maker journey started...");
		reusable = new CommonReusableMethods(getDriver(), test);
		verifyLoginPage = reusable.VerifyLoginPage();
		Assert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "Maker navigated on Login Page successfully");
		loginPage.loginApplication(makerId, password);
		test.log(Status.INFO, "Maker logged in successfully");

		dashboardPage = new DashboardPage(getDriver(), test);
		dashboardPage.clickHamburgerBtn();
		reusable.holdOn(1);
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
		Assert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		loginPage.loginApplication(checkerId, password);
		test.log(Status.INFO, "Checker logged in successfully");

		dashboardPage.clickHamburgerBtn();
		dashboardPage.hoverCardRate();
		cardRatePages.approveOrRejectRateSource(comments, approveOrReject, marketType);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Checker Approval Page : " + toastMessage);
		cs.takeScreenshot("CheckerApprovalReport", report_path, "");
		reusable.logOut();
		reusable.holdOn(1);
	}
}
