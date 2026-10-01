package com.E2logy.gfhotel.templates.testscript;

import org.testng.annotations.Test;

import com.E2logy.gfhotel.base.BaseTest;
import com.E2logy.gfhotel.common.pages.CommonPage;
import com.E2logy.gfhotel.templates.pages.TemplatesLandingPage;
import com.E2logy.gfhotel.utilities.WebUtil;

public class TemplatesTestScript extends BaseTest {
	
	@Test
	public void verifyAddingTemplate() throws InterruptedException {
		WebUtil util = WebUtil.getObject();
		CommonPage cp = new CommonPage(util);
		cp.goToTemplates();
		TemplatesLandingPage tlp = new TemplatesLandingPage(util);
		tlp.clickOnAddTemplateButton();
		tlp.enterValueInTemplate();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cp.selectDropdown(cp.getSelectZoneDD(), "Commercial Area");
		Thread.sleep(5000);
		tlp.enterValueInCategoryName();
		Thread.sleep(5000);
		tlp.enterValueInTaskName();
		Thread.sleep(5000);
		tlp.clickOnUpdateButton();
	}

}
