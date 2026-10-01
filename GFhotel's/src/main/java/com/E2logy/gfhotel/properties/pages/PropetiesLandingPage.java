package com.E2logy.gfhotel.properties.pages;

import com.E2logy.gfhotel.utilities.WebUtil;

public class PropetiesLandingPage extends PropertiesLandingOR_Page {
	
	
    WebUtil ut;
	
	public PropetiesLandingPage(WebUtil ut) {
		super(ut);
		this.ut = ut;
	}
	
	public void clickOnAddPropertyButton() {
		ut.click(getAddpropertyBT());
	}
	
	public void enterTheValueInProperty() {
		ut.sendKeys(getEnterValueInProperty(), "Taj");
		
	}
	
	public void enterTheValueInPropertyID(){
		ut.sendKeys(getEnterValueInPropertyID(), "42467765");    
	}
	
	public void enterTheValueInStreetAddressOne() {
		ut.sendKeys(getEnterValueSA1(), "Noida Sector 62");
	}
	
	public void enterTheValueInCity() {
		ut.selectByValueAttribute(getEnterValueCity(), "Noida");
	}
	
	public void enterTheValueInZipcode() {
		ut.sendKeys(getEnterValueZipcode(), "201309");
	}
	
	public void clickOnAddButton() {
		ut.click(getAddBT());
	}
	

}
