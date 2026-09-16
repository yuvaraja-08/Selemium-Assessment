package Day1Assigment.Day8.Pom;

import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMAddpage {
	WebDriver driver;
	public POMAddpage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='firstName']")
	private WebElement Fname;
	
	@FindBy(xpath="//input[@name='middleName']")
	private WebElement Mname;
	
	@FindBy(xpath="//input[@name='lastName']")
	private WebElement Lname;
	
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--active']")
	private WebElement vacy;
	
	@FindBy(xpath="//div[@role='option']//span[normalize-space()='Payroll Administrator']")
	private WebElement salesres;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement email;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement Cno;
	
	@FindBy(xpath="//input[@type='file']")
	private WebElement Resume1;
	
//	@FindBy(xpath="//div[@class='oxd-file-div oxd-file-div--active']")
//	private WebElement Resume;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[5]")
	private WebElement Date;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement Save;


	public void getFname(String value) {
		Fname.sendKeys(value);
	}

	public void getMname(String value) {
		Mname.sendKeys(value);;
	}

	public void getLname(String value) {
		Lname.sendKeys(value);;
	}

	public void getVacy() {
		vacy.click();
		salesres.click();
	}

	public void getEmail(String value) {
		email.sendKeys(value);
	}

	public void getCno(String value) {
		Cno.sendKeys(value);
	}
	public void getResume1(String value) {
		Resume1.sendKeys(value);
	}

//	public void getResume(String value) {
//		Resume.sendKeys(value);
//	}

	public void getDate() {
	    Date.sendKeys(Keys.ENTER);
	}

	public void getSave() {
		Save.click();
	}
	
	
	

}
