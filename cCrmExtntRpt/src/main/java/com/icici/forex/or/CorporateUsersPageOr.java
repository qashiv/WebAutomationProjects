package com.icici.forex.or;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class CorporateUsersPageOr extends AbstractPage {

	public CorporateUsersPageOr(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//td[text()=' View ' or ' Transacting ']/parent::tr/td//span)[1]")
	private ExtendedWebElement radioAccessCorpUsers;

	@FindBy(xpath = "(//td[normalize-space()='View ' or ' Transacting']//parent::tr)[2]//input")
	private ExtendedWebElement radioAccessCorpUsers2;

	@FindBy(xpath = "//div[text()='Review & Submit']")
	private ExtendedWebElement tabReviewAndSubmit;

	@FindBy(xpath = "//span[contains(text(),'Add New')]")
	private ExtendedWebElement linkAddNew;

	@FindBy(xpath = "//*[text()='User Id']/parent::div//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectUserId;

	@FindBy(xpath = "//*[normalize-space()='Submit']//parent::button")
	private ExtendedWebElement btnSave;

	@FindBy(xpath = "//div[contains(text(),'Corporate User')]")
	private ExtendedWebElement tabCorpUser;

	@FindBy(xpath = "//div[@class='user-dialog']//img[@type='button']")
	private ExtendedWebElement imgCancel;

	@FindBy(xpath = "//button[@class='refresh-icon']")
	private ExtendedWebElement iconRefresh;

	@FindBy(xpath = "//input[@formcontrolname='userId']")
	private ExtendedWebElement inputUserId;

	@FindBy(xpath = "//input[@formcontrolname='userName']")
	private ExtendedWebElement inputUserName;

	@FindBy(xpath = "//input[@formcontrolname='emailId']")
	private ExtendedWebElement inputEmailId;

	@FindBy(xpath = "//input[@formcontrolname='access']")
	private ExtendedWebElement inputAccess;

	@FindBy(xpath = "//span[normalize-space()='Add']//parent::button")
	private ExtendedWebElement btnAdd;

	@FindBy(xpath = "//input[@formcontrolname='otherUserId']")
	private ExtendedWebElement inputOtherUserId;

	@FindBy(xpath = "//*[@formcontrolname='productRestriction']//span[contains(@class,'inner-container')]")
	private ExtendedWebElement radioProductRestriction;

	public ExtendedWebElement getRadioProductRestriction() {
		return radioProductRestriction;
	}

	public ExtendedWebElement getInputOtherUserId() {
		return inputOtherUserId;
	}

	public ExtendedWebElement getBtnAdd() {
		return btnAdd;
	}

	public ExtendedWebElement getInputAccess() {
		return inputAccess;
	}

	public ExtendedWebElement getInputEmail() {
		return inputEmailId;
	}

	public ExtendedWebElement getInputuserName() {
		return inputUserName;
	}

	public ExtendedWebElement getInputuserId() {
		return inputUserId;
	}

	public ExtendedWebElement getIconRefresh() {
		return iconRefresh;
	}

	public ExtendedWebElement getImgCancel() {
		return imgCancel;
	}

	public ExtendedWebElement getTabCorpUser() {
		return tabCorpUser;
	}

	public ExtendedWebElement getRadioAccessCorpUsers() {
		return radioAccessCorpUsers;
	}

	public ExtendedWebElement getRadioAccessCorpUsers2() {
		return radioAccessCorpUsers2;
	}

	public ExtendedWebElement getTabReviewAndSubmit() {
		return tabReviewAndSubmit;
	}

	public ExtendedWebElement getLinkAddNew() {
		return linkAddNew;
	}

	public ExtendedWebElement getSelectUserId() {
		return selectUserId;
	}

	public ExtendedWebElement getBtnSave() {
		return btnSave;
	}

}
