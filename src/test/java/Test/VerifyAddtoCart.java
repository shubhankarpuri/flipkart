package Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ProductCatageryPage;
import pages.ProductDetailPage;

public class VerifyAddtoCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","D:\\Shubhankar Puri\\IT Software\\Software Testing\\Automation\\Selenium\\All Drivers\\Chromedriver\\chromedriver.exe");		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Verify Login Page
		LoginPage loginPage=new LoginPage(driver);
		loginPage.logintoFlipkart();
		Thread.sleep(2000);
		
		
		
		
	/*	
// for mouse***************************************************
		
		// mouse actions
		HomePage homePage=new HomePage(driver);
		homePage.moveToElectronics();	
		homePage.moveToGaming();
		homePage.moveToGamingMouseAndClick(); 
		*/
//Facet filter actions
		
		ProductCatageryPage productCatageryPage=new ProductCatageryPage(driver);
		productCatageryPage.selectMinimumValue();Thread.sleep(2000);
		productCatageryPage.selectMaximumValue();
		productCatageryPage.selectAssured();
		productCatageryPage.selectHp();Thread.sleep(2000);
		productCatageryPage.selectOmen();
		
// for laptop************************************************
		
		//ProductCatageryPage productCatageryPage=new ProductCatageryPage(driver);
		productCatageryPage.selectPriceRange();
		productCatageryPage.selectAssuredlaptop();
		productCatageryPage.selectBrand();
		productCatageryPage.selectAsus();
		productCatageryPage.selectLaptop();
		
//====================================================================	
		
		ArrayList<String> adds=new ArrayList<String> (driver.getWindowHandles());
		String a1=adds.get(1);
		driver.switchTo().window(a1);
		
		ProductDetailPage productDetailPage = new ProductDetailPage(driver);
		productDetailPage.CheckPincode();
		productDetailPage.SelectAddtoCart();
		
// logout *****************************************************************		
		
		LogoutPage logoutPage= new LogoutPage(driver);
		logoutPage.clickonMainPage();
		logoutPage.movetoAccount();
		logoutPage.clicktoLogout();
		
		
		
		
		
	}

}
