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

public class SCID_IBGTSSG_001_Test extends BaseAbstractTest {

	/**
	 * @Scenario_Description : TSSG user initiates the request for IBG Hongkong
	 *                       customer onboarding and TSSG checker approves the
	 *                       request ##Done
	 */
	private DashboardPage dashboardPage;
	private CommonReusableMethods reusable;
	private AccountDetailsPage accDetailsPage;
	private CurrencyPairPage currencyPairPage;
	private CurrencyPairMarginPage cpMarginPage;
	private ReviewAndSubmitPage reviewAndSubmitPage;
	private AdditionalFeaturesPage addFeaturesPage;
	private CorporateUsersPage corpUsersPage;
	private CounterpartyMasterPage cpMasterPage;
	private OthersPage othersPage;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "COB_TestData", executeColumn = "TUID", executeValue = "SCID_IBGTSSG_001", dsUid = "TUID")
	public void customerOnboardingJourneyForIBGHongkongCustomer(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = report_path + "SCID_IBGTSSG_001";
		String requestId, toastMessage, verifyDashboardPage, verifyCorpUserPage, txtCurrencyPairsPage;
		String verifyLoginPageByText = "Please Login to Continue";
		String tssgMakerUserId = String.valueOf(args.get("TSSG_MakerUserID"));
		String tssgPassword = String.valueOf(args.get("TSSG_Password"));
		String verifyDashboardPageByText = "Dashboard";
		String verifyAccDetailsPageByText = "Please provide below details";
		String accountNo = String.valueOf(args.get("Account Number"));
		String custId = String.valueOf(args.get("Customer ID"));
		String companyName = String.valueOf(args.get("Company Name"));
		String corpId = String.valueOf(args.get("Corporate ID"));
		String communicationAddress = String.valueOf(args.get("Communication Address"));
		String countryName = String.valueOf(args.get("Country Name"));
		String mobNo = String.valueOf(args.get("Mobile No"));
		String email = String.valueOf(args.get("Email"));
		String LEI = String.valueOf(args.get("LEI"));
		String docsPath = String.valueOf(args.get("Document Path"));
		String contactPersonName = String.valueOf(args.get("Contact Person Name"));
		String verifyCurrencyPairPage = "Please select Currency Pair";
		String verifyCPMarginPageByTxt = "Please select Currency Pairs Margin";
		String verifyAddFeaturesPageTxt = "Please select Additional features";
		String pricingType = String.valueOf(args.get("Pricing Type"));
		String currencyPair = String.valueOf(args.get("Currency Pairs"));
		String verifyCorpUserPageByText = "Please select the Corporate Users from the below list";
		String verifyReviewSubmitPageTxt = "Please Review the below details";
		String commentForApproval = String.valueOf(args.get("TL/ZH/GH/TSSG Checker Comments"));
		String commentOnCP = String.valueOf(args.get("Comments on Currency Pair"));
		String rate = String.valueOf(args.get("Rate"));
		String isNettingYes = String.valueOf(args.get("isNettingYes"));
		String isBulkDealYes = String.valueOf(args.get("isBulkDealYes"));
		String isPassCashSpotYes = String.valueOf(args.get("isPassCashSpotYes"));
		String isOrders = String.valueOf(args.get("isOrders"));
		String ordersTypes = String.valueOf(args.get("Orders Types"));
		String eDRolloverCancellation = String.valueOf(args.get("ED/Rollover/Cancellation"));
		String dailyLimit = String.valueOf(args.get("Daily Limit (in USD)"));
		String transLimit = String.valueOf(args.get("Transaction Limit (in USD)"));
		String traderLimit = String.valueOf(args.get("Trader Limit (in USD)"));
		String selectChannel = String.valueOf(args.get("Channel"));
		String authUsers = String.valueOf(args.get("Authorised Users"));
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
		String entity = String.valueOf(args.get("Entity"));
		String clientNature = String.valueOf(args.get("Client Nature"));
		String tssgChecker2 = String.valueOf(args.get("TSSG_Checker2UserID"));
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
		String userName = String.valueOf(args.get("Auth User Name"));
		String emailId = String.valueOf(args.get("Auth Email"));
		String access = String.valueOf(args.get("Access"));
		String tssgChecker = String.valueOf(args.get("TSSG_CheckerUserID"));

//		requestId = "IBG000384936";
		///// IBGTSSG - Onboarding Registration Journey

		test.log(Status.INFO, "IBGTSSG journey started");
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
		reusable.holdOn(1);
		dashboardPage.clickCreateNewRequest();
		test.log(Status.INFO, "User started to Create New Request");

		String verifyAccDetailsPage = reusable.verifyAccountDetailsPage();
		Assert.assertEquals(verifyAccDetailsPageByText, verifyAccDetailsPage,
				"User is unable to navigate on Account Details Page");
		test.log(Status.INFO, "User navigated on Account Details Page successfully");
		accDetailsPage = new AccountDetailsPage(getDriver(), test);
		reusable.holdOn(1);
		accDetailsPage.provideNewAccountDetails(accountNo);
		reusable.holdOn(2);
		accDetailsPage.fillAccDetailsForIBGCustomer(custId, companyName, corpId, contactPersonName,
				communicationAddress, countryName, mobNo, email, LEI);
		reusable.holdOn(1);
		reusable.saveAndContinue();
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Account Details Page : " + toastMessage);

		txtCurrencyPairsPage = reusable.VerifyCurrencyPairPage();
		Assert.assertEquals(verifyCurrencyPairPage, txtCurrencyPairsPage,
				"User is unable to navigate on Currency Pairs Page");
		test.log(Status.INFO, "User navigated on Currency Pairs Page successfully");
		currencyPairPage = new CurrencyPairPage(getDriver(), test);
		currencyPairPage.selectCurrencyPairDetailsIBG(pricingType);
		currencyPairPage.selectCurrencyPairNoReset(currencyPair);
		reusable.saveAndContinue();
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Currency Pair Page : " + toastMessage);

		reusable.holdOn(2);
		String verifyCPMarginPage = reusable.VerifyCurrencyPairsMarginPage();
		Assert.assertEquals(verifyCPMarginPageByTxt, verifyCPMarginPage,
				"User is unable to navigate on Currency Pairs Margin Page");
		test.log(Status.INFO, "User navigated on Currency Pairs Margin Page successfully");
		cpMarginPage = new CurrencyPairMarginPage(getDriver(), test);
		cpMarginPage.editMargin(srNo1, unit1, dealingChannel1, minAmtRange1, maxAmtRange1, bid1, ask1);
		reusable.holdOn(1);
		cpMarginPage.editMargin(srNo2, unit2, dealingChannel2, minAmtRange2, maxAmtRange2, bid2, ask2);
		reusable.holdOn(1);
		cpMarginPage.putComments(commentOnCP);
		reusable.holdOn(2);
		reusable.saveAndContinue();
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Currency Pairs Margin Page : " + toastMessage);
		reusable.holdOn(2);
		String verifyAddFeaturesPage = reusable.VerifyAdditionalFeaturesPage();
		Assert.assertEquals(verifyAddFeaturesPageTxt, verifyAddFeaturesPage,
				"user is unable to navigate on Additional Features Page");
		test.log(Status.INFO, "User navigated on Additional Features Page");
		addFeaturesPage = new AdditionalFeaturesPage(getDriver(), test);
		addFeaturesPage.provideAdditionalFeature(rate, isNettingYes, isBulkDealYes, isPassCashSpotYes, isOrders,
				ordersTypes, eDRolloverCancellation);
		test.log(Status.INFO, "User added additional features successfully");
		reusable.holdOn(2);
		reusable.saveAndContinue();
		reusable.holdOn(2);

		verifyCorpUserPage = reusable.verifyCorporateUsersPage();
		Assert.assertEquals(verifyCorpUserPageByText, verifyCorpUserPage, "Unable to navigate on Corporate Users Page");
		test.log(Status.INFO, "User navigated on Corporate Users Page successfully");
		corpUsersPage = new CorporateUsersPage(getDriver(), test);
		corpUsersPage.addNewAuthorisedUserIBG(authUsers, userName, emailId, access);
		reusable.saveAndContinue();
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Corporate Users Page : " + toastMessage);
		reusable.holdOn(2);

		String verifyReviewAndSubmitPage = reusable.verifyReviewSubmitPage();
		Assert.assertEquals(verifyReviewSubmitPageTxt, verifyReviewAndSubmitPage);
		test.log(Status.INFO, "Review and Submit page opened successfully");
		reviewAndSubmitPage = new ReviewAndSubmitPage(getDriver(), test);
		reviewAndSubmitPage.reviewAndSubmit(docsPath);
		reusable.holdOn(1);
		cs.takeScreenshot("TSSG_Submitted", report_path, "");
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Review And Submit Page : " + toastMessage);
		requestId = reusable.takeRequestIdFromToastMessage();
		reusable.holdOn(2);
		reusable.logOut();

		//// TSSG Maker Journey
		test.log(Status.INFO, "TSSG Maker Journey started and now, user is on Login Page");
		loginPage.loginApplication(tssgChecker2, tssgPassword);
		reusable.holdOn(2);
//		dashboardPage.openMyRequest(); /// when once open request id then it's showing under my request.
		dashboardPage.searchByRequestIDAndOpen(requestId);
		reusable.holdOn(2);
		cpMasterPage = new CounterpartyMasterPage(getDriver(), test);
		cpMasterPage.openCPMasterPageByTab();
		reusable.holdOn(2);
		test.log(Status.INFO, "User navigated on Cunterparty Master Page");
		cpMasterPage.setLimitAndContinue(dailyLimit, transLimit, traderLimit, selectChannel);
		test.log(Status.INFO, "User set daily, transaction and trader limit");
		reusable.holdOn(2);
		cpMarginPage.openCPMarginPageByTab();
		reusable.holdOn(2);
		addFeaturesPage.openAddFeaturesPageByTab();
		test.log(Status.INFO, "User navigated on Additional Features Page");
		reusable.holdOn(2);
		corpUsersPage.openCorpUserMasterPageByTab();
		test.log(Status.INFO, "User navigated on Corporate User Master page successfully");
		reusable.holdOn(2);
		othersPage = new OthersPage(getDriver(), test);
		othersPage.openOthersPageByTab();
		test.log(Status.INFO, "User is navigated on Others Page");
		reusable.holdOn(2);
		othersPage.fillOthersDetailsForIBGCustomer(entity, clientNature, officeAdd, iciciBranch, listOfCountries,
				cpClassification, cpStatus, crossDefClause, exportDefClause, networth, dateOfNetworth, sourceOfNetworth,
				turnover, listingDetails, noOfAcceptance, marginRights, riskPolicy, vRMscript, clientType, sME,
				internalRating, externalRating, typeOfSecurity, docDetails, selectDoc, ISDADetails, FCADetails,
				docsPath, docSignedBy, location, docStatus, docAwaited, commonSeal, safeCustodyMemoNo, limitOfAuth,
				authLevel, typeOfAuthority, typeOfAuthorisation, group, modeOfOperation, meetingDate, GSTNum,
				GSTAddress, multiGSTNo, description, reasonForBlocking, inputReason, docStorageLocation, docSerialNo,
				passportNo, freeTexts);
		othersPage.submit();
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Others Page : " + toastMessage);
		cs.takeScreenshot("TSSGMakerSubmitted", report_path, "");
		reusable.holdOn(2);
		reusable.logOut();
		test.log(Status.INFO, "TSSG maker journey has been completed and  Request Id '" + requestId
				+ "' assigned to TSSG Checker successfully");
		reusable.holdOn(2);

		/// TSSG Checker Journey...

		test.log(Status.INFO, "TSSG Checker Journey started and now, user is on Login Page");
		loginPage.loginApplication(tssgChecker, tssgPassword);
		test.log(Status.INFO, "TSSG Checker User logged in successfully by Valid Credential");

		verifyDashboardPage = reusable.VerifyDashboardPage();
		Assert.assertEquals(verifyDashboardPageByText, verifyDashboardPage,
				"User is unable to navigate on Dashboard Page");
		test.log(Status.INFO, "User navigated on Dashboard Page successfully");
		dashboardPage.approvePendingRequestByChecker(requestId, docsPath, commentOnCP, commentForApproval);
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
