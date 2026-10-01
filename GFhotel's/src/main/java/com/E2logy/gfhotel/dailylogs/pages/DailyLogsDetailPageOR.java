package com.E2logy.gfhotel.dailylogs.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.E2logy.gfhotel.utilities.WebUtil;

import lombok.Getter;

@Getter
public class DailyLogsDetailPageOR {

	public DailyLogsDetailPageOR(WebUtil wu) {
		PageFactory.initElements(wu.getDriver(), this);

	}

	@FindBy(xpath = "//input[@name='title']")
	private WebElement titleTB;

	@FindBy(xpath = "//textarea[@name='note']")
	private WebElement noteTB;

	@FindBy(xpath = "//div[text()='Select...']/parent::div")
	private WebElement Property;

	@FindBy(xpath = "//div[text()='Buffalo Niagara Marriott']")
	private WebElement ListProperty;

	@FindBy(xpath = "//button[text()='Add']")
	private WebElement addButton;

	@FindBy(xpath = "//button[text()='Add Daily Log']")
	private WebElement AddDailyLog;

	// all header

	@FindBy(xpath = "//table[@id=\"as-react-datatable\"]//tr//th")
	private List<WebElement> allHeader;

	@FindBy(xpath = "//td[@class='property_id hand-cursor']")
	private List<WebElement> propertyValues;

	@FindBy(xpath = "//td[@class='created_by hand-cursor']")
	private List<WebElement> techniciansValues;

}
