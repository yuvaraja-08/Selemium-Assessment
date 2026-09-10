package Day1Assigment.Day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day3_testcase2 {
     public static void main(String[] args) throws InterruptedException {
    	// Launch The browser
         WebDriver driver = new ChromeDriver();
         //maximize browser
         driver.manage().window().maximize();
         //implicity wait 
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         //naviagte to the browser
         driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
         Thread.sleep(3000);
         WebElement tt=driver.findElement(By.xpath("//input[@placeholder='Select A Date']"));
         tt.click();
         
         //--------------------navigate to next month----------------------
         driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--next']")).click();
         
         //---------------------click on date------------------------------
         driver.findElement(By.xpath("//div[@aria-label=\"Choose Thursday, October 8th, 2026\"]")).click();
         
         Thread.sleep(3000);
         System.out.println(tt.getDomProperty("value"));
         
         //-------------------validate displayed date correct or not---------------------
         
         String actuldate = tt.getDomProperty("value");
         
         if(actuldate.equals("08/10/2026")) {
        	 System.out.println("Displayed correct Date");
         }else {
        	 System.out.println("Displayed invaild date");
         }
         
	}
}
