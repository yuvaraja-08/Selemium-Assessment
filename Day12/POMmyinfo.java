package Day1Assigment.Day12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMmyinfo {
     WebDriver driver;
     POMmyinfo(WebDriver driver) {
    	 this.driver=driver;
    	 PageFactory.initElements(driver,this);
     }
     
     @FindBy(xpath="//a[@href='/web/index.php/pim/viewMyDetails']")
     private WebElement myinfo;
	
     public void getMyinfo() {
		  myinfo.click();
	 }
     
}
