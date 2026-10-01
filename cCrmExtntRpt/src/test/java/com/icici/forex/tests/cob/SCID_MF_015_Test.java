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
import com.icici.forex.pages.CurrencyPairMarginPage;
import com.icici.forex.pages.CurrencyPairPage;
import com.icici.forex.pages.DashboardPage;
import com.icici.forex.pages.OthersPage;
import com.icici.forex.pages.ReviewAndSubmitPage;
import com.icici.forex.utils.BaseAbstractTest;
import com.icici.forex.utils.CaptureScreenShotPage;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;

/**
 * TSSG initiates Online( CTS + Forwards) request for customer, geos to
 * SM-TL-ZH-GH-TSSG (Margin less than 15 or greater than 30 paisa and 
 * additional feature-Pass cash spot)
 *
 */
public class SCID_MF_015_Test extends BaseAbstractTest {

	private DashboardPage dashboardPage;
	private CommonReusableMethods reusable;
	private AccountDetailsPage accDetailsPage;
	private CurrencyPairPage currencyPairPage;
	private CurrencyPairMarginPage cpMarginPage;
	private ReviewAndSubmitPage reviewAndSubmitPage;
	private AdditionalFeaturesPage addFeaturesPage;
	private CorporateUsersPage corpUsersPage;
	private CobConfigurationPage cobConfig;
	private CounterpartyMasterPage cpMasterPage;
	private OthersPage othersPage;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "COB_TestData", executeColumn = "TUID", executeValue = "SCID_MF_015", dsUid = "TUID")
	public void tssgInitiatesModificationJourney_E2E(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = report_path + "SCID_MF_015_Test";
		String requestId, toastMessage, verifyLoginPage, verifyDashboardPage, requestIdFromDashboard,
				verifyCPMarginPage, verifyAddFeaturesPage, txtCurrencyPairsPage, verifyReviewSubmitPage;
		String verifyLoginPageByText = "Please Login to Continue";
		String tssgMakerUserId = String.valueOf(args.get("TSSG_MakerUserID"));
		String tssgPassword = String.valueOf(args.get("TSSG_Password"));
		String verifyDashboardPageByText = "Dashboard";
		String accountNo = String.valueOf(args.get("Account Number"));
		String yesOrNo = String.valueOf(args.get("GST Applicable"));
		String selectGSTNo = String.valueOf(args.get("Select GST Number"));
		String GSTStatus = String.valueOf(args.get("GST Status"));
		String docsPath = String.valueOf(args.get("Document Path"));
		String verifyCurrencyPairPage = "Please select Currency Pair";
		String verifyCPMarginPageByTxt = "Please select Currency Pairs Margin";
		String verifyAddFeaturesPageTxt = "Please select Additional features";
		String selectCategory = String.valueOf(args.get("Category"));
		String selectSubCategory = String.valueOf(args.get("Sub Category"));
		String serviceOffered = String.valueOf(args.get("Services Offered"));
		String pricingType = String.valueOf(args.get("Pricing Type"));
		String verifyReviewSubmitPageTxt = "Please Review the below details";
		String reassignSMName = String.valueOf(args.get("SM Reassign"));
		String smUserName = String.valueOf(args.get("SM_UserID"));
		String smPswrd = String.valueOf(args.get("SM_Password"));
		String approver1UserName = String.valueOf(args.get("TL_UserID"));
		String approver1Password = String.valueOf(args.get("TL_Password"));
		String approver2UserName = String.valueOf(args.get("ZH_UserID"));
		String approver2Password = String.valueOf(args.get("ZH_Password"));
		String approver3UserName = String.valueOf(args.get("GH_UserID"));
		String approver3Password = String.valueOf(args.get("GH_Password"));
		String comment = String.valueOf(args.get("TL/ZH/GH/TSSG Checker Comments"));
		String tssgCheckerId = String.valueOf(args.get("TSSG_CheckerUserID"));
		String comments = String.valueOf(args.get("Comments on Currency Pair"));
		String rate = String.valueOf(args.get("Rate"));
		String isNettingYes = String.valueOf(args.get("isNettingYes"));
		String isBulkDealYes = String.valueOf(args.get("isBulkDealYes"));
		String isPassCashSpotYes = String.valueOf(args.get("isPassCashSpotYes"));
		String isOrders = String.valueOf(args.get("isOrders"));
		String ordersTypes = String.valueOf(args.get("Orders Types"));
		String eDRolloverCancellation = String.valueOf(args.get("ED/Rollover/Cancellation"));
		String approvers = String.valueOf(args.get("Approvers"));
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
		String srNo1 = String.valueOf(args.get("SL No.1"));
		String unit1 = String.valueOf(args.get("Units1"));
		String dealingChannel1 = String.valueOf(args.get("Dealing Channel1"));
		String minAmtRange1 = String.valueOf(args.get("Amount Range From1"));
		String maxAmtRange1 = String.valueOf(args.get("Amount Range To1"));
		String bid1 = String.valueOf(args.get("Bid1"));
		String ask1 = String.valueOf(args.get("Ask1"));
		String srNo2 = String.valueOf(args.get("SL No.2"));
		String unit2 = String.valueOf(args.get("Units2"));
		String dealingChannel2 = String.valueOf(args.get("Dealing Channel2"));
		String minAmtRange2 = String.valueOf(args.get("Amount Range From2"));
		String maxAmtRange2 = String.valueOf(args.get("Amount Range To2"));
		String bid2 = String.valueOf(args.get("Bid2"));
		String ask2 = String.valueOf(args.get("Ask2"));
		String srNo3 = String.valueOf(args.get("SL No.3"));
		String unit3 = String.valueOf(args.get("Units3"));
		String dealingChannel3 = String.valueOf(args.get("Dealing Channel3"));
		String minAmtRange3 = String.valueOf(args.get("Amount Range From3"));
		String maxAmtRange3 = String.valueOf(args.get("Amount Range To3"));
		String bid3 = String.valueOf(args.get("Bid3"));
		String ask3 = String.valueOf(args.get("Ask3"));
		String remark = String.valueOf(args.get("Comments on Currency Pair"));
		String otherCurrencyPair = String.valueOf(args.get("Other CurrencyPair"));

		requestId = "OFL000571153";
		///// TSSG starts modification journey...

		test.log(Status.INFO, "TSSG starts modification journey and now user is on login page");
		reusable = new CommonReusableMethods(getDriver(), test);
		verifyLoginPage = reusable.VerifyLoginPage();
		Assert.assertEquals(verifyLoginPageByText, verifyLoginPage);
		test.log(Status.INFO, "User navigated on Login Page successfully");
		loginPage.loginApplication(tssgMakerUserId, tssgPassword);
		dashboardPage = new DashboardPage(getDriver(), test);
		dashboardPage.clickHamburgerBtn();
		dashboardPage.hoverCobConfiguration();
		cobConfig = new CobConfigurationPage(getDriver(), test);
		reusable.holdOn(1);
		cobConfig.clickModification();
		accDetailsPage = new AccountDetailsPage(getDriver(), test);
		accDetailsPage.provideNewAccountDetails(accountNo);
		accDetailsPage.provideGSTDetails(yesOrNo, selectGSTNo, "", GSTStatus);
		accDetailsPage.selectOnlineForwardServices(docsPath);
		reusable.saveAndContinue();
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Account Details Page : " + toastMessage);

		txtCurrencyPairsPage = reusable.VerifyCurrencyPairPage();
		Assert.assertEquals(verifyCurrencyPairPage, txtCurrencyPairsPage,
				"User is unable to navigate on Currency Pairs Page");
		test.log(Status.INFO, "User navigated on Currency Pairs Page successfully");
		currencyPairPage = new CurrencyPairPage(getDriver(), test);
		currencyPairPage.selectCurrencyPairDetails(selectCategory, selectSubCategory, serviceOffered, pricingType);
		currencyPairPage.resetCurrencyPair();
		currencyPairPage.selectCurrencyPairNoReset(otherCurrencyPair);
		reusable.saveAndContinue();
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Currency Pair Page : " + toastMessage);
		corpUsersPage = new CorporateUsersPage(getDriver(), test);
		corpUsersPage.selectAccessCorpUsers();
		test.log(Status.INFO, "Corporate Users acccessibility selected successfully");
		reviewAndSubmitPage = new ReviewAndSubmitPage(getDriver(), test);
		reviewAndSubmitPage.openReviewSubmitPageByTab();
		verifyReviewSubmitPage = reusable.verifyReviewSubmitPage();
		Assert.assertEquals(verifyReviewSubmitPageTxt, verifyReviewSubmitPage,
				"User is unable to navigate on Review And Submit Page");
		test.log(Status.INFO, "User navigated on Review And Submit Page successfully");
		reviewAndSubmitPage.reviewAndSubmit(docsPath);
		requestId = reviewAndSubmitPage.getRequestIdFromToastMessage();
		test.log(Status.INFO, "User reviewed and submitted successfully");
		cs.takeScreenshot("TSSG_Modified", report_path, "");

		reusable.holdOn(2);
		dashboardPage.clickHamburgerBtn();
		reusable.holdOn(1);
		dashboardPage.hoverCobConfiguration();
		cobConfig.reassignToSM(requestId, reassignSMName);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Reassigned to SM : " + toastMessage);
		cs.takeScreenshot("TSSG_Reasssigned_To_SM", report_path, "");
		reusable.holdOn(1);
		reusable.logOut();
		test.log(Status.INFO,
				"TSSG journey has been completed and Request Id '" + requestId + "' assigned to SM successfully");

		//// SM Journey

		verifyLoginPage = reusable.VerifyLoginPage();
		Assert.assertEquals(verifyLoginPageByText, verifyLoginPage);
		test.log(Status.INFO, "User navigated on Login Page successfully");
		loginPage.loginApplication(smUserName, smPswrd);

		dashboardPage.searchByRequestIDAndOpen(requestId);
		accDetailsPage.provideGSTDetails(yesOrNo, selectGSTNo, "", GSTStatus);
		accDetailsPage.selectOnlineForwardServices(docsPath);
		reusable.saveAndContinue();
		reusable.holdOn(1);
		txtCurrencyPairsPage = reusable.VerifyCurrencyPairPage();
		Assert.assertEquals(verifyCurrencyPairPage, txtCurrencyPairsPage,
				"User is unable to navigate on Currency Pairs Page");
		test.log(Status.INFO, "User navigated on Currency Pairs Page successfully");

    	cpMarginPage = new CurrencyPairMarginPage(getDriver(), test);
		cpMarginPage.openCPMarginPageByTab();
		verifyCPMarginPage = reusable.VerifyCurrencyPairsMarginPage();
		Assert.assertEquals(verifyCPMarginPageByTxt, verifyCPMarginPage,
				"User is unable to navigate on Currency Pairs Margin Page");
		test.log(Status.INFO, "User navigated on Currency Pairs Margin Page successfully");
		cpMarginPage.editMargin(srNo1, unit1, dealingChannel1, minAmtRange1, maxAmtRange1, bid1, ask1);
		cpMarginPage.editMargin(srNo2, unit2, dealingChannel2, minAmtRange2, maxAmtRange2, bid2, ask2);
		cpMarginPage.editMargin(srNo3, unit3, dealingChannel3, minAmtRange3, maxAmtRange3, bid3, ask3);
		cpMarginPage.putComments(comments);
		reusable.saveAndContinue();
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Currency Pairs Margin Page : " + toastMessage);

		verifyAddFeaturesPage = reusable.VerifyAdditionalFeaturesPage();
		Assert.assertEquals(verifyAddFeaturesPageTxt, verifyAddFeaturesPage,
				"user is unable to navigate on Additional Features Page");
		test.log(Status.INFO, "User navigated on Additional Features Page");
		addFeaturesPage = new AdditionalFeaturesPage(getDriver(), test);
		addFeaturesPage.provideAdditionalFeature(rate, isNettingYes, isBulkDealYes, isPassCashSpotYes, isOrders,
				ordersTypes, eDRolloverCancellation);
		addFeaturesPage.selectApprovers(approvers);
		reusable.saveAndContinue();
		reusable.holdOn(1);

		reviewAndSubmitPage.openReviewSubmitPageByTab();
		verifyReviewSubmitPage = reusable.verifyReviewSubmitPage();
		Assert.assertEquals(verifyReviewSubmitPageTxt, verifyReviewSubmitPage,
				"User is unable to navigate on Review And Submit Page");
		test.log(Status.INFO, "User navigated on Review And Submit Page successfully");
		reviewAndSubmitPage.reviewAndSubmit(docsPath);
		test.log(Status.INFO, "User reviewed and submitted successfully");
		requestId = reviewAndSubmitPage.getRequestIdFromToastMessage();
		test.log(Status.INFO, "Review And Submit Page : Details saved successfully");
		cs.takeScreenshot("SM_Approved_Modified", report_path, "");
		reusable.logOut();

		///// Approver1 Journey
		test.log(Status.INFO, "Approver 1 journey started and now, user is on Login Page");
		loginPage.loginApplication(approver1UserName, approver1Password);
		requestIdFromDashboard = dashboardPage.searchByRequestIDAndOpen(requestId);
		Assert.assertEquals(requestId, requestIdFromDashboard, "Application is not showing on Approver 1 Dashboard");
		requestId = reviewAndSubmitPage.commentsAndApprove(comment);
		test.log(Status.INFO, "Approver 1 commented and approved successfully");
		cs.takeScreenshot("TL_Approved_Modified", report_path, "");
		reusable.holdOn(1);
		reusable.logOut();
		test.log(Status.INFO,
				"Approver 1 journey completed and  Request Id '" + requestId + "' assigned to Approver2 successfully");

		//// Approver2 Journey

		test.log(Status.INFO, "Approver 2 journey started and now, user is on Login Page");
		loginPage.loginApplication(approver2UserName, approver2Password);
		requestIdFromDashboard = dashboardPage.searchByRequestIDAndOpen(requestId);
		Assert.assertEquals(requestId, requestIdFromDashboard, "Application is not showing on Approver 2 Dashboard");
		requestId = reviewAndSubmitPage.commentsAndApprove(comment);
		test.log(Status.INFO, "Approver 2 commented and approved successfully");
		cs.takeScreenshot("ZH_Approved_Modified", report_path, "");
		reusable.holdOn(1);
		reusable.logOut();
		test.log(Status.INFO,
				"Approver 2 journey completed and  Request Id '" + requestId + "' assigned to Approver 3 successfully");

		//// Approver3 Journey

		test.log(Status.INFO, "Approver 3 journey started and now, user is on Login Page");
		loginPage.loginApplication(approver3UserName, approver3Password);
		requestIdFromDashboard = dashboardPage.searchByRequestIDAndOpen(requestId);
		Assert.assertEquals(requestId, requestIdFromDashboard, "Application is not showing on Approver 2 Dashboard");
		requestId = reviewAndSubmitPage.commentsAndApprove(comment);
		test.log(Status.INFO, "Approver 3 commented and approved successfully");
		cs.takeScreenshot("ZH_Approved", report_path, "");
		reusable.holdOn(1);
		reusable.logOut();
		test.log(Status.INFO,
				"Approver 3 journey completed and  Request Id '" + requestId + "' assigned to TSSG Maker successfully");

		//// TSSG Maker Journey
		test.log(Status.INFO, "TSSG Maker Journey started and now, user is on Login Page");
		loginPage.loginApplication(tssgMakerUserId, tssgPassword);
		String requestIDFromTSSGCheckerDashboard = dashboardPage.searchByRequestIDAndOpen(requestId);
		Assert.assertEquals(requestId, requestIDFromTSSGCheckerDashboard);
		test.log(Status.INFO, "Adhoc customer assigned to TSSG Checker successfully");
		reusable.holdOn(2);
		accDetailsPage.uploadAndVerifyByAPI(docsPath);
		test.log(Status.INFO, "User navigated on Cunterparty Master Page");
		reusable.holdOn(1);
		cpMasterPage = new CounterpartyMasterPage(getDriver(), test);
		cpMasterPage.setLimitAndContinue(dailyLimit, transLimit, traderLimit, selectChannel);
		test.log(Status.INFO, "User set daily, transaction and trader limit");
		addFeaturesPage.openAddFeaturesPageByTab();
		test.log(Status.INFO, "User navigated on Additional Features Page");
		corpUsersPage.openCorpUserMasterPageByTab();
		test.log(Status.INFO, "User navigated on Corporate User Master page successfully");
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
		cs.takeScreenshot("TSSGMakerSubmitted_Modified", report_path, "");
		reusable.holdOn(1);
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
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Others Page : " + toastMessage);
		cs.takeScreenshot("TSSGCheckerAccepted_Modified", report_path, "");
		test.log(Status.INFO, "TSSG Checker Journey Completed");
		reusable.holdOn(2);
		reusable.logOut();
		reusable.holdOn(1);
	}
}
