package testcases;

import config.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DepartmentPage;

public class DepartmentTest extends BaseTest {
    private WebDriver driver;
    private DepartmentPage departmentPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
        departmentPage = new DepartmentPage(driver);
    }

    @Parameters("pagePath")
    @BeforeMethod
    public void navigateToPage(String pagePath) {
        driver.get(baseUrl + pagePath);
    }

    @Test
    public void TestPageTitle() {
        Assert.assertEquals(departmentPage.GetPageTitle(),"SHRM - Department");
    }
    @Test
    public void TestPageLink(){
        Assert.assertEquals(departmentPage.GetPageLinkText(),"http://localhost:3000/department-list");
    }
    @Test
    public void TestHeadingTag(){
        Assert.assertEquals(departmentPage.GetHeadingTag(),"Department list");
    }
    @Test
    public void TestSearchInput(){
        Assert.assertTrue(departmentPage.CheckSearchInput());
    }
    @Test
    public void TestPlaceholderSearchInput(){
        Assert.assertEquals(departmentPage.CheckPlaceholderSearchInput(),"Enter name");
    }
    @Test
    public void TestButtonAddIsDisplayed(){
        Assert.assertTrue(departmentPage.CheckButtonAdd());
    }

    @Test
    public void TestAttributeButtonAdd(){
        Assert.assertTrue(departmentPage.CheckAttributeButton().contains("ant-btn-primary"));
    }

    @Test
    public void TestOpenModal(){
        departmentPage.ClickAddButton();
        Assert.assertTrue(departmentPage.CheckModalIsDisplayed());
    }

    @Test()
    public void TestBtnCancel() {
        departmentPage.EnsureModalOpened();
        departmentPage.ClickButtonCancel();
        Assert.assertFalse(departmentPage.CheckModalIsDisplayed());
    }
    @Test
    public void TestBtnOKWithNoField(){
        departmentPage.EnsureModalOpened();
        departmentPage.ClickButtonOk();
        Assert.assertTrue(departmentPage.CheckModalIsDisplayed());
    }
    @Test
    public void TestTableIsDisplayed(){
        departmentPage.CheckTableIsDisPlayed();
    }

    @Test
    public void TestColumnName(){
        Assert.assertTrue(departmentPage.CheckColumnName());
    }
}
