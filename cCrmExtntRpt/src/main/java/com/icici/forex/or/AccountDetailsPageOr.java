package com.icici.forex.or;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class AccountDetailsPageOr extends AbstractPage {

	protected AccountDetailsPageOr(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[contains(@id,'mat-input') or @formcontrolname='acNumber']")
	private ExtendedWebElement inputAccountNo;

	@FindBy(xpath = "//span[normalize-space()='Next']//parent::button")
	private ExtendedWebElement btnNext;

	@FindBy(xpath = "//*[text()='Business Details']")
	private ExtendedWebElement TxtBusinessDetails;

	@FindBy(xpath = "//input[@formcontrolname='compName']")
	private ExtendedWebElement inputCompanyName;

	@FindBy(xpath = "//*[contains(text(),'Corporate ID')]")
	private ExtendedWebElement selectCorporateId;

	@FindBy(xpath = "//*[contains(text(),'Contact Person Name')]/..//div//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectContactPerson;

	@FindBy(xpath = "//input[@formcontrolname='otherContactPerson']")
	private ExtendedWebElement inputOtherContactPersonName;

	@FindBy(xpath = "//div[text()='Add New Address']")
	private ExtendedWebElement radioAddNewAddress;

	@FindBy(xpath = "//input[@formcontrolname='comAddres']")
	private ExtendedWebElement inputComAddress;

	@FindBy(xpath = "//input[@formcontrolname='pincode']")
	private ExtendedWebElement inputPinCode;

	@FindBy(xpath = "//input[@formcontrolname='moNumber']")
	private ExtendedWebElement inputMobileNo;

	@FindBy(xpath = "//input[@formcontrolname='email']")
	private ExtendedWebElement inputEmail;

	@FindBy(xpath = "//input[@formcontrolname='LEI']")
	private ExtendedWebElement inputLEI;

	@FindBy(xpath = "//input[@formcontrolname='LEIExpiry']")
	private ExtendedWebElement inputLEIExpiry;

	@FindBy(xpath = "//*[contains(text(),'GST Applicable')]/..//div//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectGstApplicable;

	@FindBy(xpath = "//div[@title='Yes']")
	private ExtendedWebElement optionYes;

	@FindBy(xpath = "//div[@title='No']")
	private ExtendedWebElement optionNo;

	@FindBy(xpath = "//*[text()='GST Number']/parent::div//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectGSTNumber;

	@FindBy(xpath = "//*[@role='option']")
	private ExtendedWebElement optionOther;

	@FindBy(xpath = "//input[@formcontrolname='gstOther']")
	private ExtendedWebElement inputOtherGSTNumber;

	@FindBy(xpath = "//*[text()='GST Status']/parent::div//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectGSTStatus;

	@FindBy(xpath = "//span[text()=' Online ']")
	private ExtendedWebElement radioOnline;

	@FindBy(xpath = "//span[contains(text(),'Online')]//preceding-sibling::span//input")
	private ExtendedWebElement radioOnlineServices;

	@FindBy(xpath = "//span[contains(text(),'OnCall')]//preceding-sibling::span//input")
	private ExtendedWebElement radioOnCallServices;

	@FindBy(xpath = "//span[text()=' OnCall ']")
	private ExtendedWebElement radioOnCall;

	@FindBy(xpath = "//span[text()=' Forward ']")
	private ExtendedWebElement radioForward;

	@FindBy(xpath = "//span[contains(text(),'Forward')]//preceding-sibling::span//input")
	private ExtendedWebElement radioForwardServices;

	@FindBy(xpath = "//span[text()=' NDF ']")
	private ExtendedWebElement radioNDF;

	@FindBy(xpath = "//input[@type='file' and @id='file-input']")
	private List<ExtendedWebElement> BtnUploadForwardDocs;

	@FindBy(xpath = "//button[@class='refresh-icon']")
	private ExtendedWebElement iconRefresh;

	@FindBy(xpath = "//*[@formcontrolname='gstNumber']/following-sibling::mat-error")
	private ExtendedWebElement errorMsgGSTNo;

	@FindBy(xpath = "//*[@formcontrolname='gstNumber']//div[contains(@class,'selected-option-text')]//span")
	private ExtendedWebElement selectedGSTNo;

	@FindBy(xpath = "//*[text()='External']/parent::div/../div//input")
	private List<ExtendedWebElement> uploadForVerifyAPIs;

	@FindBy(xpath = "//*[contains(text(),'Document uploading is inprogress..!')]")
	private ExtendedWebElement msgImageuploading;

	@FindBy(xpath = "//*[@formcontrolname='cPersonName']//div[contains(@class,'selected-option-text')]")
	private ExtendedWebElement selectedOptioncPresonName;

	@FindBy(xpath = "//div[text()='Currency Pairs']")
	private ExtendedWebElement tabCurrencyPair;

	@FindBy(xpath = "//*[text()='Account Number']//parent::div//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectAccountNo;

	@FindBy(xpath = "//span[normalize-space()='Accept']//parent::button")
	private ExtendedWebElement acceptDeclaration;

	@FindBy(xpath = "//input[@value='C']")
	private ExtendedWebElement radioSameAsCommAddress;

	@FindBy(xpath = "//input[@value='P']")
	private ExtendedWebElement radioSameAsPermanentAddress;

	@FindBy(xpath = "//input[@formcontrolname='customerId']")
	private ExtendedWebElement inputCustId;

	@FindBy(xpath = "//input[@formcontrolname='corporateId']")
	private ExtendedWebElement inputCorpId;

	@FindBy(xpath = "//*[text()='Country']//parent::div//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectCountry;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private ExtendedWebElement inputSearchCountry;

	@FindBy(xpath = "//*[text()='Code']//parent::div//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectCountryCode;

	@FindBy(xpath = "//mat-option[@role='option']")
	private ExtendedWebElement optionCountryCode;

	public ExtendedWebElement getOptionCountryCode() {
		return optionCountryCode;
	}

	public ExtendedWebElement getInputSearchCountry() {
		return inputSearchCountry;
	}

	public ExtendedWebElement getSelectCountry() {
		return selectCountry;
	}

	public ExtendedWebElement getInputCorpId() {
		return inputCorpId;
	}

	public ExtendedWebElement getInputCustId() {
		return inputCustId;
	}

	public ExtendedWebElement getRadioSameAsPermanentAddress() {
		return radioSameAsPermanentAddress;
	}

	public ExtendedWebElement getRadioSameAsCommAddress() {
		return radioSameAsCommAddress;
	}

	public ExtendedWebElement getAcceptDeclaration() {
		return acceptDeclaration;
	}

	public ExtendedWebElement getSelectAccountNo() {
		return selectAccountNo;
	}

	public ExtendedWebElement getTabCurrencyPair() {
		return tabCurrencyPair;
	}

	public ExtendedWebElement getSelectedOptioncPersonName() {
		return selectedOptioncPresonName;
	}

	public ExtendedWebElement getMsgImageUploading() {
		return msgImageuploading;
	}

	public List<ExtendedWebElement> getUploadForVerifyAPIs() {
		return uploadForVerifyAPIs;
	}

	public ExtendedWebElement getSelectedGSTNo() {
		return selectedGSTNo;
	}

	public ExtendedWebElement getErrorMsgGSTNo() {
		return errorMsgGSTNo;
	}

	public ExtendedWebElement getInputAccountNo() {
		return inputAccountNo;
	}

	public ExtendedWebElement getRadioForwardServices() {
		return radioForwardServices;
	}

	public ExtendedWebElement getBtnNext() {
		return btnNext;
	}

	public ExtendedWebElement getTxtBusinessDetails() {
		return TxtBusinessDetails;
	}

	public ExtendedWebElement getInputCompanyName() {
		return inputCompanyName;
	}

	public ExtendedWebElement getSelectCorporateId() {
		return selectCorporateId;
	}

	public ExtendedWebElement getSelectContactPerson() {
		return selectContactPerson;
	}

	public ExtendedWebElement getInputOtherContactPersonName() {
		return inputOtherContactPersonName;
	}

	public ExtendedWebElement getRadioAddNewAddress() {
		return radioAddNewAddress;
	}

	public ExtendedWebElement getInputComAddress() {
		return inputComAddress;
	}

	public ExtendedWebElement getSelectCountryCode() {
		return selectCountryCode;
	}

	public ExtendedWebElement getInputPinCode() {
		return inputPinCode;
	}

	public ExtendedWebElement getInputMobileNo() {
		return inputMobileNo;
	}

	public ExtendedWebElement getInputEmail() {
		return inputEmail;
	}

	public ExtendedWebElement getInputLEI() {
		return inputLEI;
	}

	public ExtendedWebElement getInputLEIExpiry() {
		return inputLEIExpiry;
	}

	public ExtendedWebElement getSelectGstApplicable() {
		return selectGstApplicable;
	}

	public ExtendedWebElement getOptionYes() {
		return optionYes;
	}

	public ExtendedWebElement getOptionNo() {
		return optionNo;
	}

	public ExtendedWebElement getSelectGSTNumber() {
		return selectGSTNumber;
	}

	public ExtendedWebElement getOptionOther() {
		return optionOther;
	}

	public ExtendedWebElement getInputOtherGSTNumber() {
		return inputOtherGSTNumber;
	}

	public ExtendedWebElement getSelectGSTStatus() {
		return selectGSTStatus;
	}

	public ExtendedWebElement getRadioOnline() {
		return radioOnline;
	}

	public ExtendedWebElement getRadioOnlineServices() {
		return radioOnlineServices;
	}

	public ExtendedWebElement getRadioOnCallServices() {
		return radioOnCallServices;
	}

	public ExtendedWebElement getRadioOnCall() {
		return radioOnCall;
	}

	public ExtendedWebElement getRadioForward() {
		return radioForward;
	}

	public ExtendedWebElement getRadioNDF() {
		return radioNDF;
	}

	public List<ExtendedWebElement> getBtnUploadForwardDocs() {
		return BtnUploadForwardDocs;
	}

	public ExtendedWebElement getIconRefresh() {
		return iconRefresh;
	}

}
