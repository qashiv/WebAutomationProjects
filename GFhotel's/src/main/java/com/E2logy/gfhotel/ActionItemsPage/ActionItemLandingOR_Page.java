package com.E2logy.gfhotel.ActionItemsPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.E2logy.gfhotel.utilities.WebUtil;

import lombok.Getter;
@Getter
public class ActionItemLandingOR_Page {
	
	
	public ActionItemLandingOR_Page(WebUtil wt) {
		PageFactory.initElements(wt.getDriver(), this);// 8 byte
	}
	
	@FindBy(xpath = "//button[text()='Add Action Item']")
	private WebElement addActionItemBT;
	
	@FindBy(xpath = "//input[@name='title']")
    private WebElement enterValueTT;
	
	@FindBy(xpath ="//label[text()='Note']")
	private WebElement enterValueNote;
	
	@FindBy(xpath = "//label[text()='Priority']")
    private WebElement selectByPriority;
}
