package com.E2logy.gfhotel.mros.testscript;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.E2logy.gfhotel.MORS.pages.MroLanndingPage;
import com.E2logy.gfhotel.base.BaseTest;
import com.E2logy.gfhotel.common.pages.CommonPage;
import com.E2logy.gfhotel.utilities.WebUtil;

public class MrosTestScript extends BaseTest{
	
	
	@Test
	
	public void verifyCreatingMro() throws InterruptedException {
		WebUtil util = WebUtil.getObject();
		CommonPage cp = new CommonPage(util);
		cp.goToMros();
		MroLanndingPage mrlp = new MroLanndingPage(util);
		mrlp.clickAdMroButton();
		mrlp.enterInputValueTitle();
		//cp.getCategoryDD().click();
		cp.selectDropdown(cp.getCategoryDD(), "Offices");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mrlp.uploadFile("C:\\Users\\suraj.p\\Downloads\\colourful-flowers-buds-with-leaves-table");
		cp.selectDropdown(cp.getPropertyDD(), "DEV TEST HOTEL");
		Thread.sleep(5000);
		cp.selectDropdown(cp.getZoneDD(), "Commercial Area");
		Thread.sleep(1000);
		cp.selectDropdown(cp.getLocationDD(), "Area");
		Thread.sleep(1000);
		cp.selectDropdown(mrlp.getPriorityDD(), "Medium");
		cp.selectDropdown(cp.getTechnicianDD(), "Nikhil admin");
		mrlp.selectDate(18);
		util.click(mrlp.getAddButton());
		mrlp.clickViewCategoryButton();
		Thread.sleep(2000);
		int count= util.getColumnNumberByColumnName("//table[@id='as-react-datatable']","Category");
		List<String> list= util.getColumnDataListByColumnNumber("//table[@id='as-react-datatable']", count);
		Thread.sleep(2000);
		int count1= util.getColumnNumberByColumnName("//table[@id='as-react-datatable']","Status");
		List<String> list1= util.getColumnDataListByColumnNumber("//table[@id='as-react-datatable']", count1);
		for(int i=0; i<list.size();i++) {
			
			String a= list.get(i);
			String b= list1.get(i);
			if(a.equals("Offices") && b.equals("Active")) {
			Assert.assertEquals(a, "Offices");
			break;
			}
			
		}
	}
	
}