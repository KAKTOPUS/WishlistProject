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

    @Step("Ждём, пока элемент будет не видим")
    public boolean waitForElementShouldBeInvisible(WebDriver driver, WebElement element) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOf(element));

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Ждём загрузки страницы и элемента")
    public void waitForPageAndElement(WebDriver driver, String selector, long timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(d -> {
                    // 1. Проверяем загрузку страницы
                    boolean isPageLoaded = ((JavascriptExecutor) d)
                            .executeScript("return document.readyState")
                            .equals("complete");

                    // 2. Определяем тип селектора и создаем соответствующий By
                    By byLocator = determineLocatorType(selector);

                    // 3. Проверяем видимость элемента
                    try {
                        return isPageLoaded &&
                                !d.findElements(byLocator).isEmpty() &&
                                d.findElement(byLocator).isDisplayed();
                    } catch (Exception e) {
                        return false;
                    }
                });
    }

    private By determineLocatorType(String selector) {
        // Удаляем лишние пробелы в начале и конце
        String trimmedSelector = selector.trim();

        // Проверяем признаки XPath
        if (trimmedSelector.startsWith("//")) {
            return By.xpath(trimmedSelector);
        }

        // По умолчанию считаем CSS-селектором
        return By.cssSelector(trimmedSelector);
    }

}
