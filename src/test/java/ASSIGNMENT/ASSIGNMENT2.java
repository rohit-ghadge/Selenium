package ASSIGNMENT;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ASSIGNMENT2 {		
	
		@Test
		void FacebookLogin() throws InterruptedException
		{
			WebDriverManager.chromedriver().setup();

			ChromeDriver driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));

			// 1: Launch the URL: https://www.facebook.com
	        driver.get("https://www.facebook.com");
	        System.out.println("Successfully opened the website");
	        driver.manage().window().maximize();
	        // 2: Click on Email and Password and Pass the Credentials using sendKeys.
	        driver.findElement(By.id("email")).sendKeys("Enter the USERNAME");
	        driver.findElement(By.id("pass")).sendKeys("Enter the PASSWORD");
	        // 3: Click on Login button.
	        driver.findElement(By.id("u_0_r")).click();
	        System.out.println("Successfully logged in");
	       // Thread.sleep(3000);
	        driver.findElement(By.id("userNavigationLabel")).click();
	       // Thread.sleep(2000);
	        driver.findElement(By.partialLinkText("Log out")).click();
	        System.out.println("Successfully logged out");
	        
	        // 4: Quit the browser
			  driver.close();

		}
		
	    
		@Test
		void EnteringandClearText() throws InterruptedException
		{
			WebDriverManager.chromedriver().setup();

			ChromeDriver driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));

			// 1: Launch the URL: htps://www.orangehrms.com
	        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	        
	        Thread.sleep(7000);
	        // 2: Click on Forget your password link
	        driver.findElement(By.xpath("//a[text()='Forgot your password?']")).click();
	        
	        
	        // 3: Enter some text using “Send keys”.
	        driver.findElement(By.id("securityAuthentication_userName")).sendKeys("Enter the USERNAME");

	        Thread.sleep(7000);
	        // 4: Clear the text using “clear” command.
	        driver.findElement(By.xpath("//input[@id='securityAuthentication_userName']")).clear();
	        
			//  driver.close();
	        // 5: Quit the browser.
			  driver.close();

		}
		/*
		 * @Test void Dropdown() throws InterruptedException {
		 * WebDriverManager.chromedriver().setup();
		 * 
		 * ChromeDriver driver = new ChromeDriver();
		 * 
		 * driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
		 * 
		 * // 1: Launch the URL:
		 * driver.get("https://www.testandquiz.com/selenium/testing.html");
		 * 
		 * // 2: select “Database Testing” from the dropdown.
		 * 
		 * // Link not working // driver.close(); // 5: Quit the browser. //
		 * driver.close();
		 * 
		 * }
		 */
	
	
}
