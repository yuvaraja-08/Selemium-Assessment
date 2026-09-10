package Day1Assigment.Day1.Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day4_testcase3 {
	public static void main(String[] args) throws InterruptedException {
   	 WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.bigbasket.com/");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//input[@placeholder='Search for Products...'])[2]")).sendKeys("orange",Keys.ENTER);
		Thread.sleep(5000);
		WebElement add=driver.findElement(By.xpath("//h3[contains(text(),'Mini Orange Imported')]/ancestor::li[@class='sc-ciQpPG kxhyzB']/descendant::button[normalize-space()='Add']"));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", add);
		add.click();
		Thread.sleep(2000);
		WebElement added=driver.findElement(By.xpath("//p[normalize-space(text())='An item has been added to your basket successfully']"));
		System.out.println(added.getText());
	}
}
//----------------------naviagte big baseket-->search product --> add to cart --> verify----------------
