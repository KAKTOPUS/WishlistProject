package pages;

import common.AbsCommon;
import components.PagesData;
import components.TitleNameData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.UrlBuilderUtil;

public abstract class AbsBasePage extends AbsCommon {

    private final UrlBuilderUtil urlBuilderUtil = new UrlBuilderUtil();
    private static final String TITLE_LOCATOR = "//h2[contains(text(), '%s')]";
    protected final By enterNameLocator = By.cssSelector("input[type='text']");
    protected final By enterPasswordLocator = By.cssSelector("input[type='password']");
    protected final By submitButtonLocator = By.cssSelector("button[type='submit']");


    @Step("Открытие страницы")
    public void open(PagesData page) {
        driver.get(urlBuilderUtil.buildUrl(page.getPage()));
    }

    @Step("Получаем заголовок страницы")
    public String getTitleName(TitleNameData titleName) {
        By locator = By.xpath(String.format(TITLE_LOCATOR, titleName.getTitle()));
        return wait.waitForPageAndElement(driver, locator, 20).getText();
    }

}
