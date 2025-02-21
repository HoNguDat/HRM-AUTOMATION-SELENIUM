package pages;

import config.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class DepartmentPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By headingTag = By.xpath("//h2[normalize-space()='Department list']");
    private By addDepartment_btn = By.xpath("//button[@class='ant-btn css-dev-only-do-not-override-qgg3xn ant-btn-primary btn-add']");
    private By modal = By. xpath("//div[@class='ant-modal-content']");
    private By departmentName_input = By.xpath("//input[@id='name']");
    private By ok_btn = By.xpath("//button[@class='ant-btn css-dev-only-do-not-override-qgg3xn ant-btn-primary']");
    private By cancel_btn = By.xpath("//button[@class='ant-btn css-dev-only-do-not-override-qgg3xn ant-btn-default']");
    private By searchName_input = By.xpath("//input[@placeholder='Enter name']");
    private By search_btn = By.xpath("//button[@class='ant-btn css-dev-only-do-not-override-qgg3xn ant-btn-default ant-btn-icon-only ant-input-search-button']");
    private By table = By.xpath("//div[@class='ant-table-content']");
    private By table_Thead = By.xpath("//thead[@class='ant-table-thead']//th");
    private By th_No = By.xpath("//th[normalize-space()='No']");
    private By th_Department = By.xpath("//th[@aria-label='Department name']");
    private By th_Action = By.xpath("//th[normalize-space()='Action']");

    public DepartmentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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

    public boolean CheckSearchInput() {
        return driver.findElement(searchName_input).isDisplayed();
    }

    public String CheckPlaceholderSearchInput() {
        return driver.findElement(searchName_input).getAttribute("placeholder");
    }

    public boolean CheckButtonAdd(){
        return driver.findElement(addDepartment_btn).isDisplayed();
    }

    public String CheckAttributeButton(){
        return driver.findElement(addDepartment_btn).getAttribute("class");
    }

    public void ClickAddButton() {
        if(!CheckModalIsDisplayed())
        {
            waitForPageLoaded();
            wait.until(ExpectedConditions.elementToBeClickable(addDepartment_btn)).click();
        }
    }

    public boolean CheckModalIsDisplayed() {
        waitForPageLoaded();
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(modal)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void EnsureModalOpened() {
        if (!CheckModalIsDisplayed()) {
            System.out.println("Modal is not displayed");
            ClickAddButton();
            System.out.println("Modal is displayed");
        }
    }

    public void InputDepartmentName(String departmentName) {
        driver.findElement(departmentName_input).sendKeys(departmentName);
    }

    public void ClickButtonOk(){
        wait.until(ExpectedConditions.elementToBeClickable(ok_btn)).click();
    }

    public void ClickButtonCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(cancel_btn)).click();
    }

    public void InputSearchName(String searchName) {
        driver.findElement(searchName_input).sendKeys(searchName);
    }

    public void ClickButtonSearch(){
        driver.findElement(search_btn).click();
    }

    public boolean CheckTableIsDisPlayed() {
        return driver.findElement(table).isDisplayed();
    }

    public boolean CheckColumnName(){
        List<WebElement> getTheads = driver.findElements(table_Thead);
        return getTheads.size() == 3 &&
                getTheads.get(0).getText().trim().equals("No") &&
                getTheads.get(1).getText().trim().equals("Department name") &&
                getTheads.get(2).getText().trim().equals("Action");
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

}
