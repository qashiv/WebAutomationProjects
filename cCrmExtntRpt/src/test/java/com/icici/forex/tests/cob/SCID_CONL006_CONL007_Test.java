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
import com.icici.forex.pages.DashboardPage;
import com.icici.forex.pages.OthersPage;
import com.icici.forex.utils.BaseAbstractTest;
import com.icici.forex.utils.CaptureScreenShotPage;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;

public class SCID_CONL006_CONL007_Test extends BaseAbstractTest {

	/**
	 * Check by debug -- Cust id is not taken from bulk counterparty upload
	 * 
	 * @Prerequisite : For Bulk Counterparty, 1 account should be onboarded, 1
	 *               should be in progress, 1 should be fresh.
	 * @Scenario_Description : To check the auto counterparty creation functionality
	 *                       for new counterparty
	 */
	private DashboardPage dashboardPage;
	private CommonReusableMethods reusable;
	private AccountDetailsPage accDetailsPage;
	private CounterpartyMasterPage cpMasterPage;
	private AdditionalFeaturesPage addFeaturesPage;
	private CorporateUsersPage corpUsersPage;
	private CobConfigurationPage cobConfigPage;
	private OthersPage othersPage;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "COB_TestData", executeColumn = "TUID", executeValue = "SCID_CONL006_CONL007", dsUid = "TUID")
	public void adhocCustOnboardingJourney(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = report_path + "SCID_CONL006_CONL007";
		String verifyLoginPage, verifyDashboardPage, toastMessage, custId, custIdFromDashboard;
		String TSSG_UserId = String.valueOf(args.get("TSSG_MakerUserID"));
		String TSSG_Password = String.valueOf(args.get("TSSG_Password"));
		String verifyLoginPageByText = "Please Login to Continue";
		String verifyDashboardPageByText = "Dashboard";
		String bulkCPFilePath = String.valueOf(args.get("Document Path"));
		String verifyAccDetailsPageByText = "Please provide below details";
		String contactPersonName = String.valueOf(args.get("Contact Person Name"));
		String otherContactPersonName = String.valueOf(args.get("Other Contact Person Name"));
		String docsPath = String.valueOf(args.get("Test Document Path"));
		String dailyLimit = String.valueOf(args.get("Daily Limit (in USD)"));
		String transLimit = String.valueOf(args.get("Transaction Limit (in USD)"));
		String traderLimit = String.valueOf(args.get("Trader Limit (in USD)"));
		String selectChannel = String.valueOf(args.get("Channel"));

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
		String apvrComment = String.valueOf(args.get("TL/ZH/GH/TSSG Checker Comments"));

		//// TSSG Journey - Adhoc customer journey

		test.log(Status.INFO, "Ad-hoc customer journey is started...");
		reusable = new CommonReusableMethods(getDriver(), test);
		verifyLoginPage = reusable.VerifyLoginPage();
		Assert.assertEquals(verifyLoginPageByText, verifyLoginPage, "Unable to navigate on Login Page");
		test.log(Status.INFO, "User navigated on Login Page successfully");
		loginPage.loginApplication(TSSG_UserId, TSSG_Password);
		test.log(Status.INFO, "TSSG user logged in successfully");
		verifyDashboardPage = reusable.VerifyDashboardPage();
		Assert.assertEquals(verifyDashboardPageByText, verifyDashboardPage,
				"User is unable to navigate on Dashboard Page");
		test.log(Status.INFO, "User navigated on Dashboard Page successfully");
		dashboardPage = new DashboardPage(getDriver(), test);
		reusable.holdOn(2);
		dashboardPage.clickHamburgerBtn();
		dashboardPage.hoverCobConfiguration();

		cobConfigPage = new CobConfigurationPage(getDriver(), test);
		cobConfigPage.uploadBulkCounterparty(bulkCPFilePath);
//		toastMessage = reusable.toastMessage();
		custId = cobConfigPage.getFreshCustIdFromBulkCounterpartyUpload();
//		test.log(Status.INFO, "Ad-hoc Customer on Cob Configuration : " + toastMessage);
		reusable.holdOn(2);
		dashboardPage.clickDashboardTab();
		verifyDashboardPage = reusable.VerifyDashboardPage();
		Assert.assertEquals(verifyDashboardPageByText, verifyDashboardPage,
				"User is unable to navigate on Dashboard Page");
		test.log(Status.INFO, "User is comeback on Dashboard Page");

		custIdFromDashboard = dashboardPage.searchByCustIDAndOpen(custId);
		Assert.assertEquals(custId, custIdFromDashboard, "Application is not showing on TSSG Maker Dashboard");

		String verifyAccDetailsPage = reusable.verifyAccountDetailsPage();
		Assert.assertEquals(verifyAccDetailsPageByText, verifyAccDetailsPage,
				"User is unable to navigate on Account Details Page");
		test.log(Status.INFO, "User navigated on Account Details Page successfully");
		accDetailsPage = new AccountDetailsPage(getDriver(), test);
		accDetailsPage.selectContactPerson(contactPersonName, otherContactPersonName);
		accDetailsPage.uploadAndVerifyByAPI(docsPath);
		reusable.holdOn(2);

		test.log(Status.INFO, "User navigated on Cunterparty Master Page");
		cpMasterPage = new CounterpartyMasterPage(getDriver(), test);
		cpMasterPage.setLimitAndContinue(dailyLimit, transLimit, traderLimit, selectChannel);
		test.log(Status.INFO, "User set daily, transaction and trader limit");
		reusable.holdOn(2);

		addFeaturesPage = new AdditionalFeaturesPage(getDriver(), test);
		addFeaturesPage.openAddFeaturesPageByTab();
		test.log(Status.INFO, "User navigated on Additional Features Page");

		reusable.holdOn(2);
		corpUsersPage = new CorporateUsersPage(getDriver(), test);
		corpUsersPage.openCorpUserMasterPageByTab();
		test.log(Status.INFO, "User navigated on Corporate User Master page successfully");
		reusable.holdOn(2);

		othersPage = new OthersPage(getDriver(), test);
		othersPage.openOthersPageByTab();
		othersPage.personalDetails(officeAdd, iciciBranch, listOfCountries, cpClassification, cpStatus, crossDefClause,
				exportDefClause, networth, dateOfNetworth, sourceOfNetworth, turnover, listingDetails, noOfAcceptance,
				marginRights, riskPolicy, vRMscript, clientType, sME, internalRating, externalRating, typeOfSecurity,
				docDetails, selectDoc, ISDADetails, FCADetails, docsPath, docSignedBy, location, docStatus, docAwaited,
				commonSeal, safeCustodyMemoNo);
		othersPage.userDetails(limitOfAuth, authLevel, typeOfAuthority, typeOfAuthorisation, group, modeOfOperation,
				meetingDate, GSTNum, GSTAddress, multiGSTNo, description, reasonForBlocking, inputReason,
				docStorageLocation, docSerialNo, passportNo, freeTexts);
		reusable.holdOn(2);
		othersPage.submit();
		reusable.holdOn(1);
		cs.takeScreenshot("TSSGMakerSubmitted", report_path, "");
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Others Page : " + toastMessage);
		reusable.holdOn(2);
		reusable.logOut();
		test.log(Status.INFO, "TSSG Maker Journey has been completed");

		//// TSSG Checker Journey

		test.log(Status.INFO, "TSSG Checker Journey started and now, user is on Login Page");
		loginPage.loginApplication(tssgCheckerId, TSSG_Password);
		test.log(Status.INFO, "TSSG Checker User logged in successfully by Valid Credential");

		verifyDashboardPage = reusable.VerifyDashboardPage();
		Assert.assertEquals(verifyDashboardPageByText, verifyDashboardPage,
				"User is unable to navigate on Dashboard Page");
		test.log(Status.INFO, "User navigated on Dashboard Page successfully");
		dashboardPage.approvePendingRequestByChecker(custId, docsPath, remark, apvrComment);
		cs.takeScreenshot("TSSGCheckerAccepted", report_path, "");
		reusable.holdOn(2);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Others Page : " + toastMessage);
		test.log(Status.INFO, "TSSG Checker Journey Completed");
		reusable.holdOn(2);
		reusable.logOut();
		reusable.holdOn(1);
	}
}
