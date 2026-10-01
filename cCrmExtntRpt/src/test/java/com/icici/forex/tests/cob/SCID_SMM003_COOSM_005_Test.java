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

/**
 * --->> SMM_003 : SM initiates request for online (CTS + forward)
 * customer,update the margin and request goes to TL and TSSG approval --->>
 * COOSM_005 : SM initiates online Forward Journey to onboard adhoc
 * customer,update currency pair and margin,request goes to TL and then to TSSG
 * approval #Done
 */
public class SCID_SMM003_COOSM_005_Test extends BaseAbstractTest {

	private DashboardPage dashboardPage;
	private AccountDetailsPage accDetailsPage;
	private CurrencyPairPage currencyPairPage;
	private CurrencyPairMarginPage cpMarginPage;
	private AdditionalFeaturesPage addFeaturesPage;
	private ReviewAndSubmitPage reviewAndSubmit;
	private CounterpartyMasterPage cpMasterPage;
	private CommonReusableMethods reusable;
	private CorporateUsersPage corpUsersPage;
	private OthersPage othersPage;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "COB_TestData", executeColumn = "TUID", executeValue = "SCID_SMM003_COOSM_005", dsUid = "TUID")
	public void customerOnboarding_E2E(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = report_path + "SCID_SMM003_COOSM_005_Test";
		String toastMessage, requestId, requestIdFromDashboard, verifyDashboardPage;
		String verifyLoginPageByText = "Please Login to Continue";
		String smUserName = String.valueOf(args.get("SM_UserID"));
		String smPswrd = String.valueOf(args.get("SM_Password"));
		String verifyDashboardPageByText = "Dashboard";
		String onboardingType = String.valueOf(args.get("Onboarding Type"));
		String verifyAccDetailsPageByText = "Please provide below details";
		String accountNo = String.valueOf(args.get("Account Number"));
		String yesOrNo = String.valueOf(args.get("GST Applicable"));
		String selectGSTNo = String.valueOf(args.get("Select GST Number"));
		String otherGSTNo = String.valueOf(args.get("Input GST Number"));
		String GSTStatus = String.valueOf(args.get("GST Status"));
		String contactPersonName = String.valueOf(args.get("Contact Person Name"));
		String otherContactPersonName = String.valueOf(args.get("Other Contact Person Name"));
		String commAddress = String.valueOf(args.get("Communication Address"));
		String pinCode = String.valueOf(args.get("Pin Code"));

		String verifyCurrencyPairPage = "Please select Currency Pair";
		String selectCategory = String.valueOf(args.get("Category"));
		String selectSubCategory = String.valueOf(args.get("Sub Category"));
		String serviceOffered = String.valueOf(args.get("Services Offered"));
		String pricingType = String.valueOf(args.get("Pricing Type"));
		String currencyPair = String.valueOf(args.get("Currency Pairs"));

		String verifyCPMarginPageByTxt = "Please select Currency Pairs Margin";
		String uploadCPMarginFilePath = String.valueOf(args.get("Document Path"));
		String comments = String.valueOf(args.get("Comments on Currency Pair"));
		String verifyAddFeaturesPageTxt = "Please select Additional features";
		String rate = String.valueOf(args.get("Rate"));
		String isNettingYes = String.valueOf(args.get("isNettingYes"));
		String isBulkDealYes = String.valueOf(args.get("isBulkDealYes"));
		String isPassCashSpotYes = String.valueOf(args.get("isPassCashSpotYes"));
		String isOrders = String.valueOf(args.get("isOrders"));
		String ordersTypes = String.valueOf(args.get("Orders Types"));
		String eDRolloverCancellation = String.valueOf(args.get("ED/Rollover/Cancellation"));
		String approvers = String.valueOf(args.get("Approvers"));

		String verifyCorpUsersPageTxt = "Please select the Corporate Users from the below list";
		String verifyReviewSubmitPageTxt = "Please Review the below details";
		String docsPath = String.valueOf(args.get("Test Document Path"));
		String approver1UserName = String.valueOf(args.get("TL_UserID"));
		String approver1Password = String.valueOf(args.get("TL_Password"));
		String approver2UserName = String.valueOf(args.get("ZH_UserID"));
		String approver2Password = String.valueOf(args.get("ZH_Password"));
		String comment = String.valueOf(args.get("TL/ZH/GH/TSSG Checker Comments"));
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

//		requestId = "OFL000477337";

		///// SM Journey to TSSG Checker - E2E
		
		test.log(Status.INFO, "SM Journey is Started...");
		reusable = new CommonReusableMethods(getDriver(), test);
		String verifyLoginPage = reusable.VerifyLoginPage();
		Assert.assertEquals(verifyLoginPageByText, verifyLoginPage);
		test.log(Status.INFO, "User navigated on Login Page successfully");
		loginPage.loginApplication(smUserName, smPswrd);
		test.log(Status.INFO, "User logged in successfully by Valid Credential");

		verifyDashboardPage = reusable.VerifyDashboardPage();
		Assert.assertEquals(verifyDashboardPageByText, verifyDashboardPage,
				"User is unable to navigate on Dashboard Page");
		test.log(Status.INFO, "User navigated on Dashboard Page successfully");
		dashboardPage = new DashboardPage(getDriver(), test);
		dashboardPage.createNewRequest(onboardingType);
		test.log(Status.INFO, "User started to Create New Request");

		String verifyAccDetailsPage = reusable.verifyAccountDetailsPage();
		Assert.assertEquals(verifyAccDetailsPageByText, verifyAccDetailsPage,
				"User is unable to navigate on Account Details Page");
		test.log(Status.INFO, "User navigated on Account Details Page successfully");
		accDetailsPage = new AccountDetailsPage(getDriver(), test);
		accDetailsPage.provideNewAccountDetails(accountNo);
		accDetailsPage.selectContactPerson(contactPersonName, otherContactPersonName);
		accDetailsPage.addNewAddress(commAddress, pinCode);
		accDetailsPage.provideGSTDetails(yesOrNo, selectGSTNo, otherGSTNo, GSTStatus);
		accDetailsPage.selectOnlineForwardServices(docsPath);
		reusable.saveAndContinue();
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Account Details Page : " + toastMessage);

		String txtCurrencyPairsPage = reusable.VerifyCurrencyPairPage();
		Assert.assertEquals(verifyCurrencyPairPage, txtCurrencyPairsPage,
				"User is unable to navigate on Currency Pairs Page");
		test.log(Status.INFO, "User navigated on Currency Pairs Page successfully");
		currencyPairPage = new CurrencyPairPage(getDriver(), test);
		currencyPairPage.selectCurrencyPairDetails(selectCategory, selectSubCategory, serviceOffered, pricingType);
		currencyPairPage.selectCurrencyPairNoReset(currencyPair);
		reusable.saveAndContinue();
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Currency Pair Page : " + toastMessage);

		String verifyCPMarginPage = reusable.VerifyCurrencyPairsMarginPage();
		Assert.assertEquals(verifyCPMarginPageByTxt, verifyCPMarginPage,
				"User is unable to navigate on Currency Pairs Margin Page");
		test.log(Status.INFO, "User navigated on Currency Pairs Margin Page successfully");
		cpMarginPage = new CurrencyPairMarginPage(getDriver(), test);
		cpMarginPage.uploadCpyMarginFile(uploadCPMarginFilePath);
		cpMarginPage.putComments(comments);
		reusable.saveAndContinue();
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Currency Pairs Margin Page : " + toastMessage);

		String verifyAddFeaturesPage = reusable.VerifyAdditionalFeaturesPage();
		Assert.assertEquals(verifyAddFeaturesPageTxt, verifyAddFeaturesPage,
				"user is unable to navigate on Additional Features Page");
		test.log(Status.INFO, "User navigated on Additional Features Page");
		addFeaturesPage = new AdditionalFeaturesPage(getDriver(), test);
		addFeaturesPage.provideAdditionalFeature(rate, isNettingYes, isBulkDealYes, isPassCashSpotYes, isOrders,
				ordersTypes, eDRolloverCancellation);
		addFeaturesPage.selectApprovers(approvers);
		test.log(Status.INFO, "User added additional features successfully");
		reusable.saveAndContinue();
		reusable.holdOn(2);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Additional Features Page : " + toastMessage);

		String verifyCorpUsersPage = reusable.verifyCorporateUsersPage();
		Assert.assertEquals(verifyCorpUsersPageTxt, verifyCorpUsersPage,
				"User is unable to navigate on Corporate Users Page");
		test.log(Status.INFO, "User navigated on Corporate Users Page");
		corpUsersPage = new CorporateUsersPage(getDriver(), test);
		corpUsersPage.selectAccessCorpUsers();
		test.log(Status.INFO, "Corporate Users acccessibility selected successfully");

		reviewAndSubmit = new ReviewAndSubmitPage(getDriver(), test);
		reviewAndSubmit.openReviewSubmitPageByTab();
		String verifyReviewSubmitPage = reusable.verifyReviewSubmitPage();
		Assert.assertEquals(verifyReviewSubmitPageTxt, verifyReviewSubmitPage,
				"User is unable to navigate on Review And Submit Page");
		test.log(Status.INFO, "User navigated on Review And Submit Page successfully");
		reviewAndSubmit.reviewAndSubmit(docsPath);
		test.log(Status.INFO, "User reviewed and submitted successfully");
		cs.takeScreenshot("SM_Approved", report_path, "");
		requestId = reviewAndSubmit.getRequestIdFromToastMessage();
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Review And Submit Page : " + toastMessage);
		reusable.holdOn(2);
		reusable.logOut();
		test.log(Status.INFO,
				"SM journey has been completed and Request Id '" + requestId + "' assigned to Approver 1 successfully");

		///// Approver1 Journey
		test.log(Status.INFO, "Approver 1 journey started and now, user is on Login Page");
		loginPage.loginApplication(approver1UserName, approver1Password);
		requestIdFromDashboard = dashboardPage.searchByRequestIDAndOpen(requestId);
		Assert.assertEquals(requestId, requestIdFromDashboard, "Application is not showing on Approver 1 Dashboard");
		requestId = reviewAndSubmit.commentsAndApprove(comment);
		test.log(Status.INFO, "Approver 1 commented and approved successfully");
		cs.takeScreenshot("TL_Approved", report_path, "");
		reusable.holdOn(2);
		reusable.logOut();
		test.log(Status.INFO, "Approver 1 journey completed successfully and  Request Id '" + requestId
				+ "' assigned to Approver2 successfully");

		//// Approver2 Journey

		test.log(Status.INFO, "Approver 2 journey started and now, user is on Login Page");
		loginPage.loginApplication(approver2UserName, approver2Password);
		requestIdFromDashboard = dashboardPage.searchByRequestIDAndOpen(requestId);
		Assert.assertEquals(requestId, requestIdFromDashboard, "Application is not showing on Approver 2 Dashboard");
		requestId = reviewAndSubmit.commentsAndApprove(comment);
		test.log(Status.INFO, "Approver 2 commented and approved successfully");
		cs.takeScreenshot("ZH_Approved", report_path, "");
		reusable.holdOn(2);
		reusable.logOut();
		test.log(Status.INFO, "Approver 2 journey completed successfully and  Request Id '" + requestId
				+ "' assigned to TSSG Maker successfully");

		//// TSSG Maker Journey
		test.log(Status.INFO, "TSSG Maker Journey started and now, user is on Login Page");
		loginPage.loginApplication(tssgMakerUserId, tssgPassword);
		dashboardPage.searchByRequestIDAndOpen(requestId);
		accDetailsPage.refreshByIcon();
		accDetailsPage.uploadAndVerifyByAPI(docsPath);

		test.log(Status.INFO, "User navigated on Cunterparty Master Page");
		cpMasterPage = new CounterpartyMasterPage(getDriver(), test);
		cpMasterPage.setLimitAndContinue(dailyLimit, transLimit, traderLimit, selectChannel);
		test.log(Status.INFO, "User set daily, transaction and trader limit");
		reusable.holdOn(2);
		addFeaturesPage.openAddFeaturesPageByTab();
		test.log(Status.INFO, "User navigated on Additional Features Page");

		reusable.holdOn(2);
		corpUsersPage.openCorpUserMasterPageByTab();
		test.log(Status.INFO, "User navigated on Corporate User Master page successfully");
		reusable.holdOn(1);
		corpUsersPage.addNewAuthorisedUser(authUsers, otherUserId, userName, email);
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
		reusable.holdOn(2);
		reusable.logOut();
		test.log(Status.INFO, "TSSG maker journy has been completed and  Request Id '" + requestId
				+ "' assigned to TSSG Checker successfully");

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
		reusable.holdOn(2);
		reusable.logOut();
		reusable.holdOn(1);
	}
}
