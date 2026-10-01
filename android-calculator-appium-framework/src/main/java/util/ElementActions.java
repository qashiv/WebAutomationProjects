package util;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public final class ElementActions {
    private ElementActions() {}

    public static WebElement click(WebElement element) {
        element.click();
        return element;
    }

    public static void tap(AndroidDriver driver, WebElement element) {
        element.click();
    }
}
