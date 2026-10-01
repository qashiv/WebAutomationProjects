package com.icici.forex.tests.cardrate;

import java.util.HashMap;

import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.icici.forex.pages.CardRateMasterPages;
import com.icici.forex.pages.CardRatePages;
import com.icici.forex.pages.CommonReusableMethods;
import com.icici.forex.pages.DashboardPage;
import com.icici.forex.utils.BaseAbstractTest;
import com.icici.forex.utils.CaptureScreenShotPage;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;

public class SCID_PM_004_Test extends BaseAbstractTest {

	/**
	 * @Scenario_Description: Maker update product in product master by updating the
	 *                        slab_deletion for domestic market with margin type %
	 *                        ,BPS and PPS and checker approves the product master
	 *                        #PreCondition - Product should be added on Product
	 *                        Master
	 */

	private DashboardPage dashboardPage;
	private CommonReusableMethods reusable;
	private CardRateMasterPages cardRateMasterPages;
	private CardRatePages cardRatePages;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "CardRate_TestData", executeColumn = "TUID", executeValue = "SCID_PM_004", dsUid = "TUID")
	public void makerAddsNewProductinProductMaster(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = "Snapshots/SCID_PM_004_Test";
		String toastMessage, verifyLoginPage;
		String verifyLoginPageByText = "Please Login to Continue";
		String makerId = String.valueOf(args.get("Maker_UserId"));
		String productName = String.valueOf(args.get("Product Or Geography"));
		String marginCurrencyPair = String.valueOf(args.get("Currency Pair"));
		String marginType = String.valueOf(args.get("Margin Type"));
		String marginSlab = String.valueOf(args.get("Margin Slabs"));
		String bankSellingMargin = String.valueOf(args.get("Bank Selling Margin"));
		String bankBuyingMargin = String.valueOf(args.get("Bank Buying Margin"));
		String slabRangeFrom = String.valueOf(args.get("Slab Range From"));
		String slabRangeTo = String.valueOf(args.get("Slab Range To"));
		String checkerId = String.valueOf(args.get("Checker_UserId"));
		String password = String.valueOf(args.get("Password"));
		String marketType = String.valueOf(args.get("Market Type"));
		String comment = String.valueOf(args.get("Comments"));
		String acceptOrReject = String.valueOf(args.get("Approve Or Reject"));
		String expRequestStatus = "Pending for approval";

		test.log(Status.INFO, "Card Rate Maker is started");
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
		reusable.holdOn(1);
		cardRateMasterPages.updateProductOnProductMaster(marketType, productName, marginSlab, marginCurrencyPair, marginType,
				slabRangeFrom, slabRangeTo, bankSellingMargin, bankBuyingMargin);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Product Status on Product Master tab : " + toastMessage);
		cs.takeScreenshot("Productupdated", report_path, "");
		reusable.holdOn(2);
		dashboardPage.openMyRequest();
		reusable.holdOn(2);
		cardRatePages = new CardRatePages(getDriver(), test);
		String actRequestStatus = cardRatePages.getRequestStatus().getText();
		softAssert.assertEquals(actRequestStatus, expRequestStatus, "Actual Request Status : " + actRequestStatus
				+ " and Expected Request Status : " + expRequestStatus + " are not matched");
		cs.takeScreenshot("ProductStatus", report_path, "");
		reusable.holdOn(1);
		reusable.logOut();

		verifyLoginPage = reusable.VerifyLoginPage();
		softAssert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "Checker navigated on Login Page successfully");
		loginPage.loginApplication(checkerId, password);

		dashboardPage.clickHamburgerBtn();
		reusable.holdOn(1);
		dashboardPage.hoverCardRateMaster();
		reusable.holdOn(1);
		cardRateMasterPages.acceptOrRejectProductInProductMaster(marketType, comment, acceptOrReject);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Product Status on Product Master tab : " + toastMessage);
		cs.takeScreenshot("ProductApproved/Rejected", report_path, "");
		softAssert.assertAll();
		reusable.holdOn(2);
		reusable.logOut();
		reusable.holdOn(1);
	}
}
