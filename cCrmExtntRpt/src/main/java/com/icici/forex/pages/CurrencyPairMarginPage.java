package com.icici.forex.pages;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.icici.forex.or.CurrencyPairMarginPageOr;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class CurrencyPairMarginPage extends CurrencyPairMarginPageOr {

	Logger logger = Logger.getLogger(CurrencyPairMarginPage.class.getName());
	public CommonReusableMethods reusable;
	ExtentTest test;

	public CurrencyPairMarginPage(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
	}

	public void uploadCpyMarginFile(String filePath) {
		getBtnUploadFile().attachFile(filePath);
		logger.info("Currency Pairs Margin File Uploaded Successfully");
	}

	public void downloadExcelFile() {
		getBtnDownloadExcel().click();
		logger.info("Currency Pair Margin File Downloaded Successfully");
	}

	public void addNewRow(String srNo, String tenors, String currencyPair, String units, String dealingChannel,
			String minAmtRange, String maxAmtRange, String bid, String ask) {
		getBtnAddNewRow().click();
		getSelectTenor().click();
		reusable = new CommonReusableMethods(getDriver(), test);
		reusable.selectMultipleFromDropdown(tenors);
		getSelectCurrencyPair().click();
		getInputSearchCurrencyPair().type(currencyPair);
		getSelectOptionText().clickByJs();
		ExtendedWebElement selectUnit = findExtendedWebElement(
				By.xpath("//*[@role='rowgroup']//tr[" + srNo + "]//td[4]//div[contains(@class,'icon-container')]"));
		selectUnit.clickByJs();
		reusable.holdOn(2);
		reusable.selectFromDropdown(units);
		reusable.holdOn(2);
		ExtendedWebElement selectDealingChannel = findExtendedWebElement(
				By.xpath("//*[@role='rowgroup']//tr[" + srNo + "]//td[5]//div[contains(@class,'icon-container')]"));
		selectDealingChannel.clickByJs();
		reusable.selectFromDropdown(dealingChannel);
		reusable.holdOn(1);
		getInputMinAmountRange().type(minAmtRange);
		getInputMaxAmountRange().type(maxAmtRange);
		getInputBid().type(bid);
		getInputAsk().type(ask);
		ExtendedWebElement iconSave = findExtendedWebElement(By.xpath("//tr[" + srNo + "]//img[@alt='Save image']"));
		iconSave.clickByJs();
	}

	public void editMargin(String srNo, String units, String dealingChannel, String minAmtRange, String maxAmtRange,
			String bid, String ask) {
		CommonReusableMethods reusable = new CommonReusableMethods(driver, test);
		ExtendedWebElement iconEdit = findExtendedWebElement(By.xpath("//tr[" + srNo + "]//img[@alt='Edit image']"));
		iconEdit.scrollTo();
		iconEdit.clickByJs();
		ExtendedWebElement selectUnit = findExtendedWebElement(
				By.xpath("//*[@role='rowgroup']//tr[" + srNo + "]//td[4]//div[contains(@class,'icon-container')]"));
		selectUnit.clickByJs();
		reusable.holdOn(1);
		reusable.selectFromDropdown(units);
		reusable.holdOn(1);
		ExtendedWebElement selectDealingChannel = findExtendedWebElement(
				By.xpath("//*[@role='rowgroup']//tr[" + srNo + "]//td[5]//div[contains(@class,'icon-container')]"));
		selectDealingChannel.clickByJs();
		if (!getVerifyFXOnlineCheckbox().getAttribute("class").contains("checkbox-checked")) {
			reusable.selectFromDropdown(dealingChannel);
		}
		reusable.holdOn(1);
		getInputMinAmountRange().type(minAmtRange);
		getInputMaxAmountRange().type(maxAmtRange);
		getInputBid().type(bid);
		getInputAsk().scrollTo();
		reusable.holdOn(1);
		getInputAsk().type(ask);
		ExtendedWebElement iconSave = findExtendedWebElement(By.xpath("//tr[" + srNo + "]//img[@alt='Save image']"));
		iconSave.clickByJs();
	}

	public void putComments(String comments) {
		getInputComments().type(comments);
	}

	public void openCPMarginPageByTab() {
		getTabCurrencyPairsMargin().click();
	}
}
