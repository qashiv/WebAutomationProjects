package com.icici.forex.or;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class LoginPageOr extends AbstractPage {

	protected LoginPageOr(WebDriver driver) {
		super(driver);
	}

	public ExtendedWebElement getInputUserName() {
		return inputUserName;
	}

	public ExtendedWebElement getInputPassword() {
		return inputPassword;
	}

	public ExtendedWebElement getBtnSignIn() {
		return btnSignIn;
	}

	public ExtendedWebElement getInputCibLoginId() {
		return inputCibLoginId;
	}

	public ExtendedWebElement getInputCibPswrd() {
		return inputCibPswrd;
	}

	public ExtendedWebElement getBtnProceed() {
		return btnProceed;
	}

	
	@FindBy(xpath = "//input[@id='VALIDATE_CREDENTIALS']")
	private ExtendedWebElement btnProceed;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private ExtendedWebElement inputCibPswrd;

	@FindBy(xpath = "//input[@placeholder='Login ID']")
	private ExtendedWebElement inputCibLoginId;

	@FindBy(xpath = "//input[@formcontrolname='username']")
	private ExtendedWebElement inputUserName;

	@FindBy(xpath = "//input[@formcontrolname='password']")
	private ExtendedWebElement inputPassword;

	@FindBy(xpath = "//button[@class='form-submit-btn']")
	private ExtendedWebElement btnSignIn;

}
