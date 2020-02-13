package driver;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;



public class Driver {


    // Holds the WebDriver instance
    public static WebDriver webDriver;

    // Initialize a webDriver instance of required browser
    // Since this does not have a significance in the application's business domain, the BeforeSuite hook is used to instantiate the webDriver
    @BeforeSuite
    public void initializeDriver() throws MalformedURLException {
        String hubURL = "http://hub.testinium.io/wd/hub";
        DesiredCapabilities capability = new DesiredCapabilities();
        if (StringUtils.isNotBlank(System.getenv("key"))) {
            capability.setCapability("key", System.getenv("key"));
            webDriver = new RemoteWebDriver(new URL(hubURL), capability);
        } else {
            System.setProperty("webdriver.chrome.driver", "/Users/testinium/IdeaProjects/Drivers/Chromedrivers/chromedriver");
            webDriver= new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
    }

    // Close the webDriver instance
    @AfterSuite
    public void closeDriver() {
        webDriver.quit();
    }

}