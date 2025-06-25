package utils;

import io.qameta.allure.Step;

public class UrlBuilderUtil {

    private String baseUrl = System.getProperty("base-url");

    @Step("Подставляем конец ссылки")
    public String buildUrl(String path) {

        if (baseUrl == null) {
            throw new IllegalArgumentException("base-url is not set in system properties");
        }

        String cleanBaseUrl = baseUrl.endsWith("/")
                ? baseUrl.substring(0, baseUrl.length() - 1)
                : baseUrl;

        return cleanBaseUrl + "/" + path.toLowerCase();
    }

}
