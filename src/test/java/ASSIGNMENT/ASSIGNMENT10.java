package ASSIGNMENT;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ASSIGNMENT10 {

	@Test
	void Capturing_the_Screenshot_of_the_browser() throws IOException
	{
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
	    //	1: Launch the URL: https://opensource-demo.orangehrmlive.com/index.php/auth/login
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		//  2: Click on Forget your password link
		driver.findElement(By.xpath("//a[@href='/index.php/auth/requestPasswordResetCode']")).click();

		// 3: Enter some text using “Send keys”.
		WebElement resetPassword = driver.findElement(By.id("securityAuthentication_userName"));
		resetPassword.sendKeys("Rohit@gmail.com");

		// 4: Take the screenshot of the browser and save it in a path (Screenshot folder) .
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(".\\Screenshot\\Screen.png"));
		System.out.println("the Screenshot is taken");
		
		// 5: Quit the browser.
		driver.quit();
		
	}
}