package main.sut;

import components.PageComponents;
import dto.TestDataGenerator;
import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.WishlistListsPage;
import pages.WishlistLoginPage;
import pages.WishlistRegistrationPage;
import pages.WishlistUsersPage;
import utils.*;

import java.net.MalformedURLException;


public abstract class AbsBaseSut {

    private String remoteUrl = System.getProperty("remote-url", "");
    private String browser = System.getProperty("browser");
    private String launchParameter = System.getProperty("launch-parameter");
    private String browserVersion = System.getProperty("browser-version");

    protected WishlistListsPage wishlistListsPage = null;
    protected WishlistLoginPage wishlistLoginPage = null;
    protected WishlistRegistrationPage wishlistRegistrationPage = null;
    protected WishlistUsersPage wishlistUsersPage = null;
    protected GetDataPropertiesUtil data = null;
    protected CompareStringsUtil compare = null;
    protected WebDriver driver = null;
    protected ScreenshotUtil screenshot = null;
    protected WaiterUtil wait = null;
    protected TestDataGenerator testDataGenerator = null;
    protected GetTextUtil getText = null;
    protected PageComponents components = null;

    @BeforeEach
    public void initDriver() throws MalformedURLException {
        driver = new WebDriverFactory().create(browser, launchParameter, remoteUrl, browserVersion);
        wishlistListsPage = new WishlistListsPage(driver);
        wishlistLoginPage = new WishlistLoginPage(driver);
        wishlistRegistrationPage = new WishlistRegistrationPage(driver);
        wishlistUsersPage = new WishlistUsersPage(driver);
        data = new GetDataPropertiesUtil();
        compare = new CompareStringsUtil();
        screenshot = new ScreenshotUtil();
        wait = new WaiterUtil();
        testDataGenerator = new TestDataGenerator();
        getText = new GetTextUtil();
        components = new PageComponents(driver);

    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

}
