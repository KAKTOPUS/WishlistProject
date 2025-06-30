package factory.settings;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class ChromeSettings implements IBrowserSettings {

    public AbstractDriverOptions settings(String launchParameter) {
        ChromeOptions options = new ChromeOptions();

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
