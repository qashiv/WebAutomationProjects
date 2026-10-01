package com.icici.forex.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.icici.forex.or.CIBPagesOr;

public class CIBPages extends CIBPagesOr {

	ExtentTest test;
	CommonReusableMethods reusable;

	public CIBPages(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
	}

	public void startCustomerJourneyByForexPlatform(String verificationText) {

		reusable = new CommonReusableMethods(driver, test);
		getMenuTreasury().clickByJs();
		reusable.holdOn(1);
		getLinkForexPlatform().clickByJs();
		reusable.holdOn(3);
		Set<String> handleValues = driver.getWindowHandles();
		for (String handleValue : handleValues) {
			driver.switchTo().window(handleValue);
			String verifyText = getTxtCustomerSelection().getText();
			if (verificationText.equalsIgnoreCase(verifyText)) {
				break;
			}
		}
		driver.manage().window().maximize();
		getSelectCustId().clickByJs();
		getSelectOption().clickByJs();
		reusable.holdOn(1);
		getSelectAccountNo().clickByJs();
		getSelectOption().clickByJs();
		
	}
}
