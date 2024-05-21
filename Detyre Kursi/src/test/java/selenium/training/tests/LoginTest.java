package selenium.training.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.testng.Assert;
import org.testng.annotations.*;
import selenium.training.pages.LoginPageDK;
import selenium.training.pages.RegisterPageDK;
import selenium.training.utils.Credentials;
import selenium.training.utils.Driver;
import selenium.training.utils.customannotations.NotInSuite;
import selenium.training.utils.customannotations.SuiteCheckListener;

@Listeners(SuiteCheckListener.class)
public class LoginTest {

    public LoginPageDK loginPageDK;

    public LoginTest() {
        this.loginPageDK = new LoginPageDK();
    }

    @BeforeMethod
    @BeforeSuite
    @NotInSuite
    public void init()
    {
        Driver.loginOrRegister(1);
    }

    @AfterMethod
    public void logout()
    {
        loginPageDK.logout();
    }

    @Test
    public void login(){
        loginPageDK.navigateToHomePage();
        loginPageDK.clickLoginButton();

        loginPageDK.login(Credentials.EMAIL, Credentials.PASSWORD);

        loginPageDK.submit();

        Assert.assertEquals("Welcome to our store", loginPageDK.successLoginMessage.getText());
    }
}
