package Presentation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Quetion1 {

    // declared Webdriver as a global
    static WebDriver driver;

    //************************ Launching Browser *********************************************//
    @BeforeTest 
    static void launchBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

   //************************ Go go Gmail and Click on Help **********************************//
    @Test(priority=1)  
    void LoginTest() throws InterruptedException 
    {
        // Implicit wait timeout for 3 Minute
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
        // Navigate to a Gmail.com
        driver.get("https://www.gmail.com");
        // Maximize current window
        driver.manage().window().maximize();
        Thread.sleep(5000);
        // Help
        driver.findElement(By.linkText("Help")).click();


    }
    //************************ Closing Browser *********************************************//
    @AfterTest   //Closing Browser
    public void closeBrowser()
    {
       //Close the current instance.
       driver.close();
       //Close the All instance associated with driver object.
      //driver.quit();
    }
}