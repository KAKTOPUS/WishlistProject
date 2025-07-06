package components;

import common.AbsCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageComponents extends AbsCommon {

    private final By navBarLocator = By.cssSelector("nav[class='navbar navbar-expand-lg navbar-light bg-light']");
    private final By navLoginLocator = By.cssSelector("a[href='/login']");
    private final By navRegisterLocator = By.cssSelector("a[href='/register']");
    private final By navWishlistsLocator = By.cssSelector("a[href='/wishlists']");
    private final By navUsersLocator = By.cssSelector("a[href='/users']");
    private final By navExitLocator = By.cssSelector("a[href='#']");

    public WebElement navBar() {
        return wait.waitForPageAndElement(driver, navBarLocator, 10);
    }

    @Step("Нажатие на <Войти>")
    public void clickOnLogin() {
        wait.waitForPageAndElement(driver, navLoginLocator, 10).click();
    }

    @Step("Нажатие на <Регистрация>")
    public void clickOnRegister() {
        wait.waitForPageAndElement(driver, navRegisterLocator, 10).click();
    }

    @Step("Нажатие на <списки>")
    public void clickOnMyWishlists() {
        wait.waitForPageAndElement(driver, navWishlistsLocator, 10).click();
    }

    @Step("Нажатие на <Пользователи>")
    public void clickOnUsers() {
        wait.waitForPageAndElement(driver, navUsersLocator, 10).click();
    }

    @Step("Нажатие на <Выйти>")
    public void clickOnExit() {
        wait.waitForPageAndElement(driver, navExitLocator, 10).click();
    }

}
