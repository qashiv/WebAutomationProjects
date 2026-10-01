package com.E2logy.gfhotel.properties.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.E2logy.gfhotel.utilities.WebUtil;

import lombok.Getter;
@Getter
public class PropertiesLandingOR_Page{
	
	
	public PropertiesLandingOR_Page(WebUtil wt) {
		PageFactory.initElements(wt.getDriver(), this);// 8 byte
	}
	
	@FindBy(xpath = "//button[text()='Add Property']")
	private WebElement addpropertyBT;
	
	@FindBy(xpath = "//label[text()='Property']")
	private WebElement enterValueInProperty;
	
	@FindBy(xpath = "//label[text()='Property ID']")
    private WebElement enterValueInPropertyID;
	
	@FindBy(xpath = "//label[contains(text(),'Street Address 1')]")
    private WebElement enterValueSA1;
	
	@FindBy(xpath = "//label[contains(text(),'City')]")
	private WebElement enterValueCity;
	
	@FindBy(xpath ="//label[contains(text(),'Zip code')]")
	private WebElement enterValueZipcode;
	
	@FindBy(xpath ="//button[contains(text(),'ADD')]")
	private WebElement addBT;
}
