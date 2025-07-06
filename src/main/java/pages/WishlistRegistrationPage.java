package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class WishlistRegistrationPage extends AbsBasePage {

    private final By enterEmailLocator = By.cssSelector("input[type='email']");
    private final By registrationButtonLocator = By.cssSelector("button.btn");
    private final By errorTextLocator = By.xpath("//div[contains(text(),'Не удалось зарегистрировать пользователя')]");

    @Step("Вводим и получаем имя")
    public String enterAndGetUserName(String name) {
        wait.waitForPageAndElement(driver, enterNameLocator, 10).sendKeys(name);
        return name;
    }

    @Step("Вводим email")
    public void enterEmail(String email) {
        wait.waitForPageAndElement(driver, enterEmailLocator, 10).sendKeys(email);
    }

    @Step("Вводим и получаем пароль")
    public String enterAndGetPassword(String password) {
        wait.waitForPageAndElement(driver, enterPasswordLocator, 10).sendKeys(password);
        return password;
    }

    @Step("Нажимаем на кнопку <Зарегестрироваться>")
    public void clickOnRegistrationButton() {
        wait.waitForPageAndElement(driver, registrationButtonLocator, 10).click();
    }

    @Step("Получаем текст ошибки")
    public String getErrorMessage() {
        return wait.waitForPageAndElement(driver, errorTextLocator, 10).getText();
    }

}
