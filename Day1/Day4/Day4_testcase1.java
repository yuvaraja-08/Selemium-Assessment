package Day1Assigment.Day1.Day4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day4_testcase1 {
	public static void main(String[] args) {
    	WebDriver driver = new ChromeDriver();
  		driver.manage().window().maximize();
  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  		driver.get("https://www.facebook.com/");
  		
  		//------------------get sizes----------------
  		
  		 List<WebElement> emailun = driver.findElements(By.xpath("//div[@class='x78zum5 xdt5ytf xh8yej3']"));
  		 int i =1;
  		 for(WebElement ele : emailun) {
  			 System.out.println(i+"."+ele.getSize());
  			 i++;
  		 }
  		
	}
}
//-------------------------------------find text and get sizes of text field---------------------------------
