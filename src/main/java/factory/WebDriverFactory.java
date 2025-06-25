package factory;

import exceptions.BrowserNotSupportedException;
import factory.settings.ChromeSettings;
import factory.settings.FirefoxSettings;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    public WebDriver create(String browser, String launchParameter, String remoteUrl, String browserVersion) throws MalformedURLException {

        if (!remoteUrl.isEmpty()) {

            MutableCapabilities mutableCapabilities = new MutableCapabilities();
            mutableCapabilities.setCapability("browserName", browser);
            mutableCapabilities.setCapability("browserVersion", browserVersion);


            return new RemoteWebDriver(new URL(remoteUrl), mutableCapabilities);
        }

        switch (browser) {
            case "chrome": {
                return new ChromeDriver((ChromeOptions) new ChromeSettings().settings(launchParameter));
            }
            case "firefox": {
                return new FirefoxDriver((FirefoxOptions) new FirefoxSettings().settings(launchParameter));
            }
        }
        throw new BrowserNotSupportedException(browser);
    }

}
