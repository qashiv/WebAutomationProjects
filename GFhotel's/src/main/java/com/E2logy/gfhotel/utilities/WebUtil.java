package com.E2logy.gfhotel.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.RandomString;

public class WebUtil {
	private WebDriver driver;

	private WebUtil() {

	}

	private static WebUtil webUtil;
	private ExtentTest extTest;

	public void setExtentTestObject(ExtentTest extTest) {
		this.extTest = extTest;
	}

	public ExtentTest getExtentTestObject() {
		return this.extTest;
	}

	public static WebUtil getObject() {
		if (webUtil == null) {
			webUtil = new WebUtil();
		}
		return webUtil;
	}

	public String getElementText(WebElement we) {

		String actualText = we.getText();
		System.out.println("Actual Text is: " + actualText);
		return actualText;
	}

	public void myThread(long duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void printMessage(String message) {
		System.out.println(message);
	}

	public void launchBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(co);
				printMessage("Chrome Browser is launched sucessfully");
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "Driver\\geckodriver.exe");
				FirefoxOptions fireOptn = new FirefoxOptions();
				fireOptn.addArguments("--remote-allow-origins=*");
				driver = new FirefoxDriver(fireOptn);
				printMessage("FireFox Browser is launched sucessfully");
			} else if (browserName.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", "Driver\\msedgedriver.exe");
				EdgeOptions edOptn = new EdgeOptions();
				edOptn.addArguments("--remote-allow-origins=*");
				driver = new EdgeDriver(edOptn);
				printMessage("Edge Browser is launched sucessfully");
			} else {
				printMessage("Unsupported browser choice");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			printMessage("Browser is not launched sucessfully");
		}
	}

	public void statusAndDetails(Status status, String message) {
		extTest.log(status, message);
	}

	public void windowMaximize() {
		try {
			driver.manage().window().maximize();
			statusAndDetails(Status.INFO, "Browser is maximized");
		} catch (Exception e) {
			e.printStackTrace();
			statusAndDetails(Status.INFO, "Browser is not maximized");
		}
	}
	//////////// windowMinimize \\\\\\\\\\

	public void windowMinimize() {

		try {
			driver.manage().window().minimize();
			statusAndDetails(Status.INFO, "the window is minimized");
		} catch (Exception e) {
			e.printStackTrace();
			statusAndDetails(Status.INFO, "the window is not minimized");
		}
	}

	/// go back ------

	public void GoBackPage() {
		driver.navigate().back();
		statusAndDetails(Status.INFO, "the Page has been back successfully ");

	}

	// _________holdon

	public void HoldOn(int sec) throws InterruptedException {

		Thread.sleep(sec);
	}

	//////////// myIplicitilyWait \\\\\\\\\\

	public void myIplicitilyWait(long seconds) {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
			statusAndDetails(Status.INFO, "the maximum timeouts for waiting is " + seconds);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	//////////// openUrl \\\\\\\\\\

	/**
	 * @param url
	 */
	public void openUrl(String url) {
		try {
			driver.get(url);
			statusAndDetails(Status.PASS, "the given url :-" + url + " is launched sucessfully");
		} catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to open the URL
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String script = "window.location.href='" + url + "';";
			jsExecutor.executeScript(script);
			statusAndDetails(Status.PASS, "the given url :-" + url + " is launched sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
			statusAndDetails(Status.PASS, "the given url :-" + url + " is not launched sucessfully");
			throw e;

		}
	}

	//////////// goToHitUrl \\\\\\\\\\

	/**
	 * with the help of this method i.e goToHitUrl() we can hit any url in the
	 * browser.
	 * 
	 * @param url by using of this url we can hit any url to the browser
	 */
	public void goToHitUrl(String url) {
		try {
			driver.navigate().to(url);
			printMessage("the given url :- " + url + " is hit successfully");
		} catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to execute JavaScript code to open the URL
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.location.href = '" + url + "';");
			printMessage("the given url :- " + url + " is hit successfully");
		} catch (WebDriverException e) {

			// WebDriverException:-----WebDriverException can be thrown for various reasons,
			// such as invalid URL,
			// network issues, browser crashes, or any other unexpected
			// errors during the navigation.......
			e.printStackTrace();
			printMessage("the given url :- " + url + " is not hit successfully");
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			printMessage("the given url :- " + url + " is not hit successfully");
			throw e;
		}
	}

	//////////// getPageTitle \\\\\\\\\\

	/**
	 * with the help of this method we can easily find the title of the current
	 * page..
	 * 
	 * @return it returns string as a title of the current page
	 */
	public String getPageTitle() {
		String pageTitle = null;
		try {
			pageTitle = driver.getTitle();
			statusAndDetails(Status.INFO, "find the title of the page is :-" + pageTitle);
		} catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to execute JavaScript code and get the page title
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String script = "return document.title;";
			pageTitle = (String) jsExecutor.executeScript(script);
			statusAndDetails(Status.INFO, "find the title of the page is :-" + pageTitle);
			return pageTitle;
		} catch (Exception e) {
			e.printStackTrace();
			statusAndDetails(Status.INFO, "Didn't find the title of the page is :-" + pageTitle);
		}
		return pageTitle;
	}

	//////////// myClose \\\\\\\\\\

	public void myClose() {

		try {
			driver.close();
			statusAndDetails(Status.INFO, "the current window or tab is closed successfully");
		} catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to close the current browser window
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.close();");
			statusAndDetails(Status.INFO, "the current window or tab is closed successfully");
		} catch (NoSuchWindowException e) {
			// NoSuchWindowException: If the current window or tab is already closed or does
			// not exist.
			e.printStackTrace();
			statusAndDetails(Status.INFO, "the current window or tab is not closed successfully");
			throw e;
		} catch (WebDriverException e) {
			// WebDriverException can be caused by a variety of factors, such as invalid
			// driver parameters,
			// network errors, or unexpected JavaScript errors....
			e.printStackTrace();
			statusAndDetails(Status.PASS, "the current window or tab is not closed successfully");
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			statusAndDetails(Status.INFO, "the current window or tab is not closed successfully");
			throw e;
		}
	}

	//////////// myQuit \\\\\\\\\\
	public void jsClickMethod(WebElement we, String elementName) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", we);
			extTest.log(Status.INFO,
					"Successfully : Maouse  over and After that click on Element Through Java script : - "
							+ elementName);
		} catch (Exception e) {
			extTest.log(Status.FAIL, "click  action is not perform by java script");
			throw e;
		}
	}

	public void jsMouseOver(WebElement we, String elementName) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript(
					"if(document.createEvent){var evObj = " + "document.createEvent('MouseEvents');evObj.initEvent"
							+ "('mouseover',true, false); arguments[0].dispatchEvent(evObj);} "
							+ "else if(document.createEventObject) " + "{ arguments[0].fireEvent('onmouseover');}",
					we);
			extTest.log(Status.INFO,
					"Successfully mouceOver on the element  [" + elementName + " ] Through javascript");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Mouse over action is not perform by java script");
		}
	}

	public Actions mouseOver(WebElement we) {
		// WebElement we = searchElementOnHTML(locator, elementName);
		Actions act = new Actions(driver);
		String elementName = we.getAccessibleName();
		try {
			act.moveToElement(we).build().perform();
			extTest.log(Status.INFO, "Successfully mouceOver on the element  [" + elementName + " ] ");

		} catch (ElementNotInteractableException e) {
			jsMouseOver(we, elementName);

		} catch (StaleElementReferenceException e) {

			act.moveToElement(we).build().perform();
			extTest.log(Status.INFO,
					"Successfully mouceOver on the element  [" + elementName + " ] After Handaling Stale Exception");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Due to Exception Action not perform ");
			extTest.addScreenCaptureFromPath(screenShot(elementName));
			throw e;
		}
		return act;
	}

	public void quit() {

		try {
			driver.quit();
			statusAndDetails(Status.INFO, "All the  window or tab is closed successfully");
		} catch (ElementNotInteractableException e) {
			// Use JavascriptExecutor to quit the entire WebDriver session
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.open('', '_self', ''); window.close();");
			statusAndDetails(Status.INFO, "All the  window or tab is closed successfully");
		} catch (NoSuchSessionException e) {
			// The NoSuchSessionException is an exception raised by Selenium WebDriver when
			// it tries to perform an operation on a session that does not exist...
			e.printStackTrace();
			statusAndDetails(Status.INFO, "All the  window or tab is not closed successfully");
			throw e;
		} catch (WebDriverException e) {
			// WebDriverException can be caused by a variety of factors, such as invalid
			// driver parameters,
			// network errors, or unexpected JavaScript errors....
			e.printStackTrace();
			statusAndDetails(Status.INFO, "All the  window or tab is not closed successfully");
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			statusAndDetails(Status.INFO, "All the  window or tab is not closed successfully");
			throw e;
		}
	}
	//////////// switchToWindowByTitle \\\\\\\\\\

	public void switchToWindowByTitle(String expectPageTitle) {

		// NoSuchWindowException: This exception occurs when you try to switch to a
		// window
		// using a window handle that does not exist or has been closed.......

		try {
			Set<String> setWindowHandles = driver.getWindowHandles();
			for (String handleValue : setWindowHandles) {
				driver.switchTo().window(handleValue);
				String actPageTitle = driver.getTitle();
				if (actPageTitle.equalsIgnoreCase(expectPageTitle)) {
					break;
				}
			}

//try {
//			Set<String>setWindowHandles= driver.getWindowHandles();
//			for (String handlevalue : setWindowHanles) {
//				driver.switchTo().window(handleValue);
//				String actPageTitle = driver.gettitle ();
//				if (actPageTitle.equalsIgnoreCase(expectPageTitle))
//					break;
//				   
//			}
//		}
//			
			statusAndDetails(Status.PASS, "the Window is switched by title :- " + expectPageTitle + " successfully");
		} catch (StaleElementReferenceException e) {
			Set<String> setWindowHandles = driver.getWindowHandles();
			for (String handleValue : setWindowHandles) {
				driver.switchTo().window(handleValue);
				String actPageTitle = driver.getTitle();
				if (actPageTitle.equalsIgnoreCase(expectPageTitle)) {
					break;
				}
			}
			statusAndDetails(Status.INFO, "the Window is  switched by title :- " + expectPageTitle + " successfully");
		} catch (NoSuchWindowException e) {
			e.printStackTrace();
			statusAndDetails(Status.INFO,
					"the Window is not  switched by title :- " + expectPageTitle + " successfully");
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			statusAndDetails(Status.INFO,
					"the Window is not switched by title :- " + expectPageTitle + " successfully");
			throw e;

		}
	}
	//////////// myFindElement \\\\\\\\\\

	/**
	 * this method is the most commonaly used to find the element then we perform
	 * any action.
	 * 
	 * @param xpath       it is used to find element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 * 
	 * @return it returns the webElement
	 */

	//////////// myFindElements \\\\\\\\\\

	/**
	 * this method is used to get multiple weblement as a list of webElement
	 * 
	 * @param xpath it is used to find element which we have to perform operation.
	 * 
	 * @return it returns list of webElements
	 */
	public List<WebElement> myFindElements(String xpath) {
		List<WebElement> webLsts = null;

		try {
			webLsts = driver.findElements(By.xpath(xpath));
			statusAndDetails(Status.INFO, "The List of WebElements is found successfully");
		} catch (InvalidSelectorException e) {
			e.printStackTrace();
			statusAndDetails(Status.INFO, "The List of WebElements is not found successfully");
			throw e;
		} catch (StaleElementReferenceException e) {
			webLsts = driver.findElements(By.xpath(xpath));
			statusAndDetails(Status.INFO, "The List of WebElements is found successfully");
		} catch (ElementClickInterceptedException e) {
			/**
			 * ElementClickInterceptedException :- it is the child class of
			 * ElementNotInteractableException this type exception occures when the element
			 * is hidden so we can use to overcome this exception then we can use java
			 * script because JavasriptExecutorenters any value or action whether any
			 * element hidden or not hidden in UI.........
			 */
			e.printStackTrace();
			statusAndDetails(Status.INFO, "The List of WebElements is not found successfully");
			throw e;
		} catch (NullPointerException e) {
			webLsts = driver.findElements(By.xpath(xpath));
			statusAndDetails(Status.INFO, "The List of WebElements is  found successfully");
		} catch (Exception e) {
			e.printStackTrace();
			statusAndDetails(Status.INFO, "The List of WebElements is not found successfully");
			throw e;
		}

		return webLsts;

	}

	//////////// mySendKeys \\\\\\\\\\

	/**
	 * this method is commonaly used to send value in input box or input field.
	 * 
	 * @param xpath       it is used to find element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 * 
	 * @param string      we have to send the input value in the textbox or input
	 *                    field
	 * 
	 * @throws ElementClickInterceptedException this type exception occures when the
	 *                                          element is hidden so we can use to
	 *                                          overcome this exception hen we can
	 *                                          use java script because
	 *                                          JavasriptExecutorenters any value or
	 *                                          action whether any element hidden or
	 *                                          not hidden in UI.........
	 * 
	 */
	public void sendKeys(WebElement webObj, String string) throws ElementClickInterceptedException {
		// WebElement
		String elementName = webObj.getAccessibleName();
		if (webObj.isDisplayed() && webObj.isEnabled()) {
			statusAndDetails(Status.PASS, "Element is Displayed and enabled ");
			try {

				webObj.sendKeys(string);
				statusAndDetails(Status.INFO, string + " value is passed in " + elementName + " textbox successfully");
			} catch (ElementNotInteractableException e) {

				/**
				 * ElementNotInteractableException :- this type exception occures when the
				 * element is hidden so we can use to overcome this exception then we can use
				 * java script because JavasriptExecutorenters any value or action whether any
				 * element hidden or not hidden in UI.........
				 */
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].value='" + string + "'", webObj);
				statusAndDetails(Status.INFO, string + " value is passed in " + elementName + " textbox successfully");
			} catch (StaleElementReferenceException e) {
				webObj = driver.findElement(By.xpath("//input[@name='" + string + "']"));
				statusAndDetails(Status.PASS, "we have found " + elementName + " successfully");
				webObj.sendKeys(string);
				statusAndDetails(Status.INFO, string + " value is passed in " + elementName + " textbox successfully");
			} catch (Exception e) {
				e.printStackTrace();
				statusAndDetails(Status.INFO,
						string + " value is not passed in " + elementName + " textbox successfully");
				throw e;
			}

		} else {
			statusAndDetails(Status.FAIL, string + " Element is Displayed and enabled");
		}
	}

	//////////// myClick \\\\\\\\\\

	/**
	 * The myClick() method is commonly used to click to the element
	 * 
	 * @param xpath       it is used to find element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 */
	public void click(WebElement webObj) {
		String elementName = webObj.getAccessibleName();
		if (webObj.isDisplayed() && webObj.isEnabled()) {

			statusAndDetails(Status.PASS, "Element is Displayed and enabled");
			try {
				webObj.click();
				statusAndDetails(Status.INFO, elementName + " element is clicked successfully");

			} catch (ElementClickInterceptedException e) {

				JavascriptExecutor js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].click()", webObj);
				statusAndDetails(Status.INFO, elementName + " element is clicked successfully");

				throw e;
			} catch (StaleElementReferenceException e) {

				webObj.click();
				statusAndDetails(Status.INFO, elementName + " element is clicked successfully");

			} catch (Exception e) {
				e.printStackTrace();
				statusAndDetails(Status.FAIL, elementName + " element is not clicked successfully");
				throw e;

			}
		} else {
			statusAndDetails(Status.PASS, "Element is not Displayed and enabled ");

		}
	}

	public void verifyTitle(String expTitle) {
		String actPageTitle = getPageTitle();
		if (actPageTitle.equalsIgnoreCase(expTitle)) {
			webUtil.statusAndDetails(Status.PASS, "Passed. Actual-" + actPageTitle + " && Expected-" + expTitle);
		} else {
			webUtil.statusAndDetails(Status.FAIL, "Failed. Actual-" + actPageTitle + " && Expected-" + expTitle);
		}
		Assert.assertEquals(actPageTitle, expTitle);
	}
	//////////// verifyString \\\\\\\\\\

	/**
	 * it is used to verify two String that is same or not.
	 * 
	 * @param actualString   it refers to the actual String.
	 * 
	 * @param expectedString it refers to the expected String.
	 */
	public String takeSnapshot(String testcaseName) {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File snapshotSourceFileObj = tss.getScreenshotAs(OutputType.FILE);
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy hh_mm_ss a");
		String timeStamp = df.format(new Date());
		File snapshotDestinationFileObj = new File("test-output\\" + testcaseName + timeStamp + ".png");
		try {
			Files.copy(snapshotSourceFileObj, snapshotDestinationFileObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return snapshotDestinationFileObj.getAbsolutePath();
	}

	public void verifText(String actualString, String expectedString, String message) {
		if (actualString.equalsIgnoreCase(expectedString)) {
			statusAndDetails(Status.PASS,
					"the actual :-" + actualString + " && expected :-" + expectedString + " both are same");
		} else {

			statusAndDetails(Status.FAIL,
					"the actual :-" + actualString + " && expected :-" + expectedString + " both are not same");
		}
		Assert.assertEquals(actualString, expectedString, message);
	}

	//////////// verifyInt \\\\\\\\\\

	/**
	 * it is used to verify two integer number that is same or not.
	 * 
	 * @param actInt it refers to the actual number.
	 * 
	 * @param expInt it refers to the expected number.
	 */
	public void verifyInt(int actInt, int expInt) {

		if (actInt == expInt) {
			statusAndDetails(Status.PASS,
					"the actual integer :-" + actInt + " and expected integer :-" + expInt + " both are same");
		} else {
			statusAndDetails(Status.FAIL,
					"the actual integer :-" + actInt + " and expected integer :-" + expInt + " both are not same");
		}
		Assert.assertEquals(actInt, expInt, "It is also verified by Assertion");
	}

	//////////// checkDisplayed \\\\\\\\\\
	/**
	 * The checkDisplayed() method is commonly used to check the element that is
	 * display or not
	 * 
	 * @param xpath       it is used to find element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 * 
	 * @return it returns boolean i.e true or false
	 * 
	 */

	//////////// checkEnabled \\\\\\\\\\
	/**
	 * The checkEnabled() method is commonly used to check the element that is
	 * enable or not
	 * 
	 * @param xpath       it is used to find element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 * 
	 * @return it returns boolean i.e true or false
	 * 
	 */

	//////////// selectByValueAttribute \\\\\\\\\\

	/**
	 * with the help of this method we can select the element by it's value
	 * attributes from drop down.
	 * 
	 * @param xpath       it is used to find element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 * 
	 * @param value       it is used to select by value attribute
	 */
	public void selectByValueAttribute(WebElement webObj, String value) {

		Select slct = new Select(webObj);

		if (webObj.isDisplayed() && webObj.isEnabled()) {

			statusAndDetails(Status.PASS, "Element is Displayed and enabled");
			try {
				slct.selectByValue(value);
				statusAndDetails(Status.INFO, "you have selected the element in dropDown by it's value :--" + value);
			} catch (ElementNotInteractableException eo) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].value='" + value + "'", webObj);
				statusAndDetails(Status.INFO, "you have selected the element in dropDown by it's value :--" + value);
			} catch (StaleElementReferenceException e) {

				slct.selectByValue(value);
				statusAndDetails(Status.INFO, "you have selected the element in dropDown by it's value :--" + value);
			} catch (NullPointerException e) {

				slct.selectByValue(value);
				statusAndDetails(Status.INFO, "you have selected the element in dropDown by it's value :--" + value);
			} catch (Exception e) {
				e.printStackTrace();
				statusAndDetails(Status.INFO, "you haven't selected the element in dropDown by it's value :--" + value);
				throw e;

			}
		} else {
			statusAndDetails(Status.FAIL, "Element is not Displayed and enabled ");
		}
	}

	//////////// selectByIndexNumber \\\\\\\\\\
	/**
	 * it is used to select that element with the help of it's index number from
	 * drop down the index number is starts 0 to number-1
	 * 
	 * @param xpath       it is used to find element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 * 
	 * @param indexNumber it refers to the index number of drop down
	 */
	public void selectByIndexNumber(WebElement webObj, int indexNumber) {

		Select slct = new Select(webObj);

		if (webObj.isDisplayed() && webObj.isEnabled()) {

			statusAndDetails(Status.PASS, "Element is Displayed and enabled");
			try {
				slct.selectByIndex(indexNumber);
				statusAndDetails(Status.INFO,
						"you have selected the element in dropDown by it's index number :--" + indexNumber);
			} catch (ElementNotInteractableException eo) {
				String script = "arguments[0].selectedIndex = " + indexNumber + "; "
						+ "arguments[0].dispatchEvent(new Event('change'));";
				((JavascriptExecutor) driver).executeScript(script, webObj);
				statusAndDetails(Status.INFO,
						"you have selected the element in dropDown by it's index number :--" + indexNumber);

			} catch (StaleElementReferenceException e) {

				slct.selectByIndex(indexNumber);
				statusAndDetails(Status.INFO,
						"you have selected the element in dropDown by it's index number :--" + indexNumber);

			} catch (NullPointerException e) {

				slct.selectByIndex(indexNumber);
				statusAndDetails(Status.INFO,
						"you have selected the element in dropDown by it's index number :--" + indexNumber);
			} catch (Exception e) {

				e.printStackTrace();
				statusAndDetails(Status.INFO,
						"you haven't selected the element in dropDown by it's index number :--" + indexNumber);
				throw e;

			}
		} else {
			statusAndDetails(Status.FAIL, "Element is not Displayed and enabled ");
		}
	}

	//////////// selectByVisibleString \\\\\\\\\\

	/**
	 * it is used to select that element with the help of inner text or that we are
	 * seeing the element in UI.
	 * 
	 * @param xpath         it is used to find element which we have to perform
	 *                      operation.
	 * 
	 * @param elementName   this shows in which element we are working and print a
	 *                      proper message in the console.
	 * 
	 * @param visibleString it refers to String as a text
	 */
	public void selectByVisibleString(WebElement webObj, String visibleString) {

		if (webObj.isDisplayed() && webObj.isEnabled()) {

			Select slct = new Select(webObj);
			statusAndDetails(Status.PASS, "Element is displayed and Enabled");
			try {
				slct.selectByVisibleText(visibleString);
				statusAndDetails(Status.INFO,
						"you have selected the element in dropDown by it's visible String :--" + visibleString);
			} catch (StaleElementReferenceException e) {

				slct.selectByVisibleText(visibleString);
				statusAndDetails(Status.INFO,
						"you have selected the element in dropDown by it's visible String :--" + visibleString);
			} catch (Exception e) {
				e.printStackTrace();
				statusAndDetails(Status.INFO,
						"you haven't selected the element in dropDown by it's visible String :--" + visibleString);
				throw e;
			}

		} else {
			statusAndDetails(Status.FAIL, "Element is not displayed and Enabled");

		}
	}

	public void verifyInnerText(WebElement we, String expectedText) {
		String actualText = we.getText();
		if (actualText.equalsIgnoreCase(expectedText)) {

			extTest.log(Status.PASS, "Passed. Actual-" + actualText + " && Expected-" + expectedText);
		} else {
			extTest.log(Status.FAIL, "Passed. Actual-" + actualText + " && Expected-" + expectedText);
		}

		// SoftAssert HardAssert
		/// Verify Assert

		// try {
		// Assert.assertEquals(actualText, expectedText); // fail
		// }catch(Throwable e) {
		//
		// }

	}

	//////////// scrollingToElement \\\\\\\\\

	/**
	 * this method is used to scroll to any particular element.
	 * 
	 * @param xpath       it is used to find that element which we have to perform
	 *                    operation.
	 * 
	 * @param elementName this shows in which element we are working and print a
	 *                    proper message in the console.
	 */
	public void scrollingToElement(WebElement webObj) {
		Actions act = new Actions(driver);
		if (webObj.isDisplayed() && webObj.isEnabled()) {
			statusAndDetails(Status.PASS, "Element is displayed and Enabled");
			try {
				act.scrollToElement(webObj).build().perform();
				statusAndDetails(Status.PASS, "scrolling to the element is performed successfully by Actions method");
			} catch (ElementNotInteractableException e) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].scrollIntoView(true);", webObj);
				statusAndDetails(Status.PASS, "scrolling to the element is performed successfully by Actions method");
			} catch (StaleElementReferenceException e) {

				act.scrollToElement(webObj).build().perform();
				statusAndDetails(Status.PASS, "scrolling to the element is performed successfully by Actions method");
			} catch (Exception e) {
				e.printStackTrace();
				statusAndDetails(Status.PASS,
						"scrolling to the element is not performed successfully by Actions method");
				throw e;
			}
		} else {
			statusAndDetails(Status.PASS, "Element is not displayed and Enabled");

		}
	}

	//////////// mouseDragDrop \\\\\\\\\

	/**
	 * this method is especially designed to drag and drop operation from one
	 * webElement to another webElement
	 * 
	 * @param dragXpath       this is the source element xpath which we have to drag
	 * @param dragElementName this is the drag element name which is draged
	 * 
	 * @param dropXpath       this is the target element xpath which we have to drop
	 * 
	 * @param dropElementName this is the drop element name where we have to drop.
	 */
	public void mouseDragDrop(WebElement dragWeb, WebElement dropWeb) {
		String dragElementName = dragWeb.getAccessibleName();
		String dropElementName = dropWeb.getAccessibleName();
		Actions ac = new Actions(driver);
		if (dragWeb.isDisplayed() && dropWeb.isEnabled() && dropWeb.isDisplayed() && dropWeb.isEnabled()) {
			statusAndDetails(Status.PASS,
					"Both element " + dragElementName + " and " + dropElementName + "is disable and enable");
			try {
				ac.dragAndDrop(dragWeb, dropWeb).build().perform();
				statusAndDetails(Status.PASS, "Drag operation " + dragElementName + " is  droped to the "
						+ dropElementName + " successfully");
			} catch (StaleElementReferenceException e) {

				ac.dragAndDrop(dragWeb, dropWeb).build().perform();
				statusAndDetails(Status.PASS, "Drag operation " + dragElementName + " is  droped to the "
						+ dropElementName + " successfully");
			} catch (ElementNotInteractableException e) {

				String xto = Integer.toString(dropWeb.getLocation().x);
				String yto = Integer.toString(dropWeb.getLocation().y);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("function simulate(f,c,d,e){var b,a=null;"
						+ "for(b in eventMatchers)if(eventMatchers[b].test(c)){a=b;break}if(!a)"
						+ "return!1;document.createEvent?(b=document.createEvent(a),a==\"HTMLEvents\""
						+ "?b.initEvent(c,!0,!0):b.initMouseEvent(c,!0,!0,document.defaultView,0,d,e,"
						+ "d,e,!1,!1,!1,!1,0,null),f.dispatchEvent(b)):(a=document.createEventObject(),"
						+ "a.detail=0,a.screenX=d,a.screenY=e,a.clientX=d,a.clientY=e,a.ctrlKey=!1,a."
						+ "altKey=!1,a.shiftKey=!1,a.metaKey=!1,a.button=1,f.fireEvent(\"on\"+c,a));"
						+ "return!0} var eventMatchers={HTMLEvents:/^(?:load|unload|abort|error|select|"
						+ "change|submit|reset|focus|blur|resize|scroll)$/,MouseEvents:/^(?:click|dblclick"
						+ "|mouse(?:down|up|over|move|out))$/}; "
						+ "simulate(arguments[0],\"mousedown\",0,0); simulate(arguments[0],\"mousemove\""
						+ ",arguments[1],arguments[2]); simulate(arguments[0],\"mouseup\",arguments[1],arguments[2]); ",
						dragWeb, xto, yto);
				statusAndDetails(Status.PASS, "Drag operation " + dragElementName + " is not droped to the "
						+ dropElementName + " successfully");
			} catch (Exception e) {
				e.printStackTrace();
				statusAndDetails(Status.PASS, "Drag operation " + dragElementName + " is not droped to the "
						+ dropElementName + " successfully");
				throw e;
			}

		} else {
			statusAndDetails(Status.PASS,
					"Both element " + dragElementName + " and " + dropElementName + "is not disable and enable");
		}
	}

	//////////// mouseMoveToElement \\\\\\\\\

	/**
	 * with the help of mouseMoveToElement method we can mouse hover of any element
	 * it means that we can move to the mouse in any given element
	 * 
	 * @param xpath       we pass xpath to the findElement method to find the
	 *                    element.
	 * @param elementName we needs to give the name of any element to print a
	 *                    suitable message .
	 */
	public void mouseMoveToElement(WebElement webMoveToElement) {
		Actions ac = new Actions(driver);
		if (webMoveToElement.isDisplayed() && webMoveToElement.isEnabled()) {
			statusAndDetails(Status.PASS, "Element is displayed and Enabled");
			try {
				ac.moveToElement(webMoveToElement).build().perform();
				statusAndDetails(Status.PASS, "Move to Element is performed successfully");

			} catch (StaleElementReferenceException e) {

				ac.release(webMoveToElement).build().perform();
				statusAndDetails(Status.PASS, "Move to Element is performed successfully");
			} catch (ElementNotInteractableException e) {
				// Use JavascriptExecutor to execute JavaScript code for moving to the element
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				String script = "var element = arguments[0];" + "var rect = element.getBoundingClientRect();"
						+ "var centerX = rect.left + rect.width / 2;" + "var centerY = rect.top + rect.height / 2;"
						+ "var mouseMoveEvent = new MouseEvent('mousemove', {" + "  bubbles: true,"
						+ "  cancelable: true," + "  view: window," + "  clientX: centerX," + "  clientY: centerY"
						+ "});" + "element.dispatchEvent(mouseMoveEvent);";
				jsExecutor.executeScript(script, webMoveToElement);

				statusAndDetails(Status.PASS, "Element is released successfully");
			} catch (Exception e) {
				e.printStackTrace();
				statusAndDetails(Status.INFO, "Move to Element is not performed successfully");
			}

		} else {
			statusAndDetails(Status.FAIL, "Element is not displayed and Enabled");

		}

	}

	public String getRandomName(int i) {
		RandomString rs = new RandomString();
		String str = rs.nextString();
		return str;
	}

	public void customDropDown(List<WebElement> list, String expected) {

		for (int i = 0; i < list.size(); i++) {
			String Text = list.get(i).getText();
			if (Text.contains(expected)) {
				list.get(i).click();
			}

		}

	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

	public void jsInputValueMethod(WebElement we, String value, String elementName) {
		try {
			// WebElement we = driver.findElement(locator);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].value='" + value + "';", we);

			extTest.log(Status.INFO,
					"Successfully enter value in the [" + elementName + " ] text Box  through java script ");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Value not entered  in the [" + elementName + " ] text Box  through java script ");
			extTest.addScreenCaptureFromPath(screenShot(elementName));
		}
	}

	private String screenShot(String elementName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void clear(WebElement bathtubCB) {
		// TODO Auto-generated method stub

	}

	public String getText(WebElement we) {
		String elementName = we.getAccessibleName();
		String innertext = null;
		try {
			innertext = we.getText();
			extTest.log(Status.INFO, "Successfully Retrieve inner Text - " + elementName);

		} catch (StaleElementReferenceException e) {
			innertext = we.getText();
			extTest.log(Status.INFO,
					"Successfully Value enterd in the  - [ " + elementName + " ] After handaling Stale Exception ");

		} catch (Exception e) {
			extTest.log(Status.FAIL, "Due To Exception Inner text not found");
			extTest.addScreenCaptureFromPath(screenShot(elementName));
			e.printStackTrace();

		}
		return innertext;
	}

	public void threadWait(int sleepMileSec) {
		try {
			Thread.sleep(sleepMileSec);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void verifyTextContains(String actualValue, String expectedTextContains) {
		if (actualValue.contains(expectedTextContains)) {
			extTest.log(Status.PASS, actualValue + " is contains value :" + expectedTextContains);
		} else {
			extTest.log(Status.FAIL, actualValue + " is not contains value :" + expectedTextContains);
		}
	}

	public int getTableRowCount(String tableXpath) {

		List<WebElement> weRowsList = driver.findElements(By.xpath(tableXpath + "//tr"));
		int rowCount = weRowsList.size() - 1;
		return rowCount;
	}

	public int getTableColumnHeaderCount(String tableXpath, String elementName) {
		List<WebElement> weListColumns = driver.findElements(By.xpath(tableXpath + "//tr[1]//td"));
		int columnCount = weListColumns.size();
		return columnCount;
	}

	/* in this method we want all the column header names in a list<String> */
	public List<String> getTableHeaderColumnNamesList(String tableXpath, String elementName) {
		List<WebElement> weListColumns = driver.findElements(By.xpath(tableXpath + "/thead/tr/th"));
		List<String> listColumnNames = new ArrayList<String>();
		int columnCount = weListColumns.size();
		for (int i = 0; i <= columnCount - 1; i++) {
			WebElement weColumnHeader = weListColumns.get(i);
			String columnName = weColumnHeader.getText();
			listColumnNames.add(columnName);
		}
		return listColumnNames;
	}

	/* this method returns column number on the basis of column name */
	public int getColumnNumberByColumnName(String tableXpath, String columnName) {
		int columnNumber = -1;
		List<WebElement> listColumnNames = driver.findElements(By.xpath(tableXpath + "/thead/tr/th"));
		int columnCount = listColumnNames.size();
		for (int i = 0; i <= columnCount - 1; i++) {
			WebElement weTableColumn = listColumnNames.get(i);
			String tablColumnName = weTableColumn.getText();
			if (tablColumnName.equalsIgnoreCase(columnName) == true) {
				columnNumber = i;
				break;
			}
		}

		return columnNumber;

	}

	public String getColumnDataByColumnNumber(String tableXpath, int columnNo) {
		String columnData = null;
		List<WebElement> listColumnData = driver.findElements(By.xpath(tableXpath + "/tbody/tr/td[" + columnNo + "]"));
		if (listColumnData.size() > 0) {
			columnData = listColumnData.get(0).getText();
		}
		return columnData;
	}

	/* this method returns row data in list on the basis of row number */
	public List<String> getRowDataListByRowNumber(String tableXpath, int rowNumber) {
		List<WebElement> weListRowData = driver
				.findElements(By.xpath(tableXpath + "//tr[" + (rowNumber + 1) + "]//td"));
		List<String> rowDataList = new ArrayList<String>();
		for (int i = 0; i <= weListRowData.size() - 1; i++) {
			WebElement weRowData = weListRowData.get(i);
			String data = weRowData.getText();
			rowDataList.add(data);
		}
		return rowDataList;
	}

	public List<String> getColumnDataListByColumnNumber(String tableXpath, int columnNumber) {
		List<WebElement> columnsList = driver
				.findElements(By.xpath(tableXpath + "//tr//td[" + (columnNumber + 1) + "]"));
		List<String> columnNameList = new ArrayList<>();
		for (int i = 0; i <= columnsList.size() - 1; i++) {
			String columnName = columnsList.get(i).getText();
			columnNameList.add(columnName);
		}
		return columnNameList;
	}

	public List<String> getColumnDataListByColumnName(String tableXpath, String columnName) {
		int columnNumber = -1;
		List<String> columnNameList;
		List<WebElement> listColumnNames = driver.findElements(By.xpath(tableXpath + "//tr[1]//td"));
		int columnCount = listColumnNames.size();
		for (int i = 0; i <= columnCount - 1; i++) {
			WebElement weTableColumn = listColumnNames.get(i);
			String tablColumnName = weTableColumn.getText();
			if (tablColumnName.equalsIgnoreCase(columnName) == true) {
				columnNumber = i;
				break;
			}
		}

		List<WebElement> columnsList = driver
				.findElements(By.xpath(tableXpath + "//tr//td[" + (columnNumber + 1) + "]"));
		columnNameList = new ArrayList<>();
		for (int i = 0; i <= columnsList.size() - 1; i++) {
			String tableColumnName = columnsList.get(i).getText();
			columnNameList.add(tableColumnName);
		}
		columnNumber = getColumnNumberByColumnName(tableXpath, columnName);
		columnNameList = getColumnDataListByColumnNumber(tableXpath, columnNumber);

		return columnNameList;
	}
}
