package com.icici.forex.pages;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.icici.forex.or.DashboardPageOr;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class DashboardPage extends DashboardPageOr {

	Logger logger = Logger.getLogger(DashboardPage.class.getName());
	String requestId;
	CommonReusableMethods reusable;
	ExtentTest test;

	public DashboardPage(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
	}

	public void createNewRequest(String onboardingType) {
		getBtnCreateNewRequest().clickByJs();
		if (onboardingType.equalsIgnoreCase("OnCall Registration")) {
			getRadioOnCallReg().clickByJs();
		}
		getBtnOk().click();
	}

	public void clickCreateNewRequest() {
		getBtnCreateNewRequest().clickByJs();
	}

	public String searchByRequestIDAndOpen(String requestId) {
		String reqID = null;
		try {
			getInputSearch().type(requestId, EXPLICIT_TIMEOUT);
			getInputSearch().sendKeys(Keys.ENTER);
			ExtendedWebElement reqIdFromDashboard = findExtendedWebElement(
					By.xpath("//td[@title='" + requestId + "']"));
			reqID = reqIdFromDashboard.getText();
			if (reqID.equals(requestId)) {
				reqIdFromDashboard.click();
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "No Data Found : " + e.getMessage());
		}
		return reqID;
	}

	public String searchByCustIDAndOpen(String custId) {
		String custID = null;
		try {
			getInputSearch().type(custId, EXPLICIT_TIMEOUT);
			getInputSearch().sendKeys(Keys.ENTER);
			ExtendedWebElement custIdFromDashboard = findExtendedWebElement(By.xpath("//td[@title='" + custId + "']"));
			custID = custIdFromDashboard.getText();
			if (custID.equals(custId)) {
				getIconEdit().click();
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "No Data Found : " + e.getMessage());
		}
		return custID;
	}

	public void approvePendingRequestByChecker(String requestId, String filePath, String remark, String apvrComment) {
		reusable = new CommonReusableMethods(driver, test);
		getLinkPendingApproval().click();
		searchByRequestIDAndOpen(requestId);
		test.log(Status.INFO, "Account Details Page opened for checker approval");
		reusable.holdOn(1);
		new AccountDetailsPage(driver, test).uploadAndVerifyByAPI(filePath);
		reusable.holdOn(1);
		test.log(Status.INFO, "Account Details Page details are checked and continue");
		reusable.holdOn(1);
		reusable.saveAndContinue();
		test.log(Status.INFO, "Counterparty Master Page details are checked and continue");
		reusable.holdOn(1);
		reusable.saveAndContinue();
		test.log(Status.INFO, "Currency Pairs Page details are checked and continue");
		reusable.holdOn(1);
		reusable.saveAndContinue();
		test.log(Status.INFO, "Additional Features Page details are checked and continue");
		reusable.holdOn(1);
		reusable.saveAndContinue();
		test.log(Status.INFO, "Corporate Users Master Page details are checked and continue");
		reusable.holdOn(1);
		getInputCheckerRemark().scrollTo();
		reusable.holdOn(1);
		getInputCheckerRemark().type(remark);
		getInputApproverComment().type(apvrComment);
		getBtnCheckerAccept().scrollTo();
		reusable.holdOn(1);
		getBtnCheckerAccept().click();

	}

	public void rejectPendingRequestByChecker(String requestId, String filePath, String remark, String apvrComment,
			String rejectReason) {
		reusable = new CommonReusableMethods(driver, test);
		getLinkPendingApproval().click();
		searchByRequestIDAndOpen(requestId);
		test.log(Status.INFO, "Account Details Page opened for checker approval");
		reusable.holdOn(1);
		new AccountDetailsPage(driver, test).uploadAndVerifyByAPI(filePath);
		reusable.holdOn(1);
		reusable.saveAndContinue();
		test.log(Status.INFO, "Account Details Page details are checked and continue");
		reusable.holdOn(1);
		reusable.saveAndContinue();
		test.log(Status.INFO, "Counterparty Master Page details are checked and continue");
		reusable.holdOn(1);
		reusable.saveAndContinue();
		test.log(Status.INFO, "Currency Pairs Page details are checked and continue");
		reusable.holdOn(1);
		reusable.saveAndContinue();
		test.log(Status.INFO, "Additional Features Page details are checked and continue");
		reusable.holdOn(1);
		reusable.saveAndContinue();
		test.log(Status.INFO, "Corporate Users Master Page details are checked and continue");
		reusable.holdOn(1);
		getInputCheckerRemark().scrollTo();
		reusable.holdOn(1);
		getInputCheckerRemark().type(remark);
		getInputApproverComment().type(apvrComment);
		getBtnCheckerReject().scrollTo();
		reusable.holdOn(1);
		getBtnCheckerReject().click();
		getInputRejectReason().type(rejectReason);
		reusable.holdOn(1);
		getBtnSubmitRejectReason();
	}

	public void editCustomerDetails(String requestId) {
		getInputSearch().type(requestId, EXPLICIT_TIMEOUT);
		getIconEdit().click();
	}

	public void clickHamburgerBtn() {
		getBtnHamburger().clickByJs();
	}

	public void hoverCobConfiguration() {
		getHoverCobConfiguration().hover();
	}

	public void hoverConfiguration() {
		getHoverConfiguration().hover();
	}

	public void clickDashboardTab() {
		getTabDashboard().click();
	}

	public void openMyRequest() {
		getBtnMyRequest().clickByJs();
	}

	public void hoverCardRate() {
		getMenuCardRate().hover();
	}

	public void hoverCardRateMaster() {
		getMenuCardRateMaster().hover();
	}

	public void hoverCardRateReports() {
		getMenuCardRateReports().hover();
	}

	public void hoverMasters() {
		getMenuMasters().hover();
	}

}
