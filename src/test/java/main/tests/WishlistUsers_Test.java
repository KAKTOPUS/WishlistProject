package main.tests;

import main.sut.AbsBaseSut;
import org.junit.jupiter.api.Test;

public class WishlistUsers_Test extends AbsBaseSut {

    @Test
    public void checkUserWishlistCard() {
        wishlistLoginPage.open(pagesData.LOGIN);
        wishlistLoginPage.enterUserName(data.getLoginFromProperties());
        wishlistLoginPage.enterPassword(data.getPasswordFromProperties());
        wishlistLoginPage.clickSubmitButton();

        components.clickOnUsers();
        wishlistUsersPage.clickViewUserWishlistButton(wishlistUserData.USER_CARD.getText());
        wishlistUsersPage.clickViewUserGiftButton(wishlistUserData.USER_WISHLIST.getText());
        String gift = wishlistUserData.USER_GIFT.getText();
        wishlistUsersPage.clickReserveOrDeleteReserveButton(gift);
        screenshot.takeElementScreenshot(driver, wishlistUsersPage.giftCard(gift), "GiftReservedScreenshot");
        compare.compareStr(wishlistUsersPage.getGiftReservedText(gift),
                wishlistUserData.GIFT_RESERVED.getText());
        wishlistUsersPage.clickReserveOrDeleteReserveButton(gift);
        screenshot.takeElementScreenshot(driver, wishlistUsersPage.giftCard(gift), "GiftUnreservedScreenshot");
    }

}
