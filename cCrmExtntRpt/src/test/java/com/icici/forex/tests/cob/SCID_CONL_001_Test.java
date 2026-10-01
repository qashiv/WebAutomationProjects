package com.icici.forex.tests.cob;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.icici.forex.pages.AccountDetailsPage;
import com.icici.forex.pages.AdditionalFeaturesPage;
import com.icici.forex.pages.CobConfigurationPage;
import com.icici.forex.pages.CommonReusableMethods;
import com.icici.forex.pages.CorporateUsersPage;
import com.icici.forex.pages.CounterpartyMasterPage;
import com.icici.forex.pages.CurrencyPairPage;
import com.icici.forex.pages.DashboardPage;
import com.icici.forex.pages.OthersPage;
import com.icici.forex.pages.ReviewAndSubmitPage;
import com.icici.forex.utils.BaseAbstractTest;
import com.icici.forex.utils.CaptureScreenShotPage;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;

public class SCID_CONL_001_Test extends BaseAbstractTest {

	/**
	 * @Scenario_Description -- Pre approved Customer initiates the online CTS
	 *                       onboarding request without changing any details(Murex
	 *                       id-Yes ,Margin-Yes)
	 */

	private DashboardPage dashboardPage;
	private CobConfigurationPage cobConfigPage;
	private AccountDetailsPage accDetailsPage;
	private CurrencyPairPage currencyPairPage;
	private AdditionalFeaturesPage addFeaturesPage;
	private CorporateUsersPage corpUsersPage;
	private ReviewAndSubmitPage reviewAndSubmit;
	private CommonReusableMethods reusable;
	private CounterpartyMasterPage cpMasterPage;
	private OthersPage othersPage;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "COB_TestData", executeColumn = "TUID", executeValue = "SCID_CONL_001", dsUid = "TUID")
	public void preApprovedCustomerOnboarding_E2E(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = report_path + "Snapshot_CONL001";
		String verifyDashboardPage, toastMessage, requestId;
		String verifyLoginPageByText = "Please Login to Continue";
		String tssgMakerUserId = String.valueOf(args.get("TSSG_MakerUserID"));
		String tssgCheckerId1 = String.valueOf(args.get("TSSG_CheckerUserID"));
		String tssgPassword = String.valueOf(args.get("TSSG_Password"));
		String verifyDashboardPageByText = "Dashboard";
		String verifyAccDetailsPageByText = "Please provide below details";
		String accountNo = String.valueOf(args.get("Account Number"));
		String yesOrNo = String.valueOf(args.get("GST Applicable"));
		String selectGSTNo = String.valueOf(args.get("Select GST Number"));
		String GSTStatus = String.valueOf(args.get("GST Status"));
		String docsPath = String.valueOf(args.get("Document Path"));
		String testDocPath = String.valueOf(args.get("Test Document Path"));
		String commAddress = String.valueOf(args.get("Communication Address"));
		String pinCode = String.valueOf(args.get("Pin Code"));
		String contactPersonName = String.valueOf(args.get("Contact Person Name"));
		String otherContactPersonName = String.valueOf(args.get("Other Contact Person Name"));
		String verifyCurrencyPairPage = "Please select Currency Pair";
		String currencyPair = String.valueOf(args.get("Currency Pairs"));
		String verifyCorpUserPageByText = "Please select the Corporate Users from the below list";
		String stubLink = String.valueOf(args.get("Stub Link"));
		String dailyLimit = String.valueOf(args.get("Daily Limit (in USD)"));
		String transLimit = String.valueOf(args.get("Transaction Limit (in USD)"));
		String traderLimit = String.valueOf(args.get("Trader Limit (in USD)"));
		String selectChannel = String.valueOf(args.get("Channel"));
		String authUsers = String.valueOf(args.get("Authorised Users"));
		String otherUserId = String.valueOf(args.get("Other UserId"));
		String userName = String.valueOf(args.get("User Name"));
		String email = String.valueOf(args.get("Email"));
		String officeAdd = String.valueOf(args.get("Registered Office Address"));
		String iciciBranch = String.valueOf(args.get("ICICI Bank"));
		String listOfCountries = String.valueOf(args.get("List of Countries"));
		String cpClassification = String.valueOf(args.get("Counterparty Classification"));
		String cpStatus = String.valueOf(args.get("Counterparty Status"));
		String crossDefClause = String.valueOf(args.get("Cross Default Clause"));
		String exportDefClause = String.valueOf(args.get("Export Default Clause"));
		String networth = String.valueOf(args.get("Networth (Amt in Rs million)"));
		String dateOfNetworth = String.valueOf(args.get("Date of Networth"));
		String sourceOfNetworth = String.valueOf(args.get("Source of Networth"));
		String turnover = String.valueOf(args.get("Turnover (Amt in Rs million)"));
		String listingDetails = String.valueOf(args.get("Listing Details"));
		String noOfAcceptance = String.valueOf(args.get("No of Acceptance"));
		String marginRights = String.valueOf(args.get("Margin Rights"));
		String riskPolicy = String.valueOf(args.get("Risk Management Policy"));
		String vRMscript = String.valueOf(args.get("VRM Script"));
		String clientType = String.valueOf(args.get("Client Type"));
		String sME = String.valueOf(args.get("SME as per RBI Definition"));
		String internalRating = String.valueOf(args.get("Internal Rating"));
		String externalRating = String.valueOf(args.get("External Rating"));
		String typeOfSecurity = String.valueOf(args.get("Type of Security"));
		String docDetails = String.valueOf(args.get("Document Details"));
		String selectDoc = String.valueOf(args.get("Select Document"));
		String ISDADetails = String.valueOf(args.get("isISDARequired"));
		String FCADetails = String.valueOf(args.get("isFCARequired"));
		String docSignedBy = String.valueOf(args.get("Document Signed By"));
		String location = String.valueOf(args.get("Location"));
		String docStatus = String.valueOf(args.get("Status of Docs"));
		String docAwaited = String.valueOf(args.get("Document Awaited"));
		String commonSeal = String.valueOf(args.get("Common Seal"));
		String safeCustodyMemoNo = String.valueOf(args.get("Safe Custody Memo No"));

		String limitOfAuth = String.valueOf(args.get("Limit of Authorisation"));
		String authLevel = String.valueOf(args.get("Authorisation Level"));
		String typeOfAuthority = String.valueOf(args.get("Type of Authority"));
		String typeOfAuthorisation = String.valueOf(args.get("Type of Authorisation"));
		String group = String.valueOf(args.get("Group"));
		String modeOfOperation = String.valueOf(args.get("Mode of Operation"));
		String meetingDate = String.valueOf(args.get("Meeting date as per BR"));
		String GSTNum = String.valueOf(args.get("GST Number"));
		String GSTAddress = String.valueOf(args.get("GST Address"));
		String multiGSTNo = String.valueOf(args.get("Multiple GST number required"));
		String description = String.valueOf(args.get("Description"));
		String reasonForBlocking = String.valueOf(args.get("Reason for blocking"));
		String inputReason = String.valueOf(args.get("Input Reason"));
		String docStorageLocation = String.valueOf(args.get("Document Storage Location"));
		String docSerialNo = String.valueOf(args.get("Document Serial No"));
		String passportNo = String.valueOf(args.get("Passport Number/NRIC Card"));
		String freeTexts = String.valueOf(args.get("Free Texts"));
		String remark = String.valueOf(args.get("Comments on Currency Pair"));
		String apvrComment = String.valueOf(args.get("TL/ZH/GH/TSSG Checker Comments"));

//		requestId = "PRP000473375";
	//// TSSG Maker Journey
		test.log(Status.INFO, "TSSG journey started and now user is on Login Page");
		reusable = new CommonReusableMethods(getDriver(), test);
		String verifyLoginPage = reusable.VerifyLoginPage();
		Assert.assertEquals(verifyLoginPageByText, verifyLoginPage);
		test.log(Status.INFO, "User navigated on Login Page successfully");
		loginPage.loginApplication(tssgMakerUserId, tssgPassword);
		test.log(Status.INFO, "User logged in successfully by Valid Credential");

		verifyDashboardPage = reusable.VerifyDashboardPage();
		Assert.assertEquals(verifyDashboardPageByText, verifyDashboardPage,
				"User is unable to navigate on Dashboard Page");
		test.log(Status.INFO, "User navigated on Dashboard Page successfully");
		dashboardPage = new DashboardPage(getDriver(), test);
		dashboardPage.clickHamburgerBtn();
		dashboardPage.hoverCobConfiguration();
		test.log(Status.INFO, "Cob Configuration expanded successfully");
		cobConfigPage = new CobConfigurationPage(getDriver(), test);
		cobConfigPage.uploadPreApproveCustomerDetails(docsPath);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Pre Approve Customer on Cob Configuration : " + toastMessage);

		/// Customer Journey
		reusable.holdOn(1);
		getDriver().navigate().to(stubLink);
		reusable.holdOn(3);
		String verifyAccDetailsPage = reusable.verifyAccountDetailsPage();
		Assert.assertEquals(verifyAccDetailsPageByText, verifyAccDetailsPage,
				"User is unable to navigate on Account Details Page");
		test.log(Status.INFO, "User navigated on Account Details Page successfully");
		accDetailsPage = new AccountDetailsPage(getDriver(), test);
		accDetailsPage.selectAccountNo(accountNo);
		reusable.holdOn(2);
		accDetailsPage.selectContactPerson(contactPersonName, otherContactPersonName);
		accDetailsPage.addNewAddress(commAddress, pinCode);
		reusable.holdOn(2);
		accDetailsPage.provideGSTDetails(yesOrNo, selectGSTNo, "", GSTStatus);
		reusable.saveAndContinue();
		accDetailsPage.acceptDeclaration();
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Account Details Page : " + toastMessage);

		String txtCurrencyPairsPage = reusable.VerifyCurrencyPairPage();
		Assert.assertEquals(verifyCurrencyPairPage, txtCurrencyPairsPage,
				"User is unable to navigate on Currency Pairs Page");
		test.log(Status.INFO, "User navigated on Currency Pairs Page successfully");
		currencyPairPage = new CurrencyPairPage(getDriver(), test);
		currencyPairPage.selectCurrencyPair(currencyPair);
		reusable.saveAndContinue();
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Currency Pair Page : " + toastMessage);

		String verifyCorpUserPage = reusable.verifyCorporateUsersPage();
		Assert.assertEquals(verifyCorpUserPageByText, verifyCorpUserPage, "Unable to navigate on Corporate Users Page");
		test.log(Status.INFO, "User navigated on Corporate Users Page successfully");
		corpUsersPage = new CorporateUsersPage(getDriver(), test);
		corpUsersPage.selectAccessCorpUsers();
		reusable.holdOn(2);
		reviewAndSubmit = new ReviewAndSubmitPage(getDriver(), test);
		reviewAndSubmit.openReviewSubmitPageByTab();
		test.log(Status.INFO, "User is navigated on Review And Submit Page");
		reviewAndSubmit.checkDisclaimerAndSubmit();
		reusable.holdOn(1);
		cs.takeScreenshot("PreApproveCustomerSubmit", report_path, "");
		requestId = reusable.takeRequestIdByCIBSubmitted();
		reusable.holdOn(2);
		reusable.logOut();
		test.log(Status.INFO, "Customer journey completed successfully");

		//// TSSG Journey
		test.log(Status.INFO, "TSSG Journey started and now, user is on Login Page");
		loginPage.loginApplication(tssgMakerUserId, tssgPassword);
		dashboardPage.searchByRequestIDAndOpen(requestId);
		accDetailsPage.refreshByIcon();
		accDetailsPage.uploadAndVerifyByAPI(testDocPath);
		reusable.holdOn(2);

		test.log(Status.INFO, "User navigated on Cunterparty Master Page");
		cpMasterPage = new CounterpartyMasterPage(getDriver(), test);
		cpMasterPage.setLimitAndContinue(dailyLimit, transLimit, traderLimit, selectChannel);
		test.log(Status.INFO, "User set daily, transaction and trader limit");
		addFeaturesPage = new AdditionalFeaturesPage(getDriver(), test);
		addFeaturesPage.openAddFeaturesPageByTab();
		test.log(Status.INFO, "User navigated on Additional Features Page");

		reusable.holdOn(2);
		corpUsersPage.openCorpUserMasterPageByTab();
		test.log(Status.INFO, "User navigated on Corporate User Master page successfully");
		corpUsersPage.addNewAuthorisedUser(authUsers, otherUserId, userName, email);
		othersPage = new OthersPage(getDriver(), test);
		othersPage.openOthersPageByTab();
		test.log(Status.INFO, "User is navigated on Others Page");
		othersPage.personalDetails(officeAdd, iciciBranch, listOfCountries, cpClassification, cpStatus, crossDefClause,
				exportDefClause, networth, dateOfNetworth, sourceOfNetworth, turnover, listingDetails, noOfAcceptance,
				marginRights, riskPolicy, vRMscript, clientType, sME, internalRating, externalRating, typeOfSecurity,
				docDetails, selectDoc, ISDADetails, FCADetails, testDocPath, docSignedBy, location, docStatus,
				docAwaited, commonSeal, safeCustodyMemoNo);

		othersPage.userDetails(limitOfAuth, authLevel, typeOfAuthority, typeOfAuthorisation, group, modeOfOperation,
				meetingDate, GSTNum, GSTAddress, multiGSTNo, description, reasonForBlocking, inputReason,
				docStorageLocation, docSerialNo, passportNo, freeTexts);
		othersPage.submit();
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Others Page : " + toastMessage);
		cs.takeScreenshot("TSSGMakerSubmitted", report_path, "");
		reusable.holdOn(2);
		reusable.logOut();
		test.log(Status.INFO, "TSSG maker journy has been completed and  Request Id '" + requestId
				+ "' assigned to TSSG Checker successfully");
		reusable.holdOn(2);

		//// TSSG Checker Journey

		test.log(Status.INFO, "TSSG Checker Journey started and now, user is on Login Page");
		loginPage.loginApplication(tssgCheckerId1, tssgPassword);
		test.log(Status.INFO, "TSSG Checker User logged in successfully by Valid Credential");

		verifyDashboardPage = reusable.VerifyDashboardPage();
		Assert.assertEquals(verifyDashboardPageByText, verifyDashboardPage,
				"User is unable to navigate on Dashboard Page");
		test.log(Status.INFO, "User navigated on Dashboard Page successfully");
		dashboardPage = new DashboardPage(getDriver(), test);
		dashboardPage.approvePendingRequestByChecker(requestId, testDocPath, remark, apvrComment);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		cs.takeScreenshot("TSSGCheckerAccepted", report_path, "");
		test.log(Status.INFO, "Others Page : " + toastMessage);
		test.log(Status.INFO, "TSSG Checker Journey Completed");
		reusable.logOut();
		reusable.holdOn(1);
	}
}
