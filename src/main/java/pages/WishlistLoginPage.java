package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishlistLoginPage extends AbsBasePage {

    public WishlistLoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получаем заголовок страницы")
    public String getTitleName() {
        String xPathSelector = "//h2[contains(text(), 'Вход в систему')]";
        waiter.waitForPageAndElement(driver, xPathSelector, 10);
        WebElement titleElement = driver.findElement(By.xpath(xPathSelector));
        String titleText = titleElement.getText();

        return titleText;
    }

    @Step("Вводим имя")
    public void enterUserName(String name) {
        WebElement userNameElement = driver.findElement(By.cssSelector("input[type='text']"));
        waiter.waitForElementShouldBeVisible(driver, userNameElement);
        userNameElement.sendKeys(name);
    }

    @Step("Вводим пароль")
    public void  enterPassword(String password) {
        WebElement userPasswordElement = driver.findElement(By.cssSelector("input[type='password']"));
        waiter.waitForElementShouldBeVisible(driver, userPasswordElement);
        userPasswordElement.sendKeys(password);
    }

    @Step("Нажимаем на кнопку <Подтвердить>")
    public void clickSubmitButton() {
        WebElement submitButtonElement = driver.findElement(By.cssSelector("button[type='submit']"));
        waiter.waitForElementShouldBeVisible(driver, submitButtonElement);

        submitButtonElement.click();
    }

    @Step("Получаем текст предупреждения")
    public String getTextAlert() {
        String cssSelector = "div[role='alert']";
        waiter.waitForPageAndElement(driver, cssSelector, 10);
        WebElement alertElement = driver.findElement(By.cssSelector(cssSelector));
        String alertText = alertElement.getText();

        return alertText;
    }




}
