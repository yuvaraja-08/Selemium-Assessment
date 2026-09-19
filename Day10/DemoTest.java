package Day1Assigment.Day10;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Day1Assigment.Day10.BaseclassPOM.Baseclass;
import Day1Assigment.Day10.BaseclassPOM.CheckOutpage;
import Day1Assigment.Day10.BaseclassPOM.PomHomePage;
import Day1Assigment.Day10.BaseclassPOM.PomLogiSause;
import Day1Assigment.Day10.BaseclassPOM.PomOverview;
import Day1Assigment.Day10.BaseclassPOM.Pomcart;
import Day1Assigment.Day10.BaseclassPOM.Pomcomplete;

public class DemoTest extends Baseclass {
        
	@Test
	public void loginTest() throws IOException, InterruptedException {
		
        FileInputStream fil = new FileInputStream("./src/main/java/BaseClassUtility/sause.properties");

        Properties p = new Properties();
        p.load(fil);

        //----------------------------------------------------------------------------------

        String url = p.getProperty("url");
        String uname = p.getProperty("username");
        String pass = p.getProperty("pass");

        driver.get(url);
        System.out.println(url + " " + uname + " " + pass);

        //------------------------------------------------------------------------------------
        Thread.sleep(3000);
        PomLogiSause p1 = new PomLogiSause(driver);
        p1.getUname(uname);
        p1.getPass(pass);
        p1.getButton();

        //-----------------------------------------------------------------------------------
        Thread.sleep(3000);
        if (driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html")) {
            System.out.println("Product page is displayed");

        } else {
            System.out.println("Product page is not displayed");
        }
        System.out.println("LoginTest Tested");
        Thread.sleep(3000);
        System.out.println("--------------------------😉 Login Tested with zero failure 😉-----------------------------------");
    }
		
	
	@Test
	public void oderPalcementTest() throws IOException, InterruptedException {
		    Thread.sleep(3000);
		    FileInputStream fil = new FileInputStream("./src/main/java/BaseClassUtility/sause.properties");
	        Properties p = new Properties();
	        p.load(fil);
	        String url = p.getProperty("url");
	        String uname = p.getProperty("username");
	        String pass = p.getProperty("pass");

	        driver.get(url);
            Thread.sleep(3000);
	        PomLogiSause p1 = new PomLogiSause(driver);

	        p1.getUname(uname);
	        p1.getPass(pass);
	        p1.getButton();

	        //-----------------------------------------------------------------------------------
            Thread.sleep(3000);
	        PomHomePage p2 = new PomHomePage(driver);
	        Thread.sleep(2000);
	        p2.getAddTocart();
            Thread.sleep(2000);
	        if (p2.getVerify1().equals("1")) {
	            System.out.println("1 item is add to cart ");
	        } else {
	            System.out.println("More than 1 item added to cart");
	        }
	        p2.getCart1Item();

	        //-----------------------------------------------------------------------------------
            Thread.sleep(3000);
	        Pomcart p3 = new Pomcart(driver);

	        if (p3.getVerifyBag().equals("Sauce Labs Backpack")) {
	            System.out.println("Yes Bag is added to cart 😀😁");
	        } else {
	            System.out.println("Bag is not added to cart 😒");
	        }
	        Thread.sleep(3000);
	        p3.getCheckout();

	        //-----------------------------------------------------------------------------------

	        FileInputStream f = new FileInputStream("./src/test/java/Day1Assigment/Day10/BaseclassPOM/Checkout.xlsx");
	        Workbook wb = WorkbookFactory.create(f);
	        String fname = wb.getSheet("Sheet1")
	                .getRow(1)
	                .getCell(0)
	                .getStringCellValue();
	        String lname = wb.getSheet("Sheet1")
	                .getRow(1)
	                .getCell(1)
	                .getStringCellValue();

	        System.out.println(fname);
	        System.out.println(lname);

	        //-----------------------------------------------------------------------------------
            Thread.sleep(3000);
	        CheckOutpage c = new CheckOutpage(driver);

	        c.getFname(fname);
	        c.getLname(lname);
	        c.getPcode("583220");
	        Thread.sleep(3000); 
	        c.getContinue();

	        //-----------------------------------------------------------------------------------

	        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-two.html")) {
	            System.out.println("Checkout: Overview page displayed");
	        } else {
	            System.out.println("Checkout: Overview page is not displayed");
	        }
	        //-----------------------------------------------------------------------------------

	        PomOverview p4 = new PomOverview(driver);

	        p4.getFinish();

	        //-----------------------------------------------------------------------------------

	        Pomcomplete p5 = new Pomcomplete(driver);
	    
	        if (p5.getThankyou().equals("Thank you for your order!")) {
	            System.out.println("Order compled");
	        } else {
	            System.out.println("Oder not completed");
	        }
		System.out.println("oderPalcementTest tested");
	}
}
