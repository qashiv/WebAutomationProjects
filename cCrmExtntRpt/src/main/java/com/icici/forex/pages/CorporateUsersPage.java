package com.icici.forex.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.icici.forex.or.CorporateUsersPageOr;

public class CorporateUsersPage extends CorporateUsersPageOr {

	Logger logger = Logger.getLogger(CorporateUsersPage.class.getName());
	CommonReusableMethods reusable;
	ExtentTest test;

	public CorporateUsersPage(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
	}

	public void selectAccessCorpUsers() {
		reusable = new CommonReusableMethods(driver, test);
		try {
			if (getRadioAccessCorpUsers().isChecked() == false) {
				getRadioAccessCorpUsers().clickByActions();
			}
			getRadioAccessCorpUsers2().clickByActions();
			reusable.holdOn(2);
			reusable.saveAndContinue();
			test.log(Status.INFO, "Corporate Users Page : Details saved successfully");
			reusable.getClosePopUp().clickByJs();
		} catch (Exception e) {
			try {
				reusable.holdOn(1);
				getIconRefresh().click();
				reusable.holdOn(2);
				getRadioAccessCorpUsers2().click();
				reusable.saveAndContinue();
				test.log(Status.INFO, "Corporate Users Page : Details saved successfully");

			} catch (Exception ex) {
				ReviewAndSubmitPage rs = new ReviewAndSubmitPage(driver, test);
				rs.openReviewSubmitPageByTab();
				test.log(Status.FAIL, "Unable to check Accessibility of User");
			}
		}
	}

	public void addNewAuthorisedUser(String userID, String otherUserId, String userName, String email) {
		try {
			reusable = new CommonReusableMethods(driver, test);
			reusable.holdOn(2);
			getLinkAddNew().clickByJs();
			reusable.holdOn(2);
			getSelectUserId().clickByJs();
			reusable.holdOn(1);
			if (userID.contains("Other")) {
				reusable.selectFromDropdown(userID);
				SimpleDateFormat sdf = new SimpleDateFormat("mm");
				String minutes = sdf.format(new Date());
				otherUserId = otherUserId + minutes;
				getInputOtherUserId().type(otherUserId);
				getInputuserName().type(userName);
				getInputEmail().type(email);
				getRadioProductRestriction().scrollTo();
				reusable.holdOn(1);
				getRadioProductRestriction().clickByActions();
			} else {
				reusable.selectFromDropdown(userID);
			}
			reusable.holdOn(1);
			getBtnSave().clickByJs();
		} catch (Exception e) {
			reusable.holdOn(2);
			getImgCancel().click();
			test.log(Status.FAIL, "Failed, Unable to Add New Authorised User : " + e.getMessage());
		}
	}

	public void addNewAuthorisedUserIBG(String userId, String userName, String emailId, String access) {
		reusable = new CommonReusableMethods(driver, test);
		reusable.holdOn(2);
		getLinkAddNew().clickByJs();
		getInputuserId().type(userId);
		getInputuserName().type(userName);
		getInputEmail().type(emailId);
		getInputAccess().type(access);
		reusable.holdOn(1);
		getBtnAdd().clickByJs();
	}

	public void openCorpUserMasterPageByTab() {
		getTabCorpUser().click();
	}
}
