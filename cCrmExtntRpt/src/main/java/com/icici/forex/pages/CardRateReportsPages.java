package com.icici.forex.pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.icici.forex.or.CardRateReportsPagesOr;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class CardRateReportsPages extends CardRateReportsPagesOr {

	public ExtentTest test;
	private CommonReusableMethods reusable;
	public List<String> cashBankSellingRates;

	public CardRateReportsPages(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
	}

	public void verifyIBRReport(String marketType, String IBRType) {
		reusable = new CommonReusableMethods(driver, test);
		getTabIBRReport().clickByJs();
		reusable.holdOn(1);
		reusable.selectMarketType(marketType);
		if (IBRType.equals("Current IBR")) {
			getRadioCurrentIBR().clickByActions();

		} else if (IBRType.equals("Historical IBR")) {
			getRadioHistoricalIBR().clickByActions();
			reusable.holdOn(1);
			getBtnSelectDateFrom().clickByJs();
			getSelectDateFrom().clickByJs();
			getInputHour().type("09");
			reusable.holdOn(1);
			getInputMinute().type("15");
			getBtnAccept().clickByJs();
			reusable.holdOn(1);
			getBtnSelectDateTo().clickByJs();
			SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, YYYY");
			String current_Date = sdf.format(new Date());
			ExtendedWebElement currentDate = findExtendedWebElement(
					By.xpath("//td[@aria-label='" + current_Date + "']"));
			currentDate.clickByJs();
			getInputHour().type("16");
			reusable.holdOn(1);
			getInputMinute().type("00");
			getBtnAccept().clickByJs();
			reusable.holdOn(2);
			getBtnGo().clickByJs();
		}
		getBtnDownloadPdf().clickByActions();
		getBtnDownloadExcel().clickByActions();

	}

	public void goToOutputFiles() {
		getTabOutputFiles().clickByJs();
	}

	public String checkPublishedReportFromOutputFiles(String marketType, String productName) {
		goToOutputFiles();
		reusable = new CommonReusableMethods(driver, test);
		reusable.selectMarketType(marketType);
		getSelectProduct().clickByJs();
		getInputProduct().type(productName);
		reusable.holdOn(1);
		getOptionProduct().clickByJs();
		reusable.holdOn(1);
		getBtnGo().clickByJs();
		reusable.holdOn(2);
//		getLinkDownloadFiles().get(0).clickByJs();
//		getLinkDownloadFiles().get(1).clickByJs();
		ExtendedWebElement prodName = findExtendedWebElement(By.xpath("//td[contains(@title,'"+productName+"')]"));
		return prodName.getText();
	}

	public void verifyCardRatesReport(String marketType, String cardRateType, String productName) {
		reusable = new CommonReusableMethods(driver, test);
		getTabCardRates().clickByJs();
		reusable.holdOn(1);
		if (marketType.equals("Domestic")) {
			getTabDomestic().clickByJs();
		} else if (marketType.equals("IBG")) {
			getTabIBG().clickByJs();
		}
		if (cardRateType.equals("Current")) {
			getRadioCurrentCardRate().clickByActions();

		} else if (cardRateType.equals("Historical")) {
			getRadioHistoricalCardRate().clickByActions();
			reusable.holdOn(1);
			getBtnSelectDateFrom().clickByJs();
			getSelectDateFrom().clickByJs();
			getInputHour().type("09");
			reusable.holdOn(1);
			getInputMinute().type("15");
			getBtnAccept().clickByJs();
			reusable.holdOn(1);
			getBtnSelectDateTo().clickByJs();
			SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, YYYY");
			String current_Date = sdf.format(new Date());
			ExtendedWebElement currentDate = findExtendedWebElement(
					By.xpath("//td[@aria-label='" + current_Date + "']"));
			currentDate.clickByJs();
			getInputHour().type("16");
			reusable.holdOn(1);
			getInputMinute().type("00");
			getBtnAccept().clickByJs();
		}
		getSelectProduct().clickByJs();
		reusable.holdOn(1);
		getInputProduct().type(productName);
		reusable.selectFromDropdown(productName);
		reusable.holdOn(2);
		getBtnGo().clickByJs();
		getBtnDownloadPdf().clickByActions();
		getBtnDownloadExcel().clickByActions();
		getBtnDownloadCSV().clickByActions();
	}

	public List<String> returnSellingRatesFromIBR(String currencyPairForRates) { /// Rajesh
		reusable = new CommonReusableMethods(driver, test);
		String[] currencyPairForIBRRate = reusable.getStringArray(currencyPairForRates);
		cashBankSellingRates = new ArrayList<String>();
		int k = 0;
		int size = getTextCashBankSellingRate().size();
		try {
			for (int i = 0; i < size; i++) {
				String currencyPairFC = getTextBaseRateCurrencyPair().get(i).getAttribute("title");
				if (currencyPairFC.equals(currencyPairForIBRRate[k])) {
					String text = getTextCashBankSellingRate().get(i).getAttribute("title");
					cashBankSellingRates.add(text);
					k++;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			test.log(Status.INFO, e.getMessage());
		}
		return cashBankSellingRates;
	}
}
