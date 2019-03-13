package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class LoginPageTest {

    WebDriver driver;

    LoginPage objLogin;

    @BeforeTest

    public void setup(){

        driver = new SafariDriver();

        objLogin = new LoginPage(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://facebook.com");

    }

    /**
     * This test go to Facebook
     * login to the application
     * Verify image
     */

    @Test (priority = 0)

    public void test_Login_Page_With_Valid_User(){

        //Login to the app

        Assert.assertTrue(objLogin.loginToFace("mora_jb@hotmail.com","y"));

        System.out.println("Login successfully");
    }

    @AfterTest

    public void teardown(){

        //close all instances

        driver.quit();
    }
}