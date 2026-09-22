package Day1Assigment.FinalCapgeminiAssesment1.Assesment1;


import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoapps.qspiders.com/ui/slider?sublist=0");
		Thread.sleep(3000);
	
	    WebElement slider = driver.findElement(By.id("slide"));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(slider, 100, 0).click().build().perform();
		 
		 
		  WebElement OP = driver.findElement(By.xpath("//h3[normalize-space()='Mens Cotton Jacket...']"));
		  Thread.sleep(3000);
		  
		  
		  //verify order MenJactot
		  if(OP.isDisplayed()) {
			  System.out.println("Men Cotton Jocket is displayed");
		  }else {
			  System.out.println("Men cotten Jocket is not displayed");
		  }
	    
		
	}

}
