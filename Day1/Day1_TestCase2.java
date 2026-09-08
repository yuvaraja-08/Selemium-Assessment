package Day1Assigment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Day1_TestCase2 {
   public static void main(String[] args) throws InterruptedException {
	   // Launch The browser
       WebDriver driver = new ChromeDriver();
       //maximize browser
       driver.manage().window().maximize();
       //implicity wait 
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
       //naviagte to the browser
       driver.get("https://www.myntra.com/");
       
       
       //searchfor the product
        WebElement search=driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
        search.sendKeys("Headphone");
        Thread.sleep(3000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        
        
        //WebElement ele=driver.findElement(By.xpath("//a[@href='headphones/oneplus/oneplus-nord-buds-3r-bluetooth-earbuds/36474064/buy']"));
        //ele.click();
        
        
        //Product add to the wislist
         driver.findElement(By.xpath("//li[@id='36474064']//div[contains(@class,'product-actions')]")).click();

        
        //wait for login i took 1min 30 sec
        
        driver.findElement(By.xpath("//span[text()='Wishlist']")).click();
        Thread.sleep(3000);
        
//        driver.findElement(By.xpath("//a[@class='wishlistLogin-button']")).click();
//        Thread.sleep(130000);
        //WebElement t=driver.findElement(By.xpath("//p[normalize-space(text())='OnePlus Nord Buds 3r Bluetooth Earbuds']"));
        //t.getText();
        
        //count the text in the wiselist
        String count = driver.findElement(By.xpath("//span[@class='index-count index-heading']")).getText();
        System.out.println(count);
        
        if(count.equals("0")) {
        	System.out.println("Product is Not added to wislist");
        }else{
        	System.out.println("Product is added to wislist");
        	}
        }
   
        
}

