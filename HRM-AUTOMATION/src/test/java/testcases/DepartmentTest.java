package testcases;

import config.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DepartmentPage;

import java.time.Duration;


public class DepartmentTest extends BaseTest {
    private DepartmentPage departmentPage;

    @BeforeClass
    public void setUp() {
        departmentPage = new DepartmentPage(driver);
        driver.get("http://localhost:3000/department-list");
    }

    @Test
    public void TestPageTitle() {
        Assert.assertEquals(departmentPage.GetPageTitle(),"SHRM - Smart human resource management");
    }

    @Test
    public void TestModalIsDisplayed() {
        departmentPage.OpenModal();
        Assert.assertTrue(departmentPage.CheckModalIsDisplayed());
    }

//    @Test
//    public void TestModalIsHidden() {
//        departmentPage.OpenModal();
//        departmentPage.ClickButtonCancel();
//        Assert.assertFalse(departmentPage.CheckModalIsDisplayed());
//    }
}
