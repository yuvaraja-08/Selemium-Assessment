package Day1Assigment.Day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day4_testcase2 {
	public static void main(String[] args) throws InterruptedException {
 	   WebDriver driver = new ChromeDriver();
  		driver.manage().window().maximize();
  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  		
  		driver.get("https://www.zomato.com/hyderabad/restaurants");
  		
  		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
  		Thread.sleep(3000);
  		WebElement ref = driver.findElement(By.xpath("//iframe[@id='auth-login-ui']"));
  		
  		driver.switchTo().frame(ref);
  		
  		WebElement ph=driver.findElement(By.xpath("//input[@placeholder='Phone']"));
  		ph.click();
  		ph.sendKeys("123456789");
  		
  		driver.switchTo().defaultContent();
  		Thread.sleep(3000);
  		WebElement tt=driver.findElement(By.xpath("(//div[@class='sc-jJkQYJ krMVc'])[2]"));
  	    System.out.println(tt.getText());
  	    if(tt.getText().equals("Delivery")) {
  	    	System.out.println("Swithed to parent");
  	    }else {
  	    	System.out.println("Not swithed parent");
  	    }
  		
  		
	}
}

//------------------zomato--> Login click--> naviagte Login frame --> backto main page check 

