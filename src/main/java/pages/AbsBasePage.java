package pages;

import common.AbsCommon;
import io.qameta.allure.Step;
import utils.UrlBuilderUtil;

public abstract class AbsBasePage extends AbsCommon {

    private UrlBuilderUtil urlBuilderUtil = new UrlBuilderUtil();


    @Step("Открытие страницы")
    public void open(String page) {
        driver.get(urlBuilderUtil.buildUrl(page));
    }

}
