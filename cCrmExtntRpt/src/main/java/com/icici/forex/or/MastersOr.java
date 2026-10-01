package com.icici.forex.or;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class MastersOr extends AbstractPage {

	public MastersOr(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@title='Application Configuration']")
	private ExtendedWebElement tabApplicationConfig;

	@FindBy(xpath = "//p[text()='Application Configuration']")
	private ExtendedWebElement labelApplicationConfig;

	@FindBy(xpath = "//input[@matautocompleteposition='below']")
	private ExtendedWebElement inputSearchConfigName;

	@FindBy(xpath = "//mat-option[@role='option']")
	private ExtendedWebElement optionConfigName;

	@FindBy(xpath = "//mat-icon[text()='search']//ancestor::button")
	private ExtendedWebElement btnSearch;

	@FindBy(xpath = "(//div[@class='action-container']//img)[1]")
	private ExtendedWebElement iconEditConfigDetails;

	@FindBy(xpath = "(//div[@class='action-container']//img)[2]")
	private ExtendedWebElement iconAuditTrail;

	@FindBy(xpath = "//input[@placeholder='From Date']//parent::div//following-sibling::div//button")
	private ExtendedWebElement btnFromDate;

	@FindBy(xpath = "//input[@placeholder='To Date']//parent::div//following-sibling::div//button")
	private ExtendedWebElement btnToDate;

	@FindBy(xpath = "//button[@aria-label='Thu Mar 14 2024' and @aria-pressed='false']")
	private ExtendedWebElement selectDate;

	@FindBy(xpath = "//img[@type='button']")
	private ExtendedWebElement btnCancelAuditTrail;

	@FindBy(xpath = "//input[@formcontrolname='confValue']")
	private ExtendedWebElement inputValue;

	@FindBy(xpath = "//input[@formcontrolname='confDesc']")
	private ExtendedWebElement inputDescription;

	@FindBy(xpath = "//span[normalize-space()='Submit']//parent::button")
	private ExtendedWebElement btnSubmit;

	@FindBy(xpath = "//span[normalize-space()='Cancel']//parent::button")
	private ExtendedWebElement btnCancel;

	@FindBy(xpath = "//span[@title='Location Master']")
	private ExtendedWebElement tabLocationMaster;

	@FindBy(xpath = "//p[text()='Location Master']")
	private ExtendedWebElement labelLocationMaster;

	@FindBy(xpath = "//mat-icon[text()='add']//ancestor::button")
	private ExtendedWebElement btnAddNew;

	@FindBy(xpath = "//span[@title='Timezone Master']")
	private ExtendedWebElement tabTimezoneMaster;

	@FindBy(xpath = "//p[text()='Time Zone Master']")
	private ExtendedWebElement labelTimezoneMaster;

	@FindBy(xpath = "//p[text()='Maturity Matrix Master']")
	private ExtendedWebElement labelMaturityMatrix;

	@FindBy(xpath = "//span[contains(text(),'Refresh')]//parent::button")
	private ExtendedWebElement btnRefresh;

	@FindBy(xpath = "//span[normalize-space()='Bulk Upload']//parent::button")
	private ExtendedWebElement btnBulkUplaod;

	@FindBy(xpath = "//span[contains(text(),'Download Excel')]//parent::button]")
	private ExtendedWebElement btnDownloadExcel;

	@FindBy(xpath = "//p[contains(text(),'My requests')]//parent::div")
	private ExtendedWebElement btnMyRequest;

	@FindBy(xpath = "//p[contains(text(),'Pending approval')]//parent::div")
	private ExtendedWebElement btnPendingApproval;

	@FindBy(xpath = "//span[text()='Upload Status: ']//following-sibling::span")
	private ExtendedWebElement txtUploadStatus;

	@FindBy(xpath = "//p[text()='Branch Master']")
	private ExtendedWebElement labelBranchMaster;

	@FindBy(xpath = "//p[text()='Currency Pair Limit']")
	private ExtendedWebElement labelCurrencyPairLimit;

	@FindBy(xpath = "//mat-radio-button[@value='Internal']")
	private ExtendedWebElement radioInternal;

	@FindBy(xpath = "//mat-radio-button[@value='External']")
	private ExtendedWebElement radioExternal;

	@FindBy(xpath = "//p[text()='Currency Master']")
	private ExtendedWebElement labelCurrencyMaster;

	@FindBy(xpath = "//p[text()='Validity Matrix']")
	private ExtendedWebElement labelValidityMatrix;

	@FindBy(xpath = "//p[text()='Trading Time']")
	private ExtendedWebElement labelTradingTime;

	@FindBy(xpath = "//p[text()='Margin Reference Master']")
	private ExtendedWebElement labelMarginReference;

	@FindBy(xpath = "//p[text()='Currency Pair Rate Master']")
	private ExtendedWebElement labelCurrencyPairRate;

	@FindBy(xpath = "//p[text()='Currency Pair Trade Status']")
	private ExtendedWebElement labelCPTradeStatus;

	@FindBy(xpath = "//span[normalize-space()='Start Trade']//parent::button")
	private ExtendedWebElement btnStartTrade;

	@FindBy(xpath = "//span[normalize-space()='Stop Trade']//parent::button")
	private ExtendedWebElement btnStopTrade;

	@FindBy(xpath = "//p[text()='Currency Pair Wise Spread Master']")
	private ExtendedWebElement labelCPWiseSpreadMaster;

	@FindBy(xpath = "//span[@title='Transaction Type Master']")
	private ExtendedWebElement btnTransTypeMaster;

	@FindBy(xpath = "//p[text()='Transaction Type Master']")
	private ExtendedWebElement labelTransTypeMaster;

	@FindBy(xpath = "//p[text()='Nostro Master']")
	private ExtendedWebElement labelNostroMaster;

	@FindBy(xpath = "//p[text()='Location Currency Group']")
	private ExtendedWebElement labelLocationCurrencyGroup;

	@FindBy(xpath = "//p[text()='Deal Type Master']")
	private ExtendedWebElement labelDealTypeMaster;

	@FindBy(xpath = "//p[text()='Currency Pair Master']")
	private ExtendedWebElement labelCurrencyPairMaster;

	@FindBy(xpath = "//p[text()='Group Transaction Default Nostro ']")
	private ExtendedWebElement labelGroupTransDeafaultNostro;

	@FindBy(xpath = "//p[text()='Holiday Master']")
	private ExtendedWebElement labelHolidayMaster;

	@FindBy(xpath = "//span[contains(text(),'Refresh')]")
	private ExtendedWebElement btn_Refresh;

	@FindBy(xpath = "//p[text()='Tenor Master']")
	private ExtendedWebElement labelTenorMaster;

	@FindBy(xpath = "//p[text()='Currency Pair Tenor Order ']")
	private ExtendedWebElement labelCPTenorOrder;

	@FindBy(xpath = "//p[text()='Order Type Master']")
	private ExtendedWebElement labelOrderTypeMaster;

	@FindBy(xpath = "//p[text()='Currency Pair Tenor Mapping']")
	private ExtendedWebElement labelCPTenorMapping;

	@FindBy(xpath = "//p[text()='Common Master']")
	private ExtendedWebElement labelCommonMaster;

	@FindBy(xpath = "//p[text()='Blotter Attributes Master']")
	private ExtendedWebElement labelBlotterAttributeMaster;

	@FindBy(xpath = "//p[normalize-space()='Order Rate Acceptability Master']")
	private ExtendedWebElement labelOrderRateAccMaster;

	@FindBy(xpath = "//p[normalize-space()='Deal Type For Booking']")
	private ExtendedWebElement labelDealTypeForBooking;

	@FindBy(xpath = "//div[contains(@class,'page-title')]")
	private ExtendedWebElement labelDefaultNotionalMaster;

	@FindBy(xpath = "//p[normalize-space()='Take Murex Desk']")
	private ExtendedWebElement labelTakeMurexDesk;

	@FindBy(xpath = "//p[text()='Dealer Portfolio Master']")
	private ExtendedWebElement labelDealerPortfolioMaster;

	@FindBy(xpath = "//p[text()='iFRA To DS Category Mapping Master']")
	private ExtendedWebElement labelIFRAToDSCategory;

	@FindBy(xpath = "//div[contains(@class,'page-title')]")
	private ExtendedWebElement labelDealBasisTypeMapping;

	@FindBy(xpath = "//p[text()='Deal Type For Conclude']")
	private ExtendedWebElement labelDealTypeForConclude;

	@FindBy(xpath = "//span[normalize-space()='Bulk Approve']")
	private ExtendedWebElement btnBulkApprove;

	@FindBy(xpath = "//div[@class='action-container']//img")
	private ExtendedWebElement iconEdit;

	@FindBy(xpath = "//span[normalize-space()='Back']")
	private ExtendedWebElement btnBack;

	@FindBy(xpath = "//textarea[@formcontrolname='comments']")
	private ExtendedWebElement inputApproverComments;

	@FindBy(xpath = "//span[normalize-space()='Accept']")
	private ExtendedWebElement btnAccept;

	@FindBy(xpath = "//span[normalize-space()='Reject']")
	private ExtendedWebElement btnReject;

	public ExtendedWebElement getTabApplicationConfig() {
		return tabApplicationConfig;
	}

	public ExtendedWebElement getLabelApplicationConfig() {
		return labelApplicationConfig;
	}

	public ExtendedWebElement getInputSearchConfigName() {
		return inputSearchConfigName;
	}

	public ExtendedWebElement getOptionConfigName() {
		return optionConfigName;
	}

	public ExtendedWebElement getBtnSearch() {
		return btnSearch;
	}

	public ExtendedWebElement getIconEditConfigDetails() {
		return iconEditConfigDetails;
	}

	public ExtendedWebElement getIconAuditTrail() {
		return iconAuditTrail;
	}

	public ExtendedWebElement getBtnFromDate() {
		return btnFromDate;
	}

	public ExtendedWebElement getBtnToDate() {
		return btnToDate;
	}

	public ExtendedWebElement getSelectDate() {
		return selectDate;
	}

	public ExtendedWebElement getBtnCancelAuditTrail() {
		return btnCancelAuditTrail;
	}

	public ExtendedWebElement getInputValue() {
		return inputValue;
	}

	public ExtendedWebElement getInputDescription() {
		return inputDescription;
	}

	public ExtendedWebElement getBtnSubmit() {
		return btnSubmit;
	}

	public ExtendedWebElement getBtnCancel() {
		return btnCancel;
	}

	public ExtendedWebElement getTabLocationMaster() {
		return tabLocationMaster;
	}

	public ExtendedWebElement getLabelLocationMaster() {
		return labelLocationMaster;
	}

	public ExtendedWebElement getBtnAddNew() {
		return btnAddNew;
	}

	public ExtendedWebElement getTabTimezoneMaster() {
		return tabTimezoneMaster;
	}

	public ExtendedWebElement getLabelTimezoneMaster() {
		return labelTimezoneMaster;
	}

	public ExtendedWebElement getLabelMaturityMatrix() {
		return labelMaturityMatrix;
	}

	public ExtendedWebElement getBtnRefresh() {
		return btnRefresh;
	}

	public ExtendedWebElement getBtnBulkUplaod() {
		return btnBulkUplaod;
	}

	public ExtendedWebElement getBtnDownloadExcel() {
		return btnDownloadExcel;
	}

	public ExtendedWebElement getBtnMyRequest() {
		return btnMyRequest;
	}

	public ExtendedWebElement getBtnPendingApproval() {
		return btnPendingApproval;
	}

	public ExtendedWebElement getTxtUploadStatus() {
		return txtUploadStatus;
	}

	public ExtendedWebElement getLabelBranchMaster() {
		return labelBranchMaster;
	}

	public ExtendedWebElement getLabelCurrencyPairLimit() {
		return labelCurrencyPairLimit;
	}

	public ExtendedWebElement getRadioInternal() {
		return radioInternal;
	}

	public ExtendedWebElement getRadioExternal() {
		return radioExternal;
	}

	public ExtendedWebElement getLabelCurrencyMaster() {
		return labelCurrencyMaster;
	}

	public ExtendedWebElement getLabelValidityMatrix() {
		return labelValidityMatrix;
	}

	public ExtendedWebElement getLabelTradingTime() {
		return labelTradingTime;
	}

	public ExtendedWebElement getLabelMarginReference() {
		return labelMarginReference;
	}

	public ExtendedWebElement getLabelCurrencyPairRate() {
		return labelCurrencyPairRate;
	}

	public ExtendedWebElement getLabelCPTradeStatus() {
		return labelCPTradeStatus;
	}

	public ExtendedWebElement getBtnStartTrade() {
		return btnStartTrade;
	}

	public ExtendedWebElement getBtnStopTrade() {
		return btnStopTrade;
	}

	public ExtendedWebElement getLabelCPWiseSpreadMaster() {
		return labelCPWiseSpreadMaster;
	}

	public ExtendedWebElement getBtnTransTypeMaster() {
		return btnTransTypeMaster;
	}

	public ExtendedWebElement getLabelTransTypeMaster() {
		return labelTransTypeMaster;
	}

	public ExtendedWebElement getLabelNostroMaster() {
		return labelNostroMaster;
	}

	public ExtendedWebElement getLabelLocationCurrencyGroup() {
		return labelLocationCurrencyGroup;
	}

	public ExtendedWebElement getLabelDealTypeMaster() {
		return labelDealTypeMaster;
	}

	public ExtendedWebElement getLabelCurrencyPairMaster() {
		return labelCurrencyPairMaster;
	}

	public ExtendedWebElement getLabelGroupTransDeafaultNostro() {
		return labelGroupTransDeafaultNostro;
	}

	public ExtendedWebElement getLabelHolidayMaster() {
		return labelHolidayMaster;
	}

	public ExtendedWebElement getBtn_Refresh() {
		return btn_Refresh;
	}

	public ExtendedWebElement getLabelTenorMaster() {
		return labelTenorMaster;
	}

	public ExtendedWebElement getLabelCPTenorOrder() {
		return labelCPTenorOrder;
	}

	public ExtendedWebElement getLabelOrderTypeMaster() {
		return labelOrderTypeMaster;
	}

	public ExtendedWebElement getLabelCPTenorMapping() {
		return labelCPTenorMapping;
	}

	public ExtendedWebElement getLabelCommonMaster() {
		return labelCommonMaster;
	}

	public ExtendedWebElement getLabelBlotterAttributeMaster() {
		return labelBlotterAttributeMaster;
	}

	public ExtendedWebElement getLabelOrderRateAccMaster() {
		return labelOrderRateAccMaster;
	}

	public ExtendedWebElement getLabelDealTypeForBooking() {
		return labelDealTypeForBooking;
	}

	public ExtendedWebElement getLabelDefaultNotionalMaster() {
		return labelDefaultNotionalMaster;
	}

	public ExtendedWebElement getLabelTakeMurexDesk() {
		return labelTakeMurexDesk;
	}

	public ExtendedWebElement getLabelDealerPortfolioMaster() {
		return labelDealerPortfolioMaster;
	}

	public ExtendedWebElement getLabelIFRAToDSCategory() {
		return labelIFRAToDSCategory;
	}

	public ExtendedWebElement getLabelDealBasisTypeMapping() {
		return labelDealBasisTypeMapping;
	}

	public ExtendedWebElement getLabelDealTypeForConclude() {
		return labelDealTypeForConclude;
	}

	public ExtendedWebElement getBtnBulkApprove() {
		return btnBulkApprove;
	}

	public ExtendedWebElement getIconEdit() {
		return iconEdit;
	}

	public ExtendedWebElement getBtnBack() {
		return btnBack;
	}

	public ExtendedWebElement getInputApproverComments() {
		return inputApproverComments;
	}

	public ExtendedWebElement getBtnAccept() {
		return btnAccept;
	}

	public ExtendedWebElement getBtnReject() {
		return btnReject;
	}

}
