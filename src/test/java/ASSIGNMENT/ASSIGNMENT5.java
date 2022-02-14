package ASSIGNMENT;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ASSIGNMENT5 {
	
	// 1: Minimizing/ maximizing the browser window
	@Test
	void MaximiseWindow() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Navigate to a website
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		//implicit wait is global wait 
		// it applied to all element which driver interacting
		driver.manage().timeouts().implicitlyWait(Duration.ofDays(3));
		
		
		//Maximize current window
		driver.manage().window().maximize();

		//Delay execution for 5 seconds to view the maximize operation
		Thread.sleep(5000);

		//Close the browser
		driver.quit();
		//Pending
	}
	
	// 2: Navigating backwards/forward in the browser
	@Test
	void NavidateBackwordForword() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofDays(3));

		// Navigate to a website
		driver.get("https://www.google.com");

	    driver.findElement(By.xpath("//a[text()='Gmail']")).click();

		//Navigating back in browser 
		driver.navigate().back();

		//Used for demo purpose only, not required
		Thread.sleep(4000);

		//Navigating forward in browser 
		driver.navigate().forward();
		
		driver.quit();

	}
	
	// 3: Implicit wait for a condition
	@Test
	void ImplicitWait() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// 2: Wait for some time using “Implicit” wait for the page to load.
		driver.manage().timeouts().implicitlyWait(Duration.ofDays(3));

		// Navigate to a website
		driver.get("https://www.google.com");

	    driver.findElement(By.xpath("//a[text()='Gmail']")).click();

		// 4.  Wait for some time using “Implicit” wait for the page to load.
		driver.manage().timeouts().implicitlyWait(Duration.ofDays(3));

		driver.quit();
         
	}
	
	// 4: Explicit wait for a condition
	@AfterTest
	void ExplicitWait() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// 2: Wait for some time using “Implicit” wait for the page to load.
		driver.manage().timeouts().implicitlyWait(Duration.ofDays(3));

		// Navigate to a website
		driver.get("https://www.google.com");
		WebElement elem = driver.findElement(By.name("q"));//finding the web element using name locator
		elem.sendKeys(new String[]{"selenium"});
		elem.submit();
		
		driver.findElement(By.xpath("//h3[text()='Selenium']")).click();

		
		String Txt = driver.findElement(By.xpath("//h2[text()='Getting Started']")).getText();
		System.out.println(Txt);

		driver.quit();

	}
}
