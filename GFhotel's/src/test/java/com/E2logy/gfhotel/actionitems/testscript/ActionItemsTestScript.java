package com.E2logy.gfhotel.actionitems.testscript;

import org.testng.annotations.Test;

import com.E2logy.gfhotel.ActionItemsPage.ActionItemLandingPage;
import com.E2logy.gfhotel.base.BaseTest;
import com.E2logy.gfhotel.common.pages.CommonPage;
import com.E2logy.gfhotel.utilities.WebUtil;

public class ActionItemsTestScript extends BaseTest {
	
	
	@Test
	
	public void verifyCreatingAnActionItem() {
		WebUtil util = WebUtil.getObject();
		CommonPage cp = new CommonPage(util);
		cp.goToActionItems();
		ActionItemLandingPage ailp = new  ActionItemLandingPage(util);
		ailp.clickOnAddActionItemButton();
		ailp.enterValueInTitle();
		ailp.enterValueInNote();
		cp.selectDropdown(cp.getPropertyDD(),"DEV TEST HOTEL");
		ailp.selectByValueInPriority();
		cp.selectDropdown(cp.getAssignToDD(), "Nikhil admin");
		
	}
}
