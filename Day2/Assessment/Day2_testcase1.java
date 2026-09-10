package Day2.Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Day2_testcase1 {
     public static void main(String[] args) {
    	//Launch the browser
    	WebDriver driver = new ChromeDriver();
 		driver.manage().window().maximize();
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 		//navigate to browser
 		driver.get("https://www.facebook.com/");
 		WebElement text=driver.findElement(By.xpath("//span[normalize-space(text())='Create new account']"));
 		
 		WebElement firstName = driver.findElement(By.xpath("//input[@id='_R_1cl2p4jikacppb6amH1_']"));
 		//if both y location are same then we use it 
 		System.out.println(firstName.getLocation().getY());
 		WebElement surname = driver.findElement(By.xpath("//input[@id='_R_1kl2p4jikacppb6amH1_']"));
 		 if(firstName.getLocation().getY()==surname.getLocation().getY()) {
 			 System.out.println("First name and surname aligned in same line");
 		 }else {
 			 System.out.println("First name and surname not aligned in same line");
 		 }
 		
	}
}
