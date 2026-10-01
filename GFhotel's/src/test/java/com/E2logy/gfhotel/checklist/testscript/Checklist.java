package com.E2logy.gfhotel.checklist.testscript;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.E2logy.gfhotel.ChecklistPage.CheckListPage;
import com.E2logy.gfhotel.base.BaseTest;
import com.E2logy.gfhotel.common.pages.CommonPage;
import com.E2logy.gfhotel.utilities.WebUtil;

public class Checklist extends BaseTest {

	final String tablePath = "//table[@id='as-react-datatable']";

	@Test(description = "User is adding checklist through \"Add Checklist\" button")
	public void addChecklist() {
		WebUtil util = WebUtil.getObject();
		CheckListPage cp = new CheckListPage(util);
		cp.addingChecklist("hottooooooooport", "Chase on The Lake", "Commercial Area");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		int countColumnNum = util.getColumnNumberByColumnName(tablePath, "Checklist");
		String columnData = util.getColumnDataByColumnNumber(tablePath, countColumnNum + 1);
		util.verifyTextContains(columnData, "hottooooooooport");
	}
	
	@Test(description ="In detail page of checklist, user will able to add Category and Task name as per their choice by clicking \"Add Category\" button")
	public void verifyTC002DetailPageOfChecklist(){
		WebUtil util = WebUtil.getObject();
		CheckListPage cp = new CheckListPage(util);
		cp.AddCategoryAndTask("smooth", "myWork");
		cp.clickOnUpdateButton();
		cp.clickOnPerformButton();
		cp.validateTheCategoeryAndTaskName();
	}

	public void verifyTC003DetailPageOfChecklist(){
		WebUtil util = WebUtil.getObject();
		CheckListPage cp = new CheckListPage(util);
		cp.addingChecklist("test", "Chase on The Lake", "Commercial Area");
		
	}

	@Test
	public void verifyTC004ImportTemplates(){
		WebUtil util = WebUtil.getObject();
		CommonPage cp = new CommonPage(util);
		CheckListPage cl = new CheckListPage(util);
		cp.goToCheckList();
		cl.importTemplates("Master(G1): Guest Room Preventative Maintenance");
		util.threadWait(2000);
		cp.goToTemplates();
		for(int i=0; i<cl.getListOfTemplates().size();i++) {
			
		WebElement weObj =	cl.getListOfTemplates().get(i);
		if(weObj.getText().contains("Master(G1): Guest Room Preventative Maintenance")) {
			util.verifyTextContains(weObj.getText(), "Master(G1): Guest Room Preventative Maintenance");
			weObj.click();
//			String templateName= util.MyGetText(cl.getTemplateName());
//			util.verifyTextContains(templateName, "Master(G1): Guest Room Preventative Maintenance");
			util.clear(cl.getTemplateName());
//			util.sendKeys(weObj, templateName);
			cp.selectDropdown(cl.getSelectProperty(), "DEV TEST HOTEL");
			util.click(cl.getClickOnUpdateBT());
		}
		}
	}

	@Test
	public void clickOnToggleButton() {
		WebUtil util = WebUtil.getObject();
		CheckListPage cl = new CheckListPage(util);
		cl.clickOnActiveToggle();	
		
	}
	
	@Test       
	public void filters() {
		WebUtil util = WebUtil.getObject();
		CheckListPage cl = new CheckListPage(util);
		cl.checkListFilterList();
		
	}
}
