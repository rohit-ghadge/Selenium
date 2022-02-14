package Presentation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Quetion4 {

	// declared Webdriver as a global
	static WebDriver driver;

	// ************************ Launching Browser *********************************************//
	@BeforeTest
	static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// ************************ Mouse Hover  **********************************//
	@Test(priority = 1)
	void assert_the_Title_of_the_web_page() throws InterruptedException
	{

		// Implicit wait timeout for 3 Minute
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
        String baseUrl = "http://demo.guru99.com/test/newtours/";

		 driver.get(baseUrl);           
         WebElement link_Home = driver.findElement(By.linkText("Home"));
     
         // moveToElement - Moves the mouse to the middle of the element.
         Actions builder = new Actions(driver);
         Action mouseOverHome = builder
                 .moveToElement(link_Home)
                 .build();
          
         mouseOverHome.perform();        
    	
				
 
	}

	// ************************ Closing Browser*********************************************//
	@AfterTest // Closing Browser
	public void closeBrowser() {
		// Close the current instance.
		// driver.close();
		// Close the All instance associated with driver object.
		// driver.quit();
	}
}