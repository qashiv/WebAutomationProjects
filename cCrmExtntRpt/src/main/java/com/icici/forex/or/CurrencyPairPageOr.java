package com.icici.forex.or;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class CurrencyPairPageOr extends AbstractPage {

	protected CurrencyPairPageOr(WebDriver driver) {
		super(driver);
	}

	public ExtendedWebElement getHeaderCurrencyPair() {
		return headerCurrencyPair;
	}

	public ExtendedWebElement getSelectBusinessGroup() {
		return selectBusinessGroup;
	}

	public ExtendedWebElement getSelectSubBusinessGroup() {
		return selectSubBusinessGroup;
	}

	public ExtendedWebElement getSelectServicesOffered() {
		return selectServicesOffered;
	}

	public List<ExtendedWebElement> getOptionsServicesOffered() {
		return optionsServicesOffered;
	}

	public ExtendedWebElement getTxtSelectFromServicesOffered() {
		return txtSelectFromServicesOffered;
	}

	public ExtendedWebElement getSelectPricingType() {
		return selectPricingType;
	}

	public ExtendedWebElement getTxtSelectFromSelectCurrencyPair() {
		return txtSelectFromSelectCurrencyPair;
	}

	public ExtendedWebElement getSelectCurrencyPair() {
		return selectCurrencyPair;
	}

	public ExtendedWebElement getInputSearchCurrencyPair() {
		return inputSearchCurrencyPair;
	}

	public ExtendedWebElement getBtnResetCurrencyPairAdded() {
		return btnResetCurrencyPairAdded;
	}

	public ExtendedWebElement getTxtSelectCurrencyPairbyStub() {
		return txtSelectCurrencyPairbyStub;
	}

	public ExtendedWebElement getMsgCurrencyPairAdded() {
		return msgCurrencyPairAdded;
	}

	public List<ExtendedWebElement> getImageCancel() {
		return imageCancel;
	}

	public ExtendedWebElement getSelectedCurrencyPair() {
		return selectedCurrecyPair;
	}

	@FindBy(xpath = "//*[text()='Select Currency Pair']//following::app-dropdown//span[contains(@class,'selected-value')]")
	private ExtendedWebElement selectedCurrecyPair;

	@FindBy(xpath = "//img[@alt='cancel']")
	private List<ExtendedWebElement> imageCancel;

	@FindBy(xpath = "//*[contains(text(),'Added')]")
	private ExtendedWebElement msgCurrencyPairAdded;

	@FindBy(xpath = "//div[text()='Currency Pairs']")
	private ExtendedWebElement headerCurrencyPair;

	@FindBy(xpath = "//*[text()='Business Group']/parent::div/..//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectBusinessGroup;

	@FindBy(xpath = "//*[text()='Sub-business Group']//parent::div/..//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectSubBusinessGroup;

	@FindBy(xpath = "//*[text()='Services Offered']/parent::div/..//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectServicesOffered;

	@FindBy(xpath = "//div[contains(@class , 'options-inner-container')]//div//mat-checkbox")
	private List<ExtendedWebElement> optionsServicesOffered;

	@FindBy(xpath = "//*[text()='Services Offered']//ancestor::div[@class='dropdown-container']//div/span")
	private ExtendedWebElement txtSelectFromServicesOffered;

	@FindBy(xpath = "//*[text()='Pricing Type']/parent::div/..//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectPricingType;

	@FindBy(xpath = "//*[text()='Select Currency Pair']//ancestor::div[contains(@class,'dropdown-container')]//div/span")
	private ExtendedWebElement txtSelectFromSelectCurrencyPair;

	@FindBy(xpath = "//*[text()='Select Currency Pair']//ancestor::div[contains(@class,'-container')]//div//span[text()='Select']")
	private ExtendedWebElement txtSelectCurrencyPairbyStub;

	@FindBy(xpath = "//*[text()='Select Currency Pair']/parent::div/..//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectCurrencyPair;

	@FindBy(xpath = "//input[@class='search-input']")
	private ExtendedWebElement inputSearchCurrencyPair;

	@FindBy(xpath = "//button[normalize-space()='Reset']")
	private ExtendedWebElement btnResetCurrencyPairAdded;

}
