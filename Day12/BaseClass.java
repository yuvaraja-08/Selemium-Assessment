package Day1Assigment.Day12;

import java.io.FileInputStream;
import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    WebDriver driver = null;
   @BeforeClass
   public void Bc() {
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
   }
   @AfterClass
   public void Ac() {
	   driver.quit();
	   System.out.println("Close the browser");
	   
   }
}
