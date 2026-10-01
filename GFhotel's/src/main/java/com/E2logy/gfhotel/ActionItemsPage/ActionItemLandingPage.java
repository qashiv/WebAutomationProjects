package com.E2logy.gfhotel.ActionItemsPage;

import com.E2logy.gfhotel.utilities.WebUtil;

public class ActionItemLandingPage extends ActionItemLandingOR_Page {
	
	
    WebUtil ut;
	
	public  ActionItemLandingPage (WebUtil ut) {
		super(ut);
		this.ut = ut;
	}
	
	public void clickOnAddActionItemButton() {
		ut.click(getAddActionItemBT());
	}
	
	public void enterValueInTitle() {
		ut.sendKeys(getEnterValueTT(), "Qa");
		
	}
	
	public void enterValueInNote() {
		ut.sendKeys(getEnterValueNote(), "Searching of Element");
	}
	
	public void selectByValueInPriority() {
		ut.sendKeys(getSelectByPriority(), "High");
	}

}
