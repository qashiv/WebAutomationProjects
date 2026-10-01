package com.icici.forex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.icici.forex.or.CobConfigurationPageOr;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class CobConfigurationPage extends CobConfigurationPageOr {

	ExtentTest test;
	CommonReusableMethods reusable;
	AccountDetailsPage accDetailsPage;

	public CobConfigurationPage(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
	}

	public void uploadPreApproveCustomerDetails(String preApprovefilePath) {
		try {
			getSubMenuUploadPreApproveCust().clickByJs();
			getUploadPreApproveFile().attachFile(preApprovefilePath);
			getBtnUpload().clickByActions();
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to upload Pre Approve Customer Details : " + e.getMessage());
		}
	}

	public void uploadBulkCounterparty(String bulkCounterpartyFile) {
		try {
			reusable = new CommonReusableMethods(driver, test);
			getSubMenuUploadBulkCounterparty().clickByJs();
			reusable.holdOn(1);
			getLinkUploadBulkCounterpartyFile().attachFile(bulkCounterpartyFile);
			reusable.holdOn(1);
			getBtnUpload().clickByJs();
			reusable.holdOn(1);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to upload Bulk Counterparty details : " + e.getMessage());
		}
	}

	public void uploadBlockBulkCounterparty(String blockBulkUploadFile) {
		reusable = new CommonReusableMethods(driver, test);
		getSubMenuBlockBulkCounterparty().clickByJs();
		reusable.holdOn(1);
		getUploadFile().attachFile(blockBulkUploadFile);
		getBtnUpload().clickByJs();
		for (int i = 0; i < getViolationMessage().size(); i++) {
			String violationMsg = getViolationMessage().get(i).getText();
			test.log(Status.INFO, "Block Bulk Counterparty Status" + violationMsg);
		}
	}

	public String getFreshCustIdFromBulkCounterpartyUpload() {
		String custId = null;
		for (int i = 0; i < getViolationMessage().size(); i++) {
			String message = getViolationMessage().get(i).getText();
			test.log(Status.INFO, "Violation Message : " + message);
			if (message.contains("Pending with TSSG")) {
				String[] arr = message.split("Pending");
				custId = arr[0].trim();
				break;
			}
		}
		return custId;
	}

	public void uploadEpsilonAndHierarchyFile(String epsilonfilePath, String hierarchyFilePath) {
		reusable = new CommonReusableMethods(driver, test);
		getSubMenuUploadEpsiloneFile().clickByJs();
		if (!getRadioBtnEpsilon().isChecked()) {
			getRadioBtnEpsilon().check();
		}
		getUploadFile().attachFile(epsilonfilePath);
		reusable.holdOn(1);
		getBtnUpload().clickByJs();
		reusable.holdOn(1);
		String toastMessage = reusable.toastMessage();
		test.log(Status.INFO, toastMessage);
		if (!getRadioTeamHierarchy().isChecked()) {
			getRadioTeamHierarchy().check();
		}
		getUploadFile().attachFile(hierarchyFilePath);
		reusable.holdOn(1);
		getBtnUpload().clickByJs();
		reusable.holdOn(1);
		toastMessage = reusable.toastMessage();
		test.log(Status.INFO, toastMessage);

	}

	public void reassignToSM(String requestId, String SMName) {
		reusable = new CommonReusableMethods(driver, test);
		getSubMenuReassign().clickByJs();
		reusable.holdOn(1);
		getInputSearch().type(requestId);
		getInputSearch().sendKeys(Keys.ENTER);
		reusable.holdOn(1);
		getCheckSearchedReqId().check();
		getSelectSM().click();
		getInputSMSearch().type(SMName);
		reusable.holdOn(1);
		reusable.selectFromDropdown(SMName);
		getBtnReassign().click();

	}

	public void filterReportByDiffColumns(String columnNames) {
		reusable = new CommonReusableMethods(driver, test);
		getSubMenuReport().clickByJs();
		reusable.holdOn(3);
		String[] columnName = reusable.getStringArray(columnNames);

		for (int i = 0; i < columnName.length; i++) {
			getIconFilter().clickByJs();
			ExtendedWebElement radioColumnName = findExtendedWebElement(By.xpath(
					"//span[contains(text(),'" + columnName[i] + "')]//parent::div//preceding-sibling::div//input"));
			reusable.holdOn(1);
			radioColumnName.scrollTo();
			reusable.holdOn(2);
			if (radioColumnName.getAttribute("aria-checked").equals("false")) {
				radioColumnName.clickByJs();
			}
			reusable.holdOn(2);
			getIconFilter().clickByJs();
			WebElement table = driver.findElement(By.xpath("//table[@role='table']"));
			WebElement headerColumnName = table.findElement(By.xpath("//*[normalize-space()='" + columnName[i] + "']"));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", headerColumnName);
			reusable.holdOn(2);
			String act_ColumnName = headerColumnName.getText();
			reusable.holdOn(1);
			SoftAssert softasrt = new SoftAssert();
			softasrt.assertEquals(act_ColumnName, columnName[i], "Actual columnName : " + act_ColumnName
					+ " and expected columnName : " + columnName + " is not matching");
			softasrt.assertAll();
		}

	}

	public void filterReportByDate(String previousMonthDate, String currentMonthDate) {
		reusable = new CommonReusableMethods(driver, test);
		getBtnFrom().scrollTo();
		reusable.holdOn(1);
		getBtnFrom().clickByJs();
		getBtnPreviousMonth().clickByJs();
		ExtendedWebElement preMonthdate = findExtendedWebElement(
				By.xpath("//div[normalize-space()='" + previousMonthDate + "']//parent::button"));
		preMonthdate.clickByJs();
		reusable.holdOn(1);
		getBtnTo().clickByJs();
		ExtendedWebElement currentMonthdate = findExtendedWebElement(
				By.xpath("//div[normalize-space()='" + currentMonthDate + "']//parent::button"));
		currentMonthdate.clickByJs(EXPLICIT_TIMEOUT);
		getBtnGo().scrollTo();
		reusable.holdOn(1);
		getBtnGo().clickByJs();
	}

	public void customerModification(String otherCurrencyPair) {
		reusable = new CommonReusableMethods(driver, test);
		getSubMenuModification().clickByJs();
		if (getExpandCurrencyPair().getAttribute("aria-expanded").equals("false")) {
			getExpandCurrencyPair().clickByJs();
			getSelectCurrencyPair().clickByJs();
			reusable.holdOn(1);
			getInputSearchCurrencyPair().type(otherCurrencyPair);
			reusable.holdOn(1);
			reusable.selectFromDropdown(otherCurrencyPair);
		}
		if (getExpandUsers().getAttribute("aria-expanded").equals("false")) {
			getExpandUsers().clickByJs();
		}
		getBtnSubmit().scrollTo();
		reusable.holdOn(1);
		getBtnSubmit().clickByJs();
	}

	public void clickModification() {
		getSubMenuModification().clickByJs();
	}

	public String takeRequestIdFromPendingRequest() {
		reusable = new CommonReusableMethods(driver, test);
		getSubMenuPendingRequest().clickByJs();
		reusable.holdOn(2);
		String requestId = getTxtRequestId().getText();
		return requestId;
	}
}
