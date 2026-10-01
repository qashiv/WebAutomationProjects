package com.E2logy.gfhotel.dailylogs.testscript;

import org.testng.annotations.Test;

import com.E2logy.gfhotel.base.BaseTest;
import com.E2logy.gfhotel.common.pages.CommonPage;
import com.E2logy.gfhotel.dailylogs.pages.DailyLogsDetailPage;
import com.E2logy.gfhotel.dailylogs.pages.DailyLogsLandingPage;
import com.E2logy.gfhotel.utilities.WebUtil;

public class Dailylogs extends BaseTest {

	@Test
	public void TC5_DailyLogs() {
	
		WebUtil weobj = WebUtil.getObject();
		CommonPage commonPage= new CommonPage(weobj);
		commonPage.goToDailylogs();
		DailyLogsLandingPage DailyLogsLandingPage= 	new DailyLogsLandingPage(weobj);
		DailyLogsLandingPage.clickDailyLogsBT();
		DailyLogsDetailPage DailyLogsDatailPage=	new DailyLogsDetailPage(weobj);
		DailyLogsDatailPage.fillTitle("jhvjvjhg");
		DailyLogsDatailPage.fillNotte("test");
		reuseCode.selectDropdown("Bayside Inn Key Largo","PropertyDropdown");
		DailyLogsDatailPage.addLogButton();
		
	}	
}
