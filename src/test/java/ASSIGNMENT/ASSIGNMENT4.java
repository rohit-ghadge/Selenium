package ASSIGNMENT;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ASSIGNMENT4 {
	
	/*
	 * @Test void DragAndDrop() throws IOException, InterruptedException {
	 * WebDriverManager.chromedriver().setup();
	 * 
	 * ChromeDriver driver = new ChromeDriver();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofDays(3)); // Open
	 * webpage driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
	 * 
	 * // Add 5 seconds wait Thread.sleep(5000);
	 * System.out.println("webpage loaded"); // Create object of actions class
	 * Actions act=new Actions(driver);
	 * 
	 * int size = driver.findElements(By.tagName("iframe")).size();
	 * System.out.println(size); driver.switchTo().frame(1);
	 * 
	 * // find element which we need to drag WebElement
	 * source=driver.findElement(By.xpath("//span[text()='Thrillers']"));
	 * System.out.println("Reached Here");
	 * 
	 * WebElement
	 * destination=driver.findElement(By.xpath("//span[text()='History']"));
	 * 
	 * System.out.println("Reached Here"); // it will click and hold the triller box
	 * and move to element will move cursor to history in another box and then
	 * release
	 * act.clickAndHold(source).pause(2000).moveToElement(destination).release().
	 * build().perform();
	 * 
	 * }
	 */
	
	@Test
	void DragAndDrop() throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofDays(3));
		// Open webpage
		
		driver.get("http://jqueryui.com/droppable");
		  driver.manage().window().maximize();
		  
		  Actions act = new Actions(driver);

		  // Script for dragging an element and dropping it in another place
		  WebElement iFrame = driver.findElement(By.tagName("iframe"));

		  System.out.println(iFrame.getSize());
		  
		  driver.switchTo().frame(iFrame);
		  
		  WebElement From = driver.findElement(By.id("draggable"));
		  System.out.println(From.getLocation());
		  
		  WebElement To = driver.findElement(By.id("droppable"));
		  System.out.println(To.getLocation());
		  
		  act.dragAndDrop(From, To).build().perform();
	}
	
}
		