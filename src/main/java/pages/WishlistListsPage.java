package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;

public class WishlistListsPage extends AbsBasePage {

    @Step("Получаем заголовок страницы")
    public String getTitleName() {
        By locator = By.xpath("//h2[contains(text(), 'Мои списки')]");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement titleElement = driver.findElement(locator);
        String titleName = titleElement.getText();

        return titleName;
    }

    @Step("Нажимаем на кнопку <Создать новый список>")
    public void clickCreateNewWishLstButton() {
        By locator = By.cssSelector("div>button[class='btn btn-primary']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement createNewWishlistElement = driver.findElement(locator);

        createNewWishlistElement.click();
    }

    public WebElement wishlistCard(String wishlistName) {
        By locator = By.xpath(String.format("//div[@class='card-body']/div[normalize-space()='%s']/ancestor::div[@class='card']",
                wishlistName));

        return driver.findElement(locator);
    }

    @Step("Получаем название списка")
    public String getWishlistCardName(String wishlistName) {
        By locator = By.xpath(String.format("//div[@class='card-title h5' and contains(text(), '%s')]", wishlistName));
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement cardNameElement = driver.findElement(locator);

        return cardNameElement.getText();
    }

    @Step("Нажимаем на кнопку <Просмотр>")
    public void clickViewButton(String wishlistName) {
        By locator = By.xpath(String.format("//div[contains(@class, 'card')][.//div[contains(@class, 'card-title')" +
                " and contains(text(), '%s')]]//button[contains(@class, 'btn-primary')]", wishlistName));
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement viewButtonElement = driver.findElement(locator);

        viewButtonElement.click();
    }

    @Step("Нажимаем на кнопку <Удалить>")
    public void clickDeleteButton(String wishlistName) {
        By locator = By.xpath(String.format("//div[contains(@class, 'card')][.//div[contains(@class, 'card-title')" +
                " and contains(text(), '%s')]]//button[contains(@class, 'btn btn-danger')]", wishlistName));
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement deleteButtonElement = driver.findElement(locator);

        deleteButtonElement.click();
    }

    @Step("Нажимаем на кнопку <Добавить подарок>")
    public void clickAddGiftButton() {
        By locator = By.cssSelector("button[class='mb-4 btn btn-primary']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement addGiftButtonElement = driver.findElement(locator);

        addGiftButtonElement.click();
    }

    @Step("Получаем название модального окна")
    public String getModalWindowName() {
        By locator = By.cssSelector("div[class='modal-title h4']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement modalWindowNameElement = driver.findElement(locator);

        return modalWindowNameElement.getText();
    }

    @Step("Вводим название")
    public String enterAndGetName(String name) {
        By locator = By.cssSelector("input[type='text']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement nameGiftElement = driver.findElement(locator);
        nameGiftElement.sendKeys(name);

        return name;
    }

    @Step("Вводим описание")
    public void enterTextDescribe(String textDescribe) {
        By locator = By.cssSelector("textarea[class='form-control']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement textDescribeElement = driver.findElement(locator);

        textDescribeElement.sendKeys(textDescribe);
    }

    @Step("Вводим ссылку на подарок")
    public void enterGiftUrl(String gift) {
        By locator = By.cssSelector("input[placeholder='https://example.com/product']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement giftUrl = driver.findElement(locator);

        giftUrl.sendKeys(gift);
    }

    @Step("Вводим цену подарка")
    public void enterGiftPrice(int price) {
        By locator = By.cssSelector("input[type='number']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement giftPrice = driver.findElement(locator);

        giftPrice.sendKeys(Integer.toString(price));
    }

    @Step("Вводим ссылку на фото")
    public void enterPhotoUrl(String photo) {
        By locator = By.cssSelector("input[placeholder='https://example.com/image.jpg']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement giftPhoto = driver.findElement(locator);

        giftPhoto.sendKeys(photo);
    }

    @Step("Нажимаем на кнопку <Создать>")
    public void clickCreateButton() {
        By locator = By.cssSelector("button[type='submit']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement createButtonElement = driver.findElement(locator);

        createButtonElement.click();
    }

    @Step("Получаем текст ошибки")
    public String getErrorText() {
        By locator = By.cssSelector("div[class='mt-5 container']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement errorElement = driver.findElement(locator);

        return errorElement.getText();
    }

    @Step("Нажимаем на кнопку <Добавить>")
    public void clickOnAddButton() {
        By locator = By.cssSelector("button[class='btn btn-primary']");
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement addButtonElement = driver.findElement(locator);

        addButtonElement.click();
    }

}

