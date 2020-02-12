package driver;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {


    public static WebDriver webDriver;

    @BeforeSuite
    public void initializeDriver(){
        System.setProperty("webdriver.chrome.driver", "/Users/testinium/IdeaProjects/Drivers/Chromedrivers/chromedriver");
        webDriver= new ChromeDriver();
    }

    // Close the webDriver instance
    @AfterSuite
    public void closeDriver(){
        webDriver.quit();
    }

}