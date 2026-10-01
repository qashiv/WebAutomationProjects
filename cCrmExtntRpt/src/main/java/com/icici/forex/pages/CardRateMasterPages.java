package com.icici.forex.pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.icici.forex.or.CardRateMasterPagesOr;

public class CardRateMasterPages extends CardRateMasterPagesOr {

	public ExtentTest test;
	public CommonReusableMethods reusable;
	String actProductName;

	public CardRateMasterPages(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
	}

	public String addProductsInProductMaster(String marketType, String productName, String INFY_Finacle, String remark,
			String marginSlabs, String currencyPair, String marginType, String bankSellingMargin,
			String bankBuyingMargin, String slabRangeFrom, String slabRangeTo) {

		getTabProductMaster().clickByJs();
		reusable = new CommonReusableMethods(driver, test);
		reusable.holdOn(1);
		reusable.selectMarketType(marketType);
		getBtnAddNew().clickByJs();
		SimpleDateFormat sdf = new SimpleDateFormat("mm_ss");
		String dateFormat = sdf.format(new Date());
		actProductName = productName + dateFormat;
		getInputProductOrGeography().type(actProductName);
		getSelectChannel().clickByJs();
		getInputSearch().type(INFY_Finacle);
		reusable.holdOn(1);
		getOptionChannel().clickByJs();
		getInputRemark().type(remark);
		String[] currencyPairs = reusable.getStringArray(currencyPair);
		String[] marginTypes = reusable.getStringArray(marginType);
		String[] bankSellingMargins = reusable.getStringArray(bankSellingMargin);
		String[] bankBuyingMargins = reusable.getStringArray(bankBuyingMargin);

		if (marginSlabs.equalsIgnoreCase("Margin without slab")) {
			getRadioMarginWithoutSlab().clickByActions();
			reusable.holdOn(2);
			for (int i = 0; i < currencyPairs.length; i++) {
				getSelectCurrencyPair().clickByJs();
				getInputCurrencyPair().type(currencyPairs[i]);
				reusable.holdOn(1);
				getOptionCurrencyPair().clickByJs();
				getSelectMarginType().clickByJs();
				reusable.selectFromDropdown(marginTypes[i]);
				getInputBankSellingMargin().type(bankSellingMargins[i]);
				reusable.holdOn(1);
				getInputBankBuyingMargin().type(bankBuyingMargins[i]);
				reusable.holdOn(1);
				getBtnAddMarginSlab().scrollTo();
				reusable.holdOn(1);
				getBtnAddMarginSlab().clickByActions();
			}
			getBtnDelete().clickByActions();

		} else if (marginSlabs.equalsIgnoreCase("Margin with slab")) {
			getRadioMarginWithSlab().clickByActions();
			reusable.holdOn(1);
			String[] slabRangesFrom = reusable.getStringArray(slabRangeFrom);
			String[] slabRangesTo = reusable.getStringArray(slabRangeTo);
			for (int i = 0; i < currencyPairs.length; i++) {
				getSelectCurrencyPair().clickByJs();
				getInputCurrencyPair().type(currencyPairs[i]);
				reusable.holdOn(1);
				getOptionCurrencyPair().clickByJs();
				getSelectMarginType().clickByJs();
				reusable.selectFromDropdown(marginTypes[i]);
				getInputSlabRangeFrom().type(slabRangesFrom[i]);
				getInputSlabRangeTo().type(slabRangesTo[i]);
				getInputBankSellingMargin().type(bankSellingMargins[i]);
				getInputBankBuyingMargin().type(bankBuyingMargins[i]);
				if (currencyPairs.length > 0) {
					getBtnAddMarginUnderSlabs().clickByActions();
				}
			}
			getBtnDelete1().clickByActions();
		}

		reusable.holdOn(1);
		getBtnSubmit().scrollTo();
		reusable.holdOn(1);
		getBtnSubmit().clickByActions();
		return actProductName;
	}

	public void goToProductMaster() {
		getTabProductMaster().clickByJs();
	}

	public void updateProductOnProductMaster(String marketType, String productName, String marginSlab,
			String currencyPair, String marginType, String slabRangeFrom, String slabRangeTo, String bankSellingMargin,
			String bankBuyingMargin) {
		reusable = new CommonReusableMethods(driver, test);
		String[] ccyPairs = reusable.getStringArray(currencyPair);
		String[] marginTypes = reusable.getStringArray(marginType);
		String[] bankSellingMargins = reusable.getStringArray(bankSellingMargin);
		String[] bankBuyingMargins = reusable.getStringArray(bankBuyingMargin);
		String[] slabRangesFrom = reusable.getStringArray(slabRangeFrom);
		String[] slabRangesTo = reusable.getStringArray(slabRangeTo);
		reusable.selectMarketType(marketType);
		reusable.holdOn(1);
		getInputProductName().type(productName);
		getBtnSearch().clickByActions();
		getIconEdit().clickByJs();
		reusable.holdOn(2);
		String verifyStatus = getToggleStatus().getAttribute("aria-checked");
		if (!verifyStatus.equals("true")) {
			getToggleStatus().clickByJs();
		}
		if (getRadioMarginWithSlab().isChecked()) {
			reusable.holdOn(1);
			getRadioMarginWithSlab().clickByJs();
			getBtnYesWarning().click();
		}
		if (getRadioMarginWithoutSlab().isChecked()) {
			reusable.holdOn(1);
			getRadioMarginWithoutSlab().clickByJs();
			getBtnYesWarning().click();
		}
		reusable.holdOn(1);
		if (marginSlab.equalsIgnoreCase("Margin with slab")) {
			reusable.holdOn(1);
			getRadioMarginWithSlab().clickByJs();
			for (int i = 0; i < ccyPairs.length; i++) {
				getSelectCurrencyPair().clickByJs();
				getInputCurrencyPair().type(ccyPairs[i]);
				reusable.selectFromDropdown(ccyPairs[i]);
				getSelectMarginType().clickByJs();
				reusable.selectFromDropdown(marginTypes[i]);
				reusable.holdOn(1);
				getInputSlabRangeFrom().type(slabRangesFrom[i]);
				getInputSlabRangeTo().type(slabRangesTo[i]);
				getInputBankSellingMargin().type(bankSellingMargins[i]);
				getInputBankBuyingMargin().type(bankBuyingMargins[i]);
				reusable.holdOn(2);
				getBtnAddMarginWithSlab().clickByJs();
			}
			reusable.holdOn(2);
			getBtnDelete().clickByJs();
		}
		if (marginSlab.equalsIgnoreCase("Margin without slab")) {
			reusable.holdOn(1);
			getRadioMarginWithoutSlab().clickByJs();
			for (int i = 0; i < ccyPairs.length; i++) {
				getSelectCurrencyPair().clickByJs();
				getInputCurrencyPair().type(ccyPairs[i]);
				reusable.selectFromDropdown(ccyPairs[i]);
				getSelectMarginType().clickByJs();
				reusable.selectFromDropdown(marginTypes[i]);
				reusable.holdOn(1);
				getInputBankSellingMargin().type(bankSellingMargins[i]);
				getInputBankBuyingMargin().type(bankBuyingMargins[i]);
				getBtnAddMarginUnderSlabs().click();
			}
			getBtnDelete().click();
		}

		reusable.holdOn(1);
		getBtnUpdate().scrollTo();
		reusable.holdOn(1);
		getBtnUpdate().clickByActions();
	}

	public void goToGlobalParameters() {
		getTabGlobalParameters().clickByJs();
	}

	public void addGlobalParameters(String makerCheckerScenario, String rateRefreshOnBasisOfThreshold,
			String DoNotSubtractFromIBRRates, String marginMultiFactor, String IBRRatesModifiedManuallyDomestic,
			String currencyPairManuallyDomestic, String IBRRatesLockedPolicyDomestic,
			String currencyPairLockedPolicyDomestic, String IBRRatesModifiedManuallyIBG, String currencyPairManuallyIBG,
			String IBRRatesLockedPolicyIBG, String currencyPairLockedPolicyIBG, String productName, String buyRate,
			String sellRate) {
		goToGlobalParameters();
		reusable = new CommonReusableMethods(driver, test);
		reusable.holdOn(1);
		if (makerCheckerScenario.equalsIgnoreCase("Maker/ Checker Required")) {
			getRadioMakerCheckerReq().clickByActions();
		} else if (makerCheckerScenario.equalsIgnoreCase("Only Checker Required")) {
			getRadioOnlyCheckerReq().clickByActions();
		} else if (makerCheckerScenario.equalsIgnoreCase("Auto Fetch and Publish")) {
			getRadioAutoFetchAndPublish().clickByActions();
		}
		if (rateRefreshOnBasisOfThreshold.equals("Yes")) {
			getRadioYesRateRefreshBasisThreshold().clickByActions();
		} else if (rateRefreshOnBasisOfThreshold.equals("No")) {
			getRadioNoRateRefreshBasisThreshold().clickByActions();
		}
		getInputMarginMultiplicationFactor().type(marginMultiFactor);
		reusable.holdOn(1);
		if (IBRRatesModifiedManuallyDomestic.equals("Yes")) {
			getSelectIBRRateDomestic().clickByJs();
			getInputCurrencyPair().type(currencyPairManuallyDomestic);
			reusable.selectFromDropdown(currencyPairManuallyDomestic);
		}
		if (IBRRatesLockedPolicyDomestic.equals("Yes")) {
			getSelectIBRRateLockedPolicyDomestic().clickByJs();
			getInputCurrencyPair().type(currencyPairLockedPolicyDomestic);
			reusable.selectFromDropdown(currencyPairLockedPolicyDomestic);
		}
		reusable.holdOn(1);
		getSelectProductName().clickByJs();
		getInputSearch().type(productName);
		reusable.selectFromDropdown(productName);
		getInputBuyUSDEquivalent().type(buyRate);
		getInputSellUSDEquivalent().type(sellRate);
		reusable.holdOn(1);
		getBtnUpdate().scrollTo();
		reusable.holdOn(1);
		getBtnUpdate().clickByJs();
	}

	public void addUpdateCpyAndThresholdPercentage(String currencyPair, String ThresholdValue) {
		getLabelThresholdMaster().clickByJs();
		getBtnAddNew().clickByJs();
		reusable = new CommonReusableMethods(driver, test);
		reusable.holdOn(1);
		getSelectCurrencyPair().clickByJs();
		getInputCurrencyPair().type(currencyPair);
		reusable.selectFromDropdown(currencyPair);
		reusable.holdOn(1);
		getInputThresholdPercent().type(ThresholdValue);
		getBtnSubmit().clickByJs();
		String toastMessage = reusable.toastMessage();
		test.log(Status.INFO, "Threshold Master Page : " + toastMessage);
		if (toastMessage.contains("already exists")) {
			getBtnBack().clickByJs();
			getInputCpyOnThMaster().type(currencyPair);
			getBtnSearch().clickByJs();
			getIconEdit().clickByJs();
			getInputThresholdPercent().type(ThresholdValue);
			getBtnUpdate().clickByJs();
			reusable.holdOn(1);
			toastMessage = reusable.toastMessage();
			test.log(Status.INFO, "Threshold Master" + toastMessage);
		}
	}

	public void submit() {
		getBtnSubmit().clickByJs();
	}

	public void thresholdMasterApproval() {
		getLabelThresholdMaster().clickByJs();
		getPendingApproval().clickByJs();
		getEditBtn().clickByJs();
	}

	public void approveOrRejectThresholdMaster(String comments, String approveOrReject) {
		getInputComments().type(comments);
		if (approveOrReject.equalsIgnoreCase("Approve")) {
			getBtnAccept().clickByJs();
		} else if (approveOrReject.equalsIgnoreCase("Reject")) {
			getBtnReject().clickByJs();
		} else {
			test.log(Status.FAIL, "Unable to click on " + approveOrReject + " button.");
		}
		getBtnYes().clickByJs();
	}

	public void acceptOrRejectProductInProductMaster(String marketType, String remarks, String acceptOrReject) {
		getTabProductMaster().clickByActions();
		reusable = new CommonReusableMethods(driver, test);
		reusable.holdOn(1);
		getLinkPendingApproval().clickByActions();
		reusable.selectMarketType(marketType);
		reusable.holdOn(2);
		getIconEdit().clickByJs();
		getInputCommentsOnProductApproval().type(remarks);
		if (acceptOrReject.equals("Approve")) {
			getBtnAccept().clickByJs();
		} else if (acceptOrReject.equals("Reject")) {
			getBtnReject().clickByJs();
		}
		reusable.holdOn(1);
		getBtnYes().clickByActions();
	}

	public String verifyEnableStatus() {
		getInputProductName().type(actProductName);
		getBtnSearch().clickByActions();
		String textBtnEnable = getBtnEnable().getText();
		return textBtnEnable;
	}

}
