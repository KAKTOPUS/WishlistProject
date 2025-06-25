package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.*;



public class WishlistListsPage extends AbsBasePage {
    public WishlistListsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получаем заголовок страницы")
    public String getTitleName() {
        String xPathSelector = "//h2[contains(text(), 'Мои списки')]";
        waiter.waitForPageAndElement(driver, xPathSelector, 10);
        WebElement titleElement = driver.findElement(By.xpath(xPathSelector));
        String titleName = titleElement.getText();

        return titleName;
    }

    @Step("Нажимаем на кнопку <Создать новый список>")
    public void clickCreateNewWishLstButton() {
        String cssSelector = "div>button[class='btn btn-primary']";
        waiter.waitForPageAndElement(driver, cssSelector, 10);
        WebElement createNewWishlistElement = driver.findElement(By.cssSelector(cssSelector));

        createNewWishlistElement.click();
    }

    public WebElement wishlistCard(String wishlistName) {
        By locator = By.xpath(String.format("//div[@class='card-body']/div[normalize-space()='%s']/ancestor::div[@class='card']",
                wishlistName));

        return driver.findElement(locator);
    }

    @Step("Получаем название списка")
    public String getWishlistCardName(String wishlistName) {
        String xPathSelector = String.format("//div[@class='card-title h5' and contains(text(), '%s')]", wishlistName);
        waiter.waitForPageAndElement(driver, xPathSelector, 10);
        WebElement cardNameElement = driver.findElement(By.xpath(xPathSelector));

        return cardNameElement.getText();
    }

    @Step("Нажимаем на кнопку <Просмотр>")
    public void clickViewButton(String wishlistName) {
        String xPathSelector = String.format("//div[contains(@class, 'card')][.//div[contains(@class, 'card-title') and contains(text(), '%s')]]//button[contains(@class, 'btn-primary')]", wishlistName);
        waiter.waitForPageAndElement(driver, xPathSelector, 10);
        WebElement viewButtonElement = driver.findElement(By.xpath(xPathSelector));

        viewButtonElement.click();
    }

    @Step("Нажимаем на кнопку <Удалить>")
    public void clickDeleteButton(String wishlistName) {
        String xPathSelector = String.format("//div[contains(@class, 'card')][.//div[contains(@class, 'card-title') and contains(text(), '%s')]]//button[contains(@class, 'btn btn-danger')]", wishlistName);
        waiter.waitForPageAndElement(driver, xPathSelector, 10);

        WebElement deleteButtonElement = driver.findElement(By.xpath(xPathSelector));

        deleteButtonElement.click();
    }

    @Step("Нажимаем на кнопку <Добавить подарок>")
    public void clickAddGiftButton() {
        String cssSelector = "button[class='mb-4 btn btn-primary']";
        waiter.waitForPageAndElement(driver, cssSelector, 10);
        WebElement addGiftButtonElement = driver.findElement(By.cssSelector(cssSelector));

        addGiftButtonElement.click();
    }

    @Step("Получаем имя модального окна")
    public String getModalWindowName() {
        String cssSelector = "div[class='modal-title h4']";
        waiter.waitForPageAndElement(driver, cssSelector, 10);
        WebElement modalWindowNameElement = driver.findElement(By.cssSelector("div[class='modal-content']"));

        return getText.getTextFromCardAndModalWindow(driver, modalWindowNameElement);
    }

    public void expectClosingModalWindow() {
        WebElement modalWindowElement = driver.findElement(By.cssSelector("div[class='modal-content']"));
        waiter.waitForElementShouldBeInvisible(driver, modalWindowElement);
    }

    @Step("Вводим название")
    public String enterAndGetName(String name) {
        String cssSelector = "input[type='text']";
        waiter.waitForPageAndElement(driver, cssSelector, 10);
        WebElement nameGiftElement = driver.findElement(By.cssSelector(cssSelector));
        nameGiftElement.sendKeys(name);

        return name;
    }

    @Step("Вводим описание")
    public void enterTextDescribe(String textDescribe) {
        String cssSelector = "textarea[class='form-control']";
        waiter.waitForPageAndElement(driver, cssSelector, 10);
        WebElement textDescribeElement = driver.findElement(By.cssSelector(cssSelector));

        textDescribeElement.sendKeys(textDescribe);
    }

    @Step("Нажимаем на кнопку <Отмена>")
    public void clickCancelButton() {
        String cssSelector = "button[class='me-2 btn btn-secondary']";
        waiter.waitForPageAndElement(driver, cssSelector, 10);
        WebElement cancelElement = driver.findElement(By.cssSelector(cssSelector));

        cancelElement.click();
    }

    @Step("Вводим ссылку на подарок")
    public void enterGiftUrl(String gift) {
        String cssSelector = "input[placeholder='https://example.com/product']";
        waiter.waitForPageAndElement(driver, cssSelector, 10);
        WebElement giftUrl = driver.findElement(By.cssSelector(cssSelector));

        giftUrl.sendKeys(gift);
    }

    @Step("Вводим стоимость подарка")
    public void enterGiftPrice(int price) {
        String cssSelector = "input[type='number']";
        waiter.waitForPageAndElement(driver, cssSelector, 10);
        WebElement giftPrice = driver.findElement(By.cssSelector(cssSelector));

        giftPrice.sendKeys(Integer.toString(price));
    }

    @Step("Вводим ссылку на фото")
    public void enterPhotoUrl(String photo) {
        String cssSelector = "input[placeholder='https://example.com/image.jpg']";
        waiter.waitForPageAndElement(driver, cssSelector, 10);
        WebElement giftPhoto = driver.findElement(By.cssSelector(cssSelector));

        giftPhoto.sendKeys(photo);
    }

    @Step("Нажимаем на кнопку <Создать>")
    public WebElement clickCreateButton() {
        String cssSelector = "button[type='submit']";
        waiter.waitForPageAndElement(driver, cssSelector, 10);
        WebElement addElement = driver.findElement(By.cssSelector(cssSelector));

        return addElement;
    }

    public void fillAllFormToAddGift(String name, String describe, String giftUrl, int giftPrice, String photoUrl) {

    }



    @Step("Получаем текст ошибки")
    public String getErrorText() {
        String cssSelector = "div[class='mt-5 container']";
        waiter.waitForPageAndElement(driver, cssSelector, 10);
        WebElement errorElement = driver.findElement(By.cssSelector(cssSelector));

        return errorElement.getText();
    }

    @Step("Нажимаем на кнопку <Удалить список>")
    public void clickDeleteListButton() {
            String cssSelector = "button[class='mb-4 ms-2 btn btn-danger']";
        waiter.waitForPageAndElement(driver, cssSelector, 10);
        WebElement deleteListButtonElement = driver.findElement(By.cssSelector(cssSelector));

        deleteListButtonElement.click();
    }

    @Step("Нажимаем на кнопку <Добавить>")
    public void clickOnAddButton() {
        String css = "button[class='btn btn-primary']";
        waiter.waitForPageAndElement(driver, css, 10);
        WebElement addButtonElement = driver.findElement(By.cssSelector(css));

        addButtonElement.click();
    }

}

