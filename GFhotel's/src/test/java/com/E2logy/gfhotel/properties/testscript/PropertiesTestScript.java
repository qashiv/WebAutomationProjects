package com.E2logy.gfhotel.properties.testscript;

import org.testng.annotations.Test;

import com.E2logy.gfhotel.base.BaseTest;
import com.E2logy.gfhotel.common.pages.CommonPage;
import com.E2logy.gfhotel.properties.pages.PropetiesLandingPage;
import com.E2logy.gfhotel.utilities.WebUtil;

public class PropertiesTestScript extends BaseTest {
	
	@Test
	
	public void verifyAddingAProperty() throws InterruptedException {
		WebUtil util = WebUtil.getObject();
		CommonPage cp = new CommonPage(util);
		cp.goToProperties();
	    PropetiesLandingPage plp = new  PropetiesLandingPage(util);
		plp.clickOnAddPropertyButton();
		cp.selectDropdown(cp.getSelectBrandDD(), "Even Hotels");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		plp.enterTheValueInProperty();
		Thread.sleep(5000);
		plp.enterTheValueInPropertyID();
		Thread.sleep(5000);
		plp.enterTheValueInStreetAddressOne();
		Thread.sleep(5000);
		cp.selectDropdown(cp.getSelectCountryDD(), "India");
		Thread.sleep(5000);
		cp.selectDropdown(cp.getSelectStateDD(), "uttar pradesh");
		Thread.sleep(5000);
		plp.enterTheValueInCity();
		Thread.sleep(5000);
		plp.enterTheValueInZipcode();
		
		cp.selectDropdown(cp.getSelectTimezoneDD(), "");
		plp.clickOnAddButton();
		
		
		
	}

}
