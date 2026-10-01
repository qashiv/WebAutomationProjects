package com.E2logy.gfhotel.inspection.testscript;

import org.testng.annotations.Test;

import com.E2logy.gfhotel.ChecklistPage.CheckListPage;
import com.E2logy.gfhotel.Inspection.pages.InspectionLandingPage;
import com.E2logy.gfhotel.base.BaseTest;

public class InspectionTestScript extends BaseTest {
	@Test
	public void createNewInspection() {
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
		reuseCode.selectDropdown("111111","Location Drop Down");
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
}