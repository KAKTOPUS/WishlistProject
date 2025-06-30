package components;

import common.AbsCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageComponents extends AbsCommon {

    public WebElement navBar() {
        By locator = By.cssSelector("nav[class='navbar navbar-expand-lg navbar-light bg-light']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement navBarElement = driver.findElement(locator);

        return navBarElement;
    }

    @Step("Нажатие на <Войти>")
    public void clickOnLogin() {
        By locator = By.cssSelector("a[href='/login']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement loginElement = driver.findElement(locator);

        loginElement.click();
    }

    @Step("Нажатие на <Регистрация>")
    public void clickOnRegister() {
        By locator = By.cssSelector("a[href='/register']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement registerElement = driver.findElement(locator);

        registerElement.click();
    }

    @Step("Нажатие на <списки>")
    public void clickOnMyWishlists() {
        By locator = By.cssSelector("a[href='/wishlists']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement myWishlistsElement = driver.findElement(locator);

        myWishlistsElement.click();
    }

    @Step("Нажатие на <Пользователи>")
    public void clickOnUsers() {
        By locator = By.cssSelector("a[href='/users']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement usersElement = driver.findElement(locator);

        usersElement.click();
    }

    @Step("Нажатие на <Выйти>")
    public void clickOnExit() {
        By locator = By.cssSelector("a[href='#']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement exitElement = driver.findElement(locator);

        exitElement.click();
    }

}
