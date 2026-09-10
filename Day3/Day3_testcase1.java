package Day1Assigment.Day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Day3_testcase1 {
      public static void main(String[] args) throws InterruptedException {
    	  //notification disabled 
    	 ChromeOptions options = new ChromeOptions();
    	 options.addArguments("--disable-notifications");
    	WebDriver driver = new ChromeDriver(options);
  		driver.manage().window().maximize();
  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  		driver.get("https://www.easemytrip.com/");
  		//-------------------------------from----------------------------------
  		driver.findElement(By.xpath("//input[@id='FromSector_show']")).click();
  		driver.findElement(By.xpath("//li[@onclick=\"autoSelectMul('spn2', 'FromSector_show', 'BLR-Bangalore, India','airport2');\"]")).click();
  		//------------------------------To---------------------------------------
  		Thread.sleep(3000);
  		
  		driver.findElement(By.xpath("//input[@id=\"a_Editbox13_show\"]")).sendKeys("Goa");
  		driver.findElement(By.xpath("//li[@onclick=\"autoSelectMul('spn5', 'Editbox13_show', 'GOI-Goa, India','airport5');\"]")).click();
  		
  		Thread.sleep(3000);
  		//--------------------------date-----------------------------------------
  	    driver.findElement(By.xpath("//li[@id='trd_0_13/09/2026']")).click();
  		Thread.sleep(3000);
//  		driver.findElement(By.xpath("//div[@id='divRtnCal']")).click();
//  		driver.findElement(By.xpath("//li[@id='fst_4_01/10/2026']")).click();
  		//---------------------------------------add 2 adults keep economy----------------
  		
  		driver.findElement(By.xpath("//div[@id='myFunction4']")).click();
  		driver.findElement(By.xpath("(//button[@id='add'])[1]")).click();
  		
  		//--------------------------click on search button-----------------------
  		Thread.sleep(3000);
  		driver.findElement(By.xpath("//div[@class='fss_flex search_colm']")).click();
  		
  		//-------------------validate flight result page--------------------
  		if(driver.getTitle().contains("EaseMyTrip.com Lowest Airfare, Flight Tickets, Cheap Air Tickets")) {
  			System.out.println("Flight result page is didplayed");
  		}else {
  			System.out.println("Flight result page is not displayed");
  		}
  		
  		
  		
	}
}
