package Day1Assigment.FinalCapgeminiAssesment1.Assesment1;

import java.time.Duration;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testcase1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoapps.qspiders.com/ui/toggle?sublist=0");
		driver.findElement(By.xpath("//a[text()='Disabled']")).click();
		Thread.sleep(3000);	
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		WebElement firstToggle = driver.findElement(By.xpath("(//input[@type='checkbox' and @disabled])[1]"));
//		js.executeScript("arguments[0].removeAttribute('disabled');", firstToggle);
//		js.executeScript("arguments[0].click();", firstToggle);
//		
//		Thread.sleep(3000);
//		WebElement SecondToggle = driver.findElement(By.xpath("(//span)[4]"));
//		js.executeScript("arguments[0].removeAttribute('disabled');", SecondToggle);
//		js.executeScript("arguments[0].click();", SecondToggle);
////		
//		Thread.sleep(3000);
//		WebElement ThirdToggle = driver.findElement(By.xpath("(//input[@type='checkbox' and @disabled])[3]"));
//		js.executeScript("arguments[0].removeAttribute('disabled');", ThirdToggle);
//		js.executeScript("arguments[0].click();", ThirdToggle);
		
		// perform action desiabled toggle
		JavascriptExecutor js = (JavascriptExecutor)driver;
		List<WebElement> toggles = driver.findElements(By.xpath("//input[@type='checkbox' and @disabled]"));

			for (WebElement toggle : toggles) {
			    js.executeScript("arguments[0].removeAttribute('disabled');", toggle);
			    js.executeScript("arguments[0].click();", toggle);
			   
			}
			
      //click on place order button
	  Thread.sleep(3000); 
	  driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();
	  WebElement OP = driver.findElement(By.xpath("//p[normalize-space()='ORDER PLACED']"));
	  Thread.sleep(3000);
	  
	  
	  //verify order palced or not
	  if(OP.isDisplayed()) {
		  System.out.println("Oder is placed🤗🤗🤗");
	  }else {
		  System.out.println("Order not placed 👿");
	  }
		
		
		
		
		
		
	}

}
