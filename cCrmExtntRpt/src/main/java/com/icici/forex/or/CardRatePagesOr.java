package com.icici.forex.or;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class CardRatePagesOr extends AbstractPage {

	public CardRatePagesOr(WebDriver driver) {
		super(driver);
	}

	protected By findIconAttach = By.xpath("//p[text()='IFRA']//parent::div//input");
	protected By txtPendingForApr = By.xpath("//td[contains(@title,'Pending for approval')]");

	@FindBy(xpath = "//div[text()='Domestic']//parent::div[@role='tab']")
	private ExtendedWebElement tabDomestic;

	@FindBy(xpath = "//div[text()='IBG']//parent::div[@role='tab']")
	private ExtendedWebElement tabIBG;

	@FindBy(xpath = "//*[contains(text(),'My requests')]//parent::a")
	private ExtendedWebElement btnMyRequest;

	@FindBy(xpath = "//*[contains(text(),'Pending approval')]//parent::a")
	private ExtendedWebElement btnPendingApproval;

	@FindBy(xpath = "//p[text()='Rate Source']")
	private ExtendedWebElement labelRateSource;

	@FindBy(xpath = "//img[starts-with(@class,'edit-icon')]")
	private ExtendedWebElement iconEdit;

	@FindBy(xpath = "//img[starts-with(@class,'cardRateIcon')]")
	private ExtendedWebElement iconAuditTrail;

	@FindBy(xpath = "//input[@id='chk_automode-input']")
	private ExtendedWebElement radioAutoFetchMode;

	@FindBy(xpath = "//input[@id='chk_manualmode-input']")
	private ExtendedWebElement radioManualMode;

	@FindBy(xpath = "//input[@id='chk_ifra-input']")
	private ExtendedWebElement radioIFRA;

	@FindBy(xpath = "//*[@formcontrolname='auto_ifra_currencyPairId']//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectIFRACurrencyPair;

	@FindBy(css = "input.search-input")
	private ExtendedWebElement searchCurrencyPair;

	@FindBy(xpath = "//mat-checkbox[contains(@id,'mat-checkbox')]//input")
	private ExtendedWebElement radioCurrencyPair;

	@FindBy(xpath = "//input//following-sibling::img[@alt='cancel']")
	private ExtendedWebElement clearSearchedCurrencyPair;

	@FindBy(xpath = "//img[@alt='cancel']")
	private ExtendedWebElement cancelSelectedCurrencyPair;

	@FindBy(css = "input#chk_jpmc-input")
	private ExtendedWebElement radioJPMC;

	@FindBy(xpath = "//*[@formcontrolname='auto_jpmc_currencyPairId']//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectJPMCCurrencyPair;

	@FindBy(xpath = "//*[@formcontrolname='manual_currencyPairId']//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectManualCurrencyPair;

	@FindBy(xpath = "//span[normalize-space()='Back']//parent::button")
	private ExtendedWebElement btnBack;

	@FindBy(xpath = "//span[normalize-space()='Update']//parent::button")
	private ExtendedWebElement btnUpdate;

	@FindBy(xpath = "//p[contains(text(),'Rate Source -')]")
	private ExtendedWebElement labelRateSourceUpdate;

	@FindBy(xpath = "//p[text()='Refresh Rate']")
	private ExtendedWebElement labelRefreshRate;

	@FindBy(xpath = "//p[contains(text(),'Refresh Rate -')]")
	private ExtendedWebElement labelRefreshRateUpdate;

	@FindBy(xpath = "//*[text()='Status']//parent::div//input[@role='switch']")
	private ExtendedWebElement toggleStatus;

	@FindBy(xpath = "//input[@value='Daily']")
	private ExtendedWebElement radioDaily;

	@FindBy(xpath = "//input[@value='Hourly']")
	private ExtendedWebElement radioHourly;

	@FindBy(xpath = "//input[@value='Custom']")
	private ExtendedWebElement radioCustom;

	@FindBy(xpath = "//*[@formcontrolname='timeSelection']//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectCustomTime;

	@FindBy(xpath = "//div[@class='option-text']")
	private ExtendedWebElement optionCustomTime;

	@FindBy(xpath = "//input[@placeholder='From']//parent::div//following-sibling::div//mat-icon")
	private ExtendedWebElement iconPublishTimeFrom;

	@FindBy(xpath = " //input[@placeholder='To']//parent::div//following-sibling::div//mat-icon")
	private ExtendedWebElement iconPublishTimeTo;

	@FindBy(xpath = "//input[@formcontrolname='hours' and not(@readonly='true')]")
	private ExtendedWebElement inputHours;

	@FindBy(xpath = "//input[@formcontrolname='minutes' and not(@readonly='true')]")
	private ExtendedWebElement inputMinutes;

	@FindBy(xpath = "//span[text()='AM']//parent::button[@name='am_pm']")
	private ExtendedWebElement btnAM;

	@FindBy(xpath = "//span[text()='PM']//parent::button[@name='am_pm']")
	private ExtendedWebElement btnPM;

	@FindBy(xpath = "//span[normalize-space()='Cancel']//parent::button")
	private ExtendedWebElement btnCancel;

	@FindBy(xpath = "//span[normalize-space()='Ok']//parent::button")
	private ExtendedWebElement btnOk;

	@FindBy(xpath = "//span[@title='Input Data Sheet']")
	private ExtendedWebElement btnInputDataSheet;

	@FindBy(xpath = "//p[text()='Input Data Sheet - Checker']")
	private ExtendedWebElement labelInputDataSheet;

	@FindBy(xpath = "//textarea[@formcontrolname='remarks']")
	private ExtendedWebElement inputComments;

	@FindBy(xpath = "//span[normalize-space()='Accept']//parent::button")
	private ExtendedWebElement btnAccept;

	@FindBy(xpath = "//span[normalize-space()='Reject']//parent::button")
	private ExtendedWebElement btnReject;

	@FindBy(xpath = "//p[normalize-space()='IFRA Template.xls']//span")
	private ExtendedWebElement iconDownloadIFRATemp;

	@FindBy(xpath = "//p[normalize-space()='JPMC Template.xls']//span")
	private ExtendedWebElement iconDownloadJPMCTemp;

	@FindBy(xpath = "//span[normalize-space()='Fetch Rate']//parent::button")
	private ExtendedWebElement btnFetchRate;

	@FindBy(xpath = "//span[contains(text(),'Upload File')]/preceding-sibling::span")
	private ExtendedWebElement radioUploadFile;

	@FindBy(xpath = "//p[text()='IFRA']//parent::div//input")
	private ExtendedWebElement iconUploadIFRARate;

	@FindBy(xpath = "//p[text()='JPMC']//parent::div//input")
	private ExtendedWebElement iconUploadJPMCRate;

	@FindBy(xpath = "//img[contains(@class,'ctaIcon')]")
	private ExtendedWebElement iconEditRate;

	@FindBy(xpath = "//span[normalize-space()='Submit']//parent::button")
	private ExtendedWebElement btnSubmit;

	@FindBy(xpath = "//h2[text()='Edit - Input Data Sheet']")
	private ExtendedWebElement lableEditInputDataSheet;

	@FindBy(xpath = "//input[@formcontrolname='bankSellingInterbankRate' and not(@readonly='true')]")
	private ExtendedWebElement inputInterbankRate;

	@FindBy(xpath = "//input[@formcontrolname='bankBuyingInterbankRate' and not(@readonly='true')]")
	private ExtendedWebElement inputInterbankSpotRate;

	@FindBy(xpath = "//input[@formcontrolname='bankBuyingCashPoint' and not(@readonly='true')]")
	private ExtendedWebElement inputCashSpotPoint;

	@FindBy(xpath = "//button[normalize-space()='Save']//parent::button")
	private ExtendedWebElement btnSave;

	@FindBy(xpath = "//span[normalize-space()='Input Data Sheet']")
	private ExtendedWebElement tabInputDataSheet;

	@FindBy(xpath = "//span[normalize-space()='Refresh Rate']")
	private ExtendedWebElement tabRefreshRate;

	@FindBy(xpath = "//span[normalize-space()='Rate Source']")
	private ExtendedWebElement tabRateSource;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private ExtendedWebElement inputCurrencyPair;

	@FindBy(xpath = "//table//tr[1]//td[4]")
	private ExtendedWebElement requestStatus;

	@FindBy(xpath = "//span[normalize-space()='Yes']//parent::button")
	private ExtendedWebElement btnYes;

	@FindBy(xpath = "//mat-checkbox[@id='chk_ifra']")
	private ExtendedWebElement radioBtnIFRA;

	@FindBy(xpath = "//mat-checkbox[@id='chk_jpmc']")
	private ExtendedWebElement radioBtnJPMC;

	@FindBy(xpath = "//mat-checkbox[@id='chk_automode']")
	private ExtendedWebElement radioBtnAutoFetchMode;

	@FindBy(xpath = "//div[@class='mat-form-field-infix ng-tns-c63-310']/child::input")
	private ExtendedWebElement valueFetchRate;

	@FindBy(xpath = "//input[@formcontrolname='bankSellingInterbankRate']") // Rajesh
	private List<ExtendedWebElement> txtInterbankRateFC;

	@FindBy(xpath = "//td[contains(@class,'column-currencyPair') and not (contains(@class,'column-currencyPair1'))]//input")
	private List<ExtendedWebElement> txtCurrencyPairFCSelling; // Rajesh

	@FindBy(xpath = "//td[contains(@class,'baseRateCurrencyPair') and not (contains(@class,'CurrencyPair1'))]//input")
	private List<ExtendedWebElement> txtCurrencyPairFCINRSelling;

	@FindBy(xpath = "//td[contains(@class,'baseRateCurrencyPair1')]//input")
	private List<ExtendedWebElement> txtCurrencyPairFCINRBuying;

	@FindBy(xpath = "//input[@formcontrolname='bankSellingRate']")
	private List<ExtendedWebElement> txtBankSellingRate;

	@FindBy(xpath = "//input[@formcontrolname='bankBuyingRate']")
	private List<ExtendedWebElement> txtBankBuyingRate;
	
	@FindBy(xpath = "//input[@formcontrolname='bankBuyingInterbankRate']") 
	private List<ExtendedWebElement> txtBuyingIntebankSpotRate;

	@FindBy(xpath = "//td[contains(@class,'column-currencyPair1')]//input")
	private List<ExtendedWebElement> textCurrencyPairFCBuying;

	@FindBy(xpath = "//td[contains(@class,'bankBuyingCashPoint')]//input")
	private List<ExtendedWebElement> textCashSpot;

	@FindBy(xpath = "//textarea[@formcontrolname='comments']")
	private ExtendedWebElement inputCommentsInputDataSheet;

	@FindBy(xpath = "//div[@role='alert']")
	private ExtendedWebElement textPendingAprroval;

	@FindBy(xpath = "//td[@title='Pending for approval']")
	private ExtendedWebElement textPendingForApproval;

	@FindBy(xpath = "//*[contains(text(),'My requests')]")
	private ExtendedWebElement myRequestStatus;

	public ExtendedWebElement getMyRequestStatus() {
		return myRequestStatus;
	}

	public ExtendedWebElement getTextPendingForApproval() {
		return textPendingForApproval;
	}

	public ExtendedWebElement getTextPendingAprroval() {
		return textPendingAprroval;
	}

	public ExtendedWebElement getInputCommentsInputDataSheet() {
		return inputCommentsInputDataSheet;
	}

	public List<ExtendedWebElement> getTextCashSpot() {
		return textCashSpot;

	}

	public List<ExtendedWebElement> getTextCurrencyPairFCBuying() {
		return textCurrencyPairFCBuying;

	}

	public List<ExtendedWebElement> getTextBuyingInterbankSR() {
		return txtBuyingIntebankSpotRate;
	}

	public List<ExtendedWebElement> getTxtBankSellingRate() {
		return txtBankSellingRate;
	}
	
	public List<ExtendedWebElement> getTxtBankBuyingRate() {
		return txtBankBuyingRate;
	}

	public List<ExtendedWebElement> getTxtCurrencyPairFCINRSelling() {
		return txtCurrencyPairFCINRSelling;
	}

	public List<ExtendedWebElement> getTxtCurrencyPairFCINRBuying() {
		return txtCurrencyPairFCINRBuying;
	}

	public List<ExtendedWebElement> getTxtCurrencyPairFCSelling() {
		return txtCurrencyPairFCSelling;
	}

	public List<ExtendedWebElement> getTxtInterbankRateFC() {
		return txtInterbankRateFC;
	}

	public ExtendedWebElement getValueFetchRate() {
		return valueFetchRate;

	}

	public ExtendedWebElement getRadioBtnAutoFetchMode() {
		return radioBtnAutoFetchMode;
	}

	public ExtendedWebElement getRadioBtnJPMC() {
		return radioBtnJPMC;
	}

	public ExtendedWebElement getRadioBtnIFRA() {
		return radioBtnIFRA;
	}

	public ExtendedWebElement getBtnYes() {
		return btnYes;
	}

	public ExtendedWebElement getRequestStatus() {
		return requestStatus;
	}

	public ExtendedWebElement getInputCurrencyPair() {
		return inputCurrencyPair;
	}

	public ExtendedWebElement getTabRateSource() {
		return tabRateSource;
	}

	public ExtendedWebElement getTabRefreshRate() {
		return tabRefreshRate;
	}

	public ExtendedWebElement getTabInputDataSheet() {
		return tabInputDataSheet;
	}

	public ExtendedWebElement getTabDomestic() {
		return tabDomestic;
	}

	public ExtendedWebElement getTabIBG() {
		return tabIBG;
	}

	public ExtendedWebElement getBtnMyRequest() {
		return btnMyRequest;
	}

	public ExtendedWebElement getBtnPendingApproval() {
		return btnPendingApproval;
	}

	public ExtendedWebElement getLabelRateSource() {
		return labelRateSource;
	}

	public ExtendedWebElement getIconEdit() {
		return iconEdit;
	}

	public ExtendedWebElement getIconAuditTrail() {
		return iconAuditTrail;
	}

	public ExtendedWebElement getRadioAutoFetchMode() {
		return radioAutoFetchMode;
	}

	public ExtendedWebElement getRadioManualMode() {
		return radioManualMode;
	}

	public ExtendedWebElement getRadioIFRA() {
		return radioIFRA;
	}

	public ExtendedWebElement getSelectIFRACurrencyPair() {
		return selectIFRACurrencyPair;
	}

	public ExtendedWebElement getSearchCurrencyPair() {
		return searchCurrencyPair;
	}

	public ExtendedWebElement getRadioCurrencyPair() {
		return radioCurrencyPair;
	}

	public ExtendedWebElement getClearSearchedCurrencyPair() {
		return clearSearchedCurrencyPair;
	}

	public ExtendedWebElement getCancelSelectedCurrencyPair() {
		return cancelSelectedCurrencyPair;
	}

	public ExtendedWebElement getRadioJPMC() {
		return radioJPMC;
	}

	public ExtendedWebElement getSelectJPMCCurrencyPair() {
		return selectJPMCCurrencyPair;
	}

	public ExtendedWebElement getSelectManualCurrencyPair() {
		return selectManualCurrencyPair;
	}

	public ExtendedWebElement getBtnBack() {
		return btnBack;
	}

	public ExtendedWebElement getBtnUpdate() {
		return btnUpdate;
	}

	public ExtendedWebElement getLabelRateSourceUpdate() {
		return labelRateSourceUpdate;
	}

	public ExtendedWebElement getLabelRefreshRate() {
		return labelRefreshRate;
	}

	public ExtendedWebElement getLabelRefreshRateUpdate() {
		return labelRefreshRateUpdate;
	}

	public ExtendedWebElement getToggleStatus() {
		return toggleStatus;
	}

	public ExtendedWebElement getRadioDaily() {
		return radioDaily;
	}

	public ExtendedWebElement getRadioHourly() {
		return radioHourly;
	}

	public ExtendedWebElement getRadioCustom() {
		return radioCustom;
	}

	public ExtendedWebElement getSelectCustomTime() {
		return selectCustomTime;
	}

	public ExtendedWebElement getOptionCustomTime() {
		return optionCustomTime;
	}

	public ExtendedWebElement getIconPublishTimeFrom() {
		return iconPublishTimeFrom;
	}

	public ExtendedWebElement getIconPublishTimeTo() {
		return iconPublishTimeTo;
	}

	public ExtendedWebElement getInputHours() {
		return inputHours;
	}

	public ExtendedWebElement getInputMinutes() {
		return inputMinutes;
	}

	public ExtendedWebElement getBtnAM() {
		return btnAM;
	}

	public ExtendedWebElement getBtnPM() {
		return btnPM;
	}

	public ExtendedWebElement getBtnCancel() {
		return btnCancel;
	}

	public ExtendedWebElement getBtnOk() {
		return btnOk;
	}

	public ExtendedWebElement getBtnInputDataSheet() {
		return btnInputDataSheet;
	}

	public ExtendedWebElement getLabelInputDataSheet() {
		return labelInputDataSheet;
	}

	public ExtendedWebElement getInputComments() {
		return inputComments;
	}

	public ExtendedWebElement getBtnAccept() {
		return btnAccept;
	}

	public ExtendedWebElement getBtnReject() {
		return btnReject;
	}

	public ExtendedWebElement getIconDownloadIFRATemp() {
		return iconDownloadIFRATemp;
	}

	public ExtendedWebElement getIconDownloadJPMCTemp() {
		return iconDownloadJPMCTemp;
	}

	public ExtendedWebElement getBtnFetchRate() {
		return btnFetchRate;
	}

	public ExtendedWebElement getRadioUploadFile() {
		return radioUploadFile;
	}

	public ExtendedWebElement getIconUploadIFRARate() {
		return iconUploadIFRARate;
	}

	public ExtendedWebElement getIconUploadJPMCRate() {
		return iconUploadJPMCRate;
	}

	public ExtendedWebElement getIconEditRate() {
		return iconEditRate;
	}

	public ExtendedWebElement getBtnSubmit() {
		return btnSubmit;
	}

	public ExtendedWebElement getLableEditInputDataSheet() {
		return lableEditInputDataSheet;
	}

	public ExtendedWebElement getInputInterbankRate() {
		return inputInterbankRate;
	}

	public ExtendedWebElement getInputInterbankSpotRate() {
		return inputInterbankSpotRate;
	}

	public ExtendedWebElement getInputCashSpotPoint() {
		return inputCashSpotPoint;
	}

	public ExtendedWebElement getBtnSave() {
		return btnSave;
	}

}
