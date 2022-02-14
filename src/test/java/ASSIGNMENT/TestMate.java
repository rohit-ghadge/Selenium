package ASSIGNMENT;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMate {

    WebDriver driver;

    @BeforeSuite
    static void launchBrowser() 
    {
        WebDriverManager.chromedriver().setup();
    }
    
	@Test
	void xPathPractice() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();

		 driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofDays(3));
		
		driver.get("https://testmate.vinsys.live");
		driver.manage().window().maximize(); 
		driver.findElement(By.id("adminUserName")).sendKeys("testadmin@vinsys.com");
		driver.findElement(By.id("adminpassword")).sendKeys("admin@123");
	    driver.findElement(By.xpath("//button[text()='LOGIN']")).click();

	    driver.findElement(By.id("questionBankId")).click();
		driver.findElement(By.id("add_question")).click();
		
		Select category = new Select(driver.findElement(By.id("subjectid")));
		if(category.isMultiple())
		{
			category.selectByVisibleText("AWS");
		}

	}
	@AfterSuite
	public void terminateBrowser()
	{
	   //Close the browser.
	   driver.close();
	}
}