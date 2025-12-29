package project_orangehrm.Utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class AllureAttachment {
    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        AllureAttachment.driver = driver;
    }

    public static void addScreenshot(String name) {
        if (driver != null) {

            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.getLifecycle().addAttachment(
                        name,
                        "image/png",
                        ".png",
                        new ByteArrayInputStream(screenshot)
                );
            } catch (Exception e) {
                System.err.println("Screenshot capture failed: " + e.getMessage());
                Allure.addAttachment("Screenshot Error", "Failed to capture screenshot: " + e.getMessage());
            }

            try {
                addPageSource(driver);
            } catch (Exception e) {
                System.err.println("Page source capture failed: " + e.getMessage());
                Allure.addAttachment("Page Source Error", "Failed to capture page source: " + e.getMessage());
            }
        }
    }

    private static void addPageSource(WebDriver driver) {
        try {
            String pageSource = driver.getPageSource();
            Allure.getLifecycle().addAttachment(
                    "Page Source",
                    "text/html",
                    ".html",
                    new ByteArrayInputStream(pageSource.getBytes(StandardCharsets.UTF_8))
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to get page source", e);
        }
    }
}
