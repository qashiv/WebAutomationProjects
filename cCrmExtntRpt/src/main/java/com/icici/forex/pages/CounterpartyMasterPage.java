package com.icici.forex.pages;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.icici.forex.or.CounterpartyMasterPageOr;

public class CounterpartyMasterPage extends CounterpartyMasterPageOr {

	Logger logger = Logger.getLogger(CounterpartyMasterPage.class.getName());
	CommonReusableMethods reusable;
	ExtentTest test;

	public CounterpartyMasterPage(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
	}

	public void setLimitAndContinue(String dailyLimitInUSD, String transLimitInUSD, String traderLimitInUSD,
			String channelOpt) {
		reusable = new CommonReusableMethods(getDriver(), test);
		getInputDailyLimit().type(dailyLimitInUSD);
		getInputTransactionLimit().type(transLimitInUSD);
		getInputTraderLimit().type(traderLimitInUSD);
        reusable.holdOn(1);
		getSelectChannel().clickByJs();
		reusable.holdOn(1);
		reusable.selectFromDropdown(channelOpt);
		reusable.saveAndContinue();
	}

	public void openCPMasterPageByTab() {
		getTabCounterpartyMaster().click();
	}
}
