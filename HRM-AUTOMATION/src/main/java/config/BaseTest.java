package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    static String driverPath = "resources\\drivers\\";
    protected WebDriverWait wait;
    protected String baseUrl;

    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(String browserType, String baseUrl) {
        switch (browserType) {
            case "chrome":
                driver = InitChrome(baseUrl);
                break;
            case "firefox":

                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = InitChrome(baseUrl);
        }
    }

    private static WebDriver InitChrome(String baseUrl) {
        System.out.println("Launching Chrome browser...");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\IDE\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");       // Tắt bảo mật CORS
        options.addArguments("--allow-running-insecure-content");  // Cho phép nội dung không an toàn
        options.addArguments("--ignore-certificate-errors");   // Bỏ qua lỗi chứng chỉ
        options.addArguments("--remote-allow-origins=*");     // Cho phép mọi  origin (Selenium 4.8+)
        options.addArguments("--allow-insecure-localhost");  // Cho phép localhost không an toàn
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

    @Parameters({ "browserType", "baseUrl" })
    @BeforeClass
    public void InitializeTestBaseSetup(String browserType, String baseUrl) {
        this.baseUrl = baseUrl;
        try {
            // Init browser
            setDriver(browserType, baseUrl);
        } catch (Exception e) {
            System.out.println("Error..." + e.getStackTrace());
        }
    }

    @AfterClass
    public void TearDown() throws Exception{
        if (driver != null) {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
