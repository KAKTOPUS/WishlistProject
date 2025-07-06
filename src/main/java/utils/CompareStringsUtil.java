package utils;

import io.qameta.allure.Step;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CompareStringsUtil {

    @Step("Сравниваем строки")
    public void compareStr(String actualString, String expectedString) {
        assertThat(actualString.toLowerCase())
              .as("String should be same as {}", expectedString.toLowerCase())
               .startsWith(expectedString.toLowerCase());
    }

}
