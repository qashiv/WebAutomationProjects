package com.icici.forex.tests.cardrate;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.icici.forex.pages.CardRateMasterPages;
import com.icici.forex.pages.CardRateReportsPages;
import com.icici.forex.pages.CommonReusableMethods;
import com.icici.forex.pages.DashboardPage;
import com.icici.forex.utils.BaseAbstractTest;
import com.icici.forex.utils.CaptureScreenShotPage;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;

public class SCID_CRPR_001_Test extends BaseAbstractTest {
	/**
	 * @Scenario_Description: Update the product master for domestic to publish the
	 *                        card rate for the selective product
	 */

	private DashboardPage dashboardPage;
	private CommonReusableMethods reusable;
	private CardRateMasterPages cardRateMasterPages;
	private CardRateReportsPages cardRateReportsPages;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "CardRate_TestData", executeColumn = "TUID", executeValue = "SCID_CRPR_001", dsUid = "TUID")
	public void updateProductAndCheckOutputFile(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = "Snapshots/SCID_CRPR_001_Test";
		String toastMessage, verifyLoginPage;
		String verifyLoginPageByText = "Please Login to Continue";
		String makerId = String.valueOf(args.get("Maker_UserId"));
		String password = String.valueOf(args.get("Password"));
		String marketType = String.valueOf(args.get("Market Type"));
		String productName = String.valueOf(args.get("Product Or Geography"));
		String marginCurrencyPair = String.valueOf(args.get("Currency Pair"));
		String marginType = String.valueOf(args.get("Margin Type"));
		String marginSlab = String.valueOf(args.get("Margin Slabs"));
		String slabRangeFrom = String.valueOf(args.get("Slab Range From"));
		String slabRangeTo = String.valueOf(args.get("Slab Range To"));
		String bankSellingMargin = String.valueOf(args.get("Bank Selling Margin"));
		String bankBuyingMargin = String.valueOf(args.get("Bank Buying Margin"));
		String checkerId = String.valueOf(args.get("Checker_UserId"));
		String remarks = String.valueOf(args.get("Comments"));
		String acceptOrReject = String.valueOf(args.get("Approve Or Reject"));

		test.log(Status.INFO, "Card Rate Maker journey is started");
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
		cs.takeScreenshot("ProductUpdated", report_path, "");
		reusable.logOut();
		test.log(Status.INFO, "Product updated and requested for approval successfully");

		loginPage.loginApplication(checkerId, password);
		reusable.holdOn(1);
		dashboardPage.clickHamburgerBtn();
		dashboardPage.hoverCardRateMaster();
		cardRateMasterPages.acceptOrRejectProductInProductMaster(marketType, remarks, acceptOrReject);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Product on Product Master Page : " + toastMessage);

		dashboardPage.clickHamburgerBtn();
		dashboardPage.hoverCardRateReports();
		cardRateReportsPages = new CardRateReportsPages(getDriver(), test);
		String prodName = cardRateReportsPages.checkPublishedReportFromOutputFiles(marketType, productName);
		Assert.assertEquals(prodName, productName,"Product '"+ productName+"' has not found on Output files Page");
		cs.takeScreenshot("PublishedReport", report_path, "");
		test.log(Status.INFO, "Published report checked from Output Files");
		softAssert.assertAll();
		reusable.holdOn(2);
		reusable.logOut();
		reusable.holdOn(1);
	}
}
