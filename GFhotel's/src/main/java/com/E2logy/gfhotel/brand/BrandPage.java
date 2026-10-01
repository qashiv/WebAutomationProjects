package com.E2logy.gfhotel.brand;

import org.openqa.selenium.WebDriver;

import com.E2logy.gfhotel.common.pages.CommonPage;
import com.E2logy.gfhotel.utilities.WebUtil;

public class BrandPage extends BrandOR{

	
	WebUtil util;
	WebDriver driver;
	
	public BrandPage(WebUtil util) {
		super(util);
     this.util=util;
		this.driver = util.getDriver();

	}
//	public String addBrand(String brandName) {
//		new CommonPage(util).goToBrands();
//		util.click(addBrandBT);
//        util.sendKeys(addBrandLogo, "C:\\Users\\suraj.p\\Pictures\\Screenshots\\ss.png");
//        util.sendKeys(addBrandName, brandName);
//        String name= util.MyGetText(addBrandName);
//        util.click(addBrandStatusToggleBT);
//        return name;
//	}
	
}
