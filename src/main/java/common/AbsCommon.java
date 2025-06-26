package common;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import utils.WaiterUtil;

public abstract class AbsCommon {

    @Inject
    protected WebDriver driver;
    @Inject
    protected WaiterUtil wait;

}
