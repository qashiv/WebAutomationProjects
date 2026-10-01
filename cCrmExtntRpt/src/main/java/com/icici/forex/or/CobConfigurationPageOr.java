package com.icici.forex.or;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class CobConfigurationPageOr extends AbstractPage {

	public CobConfigurationPageOr(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[text()=' Cob Configuration ']")
	private ExtendedWebElement menuCobConfiguration;

	@FindBy(xpath = "//span[text()=' Cancel ']/parent::button")
	private ExtendedWebElement btnCancel;

	@FindBy(xpath = "//span[text()='Download Excel Template']/parent::button")
	private ExtendedWebElement btnDownloadExcelTemp;

	@FindBy(xpath = "//span[normalize-space()='Block Bulk Counterparty']")
	private ExtendedWebElement subMenuBlockBulkCounterparty;

	@FindBy(xpath = "//*[text()='Upload Block Bulk Counterparty']")
	private ExtendedWebElement LabelUploadBlockBulkCounterparty;

	@FindBy(xpath = "//*[text()='Upload Bulk Counterparty']")
	private ExtendedWebElement LabelUploadBulkCounterparty;

	@FindBy(xpath = "//span[normalize-space()='Upload Pre-approve Customer']")
	private ExtendedWebElement subMenuUploadPreApproveCust;

	@FindBy(xpath = "//div[@class='upload-file-text']//input[@type='file']")
	private ExtendedWebElement uploadPreApproveFile;

	@FindBy(xpath = "//span[normalize-space()='Upload']/parent::button")
	private ExtendedWebElement btnUpload;

	@FindBy(xpath = "//span[normalize-space()='Upload Bulk Counterparty']")
	private ExtendedWebElement subMenuUploadBulkCounterparty;

	@FindBy(xpath = "//span[normalize-space()='Upload Epsilone File']")
	private ExtendedWebElement subMenuUploadEpsiloneFile;

	@FindBy(xpath = "//*[text()='Upload Epsilon File']")
	private ExtendedWebElement LabelUploadEpsilonfile;

	@FindBy(xpath = "//mat-radio-button[@value='E']")
	private ExtendedWebElement radioBtnEpsilon;

	@FindBy(xpath = "//mat-radio-button[@value='TH']")
	private ExtendedWebElement radioTeamHierarchy;

	@FindBy(xpath = "//*[text()='SM Assignment']")
	private ExtendedWebElement labelSMAssignment;

	@FindBy(id = "custom-dropdown")
	private ExtendedWebElement selectSM;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private ExtendedWebElement inputSMSearch;

	@FindBy(xpath = "//span[normalize-space()='Reassign']")
	private ExtendedWebElement subMenuReassign;

	@FindBy(xpath = "//span[text()='Export']/parent::button")
	private ExtendedWebElement btnExport;

	@FindBy(xpath = "//input[contains(@id,'mat-checkbox')]")
	private ExtendedWebElement radioCustomerSelect;

	@FindBy(xpath = "//span[normalize-space()='Report']")
	private ExtendedWebElement subMenuReport;

	@FindBy(xpath = "//input[@placeholder='From']/parent::div//following-sibling::div//button")
	private ExtendedWebElement btnFrom;

	@FindBy(xpath = "//input[@placeholder='To']/parent::div//following-sibling::div//button")
	private ExtendedWebElement btnTo;

	@FindBy(xpath = "//*[text()=' Go ']")
	private ExtendedWebElement btnGo;

	@FindBy(xpath = "//button[normalize-space()='Reset']")
	private ExtendedWebElement btnReset;

	@FindBy(xpath = "//span[text()='Export to Excel']/parent::button")
	private ExtendedWebElement btnExportToExcel;

	@FindBy(xpath = "//div[@class='drop-label']/label")
	private ExtendedWebElement selectFromFilter;

	@FindBy(xpath = "//span[normalize-space()='Modification']")
	private ExtendedWebElement subMenuModification;

	@FindBy(xpath = "//input[@type='file' and @formcontrolname='file']")
	private ExtendedWebElement linkUploadBulkCounterpartyFile;

	@FindBy(xpath = "//div[contains(@class,'violations_container')]//p")
	private List<ExtendedWebElement> violationMessage;

	@FindBy(xpath = "//input[@placeholder='Search Cust. ID, Name, Request ID']")
	private ExtendedWebElement inputSearch;

	@FindBy(xpath = "(//table[@role='table']//tr)[last()]//mat-checkbox")
	private ExtendedWebElement checkSearchedReqId;

	@FindBy(xpath = "//button[contains(@class,'button3')]")
	private ExtendedWebElement btnReassign;

	@FindBy(xpath = "//div[contains(@class,'filterIcon')]")
	private ExtendedWebElement iconFilter;

	@FindBy(xpath = "//button[@aria-label='Previous month']")
	private ExtendedWebElement btnPreviousMonth;

	@FindBy(xpath = "//*[contains(text(),'Currency Pairs')]//ancestor::mat-expansion-panel-header")
	private ExtendedWebElement expandCurrecyPair;

	@FindBy(xpath = "//*[text()='Select Currency Pair']//parent::div//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectCurrencyPair;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private ExtendedWebElement inputSearchCurrencyPair;

	@FindBy(xpath = "//span[normalize-space()='Submit']//parent::button")
	private ExtendedWebElement btnSubmit;

	@FindBy(xpath = "//*[contains(text(),'Users')]//ancestor::mat-expansion-panel-header")
	private ExtendedWebElement expandUsers;

	@FindBy(xpath = "//span[normalize-space()='Pending Request']")
	private ExtendedWebElement subMenuPendingRequest;

	@FindBy(xpath = "//label[text()='Request Id']//following-sibling::p")
	private ExtendedWebElement txtRequestId;

	@FindBy(xpath = "//input[@type='file']")
	private ExtendedWebElement uploadFile;
	
	public ExtendedWebElement getUploadFile() {
		return uploadFile;
	}

	public ExtendedWebElement getTxtRequestId() {
		return txtRequestId;
	}

	public ExtendedWebElement getSubMenuPendingRequest() {
		return subMenuPendingRequest;
	}

	public ExtendedWebElement getExpandUsers() {
		return expandUsers;
	}

	public ExtendedWebElement getBtnSubmit() {
		return btnSubmit;
	}

	public ExtendedWebElement getInputSearchCurrencyPair() {
		return inputSearchCurrencyPair;
	}

	public ExtendedWebElement getSelectCurrencyPair() {
		return selectCurrencyPair;
	}

	public ExtendedWebElement getExpandCurrencyPair() {
		return expandCurrecyPair;
	}

	public ExtendedWebElement getBtnPreviousMonth() {
		return btnPreviousMonth;
	}

	public ExtendedWebElement getIconFilter() {
		return iconFilter;
	}

	public ExtendedWebElement getCheckSearchedReqId() {
		return checkSearchedReqId;
	}

	public ExtendedWebElement getInputSearch() {
		return inputSearch;
	}

	public ExtendedWebElement getMenuCobConfiguration() {
		return menuCobConfiguration;
	}

	public ExtendedWebElement getBtnCancel() {
		return btnCancel;
	}

	public ExtendedWebElement getBtnDownloadExcelTemp() {
		return btnDownloadExcelTemp;
	}

	public ExtendedWebElement getSubMenuBlockBulkCounterparty() {
		return subMenuBlockBulkCounterparty;
	}

	public ExtendedWebElement getLabelUploadBlockBulkCounterparty() {
		return LabelUploadBlockBulkCounterparty;
	}

	public ExtendedWebElement getLabelUploadBulkCounterparty() {
		return LabelUploadBulkCounterparty;
	}

	public ExtendedWebElement getSubMenuUploadPreApproveCust() {
		return subMenuUploadPreApproveCust;
	}

	public ExtendedWebElement getUploadPreApproveFile() {
		return uploadPreApproveFile;
	}

	public ExtendedWebElement getBtnUpload() {
		return btnUpload;
	}

	public ExtendedWebElement getSubMenuUploadBulkCounterparty() {
		return subMenuUploadBulkCounterparty;
	}

	public ExtendedWebElement getSubMenuUploadEpsiloneFile() {
		return subMenuUploadEpsiloneFile;
	}

	public ExtendedWebElement getLabelUploadEpsilonfile() {
		return LabelUploadEpsilonfile;
	}

	public ExtendedWebElement getRadioBtnEpsilon() {
		return radioBtnEpsilon;
	}

	public ExtendedWebElement getRadioTeamHierarchy() {
		return radioTeamHierarchy;
	}

	public ExtendedWebElement getSubMenuReassign() {
		return subMenuReassign;
	}

	public ExtendedWebElement getLabelSMAssignment() {
		return labelSMAssignment;
	}

	public ExtendedWebElement getSelectSM() {
		return selectSM;
	}

	public ExtendedWebElement getInputSMSearch() {
		return inputSMSearch;
	}

	public ExtendedWebElement getBtnReassign() {
		return btnReassign;
	}

	public ExtendedWebElement getBtnExport() {
		return btnExport;
	}

	public ExtendedWebElement getRadioCustomerSelect() {
		return radioCustomerSelect;
	}

	public ExtendedWebElement getSubMenuReport() {
		return subMenuReport;
	}

	public ExtendedWebElement getBtnFrom() {
		return btnFrom;
	}

	public ExtendedWebElement getBtnTo() {
		return btnTo;
	}

	public ExtendedWebElement getBtnGo() {
		return btnGo;
	}

	public ExtendedWebElement getBtnReset() {
		return btnReset;
	}

	public ExtendedWebElement getBtnExportToExcel() {
		return btnExportToExcel;
	}

	public ExtendedWebElement getSelectFromFilter() {
		return selectFromFilter;
	}

	public ExtendedWebElement getSubMenuModification() {
		return subMenuModification;
	}

	public ExtendedWebElement getLinkUploadBulkCounterpartyFile() {
		return linkUploadBulkCounterpartyFile;
	}

	public List<ExtendedWebElement> getViolationMessage() {
		return violationMessage;
	}

}
