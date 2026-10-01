package com.icici.forex.or;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class ReviewAndSubmitPageOr extends AbstractPage {

	protected ReviewAndSubmitPageOr(WebDriver driver) {
		super(driver);
	}

	public ExtendedWebElement getBtnEdit() {
		return btnEdit;
	}

	public ExtendedWebElement getBtnBack() {
		return btnBack;
	}

	public ExtendedWebElement getBtnAddAttachments() {
		return btnAddAttachments;
	}

	public ExtendedWebElement getInputComments() {
		return InputComments;
	}

	public ExtendedWebElement getBtnApprove() {
		return btnApprove;
	}

	public ExtendedWebElement getCheckDisclaimer() {
		return checkDisclaimer;
	}

	public ExtendedWebElement getLinkTermsCondition() {
		return linkTermsCondition;
	}

	public ExtendedWebElement getAcceptTermsCondition() {
		return acceptTermsCondition;
	}

	public ExtendedWebElement getDeclineTermsCondition() {
		return declineTermsCondition;
	}

	public ExtendedWebElement getBtnSubmit() {
		return btnSubmit;
	}

	public ExtendedWebElement getTabReviewSubmit() {
		return tabReviewSubmit;
	}

	public ExtendedWebElement getReqIdFromAlert() {
		return reqIdFromAlert;
	}

	public ExtendedWebElement getBtnYes() {
		return btnYes;
	}

	@FindBy(xpath = "//span[normalize-space()='Yes']//parent::button")
	private ExtendedWebElement btnYes;

	@FindBy(xpath = "//div[contains(text(),'Application Form Submitted Successfully.')]")
	private ExtendedWebElement reqIdFromAlert;

	@FindBy(xpath = "(//button[contains(@class,'button1')])[2]")
	private ExtendedWebElement btnEdit;

	@FindBy(xpath = "(//button[contains(@class,'button1')])[3]")
	private ExtendedWebElement btnBack;

	@FindBy(xpath = "//*[text()='browse']//ancestor::div[@class='upload-file-text']//input")
	private ExtendedWebElement btnAddAttachments;

	@FindBy(xpath = "//textarea[@name='comments']")
	private ExtendedWebElement InputComments;

	@FindBy(xpath = "//span[normalize-space()='Approve']/parent::button")
	private ExtendedWebElement btnApprove;

	@FindBy(xpath = "//*[text()='Disclaimer']/parent::div//mat-checkbox[not (@id='termsid')]//label")
	private ExtendedWebElement checkDisclaimer;

	@FindBy(xpath = "//span[@id='termsCondition']")
	private ExtendedWebElement linkTermsCondition;

	@FindBy(xpath = "//*[text()=' Accept ']/parent::button")
	private ExtendedWebElement acceptTermsCondition;

	@FindBy(xpath = "//*[text()=' Decline ']/parent::button")
	private ExtendedWebElement declineTermsCondition;

	@FindBy(xpath = "//*[text()=' Submit ']/parent::button")
	private ExtendedWebElement btnSubmit;

	@FindBy(xpath = "//*[text()='Review & Submit']")
	private ExtendedWebElement tabReviewSubmit;

}
