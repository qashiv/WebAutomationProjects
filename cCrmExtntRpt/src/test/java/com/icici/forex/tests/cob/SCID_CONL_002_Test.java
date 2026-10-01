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

public class SCID_CONL_002_Test extends BaseAbstractTest {

	/**
	 * @Scenario_Description -- Pre approved Customer intiates the online CTS
	 *                       onboading request with valid details where user updates
	 *                       the personal and business details (No change in
	 *                       LEI,GST,New address) and submit the request ,the
	 *                       request should go for SM/TSSG approval (Murex id-Yes
	 *                       .Magin-Yes) #Done
	 */
	private DashboardPage dashboardPage;
	private CobConfigurationPage cobConfigPage;
	private AccountDetailsPage accDetailsPage;
	private CurrencyPairPage currencyPairPage;
	private AdditionalFeaturesPage addFeaturesPage;
	private CorporateUsersPage corpUsersPage;
	private ReviewAndSubmitPage reviewAndSubmit;
	private CounterpartyMasterPage cpMasterPage;
	private CommonReusableMethods reusable;
	private OthersPage othersPage;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "COB_TestData", executeColumn = "TUID", executeValue = "SCID_CONL_002", dsUid = "TUID")
	public void preApprovedCustomerOnboarding_E2E(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = report_path + "SCID_CONL_002_Test";
		String toastMessage, requestId, verifyDashboardPage;
		String tssgMakerUserId = String.valueOf(args.get("TSSG_MakerUserID"));
		String tssgPassword = String.valueOf(args.get("TSSG_Password"));
		String verifyDashboardPageByText = "Dashboard";
		String verifyAccDetailsPageByText = "Please provide below details";
		String verifyLoginPageByText = "Please Login to Continue";
		String onboardingType = String.valueOf(args.get("Type Of Onboarding"));
		String accountNo = String.valueOf(args.get("Account Number"));
		String yesOrNo = String.valueOf(args.get("GST Applicable"));
		String selectGSTNo = String.valueOf(args.get("Select GST Number"));
		String otherGSTNo = String.valueOf(args.get("Input GST Number"));
		String GSTStatus = String.valueOf(args.get("GST Status"));
		String docsPath = String.valueOf(args.get("Document Path"));

		String contactPersonName = String.valueOf(args.get("Contact Person Name"));
		String otherContactPersonName = String.valueOf(args.get("Other Contact Person Name"));
		String verifyCorpUsersPageTxt = "Please select the Corporate Users from the below list";
		String selectCategory = String.valueOf(args.get("Category"));
		String selectSubCategory = String.valueOf(args.get("Sub Category"));
		String serviceOffered = String.valueOf(args.get("Services Offered"));
		String pricingType = String.valueOf(args.get("Pricing Type"));
		String currencyPair = String.valueOf(args.get("Currency Pairs"));
		String testDoc = String.valueOf(args.get("Test Document Path"));
		String tssgCheckerId = String.valueOf(args.get("TSSG_CheckerUserID"));
		String tssgChecker2 = String.valueOf(args.get("TSSG_Checker2UserID"));
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

//		requestId = "OFL000430533";
	///// TSSG Journey
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
		reusable.holdOn(1);

		test.log(Status.INFO, "Cob Configuration expanded successfully");
		cobConfigPage = new CobConfigurationPage(getDriver(), test);
		cobConfigPage.uploadPreApproveCustomerDetails(docsPath);
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Pre Approve Customer on Cob Configuration : " + toastMessage);

		reusable.holdOn(1);
		dashboardPage.clickDashboardTab();
		test.log(Status.INFO, "User dashboard opened successfully");
		dashboardPage.createNewRequest(onboardingType);
		test.log(Status.INFO, "User started to Create New Request");

		String verifyAccDetailsPage = reusable.verifyAccountDetailsPage();
		Assert.assertEquals(verifyAccDetailsPageByText, verifyAccDetailsPage,
				"User is unable to navigate on Account Details Page");
		test.log(Status.INFO, "User navigated on Account Details Page successfully");
		accDetailsPage = new AccountDetailsPage(getDriver(), test);
		accDetailsPage.provideNewAccountDetails(accountNo);
		reusable.holdOn(2);
		accDetailsPage.selectContactPerson(contactPersonName, otherContactPersonName);
		accDetailsPage.provideGSTDetails(yesOrNo, selectGSTNo, otherGSTNo, GSTStatus);
		accDetailsPage.selectOnlineForwardServices(testDoc);
		reusable.saveAndContinue();
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Account Details Page : " + toastMessage);

		currencyPairPage = new CurrencyPairPage(getDriver(), test);
		currencyPairPage.selectCurrencyPairDetails(selectCategory, selectSubCategory, serviceOffered, pricingType);
		currencyPairPage.selectCurrencyPair(currencyPair);
		reusable.saveAndContinue();
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Currency Pair Page : " + toastMessage);

		String verifyCorpUsersPage = reusable.verifyCorporateUsersPage();
		Assert.assertEquals(verifyCorpUsersPageTxt, verifyCorpUsersPage,
				"User is unable to navigate on Corporate Users Page");
		test.log(Status.INFO, "User navigated on Corporate Users Page");
		corpUsersPage = new CorporateUsersPage(getDriver(), test);
		reusable.holdOn(2);
		corpUsersPage.selectAccessCorpUsers();
		test.log(Status.INFO, "Corporate Users acccessibility selected successfully");

		reviewAndSubmit = new ReviewAndSubmitPage(getDriver(), test);
		reviewAndSubmit.openReviewSubmitPageByTab();
		test.log(Status.INFO, "User is navigated to Review And Submit Page");
		reviewAndSubmit.reviewAndSubmit(testDoc);
		cs.takeScreenshot("PreApproveCustomerSubmit", report_path, "");
		requestId = reviewAndSubmit.getRequestIdFromToastMessage();
		test.log(Status.INFO, "User review and submitted successfully");
		reusable.logOut();

		///// TSSG Maker Journey
		test.log(Status.INFO, "TSSG Maker Journey started and now, user is on Login Page");
		loginPage.loginApplication(tssgCheckerId, tssgPassword);
		test.log(Status.INFO, "TSSG Maker User logged in successfully by Valid Credential");

		verifyDashboardPage = reusable.VerifyDashboardPage();
		Assert.assertEquals(verifyDashboardPageByText, verifyDashboardPage,
				"User is unable to navigate on Dashboard Page");
		test.log(Status.INFO, "User navigated on Dashboard Page successfully");
		dashboardPage.searchByRequestIDAndOpen(requestId);
		reusable.holdOn(1);
		cpMasterPage = new CounterpartyMasterPage(getDriver(), test);
		cpMasterPage.openCPMasterPageByTab();
		reusable.holdOn(1);
		currencyPairPage.openCurrencyPairPageByTab();
		reusable.holdOn(1);
		addFeaturesPage = new AdditionalFeaturesPage(getDriver(), test);
		addFeaturesPage.openAddFeaturesPageByTab();
		reusable.holdOn(1);
		corpUsersPage.openCorpUserMasterPageByTab();
		test.log(Status.INFO, "User navigated on Corporate User Master page successfully");
		corpUsersPage.addNewAuthorisedUser(authUsers, otherUserId, userName, email);
		othersPage = new OthersPage(getDriver(), test);
		othersPage.openOthersPageByTab();
		test.log(Status.INFO, "User is navigated on Others Page");
		othersPage.personalDetails(officeAdd, iciciBranch, listOfCountries, cpClassification, cpStatus, crossDefClause,
				exportDefClause, networth, dateOfNetworth, sourceOfNetworth, turnover, listingDetails, noOfAcceptance,
				marginRights, riskPolicy, vRMscript, clientType, sME, internalRating, externalRating, typeOfSecurity,
				docDetails, selectDoc, ISDADetails, FCADetails, testDoc, docSignedBy, location, docStatus, docAwaited,
				commonSeal, safeCustodyMemoNo);

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
		loginPage.loginApplication(tssgChecker2, tssgPassword);
		test.log(Status.INFO, "TSSG Checker User logged in successfully by Valid Credential");

		verifyDashboardPage = reusable.VerifyDashboardPage();
		Assert.assertEquals(verifyDashboardPageByText, verifyDashboardPage,
				"User is unable to navigate on Dashboard Page");
		test.log(Status.INFO, "User navigated on Dashboard Page successfully");
		dashboardPage.approvePendingRequestByChecker(requestId, testDoc, remark, apvrComment);
		reusable.holdOn(1);
		cs.takeScreenshot("TSSGCheckerAccepted", report_path, "");
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Others Page : " + toastMessage);
		test.log(Status.INFO, "TSSG Checker Journey Completed");
		reusable.holdOn(1);
		reusable.logOut();
		reusable.holdOn(1);
	}
}
