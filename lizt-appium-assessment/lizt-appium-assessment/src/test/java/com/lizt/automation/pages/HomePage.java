package com.lizt.automation.pages;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public void dismissWelcomeIfPresent() {
		if (isDisplayed("Finish", Duration.ofSeconds(3)))
			clickText("Finish");
		int guard = 0;
		while (guard++ < 5 && isDisplayed("Next", Duration.ofSeconds(1)))
			clickText("Next");
		if (isDisplayed("Finish", Duration.ofSeconds(2)))
			clickText("Finish");
	}

	public boolean isHomeDisplayed() {
		return isDisplayed("My Lists", Duration.ofSeconds(8));
	}

	public boolean hasText(String value) {
		return isDisplayed(value, Duration.ofSeconds(2));
	}

	public boolean hasList(String name) {
		return isDisplayed(name, Duration.ofSeconds(3));
	}

	public void addList() {
		clickText("Add list");
	}

	public void openList(String name) {
		clickText(name);
	}

	public void enterSelectionMode() {
		clickText("Check");
	}

	public void swipeListLeft(String name) {
		WebElement el = text(name);
		var r = el.getRect();
		int left = Math.max(1, r.getX());
		int top = Math.max(1, r.getY() - 30);
		int width = Math.max(350, r.getWidth() + 180);
		int height = Math.max(120, r.getHeight() + 60);
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", Map.of("left", left, "top", top, "width",
				width, "height", height, "direction", "left", "percent", 0.80, "speed", 900));
	}

	public void clickDeleteAction() {
		clickText("Delete");
	}

	public void cancelDeleteIfAsked() {
		if (isDisplayed("Do you want to remove the list?", Duration.ofSeconds(2)))
			clickText("Cancel");
	}

	public void confirmDeleteIfAsked() {
		if (isDisplayed("Do you want to remove the list?", Duration.ofSeconds(2)))
			clickText("Delete");
		else if (isDisplayed("Do you want to delete selected items?", Duration.ofSeconds(2)))
			clickText("Delete");
	}

	public void goToSettings() {
		try {
			driver.findElement(AppiumBy.accessibilityId("settings")).click();
		} catch (Exception e) {
			driver.findElement(AppiumBy.xpath("//*[@content-desc='settings']")).click();
		}
	}

	public void goToReminders() {
		try {
			driver.findElement(AppiumBy.accessibilityId("notifications")).click();
		} catch (Exception e) {
			driver.findElement(AppiumBy.xpath("//*[@content-desc='notifications']")).click();
		}
	}

	public void goToHomeTab() {
		try {
			driver.findElement(AppiumBy.accessibilityId("list")).click();
		} catch (Exception e) {
			driver.findElement(AppiumBy.xpath("//*[@content-desc='list']")).click();
		}
	}
}
