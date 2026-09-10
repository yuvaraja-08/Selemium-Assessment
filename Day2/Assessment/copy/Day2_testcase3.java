package Day2.Assessment.copy;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Day2_testcase3 {
   public static void main(String[] args) throws InterruptedException,IOException {
	    WebDriver driver = new ChromeDriver();
 		driver.manage().window().maximize();
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 		driver.get("https://demowebshop.tricentis.com/");
 		
 	    System.out.println("---------------------------Identify the webelement(14.1-inch laptop)-->add to cart button--------------------------------------------");
 	    
 	    WebElement atc= driver.findElement(By.xpath("//a[@href='/141-inch-laptop']//ancestor::div[@class='item-box']//descendant::input[@value='Add to cart']"));
 	    System.out.println("width of addTocart : "+atc.getSize().getWidth());
 	    System.out.println("Hight of addTocart : "+atc.getSize().getHeight());
 	    atc.click();
 	    
 	    
 	    System.out.println();
 	    Thread.sleep(3000);
 	    //------------------Click on add to cart button------------------------------
        driver.findElement(By.xpath("//a[@href='/cart']")).click(); 
        Thread.sleep(3000);
        
        
        System.out.println("-------------------verify remove check box is selected or not --------------------");
        WebElement checkbox = driver.findElement(By.xpath("//input[@name='removefromcart']"));
        System.out.println("If true selected else not checked : " +checkbox.isSelected());
        
        
        System.out.println("------------get rect values------------");
        System.out.println("width : "+checkbox.getRect().getWidth());
        System.out.println("width : "+checkbox.getRect().getHeight());
        System.out.println("width : "+checkbox.getRect().getX());
        System.out.println("width : "+checkbox.getRect().getY());
        System.out.println();
      
        
        System.out.println("-------Verify alter message is displayed or not ----------");
        try {
            WebElement msg = driver.findElement(
                By.xpath("//div[@class='message']")
            );

            System.out.println("Before clicking: " + msg.isDisplayed());

        } catch (NoSuchElementException e) {
            System.out.println("Before Alert message is NOT displayed");
        }
   
        driver.findElement(By.xpath("//input[@name='applydiscountcouponcode' and @type='submit']")).click();
        Thread.sleep(3000);
       
         WebElement msg=driver.findElement(By.xpath("//div[@class='message']"));
        System.out.println("after alter message(The coupon code you entered couldn't be applied to your order) :"+msg.isDisplayed());
        
        Thread.sleep(3000);
        WebElement lap = driver.findElement(By.xpath("//td[@class='product-picture']"));
        File src =lap.getScreenshotAs(OutputType.FILE);
        File dest = new File("./Ss/lap.png");
        FileHandler.copy(src, dest);
        
}
}
