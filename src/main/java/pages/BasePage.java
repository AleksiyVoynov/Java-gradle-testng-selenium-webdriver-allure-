package pages;

import configs.Config;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BasePage extends Config {

    public WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("go to page")
    public void navigateTo(String page) {
        webDriver.get(page);
    }
}
