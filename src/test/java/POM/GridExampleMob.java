package POM;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridExampleMob {
    @Test
    @Parameters("browser")
    public void mailTest(String browser) throws MalformedURLException {
        DesiredCapabilities dr=null;
        if(browser.equals("safari")){
            dr = DesiredCapabilities.safari();
            dr.setBrowserName("safari");
            dr.setPlatform(Platform.ANY);
        }else {
            dr = DesiredCapabilities.iphone();
            dr.setBrowserName("iPhone5s");
            dr.setVersion("12.1");
            dr.setPlatform(Platform.ANY);
        }
        RemoteWebDriver driver=new RemoteWebDriver(new URL("http://10.0.0.8:4444/wd/hub"), dr);
        driver.navigate().to("http://gmail.com");
        driver.findElement(By.name("identifier")) .sendKeys("morajb@gmail.com");
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.id("identifierNext"));
        action.moveToElement(we).build().perform();
        driver.findElement(By.id("identifierNext")).click();
        //driver.findElement(By.xpath("//input[@id='Passwd']")) .sendKeys("password");
        driver.quit();
    }
}