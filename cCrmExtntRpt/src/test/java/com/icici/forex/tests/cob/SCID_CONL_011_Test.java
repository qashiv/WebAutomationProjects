package com.icici.forex.tests.cob;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.icici.forex.pages.CobConfigurationPage;
import com.icici.forex.pages.CommonReusableMethods;
import com.icici.forex.pages.DashboardPage;
import com.icici.forex.utils.BaseAbstractTest;
import com.icici.forex.utils.CaptureScreenShotPage;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;

public class SCID_CONL_011_Test extends BaseAbstractTest {

	/**
	 * To check the scenario where TSSG user generate report by selecting different
	 * filter.
	 */

	private CommonReusableMethods reusable;
	private DashboardPage dashboardPage;
	private CobConfigurationPage cobConfigPage;
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = "data_source/Forex_TestData.xlsx", sheet = "COB_TestData", executeColumn = "TUID", executeValue = "SCID_CONL_011", dsUid = "TUID")
	public void generateReportByDiffFilters(HashMap<String, String> args) {

		if (args.get("Execute").equals("N")) {
			throw new SkipException("Skipping the Test Scenario as execute mode is No");
		}
		report_path = report_path + "Snapshots_CONL011";
		String verifyDashboardPage;
		String verifyLoginPageByText = "Please Login to Continue";
		String verifyDashboardPageByText = "Dashboard";
		String tssgMakerUserId = String.valueOf(args.get("TSSG_MakerUserID"));
		String tssgPassword = String.valueOf(args.get("TSSG_Password"));
		String columnNames = String.valueOf(args.get("Filter By Column Name"));

		test.log(Status.INFO, "TSSG Journey started...");
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
		cobConfigPage = new CobConfigurationPage(getDriver(), test);
		cobConfigPage.filterReportByDiffColumns(columnNames);
		cs.takeScreenshot("FilteredReportByColumnName", report_path, "");
		cobConfigPage.filterReportByDate("1", "30");
		cs.takeScreenshot("FilteredReportByDate", report_path, "");
		test.log(Status.INFO, "Report has been filtered by different column and duration");
		reusable.holdOn(2);
		reusable.logOut();
		reusable.holdOn(1);
	}
}
