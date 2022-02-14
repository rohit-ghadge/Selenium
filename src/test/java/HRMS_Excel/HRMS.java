package HRMS_Excel;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMS 
{

	WebDriver driver;
	SoftAssert Assert = new SoftAssert();

	 //******  launchBrowser **********
	@BeforeTest
	public void launchBrowser() 
	{
		WebDriverManager.chromedriver().setup();
		// initializing driver variable using ChromeDriver
		driver = new ChromeDriver();
		// launching vinsys.live on the browser	
		driver.get("https://hrms.vinsys.live/Login");
		// maximized the browser window
		driver.manage().window().maximize();
		// Set the implicit wait of 21 millisecond
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(21));
	}

	 //******  Login using csv file as a Data Provider **********	
	@Test
	public void Login_TC_01() throws IOException, InterruptedException
	{
		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(50000));
		Reader reader;
		String SAMPLE_CSV_FILE_PATH = null;
		
		try 
		{
			SAMPLE_CSV_FILE_PATH = "/home/sunbeam/Downloads/HRMS_Data.csv";
			// read the CSV file
			reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
		} 
		catch (Exception e) 
		{
			throw new IOException("Failed to fully read " + SAMPLE_CSV_FILE_PATH, e);
		}
		
		// parse the file into csv values
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

		for (CSVRecord csvRecord : csvParser) 
		{
			// Accessing Values by Column Index
			String Email     = csvRecord.get(0);
			String Password  = csvRecord.get(1);
			String FullName  = csvRecord.get(2);
			
			// skip Column Name Row
			if (Email.equalsIgnoreCase("Email"))	continue;
			
			driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(Email);
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(Password);
			driver.findElement(By.xpath("//button[text()='Sign In']")).click();
			
			// explicit wait - check that an Dashboard is present on the DOM of a page and visible.
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='btn-group btn-breadcrumb']/a[2]")));


			// Assertion for Dashboard After Login page
			WebElement webelement = driver.findElement(By.xpath("//div[@class='btn-group btn-breadcrumb']/a[2]"));
			String actual   = webelement.getText();
			String expected = "Dashboard";
			Assert.assertEquals(actual, expected);


			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='btn-group btn-breadcrumb']/a[2]")));
			
		      driver.findElement(By.xpath("//body/app-root/div[@class='wrapper']/aside[@class='main-sidebar']/app-sidebar/section[@class='sidebar']/ul[@class='sidebar-menu tree']/li[contains(@class,'treeview')]/a[1]")).click();

		      Thread.sleep(1000);
		      driver.findElement(By.xpath("//a[normalize-space()='My Leave']")).click();
		      
		      // Assertion for My Leave Dashboard
			  wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//label[text()='Apply/Cancel Leave']")));
		      Thread.sleep(20000);

			  driver.findElement(By.xpath("//a[@data-target='#modal-default']")).click();

			  Thread.sleep(1000);
		      WebElement element = driver.findElement(By.xpath("//select[@name='hrLeaveApplyLeave_masterLeaveType']"));
		      Select s = new Select (element);
              s.selectByVisibleText("Compensatory Leave	");
              
              driver.findElement(By.xpath("//my-date-picker[@name='hrLeaveApplyLeave_applyLeaveFromDate']//span[@class='mydpicon icon-mydpcalendar']")).click();
			  Thread.sleep(1000);

    	      String month1 = driver.findElement(By.xpath("//button[@class='headerlabelbtn monthlabel']")).getText();
    	      String year1  = driver.findElement(By.xpath("//button[@class='headerlabelbtn yearlabel']")).getText();
    	      	    
    	    // From Date 
    	    String month ="Nov";
    	    String year  ="2021";
    	    String select_day="11";
    	    
    	    // click on next button until given month and year true
            while(!(month1.equals(month)&&year1.equals(year)))
            {
            	driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();
      	        month1 = driver.findElement(By.xpath("//button[@class='headerlabelbtn monthlabel']")).getText();
      	        year1  = driver.findElement(By.xpath("//button[@class='headerlabelbtn yearlabel']")).getText();
            }
            
            // Save All Date of month inside List
            List<WebElement> days = driver.findElements(By.xpath("//div[@class='datevalue currmonth']"));

            for (WebElement d:days)
            { 
               if(d.getText().equals(select_day))
               {
            	 // Click on given date
                 d.click();
                 Thread.sleep(10000);
                 break;
               }
            }
			// Logout 
			driver.findElement(By.xpath("//img[@class='user-image']")).click();
			driver.findElement(By.xpath("//button[text()='Sign out']")).click();
			
			// explicit wait - click OK after Logout
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OK']")));
			driver.findElement(By.xpath("//button[text()='OK']")).click();
			
		}	
	}
	
	 
	 
	/*
	 * //****** Apply Leave Comprnsatory leave **********
	 * 
	 * @Test public void ApplyLeave_TC_02() {
	 * 
	 * }
	 */
	 //******  Terminate the browser  **********
    @AfterMethod
    public void closeBrowser() {

       // closes all the browser windows opened by web driver
       // driver.quit();
    }

}
