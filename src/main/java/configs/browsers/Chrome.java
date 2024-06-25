package configs.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

public class Chrome extends Browser {

    public Chrome(){
        this.webDriver = initChromeDriver();
    }

    private WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--allow-file-access-from-files");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        return new ChromeDriver(options);
    }
}
