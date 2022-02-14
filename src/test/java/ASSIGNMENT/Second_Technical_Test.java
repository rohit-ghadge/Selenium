
package ASSIGNMENT;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Second_Technical_Test {
	
    WebDriver driver;

    public class apptmart {
    	WebDriver driver;
    	
      @Test
    	public void shopping() throws InterruptedException
    	{
    		WebDriverManager.chromedriver().setup();
    		driver= new ChromeDriver();
    		driver.get("https://qa.apptmart.com:8083");
    		driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    		driver.findElement(By.xpath("//div[@class='text-value ng-star-inserted']")).click();
    		driver.findElement(By.cssSelector("input[inputmode='numeric']")).sendKeys("9860608724");
    		//driver.findElement(By.xpath("//input[@id='mat-input-132']")).sendKeys("9860608724");;
    		driver.findElement(By.xpath("//span[text()='Send OTP']")).click();
    		
    		Thread.sleep(3000);
    		driver.findElement(By.xpath("//div[@class='wrapper ng-star-inserted'] //input[@class='otp-input ng-untouched ng-pristine ng-valid ng-star-inserted'][1]")).sendKeys("1");
    		
    		Thread.sleep(3000);
    		driver.findElement(By.xpath("//div[@class='wrapper ng-star-inserted'] //input[@class='otp-input ng-untouched ng-pristine ng-valid ng-star-inserted'][2]")).sendKeys("2");
    	
    		Thread.sleep(3000);
    		driver.findElement(By.xpath("//div[@class='wrapper ng-star-inserted'] //input[@class='otp-input ng-untouched ng-pristine ng-valid ng-star-inserted'][3]")).sendKeys("3");
    	
    		Thread.sleep(3000);
    		driver.findElement(By.xpath("//div[@class='wrapper ng-star-inserted'] //input[@class='otp-input ng-untouched ng-pristine ng-valid ng-star-inserted'][4]")).sendKeys("4");
    	
    		Thread.sleep(3000);
    		driver.findElement(By.xpath("//div[@class='wrapper ng-star-inserted'] //input[@class='otp-input ng-untouched ng-pristine ng-valid ng-star-inserted'][5]")).sendKeys("5");
    	
      		Thread.sleep(3000);
    		driver.findElement(By.xpath("//div[@class='wrapper ng-star-inserted'] //input[@class='otp-input ng-untouched ng-pristine ng-valid ng-star-inserted'][6]")).sendKeys("6");
    
    	}
    }
}