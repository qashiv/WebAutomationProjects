package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    private static AndroidDriver driver;

    public static AndroidDriver initializeDriver() {

        try {

            UiAutomator2Options options =
                    new UiAutomator2Options();

            options.setPlatformName("Android");

            options.setAutomationName("UiAutomator2");

            options.setDeviceName(
                    "10BF3E012R000ZD"
            );

            options.setAppPackage(
                    "com.vivo.calculator"
            );

            options.setAppActivity(
                    "com.android.bbkcalculator.Calculator"
            );

            options.setNoReset(false);

            driver = new AndroidDriver(
                    new URL(
                            "http://127.0.0.1:4723"
                    ),
                    options
            );

            driver.manage()
                    .timeouts()
                    .implicitlyWait(
                            Duration.ofSeconds(5)
                    );

            return driver;

        } catch (MalformedURLException e) {

            throw new RuntimeException(
                    "Invalid Appium server URL",
                    e
            );
        }
    }

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}