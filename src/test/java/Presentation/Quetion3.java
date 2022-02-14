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

public class Quetion3 {

	// declared Webdriver as a global
	static WebDriver driver;

	// ************************ Launching Browser *********************************************//
	@BeforeTest
	static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// ************************assert the title of the web page  **********************************//
	@Test(priority = 1)
	void assert_the_Title_of_the_web_page()
	{
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		// Implicit wait timeout for 3 Minute
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));

		// 1: Launch the URL: Testmate
		driver.get("https://testmate.vinsys.live");
		String Actual = driver.getTitle();
		// Maximize current window
		driver.manage().window().maximize();

		String Expected = "Vinsys ProctoMate The Online Examination Platform";

		if (Actual.equals(Expected)) 
		{
			System.out.println("Test Passed!");
		}
		else 
		{
			System.out.println("Test Failed");
		}
	}

	// ************************ Closing Browser
	// *********************************************//
	@AfterTest // Closing Browser
	public void closeBrowser() {
		// Close the current instance.
		// driver.close();
		// Close the All instance associated with driver object.
		// driver.quit();
	}
}