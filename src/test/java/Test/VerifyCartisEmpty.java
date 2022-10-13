package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import utils.Utility;

public class VerifyCartisEmpty {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		
		System.setProperty("webdriver.chrome.driver","D:\\Shubhankar Puri\\IT Software\\Software Testing\\Automation\\Selenium\\Chromedriver\\chromedriver.exe");		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Verify Login Page
		LoginPage loginPage=new LoginPage(driver);
		String id = Utility.excelSheet("Sheet1", 1, 3);
		loginPage.sendusername(id);
		String pass = Utility.excelSheet("Sheet1", 2, 3);
		loginPage.sendpasword(pass);
		loginPage.loginbutton();
		Thread.sleep(2000);
		HomePage homePage=new HomePage(driver);
		
		
		
		
		CartPage cartPage = new CartPage(driver);
		cartPage.clickonCart();
		cartPage.checkCartisEmpty();
		
		
		
		
		
		
		
		
	}

}
