package com.icici.forex.or;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class UserDetailsPageOr extends AbstractPage {

	public UserDetailsPageOr(WebDriver driver) {
		super(driver);
	}

	public ExtendedWebElement getRadioNonAccountHolder() {
		return radioNonAccountHolder;
	}

	public ExtendedWebElement getInputAccountNo() {
		return inputAccountNo;
	}

	public ExtendedWebElement getInputCompanyName() {
		return inputCompanyName;
	}

	public ExtendedWebElement getSelectBranchSolID() {
		return selectBranchSolID;
	}

	public ExtendedWebElement getInputSOLIdSearch() {
		return inputSOLIdSearch;
	}

	public ExtendedWebElement getBtnSubmit() {
		return btnSubmit;
	}

	public List<ExtendedWebElement> getOptionListBox() {
		return optionListBox;
	}

	public ExtendedWebElement getTxtSelect() {
		return txtSelect;
	}

	public ExtendedWebElement getOptionBranchSolId() {
		return optionBranchSolId;
	}

	@FindBy(xpath = "//div[@class='option-text']")
	private ExtendedWebElement optionBranchSolId;

	@FindBy(xpath = "//*[text()='Select']")
	private ExtendedWebElement txtSelect;

	@FindBy(xpath = "//div[@role='listbox']//mat-option")
	private List<ExtendedWebElement> optionListBox;

	@FindBy(xpath = "//span[text()=' Non-Account holder ']")
	private ExtendedWebElement radioNonAccountHolder;

	@FindBy(xpath = "//input[@formcontrolname='accountNumber']")
	private ExtendedWebElement inputAccountNo;

	@FindBy(xpath = "//input[@formcontrolname='companyName']")
	private ExtendedWebElement inputCompanyName;

	@FindBy(xpath = "//*[text()='Branch SOL ID']/parent::div//div[contains(@class,'icon-container')]")
	private ExtendedWebElement selectBranchSolID;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private ExtendedWebElement inputSOLIdSearch;

	@FindBy(xpath = "//div[@class='button-container']//button")
	private ExtendedWebElement btnSubmit;

}
