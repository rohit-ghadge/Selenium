package ASSIGNMENT;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ASSIGNMENT9
{
	@Test
	void Handling_for_JS_Prompt()
	{
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		// 1: Launch the URL: https://the-internet.herokuapp.com/javascript_alerts		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		// 2: Click on the “Click for JS Prompt”.
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
	   // WebDriverWait wait = new WebDriverWait(driver, 2);
	    Alert alert = driver.switchTo().alert();

	    // 3. Enter the value “Selenium” in edit box
		driver.switchTo().alert().sendKeys("Selenium");
		
		// 4. Click on OK button
		driver.switchTo().alert().accept();

		// 3 Verify that message “You entered: Selenium see on screen
	}
}