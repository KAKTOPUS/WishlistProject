package main.tests;

import org.junit.jupiter.api.Test;
import main.sut.AbsBaseSut;


public class Login_Test extends AbsBaseSut {

    @Test
    public void positiveLoginTest() {
        wishlistLoginPage.open(pagesData.LOGIN);
        wishlistLoginPage.enterUserName(data.getLoginFromProperties());
        wishlistLoginPage.enterPassword(data.getPasswordFromProperties());
        wishlistLoginPage.clickSubmitButton();
        compare.compareStr(wishlistListsPage.getTitleName(title.WISHLIST),
                title.WISHLIST.getTitle());
    }

    @Test
    public void negativeLoginTest() {
        wishlistLoginPage.open(pagesData.LOGIN);
        wishlistLoginPage.enterUserName(data.getLoginFromProperties());
        wishlistLoginPage.enterPassword(data.getWrongPasswordFromProperties());
        wishlistLoginPage.clickSubmitButton();
        compare.compareStr(wishlistLoginPage.getErrorText(),
                loginData.ERROR_LOGIN.getText());
    }
}
