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
import com.icici.forex.utils.CaptureScreenShotPage;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;

@Ignore
public class SCID_GP002_GP005_GP007_GP008_GP009_GP010_Test extends BaseAbstractTest {

	/**
	 * @Scenario_Description: To check maker/Checker allowed functionality for
	 *                        global parameters
	 * 
	 */

	private DashboardPage dashboardPage;
	private CommonReusableMethods reusable;
	private CardRateMasterPages cardRateMasterPages;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "CardRate_TestData", executeColumn = "TUID", executeValue = "SCID_GP002_GP005_GP007_GP008_GP009_GP010", dsUid = "TUID")
	public void addGlobalParameters(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = "Snapshots/SCID_GP002_GP005_GP007_GP008_GP009_GP010_Test";
		String toastMessage, verifyLoginPage;
		String verifyLoginPageByText = "Please Login to Continue";
		String makerId = String.valueOf(args.get("Maker_UserId"));
		String password = String.valueOf(args.get("Password"));
		String makerCheckerScenario = String.valueOf(args.get("Maker/Checker Scenario"));
		String rateRefreshOnBasisOfThreshold = String.valueOf(args.get("Rate Refresh on Basis of Threshold"));
		String DoNotSubtractFromIBRRates = String.valueOf(args.get("Do not Subtract C/S' from IBR Rates"));
		String marginMultiFactor = String.valueOf(args.get("Margin Multiplication Factor"));
		String productNameFromPDMaster = String.valueOf(args.get("Product Name"));
		String buyRate = String.valueOf(args.get("Buy (USD Equivalent)"));
		String sellRate = String.valueOf(args.get("Sell (USD Equivalent)"));
		String IBRRatesModifiedManuallyDomestic = String.valueOf(args.get("IBR Rates Modified Manually Domestic"));
		String currencyPairManuallyDomestic = String.valueOf(args.get("Currency Pair Manually Domestic"));
		String IBRRatesLockedPolicyDomestic = String.valueOf(args.get("IBR Rates locked as per policy domestic"));
		String currencyPairLockedPolicyDomestic = String.valueOf(args.get("Currency Pair Locked Policy Domestic"));
		String IBRRatesModifiedManuallyIBG = String.valueOf(args.get("IBR Rates Modified Manually IBG"));
		String currencyPairManuallyIBG = String.valueOf(args.get("Currency Pair Manually IBG"));
		String IBRRatesLockedPolicyIBG = String.valueOf(args.get("IBR Rates locked as per policy IBG"));
		String currencyPairLockedPolicyIBG = String.valueOf(args.get("Currency Pair Locked Policy IBG"));

		test.log(Status.INFO, "Card Rate Maker journey is started");
		reusable = new CommonReusableMethods(getDriver(), test);
		verifyLoginPage = reusable.VerifyLoginPage();
		SoftAssert softAssert =new SoftAssert();
		softAssert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "Maker navigated on Login Page successfully");
		loginPage.loginApplication(makerId, password);
		test.log(Status.INFO, "Card Rate Maker logged in successfully");

		dashboardPage = new DashboardPage(getDriver(), test);
		dashboardPage.clickHamburgerBtn();
		reusable.holdOn(1);
		dashboardPage.hoverCardRateMaster();
		cardRateMasterPages = new CardRateMasterPages(getDriver(), test);
		cardRateMasterPages.addGlobalParameters(makerCheckerScenario, rateRefreshOnBasisOfThreshold,
				DoNotSubtractFromIBRRates, marginMultiFactor, IBRRatesModifiedManuallyDomestic,
				currencyPairManuallyDomestic, IBRRatesLockedPolicyDomestic, currencyPairLockedPolicyDomestic,
				IBRRatesModifiedManuallyIBG, currencyPairManuallyIBG, IBRRatesLockedPolicyIBG,
				currencyPairLockedPolicyIBG, productNameFromPDMaster, buyRate, sellRate);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Global Parameters Page : " + toastMessage);
		cs.takeScreenshot("GlobalParametersUpdated", report_path, "");
		softAssert.assertAll();
		reusable.holdOn(2);
		reusable.logOut();
		reusable.holdOn(1);
	}

}
