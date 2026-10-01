package com.lizt.automation.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;

public class DetailsPage extends BasePage {
	public DetailsPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public boolean isDisplayed(String listName) {
		return isDisplayed(listName, Duration.ofSeconds(6));
	}

	public void editList(String currentName, String newName) {
		clickText(currentName);
		clearAndType(input(), newName);
		clickText("Save");
	}

	public void createCategory() {
		clickText("Create");
	}

	public void addCategory(String name) {
		clearAndType(input(), name);
		clickText("Add");
	}

	public void openCategory(String category) {
		clickText(category);
	}

	public void addItem(String item) {
		List<WebElement> plus = driver.findElements(AppiumBy.xpath("//*[@content-desc='plus']"));
		if (plus.isEmpty())
			plus = driver.findElements(AppiumBy.xpath("//*[contains(@content-desc,'plus') or @text='+']"));
		if (plus.isEmpty())
			throw new AssertionError("Category + button not found. Capture Appium page source to update locator.");
		plus.get(plus.size() - 1).click();
		clearAndType(input(), item);
		clickText("Add");
	}

	public void enterItemAndAdd(String item) {
		clearAndType(input(), item);
		clickText("Add");
	}

	public void submitEmptyItem() {
		clickText("Add");
	}

	public void openAddItem() {
		List<WebElement> plus = driver.findElements(AppiumBy.xpath("//*[@content-desc='plus']"));
		if (plus.isEmpty())
			plus = driver.findElements(AppiumBy.xpath("//*[contains(@content-desc,'plus') or @text='+']"));
		if (plus.isEmpty())
			throw new AssertionError("Category + button not found.");
		plus.get(plus.size() - 1).click();
	}

	public boolean hasItem(String item) {
		return isDisplayed(item, Duration.ofSeconds(4));
	}

	public void completeItem(String item) {
		clickText(item);
	}

	public void deleteCompletedItem() {
		clickText("Delete");
	}

	public boolean editItemControlExists(String item) {
		try {
			WebElement itemEl = text(item);
			return !itemEl.findElements(AppiumBy.xpath("ancestor::*//*[contains(@text,'Edit')]")).isEmpty();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validationShown() {
		return isDisplayed("You must add a title", Duration.ofSeconds(3));
	}

	public void backToHome() {
		back();
	}

	public boolean hasText(String value) {
		return isDisplayed(value, Duration.ofSeconds(2));
	}
}
