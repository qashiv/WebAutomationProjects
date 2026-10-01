package utils;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void capture(
            AndroidDriver driver,
            String testName) {

        try {

            File source =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(
                                    OutputType.FILE
                            );

            String timestamp =
                    new SimpleDateFormat(
                            "yyyyMMdd_HHmmss"
                    ).format(
                            new Date()
                    );

            File directory =
                    new File(
                            "test-output/screenshots"
                    );

            if (!directory.exists()) {
                directory.mkdirs();
            }

            File destination =
                    new File(
                            directory,
                            testName
                                    + "_"
                                    + timestamp
                                    + ".png"
                    );

            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println(
                    "Screenshot saved: "
                            + destination
                            .getAbsolutePath()
            );

        } catch (Exception e) {

            System.err.println(
                    "Unable to save screenshot: "
                            + e.getMessage()
            );
        }
    }
}