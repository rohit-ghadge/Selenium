package ASSIGNMENT;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ASSIGNMENT7 {

	@Test
	void SwitchToFrame() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// 1: Launch the URL: https://netbanking.hdfcbank.com/netbanking/
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		
		//implicit wait is global wait 
		// it applied to all element which driver interacting
		driver.manage().timeouts().implicitlyWait(Duration.ofDays(3));
	      //2. grabbing the first frame with the help of index
	      driver.switchTo().frame(0);
	      //2.  enter the Customer ID/ User ID
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("100");	
		// 3: Click on Continue button
		driver.findElement(By.xpath("//a[@text()='CONTINUE']")).click();
		// 4. Verify that entered value in textbox check manually
		//4: Quit the Browser.
		  driver.close();

		
		
	}
}
