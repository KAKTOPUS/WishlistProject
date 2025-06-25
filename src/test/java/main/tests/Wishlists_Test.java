package main.tests;

import main.sut.AbsBaseSut;
import org.junit.jupiter.api.Test;

public class Wishlists_Test extends AbsBaseSut {

    @Test
    public void createAndDeleteWishlistTest() {
        wishlistLoginPage.open("login");
        wishlistLoginPage.enterUserName(data.getLoginFromProperties());
        wishlistLoginPage.enterPassword(data.getPasswordFromProperties());
        wishlistLoginPage.clickSubmitButton();

        wishlistListsPage.clickCreateNewWishLstButton();

        String expectModalWindowName = "Создать новый список желаний";
        compare.compareStr(wishlistListsPage.getModalWindowName(), expectModalWindowName);

        String wishlistName = wishlistListsPage.enterAndGetName(testDataGenerator.getName());
        wishlistListsPage.enterTextDescribe(testDataGenerator.getName());
        wishlistListsPage.clickCreateButton();

        compare.compareStr(wishlistListsPage.getWishlistCardName(wishlistName), wishlistName);

        screenshot.takeElementScreenshot(driver, wishlistListsPage.wishlistCard(wishlistName), "WishlistCardScreenshot");

        wishlistListsPage.clickDeleteButton(wishlistName);
        screenshot.takeFullscreenScreenshot(driver, "WishlistsScreenshot");
    }

    @Test
    public void errorToAddGiftTest() throws InterruptedException {
        wishlistLoginPage.open("login");
        wishlistLoginPage.enterUserName(data.getLoginFromProperties());
        wishlistLoginPage.enterPassword(data.getPasswordFromProperties());
        wishlistLoginPage.clickSubmitButton();

        wishlistListsPage.clickViewButton("Птицы");
        screenshot.takeFullscreenScreenshot(driver, "WishlistScreenshot");

        wishlistListsPage.clickAddGiftButton();

        String addGiftText = "Добавить подарок";
        compare.compareStr(wishlistListsPage.getModalWindowName(), addGiftText);

        wishlistListsPage.enterAndGetName(testDataGenerator.getName());
        wishlistListsPage.enterTextDescribe(testDataGenerator.getName());
        wishlistListsPage.enterGiftUrl(data.getGiftUrlFromProperties());
        wishlistListsPage.enterGiftPrice(testDataGenerator.getPrice());
        wishlistListsPage.enterPhotoUrl(data.getGiftPhotoFromProperties());
        wishlistListsPage.clickOnAddButton();

        String errorText = "Ошибка: Не удалось добавить подарок";
        compare.compareStr(wishlistListsPage.getErrorText(), errorText);
        screenshot.takeFullscreenScreenshot(driver, "ErrorToAddGiftScreenshot");

        components.clickOnMyWishlists();
        wishlistListsPage.clickViewButton("Птицы");
        screenshot.takeFullscreenScreenshot(driver, "GiftIsNotAddedScreenshot");
    }

}
