package HRMS;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMS_Login extends HRMS_DataProvider {

    WebDriver driver;

 //******  launchBrowser **********
    @BeforeTest
    public void launchBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Implicit wait timeout for 21 Second
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50000));
        driver.get("https://shambhavihrms.vinsys.com/Login");
        driver.manage().window().maximize();

    }
    //******  Login Page **********

    @Test(priority = 1, dataProvider = "LoginScenario")
    public void Login_TC_02(String username, String password, String expresult) {
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        
        // Assert with Title
        String ExpRes = driver.getTitle();
        Assert.assertEquals(ExpRes, expresult);
        
        // Assert for email address we pass and email Address on dashboard are same.
        ExpRes=driver.findElement(By.xpath("//label[contains(text(),'@vinsys.com')]")).getText();
        Assert.assertEquals(ExpRes, username);
        driver.findElement(By.xpath("//div[@class='navbar-custom-menu']")).click();
        driver.findElement(By.xpath("//button[text()='Sign out']")).click();
        driver.findElement(By.xpath("//button[text()='OK']")).click();
        
    }

    @Test(priority = 2, dataProvider = "LoginScenario2")
    public void Login_TC_03(String username, String password, String expresult) {
    	
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();

        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        driver.findElement(By.xpath("//button[text()='OK']")).click();
        
       // WebElement Expected = driver.findElement(By.xpath("//p[text()='Incorrect username or password']"));
       // String actualResult = Expected.getText();
      //  Assert.assertEquals(expresult, actualResult);


    }
    //******  Terminate the browser  **********
     @AfterMethod
     public void closeBrowser() {

    // driver.quit();
     }

}