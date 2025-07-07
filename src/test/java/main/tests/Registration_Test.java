package main.tests;

import main.sut.AbsBaseSut;
import org.junit.jupiter.api.Test;

public class Registration_Test extends AbsBaseSut {

    @Test
    public void positiveRegistrationTest() {
        wishlistRegistrationPage.open(pagesData.REGISTRATION);
        String name = wishlistRegistrationPage.enterAndGetUserName(testDataGenerator.getName());
        wishlistRegistrationPage.enterEmail(testDataGenerator.getEmail());
        String password = wishlistRegistrationPage.enterAndGetPassword(testDataGenerator.getPassword());
        wishlistRegistrationPage.clickOnRegistrationButton();
        wishlistLoginPage.enterUserName(name);
        wishlistLoginPage.enterPassword(password);
        wishlistLoginPage.clickSubmitButton();
        compare.compareStr(wishlistListsPage.getTitleName(title.WISHLIST),
                title.WISHLIST.getTitle());
    }

    @Test
    public void negativeRegistrationTest() {
        wishlistRegistrationPage.open(pagesData.REGISTRATION);
        wishlistRegistrationPage.enterAndGetUserName(data.getLoginFromProperties());
        wishlistRegistrationPage.enterEmail(data.getUrlFromProperties());
        wishlistRegistrationPage.enterAndGetPassword(data.getPasswordFromProperties());
        wishlistRegistrationPage.clickOnRegistrationButton();
        compare.compareStr(wishlistRegistrationPage.getErrorMessage(),
                registrationData.ERROR_REGISTRATION.getText());
    }

}
