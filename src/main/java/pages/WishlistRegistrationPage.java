package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishlistRegistrationPage extends AbsBasePage {

    public WishlistRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получаем заголовок страницы")
    public String getTitleText() {
        String strName = "//h2[contains(text(), 'Регистрация')]";
        waiter.waitForPageAndElement(driver, strName, 10);
        WebElement titleElement = driver.findElement(By.xpath(strName));
        String titleText = titleElement.getText();

        return titleText;
    }

    @Step("Вводим и получаем имя")
    public String enterAndGetUserName(String name) {
        String cssSelector = "input[type='text']";
        waiter.waitForPageAndElement(driver, cssSelector, 10);
        WebElement userNameElement = driver.findElement(By.cssSelector(cssSelector));

        userNameElement.sendKeys(name);

        return name;
    }

    @Step("Вводим email")
    public void enterEmail(String email) {
        String cssSelector = "input[type='email']";
        waiter.waitForPageAndElement(driver, cssSelector, 10);
        WebElement userEmailElement = driver.findElement(By.cssSelector(cssSelector));

        userEmailElement.sendKeys(email);
    }

    @Step("Вводим и получаем пароль")
    public String enterAndGetPassword(String password) {
        String cssSelector = "input[type='password']";
        waiter.waitForPageAndElement(driver, cssSelector, 10);
        WebElement userPasswordElement = driver.findElement(By.cssSelector("input[type='password']"));

        userPasswordElement.sendKeys(password);

        return password;
    }

    @Step("Нажимаем на кнопку <Зарегестрироваться>")
    public void clickOnRegistrationButton() {
        String cssSelector = "button.btn";
        waiter.waitForPageAndElement(driver, cssSelector, 10);
        WebElement registrationButtonElement = driver.findElement(By.cssSelector(cssSelector));

        registrationButtonElement.click();
    }

    @Step("Получаем текст ошибки")
    public String getAlertMessage() {
        String xPathSelector = "//div[contains(text(),'Не удалось зарегистрировать пользователя')]";
        waiter.waitForPageAndElement(driver, xPathSelector, 10);
        WebElement alertElement = driver.findElement(By.xpath(xPathSelector));
        String alertText = alertElement.getText();

        return alertText;
    }

}
