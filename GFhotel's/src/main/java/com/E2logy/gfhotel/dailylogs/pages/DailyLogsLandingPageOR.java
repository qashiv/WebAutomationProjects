package com.E2logy.gfhotel.dailylogs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.E2logy.gfhotel.utilities.WebUtil;

public class DailyLogsLandingPageOR {

	public DailyLogsLandingPageOR(WebUtil wu) {
		PageFactory.initElements(wu.getDriver(), this);
		
	}

	@FindBy(xpath="//button[text()='Add Daily Log']")
	protected WebElement dailyLogsBT;
	
	
	@FindBy(xpath="//input[@name='title']")
	protected WebElement title;
	
	
	@FindBy(xpath="//div[text()='Select...']")
	private WebElement SelectProperty;
	
	@FindBy(xpath="//textarea[@name='note']")
	 WebElement Note;
	
	@FindBy(xpath="//button[text()='Add']")
	 WebElement addButton;
	
	@FindBy(xpath = "//label[text()='Property']/parent::div/div")
	protected WebElement selectProperty;
	
	
	
}
