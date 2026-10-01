package com.icici.forex.tests.cob;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.icici.forex.pages.CIBPages;
import com.icici.forex.pages.CobConfigurationPage;
import com.icici.forex.pages.CommonReusableMethods;
import com.icici.forex.pages.DashboardPage;
import com.icici.forex.utils.BaseAbstractTest;
import com.icici.forex.utils.CaptureScreenShotPage;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;

public class SCID_BBM_001 extends BaseAbstractTest {

	/**
	 * @Prerequisite : Customer should be onboarded and need Unique Murex Short Code
	 *               (From TSSG Checker report page > Counterparty Master page)
	 * 
	 * @Scenario_Description: TSSG uploads the bulk blocking for counterparty.
	 */
	private DashboardPage dashboardPage;
	private CommonReusableMethods reusable;
	private CobConfigurationPage cobConfigPage;
	private CIBPages cib;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "COB_TestData", executeColumn = "TUID", executeValue = "SCID_BBM_001", dsUid = "TUID")
	public void bulkBlockCounterpartyCOBJourney(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path =report_path +"Snapshots_BBM001";
		String verifyDashboardPage;
		String verifyLoginPageByText = "Please Login to Continue";
		String TSSGMakerUserId = String.valueOf(args.get("TSSG_MakerUserID"));
		String TSSGPswrd = String.valueOf(args.get("TSSG_Password"));
		String verifyDashboardPageByText = "Dashboard";
		String uploadBulkCounterpartyFile = String.valueOf(args.get("Document Path"));
		String stubLink = String.valueOf(args.get("Stub Link"));

		getTest().log(Status.INFO, "TSSG Maker Journey is started");
		reusable = new CommonReusableMethods(getDriver(), getTest());
		String verifyLoginPage = reusable.VerifyLoginPage();
		Assert.assertEquals(verifyLoginPageByText, verifyLoginPage);
		getTest().log(Status.INFO, "User navigated on Login Page successfully");
		loginPage.loginApplication(TSSGMakerUserId, TSSGPswrd);
		getTest().log(Status.INFO, "TSSG Maker logged in successfully by Valid Credential");

		verifyDashboardPage = reusable.VerifyDashboardPage();
		Assert.assertEquals(verifyDashboardPageByText, verifyDashboardPage,
				"User is unable to navigate on Dashboard Page");
		getTest().log(Status.INFO, "User navigated on Dashboard Page successfully");
		dashboardPage = new DashboardPage(getDriver(), getTest());
		reusable.holdOn(2);
		dashboardPage.clickHamburgerBtn();
		dashboardPage.hoverCobConfiguration();
		cobConfigPage = new CobConfigurationPage(getDriver(), getTest());
		cobConfigPage.uploadBlockBulkCounterparty(uploadBulkCounterpartyFile);
		cs.takeScreenshot("BlockBulkCounterpartyUploaded", report_path, "");
		reusable.holdOn(2);
		reusable.logOut();

		verifyLoginPage = reusable.VerifyLoginPage();
		Assert.assertEquals(verifyLoginPageByText, verifyLoginPage);
		getTest().log(Status.INFO, "User navigated on Login Page successfully");

		getDriver().navigate().to(stubLink);
		reusable.holdOn(1);
		cib = new CIBPages(getDriver(), getTest());
		String accountStatus = cib.getAccountStatusByStub().getText();
		if (accountStatus.contains("Customer is blocked")) {
			getTest().log(Status.INFO, "Customer is blocked. Please contact SM.");
		} else {
			getTest().log(Status.FAIL, "Customer is not blocked");
		}
		cs.takeScreenshot("BlockBulkCounterpartyStatus", report_path, "");
		reusable.holdOn(2);
		reusable.logOut();
		reusable.holdOn(1);
	}
}
