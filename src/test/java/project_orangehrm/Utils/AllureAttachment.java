package project_orangehrm.Utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
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

    @Attachment(value = "{name}", type = "image/png")
    public static byte[] addScreenshot(String name) {
        if (driver != null) {
            try {
                return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            } catch (Exception e) {
                System.err.println("Screenshot capture failed: " + e.getMessage());
                return attachErrorMessage("Screenshot Error: " + e.getMessage());
            }
        }
        return attachErrorMessage("Driver is null - cannot capture screenshot");
    }

    @Attachment(value = "Screenshot (Alternative Method)", type = "image/png")
    public static byte[] addScreenshotAlternative(String name) {
        if (driver != null) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.getLifecycle().addAttachment(
                        name,
                        "image/png",
                        ".png",
                        new ByteArrayInputStream(screenshot)
                );
                return screenshot;
            } catch (Exception e) {
                System.err.println("Screenshot capture failed: " + e.getMessage());
                try {
                    addPageSource(driver);
                } catch (Exception ex) {
                    System.err.println("Page source capture also failed: " + ex.getMessage());
                }
                return attachErrorMessage("Screenshot failed");
            }
        }
        return attachErrorMessage("Driver is null");
    }

    @Attachment(value = "Page Source", type = "text/html")
    private static byte[] addPageSource(WebDriver driver) {
        try {
            String pageSource = driver.getPageSource();
            return pageSource.getBytes(StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get page source", e);
        }
    }

    @Attachment(value = "Error Log", type = "text/plain")
    private static byte[] attachErrorMessage(String message) {
        return message.getBytes(StandardCharsets.UTF_8);
    }
}
