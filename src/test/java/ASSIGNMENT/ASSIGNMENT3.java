package ASSIGNMENT;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ASSIGNMENT3 {

	/*
	@Test
	void Selecting_a_multiple_rows_in_a_table() {
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofDays(3));

		// 1: Launch the URL:  
		driver.get("https://www.igniteui.com.grid/selection");
		
		// URL not working
		
		List items = driver.findElements(By.id(“id”));
		Actions actions = new Actions(driver);
		actions.click(items.get(0)).keyDown(Keys.CONTROL)
		.click(items.get(2)).keyUp(Keys.CONTROL).build().perform();
		
		
	}*/
	
	@Test
	void Selecting_a_multiple_rows_in_a_table() {
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofDays(3));
	String baseUrl = "http://jqueryui.com/selectable/";
	driver.get(baseUrl);
	driver.switchTo().frame(0);
	// 2: Click on the table which you want select the rows.
	List<WebElement> list=driver.findElements(By.cssSelector("ol#selectable *"));
	Actions act=new Actions(driver);

	// 3: Select the first row and hold the “Ctrl” key in keyboard and select the remaining rows.
	// 4: Perform this action till all the rows get selected and release the “Ctrl” key from the keyboard.
	act.keyDown(Keys.CONTROL)
    .click(list.get(0))
    .click(list.get(1))
    .click(list.get(2))
    .click(list.get(3))
    .click(list.get(4))
    .click(list.get(5))
    .click(list.get(6))
    .keyUp(Keys.CONTROL)
    .build()
    .perform();

	// 5: Quit the browser.
	driver.quit();

    }
}