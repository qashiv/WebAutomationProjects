package com.E2logy.gfhotel.MORS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.E2logy.gfhotel.utilities.WebUtil;

import lombok.Getter;

@Getter
public class MrosLandingOR_Page {
	
	
	
	public MrosLandingOR_Page(WebUtil wt) {
		PageFactory.initElements(wt.getDriver(), this);// 8 byte
	}
	
	
	@FindBy(xpath = "//button[text()='Add MRO']")
	private WebElement addMroBT;
	
	@FindBy(xpath = "//input[@name='title']")
	private WebElement enterTitle;
	
	@FindBy(xpath = "//label[text()='Priority']/parent::div//div[text()='Select...']")
	private WebElement priorityDD;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement fileUpload;
	
	@FindBy(xpath = "//button[text()='Add']")
	private WebElement addButton;
	
	@FindBy(xpath="//button[text()='View Category']")
	private WebElement viewCategory;
	
	
}
