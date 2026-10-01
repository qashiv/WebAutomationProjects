package com.E2logy.gfhotel.dailylogs.pages;

import com.E2logy.gfhotel.common.pages.CommonPage;
import com.E2logy.gfhotel.utilities.WebUtil;

public class DailyLogsLandingPage extends DailyLogsLandingPageOR {

	private WebUtil wt;// null

	public DailyLogsLandingPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	public void clickDailyLogsBT() {
		wt.click(dailyLogsBT);

	}

	public void clickAddDailylogBT() {
		wt.click(dailyLogsBT);

	}

	public void enterNote(String note) {
		wt.sendKeys(Note, note);

	}

	public void enterTextOnTitleTB(String titleName) {
		wt.sendKeys(title, titleName);
	}

	public void addDailyLogsInfo(String titleName, String dropDownElement, String note) {
		clickAddDailylogBT();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		enterTextOnTitleTB(titleName);
		CommonPage common = new CommonPage(wt);
		common.selectDropdown(selectProperty, dropDownElement);
		enterNote(note);
		wt.click(addButton);

	}

}
