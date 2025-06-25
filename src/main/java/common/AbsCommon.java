package common;

import dto.TestDataGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.GetDataPropertiesUtil;
import utils.GetTextUtil;
import utils.ScreenshotUtil;
import utils.WaiterUtil;

public abstract class AbsCommon {

    protected WebDriver driver = null;
    protected TestDataGenerator testDataGenerator = null;
    protected WaiterUtil waiter = null;
    protected GetDataPropertiesUtil propertiesUtil = null;
    protected ScreenshotUtil screenshot = null;
    protected GetTextUtil getText = null;
    protected Actions action = null;

    public AbsCommon(WebDriver driver) {
        this.driver = driver;
        this.testDataGenerator = new TestDataGenerator();
        this.waiter = new WaiterUtil();
        this.propertiesUtil = new GetDataPropertiesUtil();
        this.screenshot = new ScreenshotUtil();
        this.getText = new GetTextUtil();
        action = new Actions(driver);
    }

}
