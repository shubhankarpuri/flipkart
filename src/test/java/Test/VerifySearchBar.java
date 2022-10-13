package Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;
import pages.ProductCatageryPage;
import pages.ProductDetailPage;
import pages.SearchBar;

public class VerifySearchBar {

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
				
				
		//Verify search bar functionality
		SearchBar searchBar=new SearchBar(driver);
		searchBar.ClickonSearch();
		//searchBar.SearchForLaptop();
		searchBar.ClickonSubmit();Thread.sleep(2000);
		
		//Facet filter actions
		
				ProductCatageryPage productCatageryPage=new ProductCatageryPage(driver);
				
		// for laptop************************************************
				
				//ProductCatageryPage productCatageryPage=new ProductCatageryPage(driver);
				productCatageryPage.selectPriceRange();Thread.sleep(2000);
				productCatageryPage.selectAssuredlaptop();Thread.sleep(2000);
				productCatageryPage.selectBrand();Thread.sleep(2000);
				productCatageryPage.selectAsus();Thread.sleep(2000);
				productCatageryPage.selectLaptop();Thread.sleep(2000);
				
		//====================================================================	
				
				ArrayList<String> adds=new ArrayList<String> (driver.getWindowHandles());
				String a1=adds.get(1);
				driver.switchTo().window(a1);
				
				ProductDetailPage productDetailPage = new ProductDetailPage(driver);
				productDetailPage.CheckPincode();Thread.sleep(2000);
				productDetailPage.SelectAddtoCart();
					
		
		
	}

}
