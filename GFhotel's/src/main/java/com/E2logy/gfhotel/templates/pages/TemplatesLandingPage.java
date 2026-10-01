package com.E2logy.gfhotel.templates.pages;

import com.E2logy.gfhotel.utilities.WebUtil;

public class TemplatesLandingPage extends TemplatesLandingPageOR{
	
	   WebUtil ut;
		
		public TemplatesLandingPage(WebUtil ut) {
			super(ut);
			this.ut = ut;
		}
		
		public void clickOnAddTemplateButton() {
			ut.click(getAddtemplateBT());
		}
		
		public void enterValueInTemplate() {
			ut.sendKeys(getEnterValueTemplate(), "Enter");
		}
		
		public void enterValueInCategoryName() {
			ut.sendKeys(getEnterValueCategory(), "High profile");
		}
		
		public void enterValueInTaskName() {
			ut.sendKeys(getEnterValueTaskName(), "work");
		}
		
		public void clickOnUpdateButton() {
			ut.click(getClickUpdateBT());
		}

}
