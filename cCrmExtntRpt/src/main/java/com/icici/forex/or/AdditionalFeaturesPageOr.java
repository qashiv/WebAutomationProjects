package com.icici.forex.or;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class AdditionalFeaturesPageOr extends AbstractPage {

	protected AdditionalFeaturesPageOr(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[text()='Additional Features']")
	private ExtendedWebElement tabAddFeatures;

	@FindBy(xpath = "//*[text()='Net Rate ']")
	private ExtendedWebElement checkNetRate;

	@FindBy(xpath = "//*[text()='Net Rate ']/preceding-sibling::span//input")
	private ExtendedWebElement radioNetRate;

	@FindBy(xpath = "//*[text()='Breakup- Spot/Swap ']")
	private ExtendedWebElement checkBreakupSpotSwap;

	@FindBy(xpath = "//mat-slide-toggle[@formcontrolname='matchingdealtoggle']")
	private ExtendedWebElement toggleNettingMatchingDeal;

	@FindBy(xpath = "//mat-slide-toggle[@formcontrolname='dealbookingtoggle']")
	private ExtendedWebElement toggleBulkDealBooking;

	@FindBy(xpath = "//mat-slide-toggle[@formcontrolname='cashtoggle']")
	private ExtendedWebElement togglePassCashSpot;

	@FindBy(xpath = "//mat-slide-toggle[@formcontrolname='ordertoggle']")
	private ExtendedWebElement toggleOrders;

	@FindBy(xpath = "//*[contains(text(),'ED/Roll')]//parent::div//..//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectEDRolloverCancellation;

	@FindBy(xpath = "//div[contains(@class,'options-inner-container')]//mat-option")
	private List<ExtendedWebElement> selectOptions;

	@FindBy(xpath = "//*[text()='Orders Types']/parent::div/..//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectOrdersType;

	@FindBy(xpath = "//*[text()='Merge/Spilt Deals']/parent::div//input")
	private ExtendedWebElement toggleMergeSpiltDeals;

	@FindBy(xpath = "//*[text()='Single Click Deal Booking']/parent::div//input")
	private ExtendedWebElement toggleSingleClickDealBooking;

	@FindBy(xpath = "//*[text()='Approvals']/parent::div/following-sibling::div//div[contains(@class,'icon-container')]")
	private List<ExtendedWebElement> selectApprover;

	@FindBy(xpath = "//*[contains(text(),'ED/Roll')]//parent::div//..//div[contains(@class,'dropdown-trigger')]")
	private ExtendedWebElement statusEDRollover;

	public ExtendedWebElement getStatusEDRollover() {
		return statusEDRollover;
	}

	public ExtendedWebElement getTabAddFeatures() {
		return tabAddFeatures;
	}

	public ExtendedWebElement getCheckNetRate() {
		return checkNetRate;
	}

	public ExtendedWebElement getRadioNetRate() {
		return radioNetRate;
	}

	public ExtendedWebElement getCheckBreakupSpotSwap() {
		return checkBreakupSpotSwap;
	}

	public ExtendedWebElement getToggleNettingMatchingDeal() {
		return toggleNettingMatchingDeal;
	}

	public ExtendedWebElement getToggleBulkDealBooking() {
		return toggleBulkDealBooking;
	}

	public ExtendedWebElement getTogglePassCashSpot() {
		return togglePassCashSpot;
	}

	public ExtendedWebElement getSelectEDRolloverCancellation() {
		return selectEDRolloverCancellation;
	}

	public List<ExtendedWebElement> getSelectOptions() {
		return selectOptions;
	}

	public ExtendedWebElement getToggleOrders() {
		return toggleOrders;
	}

	public ExtendedWebElement getSelectOrdersType() {
		return selectOrdersType;
	}

	public ExtendedWebElement getToggleMergeSpiltDeals() {
		return toggleMergeSpiltDeals;
	}

	public ExtendedWebElement getToggleSingleClickDealBooking() {
		return toggleSingleClickDealBooking;
	}

	public List<ExtendedWebElement> getSelectApprover() {
		return selectApprover;
	}

}
