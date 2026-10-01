package com.lizt.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddListPage extends BasePage {
	public AddListPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public boolean isDisplayed() {
		return isDisplayed("Create List", java.time.Duration.ofSeconds(5));
	}

	public void enterTitle(String title) {
		clearAndType(input(), title);
	}

	public void save() {
		clickText("Create List");
	}

	public void saveEdit() {
		clickText("Save");
	}

	public boolean hasValidationMessage() {
		return isDisplayed("You must add a title", java.time.Duration.ofSeconds(3));
	}
}
