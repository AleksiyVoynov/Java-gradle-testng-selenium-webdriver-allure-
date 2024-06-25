package configs.browsers;

import org.openqa.selenium.WebDriver;

public abstract class Browser {

    public String name;

    public WebDriver webDriver;

    @Override
    public String toString() {
        return name;
    }
}
