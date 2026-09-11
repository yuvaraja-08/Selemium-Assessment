package Day1Assigment.Day1.Day5;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day5_testcase2 {
    public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fil = new FileInputStream("./src/test/resources/OrangeORM.xlsx");
		Workbook wb=WorkbookFactory.create(fil);
		String browser = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String url = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String username = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String pass = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		
		
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(pass);
		
		
		WebDriver driver = null;
		if(browser.equals("chrome")) {
			 driver= new ChromeDriver();
		 }
		
		
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
		 
		 driver.get(url);
		 driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
		 driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 Thread.sleep(3000);
		 driver.quit();
		 
		//Testcase 2 
//
//		 1.Navigate to orange Hrm application
//		 2.Enter the username password and click on login buuton
//		 by redaing the data from excel file.
				
    }
}
