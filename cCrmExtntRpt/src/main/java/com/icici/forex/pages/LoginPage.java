package com.icici.forex.pages;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.icici.forex.or.LoginPageOr;

public class LoginPage extends LoginPageOr {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	String title;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void loginApplication(String userId, String pswrd) {
		try {

			LOGGER.info("Login Page opened successfully");
			driver.manage().timeouts().implicitlyWait(EXPLICIT_TIMEOUT, TimeUnit.SECONDS);
			getInputUserName().type(userId);
			getInputPassword().type(pswrd);
			getBtnSignIn().click();
		} catch (Exception e) {
			LOGGER.info(e.toString() + " UserID or Password is incorrect");
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
