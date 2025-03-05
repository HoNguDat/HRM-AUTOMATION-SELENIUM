package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    private By headingTag = By.xpath("//h1[normalize-space()='Login']");
    private By label_Email = By.xpath("//label[normalize-space()='Email']");
    private By label_Password = By.xpath("//label[normalize-space()='Password']");
    private By input_Email = By.xpath("//input[@id='login-form_username']");
    private By input_Password = By.xpath("//input[@id='login-form_password']");
    private By errorInput_Email = By.xpath("//div[@class='ant-form-item-explain-error']");
    private By errorInput_Password = By.xpath("//div[contains(text(),'Please input your password!')]");
    private By eyeIconClosed  = By.xpath("//span[@aria-label='eye-invisible']");
    private By eyeIconOpened = By.cssSelector("span[aria-label='eye']");
    private By link_ForgotPassword = By.xpath("//a[@class='ant-typography css-dev-only-do-not-override-qgg3xn']");
    private By button_Login = By.xpath("//button[@type='submit']");
    private By link_Image = By.xpath("//img[@alt='sign-up-background']");
    private By messageError = By.xpath("//div[@class='ant-message-custom-content ant-message-error']");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public String GetPageTitle() {
        System.out.println("Tittle tested");
        return driver.getTitle();
    }
    public String GetPageLinkText() {
        System.out.println("Link text tested");
        return driver.getCurrentUrl();
    }
    public String GetHeadingTag() {
        System.out.println("Heading tag tested");
        return driver.findElement(headingTag).getText();
    }
    public String GetLabel_Email() {
        System.out.println("Label email tested");
        return driver.findElement(label_Email).getText();
    }
    public String GetLabel_Password() {
        System.out.println("Label password tested");
        return driver.findElement(label_Password).getText();
    }
    public String GetTextForgotPassword(){
        return driver.findElement(link_ForgotPassword).getText();
    }

    public String GetPlaceholderEmail(){
        System.out.println("Input: " + driver.findElement(input_Email).getAttribute("placeholder"));
        return driver.findElement(input_Email).getAttribute("placeholder");
    }
    public String GetPlaceholderPassword(){
        System.out.println("Pass: " + driver.findElement(input_Password).getAttribute("placeholder"));
        return driver.findElement(input_Password).getAttribute("placeholder");
    }
    public String GetLabelCLassEmail() {
        System.out.println("Label email class: "+driver.findElement(label_Email).getAttribute("class"));
        return driver.findElement(label_Email).getAttribute("class");
    }
    public String GetLabelCLassPassword() {
        System.out.println("Label password class: "+driver.findElement(label_Password).getAttribute("class"));
        return driver.findElement(label_Password).getAttribute("class");
    }
    public boolean CheckButtonLoginIsDisplayed(){
        return driver.findElement(button_Login).isDisplayed();
    }
    public String CheckButtonLoginText(){
        return driver.findElement(button_Login).getText();
    }
    public boolean CheckErrorMessageForEmptyEmail(){
        action.moveToElement(driver.findElement(input_Email)).click().build().perform();
        driver.findElement(input_Email).sendKeys("hongudat");
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
        return driver.findElement(errorInput_Email).isDisplayed();
    }
    public boolean CheckErrorMessageForEmptyPassword(){
        action.moveToElement(driver.findElement(input_Password)).click().build().perform();
        driver.findElement(input_Password).sendKeys("hongudat");
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
        return driver.findElement(errorInput_Password).isDisplayed();
    }
    public Boolean CheckErrorMessageEmail() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorInput_Email));
        return driver.findElement(errorInput_Email).isDisplayed();
    }
    public Boolean CheckErrorMessagePassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorInput_Password));
        return driver.findElement(errorInput_Password).isDisplayed();
    }
    public void ClickEyeIconOpen() throws Exception{
        Thread.sleep(10000);
        System.out.println("Eye display: "+driver.findElement(eyeIconOpened).isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(eyeIconOpened));
        driver.findElement(eyeIconOpened).click();
        System.out.println("Đã nhấn open");
    }
    public void ClickEyeIconClose() {
        driver.findElement(eyeIconClosed).click();
        System.out.println("Đã nhấn close");
    }
    public boolean CheckPasswordType(){
        System.out.println("Password type: "+ driver.findElement(input_Password).getAttribute("type"));
        if (driver.findElement(input_Password).getAttribute("type").equals("password"))
        {
            return true;
        }
        return false;
    }
    public boolean CheckEyeIconClosed(){
        System.out.println("Icon closed xuat hien: "+ driver.findElement(eyeIconClosed).isDisplayed());
        return driver.findElement(eyeIconClosed).isDisplayed();
    }
    public boolean CheckEyeIconOpened(){
        System.out.println("Icon opened xuat hien: "+ driver.findElement(eyeIconOpened).isDisplayed());
        return driver.findElement(eyeIconOpened).isDisplayed();
    }
    public void ClickButtonLogin(){
        driver.findElement(button_Login).click();
    }
    public void EnterEmail(String email){
        driver.findElement(input_Email).clear();
        driver.findElement(input_Email).sendKeys(email);
    }
    public void EnterPassword(String password){
        driver.findElement(input_Password).clear();
        driver.findElement(input_Password).sendKeys(password);
    }
    public Boolean CheckMessageIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageError));
        System.out.println("Message error: "+ driver.findElement(messageError).isDisplayed());
        return driver.findElement(messageError).isDisplayed();
    }

}
