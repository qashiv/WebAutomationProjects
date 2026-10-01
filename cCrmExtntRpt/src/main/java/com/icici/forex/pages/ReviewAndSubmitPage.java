package com.icici.forex.pages;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.icici.forex.or.ReviewAndSubmitPageOr;

public class ReviewAndSubmitPage extends ReviewAndSubmitPageOr {

	Logger logger = Logger.getLogger(ReviewAndSubmitPage.class.getName());
	CommonReusableMethods reusable;
	ExtentTest test;

	public ReviewAndSubmitPage(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
	}

	public void reviewAndSubmit(String filePath) {
		try {
			reusable = new CommonReusableMethods(driver, test);
			getBtnAddAttachments().scrollTo();
			reusable.holdOn(1);
			getBtnAddAttachments().attachFile(filePath);
			getBtnSubmit().scrollTo();
			reusable.holdOn(1);
			getBtnSubmit().clickByActions();
			reusable.holdOn(1);
		} catch (Exception e) {
			test.log(Status.FAIL, "Problem occured while review and submit : " + e.getMessage());
		}

	}

	public String getRequestIdFromToastMessage() {
		String message = getReqIdFromAlert().getText();
		String[] arr = message.split("is");
		String reqId = arr[1].trim();
		String requestId = reqId.replace(".", "").trim();
		return requestId;
	}

	public void checkDisclaimerAndSubmit() {
		reusable = new CommonReusableMethods(driver, test);
		getCheckDisclaimer().scrollTo();
		reusable.holdOn(1);
		getCheckDisclaimer().check();
		getLinkTermsCondition().clickByActions();
		WebElement dialogContent = driver
				.findElement(By.xpath("//mat-dialog-content[contains(@class,'mat-dialog-content')]"));
		WebElement content = dialogContent.findElement(By.xpath("//mat-dialog-content//div//p[last()]"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", content);
		if (getAcceptTermsCondition().isVisible() == true) {
			getAcceptTermsCondition().clickByJs();
		}
		getBtnSubmit().clickIfPresent(EXPLICIT_TIMEOUT);

	}

	public void reviewAndEdit() {
		getBtnEdit().click();
	}

	public void back() {
		getBtnBack().click();
	}

	public String commentsAndApprove(String comments) {
		getInputComments().type(comments);
		reusable = new CommonReusableMethods(driver, test);
		reusable.holdOn(1);
		getBtnApprove().clickByJs();
		String requestId = reusable.takeRequestIdFromToastMessage();
		return requestId;
	}

	public void openReviewSubmitPageByTab() {
		getTabReviewSubmit().clickByJs();
	}
}
