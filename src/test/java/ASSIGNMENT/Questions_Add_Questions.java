package ASSIGNMENT;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Questions_Add_Questions {

    // declared Webdriver as a global
    static WebDriver driver;

    @BeforeTest // Launching Browser
    static void launchBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test(priority=1) // prerequisite Conditon
    void LoginTest() throws InterruptedException
    {
        // Implicit wait timeout for 3 Minute
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));

        // Navigate to a website
        driver.get("https://testmate.vinsys.live");
        // Maximize current window
        driver.manage().window().maximize();
        // Login
        driver.findElement(By.id("adminUserName")).sendKeys("testadmin@vinsys.com");
        driver.findElement(By.id("adminpassword")).sendKeys("admin@123");
        driver.findElement(By.xpath("//button[text()='LOGIN']")).click();

    }

    @Test(priority=2)
    void Questions_Add_001() throws InterruptedException
    {
        // Click on QUESTONS link Inside Navbar.
        driver.findElement(By.id("questionBankId")).click();
        // Navigating to
        driver.findElement(By.id("add_question")).click();
    }

    @Test(priority=3)
    void Questions_Add_002() throws InterruptedException
    {
        //Select the Category from Dropdown
        Select category = new Select(driver.findElement(By.id("subjectid")));
        category.selectByVisibleText("AWS");
    }

    @Test(priority=4)
    void Questions_Add_004() throws InterruptedException
    {
        // Select the Question Type form Dropdown
        Select questionType = new Select(driver.findElement(By.id("qtype")));
        questionType.selectByVisibleText("Text");
    }

    @Test(priority=5)
    void Questions_Add_005() throws InterruptedException
    {
           // Adding the Question
        driver.findElement(By.xpath("//textarea[@id='newquestion']//preceding::div[1]")).click();
        driver.findElement(By.xpath("//textarea[@id='newquestion']//preceding::div[1]")).sendKeys("Amazon S3 is which type of storage service?");

    }

    @Test(priority=6)
    void Questions_Add_006() throws InterruptedException
    {
        // Answer Type
        driver.findElement(By.id("singleAswerType")).click();
    }

    @Test(priority=7)
    void Questions_Add_007() throws InterruptedException
    {
        // Select the Question Type form Dropdown
        Select answerOptions = new Select(driver.findElement(By.id("TotalOptions")));
        answerOptions.selectByVisibleText("3");

    }

    @Test(priority=8)
    void Questions_Add_008() throws InterruptedException
    {
        // Send Option A
        driver.findElement(By.xpath("//textarea[@id='optionA']//preceding::div[1]")).click();
        driver.findElement(By.xpath("//textarea[@id='optionA']//preceding::div[1]")).sendKeys("AnswerA");

    }

    @Test(priority=9)
    void Questions_Add_009() throws InterruptedException
    {
        // Send Option B
        driver.findElement(By.xpath("//textarea[@id='optionB']//preceding::div[1]")).click();
        driver.findElement(By.xpath("//textarea[@id='optionB']//preceding::div[1]")).sendKeys("AnswerB");
    }

    @Test(priority=10)
    void Questions_Add_010() throws InterruptedException
    {
           // Send Option C
        driver.findElement(By.xpath("//textarea[@id='optionC']//preceding::div[1]")).click();
        driver.findElement(By.xpath("//textarea[@id='optionC']//preceding::div[1]")).sendKeys("AnswerC");
    }

    @Test(priority=11)
    void Questions_Add_011() throws InterruptedException
    {
           // Select the correct answer
        Select correctAnswer = new Select(driver.findElement(By.id("CorrectAnswer")));
        correctAnswer.selectByVisibleText("B");
    }

    @Test(priority=12)
    void Questions_Add_012() throws InterruptedException
    {
        // show optoin as
        driver.findElement(By.id("MCQRadio")).click();

    }

    @Test(priority=13)
    void Questions_Add_013() throws InterruptedException
    {
        // Send Option Hint
        driver.findElement(By.xpath("//textarea[@id='questionHint']//preceding::div[1]")).click();
        driver.findElement(By.xpath("//textarea[@id='questionHint']//preceding::div[1]")).sendKeys("Hint");

    }

    @Test(priority=14)
    void Questions_Add_014() throws InterruptedException
    {
        // Send Option Description
        driver.findElement(By.xpath("//textarea[@id='questiondescription']//preceding::div[1]")).click();
        driver.findElement(By.xpath("//textarea[@id='questiondescription']//preceding::div[1]")).sendKeys("Decription");

    }

    @Test(priority=15)
    void Questions_Add_015() throws InterruptedException
    {
          // Click on Save Question Button
            driver.findElement(By.xpath("//button[contains(text(), 'Save Question')]")).click();
    }

    @AfterTest   //Closing Browser
    public void closeBrowser()
    {
       //Close the browser.
       //driver.close();
    }
}