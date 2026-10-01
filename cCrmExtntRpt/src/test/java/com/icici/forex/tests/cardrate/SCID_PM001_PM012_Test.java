package com.icici.forex.tests.cardrate;

import java.util.HashMap;
import org.testng.SkipException;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.icici.forex.pages.CardRateMasterPages;
import com.icici.forex.pages.CommonReusableMethods;
import com.icici.forex.pages.DashboardPage;
import com.icici.forex.utils.BaseAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;

@Ignore
public class SCID_PM001_PM012_Test extends BaseAbstractTest {

	/**
	 * @Scenario_Description: Maker adds new product in product master(currency pair
	 *                        with slab and without slab) for domestic market with
	 *                        margin type % ,BPS and PPS and checker approves the
	 *                        product master
	 * 
	 */
	private DashboardPage dashboardPage;
	private CommonReusableMethods reusable;
	private CardRateMasterPages cardRateMasterPages;

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "CardRate_TestData", executeColumn = "TUID", executeValue = "SCID_PM001_PM012", dsUid = "TUID")
	public void makerAddsNewProductinProductMaster(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}

		report_path = "Snapshots/SCID_PM001_PM012_Test";
		String toastMessage, verifyLoginPage;
		String verifyLoginPageByText = "Please Login to Continue";
		String makerId = String.valueOf(args.get("Maker_UserId"));
		String checkerId = String.valueOf(args.get("Checker_UserId"));
		String password = String.valueOf(args.get("Password"));
		String marketType = String.valueOf(args.get("Market Type"));
		String productName = String.valueOf(args.get("Product Or Geography"));
		String INFY_Finacle = String.valueOf(args.get("Channel INFY_Finacle"));
		String remark = String.valueOf(args.get("Remark"));
		String marginSlabs = String.valueOf(args.get("Margin Slabs"));
		String currencyPair = String.valueOf(args.get("Currency Pair"));
		String marginType = String.valueOf(args.get("Margin Type"));
		String bankSellingMargin = String.valueOf(args.get("Bank Selling Margin"));
		String bankBuyingMargin = String.valueOf(args.get("Bank Buying Margin"));
		String slabRangeFrom = String.valueOf(args.get("Slab Range From"));
		String slabRangeTo = String.valueOf(args.get("Slab Range To"));
		String comment = String.valueOf(args.get("Comments"));
		String acceptOrReject = String.valueOf(args.get("Approve Or Reject"));
		String expEnableBtnText = "Enable";

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
		cardRateMasterPages.addProductsInProductMaster(marketType, productName, INFY_Finacle, remark, marginSlabs,
				currencyPair, marginType, bankSellingMargin, bankBuyingMargin, slabRangeFrom, slabRangeTo);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Product Status on Product Master tab : " + toastMessage);
		reusable.holdOn(2);
		reusable.logOut();
		verifyLoginPage = reusable.VerifyLoginPage();
		softAssert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "Maker navigated on Login Page successfully");
		loginPage.loginApplication(checkerId, password);

		dashboardPage.clickHamburgerBtn();
		reusable.holdOn(1);
		dashboardPage.hoverCardRateMaster();
		reusable.holdOn(1);
		cardRateMasterPages.acceptOrRejectProductInProductMaster(marketType, comment, acceptOrReject);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Product Status on Product Master tab : " + toastMessage);
		reusable.holdOn(2);
		reusable.logOut();

		verifyLoginPage = reusable.VerifyLoginPage();
		softAssert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "Maker navigated on Login Page successfully");
		loginPage.loginApplication(makerId, password);
		dashboardPage.clickHamburgerBtn();
		reusable.holdOn(1);
		dashboardPage.hoverCardRateMaster();
		cardRateMasterPages.goToProductMaster();
		reusable.selectMarketType(marketType);
		cardRateMasterPages.verifyEnableStatus();
		String actualEnableBtnText = cardRateMasterPages.verifyEnableStatus();
		softAssert.assertEquals(expEnableBtnText, actualEnableBtnText, "Product Status is not Unable");
		softAssert.assertAll();
		reusable.holdOn(2);
		reusable.logOut();
	}
}
