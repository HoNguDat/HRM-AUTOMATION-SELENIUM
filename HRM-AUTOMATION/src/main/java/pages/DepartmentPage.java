package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DepartmentPage {
    private WebDriver driver;

    private By addDepartment_btn = By.xpath("//span[normalize-space()='Add new']");
    private By modal = By. xpath("//div[@class='ant-modal-content']");
    private By departmentName_input = By.xpath("//input[@id='name']");
    private By ok_btn = By.xpath("//button[@class='ant-btn css-dev-only-do-not-override-qgg3xn ant-btn-primary']");
    private By cancel_btn = By.xpath("//button[@class='ant-btn css-dev-only-do-not-override-qgg3xn ant-btn-default']");
    private By searchName_input = By.xpath("//input[@placeholder='Enter name']");
    private By search_btn = By.xpath("//button[@class='ant-btn css-dev-only-do-not-override-qgg3xn ant-btn-default ant-btn-icon-only ant-input-search-button']");

    public DepartmentPage(WebDriver driver) {
        this.driver = driver;
    }

    public String GetPageTitle() {
        return driver.getTitle();
    }

    public void OpenModal() {
        driver.findElement(addDepartment_btn).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-content']")));
    }

    public boolean CheckModalIsDisplayed() {
        return driver.findElement(modal).isDisplayed();
    }

    public void InputDepartmentName(String departmentName) {
        driver.findElement(departmentName_input).sendKeys(departmentName);
    }

    public void ClickButtonOk(){
        driver.findElement(ok_btn).click();
    }

    public void ClickButtonCancel(){
        driver.findElement(cancel_btn).click();
    }

    public void InputSearchName(String searchName) {
        driver.findElement(searchName_input).sendKeys(searchName);
    }

    public void ClickButtonSearch(){
        driver.findElement(search_btn).click();
    }

}
