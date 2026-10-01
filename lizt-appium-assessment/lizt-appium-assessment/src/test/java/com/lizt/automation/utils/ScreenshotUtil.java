package com.lizt.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ScreenshotUtil {
	private ScreenshotUtil() {
	}

	public static String capture(WebDriver driver, String name) {
		try {
			Path dir = Path.of("screenshots");
			Files.createDirectories(dir);
			String stamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS"));
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Path target = dir.resolve(name + "_" + stamp + ".png");
			Files.copy(source.toPath(), target);
			return target.toString();
		} catch (Exception e) {
			return "Screenshot failed: " + e.getMessage();
		}
	}
}
