package main.tests;

import main.sut.AbsBaseSut;
import org.junit.jupiter.api.Test;

public class Components_Test extends AbsBaseSut {

    @Test
    public void checkNavigationBarToLogin() {
        wishlistLoginPage.open(pagesData.LOGIN);
        components.clickOnLogin();
        compare.compareStr(wishlistLoginPage.getTitleName(title.LOGIN),
                title.LOGIN.getTitle());
    }

    @Test
    public void checkNavigationBarToRegistration() {
        wishlistLoginPage.open(pagesData.LOGIN);
        components.clickOnRegister();
        compare.compareStr(wishlistRegistrationPage.getTitleName(title.REGISTRATION),
                title.REGISTRATION.getTitle());
    }

    @Test
    public void checkNavigationBarToWishlist() {
        wishlistLoginPage.open(pagesData.LOGIN);
        wishlistLoginPage.enterUserName(data.getLoginFromProperties());
        wishlistLoginPage.enterPassword(data.getPasswordFromProperties());
        wishlistLoginPage.clickSubmitButton();
        components.clickOnMyWishlists();
        compare.compareStr(wishlistListsPage.getTitleName(title.WISHLIST),
                title.WISHLIST.getTitle());
    }

    @Test
    public void checkNavigationBarToUsers() {
        wishlistLoginPage.open(pagesData.LOGIN);
        wishlistLoginPage.enterUserName(data.getLoginFromProperties());
        wishlistLoginPage.enterPassword(data.getPasswordFromProperties());
        wishlistLoginPage.clickSubmitButton();
        components.clickOnUsers();
        compare.compareStr(wishlistUsersPage.getTitleName(title.USERS),
                title.USERS.getTitle());
    }

    @Test
    public void checkLogoutButton() {
        wishlistLoginPage.open(pagesData.LOGIN);
        wishlistLoginPage.enterUserName(data.getLoginFromProperties());
        wishlistLoginPage.enterPassword(data.getPasswordFromProperties());
        wishlistLoginPage.clickSubmitButton();
        components.clickOnExit();
        compare.compareStr(wishlistLoginPage.getTitleName(title.LOGIN),
                title.LOGIN.getTitle());
    }

}
