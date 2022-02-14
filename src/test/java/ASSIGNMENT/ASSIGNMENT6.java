package ASSIGNMENT;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ASSIGNMENT6 {

	public class Practice {

	@Test
	void Excel() throws InterruptedException, IOException {
		
		HSSFWorkbook workbook;
		HSSFSheet sheet;
		HSSFCell cell;
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//implicit wait is global wait 
		// it applied to all element which driver interacting
		driver.manage().timeouts().implicitlyWait(Duration.ofDays(3));
		

		driver.get("http://www.facebook.com/"); 

		driver.manage().window().maximize(); 


		// Import excel sheet. 

		File src=new File("//home//sunbeam//Downloads/login.xls"); 

		// Load the file. 

		FileInputStream finput = new FileInputStream(src); 

		// Load the workbook. 

		workbook = new HSSFWorkbook(finput); 

		// Load the sheet in which data is stored. 

		sheet= workbook.getSheetAt(0); 

		for(int i=1; i<=sheet.getLastRowNum(); i++) { 

		// Import data for Email. 

		cell = sheet.getRow(i).getCell(1); 

		cell.setCellType(Cell.CELL_TYPE_STRING); 

		driver.findElement(By.id("email")).sendKeys(cell.getStringCellValue()); 

		// Import data for password. 

		cell = sheet.getRow(i).getCell(2); 

		cell.setCellType(Cell.CELL_TYPE_STRING); 

		driver.findElement(By.id("pass")).sendKeys(cell.getStringCellValue()); 

		} 
	}
	}

}
