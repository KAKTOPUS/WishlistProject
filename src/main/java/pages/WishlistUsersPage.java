package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WishlistUsersPage extends AbsBasePage {

    public WebElement userCard(String userName) {
        By locator = By.xpath(String.format("//div[@class='card-body']/div[normalize-space()='%s']" +
                "/ancestor::div[@class='card']", userName));
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement userCardElement = driver.findElement(locator);

        return userCardElement;
    }

    @Step("Нажимаем на кнопку <Посмотреть желания>")
    public void clickViewUserWishlistButton(String userName) {
        By locator = By.xpath(String.format("//div[contains(@class, 'card-title')" +
                " and normalize-space()='%s']/following-sibling::a[contains(@class, 'btn-primary')]", userName));
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement viewWishlistElement = driver.findElement(locator);

        viewWishlistElement.click();
    }

    public WebElement userWishlistCard(String wishlistName) {
        By locator = By.xpath(String.format("//div[@class='card']//div[contains(@class, 'card-title')" +
                " and normalize-space()='%s']/ancestor::div[@class='card']", wishlistName));
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement userWishlistCardElement = driver.findElement(locator);

        return userWishlistCardElement;
    }

    @Step("Нажимаем на кнопку <Посмотреть подарки>")
    public void clickViewUserGiftButton(String wishlistName) {
        By locator = By.xpath(String.format("//div[@class='card']//div[contains(@class, 'card-title')" +
                " and normalize-space()='%s']/ancestor::div[@class='card']//a[contains(@class, 'btn')]", wishlistName));
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement viewUserGiftButtonElement = driver.findElement(locator);

        viewUserGiftButtonElement.click();
    }

    public WebElement giftCard(String giftName) {
        By locator = By.xpath(String.format("//div[@class='card-body']/div[contains(@class, 'card-title')" +
                " and normalize-space()='%s']/ancestor::div[@class='card']", giftName));
        wait.waitForPageAndElement(driver, locator, 15);
        WebElement giftCardElement = driver.findElement(locator);

        return giftCardElement;
    }

    @Step("Нажимаем на кнопку <Зарезервировать подарок>")
    public void clickReserveOrDeleteReserveButton(String giftName) {
        By locator = By.xpath(String.format("//div[@class='card-body']/div[contains(@class, 'card-title')" +
                " and normalize-space()='%s']/ancestor::div[@class='card']//button[contains(@class, 'btn')]", giftName));
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement reserveButtonElement = driver.findElement(locator);

        reserveButtonElement.click();
    }

    @Step("Получаем текст <Подарок зарезервирован>")
    public String getGiftReservedText(String giftName) {
        By locator = By.xpath(String.format("//div[contains(@class, 'card')][.//div[contains(@class, 'card-title')" +
                " and normalize-space()='%s']]//small[contains(@class, 'text-muted')]", giftName));
        wait.waitForPageAndElement(driver, locator, 10);
        WebElement giftReservedText = driver.findElement(locator);

        return giftReservedText.getText();
    }

}
