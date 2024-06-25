package configs.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class Safari extends Browser {

    public Safari(){
        this.webDriver = initChromeDriver();
    }

    private WebDriver initChromeDriver() {
        SafariOptions options = new SafariOptions();
        return new SafariDriver(options);
    }
}
