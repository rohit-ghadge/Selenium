package Presentation;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Quetion5 {

	// declared Webdriver as a global
	static WebDriver driver;

	// ************************ Launching Browser
	// *********************************************//
	@BeforeTest
	static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// ************************ **********************************//
	@Test
	public void test() throws InterruptedException {
		// Start application
				driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
		 
				// Click on timer button to start
				driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		 
				// Create object of WebDriverWait class and it will wait max of 20 seconds.
				// By default it will accepts in Seconds
			     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 
				// Here we will wait until element is not visible, if element is visible then it will return web element
				// or else it will throw exception
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Selenium']")));
		 
				// if element found then we will use- In this example I just called isDisplayed method
				boolean status = element.isDisplayed();
		 
				// if else condition
				if (status) {
					System.out.println("===== WebDriver is visible======");
				} else {
					System.out.println("===== WebDriver is not visible======");
				}
	}

	// ************************ Closing
	// Browser*********************************************//
	@AfterTest // Closing Browser
	public void closeBrowser() {
		// Close the current instance.
		// driver.close();
	}
}