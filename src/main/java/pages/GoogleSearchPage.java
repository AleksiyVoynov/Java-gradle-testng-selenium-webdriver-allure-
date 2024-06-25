package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchPage extends BasePage {
    private final By search = By.cssSelector("textarea[name='q']");
    private final By results = By.cssSelector("#rso [role='text'], #rso [role='link']");

    public GoogleSearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("make search {0}")
    public void searchFor(String text) {
        WebElement element = webDriver.findElement(search);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    @Step("take search result")
    public boolean getSearchingResult(String text) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(5), Duration.ofSeconds(1))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(results))
                .stream()
                .map(WebElement::getText)
                .anyMatch(elementText -> elementText.toLowerCase().contains(text.toLowerCase()));
    }
}
