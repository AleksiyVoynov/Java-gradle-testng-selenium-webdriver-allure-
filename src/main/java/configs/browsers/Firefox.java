package configs.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox extends Browser {
    public Firefox() {
        this.webDriver = initChromeDriver();
    }

    private WebDriver initChromeDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        return new FirefoxDriver(options);
    }
}
