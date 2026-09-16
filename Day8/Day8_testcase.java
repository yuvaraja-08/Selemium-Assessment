package Day1Assigment.Day8;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Day1Assigment.Day8.Pom.POMAddpage;
import Day1Assigment.Day8.Pom.POMCandidate;
import Day1Assigment.Day8.Pom.POMLogin;
import Day1Assigment.Day8.Pom.POMRecruitment;

public class Day8_testcase {
      public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		
    	//Read the data propertie file
    	FileInputStream fil = new FileInputStream("./src/test/java/Day1Assigment/Day8/HRM.properties");
		Properties p = new Properties();
		p.load(fil);
		 String browser = p.getProperty("browser");
		 String url = p.getProperty("url");
		 String uname = p.getProperty("username");
		 String pass = p.getProperty("pass");
		 
		FileInputStream xl = new FileInputStream("src/test/java/Day1Assigment/Day8/pom.xlsx");
		Workbook wb = WorkbookFactory.create(xl);
		String Fname = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String Mname = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String Lname = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String email = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		String res = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
		String cname = wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();
		
	
		
		 WebDriver driver = null;
		 if(browser.equals("chrome")) {
			 driver =new ChromeDriver();
		 }
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.get(url);
		 
		//PomLogin page
		 POMLogin p1 = new POMLogin(driver);
		 p1.getUname(uname);
		 p1.getPass(pass);
		 p1.getLogin();
		 
		//PomRecruitment
		 
		 POMRecruitment p2 = new POMRecruitment(driver);
		 p2.getRbutton();
		 p2.getAdd();
		 
		 //POMAddpage
		 
		 POMAddpage p3 = new POMAddpage(driver);
		 p3.getFname(Fname);
		 p3.getMname(Mname);
		 p3.getLname(Lname);
		 p3.getVacy();
		 p3.getEmail(email);
		 p3.getCno("6362531028");
		 p3.getResume1(res);		 
		// p3.getDate();
		 Thread.sleep(3000);
		 p3.getSave();
		 Thread.sleep(3000);
		 
		 POMCandidate p4 = new POMCandidate(driver);
		 p4.getCbutton();
		 p4.getJtite();
		 p4.getVac();
		 p4.getHireM();
		 p4.getStatus();
		 p4.getCname(cname);
		 p4.getFrom("2026-01-09");
		 p4.getTo("2026-18-09");
		 
		 
		 try {
			    p4.getRv();
			    System.out.println("No Records Found😥😥😒😒");
			} catch (NoSuchElementException e) {
			    System.out.println("Record Found 😁😁😁");
			}
	}
}
