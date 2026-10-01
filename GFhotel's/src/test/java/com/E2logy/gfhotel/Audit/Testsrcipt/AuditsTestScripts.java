package com.E2logy.gfhotel.Audit.Testsrcipt;

import org.testng.annotations.Test;

import com.E2logy.gfhotel.Audits.pages.AuditsPage;
import com.E2logy.gfhotel.base.BaseTest;

public class AuditsTestScripts extends BaseTest {

	@Test()
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

		audpage.selectAuditStatus("Completed");
		reuseCode.clickSummitButton();
		webUtil.threadWait(5000);
		audpage.clickCreateAuditRow();
		webUtil.threadWait(5000);
		webUtil.verifyInnerText(audpage.getPropertyINT(), "Hilton Garden Inn Madison West/Middleton"); 
		System.out.println(audpage.getAdutstatusINT());
		webUtil.verifyInnerText(audpage.getAdutstatusINT(), "Completed");

	}

}
