package com.icici.forex.tests.cob;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.icici.forex.pages.CommonReusableMethods;
import com.icici.forex.pages.DashboardPage;
import com.icici.forex.pages.UserDetailsPage;
import com.icici.forex.utils.BaseAbstractTest;
import com.icici.forex.utils.CaptureScreenShotPage;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;

public class SCID_TSSG_001_Test extends BaseAbstractTest {

	/**
	 * @Scenario_Description -- TSSG initiates on call(CTS) Journey for Ad hoc
	 *                       customer (Margin-No, Murex id-No BRCPTY)
	 * 
	 *                       #DONE
	 */
	private DashboardPage dashboardPage;
	private UserDetailsPage userDetailsPage;
	private CommonReusableMethods reusable;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "COB_TestData", executeColumn = "TUID", executeValue = "SCID_TSSG_001", dsUid = "TUID")
	public void SCID_TSSG_001_Adhoc_Customer_Onboarding_Journey_E2E(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = report_path + "SCID_TSSG_001_Test";
		String toastMessage, verifyDashboardPage;
		String verifyLoginPageByText = "Please Login to Continue";
		String tssgMakerUserId = String.valueOf(args.get("TSSG_MakerUserID"));
		String tssgPassword = String.valueOf(args.get("TSSG_Password"));
		String verifyDashboardPageByText = "Dashboard";
		String onboardingType = String.valueOf(args.get("Onboarding Type"));
//		String accountNo = String.valueOf(args.get("Account Number"));
//		String branchSolId = String.valueOf(args.get("Branch SOL ID"));
		String companyName = String.valueOf(args.get("Company Name"));
		String verifyUserDetailsPageByText = "Non-Account holder";

		test.log(Status.INFO, "TSSG Journey started");
		///// TSSG - OnCall CTS Journey
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
		dashboardPage.createNewRequest(onboardingType);
		test.log(Status.INFO, "User started to Create New Request");

		String verifyUserDetailsPage = reusable.verifyUserDetailsPage();
		Assert.assertEquals(verifyUserDetailsPageByText, verifyUserDetailsPage,
				"Unable to navigate on User Details Page");
		test.log(Status.INFO, "User is navigated on User Details Page successfully");
		userDetailsPage = new UserDetailsPage(getDriver(), test);
//		userDetailsPage.provideAccHolderDetailsAndSubmit(accountNo, branchSolId);
		userDetailsPage.provideNonAccHolderDetailsAndSubmit(companyName);
		test.log(Status.INFO, "User filled user details and submitted successfully");
		reusable.holdOn(2);
		cs.takeScreenshot("OnCallCustIdCaptured", report_path, "");
		toastMessage = reusable.toastMessage();
		if (toastMessage.contains("Counterparty Registered Successfully")) {
			test.log(Status.PASS, "User Details Page : " + toastMessage);
		} else {
			test.log(Status.FAIL, "User Details Page : " + toastMessage);
		}
		reusable.holdOn(2);
		reusable.logOut();
		test.log(Status.INFO, "TSSG Journey completed for Adhoc customer");
		reusable.holdOn(1);
	}
}
