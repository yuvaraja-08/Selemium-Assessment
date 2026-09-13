package Day1Assigment.day6;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Day6_testcase {
    public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		//properices for Comman data
    	ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
    	FileInputStream fil = new FileInputStream("./src/test/java/Day6/HRM.properties");
    	Properties p = new Properties();
    	p.load(fil);
    	
    	String b = p.getProperty("browser");
    	String u = p.getProperty("url");
    	String un = p.getProperty("username");
    	String pass = p.getProperty("password");
    	
    	System.out.println(b+ " - " +u+" - "+un+ " - "+pass);
    	
    	
    	WebDriver driver = null;
    	if(b.equals("chrome")) {
    		driver = new ChromeDriver();
    	}
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	//Login
    	driver.get(u);
    	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(un,Keys.TAB,pass,Keys.ENTER);
    	//click PMI
    	driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")).click();
    	driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
    	
    	//testscript data in excel file
    	
    	FileInputStream ex = new FileInputStream("./src/test/java/Day6/testScriptDay6.xlsx");
    	Workbook wb = WorkbookFactory.create(ex);
    	String Fname = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
    	String Mname = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
    	String Lname = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
    	String uname = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
    	String pa = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
    	String empname = wb.getSheet("Sheet1").getRow(4).getCell(1).getStringCellValue();
  
    	System.out.println(Fname+ " - " +Mname+ " - " +Lname+ " - "+uname+" - "+pa);
    	
    	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(Fname,Keys.TAB,Mname,Keys.TAB,Lname);
    	driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")).click();
    	driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys(uname);
    	driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys(pa);
    	driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(pa);
    	
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//button[@type='submit']")).click();
    	
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']")).click();
    	
    	driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(uname);
//    	driver.findElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]")).click();
//    	driver.findElement(By.xpath("//div[@role='option']//span[text()='ESS']")).click();
        WebElement emp = driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]"));
        emp.sendKeys(empname);
        Thread.sleep(3000);
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);

        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        
        
//        driver.findElement(By.xpath("//label[text()='Status']/following::div[contains(@class,'oxd-select-text')][1]")).click();
//        driver.findElement(By.xpath("//div[@role='option']//span[text()='Enabled']")).click();
    	driver.findElement(By.xpath("//button[@type='submit']")).click();
    	
    	
    	
    	WebElement record = driver.findElement(By.xpath("//div[contains(text(),'pavan1')]"));
    	if(record.isDisplayed()) {
    		System.out.println("Record is Displayed");
    	}else {
    		System.out.println("Record is not displayed");
    	}
    	Thread.sleep(3000);
    	driver.quit();
    	
	}
}
