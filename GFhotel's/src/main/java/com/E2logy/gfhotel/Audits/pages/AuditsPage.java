package com.E2logy.gfhotel.Audits.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.E2logy.gfhotel.utilities.WebUtil;

public class AuditsPage extends AuditsPageOR {
	private WebUtil ut;
	WebDriver driver;

	public AuditsPage(WebUtil ut) {
		super(ut);
		this.ut = ut;
		this.driver = ut.getDriver();

	}

	public void clickHrAuditsLink() {
		ut.threadWait(5000);
		ut.jsClickMethod(getHraudittempleteLK(), "Audit Templete");
	}

	public void clickAuditsStartButton() {
		ut.click(getAuditstartBT());
	}

	public void checkAuditCheckBoxes() {
		WebElement we = null;
		WebElement yeswe = null;
		List<WebElement> yeslist = getAuditYesBT();
		List<WebElement> list = getAuditCheckBoxesCB();
		for (int i = 0; i <= list.size() - 1; i++) {
			we = list.get(i);
			yeswe = yeslist.get(i);
			if (we.isSelected() == false) {
				we.click();
				ut.threadWait(2000);
				yeswe.click();

			}
		}
	}

	public void clickCompleteOnDate() {
		ut.click(getCompleteonBT());
	}

	public void enterDateORMonthSelect(String date) {
		ut.click(getDateBT(date));
	}

	public void clickMonthDropDown() {
		ut.click(getClickmonthDD());
	}

	public void selectAuditStatus(String valueofselect) {

		ut.mouseOver(getAuditstatusDD()).click().sendKeys(valueofselect).sendKeys(Keys.RETURN).perform();

	}

	public void clickCreateAuditRow() {
		ut.click(getCreatedauditROW());
	}
}