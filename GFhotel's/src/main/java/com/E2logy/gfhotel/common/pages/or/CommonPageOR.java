package com.E2logy.gfhotel.common.pages.or;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.E2logy.gfhotel.utilities.WebUtil;

import lombok.Getter;

@Getter
public class CommonPageOR {

	public CommonPageOR(WebUtil wt) {
		PageFactory.initElements(wt.getDriver(), this);// 8 byte
	}

	// _______________ login ___________________

	@CacheLookup
	@FindBy(xpath = "//input[@name='email']")
	protected WebElement userEmailTB;

	@CacheLookup
	@FindBy(xpath = "//input[@name='password']")
	protected WebElement passwordTB;

	@CacheLookup
	@FindBy(xpath = "//button[@class='btn btn-info btn-block button-green']")
	protected WebElement loginBT;

	@FindBy(xpath = "//button[text()='Perform']")
	private WebElement performBT;
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement contiuneBT;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement summitBT;
	
	@CacheLookup
	
	@FindBy(xpath = "//li[@class='nav-item']//span[text()='Checklists']")
	protected WebElement CheckListLK;

	@CacheLookup
	@FindBy(xpath = "//a[@class='nav-link nav-link-custom d-flex']//span[text()='Inspections']")
	protected WebElement InspectionsLK;

	@CacheLookup
	@FindBy(xpath = "//a[@class='nav-link nav-link-custom d-flex']//span[text()='MROs']")
	protected WebElement MRosLK;
	
	@CacheLookup
	@FindBy(xpath = "//a[@class='nav-link nav-link-custom d-flex']//span[text()='Daily Logs']")
	protected WebElement DailylogsLK;
	
	
	//a[@class='nav-link nav-link-custom d-flex']//span[text()='Trackers']
	@CacheLookup
	@FindBy(xpath = "	//a[@class='nav-link nav-link-custom d-flex']//span[text()='Trackers']")
	protected WebElement TrackersLK;
	
	//a[@class='nav-link nav-link-custom d-flex']//span[text()='AUDITS ']
	
	@CacheLookup
	@FindBy(xpath = "//a[@class='nav-link nav-link-custom d-flex']//span[text()='AUDITS ']")
	protected WebElement AdultsLK;
	

	@CacheLookup
	@FindBy(xpath = "//a[@class='nav-link nav-link-custom d-flex']//span[text()='Action items']")
	protected WebElement ActionitemsLK;
	
	@CacheLookup
	@FindBy(xpath = "//a[@class='nav-link nav-link-custom d-flex']//span[text()='Quick Links ']")
	protected WebElement QuickLinksLK;

	@CacheLookup
	@FindBy(xpath = "//a[@class='nav-link nav-link-custom d-flex']//span[text()='Brands ']")
	protected WebElement BrandsLK;

	@CacheLookup

	@FindBy(xpath = "//a[@class='nav-link nav-link-custom d-flex']//span[text()='Properties']")
	protected WebElement PropertiesLK;
	
	@CacheLookup
	@FindBy(xpath = "//a[@class='nav-link nav-link-custom d-flex']//span[text()='Templates']")
	protected WebElement TemplatesLK;
	
	@CacheLookup 
	@FindBy(xpath = "//a[@class='nav-link nav-link-custom d-flex']//span[text()='Audit Templates']")
	protected WebElement AuditTemplatesLK;
	

	@CacheLookup 
	@FindBy(xpath = "	//a[@class=\"nav-link nav-link-custom d-flex\"]//span[text()='Manage Links']")
	protected WebElement ManageLinkLK;
	
	@CacheLookup 
	@FindBy(xpath = "//a[@class=\"nav-link nav-link-custom d-flex\"]//span[text()='Users']")
	protected WebElement UsersLK;
	
	@CacheLookup 
	@FindBy(xpath = "//a[@class=\"nav-link nav-link-custom d-flex\"]//span[text()='Roles']")
	protected WebElement RolesLK;
	
	@CacheLookup 
	@FindBy(xpath = "//a[@class=\"nav-link nav-link-custom d-flex\"]//span[text()='My Account']")
	protected WebElement myAccountLK;
	@CacheLookup 
	@FindBy(xpath = "//img[@class=\"mg-b-0\"]")
	protected WebElement userclickonGfboticon;
	 
	
	
	
	// _______________ saveButton ___________________

	@FindBy(xpath = "//div[text()='Select...']")
	private WebElement selectDD;
	
	@FindBy(xpath = "//div[text()='Select...']/parent::div/child::div//input")
	private WebElement hotelnameTxt;
	
	
	@FindBy(xpath="//div[text()='Select...']")
	 WebElement clickOnSelectButton;
	
	@FindBy(xpath="//div[contains(@id,'react-select')]")
	 List<WebElement> selectTheElement;
	
	//__________________DropDown____________________
	
	
	@FindBy(xpath = "//label[text()='Category']/parent::div//div[text()='Select...']")
    protected WebElement categoryDD;
	
	@FindBy(xpath = "//label[text()='Property']/parent::div//div[text()='Select...']")
    protected WebElement propertyDD;
	
	@FindBy(xpath = "//label[text()='Zone']/parent::div//div[text()='Equipment']")
    protected WebElement zoneDD;
	
	@FindBy(xpath = "//label[text()='Location']/parent::div//div[text()='Select...']")
    protected WebElement locationDD;
	
	@FindBy(xpath = "//label[text()='Technician']/parent::div//div[text()='Select...']")
    protected WebElement technicianDD;
	
	@FindBy(xpath = "//label[text()='Assign To']/parent::div//div[text()='Select...']")
	protected WebElement assignToDD;
	
	@FindBy(xpath = "//label[text()='Brand']/parent::div//div[text()='Select...']")
	protected WebElement selectBrandDD;
	
	
	@FindBy(xpath = "//label[text()='Country']/parent::div//div[text()='Select...']")
	protected WebElement selectCountryDD;
	
	@FindBy(xpath = "//label[text()='State']/parent::div//div[text()='Select...']")
	protected WebElement selectStateDD;
	
	@FindBy(xpath = "//label[text()='Timezone']/parent::div//div[text()='Select...']")
	protected WebElement selectTimezoneDD;
	
	@FindBy(xpath = "//label[text()='Zone']/parent::div//div[text()='Select...']")
	protected WebElement selectZoneDD;
	
	
	
	
	
	
	
	
}
