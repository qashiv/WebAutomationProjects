package com.icici.forex.or;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class CommonReusableMethodsOr extends AbstractPage {

	protected CommonReusableMethodsOr(WebDriver driver) {
		super(driver);
	}

	public ExtendedWebElement getBtnSaveAndContinue() {
		return btnSaveAndContinue;
	}

	public List<ExtendedWebElement> getSelectOptions() {
		return selectOptions;
	}

	public List<ExtendedWebElement> getToastMessages() {
		return toastMessages;
	}

	public ExtendedWebElement getToastMessage() {
		return toastMessage;
	}

	public ExtendedWebElement getRadioSameAsCommAdds() {
		return radioSameAsCommAdds;
	}

	public ExtendedWebElement getRadioSameAsPermanentAdds() {
		return radioSameAsPermanentAdds;
	}

	public ExtendedWebElement getRadioAddNewAddress() {
		return radioAddNewAddress;
	}

	public ExtendedWebElement getBtnLogout() {
		return btnLogout;
	}

	public ExtendedWebElement getLabelLoginPage() {
		return labelLoginPage;
	}

	public ExtendedWebElement getLabelDashboard() {
		return labelDashboard;
	}

	public ExtendedWebElement getLabelCurrencyPair() {
		return labelCurrencyPair;
	}

	public ExtendedWebElement getLabelAccountDetailsPage() {
		return labelAccountDetailsPage;
	}

	public ExtendedWebElement getLabelCorporateUsersPage() {
		return labelCorporateUsersPage;
	}

	public ExtendedWebElement getLabelReviewSubmitPage() {
		return labelReviewSubmitPage;
	}

	public ExtendedWebElement getLabelCurrencyPairsMargin() {
		return labelCurrencyPairsMargin;
	}

	public ExtendedWebElement getLabelAdditionalFeatures() {
		return labelAdditionalFeatures;
	}

	public ExtendedWebElement getLabelNonAccountHolder() {
		return labelNonAccountHolder;
	}

	public ExtendedWebElement getTriggerProfile() {
		return triggerProfile;
	}

	public ExtendedWebElement getTxtReqId() {
		return txtReqId;
	}

	public ExtendedWebElement getOnboardMessage() {
		return onboardMessage;
	}

	public ExtendedWebElement getBtnNo() {
		return btnNo;
	}

	public ExtendedWebElement getBtnYes() {
		return btnYes;
	}

	public ExtendedWebElement getClosePopUp() {
		return closePopUp;
	}

	public ExtendedWebElement getPopUpMsg() {
		return popUpMsg;

	}

	@FindBy(xpath = "//div[@id='toast-container']")
	private ExtendedWebElement popUpMsg;
	
	@FindBy(xpath = "//button[@aria-label='Close']")
	private ExtendedWebElement closePopUp;

	@FindBy(xpath = "//span[normalize-space()='Yes']//parent::button")
	private ExtendedWebElement btnYes;

	@FindBy(xpath = "//span[normalize-space()='No']//parent::button")
	private ExtendedWebElement btnNo;

	@FindBy(xpath = "//p[text()='You have been on-boarded successfully']")
	private ExtendedWebElement onboardMessage;

	@FindBy(xpath = "//label[text()='Request Id']//following-sibling::p")
	private ExtendedWebElement txtReqId;

	@FindBy(xpath = "//div[@class='mat-menu-trigger profile']")
	private ExtendedWebElement triggerProfile;

	@FindBy(xpath = "//span[normalize-space()='Save & Continue']//parent::button")
	private ExtendedWebElement btnSaveAndContinue;

	@FindBy(xpath = "//div[contains(@class , 'options-inner-container')]//mat-option")
	private List<ExtendedWebElement> selectOptions;

	@FindBy(xpath = "//div[@id='toast-container']")
	private List<ExtendedWebElement> toastMessages;

	@FindBy(xpath = "//div[@role='alert']")
	private ExtendedWebElement toastMessage;

	@FindBy(xpath = "//input[@class='mat-radio-input' and @value='C']")
	private ExtendedWebElement radioSameAsCommAdds;

	@FindBy(xpath = "//input[@class='mat-radio-input' and @value='P']")
	private ExtendedWebElement radioSameAsPermanentAdds;

	@FindBy(xpath = "//input[@class='mat-radio-input' and @value='N']")
	private ExtendedWebElement radioAddNewAddress;

	@FindBy(xpath = "//div[text()='Logout']")
	private ExtendedWebElement btnLogout;

	@FindBy(xpath = "//*[text()='Please Login to Continue']")
	private ExtendedWebElement labelLoginPage;

	@FindBy(xpath = "//*[text()='Dashboard ']")
	private ExtendedWebElement labelDashboard;

	@FindBy(xpath = "//*[text()='Please select Currency Pair']")
	private ExtendedWebElement labelCurrencyPair;

	@FindBy(xpath = "//*[text()='Please provide below details']")
	private ExtendedWebElement labelAccountDetailsPage;

	@FindBy(xpath = "//*[contains(text(),'select the Corporate Users')]")
	private ExtendedWebElement labelCorporateUsersPage;

	@FindBy(xpath = "//*[contains(text(),'Please Review the below details')]")
	private ExtendedWebElement labelReviewSubmitPage;

	@FindBy(xpath = "//*[contains(text(),' Please select Currency Pairs ')]")
	private ExtendedWebElement labelCurrencyPairsMargin;

	@FindBy(xpath = "//*[text()='Please select Additional features']")
	private ExtendedWebElement labelAdditionalFeatures;

	@FindBy(xpath = "//*[text()=' Non-Account holder ']")
	private ExtendedWebElement labelNonAccountHolder;
}
