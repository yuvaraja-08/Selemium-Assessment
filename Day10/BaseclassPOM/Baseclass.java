package Day1Assigment.Day10.BaseclassPOM;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import net.bytebuddy.asm.MemberSubstitution.Current;

public class Baseclass {
    
	
	
	protected WebDriver driver = null;
	
	@BeforeSuite
	public void Bs() {
		System.out.println("open Database connectivity ");
	}
	@BeforeTest
	public void Bf() {
		System.out.println("Pre conditions");
	}
	@BeforeClass()
	public void Bc() throws IOException {
		FileInputStream fil = new FileInputStream("src/main/java/BaseClassUtility/sause.properties");
		Properties p = new Properties();
		p.load(fil);
		String browser = p.getProperty("browser");
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("Browser is open");
		
	}
	@BeforeMethod
	public void Bm() {
		System.out.println("Login");
	}
	@AfterMethod
	public void Am() {
		System.out.println("Logout");
	}
	@AfterClass
	public void Ac(){
		 driver.quit();
		System.out.println("quite");
	}
	@AfterTest
	public void At() {
		System.out.println("Post condition");
	}
	@AfterSuite
	public void As() {
		System.out.println("Close database connectivity");
	}
	
000	.0

}
