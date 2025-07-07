package main.sut;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import components.*;
import config.GuiceModule;
import dto.TestDataGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.WishlistListsPage;
import pages.WishlistLoginPage;
import pages.WishlistRegistrationPage;
import pages.WishlistUsersPage;
import utils.*;

public abstract class AbsBaseSut {

    protected TitleNameData title;
    protected PagesData pagesData;
    protected LoginData loginData;
    protected RegistrationData registrationData;
    protected WishlistsData wishlistsData;
    protected WishlistUserData wishlistUserData;
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
    protected TestDataGenerator testDataGenerator;
    @Inject
    protected PageComponents components;

    @BeforeEach
    public void setUp() {
        Injector injector = Guice.createInjector(new GuiceModule());
        injector.injectMembers(this);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
