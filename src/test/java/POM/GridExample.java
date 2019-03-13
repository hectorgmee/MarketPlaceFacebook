package POM;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridExample {
    @Test
    @Parameters("browser")
    public void mailTest(String browser) throws MalformedURLException {
        DesiredCapabilities dr=null;
        if(browser.equals("chrome")){
            dr=DesiredCapabilities.chrome();
            dr.setBrowserName("chrome");
            dr.setPlatform(Platform.WINDOWS);
        }else{
            dr=DesiredCapabilities.safari();
            dr.setBrowserName("firefox");
            dr.setPlatform(Platform.WINDOWS);
        }
        RemoteWebDriver driver=new RemoteWebDriver(new URL("http://10.0.0.8:5556/wd/hub"), dr);
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