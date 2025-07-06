package utils;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class WaiterUtil {

    @Step("Ждём загрузки страницы и элемента")
    public WebElement waitForPageAndElement(WebDriver driver, By locator, long timeoutInSeconds) {
       return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(d -> {
                    boolean isPageLoaded = ((JavascriptExecutor) d)
                            .executeScript("return document.readyState")
                            .equals("complete");

                    if (!isPageLoaded) {
                        return null;
                    }

                    List<WebElement> elements = d.findElements(locator);
                    if (elements.isEmpty()) {
                        return null;
                    }

                    WebElement element = elements.get(0);
                    return element.isDisplayed() ? element : null;
                });

    }

}
