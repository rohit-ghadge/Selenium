package BookStation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Your_Order {

    // declared Webdriver as a global
    static WebDriver driver;

    //************************ Launching Browser *********************************************//

    @BeforeTest 
    static void launchBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

   //************************ prerequisite Login *********************************************//
    @Test(priority=1)  
    void LoginTest() 
    {
        // Implicit wait timeout for 3 Minute
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));

        // Navigate to a BookStation website
        driver.get("https://bookstation.vinsys.live/portal/public/login");
        // Maximize current window
        driver.manage().window().maximize();
        // Login
        driver.findElement(By.id("emailid_validation")).sendKeys("shivanibiradar1997@gmail.com");
        driver.findElement(By.id("password_validation")).sendKeys("Shivani@123");
        driver.findElement(By.xpath("//input[@name='login']")).click();
        System.out.println("point 1 hit");


    }
    
    //************************ Navigate to Order Page *********************************************//
    @Test(priority=2)
    void YO_001() 
    {
        // Navigating to Your Orders Page.
        driver.findElement(By.xpath("//a[@class='nav-link order hover_effect_header']")).click();
        String string = driver.findElement(By.xpath("//h5[contains(text(), 'Your Orders')]")).getText();
        
        if(string.equalsIgnoreCase("Your Orders"))
        System.out.println("We are On the Your Orders Page");
        System.out.println("point 2 hit");
    }   
    
  //************************ Search *********************************************//
    @Test(priority=3)
    void YO_002() 
    {
        // Search book By using name,author,publication or category 
        driver.findElement(By.id("serachorder_box_value")).sendKeys("Cal Newport");
        driver.findElement(By.id("serachorder_box_value")).click();
		driver.navigate().back();
        System.out.println("point 3 hit");

    }
    
    //************************ Book Sold By Past 3 Months  *********************************************//
    @Test(priority=4)
    void YO_003() 
    {
        driver.findElement(By.xpath("//a[@class='nav-link order hover_effect_header']")).click();
        // Book Sold By Past 3 Months Dropdown
        Select orderlistmonth = new Select(driver.findElement(By.id("orderlistmonth")));
        orderlistmonth.selectByVisibleText("Past 3 Months");
        System.out.println("point 4 hit");

    }
    
    //************************ Click On All Orders  *********************************************//
    @Test(priority=5)
    void YO_004() 
    {
       // 
        driver.findElement(By.xpath("//a[@class='nav-link order hover_effect_header']")).click();
        System.out.println("point 5 hit");

    }
    
    //************************ Click On Delivered Orders  *********************************************//
    @Test(priority=6)
    void YO_005() 
    {
       // 
        driver.findElement(By.xpath("//a[contains(text(), 'Delivered Orders')]")).click();
        System.out.println("point 6 hit");

    }
    
  //************************ Click On Cancelled & Return Orders  *********************************************//
    @Test(priority=7)
    void YO_006() 
    {
       // 
        driver.findElement(By.xpath("//a[contains(text(), 'Cancelled & Return Orders')]")).click();
        System.out.println("point 7 hit");

    }
    
  //************************ Click On Exchange Particular Book  *********************************************//
    @Test(priority=8)
    void YO_007() 
    {
       // 
        driver.findElement(By.xpath("//a[contains(text(), 'Exchange')]")).click();
        System.out.println("point 8 hit");

    }
    
  //************************ Click On Order Placed  *********************************************//
    @Test(priority=9)
    void YO_008() 
    {
       // 
        driver.findElement(By.xpath("//a[contains(text(), 'All Orders')]")).click();
        System.out.println("point 9 hit");

    }
    
  //************************ Click On Item Details  *********************************************//
    @Test(priority=10)
    void YO_009() 
    {
       // 
        driver.findElement(By.xpath("//a[contains(text(), 'All Orders')]")).click();
        driver.findElement(By.xpath("//div[@id='arriving_3336']//preceding::div[7]")).click();
        System.out.println("point 10 hit");

    }
    
  //************************ Click On Track Item  *********************************************//
    @Test(priority=11)
    void YO_010() 
    {
       // 
        driver.findElement(By.xpath("//a[contains(text(), 'Track')]")).click();
        System.out.println("point 11 hit");

    }
    
    
    //************************ Click On Help  *********************************************//
      @Test(priority=11)
      void YO_011() 
      {
         // 
          driver.findElement(By.xpath("//a[contains(text(), 'Track')]//following-sibling::a[2]")).click();
          System.out.println("point 12 hit");

      }
    @AfterTest   //Closing Browser
    public void closeBrowser()
    {
       //Close the browser.
       driver.close();
    }
}