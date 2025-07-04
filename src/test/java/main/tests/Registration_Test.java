package main.tests;

import main.sut.AbsBaseSut;
import org.junit.jupiter.api.Test;

public class Registration_Test extends AbsBaseSut {

    @Test
    public void positiveRegistrationTest() {
        wishlistRegistrationPage.open("register");
        String titleRegistration = "Регистрация";
        compare.compareStr(wishlistRegistrationPage.getTitleText(), titleRegistration);
        screenshot.takeFullscreenScreenshot(driver, "RegistrationScreenshot");

        String name = wishlistRegistrationPage.enterAndGetUserName(testDataGenerator.getName());
        wishlistRegistrationPage.enterEmail(testDataGenerator.getEmail());
        String password = wishlistRegistrationPage.enterAndGetPassword(testDataGenerator.getPassword());
        wishlistRegistrationPage.clickOnRegistrationButton();

        String titleLogin = "Вход в систему";
        compare.compareStr(wishlistLoginPage.getTitleName(), titleLogin);

        wishlistLoginPage.enterUserName(name);
        wishlistLoginPage.enterPassword(password);
        wishlistLoginPage.clickSubmitButton();

        String titleLists = "Мои списки желаний";
        compare.compareStr(wishlistListsPage.getTitleName(), titleLists);
        screenshot.takeFullscreenScreenshot(driver, "SuccessLoginScreenshot");
    }

    @Test
    public void negativeRegistrationTest() {
        wishlistRegistrationPage.open("register");
        wishlistRegistrationPage.enterAndGetUserName(data.getLoginFromProperties());
        wishlistRegistrationPage.enterEmail(data.getUrlFromProperties());
        wishlistRegistrationPage.enterAndGetPassword(data.getPasswordFromProperties());
        wishlistRegistrationPage.clickOnRegistrationButton();

        String errorText = "Не удалось зарегистрировать пользователя";
        compare.compareStr(wishlistRegistrationPage.getErrorMessage(), errorText);
        screenshot.takeFullscreenScreenshot(driver, "WrongRegistrationAlertScreenshot");
    }

}
