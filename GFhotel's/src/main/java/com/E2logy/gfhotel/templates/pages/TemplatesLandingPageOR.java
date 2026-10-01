package com.E2logy.gfhotel.templates.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.E2logy.gfhotel.utilities.WebUtil;

import lombok.Getter;

@Getter
public class TemplatesLandingPageOR {
	
	public TemplatesLandingPageOR (WebUtil wu) {
		PageFactory.initElements(wu.getDriver(), this);// 8 byte
	}
	
	@FindBy(xpath = "//button[contains(text(),' Add Template')]")
	private WebElement addtemplateBT;
	
	@FindBy(xpath = "//input[@name='checklist_name']")
	private WebElement enterValueTemplate;
	
	@FindBy(xpath = "//input[@name='category_name']")
	private WebElement enterValueCategory;
	
	@FindBy(xpath = "//input[@name='task_name']")
	private WebElement enterValueTaskName;
	
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement clickUpdateBT;

}
