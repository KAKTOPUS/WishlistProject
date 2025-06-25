package main.tests;

import main.sut.AbsBaseSut;
import org.junit.jupiter.api.Test;

public class Components_Test extends AbsBaseSut {

    @Test
    public void checkNavBarTest() {
        wishlistLoginPage.open("login");
        components.clickNavigationBar();
        screenshot.takeFullscreenScreenshot(driver, "OpenNavBarScreenshot");
        components.clickOnRegister();
        screenshot.takeFullscreenScreenshot(driver, "OpenRegistrationScreenshot");

        components.clickOnLogin();
        wishlistLoginPage.enterUserName(data.getLoginFromProperties());
        wishlistLoginPage.enterPassword(data.getPasswordFromProperties());
        wishlistLoginPage.clickSubmitButton();

        components.clickOnUsers();
        screenshot.takeFullscreenScreenshot(driver, "OpenUsersScreenshot");

        components.clickOnMyWishlists();
        screenshot.takeFullscreenScreenshot(driver, "OpenMyWishlistsScreenshot");
    }
}
