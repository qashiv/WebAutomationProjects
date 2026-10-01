package com.icici.forex.or;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class CounterpartyMasterPageOr extends AbstractPage {

	public CounterpartyMasterPageOr(WebDriver driver) {
		super(driver);
	}

	public ExtendedWebElement getTabCounterpartyMaster() {
		return tabCounterpartyMaster;
	}

	public ExtendedWebElement getInputDailyLimit() {
		return inputDailyLimit;
	}

	public ExtendedWebElement getInputTransactionLimit() {
		return inputTransactionLimit;
	}

	public ExtendedWebElement getInputTraderLimit() {
		return inputTraderLimit;
	}

	public ExtendedWebElement getSelectChannel() {
		return selectChannel;
	}

	@FindBy(xpath = "//div[text()='Counterparty Master']")
	private ExtendedWebElement tabCounterpartyMaster;

	@FindBy(xpath = "//input[@formcontrolname='dailyLimit']")
	private ExtendedWebElement inputDailyLimit;

	@FindBy(xpath = "//input[@formcontrolname='transactionLimit']")
	private ExtendedWebElement inputTransactionLimit;

	@FindBy(xpath = "//input[@formcontrolname='traderLimit']")
	private ExtendedWebElement inputTraderLimit;

	@FindBy(xpath = "//*[text()='Channel']/parent::div/..//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectChannel;

}
