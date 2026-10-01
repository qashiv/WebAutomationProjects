package com.E2logy.gfhotel.Inspection.pages.or;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.E2logy.gfhotel.utilities.WebUtil;

import lombok.Getter;

@Getter
public class InspectionLandingPageOR {
	
	public InspectionLandingPageOR(WebUtil wu) {
		PageFactory.initElements(wu.getDriver(), this);// 8 byte
	}
		

		@FindBy(xpath = "//label[text()='Tank Water Level']")
		private WebElement tankwaterCB;

		@FindBy(xpath = "//div[@class='d-flex']//button[@value='YES']")
		private WebElement yesBT;

		@FindBy(xpath = "//div[@class='d-flex']//button[@value='NO']")
		private WebElement noBT;
		@FindBy(xpath = "//div[@class='d-flex']//button[@value='NOTE']")
		private WebElement addnoteBT;

		@FindBy(xpath = "//label[text()='Tub Drain/Clean/Zip it']")
		private WebElement tubdrainCB;

		@FindBy(xpath = "//label[contains(text(),'Bathtub Water')]")
		private WebElement bathtubCB;

		// LIVING

		@FindBy(xpath = "//label[contains(text(),'In Room Safe')]")
		private WebElement roomsafeCB;

		@FindBy(xpath = "//label[contains(text(),'Smoke Detector Test')]")
		private WebElement smokediteCB;

		@FindBy(xpath = "//label[contains(text(),'Alarm clock/Time/Radio')]")
		private WebElement alarmclockCB;

		@FindBy(xpath = "//label[contains(text(),'TV Remote')]")
		private WebElement tvremoteCB;
	
		//Hall
		@FindBy(xpath = "//label[text()='Closet Doors/Latch']")
		private WebElement doorsCB;
		
		
		//review 
		
		@FindBy(xpath = "//input[@name='out_time']")
		private WebElement outtimeDD;
		
		@FindBy(xpath = "//div[text()='22']")
		private WebElement choosedateBT;
		
		
		
		
		///Validation
		
		@FindBy(xpath = "//th[text()='Checklist']/parent::tr/parent::thead/following-sibling::tbody/child::tr[1]")
		private WebElement inpectionDataINT;
		
		@FindBy(xpath = "//div[@class='form-group col-md-3 m-0 inspe_hgt']//label[text()='In Time']/following-sibling::p")
		private WebElement intimeINT;
		@FindBy(xpath = "//div[@class='form-group col-md-3 m-0 inspe_hgt']//label[text()='Out Time']/following-sibling::p")
		private WebElement outtimeINT;
		
		@FindBy(xpath = "//div[@class='form-group col-md-3 m-0 inspe_hgt']//label[text()='Zone Type']/following-sibling::p")
		private WebElement zonetypeINT;
		
		@FindBy(xpath = "//div[@class='form-group col-md-3 m-0 inspe_hgt']//label[text()='Location']/following-sibling::p")
		private WebElement locationINT;
		
	}

