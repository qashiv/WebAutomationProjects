package com.icici.forex.pages;

import java.util.logging.Logger;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.icici.forex.or.AdditionalFeaturesPageOr;

public class AdditionalFeaturesPage extends AdditionalFeaturesPageOr {

	Logger logger = Logger.getLogger(AdditionalFeaturesPage.class.getName());
	CommonReusableMethods reusable;
	ExtentTest test;

	public AdditionalFeaturesPage(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
	}

	public void selectApprovers(String approvers) {

		reusable = new CommonReusableMethods(getDriver(), test);
		getSelectApprover().get(0).scrollTo();
		reusable.holdOn(1);
		String[] approver = reusable.getStringArray(approvers);
		for (int i = 0; i < getSelectApprover().size(); i++) {
			getSelectApprover().get(i).clickByJs();
			reusable.holdOn(1);
			reusable.selectFromDropdown(approver[i]);
			reusable.holdOn(1);
		}
	}

	public void provideAdditionalFeature(String rate, String isNetting, String isBulkDeal, String isPassCashSpot,
			String isOrders, String orderType, String eDRolloverCancellation) {
		reusable = new CommonReusableMethods(getDriver(), test);
		if (rate.equalsIgnoreCase("Net Rate") && getRadioNetRate().isChecked() == false) {
			getCheckNetRate().click();
		} else {
			getCheckBreakupSpotSwap().click();
		}
		if (isNetting.equalsIgnoreCase("Yes")) {
			getToggleNettingMatchingDeal().click();
		}
		if (isBulkDeal.equalsIgnoreCase("Yes")) {
			getToggleBulkDealBooking().click();
		}

		String statusCashPass = getTogglePassCashSpot().getAttribute("class");
		if (isPassCashSpot.equalsIgnoreCase("Yes")) {
			if (statusCashPass.contains("mat-checked")) {
				test.log(Status.INFO, "Toggle Pass Cash Spot is already checked");
			} else {
				getTogglePassCashSpot().click();
			}
		}

		String statusIsOrders = getToggleOrders().getAttribute("class");
		if (isOrders.equalsIgnoreCase("Yes")) {
			if (statusIsOrders.contains("mat-checked")) {
				test.log(Status.INFO, "Toggle IsOrders is already checked");
			} else {
				getToggleOrders().click();
				getSelectOrdersType().click();
				reusable.holdOn(1);
				reusable.selectFromDropdown(orderType);
			}
		}

		String checkAvailability = getStatusEDRollover().getAttribute("class");
		if (checkAvailability.contains("disabled")) {
			test.log(Status.INFO, "ED/Rollover/Cancellation is disabled");
		} else {
			getSelectEDRolloverCancellation().click();
			reusable.selectFromDropdown(eDRolloverCancellation);
		}
	}

	public void openAddFeaturesPageByTab() {
		try {
			getTabAddFeatures().click();
		} catch (ElementClickInterceptedException e) {
			getTabAddFeatures().clickByJs();
		} catch (Exception ex) {
			test.log(Status.FAIL, "Unable to click on Features tab : " + ex.getMessage());
		}
	}
}
