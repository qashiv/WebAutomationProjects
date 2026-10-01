package com.E2logy.gfhotel.Dashboard.testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.E2logy.gfhotel.Audits.pages.AuditsPage;
import com.E2logy.gfhotel.ChecklistPage.CheckListPage;
import com.E2logy.gfhotel.Inspection.pages.InspectionLandingPage;
import com.E2logy.gfhotel.base.BaseTest;
import com.E2logy.gfhotel.common.pages.CommonPage;
import com.E2logy.gfhotel.dailylogs.pages.DailyLogsDetailPage;
import com.E2logy.gfhotel.dailylogs.pages.DailyLogsLandingPage;
import com.E2logy.gfhotel.dashboard.HomeLandingPage;
import com.E2logy.gfhotel.utilities.WebUtil;

public class Dashbord extends BaseTest {

	WebUtil weObj = WebUtil.getObject();
	private DailyLogsDetailPage detailspage;
	final String tablePath = "//table[@id='as-react-datatable']";
	String time;
	HomeLandingPage homepage = new HomeLandingPage(weObj);
	
	
	@Test(description = "User is clicking on GF bot icon ")
	public void tc01VerifyDashBord() {

		CommonPage cp = new CommonPage(weObj);
		cp.goToInspections();
		HomeLandingPage homeLandingPage = new HomeLandingPage(weObj);
		homeLandingPage.clickOnGFBotIcon();
		weObj.threadWait(2000);
//		String welcomeText = homeLandingPage.getwelcomeText();
//		weObj.verifText(welcomeText, "WELCOME TO GFBOT", "Welcome text");

	}

	@Test(description = "User is adding inspections from the \"Inspection\" module")
	public void addAndValidateAddedInspection() {

		reuseCode.goToCheckList();
		webUtil.threadWait(5000);
		CheckListPage chlpage = new CheckListPage(webUtil);
		webUtil.verifyInnerText(chlpage.getChecklistheaderINT(), "CHECKLISTS");
		reuseCode.clickPerformbutton();
		webUtil.threadWait(3000);

		webUtil.verifyInnerText(chlpage.getGetPropertyINT(), "Property");
		webUtil.threadWait(5000);
		reuseCode.selectDropdown("Bayside Inn Key Largo", "Property Drop Down");
		webUtil.threadWait(5000);
		chlpage.clickRoomButton();
		chlpage.clickGuestRoomPreventativeLink();
		webUtil.threadWait(5000);
		chlpage.clickStatrtInspectionButton();

		webUtil.verifyInnerText(chlpage.getInspectionpageheaderINT(), "INSPECTION");
		reuseCode.selectDropdown("111111", "Location Drop Down");
		InspectionLandingPage inspecpage = new InspectionLandingPage(webUtil);

		// BATHROOM

		reuseCode.clickContinueButton();
		inspecpage.checkTankWaterCheckBox();
		inspecpage.clickYesButton();
		inspecpage.checkTubDrainCheckBox();
		inspecpage.clickYesButton();
		inspecpage.checkBathTubCheckBox();
		inspecpage.clickYesButton();
		inspecpage.clickYesButton();
		// LIVING

		inspecpage.checkRoomSafeCheckBox();
		inspecpage.clickYesButton();
		inspecpage.checkAlarmClockCheckBox();
		inspecpage.clickNoButton();
		inspecpage.checkSmokedetecterCheckBox();
		inspecpage.clickYesButton();
		inspecpage.checkTVremoteCheckBox();
		inspecpage.clickYesButton();

		// hall

		inspecpage.checkDoorsLatchCheckBox();
		inspecpage.clickNoButton();
		reuseCode.clickContinueButton();
		// review
		inspecpage.clickTimeOut();

		String inpectionDate = inspecpage.selectDate();
		reuseCode.clickSummitButton();

		// Validation
		webUtil.threadWait(5000);
		inspecpage.clickCreatedInspection();
		webUtil.threadWait(5000);

		webUtil.verifyTextContains(webUtil.getText(inspecpage.getIntimeINT()), "23 May");
		webUtil.verifyTextContains(webUtil.getText(inspecpage.getOuttimeINT()), "23 May");

		webUtil.verifyInnerText(inspecpage.getLocationINT(), "111111");
		webUtil.verifyInnerText(inspecpage.getZonetypeINT(), "Room");

	}

	@Test(description = "User is performing Auditing(generally corporate admin or System Admin or Above Property role) from the Audits module")

	public void createAudit() {
		reuseCode.goToAuditTemplates();
		webUtil.threadWait(3000);
		AuditsPage audpage = new AuditsPage(webUtil);
		webUtil.verifyInnerText(audpage.getAudittempleteHeaderINT(), "AUDITS TEMPLATES");
		reuseCode.clickPerformbutton();
		webUtil.threadWait(3000);
		webUtil.verifyInnerText(audpage.getPropertypopheaderINT(), "Audit Checklists");
		reuseCode.selectDropdown("Hilton Garden Inn Madison West/Middleton", "Audits Drop Down");
		webUtil.threadWait(5000);
		audpage.clickHrAuditsLink();

		audpage.clickAuditsStartButton();
		webUtil.threadWait(3000);
		webUtil.verifyInnerText(audpage.getAuditinfoheaderINT(), "AUDIT");
		reuseCode.clickContinueButton();
		audpage.checkAuditCheckBoxes();
		reuseCode.clickContinueButton();
		audpage.clickCompleteOnDate();
		audpage.clickMonthDropDown();
		audpage.enterDateORMonthSelect("July");

		audpage.clickCompleteOnDate();

		audpage.enterDateORMonthSelect("26");
		audpage.selectAuditStatus("Completed");
		reuseCode.clickSummitButton();
		webUtil.threadWait(5000);
		audpage.clickCreateAuditRow();
		webUtil.threadWait(5000);
		webUtil.verifyInnerText(audpage.getPropertyINT(), "Hilton Garden Inn Madison West/Middleton");
		webUtil.verifyInnerText(audpage.getAdutstatusINT(), "Complete");

	}

	@Test(description = "User is adding daily logs from the \"Daily Logs\" module")
	public void DailyLogs() {

		// WebUtil weobj = WebUtil.getObject();
		CommonPage commonPage = new CommonPage(weObj);
		commonPage.goToDailylogs();
		DailyLogsLandingPage DailyLogsLandingPage = new DailyLogsLandingPage(weObj);
		DailyLogsLandingPage.clickDailyLogsBT();
		DailyLogsDetailPage DailyLogsDatailPage = new DailyLogsDetailPage(weObj);
		DailyLogsDatailPage.fillTitle("jhvjvjhg");
		DailyLogsDatailPage.fillNotte("test");
		reuseCode.selectDropdown("Bayside Inn Key Largo", "PropertyDropdown");
		DailyLogsDatailPage.addLogButton();

	}

	@Test(groups= {"SmokeTest"},description = "To verify user is able to see last recently added records based on property")
	public void verifyRecentAddedProperty() {
		 homepage = new HomeLandingPage(weObj);
		homepage.clickOnRecentDailyLogViewMoreLink();
		DailyLogsLandingPage logsPage = new DailyLogsLandingPage(weObj);
		logsPage.addDailyLogsInfo("jhfahjhak", "Buffalo Niagara Marriott", "Test Note");
		int countColumnNum = weObj.getColumnNumberByColumnName(tablePath, "Property");
		String columnData = weObj.getColumnDataByColumnNumber(tablePath, countColumnNum + 1);
		weObj.verifyTextContains(columnData, "Buffalo Niagara Marriott");
		int countColumn = weObj.getColumnNumberByColumnName(tablePath, "Technician");
		String column = weObj.getColumnDataByColumnNumber(tablePath, countColumn + 1);
		if (column.isEmpty() == false) {
			Assert.assertEquals(column.isEmpty(), false);
		} else {
			Assert.assertEquals(column.isEmpty(), true);
		}
		
		int columnCount = weObj.getColumnNumberByColumnName(tablePath, "Date Time");
		 time = weObj.getColumnDataByColumnNumber(tablePath, columnCount + 1);
		homepage.clickOnGFBotIcon();
		homepage.validateTheSelectProperties("Buffalo Niagara Marriott");

	}

	@Test(groups= {"SmokeTest"})
	public void timeDisplayingOnDashboardCard() {
		
//		homepage.clickOnGFBotIcon();
		 homepage = new HomeLandingPage(weObj);
		CommonPage commonPage = new CommonPage(weObj);
		commonPage.goToDailylogs();
		int columnCount = weObj.getColumnNumberByColumnName(tablePath, "Date Time");
		String actualTime = weObj.getColumnDataByColumnNumber(tablePath, columnCount + 1);
		homepage.clickOnGFBotIcon();
		homepage.clickOnRecentDailyLogViewMoreLink();
		int columnCount1 = weObj.getColumnNumberByColumnName(tablePath, "Date Time");
		String expectedTime = weObj.getColumnDataByColumnNumber(tablePath, columnCount1 + 1);
		weObj.verifyTextContains(actualTime, expectedTime);
		
	}
	
	
	@Test()
	public void verifyInspectionCount() throws InterruptedException{
		
		 homepage = new HomeLandingPage(weObj);
		 Thread.sleep(1000);
		 homepage.clickOnSelectProperties();
		 int expectedCount= homepage.countOfRecentInspectenlist();
		 homepage.clickOnRecentInspectionsViewMoreLink();
		 int actualCount= weObj.getTableRowCount(tablePath);
		 Assert.assertEquals(expectedCount, actualCount);
	}
	
	@Test(description = "Verify that user is able to see Technicians and Property names")
	public void VerifyPropertyAndTechniciansHeader() {
		detailspage = new DailyLogsDetailPage(weObj);
		boolean Propertystatus = detailspage.VerifyPropertyHeader("Property");
		System.out.println("Property Values visible :-" + Propertystatus);
		Assert.assertTrue(Propertystatus, "Property  values is visible ");

		boolean TechniciansStatus = detailspage.VerifyPropertyHeader("Property");
		System.out.println("Technicians Values visible :-" + TechniciansStatus);

		Assert.assertTrue(TechniciansStatus, "Technicians values are visible");
	}
}
