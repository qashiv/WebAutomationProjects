package com.icici.forex.or;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class CardRateReportsPagesOr extends AbstractPage {

	public CardRateReportsPagesOr(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//p[text()='Card Rates']")
	private ExtendedWebElement labelCardRates;

	@FindBy(xpath = "//*[@value='Current']//span[contains(@class,'radio-container')]")
	private ExtendedWebElement radioCurrentCardRate;

	@FindBy(xpath = "//*[@value='Historical']//span[contains(@class,'radio-container')]")
	private ExtendedWebElement radioHistoricalCardRate;

	@FindBy(xpath = "//*[@formcontrolname='productId']//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectProductId;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private ExtendedWebElement inputSearch;

	@FindBy(xpath = "//div[@class='option-text']")
	private ExtendedWebElement selectProductOption;

	@FindBy(xpath = "//span[normalize-space()='Go']//parent::button")
	private ExtendedWebElement btnGo;

	@FindBy(xpath = "//div[normalize-space()='Download PDF']//span")
	private ExtendedWebElement btnDownloadPdf;

	@FindBy(xpath = "//div[normalize-space()='Download Excel']//span")
	private ExtendedWebElement btnDownloadExcel;

	@FindBy(xpath = "//div[normalize-space()='Download Finacle CSV']//span")
	private ExtendedWebElement btnDownloadCSV;

	@FindBy(xpath = "//input[@placeholder='From']//parent::div//following-sibling::div//button")
	private ExtendedWebElement iconDateFrom;

	@FindBy(xpath = "//input[@placeholder='To']//parent::div//following-sibling::div//button")
	private ExtendedWebElement iconDateTo;

	@FindBy(xpath = "//span[@title='Margin Report']")
	private ExtendedWebElement tabMarginReport;

	@FindBy(xpath = "//p[text()='Margin Report']")
	private ExtendedWebElement labelMarginReport;

	@FindBy(xpath = "//input[@matautocompleteposition='below']")
	private ExtendedWebElement inputSearchProduct;

	@FindBy(xpath = "(//mat-option[@role='option'])[last()]")
	private ExtendedWebElement optionProduct;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	private ExtendedWebElement btnSearch;

	@FindBy(xpath = "//p[text()='IBR']")
	private ExtendedWebElement labelIBR;

	@FindBy(xpath = "//mat-radio-button[@value='Current IBR']")
	private ExtendedWebElement radioCurrentIBR;

	@FindBy(xpath = "//mat-radio-button[@value='Historical IBR']")
	private ExtendedWebElement radioHistoricalIBR;

	@FindBy(xpath = "//div[text()='IBG']//parent::div[@role='tab']")
	private ExtendedWebElement tabIBG;

	@FindBy(xpath = "//div[text()='Domestic']//parent::div[@role='tab']")
	private ExtendedWebElement tabDomestic;

	@FindBy(xpath = "//p[text()='Card Rate Output Files']")
	private ExtendedWebElement labelOutputFiles;

	@FindBy(xpath = "//*[contains(@formcontrolname,'product')]//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectProductData;

	@FindBy(xpath = "//div[normalize-space()='Select All']")
	private ExtendedWebElement optionSelectAll;

	@FindBy(xpath = "//mat-option[@role='option']")
	private ExtendedWebElement optionSelectProduct;

	@FindBy(xpath = "//button[normalize-space()='Go']")
	private ExtendedWebElement btn_Go;

	@FindBy(xpath = "//span[@title='Other Source Report']")
	private ExtendedWebElement tabOtherSourceReport;

	@FindBy(xpath = "//p[text()='Report - ARR']")
	private ExtendedWebElement labelOtherSourceReport;

	@FindBy(xpath = "//input[@placeholder='To']//..//following-sibling::div//button")
	private ExtendedWebElement btnSelectDateTo;

	@FindBy(xpath = "//input[@placeholder='From']//..//following-sibling::div//button")
	private ExtendedWebElement btnSelectDateFrom;

	@FindBy(xpath = "//td//div[normalize-space()='1']")
	private ExtendedWebElement selectDateFrom;

	@FindBy(xpath = "//span[normalize-space()='IBR Report']")
	private ExtendedWebElement tabIBRReport;

	@FindBy(xpath = "//input[@formcontrolname='hour']")
	private ExtendedWebElement inputHour;

	@FindBy(xpath = "//input[@formcontrolname='minute']")
	private ExtendedWebElement inputMinute;

	@FindBy(xpath = "//button[contains(@class,'mat-stroked-button')]")
	private ExtendedWebElement btnAccept;

	@FindBy(xpath = "//span[normalize-space()='Output Files']")
	private ExtendedWebElement tabOutputFiles;

	@FindBy(xpath = "//*[@formcontrolname='productData']//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectProduct;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private ExtendedWebElement inputProduct;

	@FindBy(xpath = "//td[contains(@class,'pdfcsv')]//a")
	private List<ExtendedWebElement> linkDownloadFiles;

	@FindBy(xpath = "//span[normalize-space()='Card Rates']")
	private ExtendedWebElement tabCardRates;

	@FindBy(xpath = "//td[contains(@class,'cashBankSellingRate')]")
	private List<ExtendedWebElement> textCashBankSellingRate;

	@FindBy(xpath = "//td[contains(@class,'baseRateCurrencyPairCode')]")
	private List<ExtendedWebElement> textBaseRateCurrencyPair;

	public List<ExtendedWebElement> getTextBaseRateCurrencyPair() {
		return textBaseRateCurrencyPair;
	}

	public List<ExtendedWebElement> getTextCashBankSellingRate() {
		return textCashBankSellingRate;
	}

	public ExtendedWebElement getTabCardRates() {
		return tabCardRates;
	}

	public List<ExtendedWebElement> getLinkDownloadFiles() {
		return linkDownloadFiles;
	}

	public ExtendedWebElement getInputProduct() {
		return inputProduct;
	}

	public ExtendedWebElement getSelectProduct() {
		return selectProductData;
	}

	public ExtendedWebElement getTabOutputFiles() {
		return tabOutputFiles;
	}

	public ExtendedWebElement getBtnAccept() {
		return btnAccept;
	}

	public ExtendedWebElement getInputMinute() {
		return inputMinute;
	}

	public ExtendedWebElement getInputHour() {
		return inputHour;
	}

	public ExtendedWebElement getLabelCardRates() {
		return labelCardRates;
	}

	public ExtendedWebElement getRadioCurrentCardRate() {
		return radioCurrentCardRate;
	}

	public ExtendedWebElement getRadioHistoricalCardRate() {
		return radioHistoricalCardRate;
	}

	public ExtendedWebElement getSelectProductId() {
		return selectProductId;
	}

	public ExtendedWebElement getInputSearch() {
		return inputSearch;
	}

	public ExtendedWebElement getSelectProductOption() {
		return selectProductOption;
	}

	public ExtendedWebElement getBtnGo() {
		return btnGo;
	}

	public ExtendedWebElement getBtnDownloadPdf() {
		return btnDownloadPdf;
	}

	public ExtendedWebElement getBtnDownloadExcel() {
		return btnDownloadExcel;
	}

	public ExtendedWebElement getBtnDownloadCSV() {
		return btnDownloadCSV;
	}

	public ExtendedWebElement getIconDateFrom() {
		return iconDateFrom;
	}

	public ExtendedWebElement getIconDateTo() {
		return iconDateTo;
	}

	public ExtendedWebElement getTabMarginReport() {
		return tabMarginReport;
	}

	public ExtendedWebElement getLabelMarginReport() {
		return labelMarginReport;
	}

	public ExtendedWebElement getInputSearchProduct() {
		return inputSearchProduct;
	}

	public ExtendedWebElement getOptionProduct() {
		return optionProduct;
	}

	public ExtendedWebElement getBtnSearch() {
		return btnSearch;
	}

	public ExtendedWebElement getLabelIBR() {
		return labelIBR;
	}

	public ExtendedWebElement getRadioCurrentIBR() {
		return radioCurrentIBR;
	}

	public ExtendedWebElement getRadioHistoricalIBR() {
		return radioHistoricalIBR;
	}

	public ExtendedWebElement getTabIBG() {
		return tabIBG;
	}

	public ExtendedWebElement getTabDomestic() {
		return tabDomestic;
	}

	public ExtendedWebElement getLabelOutputFiles() {
		return labelOutputFiles;
	}

	public ExtendedWebElement getSelectProductData() {
		return selectProductData;
	}

	public ExtendedWebElement getOptionSelectAll() {
		return optionSelectAll;
	}

	public ExtendedWebElement getOptionSelectProduct() {
		return optionSelectProduct;
	}

	public ExtendedWebElement getBtn_Go() {
		return btn_Go;
	}

	public ExtendedWebElement getTabOtherSourceReport() {
		return tabOtherSourceReport;
	}

	public ExtendedWebElement getLabelOtherSourceReport() {
		return labelOtherSourceReport;
	}

	public ExtendedWebElement getBtnSelectDateFrom() {
		return btnSelectDateFrom;
	}

	public ExtendedWebElement getBtnSelectDateTo() {
		return btnSelectDateTo;
	}

	public ExtendedWebElement getSelectDateFrom() {
		return selectDateFrom;
	}

	public ExtendedWebElement getTabIBRReport() {
		return tabIBRReport;
	}

}
