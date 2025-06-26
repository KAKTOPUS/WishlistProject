package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WishlistRegistrationPage extends AbsBasePage {


    @Step("Получаем заголовок страницы")
    public String getTitleText() {
        By locator = By.xpath("//h2[contains(text(), 'Регистрация')]");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement titleElement = driver.findElement(locator);
        String titleText = titleElement.getText();

        return titleText;
    }

    @Step("Вводим и получаем имя")
    public String enterAndGetUserName(String name) {
        By locator = By.cssSelector("input[type='text']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement userNameElement = driver.findElement(locator);
        userNameElement.sendKeys(name);

        return name;
    }

    @Step("Вводим email")
    public void enterEmail(String email) {
        By locator = By.cssSelector("input[type='email']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement userEmailElement = driver.findElement(locator);

        userEmailElement.sendKeys(email);
    }

    @Step("Вводим и получаем пароль")
    public String enterAndGetPassword(String password) {
        By locator = By.cssSelector("input[type='password']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement userPasswordElement = driver.findElement(locator);
        userPasswordElement.sendKeys(password);

        return password;
    }

    @Step("Нажимаем на кнопку <Зарегестрироваться>")
    public void clickOnRegistrationButton() {
        By locator = By.cssSelector("button.btn");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement registrationButtonElement = driver.findElement(locator);

        registrationButtonElement.click();
    }

    @Step("Получаем текст ошибки")
    public String getErrorMessage() {
        By locator = By.xpath("//div[contains(text(),'Не удалось зарегистрировать пользователя')]");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement errorElement = driver.findElement(locator);
        String errorText = errorElement.getText();

        return errorText;
    }

}
