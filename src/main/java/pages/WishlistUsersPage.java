package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WishlistUsersPage extends AbsBasePage {

    private static final String USER_CARD_LOCATOR = "//div[@class='card-body']/div[normalize-space()='%s']" +
            "/ancestor::div[@class='card']";
    private static final String VIEW_BUTTON_LOCATOR = "//div[contains(@class, 'card-title')" +
            " and normalize-space()='%s']/following-sibling::a[contains(@class, 'btn-primary')]";
    private static final String WISHLIST_CARD = "//div[@class='card']//div[contains(@class, 'card-title')" +
            " and normalize-space()='%s']/ancestor::div[@class='card']";
    private static final String VIEW_GIFT_BUTTON_LOCATOR = "//div[@class='card']//div[contains(@class, 'card-title')" +
            " and normalize-space()='%s']/ancestor::div[@class='card']//a[contains(@class, 'btn')]";
    private static final String GIFT_CARD_LOCATOR = "//div[@class='card-body']/div[contains(@class, 'card-title')" +
            " and normalize-space()='%s']/ancestor::div[@class='card']";
    private static final String RESERVE_BUTTON_LOCATOR = "//div[@class='card-body']/div[contains(@class, 'card-title')" +
            " and normalize-space()='%s']/ancestor::div[@class='card']//button[contains(@class, 'btn')]";
    private static final String RESERVED_TEXT_LOCATOR = "//div[contains(@class, 'card')][.//div[contains(@class, 'card-title')" +
            " and normalize-space()='%s']]//small[contains(@class, 'text-muted')]";

    public WebElement userCard(String userName) {
        By locator = By.xpath(String.format(USER_CARD_LOCATOR, userName));
        return wait.waitForPageAndElement(driver, locator, 10);
    }

    @Step("Нажимаем на кнопку <Посмотреть желания>")
    public void clickViewUserWishlistButton(String userName) {
        By locator = By.xpath(String.format(VIEW_BUTTON_LOCATOR, userName));
        wait.waitForPageAndElement(driver, locator, 10).click();
    }

    public WebElement userWishlistCard(String wishlistName) {
        By locator = By.xpath(String.format(WISHLIST_CARD, wishlistName));
        return wait.waitForPageAndElement(driver, locator, 10);
    }

    @Step("Нажимаем на кнопку <Посмотреть подарки>")
    public void clickViewUserGiftButton(String wishlistName) {
        By locator = By.xpath(String.format(VIEW_GIFT_BUTTON_LOCATOR, wishlistName));
        wait.waitForPageAndElement(driver, locator, 10).click();
    }

    public WebElement giftCard(String giftName) {
        By locator = By.xpath(String.format(GIFT_CARD_LOCATOR, giftName));
        return wait.waitForPageAndElement(driver, locator, 10);
    }

    @Step("Нажимаем на кнопку <Зарезервировать подарок>")
    public void clickReserveOrDeleteReserveButton(String giftName) {
        By locator = By.xpath(String.format(RESERVE_BUTTON_LOCATOR, giftName));
        wait.waitForPageAndElement(driver, locator, 10).click();
    }

    @Step("Получаем текст <Подарок зарезервирован>")
    public String getGiftReservedText(String giftName) {
        By locator = By.xpath(String.format(RESERVED_TEXT_LOCATOR, giftName));
        return wait.waitForPageAndElement(driver, locator, 10).getText();
    }

}
