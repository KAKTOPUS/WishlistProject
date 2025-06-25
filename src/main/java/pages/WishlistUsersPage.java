package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishlistUsersPage extends AbsBasePage {

    public WishlistUsersPage(WebDriver driver) {
        super(driver);
    }

    public WebElement userCard(String userName) {
        String xPath = String.format("//div[@class='card-body']/div[normalize-space()='%s']/ancestor::div[@class='card']", userName);
        waiter.waitForPageAndElement(driver, xPath, 10);
        WebElement userCardElement = driver.findElement(By.xpath(xPath));

        return userCardElement;
    }

    @Step("Нажимаем на кнопку <Посмотреть желания>")
    public void clickViewUserWishlistButton(String userName) {
        String xPath = String.format("//div[contains(@class, 'card-title') and normalize-space()='%s']/following-sibling::a[contains(@class, 'btn-primary')]", userName);
        waiter.waitForPageAndElement(driver, xPath, 10);
        WebElement viewWishlistElement = driver.findElement(By.xpath(xPath));

        viewWishlistElement.click();
        //waiter.waitClick(driver, viewWishlistElement);
    }

    public WebElement userWishlistCard(String wishlistName) {
        String xPath = String.format("//div[@class='card']//div[contains(@class, 'card-title') and normalize-space()='%s']/ancestor::div[@class='card']", wishlistName);
        waiter.waitForPageAndElement(driver, xPath, 10);
        WebElement userWishlistCardElement = driver.findElement(By.xpath(xPath));

        return userWishlistCardElement;
    }

    @Step("Нажимаем на кнопку <Посмотреть подарки>")
    public void clickViewUserGiftButton(String wishlistName) {
        String xPath = String.format("//div[@class='card']//div[contains(@class, 'card-title') and normalize-space()='%s']/ancestor::div[@class='card']//a[contains(@class, 'btn')]", wishlistName);
        waiter.waitForPageAndElement(driver, xPath, 10);
        WebElement viewUserGiftButtonElement = driver.findElement(By.xpath(xPath));

        viewUserGiftButtonElement.click();
    }

    public void clickBackToTheUsersButton() {
        String css = "a[class='btn btn-secondary']";
        waiter.waitForPageAndElement(driver, css, 10);
        WebElement backToTheUsersButtonElement = driver.findElement(By.cssSelector("a[class='btn btn-secondary']"));

        backToTheUsersButtonElement.click();

    }

    public WebElement giftCard(String giftName) {
        String xPath = String.format("//div[@class='card-body']/div[contains(@class, 'card-title') and normalize-space()='%s']/ancestor::div[@class='card']", giftName);
        waiter.waitForPageAndElement(driver, xPath, 15);
        WebElement giftCardElement = driver.findElement(By.xpath(xPath));

        return giftCardElement;
    }

    @Step("Нажимаем на кнопку <Зарезервировать подарок>")
    public void clickReserveOrDeleteReserveButton(String giftName) {
        String xPath = String.format("//div[@class='card-body']/div[contains(@class, 'card-title') and normalize-space()='%s']/ancestor::div[@class='card']//button[contains(@class, 'btn')]", giftName);
        waiter.waitForPageAndElement(driver, xPath, 10);
        WebElement reserveButtonElement = driver.findElement(By.xpath(xPath));

        reserveButtonElement.click();
    }

    @Step("Получаем текст <Подарок зарезервирован>")
    public String getGiftReservedText(String giftName) {
        String xPath = String.format("//div[contains(@class, 'card')][.//div[contains(@class, 'card-title') and normalize-space()='%s']]//small[contains(@class, 'text-muted')]", giftName);
        waiter.waitForPageAndElement(driver, xPath, 10);
        WebElement giftReservedText = driver.findElement(By.xpath(xPath));

        return giftReservedText.getText();
    }

}
