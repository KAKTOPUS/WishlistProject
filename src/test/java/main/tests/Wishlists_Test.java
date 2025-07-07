package main.tests;

import main.sut.AbsBaseSut;
import org.junit.jupiter.api.Test;

public class Wishlists_Test extends AbsBaseSut {

    @Test
    public void createAndDeleteWishlistTest() {
        wishlistLoginPage.open(pagesData.LOGIN);
        wishlistLoginPage.enterUserName(data.getLoginFromProperties());
        wishlistLoginPage.enterPassword(data.getPasswordFromProperties());
        wishlistLoginPage.clickSubmitButton();

        wishlistListsPage.clickCreateNewWishLstButton();
        String wishlistName = wishlistListsPage.enterAndGetName(testDataGenerator.getName());
        wishlistListsPage.enterTextDescribe(testDataGenerator.getName());
        wishlistListsPage.clickCreateButton();
        compare.compareStr(wishlistListsPage.getWishlistCardName(wishlistName),
                wishlistName);
        wishlistListsPage.clickDeleteButton(wishlistName);
        screenshot.takeFullscreenScreenshot(driver, "WishlistsScreenshot");
    }

    @Test
    public void errorToAddGiftTest() {
        wishlistLoginPage.open(pagesData.LOGIN);
        wishlistLoginPage.enterUserName(data.getLoginFromProperties());
        wishlistLoginPage.enterPassword(data.getPasswordFromProperties());
        wishlistLoginPage.clickSubmitButton();

        wishlistListsPage.clickViewButton(wishlistsData.WISHLIST_NAME.getText());
        wishlistListsPage.clickAddGiftButton();
        wishlistListsPage.enterAndGetName(testDataGenerator.getName());
        wishlistListsPage.enterTextDescribe(testDataGenerator.getName());
        wishlistListsPage.enterGiftUrl(data.getGiftUrlFromProperties());
        wishlistListsPage.enterGiftPrice(testDataGenerator.getPrice());
        wishlistListsPage.enterPhotoUrl(data.getGiftPhotoFromProperties());
        wishlistListsPage.clickOnAddButton();
        compare.compareStr(wishlistListsPage.getErrorText(),
                wishlistsData.ERROR_TEXT.getText());

        components.clickOnMyWishlists();
        wishlistListsPage.clickViewButton(wishlistsData.WISHLIST_NAME.getText());
        screenshot.takeFullscreenScreenshot(driver, "GiftIsNotAddedScreenshot");
    }

}
