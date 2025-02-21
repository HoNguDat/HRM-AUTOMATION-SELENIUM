package testcases;

import config.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DepartmentPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void TestPageTitle() {
        Assert.assertEquals(loginPage.GetPageTitle(),"SHRM - Login");
    }
    @Test
    public void TestPageLink(){
        Assert.assertEquals(loginPage.GetPageLinkText(),"http://localhost:3000/login");
    }
    @Test
    public void TestHeadingTag(){
        Assert.assertEquals(loginPage.GetHeadingTag(),"Login");
    }

}
