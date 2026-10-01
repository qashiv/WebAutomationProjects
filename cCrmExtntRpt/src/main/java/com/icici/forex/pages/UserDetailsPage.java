package com.icici.forex.pages;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.icici.forex.or.UserDetailsPageOr;

public class UserDetailsPage extends UserDetailsPageOr {

	Logger logger = Logger.getLogger(UserDetailsPage.class.getName());
	private CommonReusableMethods reusable;
	ExtentTest test;

	public UserDetailsPage(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
	}

	public void provideAccHolderDetailsAndSubmit(String accountNo, String branchSolId) {
		getInputAccountNo().type(accountNo);
		test.log(Status.INFO, "Account number entered : "+ accountNo);
		reusable = new CommonReusableMethods(getDriver(), test);
		if(getTxtSelect().getText().equalsIgnoreCase("Select")) {
			getSelectBranchSolID().click();
			getInputSOLIdSearch().type(branchSolId);
			getOptionBranchSolId().click();
		}
		reusable.holdOn(2);
		getBtnSubmit().click();
	}

	public void provideNonAccHolderDetailsAndSubmit(String companyName) {
		getRadioNonAccountHolder().check();
		reusable = new CommonReusableMethods(getDriver(), test);
		reusable.holdOn(2);
		getInputCompanyName().type(companyName);
		for (int i = 0; i < getOptionListBox().size(); i++) {
			String option = getOptionListBox().get(i).getText().trim();
			if (option.equalsIgnoreCase(companyName)) {
				getOptionListBox().get(i).click();
				break;
			}
		}
		reusable.holdOn(2);
		getBtnSubmit().click();
	}
}
