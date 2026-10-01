package com.lizt.automation.base;

import com.lizt.automation.pages.HomePage;
import com.lizt.automation.utils.Config;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URI;
import java.nio.file.Path;
import java.time.Duration;

public abstract class BaseTest {
	protected AndroidDriver driver;
	protected WebDriverWait wait;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		UiAutomator2Options options = new UiAutomator2Options().setPlatformName(Config.get("platformName"))
				.setAutomationName(Config.get("automationName")).setDeviceName(Config.deviceName())
				.setAppPackage(Config.appPackage()).setAppActivity(Config.appActivity())
				.setNewCommandTimeout(Duration.ofSeconds(Long.parseLong(Config.get("newCommandTimeout"))));

		String app = Config.appPath();
		if (app != null && !app.isBlank()) {
			Path path = Path.of(app).toAbsolutePath().normalize();
			options.setApp(path.toString());
		}
		driver = new AndroidDriver(URI.create(Config.server()).toURL(), options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		new HomePage(driver, wait).dismissWelcomeIfPresent();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

	public AndroidDriver getDriver() {
		return driver;
	}
}
