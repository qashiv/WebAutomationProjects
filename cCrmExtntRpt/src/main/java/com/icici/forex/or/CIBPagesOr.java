package com.icici.forex.or;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class CIBPagesOr extends AbstractPage {

	public CIBPagesOr(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@class='list-text' and text()='Treasury']//ancestor::a")
	private ExtendedWebElement menuTreasury;

	@FindBy(xpath = "//a[text()='i-Treasury']")
	private ExtendedWebElement linkITreasury;

	@FindBy(xpath = "//a[text()='Insta Forward']")
	private ExtendedWebElement linkInstaForward;

	@FindBy(xpath = "//a[text()='ICICI DEALZ']")
	private ExtendedWebElement linkICICIDealz;

	@FindBy(xpath = "//a[text()='Insta Limit for Bullion']")
	private ExtendedWebElement linkInstaLimitForBullion;

	@FindBy(xpath = "//a[text()='Tresure On Boarding']")
	private ExtendedWebElement linkTreasureOnboarding;

	@FindBy(xpath = "//a[text()='Sovereign Gold Bonds']")
	private ExtendedWebElement linkSovereignGoldBonds;

	@FindBy(xpath = "//a[text()='FX OnBoarding']")
	private ExtendedWebElement linkFXOnboarding;

	@FindBy(xpath = "//a[text()='Forex Platform']")
	private ExtendedWebElement linkForexPlatform;

	@FindBy(xpath = "//div[text()='Customer Selection']")
	private ExtendedWebElement txtCustomerSelection;

	@FindBy(xpath = "//*[text()='Customer ID']//..//div//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectCustId;

	@FindBy(xpath = "//mat-option[@role='option']")
	private ExtendedWebElement selectOption;

	@FindBy(xpath = "//*[text()='Account No']//..//div//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectAccountNo;

	@FindBy(xpath = "//div[contains(@class,'container')]//p")
	private ExtendedWebElement accountStatusByStub;

	public ExtendedWebElement getAccountStatusByStub() {
		return accountStatusByStub;
	}

	public ExtendedWebElement getSelectAccountNo() {
		return selectAccountNo;
	}

	public ExtendedWebElement getSelectOption() {
		return selectOption;
	}

	public ExtendedWebElement getSelectCustId() {
		return selectCustId;
	}

	public ExtendedWebElement getTxtCustomerSelection() {
		return txtCustomerSelection;
	}

	public ExtendedWebElement getMenuTreasury() {
		return menuTreasury;
	}

	public ExtendedWebElement getLinkITreasury() {
		return linkITreasury;
	}

	public ExtendedWebElement getLinkInstaForward() {
		return linkInstaForward;
	}

	public ExtendedWebElement getLinkICICIDealz() {
		return linkICICIDealz;
	}

	public ExtendedWebElement getLinkInstaLimitForBullion() {
		return linkInstaLimitForBullion;
	}

	public ExtendedWebElement getLinkTreasureOnboarding() {
		return linkTreasureOnboarding;
	}

	public ExtendedWebElement getLinkSovereignGoldBonds() {
		return linkSovereignGoldBonds;
	}

	public ExtendedWebElement getLinkFXOnboarding() {
		return linkFXOnboarding;
	}

	public ExtendedWebElement getLinkForexPlatform() {
		return linkForexPlatform;
	}

}
