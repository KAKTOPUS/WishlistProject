package config;

import com.google.inject.AbstractModule;
import dto.TestDataGenerator;
import utils.*;

public class GuiceModule extends AbstractModule {

    protected void configure() {
        install(new WebDriverModule());

        bind(GetDataPropertiesUtil.class).asEagerSingleton();
        bind(CompareStringsUtil.class).asEagerSingleton();
        bind(ScreenshotUtil.class).asEagerSingleton();
        bind(WaiterUtil.class).asEagerSingleton();
        bind(TestDataGenerator.class).asEagerSingleton();
    }

}
