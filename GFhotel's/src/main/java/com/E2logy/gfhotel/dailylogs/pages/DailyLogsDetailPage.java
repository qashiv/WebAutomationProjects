package com.E2logy.gfhotel.dailylogs.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.E2logy.gfhotel.utilities.WebUtil;

public class DailyLogsDetailPage extends DailyLogsDetailPageOR {
	private WebUtil wt;// null

	public DailyLogsDetailPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	public void fillTitle(String title) {
		wt.sendKeys(getTitleTB(), title);
	}

	public void fillNotte(String note) {
		wt.sendKeys(getNoteTB(), note);
	}

	public void addLogButton() {
		wt.click(getAddButton());
	}

	// wt.customDropDown(ListProperty, expected);

	public boolean VerifyPropertyHeader(String headerName) {
		boolean status = false;
		List<WebElement> allvalues = getPropertyValues();

		for (WebElement header : getAllHeader()) {
			if (header.getText().equalsIgnoreCase(headerName) && !allvalues.isEmpty()) {
				for (WebElement text : allvalues) {
					status = text.isDisplayed();
					break;
				}
				break;
			}
		}
		return status;
	}

	public boolean VerifyTechniciansHeader(String headerName) {
		boolean status = false;
		List<WebElement> Techvalues = getTechniciansValues();

		for (WebElement header : getAllHeader()) {
			if (header.getText().equalsIgnoreCase(headerName) && !Techvalues.isEmpty()) {
				for (WebElement text : Techvalues) {
					status = text.isDisplayed();
					break;
				}
				break;
			}
		}
		return status;
	}
}
