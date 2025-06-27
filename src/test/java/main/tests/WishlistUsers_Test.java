package main.tests;

import main.sut.AbsBaseSut;
import org.junit.jupiter.api.Test;

public class WishlistUsers_Test extends AbsBaseSut {

    @Test
    public void checkUserWishlistCard() {
        wishlistLoginPage.open("login");
        wishlistLoginPage.enterUserName(data.getLoginFromProperties());
        wishlistLoginPage.enterPassword(data.getPasswordFromProperties());
        wishlistLoginPage.clickSubmitButton();

        components.clickOnUsers();
        screenshot.takeFullscreenScreenshot(driver, "UsersPage");
        String userCardName = "admin";
        String actualCardName = wishlistUsersPage.userCard(userCardName).getText();
        compare.compareStr(actualCardName, userCardName);
        screenshot.takeElementScreenshot(driver, wishlistUsersPage.userCard(userCardName), "UserCardScreenshot");

        wishlistUsersPage.clickViewUserWishlistButton(userCardName);
        screenshot.takeFullscreenScreenshot(driver, "UserWishlists");

        String userWishlist = "Тестовый";
        String actualUserWishlist = wishlistUsersPage.userWishlistCard(userWishlist).getText();
        compare.compareStr(actualUserWishlist, userWishlist);
        screenshot.takeElementScreenshot(driver, wishlistUsersPage.userWishlistCard(userWishlist),
                "UserWishlistScreenshot");

        wishlistUsersPage.clickViewUserGiftButton(userWishlist);
        screenshot.takeFullscreenScreenshot(driver, "UserGiftListScreenshot");

        String gift = "Наушники";
        String actualUserGiftName = wishlistUsersPage.giftCard(gift).getText();
        compare.compareStr(actualUserGiftName, gift);
        screenshot.takeElementScreenshot(driver, wishlistUsersPage.giftCard(gift), "GiftScreenshot");

        wishlistUsersPage.clickReserveOrDeleteReserveButton(gift);
        screenshot.takeElementScreenshot(driver, wishlistUsersPage.giftCard(gift), "GiftReservedScreenshot");
        String giftReserved = "Подарок зарезервирован";
        String actualGiftReserved = wishlistUsersPage.getGiftReservedText(gift);
        compare.compareStr(actualGiftReserved, giftReserved);
        wishlistUsersPage.clickReserveOrDeleteReserveButton(gift);
        wait.waitForElementShouldBeVisible(driver, wishlistUsersPage.giftCard(gift));
        screenshot.takeElementScreenshot(driver, wishlistUsersPage.giftCard(gift), "GiftUnreservedScreenshot");
    }

}
