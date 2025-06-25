package pages;


import common.AbsCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import utils.UrlBuilderUtil;

public abstract class AbsBasePage extends AbsCommon {
    private UrlBuilderUtil urlBuilderUtil = new UrlBuilderUtil();

    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы")
    public void open(String page) {
        driver.get(urlBuilderUtil.buildUrl(page));
    }

}
