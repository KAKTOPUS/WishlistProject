package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WishlistLoginPage extends AbsBasePage {


    @Step("Получаем заголовок страницы")
    public String getTitleName() {
        By locator = By.xpath("//h2[contains(text(), 'Вход в систему')]");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement titleElement = driver.findElement(locator);
        String titleText = titleElement.getText();

        return titleText;
    }

    @Step("Вводим имя")
    public void enterUserName(String name) {
        By locator = By.cssSelector("input[type='text']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement userNameElement = driver.findElement(locator);

        userNameElement.sendKeys(name);
    }

    @Step("Вводим пароль")
    public void  enterPassword(String password) {
        By locator = By.cssSelector("input[type='password']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement userPasswordElement = driver.findElement(locator);

        userPasswordElement.sendKeys(password);
    }

    @Step("Нажимаем на кнопку <Подтвердить>")
    public void clickSubmitButton() {
        By locator = By.cssSelector("button[type='submit']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement submitButtonElement = driver.findElement(locator);

        submitButtonElement.click();
    }

    @Step("Получаем текст ошибки")
    public String getErrorText() {
        By locator = By.cssSelector("div[role='alert']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement errorElement = driver.findElement(locator);
        String errorText = errorElement.getText();

        return errorText;
    }

}
