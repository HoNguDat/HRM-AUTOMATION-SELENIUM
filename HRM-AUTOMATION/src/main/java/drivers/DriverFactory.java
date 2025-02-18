package drivers;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {
     if (driver == null) {
         switch (browser){
             case "chrome":
                 System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("chromedriver"));
                 driver = new ChromeDriver();
                 driver.manage().window().maximize();
                 break;
             default:
                 throw new RuntimeException("Unsupported browser: " + browser);
         }
     }
     return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
