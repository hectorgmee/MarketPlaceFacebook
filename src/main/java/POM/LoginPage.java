package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.utilities.Assert;


public class LoginPage {

    WebDriver driver;

    @FindBy (id = "email")

    WebElement userFacebook;

    @FindBy(id = "pass")

    WebElement passFacebook;

    @FindBy (id = "loginbutton")

    WebElement logbtnFace;

    public LoginPage (WebDriver driver){

        this.driver = driver;

        //This initialize all webelements

        PageFactory.initElements(driver, this);
    }

    //Set username

    public void setUserFacebook(String strUserName){

        userFacebook.sendKeys(strUserName);
    }

    //Set Password

    public void setPassFacebook (String strPassword){

        passFacebook.sendKeys(strPassword);
    }

    public boolean clickLogin(){

        logbtnFace.click();

        return true;
    }

    public  boolean loginToFace (String strUserName, String strPassword){

        //Fill user name

        this.setUserFacebook(strUserName);

        //Fill password

        this.setPassFacebook(strPassword);

        //Click login button

        return this.clickLogin();
    }


}
