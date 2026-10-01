package com.icici.forex.or;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class CardRateMasterPagesOr extends AbstractPage {

	public CardRateMasterPagesOr(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'Threshold Master')]")
	private ExtendedWebElement labelThresholdMaster;

	@FindBy(xpath = "(//*[@formcontrolname='currencyPairId']//div[contains(@class,'icon-container')])[last()]")
	private ExtendedWebElement selectCurrencyPair;

	@FindBy(xpath = "//div[@role='listbox']//mat-option")
	private ExtendedWebElement suggestionCurrencyPair;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	private ExtendedWebElement btnSearch;

	@FindBy(xpath = "//span[normalize-space()='Add New']//parent::button")
	private ExtendedWebElement btnAddNew;

	@FindBy(xpath = "//img[contains(@src,'assets/images/icons')]")
	private ExtendedWebElement iconEdit;

	@FindBy(xpath = "//img[contains(@src,'assets/Path')]")
	private ExtendedWebElement iconAuditTrail;

	@FindBy(xpath = "//div[@class='dialog-header']//img")
	private ExtendedWebElement closeAuditTrail;

	@FindBy(xpath = "//span[@title='Margin Erosion']")
	private ExtendedWebElement tabMarginErosion;

	@FindBy(xpath = "//p[normalize-space()='Margin Erosion Master']")
	private ExtendedWebElement labelMarginErosionMaster;

	@FindBy(xpath = "//span[normalize-space()='Product Master']")
	private ExtendedWebElement tabProductMaster;

	@FindBy(xpath = "//p[text()='Product Master']")
	private ExtendedWebElement labelProductMaster;

	@FindBy(xpath = "//li[@class='pager__item pager__item--next']")
	private ExtendedWebElement iconGoToNext;

	@FindBy(xpath = "//li[@class='pager__item pager__item--prev']")
	private ExtendedWebElement iconGoToPrev;

	@FindBy(xpath = "//p[text()='Global Parameters']")
	private ExtendedWebElement labelGlobalParameters;

	@FindBy(xpath = "//input[@value='Maker_Checker_Allowed']")
	private ExtendedWebElement radioMakerCheckerReq;

	@FindBy(xpath = "//input[@value='Skip_Maker']")
	private ExtendedWebElement radioOnlyCheckerReq;

	@FindBy(xpath = "//input[@value='Skip_Maker_Checker']")
	private ExtendedWebElement radioAutoFetchAndPublish;

	@FindBy(xpath = "//*[@formcontrolname='Rate_refresh_basis_threshold']//input[@value='YES']")
	private ExtendedWebElement radioYesRateRefreshBasisThreshold;

	@FindBy(xpath = "//*[@formcontrolname='Rate_refresh_basis_threshold']//input[@value='NO']")
	private ExtendedWebElement radioNoRateRefreshBasisThreshold;

	@FindBy(xpath = "//*[@formcontrolname='subtract_CS']//input[@value='YES']")
	private ExtendedWebElement radioYesSubstractCS;

	@FindBy(xpath = "//*[@formcontrolname='subtract_CS']//input[@value='NO']")
	private ExtendedWebElement radioNoSubstractCS;

	@FindBy(xpath = "//input[@formcontrolname='Margin_erosion']")
	private ExtendedWebElement inputMarginMultiplicationFactor;

	@FindBy(xpath = "//*[contains(text(),'modified manually')]/..//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectIBRRateDomestic;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private ExtendedWebElement inputCurrencyPair;

	@FindBy(xpath = "//mat-checkbox[contains(@id,'mat-checkbox-')]")
	private ExtendedWebElement radioSearchedCurrencyPair;

	@FindBy(xpath = "//*[@formcontrolname='currencyPairId1']//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectIBRRateIBG;

	@FindBy(xpath = "//*[@formcontrolname='currencyPairId2']//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectIBRRatesLockedDomestic;

	@FindBy(xpath = "//*[@formcontrolname='currencyPairId3']//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectIBRRateLockedIBG;

	@FindBy(xpath = "//*[@formcontrolname='productId']//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectProductName;

	@FindBy(xpath = "//input[@formcontrolname='buyLimit']")
	private ExtendedWebElement inputBuyUSDEquivalent;

	@FindBy(xpath = "//input[@formcontrolname='sellLimit']")
	private ExtendedWebElement inputSellUSDEquivalent;

	@FindBy(xpath = "//mat-icon[text()='add']//ancestor::button")
	private ExtendedWebElement iconAdd;

	@FindBy(xpath = "//span[normalize-space()='Update']//parent::button")
	private ExtendedWebElement btnUpdate;

	@FindBy(xpath = "//span[@title='Other Source Master']")
	private ExtendedWebElement tabOtherSourceMaster;

	@FindBy(xpath = "//p[normalize-space()='Other Sources Master - ARR']")
	private ExtendedWebElement labelOtherSourceMaster;

	@FindBy(xpath = "//p[normalize-space()='Finacle API']")
	private ExtendedWebElement labelFinacleAPI;

	@FindBy(xpath = "//span[normalize-space()='Push To Finacle']/parent::button")
	private ExtendedWebElement btnPushToFinacle;

	@FindBy(xpath = "//input[@formcontrolname='productName']")
	private ExtendedWebElement inputProductOrGeography;

	@FindBy(xpath = "//*[@formcontrolname='channelId']//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectChannel;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private ExtendedWebElement inputSearch;

	@FindBy(xpath = "//span[@class='mat-option-text']//mat-checkbox[contains(@id,'mat-checkbox-')]")
	private ExtendedWebElement optionChannel;

	@FindBy(xpath = "//textarea[@formcontrolname='productRemarks']")
	private ExtendedWebElement inputRemarks;

	@FindBy(xpath = "//mat-checkbox[@formcontrolname='checkMargin']//input")
	private ExtendedWebElement radioMarginWithoutSlab;

	@FindBy(xpath = "//mat-option[@role='option']")
	private ExtendedWebElement optionCurrencyPair;

	@FindBy(xpath = "(//*[@formcontrolname='marginType']//div[contains(@class,'icon-container')])[last()]")
	private ExtendedWebElement selectMarginType;

	@FindBy(xpath = "(//input[@formcontrolname='bankSellingMargin' or @formcontrolname='slabBankSellingMargin'])[last()]")
	private ExtendedWebElement inputBankSellingMargin;

	@FindBy(xpath = "(//input[@formcontrolname='bankBuyingMargin' or @formcontrolname='slabBankBuyingMargin'])[last()]")
	private ExtendedWebElement inputBankBuyingMargin;

	@FindBy(xpath = "//span[contains(text(),'Margin with slab')]//preceding-sibling::span//input")
	private ExtendedWebElement radioMarginWithSlab;

	@FindBy(xpath = "(//input[@formcontrolname='fromAmt'])[last()]")
	private ExtendedWebElement inputSlabRangeFrom;

	@FindBy(xpath = "(//input[@formcontrolname='toAmt'])[last()]")
	private ExtendedWebElement inputSlabRangeTo;

	@FindBy(xpath = "//span[normalize-space()='Submit']//parent::button")
	private ExtendedWebElement btnSubmit;

	@FindBy(xpath = "//*[contains(text(),'Pending approval')]//parent::a")
	private ExtendedWebElement linkPendingApproval;

	@FindBy(xpath = "//textarea[@formcontrolname='remarks']")
	private ExtendedWebElement inputComment;

	@FindBy(xpath = "//span[normalize-space()='Accept']//parent::button")
	private ExtendedWebElement btnAccept;

	@FindBy(xpath = "//span[normalize-space()='Reject']//parent::button")
	private ExtendedWebElement btnReject;

	@FindBy(xpath = "//span[normalize-space()='Yes']//parent::button")
	private ExtendedWebElement btnYes;

	@FindBy(xpath = "(//button[contains(@class,'formArrayDelete')])[last()]")
	private ExtendedWebElement btnDelete;

	@FindBy(xpath = "//span[normalize-space()='Global Parameters']")
	private ExtendedWebElement tabGlobalParameters;

	@FindBy(xpath = "//*[@formcontrolname='currencyPairId1']//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectIBRRatesModifiedManuallyIBG;

	@FindBy(xpath = "//*[@formcontrolname='currencyPairId2']//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectIBRRateLockedPolicyDomestic;

	@FindBy(xpath = "//*[@formcontrolname='currencyPairId3']//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectIBRRateLockedPolicyIBG;

	@FindBy(xpath = "//mat-option[contains(@id,'mat-option-')]")
	private ExtendedWebElement currencyPairOption;

	@FindBy(xpath = "//input[contains(@id,'mat-input-')]")
	private ExtendedWebElement inputThresholdPercent;

	@FindBy(xpath = "//h5[contains(text(),'Pending approval')]")
	private ExtendedWebElement pendingApproval;

	@FindBy(xpath = "//img[contains(@class,'ctaIcon edit-icon')]")
	private ExtendedWebElement btnEdit;

	@FindBy(xpath = "//textarea[contains(@id,'mat-input-')]")
	private ExtendedWebElement inputComments;

	@FindBy(xpath = "//input[@role='combobox']")
	private ExtendedWebElement inputProductName;

	@FindBy(xpath = "(//button[contains(@class,'AddNew') or contains(@class, 'addNew')])[last()]")
	private ExtendedWebElement btnAddMarginUnderSlabs;

	@FindBy(xpath = "(//button[contains(@class,'delete')])[last()]")
	private ExtendedWebElement btnDelete1;

	@FindBy(xpath = "//span[normalize-space()='Back']//parent::button")
	private ExtendedWebElement btnBack;

	@FindBy(xpath = "//input[@matautocompleteposition='below' or @type = 'text']")
	private ExtendedWebElement inputCpyOnThMaster;

	@FindBy(xpath = "(//button[contains(@class,'AddNew')])[last()]")
	private ExtendedWebElement btnAddMarginSlab;

	@FindBy(xpath = "//span[normalize-space()='Cancel']//parent::button")
	private ExtendedWebElement btnCancel;

	@FindBy(xpath = "//textarea[@formcontrolname='remarks']")
	private ExtendedWebElement inputCommentsOnProductApproval;

	@FindBy(xpath = "//span[normalize-space()='Enable']")
	private ExtendedWebElement btnEnable;

	@FindBy(xpath = "//input[@type = 'checkbox' and @role='switch']")
	private ExtendedWebElement toggleStatus;

	@FindBy(xpath = "//span[contains(text(),'Yes')]/..")
	private ExtendedWebElement btnYesWarning;

	@FindBy(xpath = "(//button[contains(@class,'AddNew')])[last()]")
	private ExtendedWebElement btnAddMarginWithSlab;

	public ExtendedWebElement getBtnAddMarginWithSlab() {
		return btnAddMarginWithSlab;
	}

	public ExtendedWebElement getBtnYesWarning() {
		return btnYesWarning;
	}

	public ExtendedWebElement getToggleStatus() {
		return toggleStatus;
	}

	public ExtendedWebElement getBtnEnable() {
		return btnEnable;
	}

	public ExtendedWebElement getInputCommentsOnProductApproval() {
		return inputCommentsOnProductApproval;
	}

	public ExtendedWebElement getBtnCancel() {
		return btnCancel;
	}

	public ExtendedWebElement getBtnAddMarginSlab() {
		return btnAddMarginSlab;
	}

	public ExtendedWebElement getInputCpyOnThMaster() {
		return inputCpyOnThMaster;
	}

	public ExtendedWebElement getBtnBack() {
		return btnBack;
	}

	public ExtendedWebElement getBtnDelete1() {
		return btnDelete1;
	}

	public ExtendedWebElement getBtnAddMarginUnderSlabs() {
		return btnAddMarginUnderSlabs;
	}

	public ExtendedWebElement getInputProductName() {
		return inputProductName;
	}

	public ExtendedWebElement getInputComments() {
		return inputComments;
	}

	public ExtendedWebElement getEditBtn() {
		return btnEdit;
	}

	public ExtendedWebElement getPendingApproval() {
		return pendingApproval;
	}

	public ExtendedWebElement getInputThresholdPercent() {
		return inputThresholdPercent;
	}

	public ExtendedWebElement getSelectIBRRateLockedPolicyIBG() {
		return selectIBRRateLockedPolicyIBG;
	}

	public ExtendedWebElement getSelectIBRRateLockedPolicyDomestic() {
		return selectIBRRateLockedPolicyDomestic;
	}

	public ExtendedWebElement getSelectIBRRatesModifiedManuallyIBG() {
		return selectIBRRatesModifiedManuallyIBG;
	}

	public ExtendedWebElement getTabGlobalParameters() {
		return tabGlobalParameters;
	}

	public ExtendedWebElement getBtnDelete() {
		return btnDelete;
	}

	public ExtendedWebElement getBtnYes() {
		return btnYes;
	}

	public ExtendedWebElement getBtnReject() {
		return btnReject;
	}

	public ExtendedWebElement getBtnAccept() {
		return btnAccept;
	}

	public ExtendedWebElement getInputComment() {
		return inputComment;
	}

	public ExtendedWebElement getLinkPendingApproval() {
		return linkPendingApproval;
	}

	public ExtendedWebElement getBtnSubmit() {
		return btnSubmit;
	}

	public ExtendedWebElement getInputSlabRangeTo() {
		return inputSlabRangeTo;
	}

	public ExtendedWebElement getInputSlabRangeFrom() {
		return inputSlabRangeFrom;
	}

	public ExtendedWebElement getRadioMarginWithSlab() {
		return radioMarginWithSlab;
	}

	public ExtendedWebElement getInputBankBuyingMargin() {
		return inputBankBuyingMargin;
	}

	public ExtendedWebElement getInputBankSellingMargin() {
		return inputBankSellingMargin;
	}

	public ExtendedWebElement getSelectMarginType() {
		return selectMarginType;
	}

	public ExtendedWebElement getOptionCurrencyPair() {
		return optionCurrencyPair;
	}

	public ExtendedWebElement getRadioMarginWithoutSlab() {
		return radioMarginWithoutSlab;
	}

	public ExtendedWebElement getInputRemark() {
		return inputRemarks;
	}

	public ExtendedWebElement getOptionChannel() {
		return optionChannel;
	}

	public ExtendedWebElement getInputSearch() {
		return inputSearch;
	}

	public ExtendedWebElement getSelectChannel() {
		return selectChannel;
	}

	public ExtendedWebElement getInputProductOrGeography() {
		return inputProductOrGeography;
	}

	public ExtendedWebElement getLabelThresholdMaster() {
		return labelThresholdMaster;
	}

	public ExtendedWebElement getSelectCurrencyPair() {
		return selectCurrencyPair;
	}

	public ExtendedWebElement getSuggestionCurrencyPair() {
		return suggestionCurrencyPair;
	}

	public ExtendedWebElement getBtnSearch() {
		return btnSearch;
	}

	public ExtendedWebElement getBtnAddNew() {
		return btnAddNew;
	}

	public ExtendedWebElement getIconEdit() {
		return iconEdit;
	}

	public ExtendedWebElement getIconAuditTrail() {
		return iconAuditTrail;
	}

	public ExtendedWebElement getCloseAuditTrail() {
		return closeAuditTrail;
	}

	public ExtendedWebElement getTabMarginErosion() {
		return tabMarginErosion;
	}

	public ExtendedWebElement getLabelMarginErosionMaster() {
		return labelMarginErosionMaster;
	}

	public ExtendedWebElement getTabProductMaster() {
		return tabProductMaster;
	}

	public ExtendedWebElement getLabelProductMaster() {
		return labelProductMaster;
	}

	public ExtendedWebElement getIconGoToNext() {
		return iconGoToNext;
	}

	public ExtendedWebElement getIconGoToPrev() {
		return iconGoToPrev;
	}

	public ExtendedWebElement getLabelGlobalParameters() {
		return labelGlobalParameters;
	}

	public ExtendedWebElement getRadioMakerCheckerReq() {
		return radioMakerCheckerReq;
	}

	public ExtendedWebElement getRadioOnlyCheckerReq() {
		return radioOnlyCheckerReq;
	}

	public ExtendedWebElement getRadioAutoFetchAndPublish() {
		return radioAutoFetchAndPublish;
	}

	public ExtendedWebElement getRadioYesRateRefreshBasisThreshold() {
		return radioYesRateRefreshBasisThreshold;
	}

	public ExtendedWebElement getRadioNoRateRefreshBasisThreshold() {
		return radioNoRateRefreshBasisThreshold;
	}

	public ExtendedWebElement getRadioYesSubstractCS() {
		return radioYesSubstractCS;
	}

	public ExtendedWebElement getRadioNoSubstractCS() {
		return radioNoSubstractCS;
	}

	public ExtendedWebElement getInputMarginMultiplicationFactor() {
		return inputMarginMultiplicationFactor;
	}

	public ExtendedWebElement getSelectIBRRateDomestic() {
		return selectIBRRateDomestic;
	}

	public ExtendedWebElement getInputCurrencyPair() {
		return inputCurrencyPair;
	}

	public ExtendedWebElement getRadioSearchedCurrencyPair() {
		return radioSearchedCurrencyPair;
	}

	public ExtendedWebElement getSelectIBRRateIBG() {
		return selectIBRRateIBG;
	}

	public ExtendedWebElement getSelectIBRRatesLockedDomestic() {
		return selectIBRRatesLockedDomestic;
	}

	public ExtendedWebElement getSelectIBRRateLockedIBG() {
		return selectIBRRateLockedIBG;
	}

	public ExtendedWebElement getSelectProductName() {
		return selectProductName;
	}

	public ExtendedWebElement getInputBuyUSDEquivalent() {
		return inputBuyUSDEquivalent;
	}

	public ExtendedWebElement getInputSellUSDEquivalent() {
		return inputSellUSDEquivalent;
	}

	public ExtendedWebElement getIconAdd() {
		return iconAdd;
	}

	public ExtendedWebElement getBtnUpdate() {
		return btnUpdate;
	}

	public ExtendedWebElement getTabOtherSourceMaster() {
		return tabOtherSourceMaster;
	}

	public ExtendedWebElement getLabelOtherSourceMaster() {
		return labelOtherSourceMaster;
	}

	public ExtendedWebElement getLabelFinacleAPI() {
		return labelFinacleAPI;
	}

	public ExtendedWebElement getBtnPushToFinacle() {
		return btnPushToFinacle;
	}

}
