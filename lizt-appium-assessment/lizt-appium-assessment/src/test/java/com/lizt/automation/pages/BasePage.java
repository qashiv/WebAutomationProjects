package com.lizt.automation.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;

public abstract class BasePage {
	protected final WebDriver driver;
	protected final WebDriverWait wait;

	protected BasePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	protected WebElement text(String value) {
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//*[@text=" + quote(value) + "]")));
	}

	protected List<WebElement> texts(String value) {
		return driver.findElements(AppiumBy.xpath("//*[@text=" + quote(value) + "]"));
	}

	protected WebElement input() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.EditText")));
	}

	protected WebElement inputAt(int index) {
		return wait.until(d -> {
			List<WebElement> els = d.findElements(AppiumBy.className("android.widget.EditText"));
			return els.size() > index ? els.get(index) : null;
		});
	}

	protected void clickText(String value) {
		text(value).click();
	}

	protected void clearAndType(WebElement el, String value) {
		el.clear();
		el.sendKeys(value);
	}

	protected boolean isDisplayed(String value, Duration timeout) {
		try {
			new WebDriverWait(driver, timeout).until(
					ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//*[@text=" + quote(value) + "]")));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	protected String quote(String value) {
		if (!value.contains("'"))
			return "'" + value + "'";
		return "\"" + value + "\"";
	}

	protected void back() {
		driver.navigate().back();
	}
}
