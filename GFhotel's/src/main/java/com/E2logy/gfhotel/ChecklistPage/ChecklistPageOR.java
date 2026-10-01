package com.E2logy.gfhotel.ChecklistPage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.E2logy.gfhotel.utilities.WebUtil;

import lombok.Getter;

@Getter
public class ChecklistPageOR {

	public ChecklistPageOR(WebUtil wt) {
		PageFactory.initElements(wt.getDriver(), this);// 8 byte
	}

	@FindBy(xpath = "//button[text()='Add Checklist']")
	private WebElement addChecklistBT;

	@FindBy(xpath = "//a[@id='left-tabs-example-tab-room']")
	private WebElement roomBT;

	@FindBy(xpath = "//div[@id='left-tabs-example-tabpane-room']//table[@class='mg-b-0 checklist_inspect_table table']//a[text()='Guest Room Preventative Maintenance (Largo)']")
	private WebElement guestroompreLK;

	@FindBy(xpath = "//button[text()='Start Inspection']")
	private WebElement startinspectionBT;

	// Validation xpath
	@FindBy(xpath = "//h3[text()='Checklists']")
	private WebElement checklistheaderINT;

	@FindBy(xpath = "//label[text()='Property']")
	private WebElement getPropertyINT;

	@FindBy(xpath = "//label[text()='Property']/parent::div/div")
	protected WebElement selectProperty;

	@FindBy(xpath = "//h3[text()='Inspection']")
	private WebElement inspectionpageheaderINT;

	@FindBy(name = "checklist_name")
	protected WebElement checklistName;

	@FindBy(xpath = "//label[text()='Zone']/parent::div/div")
	protected WebElement selectZone;

	@FindBy(xpath = "//button[text()='ADD']")
	protected WebElement clickOnAddButton;

	@FindBy(xpath = "//table[@id=\"as-react-datatable\"]//descendant::tbody/tr/td[@class=\"checklist_id hand-cursor\"]")
	private List<WebElement> checklists;

	@FindBy(xpath = "//input[@name='category_name']")
	protected WebElement enterCategory;
	
	@FindBy(xpath = "//input[@name='task_name']")
	protected WebElement enterTask;
	
	@FindBy(xpath = "(//td[contains(@class,'checklist_id')])[1]")
	protected WebElement clickOnInfoUser;
	
	@FindBy(xpath = "//button[text()='Update']")
	protected WebElement clickOnUpdateBT;
	
	@FindBy(xpath = "//button[text()='Perform']")
	protected WebElement clickOnPerformBT;
	
	@FindBy(xpath = "//div[text()='Select...']")
	protected WebElement selectBT;
	
	@FindBy(xpath= "//button[text()='Import Template']")
	protected WebElement clickImportTemplates;
	
	@FindBy(xpath= "//button[text()='CONTINUE']")
	protected WebElement clickOnContinue;
	
	@FindBy(xpath = "//table[@id='as-react-datatable']/tbody/tr")
	private List<WebElement> listOfTemplates;
	
	@FindBy(className= "az-toggle")
	protected WebElement clickOnActiveStatus;
	
	@FindBy(name= "checklist_name")
	private WebElement templateName;
	
	@FindBy(xpath= "//button[text()='add category']")
	private WebElement addCategory;
	
	@FindBy(xpath= "//button[text()='Filter']")
	protected WebElement addFilter;
	
	@FindBy(xpath= "//button[text()='Search']")
	protected WebElement searchButton;
}
