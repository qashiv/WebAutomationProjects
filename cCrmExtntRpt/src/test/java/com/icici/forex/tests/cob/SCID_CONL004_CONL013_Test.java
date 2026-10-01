package com.icici.forex.tests.cob;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.icici.forex.pages.AccountDetailsPage;
import com.icici.forex.pages.AdditionalFeaturesPage;
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

public class SCID_CONL004_CONL013_Test extends BaseAbstractTest {

	/**
	 * ## Done Ad hoc customer initiates the online CTS journey (No change in
	 * LEI,GST,New address) and goes to margin update to SM and goes to TL for
	 * approval.
	 */

	private DashboardPage dashboardPage;
	private AccountDetailsPage accDetailsPage;
	private CurrencyPairPage currencyPairPage;
	private CurrencyPairMarginPage cPMarginPage;
	private CorporateUsersPage corpUserPage;
	private ReviewAndSubmitPage reviewAndSubmit;
	private CounterpartyMasterPage cpMasterPage;
	private AdditionalFeaturesPage addFeaturesPage;
	private OthersPage othersPage;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "COB_TestData", executeColumn = "TUID", executeValue = "SCID_CONL004_CONL013", dsUid = "TUID")
	public void adhocCustomerOnboarding_E2E(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = "Snapshots_CONL004_CONL013";
		String requestId, toastMessage, verifyDashboardPage, requestIDFromDashboard, verifyCorpUsersPage;
		String verifyDashboardPageByText = "Dashboard";
		String verifyLoginPageByText = "Please Login to Continue";
		String verifyAccountDetailsByText = "Please provide below details";
		String accountNo = String.valueOf(args.get("Account Number"));
		String contactPersonName = String.valueOf(args.get("Contact Person Name"));
		String otherContactPersonName = String.valueOf(args.get("Other Contact Person Name"));
		String no = String.valueOf(args.get("GST Applicable"));
		String verifyCurrencyPairPage = "Please select Currency Pair";
		String currencyPair = String.valueOf(args.get("Currency Pairs"));
		String verifyCorpUsersPageByText = "Please select the Corporate Users from the below list";
		String verifyReviewSubmitPageByText = "Please Review the below details";
		String SMUserName = String.valueOf(args.get("SM_UserID"));
		String SMPswrd = String.valueOf(args.get("SM_Password"));
		String verifyCPMarginPageByText = "Please select Currency Pairs Margin";
		String currencyPairMarginFilePath = String.valueOf(args.get("Document Path"));
		String comments = String.valueOf(args.get("Comments on Currency Pair"));
		String docsPath = String.valueOf(args.get("Test Document Path"));
		String verifyAddFeaturesPageTxt = "Please select Additional features";
		String rate = String.valueOf(args.get("Rate"));
		String isNettingYes = String.valueOf(args.get("isNettingYes"));
		String isBulkDealYes = String.valueOf(args.get("isBulkDealYes"));
		String isPassCashSpotYes = String.valueOf(args.get("isPassCashSpotYes"));
		String isOrders = String.valueOf(args.get("isOrders"));
		String ordersTypes = String.valueOf(args.get("Orders Types"));
		String eDRolloverCancellation = String.valueOf(args.get("ED/Rollover/Cancellation"));
		String approvers = String.valueOf(args.get("Approvers"));

		String TLUserName = String.valueOf(args.get("TL_UserID"));
		String TLPswrd = String.valueOf(args.get("TL_Password"));
		String ZHUserName = String.valueOf(args.get("ZH_UserID"));
		String ZHPassword = String.valueOf(args.get("ZH_Password"));
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
		String apvrComment = String.valueOf(args.get("TL/ZH/GH/TSSG Checker Comments"));
		String stubLink = String.valueOf(args.get("Stub Link"));

		//// Ad-hoc Customer starts journey By Stub.......... Before here, Write CIB
		//// flow script

//		requestId = "PRP000570993";
		test.log(Status.INFO, "Ad-hoc Customer journey started");
		getDriver().navigate().to(stubLink);
		String verifyAccountDetailsPage = reusable.verifyAccountDetailsPage();
		Assert.assertEquals(verifyAccountDetailsByText, verifyAccountDetailsPage,
				"Unable to navigate on Account Details Page");
		test.log(Status.INFO, "user is navigated on Account Details Page");
		reusable.holdOn(2);
		accDetailsPage = new AccountDetailsPage(getDriver(), test);
		accDetailsPage.selectAccountNo(accountNo);
		reusable.holdOn(3);
		accDetailsPage.selectContactPerson(contactPersonName, otherContactPersonName);
		accDetailsPage.provideGSTDetails(no, "", "", "");
		reusable.holdOn(1);
		reusable.saveAndContinue();
		accDetailsPage.acceptDeclaration();
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Account Details Page : " + toastMessage);

		String txtCurrencyPair = reusable.VerifyCurrencyPairPage();
		Assert.assertEquals(verifyCurrencyPairPage, txtCurrencyPair, "Unable to navigate on Currency Pairs Page");
		test.log(Status.INFO, "User navigated to Currency Pairs Page successfully");
		currencyPairPage = new CurrencyPairPage(getDriver(), test);
		currencyPairPage.selectCurrencyPair(currencyPair);
		reusable.saveAndContinue();
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Currency Pairs Page : " + toastMessage);

		verifyCorpUsersPage = reusable.verifyCorporateUsersPage();
		Assert.assertEquals(verifyCorpUsersPageByText, verifyCorpUsersPage,
				"Unable to navigate on Corporate Users Page");
		test.log(Status.INFO, "User navigated to Corporate Users Page successfully");
		corpUserPage = new CorporateUsersPage(getDriver(), test);
		reusable.holdOn(2);
		corpUserPage.selectAccessCorpUsers();
		test.log(Status.INFO, "Corporate Users Accessibity set successfully");

		String verifyReviewSubmitPage = reusable.verifyReviewSubmitPage();
		Assert.assertEquals(verifyReviewSubmitPageByText, verifyReviewSubmitPage,
				"Unable to navigate on Review And Submit Page");
		test.log(Status.INFO, "User is navigated on Review And Submit Page successfully");
		reviewAndSubmit = new ReviewAndSubmitPage(getDriver(), test);
		reviewAndSubmit.checkDisclaimerAndSubmit();
		requestId = reusable.takeRequestIdByCIBSubmitted();
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Review And Submit Page : " + toastMessage);
		cs.takeScreenshot("PreApproveCustomerSubmit", report_path, "");
		reusable.holdOn(2);
		reusable.logOut();
		test.log(Status.INFO, "Adhoc customer application submitted successfully");

		//// SM Journey for Adhoc Customer
		String verifyLoginPage = reusable.VerifyLoginPage();
		Assert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "User navigated on Login Page successfully");
		loginPage.loginApplication(SMUserName, SMPswrd);
		test.log(Status.INFO, "SM user logged in successfully");
		dashboardPage = new DashboardPage(getDriver(), test);
		requestIDFromDashboard = dashboardPage.searchByRequestIDAndOpen(requestId);
		Assert.assertEquals(requestId, requestIDFromDashboard, "Request Id : " + requestId + " is not assigned to SM");
		test.log(Status.INFO, "Adhoc customer assigned to SM successfully");

		cPMarginPage = new CurrencyPairMarginPage(getDriver(), test);
		cPMarginPage.openCPMarginPageByTab();
		String verifyCurrencyPairsMarginPage = reusable.VerifyCurrencyPairsMarginPage();
		Assert.assertEquals(verifyCPMarginPageByText, verifyCurrencyPairsMarginPage);
		test.log(Status.INFO, "user navigated to Currency Pairs Margin Page Successfully");
		cPMarginPage.uploadCpyMarginFile(currencyPairMarginFilePath);
		cPMarginPage.putComments(comments);
		reusable.saveAndContinue();
		test.log(Status.INFO, "SM added Currency Pairs Margin successfully");
		addFeaturesPage = new AdditionalFeaturesPage(getDriver(), test);
		addFeaturesPage.openAddFeaturesPageByTab();
		String verifyAddFeaturesPage = reusable.VerifyAdditionalFeaturesPage();
		Assert.assertEquals(verifyAddFeaturesPageTxt, verifyAddFeaturesPage,
				"user is unable to navigate on Additional Features Page");
		test.log(Status.INFO, "User navigated on Additional Features Page");
		addFeaturesPage.provideAdditionalFeature(rate, isNettingYes, isBulkDealYes, isPassCashSpotYes, isOrders,
				ordersTypes, eDRolloverCancellation);
		addFeaturesPage.selectApprovers(approvers);
		test.log(Status.INFO, "User added additional features successfully");
		reusable.saveAndContinue();
		reusable.holdOn(1);
		corpUserPage.openCorpUserMasterPageByTab();
		verifyCorpUsersPage = reusable.verifyCorporateUsersPage();
		Assert.assertEquals(verifyCorpUsersPageByText, verifyCorpUsersPage,
				"Unable to navigate on Corporate Users Page");
		test.log(Status.INFO, "User navigated on Corporate Users Page successfully");

		reviewAndSubmit.openReviewSubmitPageByTab();
		String verifyReviewSubmitPageTxt = reusable.verifyReviewSubmitPage();
		Assert.assertEquals(verifyReviewSubmitPageByText, verifyReviewSubmitPageTxt);
		test.log(Status.INFO, "User is navigated to Review And Submit Page successfully");
		reviewAndSubmit.reviewAndSubmit(docsPath);
		cs.takeScreenshot("SMSubmittedAdhocCust", report_path, "");
		test.log(Status.INFO, "SM reviewed details and submitted successfully");
		reusable.holdOn(2);
		reusable.logOut();

		///// Approver1 Journey
		test.log(Status.INFO, "Approver 1 journey started and now, user is on Login Page");
		loginPage.loginApplication(TLUserName, TLPswrd);
		requestIDFromDashboard = dashboardPage.searchByRequestIDAndOpen(requestId);
		Assert.assertEquals(requestId, requestIDFromDashboard, "Application is not showing on Approver 1 Dashboard");
		requestId = reviewAndSubmit.commentsAndApprove(comments);
		test.log(Status.INFO, "Approver 1 commented and approved successfully");
		cs.takeScreenshot("TL_Approved", report_path, "");
		reusable.holdOn(1);
		reusable.logOut();
		test.log(Status.INFO, "Approver 1 journey completed successfully with Request Id : " + requestId);

		//// Approver2 Journey

		test.log(Status.INFO, "Approver 2 journey started and now, user is on Login Page");
		loginPage.loginApplication(ZHUserName, ZHPassword);
		requestIDFromDashboard = dashboardPage.searchByRequestIDAndOpen(requestId);
		Assert.assertEquals(requestId, requestIDFromDashboard, "Application is not showing on Approver 2 Dashboard");
		requestId = reviewAndSubmit.commentsAndApprove(comments);
		test.log(Status.INFO, "Approver 2 commented and approved successfully");
		cs.takeScreenshot("ZH_Approved", report_path, "");
		reusable.holdOn(1);
		reusable.logOut();
		test.log(Status.INFO, "Approver 2 journey completed successfully and  Request Id '" + requestId
				+ "' assigned to TSSG Maker successfully");

		//// TSSG Maker Journey
		test.log(Status.INFO, "TSSG Maker Journey started and now, user is on Login Page");
		loginPage.loginApplication(tssgMakerUserId, tssgPassword);
		dashboardPage.searchByRequestIDAndOpen(requestId);
		accDetailsPage.refreshByIcon();
		accDetailsPage.uploadAndVerifyByAPI(docsPath);
		reusable.holdOn(1);

		test.log(Status.INFO, "User navigated on Cunterparty Master Page");
		cpMasterPage = new CounterpartyMasterPage(getDriver(), test);
		cpMasterPage.setLimitAndContinue(dailyLimit, transLimit, traderLimit, selectChannel);
		test.log(Status.INFO, "User set daily, transaction and trader limit");
		reusable.holdOn(1);
		addFeaturesPage = new AdditionalFeaturesPage(getDriver(), test);
		addFeaturesPage.openAddFeaturesPageByTab();
		test.log(Status.INFO, "User navigated on Additional Features Page");

		reusable.holdOn(1);
		corpUserPage = new CorporateUsersPage(getDriver(), test);
		corpUserPage.openCorpUserMasterPageByTab();
		test.log(Status.INFO, "User navigated on Corporate User Master page successfully");
		corpUserPage.addNewAuthorisedUser(authUsers, otherUserId, userName, email);
		reusable.holdOn(1);

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
		dashboardPage = new DashboardPage(getDriver(), test);
		dashboardPage.approvePendingRequestByChecker(requestId, docsPath, comments, apvrComment);
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
