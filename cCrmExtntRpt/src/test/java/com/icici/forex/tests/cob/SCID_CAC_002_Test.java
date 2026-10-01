package com.icici.forex.tests.cob;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.icici.forex.pages.AccountDetailsPage;
import com.icici.forex.pages.CommonReusableMethods;
import com.icici.forex.pages.CorporateUsersPage;
import com.icici.forex.pages.CurrencyPairPage;
import com.icici.forex.utils.BaseAbstractTest;
import com.icici.forex.utils.CaptureScreenShotPage;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;

public class SCID_CAC_002_Test extends BaseAbstractTest {
	/**
	 * #Customer onboarding Acceptance Criteria
	 * 
	 * @Scenario_Description : If customer drop in the middle of the journey and
	 *                       when he returns he should be navigated to the page
	 *                       where he dropped
	 */

	private CommonReusableMethods reusable;
	private AccountDetailsPage accDetailsPage;
	private CurrencyPairPage currencyPairsPage;
	private CorporateUsersPage corpUsersPage;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider", priority = 1)
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "COB_TestData", executeColumn = "TUID", executeValue = "SCID_CAC_002", dsUid = "TUID")
	public void checkDataSavedIfDroppedInMiddleOfFlow(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = report_path + "SCID_CAC_002_Test";
		String toastMessage;
		String verifyAccDetailsPageByText = "Please provide below details";
		String accountNo = String.valueOf(args.get("Account Number"));
		String yesOrNo = String.valueOf(args.get("GST Applicable"));
		String yesLeaveThePage = "Yes";
		String selectGSTNo = String.valueOf(args.get("Select GST Number"));
		String GSTStatus = String.valueOf(args.get("GST Status"));
		String contactPersonName = String.valueOf(args.get("Contact Person Name"));
		String otherContactPersonName = String.valueOf(args.get("Other Contact Person Name"));
		String commAddress = String.valueOf(args.get("Communication Address"));
		String pinCode = String.valueOf(args.get("Pin Code"));
		String verifyCurrencyPairPage = "Please select Currency Pair";
		String currencyPair = String.valueOf(args.get("Currency Pairs"));
		String stubLink = String.valueOf(args.get("Stub Link"));

		/// Customer Journey
		test.log(Status.INFO, "Customer Journey is started...");
		getDriver().navigate().to(stubLink);
		reusable = new CommonReusableMethods(getDriver(), test);
		reusable.holdOn(2);
		String verifyAccDetailsPage = reusable.verifyAccountDetailsPage();
		Assert.assertEquals(verifyAccDetailsPageByText, verifyAccDetailsPage,
				"User is unable to navigate on Account Details Page");
		test.log(Status.INFO, "User navigated on Account Details Page successfully");
		accDetailsPage = new AccountDetailsPage(getDriver(), test);
		accDetailsPage.selectAccountNo(accountNo);
		accDetailsPage.selectContactPerson(contactPersonName, otherContactPersonName);
		accDetailsPage.addNewAddress(commAddress, pinCode);
		reusable.holdOn(1);
		accDetailsPage.provideGSTDetails(yesOrNo, selectGSTNo, "", GSTStatus);
		reusable.saveAndContinue();
		accDetailsPage.acceptDeclaration();
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Account Details Page : " + toastMessage);

		String txtCurrencyPairsPage = reusable.VerifyCurrencyPairPage();
		Assert.assertEquals(verifyCurrencyPairPage, txtCurrencyPairsPage,
				"User is unable to navigate on Currency Pairs Page");
		test.log(Status.INFO, "User navigated on Currency Pairs Page successfully");
		currencyPairsPage = new CurrencyPairPage(getDriver(), test);
		currencyPairsPage.selectCurrencyPair(currencyPair);
		reusable.saveAndContinue();
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Currency Pair Page : " + toastMessage);

		corpUsersPage = new CorporateUsersPage(getDriver(), test);
		corpUsersPage.selectAccessCorpUsers();

		reusable.holdOn(2);
		reusable.logOut();
		test.log(Status.INFO, "Customer dropped journey from Curency Pair Page");
		reusable.holdOn(2);
		getDriver().navigate().to(stubLink);
		reusable.holdOn(2);
		verifyAccDetailsPage = reusable.verifyAccountDetailsPage();
		Assert.assertEquals(verifyAccDetailsPageByText, verifyAccDetailsPage,
				"User is unable to navigate on Account Details Page");
		test.log(Status.INFO, "User navigated on Account Details Page successfully");
		accDetailsPage = new AccountDetailsPage(getDriver(), test);
		accDetailsPage.selectAccountNo(accountNo);
		reusable.holdOn(12);
		reusable.getBtnSaveAndContinue().scrollTo();
		reusable.holdOn(2);
		currencyPairsPage.getHeaderCurrencyPair().scrollTo();
		reusable.holdOn(2);
		currencyPairsPage.openCurrencyPairPageByTab();
		reusable.consentForLeaveThePage(yesLeaveThePage);
		reusable.holdOn(2);
		try {
			String selectedCurrencyPair = currencyPairsPage.getSelectedCurrencyPair().getAttribute("title");
			if (selectedCurrencyPair.equalsIgnoreCase(currencyPair)) {
				test.log(Status.PASS,
						"Passed, Selected Currency Pair : " + selectedCurrencyPair + " and Expected Currency Pair : "
								+ currencyPair
								+ " are matched means customer Data is saved when he dropped the journey");
			} else {
				test.log(Status.FAIL,
						"Failed, Selected Currency Pair : " + selectedCurrencyPair + " and Expected Currency Pair : "
								+ currencyPair
								+ " are mismatched means Customer Data is not saved when he dropped the journey.");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Customer Data is not saved when dropped journey in the middle");
			e.getStackTrace();
		}

		reusable.holdOn(2);
		reusable.logOut();
		reusable.holdOn(1);
	}
}
