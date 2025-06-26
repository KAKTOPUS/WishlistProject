package main.sut;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import components.PageComponents;
import config.GuiceModule;
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

    @Inject
    protected WebDriver driver;
    @Inject
    protected WishlistListsPage wishlistListsPage;
    @Inject
    protected WishlistLoginPage wishlistLoginPage;
    @Inject
    protected WishlistRegistrationPage wishlistRegistrationPage;
    @Inject
    protected WishlistUsersPage wishlistUsersPage;
    @Inject
    protected GetDataPropertiesUtil data;
    @Inject
    protected CompareStringsUtil compare;
    @Inject
    protected ScreenshotUtil screenshot;
    @Inject
    protected WaiterUtil wait;
    @Inject
    protected TestDataGenerator testDataGenerator;
    @Inject
    protected PageComponents components;

    @BeforeEach
    public void setUp() {
        Injector injector = Guice.createInjector(new GuiceModule() {
            @Override
            protected void configure() {
                try {
                    bind(WebDriver.class).toInstance(createWebDriver());
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        injector.injectMembers(this);
    }

    private WebDriver createWebDriver() throws MalformedURLException {
        WebDriverFactory factory = new WebDriverFactory();
        return factory.create(
                System.getProperty("browser"),
                System.getProperty("launch-parameter"),
                System.getProperty("remote-url"),
                System.getProperty("browser-version")
        );
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
