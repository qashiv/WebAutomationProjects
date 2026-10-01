package com.icici.forex.pages;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.icici.forex.or.CurrencyPairPageOr;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class CurrencyPairPage extends CurrencyPairPageOr {

	Logger logger = Logger.getLogger(CurrencyPairPage.class.getName());
	CommonReusableMethods reusable;
	ExtentTest test;

	public CurrencyPairPage(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
	}

	public void selectCurrencyPairDetails(String selectCategory, String selectSubCategory, String serviceOffered,
			String pricingType) {

		reusable = new CommonReusableMethods(getDriver(), test);
		reusable.holdOn(2);
		getSelectBusinessGroup().click();
		reusable.selectFromDropdown(selectCategory);
		getSelectSubBusinessGroup().click();
		reusable.selectFromDropdown(selectSubCategory);
		String selectedServicesOffered = getTxtSelectFromServicesOffered().getText();
		if (selectedServicesOffered.equals("Select")) {
			getSelectServicesOffered().click();
			reusable.selectFromDropdown(serviceOffered);
		}
		getSelectPricingType().click();
		reusable.selectFromDropdown(pricingType);
	}

	public void selectCurrencyPairDetailsIBG(String pricingType) {
		reusable = new CommonReusableMethods(getDriver(), test);
		reusable.holdOn(2);
		getSelectPricingType().click();
		reusable.selectFromDropdown(pricingType);
	}

	public void selectCurrencyPairNoReset(String currencyPairFromExl) {
		reusable = new CommonReusableMethods(getDriver(), test);
		reusable.holdOn(2);
		if (getTxtSelectFromSelectCurrencyPair().getText().equals("Select")) {
			getSelectCurrencyPair().click();
			String[] searchCurrencyPair = reusable.getStringArray(currencyPairFromExl);
			for (int i = 0; i < searchCurrencyPair.length; i++) {
				getInputSearchCurrencyPair().type(searchCurrencyPair[i]);
				reusable.holdOn(2);
				reusable.selectMultipleFromDropdown(searchCurrencyPair[i]);
			}
		}
	}

	public void selectCurrencyPair(String currencyPairFromExl) {
		reusable = new CommonReusableMethods(getDriver(), test);
		reusable.holdOn(2);
		try {
			if (getTxtSelectCurrencyPairbyStub().getText().equals("Select")) {
				getSelectCurrencyPair().click();
				String[] searchCurrencyPair = reusable.getStringArray(currencyPairFromExl);
				for (int i = 0; i < searchCurrencyPair.length; i++) {
					getInputSearchCurrencyPair().type(searchCurrencyPair[i]);
					reusable.holdOn(1);
					reusable.selectMultipleFromDropdown(searchCurrencyPair[i]);
				}
			}
		} catch (NoSuchElementException e) {
			if (getMsgCurrencyPairAdded().getText().contains("Added")) {
				getSelectCurrencyPair().clickByJs();
				reusable.holdOn(1);
				getBtnResetCurrencyPairAdded().clickByJs();
				reusable.holdOn(1);
				String[] searchCurrencyPair = reusable.getStringArray(currencyPairFromExl);
				for (int i = 0; i < searchCurrencyPair.length; i++) {
					getInputSearchCurrencyPair().type(searchCurrencyPair[i]);
					reusable.holdOn(1);
					reusable.selectMultipleFromDropdown(searchCurrencyPair[i]);
				}
			}
		} catch (Exception ex) {
			test.log(Status.FAIL, "Unable to Select Currency Pair");
			ex.printStackTrace();
		}
	}

	public void resetCurrencyPair() {
		reusable = new CommonReusableMethods(driver, test);
		getSelectCurrencyPair().clickByJs();
		reusable.holdOn(1);
		getBtnResetCurrencyPairAdded().clickByJs();
		reusable.holdOn(1);
		getSelectCurrencyPair().clickByJs();
	}

	public void cancelCurrencyPairByText(String currencyPairText) {
		ExtendedWebElement cancelCurrenyPair = findExtendedWebElement(
				By.xpath("//span[text()='" + currencyPairText + "']/following-sibling::img[@alt='cancel']"));
		cancelCurrenyPair.click();
	}

	public void openCurrencyPairPageByTab() {
		getHeaderCurrencyPair().click();
	}
}
