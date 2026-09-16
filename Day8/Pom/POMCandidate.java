package Day1Assigment.Day8.Pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMCandidate {
	WebDriver driver;
	public POMCandidate(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
   
	@FindBy(xpath="//a[normalize-space()='Candidates']")
	private WebElement Cbutton;
	
	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
	private WebElement Jtite;
	
	@FindBy(xpath="//div[@role='option']//span[normalize-space()='Payroll Administrator']")
	private WebElement JJ;
	
	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
	private WebElement Vac;
	
	@FindBy(xpath="//div[@role='option']//span[normalize-space()='Payroll Administrator']")
	private WebElement Vacy1;
	
	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[3]")
	private WebElement HireM;
	
	
	@FindBy(xpath="//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-candidate-page']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]")
	private WebElement status;

	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement Cname;
	
	@FindBy(xpath="//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-candidate-page']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")
	private WebElement MM;
	
	@FindBy(xpath="//input[@placeholder='From']")
	private WebElement From;
	
	@FindBy(xpath="//input[@placeholder='To']")
	private WebElement To;
	
	@FindBy(xpath="//p[normalize-space()='No Records Found']")
	private WebElement rv;
	
	

	public String getRv() {
	   return rv.getText();
	}


	public WebDriver getDriver() {
		return driver;
	}

	public void getJtite() {
		Jtite.click();
		JJ.click();
	}

	public void getCbutton() {
		Cbutton.click();
	}

	public void getVac() {
		Vac.click();
		Vacy1.click();
	}

	public void getHireM() throws AWTException, InterruptedException {
		HireM.click();
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);

        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
	}


	public void getStatus() throws AWTException {
		status.click();
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_DOWN);
        r1.keyRelease(KeyEvent.VK_DOWN);

        r1.keyPress(KeyEvent.VK_ENTER);
        r1.keyRelease(KeyEvent.VK_ENTER);
		
	}

	public void getCname(String value) throws AWTException, InterruptedException {
		 Cname.sendKeys(value);
		 Thread.sleep(3000);
		 Robot r2 = new Robot();
		 r2.keyPress(KeyEvent.VK_DOWN);
	     r2.keyRelease(KeyEvent.VK_DOWN);
	     r2.keyPress(KeyEvent.VK_ENTER);
	     r2.keyRelease(KeyEvent.VK_ENTER);
	}
	

	public void getFrom(String value) {
		From.sendKeys(value,Keys.ENTER);
	}
	
	public void getTo(String value) throws InterruptedException, AWTException {
		To.sendKeys(value,Keys.TAB);
		Thread.sleep(3000);
		 Robot r3 = new Robot();
		 r3.keyPress(KeyEvent.VK_DOWN);
	     r3.keyRelease(KeyEvent.VK_DOWN);
	     r3.keyPress(KeyEvent.VK_ENTER);
	     r3.keyRelease(KeyEvent.VK_ENTER);
	     To.sendKeys(Keys.ENTER);
		
	}
	
	
}
