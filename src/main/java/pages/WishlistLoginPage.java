package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class WishlistLoginPage extends AbsBasePage {
    private final By errorTextLocator = By.cssSelector("div[role='alert']");

    @Step("Вводим имя")
    public void enterUserName(String name) {
        wait.waitForPageAndElement(driver, enterNameLocator, 10).sendKeys(name);
    }

    @Step("Вводим пароль")
    public void  enterPassword(String password) {
        wait.waitForPageAndElement(driver, enterPasswordLocator, 10).sendKeys(password);
    }

    @Step("Нажимаем на кнопку <Подтвердить>")
    public void clickSubmitButton() {
        wait.waitForPageAndElement(driver, submitButtonLocator,10).click();
    }

    @Step("Получаем текст ошибки")
    public String getErrorText() {
        return wait.waitForPageAndElement(driver, errorTextLocator, 10).getText();
    }

}
