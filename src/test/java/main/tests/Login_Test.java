package main.tests;

import org.junit.jupiter.api.Test;
import main.sut.AbsBaseSut;


public class Login_Test extends AbsBaseSut {

    @Test
    public void positiveLoginTest() {
        wishlistLoginPage.open("login");
        wishlistLoginPage.enterUserName(data.getLoginFromProperties());
        wishlistLoginPage.enterPassword(data.getPasswordFromProperties());
        wishlistLoginPage.clickSubmitButton();

        String titleWishlist = "Мои списки желаний";
        compare.compareStr(wishlistListsPage.getTitleName(), titleWishlist);
        screenshot.takeFullscreenScreenshot(driver, "SuccessLoginScreenshot");

        components.clickOnExit();

        String titleLogin = "Вход в систему";
        compare.compareStr(wishlistLoginPage.getTitleName(), titleLogin);
        screenshot.takeFullscreenScreenshot(driver, "Registration");
    }

    @Test
    public void negativeLoginTest() {
        wishlistLoginPage.open("login");
        wishlistLoginPage.enterUserName(data.getLoginFromProperties());
        wishlistLoginPage.enterPassword(testDataGenerator.getPassword());
        wishlistLoginPage.clickSubmitButton();

        String errorText = "Неверное имя пользователя или пароль";
        compare.compareStr(wishlistLoginPage.getTextAlert(), errorText);

        screenshot.takeFullscreenScreenshot(driver, "WrongLoginAlertScreenshot");
    }
}
