package testcases;

import config.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
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

    @Parameters("pagePath")
    @BeforeMethod
    public void navigateToPage(String pagePath) {
        driver.get(baseUrl + pagePath);
    }

//    @Test
//    public void TestPageTitle() {
//        Assert.assertEquals(loginPage.GetPageTitle(),"SHRM - Login");
//    }
//    @Test
//    public void TestPageLink(){
//        Assert.assertEquals(loginPage.GetPageLinkText(),"http://localhost:3000/login");
//    }
//    @Test
//    public void TestHeadingTag(){
//        Assert.assertEquals(loginPage.GetHeadingTag(),"Login");
//    }
//    @Test
//    public void TestLabelEmail(){
//        Assert.assertEquals(loginPage.GetLabel_Email(),"Email");
//    }
//    @Test
//    public void TestLabelPassword(){
//        Assert.assertEquals(loginPage.GetLabel_Password(),"Password");
//    }
//    @Test
//    public void TestRequiredCLassLabelEmail(){
//        Assert.assertTrue(loginPage.GetLabelCLassEmail().contains("required"));
//    }
//    @Test
//    public void TestRequiredCLassPassword(){
//        Assert.assertTrue(loginPage.GetLabelCLassPassword().contains("required"));
//    }
//    @Test
//    public void TestPlaceholderEmail(){
//        Assert.assertEquals(loginPage.GetPlaceholderEmail(),"Enter email ...");
//    }
//    @Test
//    public void TestPlaceholderPassword(){
//        Assert.assertEquals(loginPage.GetPlaceholderPassword(),"Enter password ...");
//    }
//    @Test
//    public void TestTextForgotPassword(){
//        Assert.assertEquals(loginPage.GetTextForgotPassword(),"Forgot your password");
//    }
//    @Test
//    public void TestButtonLoginIsDisplayed(){
//        Assert.assertTrue(loginPage.CheckButtonLoginIsDisplayed());
//    }
//    @Test
//    public void TestButtonLoginText() {
//        Assert.assertEquals(loginPage.CheckButtonLoginText(), "Login");
//    }
//    @Test
//    public void TestErrorMessageForEmptyEmail() {
//        Assert.assertTrue(loginPage.CheckErrorMessageForEmptyEmail());
//    }
//    @Test
//    public void TestErrorMessageForEmptyPassword(){
//        Assert.assertTrue(loginPage.CheckErrorMessageForEmptyPassword());
//    }
//    @Test
//    public void TestPasswordIsHiddenByDefault(){
//        Assert.assertTrue(loginPage.CheckPasswordType());
//        Assert.assertTrue(loginPage.CheckEyeIconClosed());
//    }
//    @Test(dependsOnMethods = "TestPasswordIsHiddenByDefault")
//    public void TestShowPassword(){
//        loginPage.ClickEyeIconClose();
//        Assert.assertFalse(loginPage.CheckPasswordType());
//        Assert.assertTrue(loginPage.CheckEyeIconOpened());
//    }
//    @Test(dependsOnMethods = "TestShowPassword")
//    public void TestHidePasswordAfterClickAgain() throws Exception{
//        Assert.assertTrue(loginPage.CheckPasswordType());
//    }
//    @Test
//    public void TestLoginWithNoField()
//    {
//        loginPage.ClickButtonLogin();
//        Assert.assertTrue(loginPage.CheckErrorMessageEmail());
//        Assert.assertTrue(loginPage.CheckErrorMessagePassword());
//    }
//    @Test
//    public void TestLoginWithNoEmailAndValidPass() throws Exception{
//        loginPage.EnterPassword("Ngudat4102.");
//        loginPage.ClickButtonLogin();
//        Assert.assertTrue(loginPage.CheckErrorMessageEmail());
//    }
//    @Test
//    public void TestLoginWithNoPasswordAndValidEmail(){
//        loginPage.EnterEmail("hongudat");
//        loginPage.ClickButtonLogin();
//        Assert.assertTrue(loginPage.CheckErrorMessagePassword());
//    }
    @Test void TestLoginWithInValidEmailAndInValidPass(){
        loginPage.EnterEmail("invalid@gmail.com");
        loginPage.EnterPassword("invalidpassword");
        loginPage.ClickButtonLogin();
        Assert.assertTrue(loginPage.CheckMessageIsDisplayed());

    }
//    @Test
//    public void TestLoginWithValidEmailAndInValidPass(){
//        loginPage.EnterEmail("hongudat@gmail.com");
//        loginPage.EnterPassword("invalidpassword");
//        loginPage.ClickButtonLogin();
//        Assert.assertTrue(loginPage.CheckMessageIsDisplayed());
//
//    }
//    @Test
//    public void TestLoginWithInValidEmailAndVailPass(){
//        loginPage.EnterEmail("invalid@gmail.com");
//        loginPage.EnterPassword("Ngudat4102.");
//        loginPage.ClickButtonLogin();
//        Assert.assertTrue(loginPage.CheckMessageIsDisplayed());
//    }
//    @Test
//    public void TestLoginWithValidEmailAndVailPass(){}
}
