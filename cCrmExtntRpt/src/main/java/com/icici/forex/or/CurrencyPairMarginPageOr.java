package com.icici.forex.or;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class CurrencyPairMarginPageOr extends AbstractPage {

	protected CurrencyPairMarginPageOr(WebDriver driver) {
		super(driver);
	}

	public ExtendedWebElement getBtnDownloadExcel() {
		return btnDownloadExcel;
	}

	public ExtendedWebElement getBtnAddNewRow() {
		return btnAddNewRow;
	}

	public ExtendedWebElement getBtnUploadFile() {
		return btnUploadFile;
	}

	public ExtendedWebElement getInputComments() {
		return inputComments;
	}

	public ExtendedWebElement getBtnEdit() {
		return btnEdit;
	}

	public ExtendedWebElement getSelectTenor() {
		return selectTenor;
	}

	public ExtendedWebElement getSelectCurrencyPair() {
		return selectCurrencyPair;
	}

	public ExtendedWebElement getSelectUnits() {
		return selectUnits;
	}

	public ExtendedWebElement getSelectDealingChannel() {
		return selectDealingChannel;
	}

	public ExtendedWebElement getInputSearchCurrencyPair() {
		return inputSearchCurrencyPair;
	}

	public List<ExtendedWebElement> getSelectCurrencyPairOptions() {
		return selectCurrencyPairOptions;
	}

	public ExtendedWebElement getSelectOptionText() {
		return selectOptionText;
	}

	public ExtendedWebElement getInputMinAmountRange() {
		return inputMinAmountRange;
	}

	public ExtendedWebElement getInputMaxAmountRange() {
		return inputMaxAmountRange;
	}

	public ExtendedWebElement getIconSave() {
		return IconSave;
	}

	public ExtendedWebElement getTabCurrencyPairsMargin() {
		return tabCurrencyPairsMargin;
	}

	public ExtendedWebElement getInputBid() {
		return inputBid;
	}

	public ExtendedWebElement getInputAsk() {
		return inputAsk;
	}

	public ExtendedWebElement getVerifyFXOnlineCheckbox() {
		return verifyFXOnlineCheckbox;
	}

	@FindBy(xpath = "//div[normalize-space()='Fx Online']//parent::div/div/mat-checkbox")
	private ExtendedWebElement verifyFXOnlineCheckbox;

	@FindBy(xpath = "//td[contains(@class,'buyMargin')]//input[@name='buyMargin']")
	private ExtendedWebElement inputAsk;

	@FindBy(xpath = "//td[contains(@class,'sellMargin')]//input[@name='buyMargin']")
	private ExtendedWebElement inputBid;

	@FindBy(xpath = "//span[text()='Download Excel']/parent::button")
	private ExtendedWebElement btnDownloadExcel;

	@FindBy(xpath = "//span[text()='Add New Row']/ancestor::button")
	private ExtendedWebElement btnAddNewRow;

	@FindBy(xpath = "//input[@type='file']")
	private ExtendedWebElement btnUploadFile;

	@FindBy(xpath = "//textarea[@name='comments']")
	private ExtendedWebElement inputComments;

	@FindBy(xpath = "//img[@alt='Edit image']")
	private ExtendedWebElement btnEdit;

	@FindBy(xpath = "(//*[@role='rowgroup']//tr[last()]//div[contains(@class,'icon-container')])[1]")
	private ExtendedWebElement selectTenor;

	@FindBy(xpath = "(//*[@role='rowgroup']//tr[last()]//div[contains(@class,'icon-container')])[2]")
	private ExtendedWebElement selectCurrencyPair;

	@FindBy(xpath = "//*[@role='rowgroup']//tr[3]//td[4]//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectUnits;

	@FindBy(xpath = "(//*[@role='rowgroup']//tr[last()]//div[contains(@class,'icon-container')])[4]")
	private ExtendedWebElement selectDealingChannel;

	@FindBy(xpath = "//input[@class='search-input']")
	private ExtendedWebElement inputSearchCurrencyPair;

	@FindBy(xpath = "//div[contains(@class,'options-inner-container')]")
	private List<ExtendedWebElement> selectCurrencyPairOptions;

	@FindBy(xpath = "//div[@class='option-text']")
	private ExtendedWebElement selectOptionText;

	@FindBy(xpath = "//input[@name='minAmount']")
	private ExtendedWebElement inputMinAmountRange;

	@FindBy(xpath = "//input[@name='maxAmount']")
	private ExtendedWebElement inputMaxAmountRange;

	@FindBy(xpath = "(//img[@alt='Save image'])[last()]")
	private ExtendedWebElement IconSave;

	@FindBy(xpath = "//*[text()='Currency Pairs Margin']")
	private ExtendedWebElement tabCurrencyPairsMargin;
}
