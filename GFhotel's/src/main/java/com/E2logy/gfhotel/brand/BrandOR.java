package com.E2logy.gfhotel.brand;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.E2logy.gfhotel.utilities.WebUtil;

public class BrandOR {

	WebDriver driver;
	public BrandOR(WebUtil wt) {
		driver=wt.getDriver();
		PageFactory.initElements(driver, this);
	}// 8 byte
	
	@FindBy(xpath="//button[text()='Add Brand']")
	protected WebElement addBrandBT;
	
	@FindBy(xpath="//input[@type='file']")
	protected WebElement addBrandLogo;
	
		@FindBy(xpath="//input[@name='customer_name']")
	protected WebElement addBrandName;
		
		@FindBy(xpath="//div[@class='az-toggle on']")
		protected WebElement addBrandStatusToggleBT;
		
		

		@FindBy(xpath="//button[text()='Add']")
		protected WebElement addBT;
		
		@FindBy(xpath="//label[text()='Brand']/parent::div/div")
		protected WebElement selectBrand;
		
		
}
