package com.icici.forex.or;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class DashboardPageOr extends AbstractPage {

	protected DashboardPageOr(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='Masters']")
	private ExtendedWebElement menuMasters;

	@FindBy(xpath = "//span[normalize-space()='Card Rate Reports']")
	private ExtendedWebElement menuCardRateReports;

	@FindBy(xpath = "//span[normalize-space()='Card Rate Master']")
	private ExtendedWebElement menuCardRateMaster;

	@FindBy(xpath = "//*[contains(text(),'My requests')]")
	private ExtendedWebElement btnMyRequest;

	@FindBy(xpath = "//span[normalize-space()='Submit']//parent::button")
	private ExtendedWebElement btnSubmitRejectReason;

	@FindBy(xpath = "//textarea[@name='rejectComments']")
	private ExtendedWebElement inputRejectReason;

	@FindBy(xpath = "//span[normalize-space()='Reject']//parent::button")
	private ExtendedWebElement btnCheckerReject;

	@FindBy(xpath = "//img[contains(@class,'hamburger-btn')]")
	private ExtendedWebElement btnHamburger;

	@FindBy(xpath = "//*[normalize-space()='Accept']//parent::button")
	private ExtendedWebElement btnCheckerAccept;

	@FindBy(xpath = "//*[text()='Approver comments']//parent::div//textarea")
	private ExtendedWebElement inputApproverComment;

	@FindBy(xpath = "//textarea[@name='checkerRemark']")
	private ExtendedWebElement inputCheckerRemark;

	@FindBy(xpath = "//*[contains(text(),'Pending approval')]/parent::div")
	private ExtendedWebElement linkPendingApproval;

	@FindBy(xpath = "//span[text()='Dashboard']")
	private ExtendedWebElement tabDashboard;

	@FindBy(xpath = "//span[text()=' Create New Request ']/parent::button")
	private ExtendedWebElement btnCreateNewRequest;

	@FindBy(xpath = "//span[text()='On Call Registration']")
	private ExtendedWebElement radioOnCallReg;

	@FindBy(xpath = "//input[@id='mat-radio-3-input']")
	private ExtendedWebElement radioOnboardingReg;

	@FindBy(xpath = "//span[text()=' Ok ']/parent::button")
	private ExtendedWebElement btnOk;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private ExtendedWebElement inputSearch;

	@FindBy(xpath = "//div[@class='action-container']")
	private ExtendedWebElement iconEdit;

	@FindBy(xpath = "//span[normalize-space()='Cob Configuration']")
	private ExtendedWebElement hoverCobConfiguration;

	@FindBy(xpath = "//span[normalize-space()='Configuration']")
	private ExtendedWebElement hoverConfiguration;

	@FindBy(xpath = "//span[normalize-space()='Card Rate']")
	private ExtendedWebElement menuCardRate;

	@FindBy(xpath = "//div[@class='wrapper']")
	private ExtendedWebElement wrapperModules;

	public ExtendedWebElement getWrapperModules() {
		return wrapperModules;
	}

	public ExtendedWebElement getMenuCardRate() {
		return menuCardRate;
	}

	public ExtendedWebElement getMenuMasters() {
		return menuMasters;
	}

	public ExtendedWebElement getMenuCardRateReports() {
		return menuCardRateReports;
	}

	public ExtendedWebElement getMenuCardRateMaster() {
		return menuCardRateMaster;
	}

	public ExtendedWebElement getBtnMyRequest() {
		return btnMyRequest;
	}

	public ExtendedWebElement getBtnSubmitRejectReason() {
		return btnSubmitRejectReason;
	}

	public ExtendedWebElement getInputRejectReason() {
		return inputRejectReason;
	}

	public ExtendedWebElement getBtnCheckerReject() {
		return btnCheckerReject;
	}

	public ExtendedWebElement getBtnHamburger() {
		return btnHamburger;
	}

	public ExtendedWebElement getBtnCheckerAccept() {
		return btnCheckerAccept;
	}

	public ExtendedWebElement getInputApproverComment() {
		return inputApproverComment;
	}

	public ExtendedWebElement getInputCheckerRemark() {
		return inputCheckerRemark;
	}

	public ExtendedWebElement getLinkPendingApproval() {
		return linkPendingApproval;
	}

	public ExtendedWebElement getTabDashboard() {
		return tabDashboard;
	}

	public ExtendedWebElement getBtnCreateNewRequest() {
		return btnCreateNewRequest;
	}

	public ExtendedWebElement getRadioOnCallReg() {
		return radioOnCallReg;
	}

	public ExtendedWebElement getRadioOnboardingReg() {
		return radioOnboardingReg;
	}

	public ExtendedWebElement getBtnOk() {
		return btnOk;
	}

	public ExtendedWebElement getInputSearch() {
		return inputSearch;
	}

	public ExtendedWebElement getIconEdit() {
		return iconEdit;
	}

	public ExtendedWebElement getHoverCobConfiguration() {
		return hoverCobConfiguration;
	}

	public ExtendedWebElement getHoverConfiguration() {
		return hoverConfiguration;
	}

}
