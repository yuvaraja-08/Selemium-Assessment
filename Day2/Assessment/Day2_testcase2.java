package Day2.Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_testcase2 {
     public static void main(String[] args) throws InterruptedException {
    	 WebDriver driver = new ChromeDriver();
  		driver.manage().window().maximize();
  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  		//navigate to the location
  		driver.get("https://www.facebook.com/");
  		System.out.println("---------Create new account button x and y coordinate");
  		WebElement accLoc=driver.findElement(By.xpath("//span[contains(text(),'Create new account')]"));
  		Thread.sleep(3000);
  		System.out.println(accLoc.getLocation().getX());
  		System.out.println(accLoc.getLocation().getY());
  		Thread.sleep(3000);
  		System.out.println("--------------Dom attribute and property after entering mail ---------------");
  		WebElement email = driver.findElement(By.xpath("//input[@id='_R_1h6kqsqppb6amH1_']"));
  		System.out.println(email.getDomAttribute("value"));
  		System.out.println(email.getDomProperty("value"));
  		Thread.sleep(3000);
  		System.out.println("------------Dom attribute and property after entering mail------------------");
  		email.sendKeys("yuvaraja8824@gamil.com");
  		System.out.println(email.getDomAttribute("value"));
  		System.out.println(email.getDomProperty("value"));
  		Thread.sleep(3000);
  		accLoc.click();
  		Thread.sleep(3000);
  		System.out.println("-------------get size subit button----------------------");
  		WebElement submit= driver.findElement(By.xpath("//span[contains(text(),'Submit')]/ancestor::div[@role='button']"));
  		System.out.println(submit.getSize().getWidth());
  		System.out.println(submit.getSize().getHeight());
  		Thread.sleep(3000);
  		System.out.println("-----------------CSS Values--------------------- ");
  		System.out.println(submit.getCssValue("cursor"));
  		System.out.println(submit.getCssValue("text-align"));
  		System.out.println(submit.getCssValue("display"));
  		
  		
  		
	}
}
