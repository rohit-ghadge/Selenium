package ASSIGNMENT;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJetAutomation {

	@Test
	void xPathPractice() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofDays(3));
		
		 driver.get("https://book.spicejet.com/search.aspx");
		 driver.findElement(By.xpath("//input[@id='ControlGroupSearchView_AvailabilitySearchInputSearchView_RoundTrip']")).click();
	     driver.findElement(By.cssSelector("#ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT")).click();
	      driver.findElement(By.xpath("//a[text()=' Pune (PNQ)']")).click();
	      driver.findElement(By.xpath("//div[@id='glsControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTNR'] //a[text()=' Goa (GOI)']")).click();	    
        
	      String month1 = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first'] //span[@class='ui-datepicker-month']")).getText();
	      String year1 = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first'] //span[@class='ui-datepicker-year']")).getText();
	      	    
	      
        while(!(month1.equals("November")&&year1.equals("2021")))
        {
        	driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last'] //span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
  	        month1 = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first'] //span[@class='ui-datepicker-month']")).getText();
  	        year1 = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first'] //span[@class='ui-datepicker-year']")).getText();
        }
	    driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first'] //a[text()='21']")).click();
    	System.out.println("Date is : "+month1+"/"+year1);

    	//Return
	    driver.findElement(By.xpath("//input[@id='custom_date_picker_id_2']")).click();
	    String month2 = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first'] //span[@class='ui-datepicker-month']")).getText();
	    System.out.println("month2 : "+month2);
	    String year2 = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first'] //span[@class='ui-datepicker-year']")).getText();
        System.out.println("year : "+year2 );
        
        while(!(month2.equals("May")&&year2.equals("2022")))
        {
        	driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last'] //span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
    	    month2 = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first'] //span[@class='ui-datepicker-month']")).getText();
    	    year2 = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first'] //span[@class='ui-datepicker-year']")).getText();
        }
        
    	driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first'] //a[text()='7']")).click();
    	System.out.println("Date is : "+month2+"/"+year2);

	}
}