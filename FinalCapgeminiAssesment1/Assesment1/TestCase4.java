package Day1Assigment.FinalCapgeminiAssesment1.Assesment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase4 {
     public static void main(String[] args) throws InterruptedException {
    	 WebDriver driver = new ChromeDriver();
 		driver.manage().window().maximize();
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 		driver.get("https://www.shoppersstack.com/");
 		
 		Thread.sleep(5000);
 		
 		driver.findElement(By.xpath("(//div[@class='featuredProducts_cardBody__l4gLE'])[3]")).click();
 		
 		//pass devlivery pincode
 		WebElement cd = driver.findElement(By.id("Check Delivery"));
 		cd.sendKeys("583104");
 		Thread.sleep(3000);
 		cd.sendKeys(Keys.ENTER);
 		
 		WebElement verify = driver.findElement(By.xpath("//a[normalize-space()='Check deliverable pins.']"));
 		if(verify.isDisplayed()) {
 			System.out.println("Not deliverable to that location");
 		}else {
 			System.out.println("Delivery to location");
 		}
 	
 		
 		
	}
}
