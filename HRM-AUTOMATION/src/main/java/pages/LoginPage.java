package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By headingTag = By.xpath("//h1[normalize-space()='Login']");
    private By label_Email = By.xpath("//label[normalize-space()='Username']");
    private By label_Password = By.xpath("//label[normalize-space()='Password']");
    private By input_Email = By.xpath("//input[@id='login-form_username']");
    private By input_Password = By.xpath("//input[@id='login-form_password']");
    private By link_ForgotPassword = By.xpath("//a[@class='ant-typography css-dev-only-do-not-override-qgg3xn']");
    private By button_Login = By.xpath("//button[@type='submit']");
    private By link_Image = By.xpath("//img[@alt='sign-up-background']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String GetPageTitle() {
        return driver.getTitle();
    }

    public String GetPageLinkText() {
        return driver.getCurrentUrl();
    }

    public String GetHeadingTag() {
        return driver.findElement(headingTag).getText();
    }

}
