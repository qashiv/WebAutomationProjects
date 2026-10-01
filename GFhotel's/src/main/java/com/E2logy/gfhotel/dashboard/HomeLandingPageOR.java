package com.E2logy.gfhotel.dashboard;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.E2logy.gfhotel.utilities.WebUtil;

public class HomeLandingPageOR {

	public HomeLandingPageOR(WebUtil wu) {
		PageFactory.initElements(wu.getDriver(), this);// 8 byte
		
	}

	@FindBy(xpath="//h1[text()='WELCOME TO GFBOT']")
	protected WebElement welcometext;
	
	@FindBy(xpath = "//img[@alt='Site Logo']")
	protected WebElement gfBotIcon;
	
@FindBy(xpath="//h6[text()='Recent Daily Log']/a")
protected WebElement RecentDailyLogViewMoreLink ;

@FindBy(xpath="//h6[text()='Recent Inspections']/a")
protected WebElement RecentInspectionViewMoreLink ;

@FindBy(xpath = "//div[text()='All Properties']")
protected WebElement clickOnProperties;

@FindBy(xpath= "//div[contains(@id,'react-select')]")
protected List<WebElement> selectTheProperties;

@FindBy(xpath= "//h6[text()='Recent Inspections']/parent::div/parent::div//table//tr")
protected List<WebElement> elementUnderRecentInspections;




}

