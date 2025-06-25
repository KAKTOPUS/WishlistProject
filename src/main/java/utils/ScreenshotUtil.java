package utils;

import exceptions.DriverNotSupportedScreenshotException;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.ByteArrayInputStream;

public class ScreenshotUtil {

    @Step("Делаем скриншот элемента")
    public void takeElementScreenshot(WebDriver driver, WebElement element, String name) {




        if (driver instanceof TakesScreenshot) {
            byte[] screenshot = element.getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment(
                    name,
                    "image/png",
                    new ByteArrayInputStream(screenshot),
                    "png"
            );

        } else  {
            throw new DriverNotSupportedScreenshotException();
        }
    }

    @Step("Делам скриншот всей страницы")
    public void takeFullscreenScreenshot(WebDriver driver, String name) {
        if (driver instanceof TakesScreenshot) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment(
                    name,
                    "image/png",
                    new ByteArrayInputStream(screenshot),
                    "png"
            );

        } else {
            throw  new DriverNotSupportedScreenshotException();
        }
    }
}
