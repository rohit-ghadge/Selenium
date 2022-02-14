package Presentation;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Quetion2 {

    // declared Webdriver as a global
    static WebDriver driver;

    //************************ Launching Browser *********************************************//
    @BeforeTest 
    static void launchBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

   //************************ Web Based Popup **********************************//
    @Test(priority=1)  
    void Identifying_and_Switching_to_a_pop_up_window()
	{
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
	       // Implicit wait timeout for 3 Minute
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
        
		// 1: Launch the URL: https://the-internet.herokuapp.com/javascript_alerts
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		// 2: Click on the “Click for JS Alert”.
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
	    Alert alert = driver.switchTo().alert();
		// 3. Click on OK button  

	    // capture alert message and print on console
        System.out.println(driver.switchTo().alert().getText());

	    driver.switchTo().alert().accept();
	   //  3: Verify that message “You successfully clicked an alert
	}
    
    //************************ Closing Browser *********************************************//
    @AfterTest   //Closing Browser
    public void closeBrowser()
    {
       //Close the current instance.
     //  driver.close();
       //Close the All instance associated with driver object.
      // driver.quit();
    }
}