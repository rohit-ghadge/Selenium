package ASSIGNMENT;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ASSIGNMENT1 {
	
    WebDriver driver;

    @BeforeTest
    static void launchBrowser() 
    {
        WebDriverManager.chromedriver().setup();
    }

	@Test
	void Check_the_title_of_the_webpage()
	{
		driver = new ChromeDriver();
		
		//implicit wait is global wait 
		// it applied to all element which driver interacting
		driver.manage().timeouts().implicitlyWait(Duration.ofDays(3));
		
		// 1: Launch the URL: https://www.google.com
		driver.get("https://www.google.com");
		
		// 1. Maximize current window
		driver.manage().window().maximize();
		
		// 3: Using “get title”, we can print the title of the webpage in console.
		String title = driver.getTitle();
		System.out.println("Your page title Is : "+title);
		// make sure navigating to correct page.
		Assert.assertEquals("Google",driver.getTitle());
	}
	
	@AfterTest
	public void terminateBrowser()
	{
	   // 4: Close the browser.
	   driver.close();
	}
	
}