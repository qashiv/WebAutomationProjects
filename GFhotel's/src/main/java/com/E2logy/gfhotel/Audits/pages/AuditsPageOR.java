package com.E2logy.gfhotel.Audits.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.E2logy.gfhotel.utilities.WebUtil;

import lombok.Getter;

@Getter
public class AuditsPageOR {
	WebDriver driver;
	public AuditsPageOR(WebUtil wt) {
		driver=wt.getDriver();
		PageFactory.initElements(driver, this);// 8 byte
	}
	@FindBy(xpath = "//a[text()='HR Audit Template']")
	private WebElement hraudittempleteLK;

	@FindBy(xpath = "//button[text()='Start Audit']")
	private WebElement auditstartBT;

	@FindBys({ @FindBy(xpath = "//span[@class='checkmark']") })
	private List<WebElement> auditCheckBoxesCB;

	@FindBys({ @FindBy(xpath = "//button[@value='YES']") })
	private List<WebElement> auditYesBT;

	public WebElement getDateBT(String date) {
		return driver.findElement(By.xpath("//div[text()='" + date + "']"));
	}

	@FindBy(xpath = "//div[@class='react-datepicker__month-read-view']")
	private WebElement clickmonthDD;

	@FindBy(xpath = "//input[@name='out_time']")
	private WebElement completeonBT;

	@FindBy(xpath = "//input[@id='react-select-2-input']")
	private WebElement auditstatusDD;

	@FindBy(xpath = "//th[text()='Status']/parent::tr/parent::thead/following-sibling::tbody/child::tr[1]")
	private WebElement createdauditROW;
	
	
	// Validation
	@FindBy(xpath = "//h3[text()='Audits Templates']")
	private WebElement audittempleteHeaderINT;
	
	@FindBy(xpath = "//h3[text()='Audit Checklists']")
	private WebElement propertypopheaderINT;
	
	@FindBy(xpath = "//h3[text()='Audit']")
	private WebElement auditinfoheaderINT;
	
	@FindBy(xpath = "//label[text()='Property Name']/following-sibling::p")
	private WebElement propertyINT;
	
	@FindBy(xpath = "//label[text()='Current Status']/following-sibling::p")
	private WebElement adutstatusINT;
	

}
