package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;

public class WishlistListsPage extends AbsBasePage {

    private final By createNewWishlistLocator = By.cssSelector("div>button[class='btn btn-primary']");
    private static final String WISHLIST_CARD_LOCATOR = "//div[@class='card-body']/div[normalize-space()='%s']" +
            "/ancestor::div[@class='card']";
    private static final String WISHLIST_VIEW_BUTTON_LOCATOR = "//div[contains(@class, 'card')]" +
            "[.//div[contains(@class, 'card-title') and contains(text(), '%s')]]//button[contains(@class, 'btn-primary')]";
    private static final String WISHLIST_DELETE_BUTTON_LOCATOR = "//div[contains(@class, 'card')]" +
            "[.//div[contains(@class, 'card-title') and contains(text(), '%s')]]//button[contains(@class, 'btn btn-danger')]";
    private final By addGiftButtonLocator = By.cssSelector("button[class='mb-4 btn btn-primary']");
    private final By modalWindowLocator = By.cssSelector("div[class='modal-title h4']");
    private final By enterDescribeLocator = By.cssSelector("textarea[class='form-control']");
    private final By enterGiftUrlLocator = By.cssSelector("input[placeholder='https://example.com/product']");
    private final By enterGiftPriceLocator = By.cssSelector("input[type='number']");
    private final By enterGiftPhotoUrlLocator = By.cssSelector("input[placeholder='https://example.com/image.jpg']");
    private final By errorTextLocator = By.cssSelector("div[class='mt-5 container']");
    private final By addButtonLocator = By.cssSelector("button[class='btn btn-primary']");

    @Step("Нажимаем на кнопку <Создать новый список>")
    public void clickCreateNewWishLstButton() {
        wait.waitForPageAndElement(driver, createNewWishlistLocator, 10).click();
    }

    public WebElement wishlistCard(String wishlistName) {
        By locator = By.xpath(String.format(WISHLIST_CARD_LOCATOR, wishlistName));
        return wait.waitForPageAndElement(driver, locator, 10);
    }

    @Step("Получаем название списка")
    public String getWishlistCardName(String wishlistName) {
        By locator = By.xpath(String.format(WISHLIST_CARD_LOCATOR, wishlistName));
        return wait.waitForPageAndElement(driver, locator, 10).getText();
    }

    @Step("Нажимаем на кнопку <Просмотр>")
    public void clickViewButton(String wishlistName) {
        By locator = By.xpath(String.format(WISHLIST_VIEW_BUTTON_LOCATOR, wishlistName));
        wait.waitForPageAndElement(driver, locator, 10).click();
    }

    @Step("Нажимаем на кнопку <Удалить>")
    public void clickDeleteButton(String wishlistName) {
        By locator = By.xpath(String.format(WISHLIST_DELETE_BUTTON_LOCATOR, wishlistName));
        wait.waitForPageAndElement(driver, locator, 10).click();
    }

    @Step("Нажимаем на кнопку <Добавить подарок>")
    public void clickAddGiftButton() {
        wait.waitForPageAndElement(driver, addGiftButtonLocator, 10).click();
    }

    @Step("Получаем название модального окна")
    public String getModalWindowName() {
        return wait.waitForPageAndElement(driver, modalWindowLocator, 10).getText();
    }

    @Step("Вводим название")
    public String enterAndGetName(String name) {
        wait.waitForPageAndElement(driver, enterNameLocator, 10).sendKeys(name);
        return name;
    }

    @Step("Вводим описание")
    public void enterTextDescribe(String textDescribe) {
        wait.waitForPageAndElement(driver, enterDescribeLocator, 10).sendKeys(textDescribe);
    }

    @Step("Вводим ссылку на подарок")
    public void enterGiftUrl(String gift) {
       wait.waitForPageAndElement(driver, enterGiftUrlLocator, 10).sendKeys(gift);
    }

    @Step("Вводим цену подарка")
    public void enterGiftPrice(int price) {
        wait.waitForPageAndElement(driver, enterGiftPriceLocator, 10).sendKeys(Integer.toString(price));
    }

    @Step("Вводим ссылку на фото")
    public void enterPhotoUrl(String photo) {
        wait.waitForPageAndElement(driver, enterGiftPhotoUrlLocator, 10).sendKeys(photo);
    }

    @Step("Нажимаем на кнопку <Создать>")
    public void clickCreateButton() {
        wait.waitForPageAndElement(driver, submitButtonLocator, 10).click();
    }

    @Step("Получаем текст ошибки")
    public String getErrorText() {
        return wait.waitForPageAndElement(driver, errorTextLocator, 10).getText();
    }

    @Step("Нажимаем на кнопку <Добавить>")
    public void clickOnAddButton() {
        wait.waitForPageAndElement(driver, addButtonLocator, 10).click();
    }

}

