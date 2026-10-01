package com.icici.forex.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.icici.forex.or.AccountDetailsPageOr;

public class AccountDetailsPage extends AccountDetailsPageOr {

	Logger logger = Logger.getLogger(AccountDetailsPage.class.getName());
	JavascriptExecutor jse;
	CommonReusableMethods reusable;
	ExtentTest test;

	public AccountDetailsPage(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
	}

	public void provideNewAccountDetails(String accountNo) {
		getInputAccountNo().type(accountNo);
		test.log(Status.INFO, "Account Number entered : " + accountNo);
		reusable = new CommonReusableMethods(getDriver(), test);
		if (getBtnNext().isPresent() == true) {
			getBtnNext().clickByJs();
			test.log(Status.INFO, "Account Number filled and clicked on Next Button");
			logger.info("Clicked on Next Button");
		}
		String businessDetailsTxt = getTxtBusinessDetails().getText();
		if (businessDetailsTxt.contains("Business Details")) {
			logger.info("Account Details Page opened successfully");
			test.log(Status.INFO, "Account Details Page opened successfully");
		} else {
			logger.info("Customer is already onboarded or in progress, Please use fresh account");
			test.log(Status.FAIL, "Customer is already onboarded or in progress, Please use fresh account");
		}
	}

	public void selectAccountNo(String accountNo) {
		getSelectAccountNo().click();
		reusable = new CommonReusableMethods(driver, test);
		reusable.holdOn(1);
		reusable.selectFromDropdown(accountNo);

	}

	public void fillAccDetailsForIBGCustomer(String custId, String companyName, String corpId, String contactPersonName,
			String communicationAddress, String countryName, String mobNo, String email, String LEI) {
		reusable = new CommonReusableMethods(driver, test);
		getInputCustId().type(custId);
		getInputCompanyName().type(companyName);
		getInputCorpId().type(corpId);
		getInputOtherContactPersonName().type(contactPersonName);
		getRadioAddNewAddress().clickByJs();
		getInputComAddress().type(communicationAddress);
		getSelectCountry().clickByJs();
		reusable.holdOn(1);
		getInputSearchCountry().type(countryName);
		reusable.selectFromDropdown(countryName);
		getSelectCountryCode().clickByJs();
		reusable.holdOn(1);
		getOptionCountryCode().clickByJs();
		getInputMobileNo().type(mobNo);
		getInputEmail().type(email);
		getInputLEI().type(LEI);
		reusable.holdOn(1);
		getSelectGstApplicable().clickByJs();
		getSelectedGSTNo().clickByJs();
	}

	public void selectContactPerson(String selectContactPersonName, String inputOtherContactPersonName) {
		reusable = new CommonReusableMethods(getDriver(), test);
		reusable.holdOn(2);
		try {
		boolean companyNameStatus = getInputCompanyName().getElement().isEnabled();
		if (companyNameStatus == false) {
			test.log(Status.INFO, "Company name is auto populated and disabled");
		} else {
			String companyName = getInputCompanyName().getAttribute("value");
			SimpleDateFormat sdf = new SimpleDateFormat("mm");
			String minute = sdf.format(new Date());
			String compName = companyName + minute;
			getInputCompanyName().type(compName);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(getSelectContactPerson().getElement()));
		reusable.holdOn(2);
		getSelectContactPerson().click();
		reusable.selectFromDropdown(selectContactPersonName);
		String selectedOpt = getSelectedOptioncPersonName().getText().trim();
		if (selectedOpt.equals("Other")) {
			getInputOtherContactPersonName().type(inputOtherContactPersonName);
		}
	}

	public void addNewAddress(String commAddress, String pinCode) {
		getRadioAddNewAddress().clickByJs();
		getInputComAddress().type(commAddress);
		getInputPinCode().type(pinCode);
	}

	public void communicationAddress(String addType) {
		if (addType.equalsIgnoreCase("Same as Communication address")) {
			getRadioSameAsCommAddress().clickByJs();
		} else if (addType.equalsIgnoreCase("Same as Permanent Address")) {
			getRadioSameAsPermanentAddress().clickByJs();
		}
	}

	public void provideLEIDetails(String LEI) {
		getInputLEI().type(LEI);
	}

	public void provideGSTDetails(String YesOrNo, String selectGSTNumber, String inputOtherGSTNumber,
			String GSTStatus) {
		reusable = new CommonReusableMethods(driver, test);
		try {
			getSelectGstApplicable().click();
			reusable.selectFromDropdown(YesOrNo);
			if (YesOrNo.equalsIgnoreCase("Yes")) {
				getSelectGSTNumber().click();
				reusable = new CommonReusableMethods(getDriver(), test);
				reusable.selectFromDropdown(selectGSTNumber);
				if (getSelectedGSTNo().getAttribute("title").equalsIgnoreCase(selectGSTNumber)) {
					logger.info("GST number selected : " + getSelectedGSTNo().getAttribute("title"));
					test.log(Status.PASS, "GST number selected : " + getSelectedGSTNo().getAttribute("title"));
				} else {
					logger.info("GST number is not available in GST gateway");
					test.log(Status.FAIL, "GST number is not available in GST gateway");
				}
				if (getSelectedGSTNo().getAttribute("title").equals("Other")) {
					getInputOtherGSTNumber().type(inputOtherGSTNumber);
				}
				getSelectGSTStatus().click();
				reusable.selectFromDropdown(GSTStatus);
			}
		} catch (ElementClickInterceptedException e) {
			getSelectGstApplicable().scrollTo();
			reusable.holdOn(2);
			getSelectGstApplicable().clickByJs();
			reusable.holdOn(1);
			reusable.selectFromDropdown(YesOrNo);
			if (YesOrNo.equalsIgnoreCase("Yes")) {
				getSelectGSTNumber().click();
				reusable.selectFromDropdown(selectGSTNumber);
				if (getSelectedGSTNo().getAttribute("title").equalsIgnoreCase(selectGSTNumber)) {
					logger.info("GST number selected : " + getSelectedGSTNo().getAttribute("title"));
					test.log(Status.PASS, "GST number selected : " + getSelectedGSTNo().getAttribute("title"));
				} else {
					logger.info("GST number is not available in GST gateway");
					test.log(Status.FAIL, "GST number is not available in GST gateway");
				}
				if (getSelectedGSTNo().getAttribute("title").equals("Other")) {
					getInputOtherGSTNumber().type(inputOtherGSTNumber);
				}
				getSelectGSTStatus().click();
				reusable.selectFromDropdown(GSTStatus);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "GST applicable dropdown is not selected : " + e.getCause());
		}
	}

	public void selectOnlineOncallServices() {
		try {
			getRadioOnline().check();
			if (!getRadioOnCall().isChecked()) {
				getRadioOnCall().check();
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Problem occured while selecting online onCall services : " + e.getMessage());
		}
	}

	public void selectOnlineServices() {
		try {
			getRadioOnline().check();
			getRadioOnCall().uncheck();
		} catch (Exception e) {
			test.log(Status.FAIL, "Problem occured while selecting online services : " + e.getMessage());
		}
	}

	public void selectOnCallService() {
		try {
			if (getRadioOnCallServices().isChecked() == false) {
				getRadioOnCall().check();
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to select onCall Service : " + e.getMessage());
		}
	}

	public void uncheckOnlineForwardServices() {
		if (getRadioOnlineServices().isChecked() == true) {
			getRadioOnline().check();
		}
		if (getRadioForwardServices().isChecked() == true) {
			getRadioForward().check();
		}
	}

	public void selectOnlineForwardServices(String docsPath) {
		try {
			reusable = new CommonReusableMethods(driver, test);
			if (getRadioOnlineServices().isChecked() == false) {
				getRadioOnline().check();
				getRadioOnCall().clickByJs();
			}
			if (getRadioForwardServices().isChecked() == false) {
				getRadioForward().check();
				reusable.holdOn(2);
//				getBtnUploadForwardDocs().get(0).attachFile(docsPath);
//				getBtnUploadForwardDocs().get(1).attachFile(docsPath);
//				getBtnUploadForwardDocs().get(2).attachFile(docsPath);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Problem occured while selecting Online Forward Services : " + e.getMessage());
		}
	}

	public void selectOnCallForwardServices(String docsPath) {
		try {
			reusable = new CommonReusableMethods(driver, test);
			if (getRadioOnCallServices().isChecked() == false) {
				getRadioOnCall().click();
				getRadioForward().check();
				reusable.holdOn(2);
//				getBtnUploadForwardDocs().get(0).attachFile(docsPath);
//				getBtnUploadForwardDocs().get(1).attachFile(docsPath);
//				getBtnUploadForwardDocs().get(2).attachFile(docsPath);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Problem occured while selecting OnCall Forward Services : " + e.getMessage());
		}
	}

	public void refreshByIcon() {
		getIconRefresh().clickIfPresent();
	}

	public void openCurencyPairPageByTab() {
		getTabCurrencyPair().click();
	}

	public void uploadAndVerifyByAPI(String filePath) {
		try {
			reusable = new CommonReusableMethods(driver, test);
			for (int i = 0; i < getUploadForVerifyAPIs().size(); i++) {
				getUploadForVerifyAPIs().get(i).attachFile(filePath);
				reusable.holdOn(1);
			}
			reusable.holdOn(2);
			reusable.saveAndContinue();
		} catch (Exception e) {
			test.log(Status.FAIL, "UNVERIFIED By External APIs : " + e.getMessage());
		}
	}

	public void acceptDeclaration() {
		getAcceptDeclaration().clickByJs(EXPLICIT_TIMEOUT);
	}
}
