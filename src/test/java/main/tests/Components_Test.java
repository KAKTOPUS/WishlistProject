package main.tests;

import main.sut.AbsBaseSut;
import org.junit.jupiter.api.Test;

public class Components_Test extends AbsBaseSut {

    @Test
    public void checkNavBarTest() {
        wishlistLoginPage.open("login");
        screenshot.takeElementScreenshot(driver, components.navBar(), "NavigationBarWhenNotLoggedInScreenshot");
        components.clickOnRegister();
        screenshot.takeFullscreenScreenshot(driver, "OpenRegistrationScreenshot");

        components.clickOnLogin();
        screenshot.takeFullscreenScreenshot(driver, "OpenLoginScreenshot");
        wishlistLoginPage.enterUserName(data.getLoginFromProperties());
        wishlistLoginPage.enterPassword(data.getPasswordFromProperties());
        wishlistLoginPage.clickSubmitButton();
        screenshot.takeElementScreenshot(driver, components.navBar(), "NavigationBarWhenLoggedInScreenshot");

        components.clickOnUsers();
        screenshot.takeFullscreenScreenshot(driver, "OpenUsersScreenshot");

        components.clickOnMyWishlists();
        screenshot.takeFullscreenScreenshot(driver, "OpenMyWishlistsScreenshot");

        components.clickOnExit();
        screenshot.takeFullscreenScreenshot(driver, "LogoutScreenshot");
    }
}
