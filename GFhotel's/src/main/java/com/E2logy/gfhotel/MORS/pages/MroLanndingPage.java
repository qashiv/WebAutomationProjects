package com.E2logy.gfhotel.MORS.pages;

import org.openqa.selenium.By;

import com.E2logy.gfhotel.utilities.WebUtil;

public class MroLanndingPage extends MrosLandingOR_Page  {
	
	
	WebUtil ut;
	
	public MroLanndingPage(WebUtil ut) {
		super(ut);
		this.ut = ut;
	}
	
	public void clickAdMroButton() {
		ut.click(getAddMroBT());
		
	}
	
	public void enterInputValueTitle() {
		ut.sendKeys(getEnterTitle(), "Mr");
		
	}
	
	public void selectValuePriority() {
		ut.sendKeys(getPriorityDD(), "Medium");
	}
	
	public void uploadFile(String path) {
		ut.sendKeys(getFileUpload(), path);
	}
	
	public void selectDate(int date) {
		ut.getDriver().findElement(By.name("due_date")).click();
		ut.getDriver().findElement(By.xpath("//div[text()='"+date+"']")).click();
	}
	
	public void clickViewCategoryButton() {
		ut.click(getViewCategory());
		
	}
	
}
