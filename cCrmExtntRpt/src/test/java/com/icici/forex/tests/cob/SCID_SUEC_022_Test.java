package com.icici.forex.tests.cob;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.icici.forex.pages.AccountDetailsPage;
import com.icici.forex.pages.AdditionalFeaturesPage;
import com.icici.forex.pages.CommonReusableMethods;
import com.icici.forex.pages.CorporateUsersPage;
import com.icici.forex.pages.CounterpartyMasterPage;
import com.icici.forex.pages.CurrencyPairMarginPage;
import com.icici.forex.pages.CurrencyPairPage;
import com.icici.forex.pages.DashboardPage;
import com.icici.forex.pages.OthersPage;
import com.icici.forex.pages.ReviewAndSubmitPage;
import com.icici.forex.utils.BaseAbstractTest;
import com.icici.forex.utils.CaptureScreenShotPage;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;

public class SCID_SUEC_022_Test extends BaseAbstractTest {

	/**
	 * @PreRequisite : Confirm account number is for adhoc customer,, SM can not
	 *               reject so uncheck Online and check oncall services and continue
	 *               to onboard customer.
	 * 
	 * @Scenario_Description : To check on call ad hoc customer request for online
	 *                       journey and SM/TSSG rejects the request as SM/TSSG
	 *                       doesn't want to give him online access.
	 */
	private CommonReusableMethods reusable;
	private AccountDetailsPage accDetailsPage;
	private CurrencyPairPage currencyPairsPage;
	private CurrencyPairMarginPage cpMarginPage;
	private CorporateUsersPage corpUsersPage;
	private ReviewAndSubmitPage reviewAndSubmit;
	private DashboardPage dashboardPage;
	private CounterpartyMasterPage cpMasterPage;
	private AdditionalFeaturesPage addFeaturesPage;
	private OthersPage othersPage;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "COB_TestData", executeColumn = "TUID", executeValue = "SCID_SUEC_022", dsUid = "TUID")
	public void customerInitiatesAndRejectBySM(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = report_path + "SCID_SUEC_022_Test";
		String stubLink = String.valueOf(args.get("Stub Link"));
		String verifyLoginPage, verifyDashboardPage, toastMessage, requestId, txtCurrencyPairsPage, verifyCorpUserPage;
		String verifyLoginPageByText = "Please Login to Continue";
		String verifyDashboardPageByText = "Dashboard";
		String verifyAccDetailsPageByText = "Please provide below details";
		String verifyCPMarginPageByTxt = "Please select Currency Pairs Margin";
		String verifyAddFeaturesPageTxt = "Please select Additional features";
		String accountNo = String.valueOf(args.get("Account Number"));
		String yesOrNo = String.valueOf(args.get("GST Applicable"));
		String selectGSTNo = String.valueOf(args.get("Select GST Number"));
		String GSTStatus = String.valueOf(args.get("GST Status"));
		String docsPath = String.valueOf(args.get("Test Document Path"));
		String commAddress = String.valueOf(args.get("Communication Address"));
		String pinCode = String.valueOf(args.get("Pin Code"));
		String contactPersonName = String.valueOf(args.get("Contact Person Name"));
		String otherContactPersonName = String.valueOf(args.get("Other Contact Person Name"));
		String verifyCurrencyPairPage = "Please select Currency Pair";
		String currencyPair = String.valueOf(args.get("Currency Pairs"));
		String verifyCorpUserPageByText = "Please select the Corporate Users from the below list";
		String tssgMakerUserId = String.valueOf(args.get("TSSG_MakerUserID"));
		String tssgPassword = String.valueOf(args.get("TSSG_Password"));
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
		String tssgCheckerId = String.valueOf(args.get("TSSG_CheckerUserID"));
		String remark = String.valueOf(args.get("Comments on Currency Pair"));
		String comment = String.valueOf(args.get("TL/ZH/GH/TSSG Checker Comments"));
		String smUserId = String.valueOf(args.get("SM_UserID"));
		String smPassword = String.valueOf(args.get("SM_Password"));

//		requestId = "PRP000571620";
		//// Customer Journey
		test.log(Status.INFO, "Customer  journey started by Stub link");
		getDriver().navigate().to(stubLink);
		reusable = new CommonReusableMethods(getDriver(), test);
		reusable.holdOn(1);
		String verifyAccDetailsPage = reusable.verifyAccountDetailsPage();
		Assert.assertEquals(verifyAccDetailsPageByText, verifyAccDetailsPage,
				"User is unable to navigate on Account Details Page");
		test.log(Status.INFO, "User navigated on Account Details Page successfully");
		accDetailsPage = new AccountDetailsPage(getDriver(), test);
		accDetailsPage.selectAccountNo(accountNo);
		accDetailsPage.selectContactPerson(contactPersonName, otherContactPersonName);
		accDetailsPage.addNewAddress(commAddress, pinCode);
		accDetailsPage.provideGSTDetails(yesOrNo, selectGSTNo, "", GSTStatus);
		reusable.saveAndContinue();
		accDetailsPage.acceptDeclaration();
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Account Details Page : " + toastMessage);

		txtCurrencyPairsPage = reusable.VerifyCurrencyPairPage();
		Assert.assertEquals(verifyCurrencyPairPage, txtCurrencyPairsPage,
				"User is unable to navigate on Currency Pairs Page");
		test.log(Status.INFO, "User navigated on Currency Pairs Page successfully");
		currencyPairsPage = new CurrencyPairPage(getDriver(), test);
		currencyPairsPage.selectCurrencyPair(currencyPair);
		reusable.saveAndContinue();
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Currency Pair Page : " + toastMessage);

		verifyCorpUserPage = reusable.verifyCorporateUsersPage();
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
		cs.takeScreenshot("AdhocCustomerSubmit", report_path, "");
		requestId = reusable.takeRequestIdByCIBSubmitted();
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Review And Submit Page : " + toastMessage);
		reusable.holdOn(2);
		reusable.logOut();
		test.log(Status.INFO, "Customer journey completed successfully");

		/// SM Journey

		test.log(Status.INFO, "Now, SM Journey is Started...");
		verifyLoginPage = reusable.VerifyLoginPage();
		Assert.assertEquals(verifyLoginPageByText, verifyLoginPage,
				"Unable to Login please check your userId/Password");
		test.log(Status.INFO, "User navigated on Login Page successfully");
		loginPage.loginApplication(smUserId, smPassword);
		test.log(Status.INFO, "User logged in successfully by Valid Credential");

		verifyDashboardPage = reusable.VerifyDashboardPage();
		Assert.assertEquals(verifyDashboardPageByText, verifyDashboardPage,
				"User is unable to navigate on Dashboard Page");
		test.log(Status.INFO, "User navigated on Dashboard Page successfully");
		dashboardPage = new DashboardPage(getDriver(), test);
		dashboardPage.searchByRequestIDAndOpen(requestId);
		accDetailsPage.openCurencyPairPageByTab();
		txtCurrencyPairsPage = reusable.VerifyCurrencyPairPage();
		Assert.assertEquals(verifyCurrencyPairPage, txtCurrencyPairsPage,
				"User is unable to navigate on Currency Pairs Page");
		test.log(Status.INFO, "User navigated on Currency Pairs Page successfully");

		reusable.holdOn(2);
		cpMarginPage = new CurrencyPairMarginPage(getDriver(), test);
		cpMarginPage.openCPMarginPageByTab();
		String verifyCPMarginPage = reusable.VerifyCurrencyPairsMarginPage();
		Assert.assertEquals(verifyCPMarginPageByTxt, verifyCPMarginPage,
				"User is unable to navigate on Currency Pairs Margin Page");
		test.log(Status.INFO, "User navigated on Currency Pairs Margin Page successfully");

		reusable.holdOn(2);
		addFeaturesPage = new AdditionalFeaturesPage(getDriver(), test);
		addFeaturesPage.openAddFeaturesPageByTab();
		String verifyAddFeaturesPage = reusable.VerifyAdditionalFeaturesPage();
		Assert.assertEquals(verifyAddFeaturesPageTxt, verifyAddFeaturesPage,
				"user is unable to navigate on Additional Features Page");
		test.log(Status.INFO, "User navigated on Additional Features Page");

		reusable.holdOn(2);
		corpUsersPage.openCorpUserMasterPageByTab();
		verifyCorpUserPage = reusable.verifyCorporateUsersPage();
		Assert.assertEquals(verifyCorpUserPageByText, verifyCorpUserPage, "Unable to navigate on Corporate Users Page");
		test.log(Status.INFO, "User navigated on Corporate Users Page successfully");

		reusable.holdOn(2);
		reviewAndSubmit.openReviewSubmitPageByTab();
		reviewAndSubmit.reviewAndSubmit(docsPath);
		reusable.holdOn(1);
		cs.takeScreenshot("SM_Submitted", report_path, "");
		requestId = reviewAndSubmit.getRequestIdFromToastMessage();
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Review And Submit Page : " + toastMessage);
		test.log(Status.INFO, "SM approved successfully");
		reusable.holdOn(2);
		reusable.logOut();

		/// TSSG Journey

		test.log(Status.INFO, "TSSG Maker Journey started and now, user is on Login Page");
		loginPage.loginApplication(tssgMakerUserId, tssgPassword);
		dashboardPage.searchByRequestIDAndOpen(requestId);
		accDetailsPage.refreshByIcon();
		accDetailsPage.uploadAndVerifyByAPI(docsPath);
		test.log(Status.INFO, "User navigated on Cunterparty Master Page");
		cpMasterPage = new CounterpartyMasterPage(getDriver(), test);
		cpMasterPage.setLimitAndContinue(dailyLimit, transLimit, traderLimit, selectChannel);
		test.log(Status.INFO, "User set daily, transaction and trader limit");
		reusable.holdOn(1);
		addFeaturesPage = new AdditionalFeaturesPage(getDriver(), test);
		addFeaturesPage.openAddFeaturesPageByTab();
		test.log(Status.INFO, "User navigated on Additional Features Page");
		reusable.holdOn(1);
		corpUsersPage.openCorpUserMasterPageByTab();
		test.log(Status.INFO, "User navigated on Corporate User Master page successfully");
		corpUsersPage.addNewAuthorisedUser(authUsers, otherUserId, userName, email);
		reusable.holdOn(2);
		othersPage = new OthersPage(getDriver(), test);
		othersPage.openOthersPageByTab();
		test.log(Status.INFO, "User is navigated on Others Page");
		othersPage.personalDetails(officeAdd, iciciBranch, listOfCountries, cpClassification, cpStatus, crossDefClause,
				exportDefClause, networth, dateOfNetworth, sourceOfNetworth, turnover, listingDetails, noOfAcceptance,
				marginRights, riskPolicy, vRMscript, clientType, sME, internalRating, externalRating, typeOfSecurity,
				docDetails, selectDoc, ISDADetails, FCADetails, docsPath, docSignedBy, location, docStatus, docAwaited,
				commonSeal, safeCustodyMemoNo);

		othersPage.userDetails(limitOfAuth, authLevel, typeOfAuthority, typeOfAuthorisation, group, modeOfOperation,
				meetingDate, GSTNum, GSTAddress, multiGSTNo, description, reasonForBlocking, inputReason,
				docStorageLocation, docSerialNo, passportNo, freeTexts);
		othersPage.submit();
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Others Page : " + toastMessage);
		cs.takeScreenshot("TSSGMakerSubmitted", report_path, "");
		reusable.holdOn(3);
		reusable.logOut();
		test.log(Status.INFO, "TSSG maker journy has been completed and  Request Id '" + requestId
				+ "' assigned to TSSG Checker successfully");
		reusable.holdOn(2);

		//// TSSG Checker Journey

		test.log(Status.INFO, "TSSG Checker Journey started and now, user is on Login Page");
		loginPage.loginApplication(tssgCheckerId, tssgPassword);
		test.log(Status.INFO, "TSSG Checker User logged in successfully by Valid Credential");

		verifyDashboardPage = reusable.VerifyDashboardPage();
		Assert.assertEquals(verifyDashboardPageByText, verifyDashboardPage,
				"User is unable to navigate on Dashboard Page");
		test.log(Status.INFO, "User navigated on Dashboard Page successfully");
		dashboardPage.approvePendingRequestByChecker(requestId, docsPath, remark, comment);
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
