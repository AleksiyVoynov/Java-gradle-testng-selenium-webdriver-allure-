import browsers.Chrome;
import browsers.Firefox;
import browsers.Safari;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest implements IHookable {
    protected WebDriver webDriver;

    @BeforeClass
    @Step("setting up web driver")
    @Parameters({"browser"})
    protected void setUp(@Optional("default") String browser) {
        if (browser.equals("chrome")) {
            webDriver = new Chrome().webDriver;
        } else if (browser.equals("safari")) {
            webDriver = new Safari().webDriver;
        } else if (browser.equals("firefox")) {
            webDriver = new Firefox().webDriver;
        } else {
            webDriver = new Chrome().webDriver;
        }
        Allure.addAttachment("Browser Info", browser);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass
    @Step("tearing down web driver")
    protected void tearDown() {
        webDriver.quit();
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
        if (testResult.getThrowable() != null) {
            try {
                takeScreenShot(webDriver);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Attachment(value = "Failure in method {0}", type = "image/png")
    private byte[] takeScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
