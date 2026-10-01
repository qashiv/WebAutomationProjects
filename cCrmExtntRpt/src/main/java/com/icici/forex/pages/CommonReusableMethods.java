package com.icici.forex.pages;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.icici.forex.or.CommonReusableMethodsOr;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class CommonReusableMethods extends CommonReusableMethodsOr {

	Logger logger = Logger.getLogger(CommonReusableMethods.class.getName());
	ExtentTest test;

	public CommonReusableMethods(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
	}

	public void selectFromDropdown(String dropdownText) {
		for (int i = 0; i < getSelectOptions().size(); i++) {
			String option = getSelectOptions().get(i).getText();
			if (option.equalsIgnoreCase(dropdownText)) {
				getSelectOptions().get(i).clickByJs();
				break;
			}
		}
	}

	public void selectMultipleFromDropdown(String options) {
		String[] optionArr = getStringArray(options);
		for (int i = 0; i < getSelectOptions().size(); i++) {
			String option = getSelectOptions().get(i).getText();
			if (option.equalsIgnoreCase(optionArr[i])) {
				getSelectOptions().get(i).clickByJs();
			}
		}
	}

	public void selectDateFromCalendar(String date) {
		ExtendedWebElement desiredDate = findExtendedWebElement(
				By.xpath("//div[normalize-space()='" + date + "']//parent::button"));
		desiredDate.clickByJs();
	}

	public void saveAndContinue() {
		try {
			getBtnSaveAndContinue().scrollTo();
			holdOn(2);
			getBtnSaveAndContinue().click();
		} catch (ElementClickInterceptedException e) {
			getBtnSaveAndContinue().scrollTo();
			holdOn(1);
			getBtnSaveAndContinue().clickByJs();
		} catch (StaleElementReferenceException e) {
			ExtendedWebElement save = findExtendedWebElement(
					By.xpath("//span[normalize-space()='Save & Continue']//parent::button"));
			holdOn(2);
			save.clickByJs();
		} catch (NoSuchElementException e) {
			ExtendedWebElement save = findExtendedWebElement(
					By.xpath("//span[normalize-space()='Save & Continue']//parent::button"));
			save.scrollTo();
			holdOn(1);
			save.clickByJs();
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to click on Save & Continue Button : " + e.getMessage());
		}
	}

	public String takeRequestIdFromToastMessage() {
		String message = toastMessage();
		test.log(Status.INFO, message);
		String[] arr = message.split("is");
		String reqId = arr[1].trim();
		String requestId = reqId.replace(".", "");
		return requestId.trim();
	}

	public String takeRequestIdByCIBSubmitted() {
		String requestId = null;
		String msg = getOnboardMessage().getText();
		if (msg.contains("You have been on-boarded successfully")) {
			getTxtReqId().scrollTo();
			holdOn(1);
			requestId = getTxtReqId().getText();
		}
		return requestId;
	}

	public void clickOnRadioBtnByText(String radioBtnText) {
		if (radioBtnText.equalsIgnoreCase("Same as Communication address")) {
			getRadioSameAsCommAdds().clickByJs();
		} else if (radioBtnText.equalsIgnoreCase("Same as Permanent Address")) {
			getRadioSameAsPermanentAdds().clickByJs();
		} else {
			getRadioAddNewAddress().clickByJs();
		}
	}

	public void holdOn(long waitInSec) {
		try {
			Thread.sleep(waitInSec * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[] getStringArray(String texts) {
		String[] text = texts.split(", ");
		return text;
	}

	public void logOut() {
		getTriggerProfile().clickByJs();
		holdOn(2);
		getBtnLogout().clickByJs();

	}

	public String VerifyLoginPage() {
		String verifyText = getLabelLoginPage().getText();
		return verifyText;
	}

	public String VerifyDashboardPage() {
		String verifyText = getLabelDashboard().getText();
		return verifyText;
	}

	public String VerifyCurrencyPairPage() {
		String verifyText = getLabelCurrencyPair().getText();
		return verifyText;
	}

	public String VerifyCurrencyPairsMarginPage() {
		String verifyText = getLabelCurrencyPairsMargin().getText();
		return verifyText;
	}

	public String VerifyAdditionalFeaturesPage() {
		String verifyText = getLabelAdditionalFeatures().getText();
		return verifyText;
	}

	public String verifyAccountDetailsPage() {
		String verifyByText = getLabelAccountDetailsPage().getText();
		return verifyByText;
	}

	public String verifyCorporateUsersPage() {
		String verifyByText = getLabelCorporateUsersPage().getText();
		return verifyByText;
	}

	public String verifyReviewSubmitPage() {
		String verifyByText = getLabelReviewSubmitPage().getText();
		return verifyByText;
	}

	public String verifyUserDetailsPage() {
		String verifyByText = getLabelNonAccountHolder().getText();
		return verifyByText;
	}

	public String toastMessage() {
		String message = null;
		try {
			message = getToastMessage().getText();
			getClosePopUp().click();
		} catch (Exception e) {
			test.log(Status.INFO, "Unable to find toast message.\n\n" + e.getCause());
		}
		return message;
	}

	public List<String> toastMessages() {
		List<String> messages = new ArrayList<String>();
		for (int i = 0; i < getToastMessages().size(); i++) {
			String message = getToastMessages().get(i).getText();
			messages.add(message);
		}
		return messages;
	}

	public void selectMarketType(String marketType) {
		CardRatePages cardRatePages = new CardRatePages(driver, test);
		if (marketType.equals("Domestic")
				&& cardRatePages.getTabDomestic().getAttribute("aria-selected").equals("false")) {
			cardRatePages.getTabDomestic().clickByJs();
		} else if (marketType.equals("IBG")
				&& cardRatePages.getTabIBG().getAttribute("aria-selected").equals("false")) {
			cardRatePages.getTabIBG().clickByJs();
		}
	}

	public void consentForLeaveThePage(String yesOrNo) {
		if (yesOrNo.equals("Yes")) {
			getBtnYes().clickByJs();
		} else if (yesOrNo.equals("No")) {
			getBtnNo().clickByJs();
		}
	}

	public double truncateToTwoDecimalPlaces(double value) {
		BigDecimal bd = new BigDecimal(Double.toString(value));
		bd = bd.setScale(2, RoundingMode.DOWN);
			return bd.doubleValue();
		}
}