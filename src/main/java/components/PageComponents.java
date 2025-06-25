package components;

import common.AbsCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageComponents extends AbsCommon {
    public PageComponents(WebDriver driver) {
        super(driver);
    }

    @Step("Нажатие на <Войти>")
    public void clickOnLogin() {
        String css = "a[href='/login']";
        waiter.waitForPageAndElement(driver, css, 10);
        WebElement loginElement = driver.findElement(By.cssSelector(css));

        loginElement.click();
    }

    @Step("Нажатие на <Регистрация>")
    public void clickOnRegister() {
        String css = "a[href='/register']";
        waiter.waitForPageAndElement(driver, css, 10);
        WebElement registerElement = driver.findElement(By.cssSelector(css));

        registerElement.click();
    }

    @Step("Нажатие на <списки>")
    public void clickOnMyWishlists() {
        String css = "a[href='/wishlists']";
        waiter.waitForPageAndElement(driver, css, 10);
        WebElement myWishlistsElement = driver.findElement(By.cssSelector(css));

        myWishlistsElement.click();
    }

    @Step("Нажатие на <Пользователи>")
    public void clickOnUsers() {
        String css = "a[href='/users']";
        waiter.waitForPageAndElement(driver, css, 10);
        WebElement usersElement = driver.findElement(By.cssSelector(css));

        usersElement.click();
    }

    @Step("Нажатие на <Выйти>")
    public void clickOnExit() {
        String css = "a[href='#']";
        waiter.waitForPageAndElement(driver, css, 10);
        WebElement exitElement = driver.findElement(By.cssSelector(css));

        exitElement.click();
    }

    @Step("Нажатие на кнопку <nav.bar>")
    public void clickNavigationBar() {
        String css = "button[aria-controls='basic-navbar-nav']";
        waiter.waitForPageAndElement(driver, css, 10);
        WebElement navBarElement = driver.findElement(By.cssSelector(css));

        navBarElement.click();
    }

}
