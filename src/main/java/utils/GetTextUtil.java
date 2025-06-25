package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetTextUtil {

    public String getTextFromCardAndModalWindow(WebDriver driver, WebElement element) {
        String text = (String) ((JavascriptExecutor)driver)
                .executeScript("return arguments[0].firstChild.textContent.trim()", element);

        return text;
    }
}
