package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import pages.CalculatorPage;

public class BaseTest {

    protected AndroidDriver driver;

    protected CalculatorPage calculator;


    @BeforeMethod
    public void setUp() {

        driver =
                DriverFactory.initializeDriver();

        calculator =
                new CalculatorPage(driver);
    }


    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}