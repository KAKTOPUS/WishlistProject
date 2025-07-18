package factory.settings;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class FirefoxSettings implements IBrowserSettings {

    public AbstractDriverOptions settings(String launchParameter) {
        FirefoxOptions options = new FirefoxOptions();

        switch (launchParameter) {
            case "headless": {
                options.addArguments("--headless");
                return options;
            }
            case "fullscreen": {
                options.addArguments("--fullscreen");
                return options;
            }
            case "kiosk": {
                options.addArguments("--kiosk");
                return options;
            }
            default: {
                options.addArguments("start-fullscreen");
                return options;
            }
        }
    }

}
