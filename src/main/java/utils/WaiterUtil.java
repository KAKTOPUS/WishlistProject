package utils;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaiterUtil {

    private WebDriverWait wait = null;
    private CompareStringsUtil compare = new CompareStringsUtil();

    @Step("Ждём, пока элемент будет видим")
    public boolean waitForElementShouldBeVisible(WebDriver driver, WebElement element) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated((By) element));

           return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Ждём загрузки страницы и элемента")
    public void waitForPageAndElement(WebDriver driver, By locator, long timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(d -> {

                    boolean isPageLoaded = ((JavascriptExecutor) d)
                            .executeScript("return document.readyState")
                            .equals("complete");
                    try {
                        return isPageLoaded &&
                                !d.findElements(locator).isEmpty() &&
                                d.findElement(locator).isDisplayed();
                    } catch (Exception e) {
                        return false;
                    }
                });
    }

}
