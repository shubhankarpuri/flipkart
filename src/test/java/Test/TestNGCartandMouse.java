package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BrowserSetup.Base;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ProductCatageryPage;
import pages.ProductDetailPage;
import pages.SearchBar;
import pages.TravelPage;
import utils.Utility;

public class TestNGCartandMouse extends Base{

	private WebDriver driver;
	private LoginPage loginPage;
	private CartPage cartPage;
	private HomePage homePage;
	private LogoutPage logoutPage;
	private ProductCatageryPage productCatageryPage;
	private ProductDetailPage productDetailPage ;
	private ArrayList<String> adds;
	private SoftAssert soft;
	private int testID;
	
	
	@Parameters("browser")
		@BeforeTest
		public void beforeTest(String browsername)
		{
		if(browsername.equals("Chrome"))
		{
			driver= openChromeDriver();
		}
		if(browsername.equals("Firefox")) 
		{
			driver= openFirefoxDriver();
		}
		if(browsername.equals("Edge")) 
		{
			driver= openEdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		@BeforeClass
		public void beforeClass()
		{
			loginPage=new LoginPage(driver);
			cartPage = new CartPage(driver);
			homePage=new HomePage(driver);
			logoutPage= new LogoutPage(driver);
			productCatageryPage=new ProductCatageryPage(driver);
			adds=new ArrayList<String> (driver.getWindowHandles());
			productDetailPage = new ProductDetailPage(driver);
			soft = new SoftAssert();
					
		}
		@BeforeMethod
		public void beforeMethod() throws InterruptedException, EncryptedDocumentException, IOException 
		{
			driver.get("https://www.flipkart.com/");
			String id = Utility.excelSheet("Sheet1", 3, 1);
			loginPage.sendusername(id);Thread.sleep(1000);
			String pass = Utility.excelSheet("Sheet1", 3, 2);
			loginPage.sendpasword(pass);Thread.sleep(1000);
			loginPage.loginbutton();
			Thread.sleep(2000);
		} 
		
		@Test 
		public void verifyCart() throws InterruptedException
		{
			// Verify Cart is Empty
			testID=2001;
			cartPage.clickonCart();Thread.sleep(1000);
			String url=driver.getCurrentUrl();
			cartPage.checkCartisEmpty();Thread.sleep(1000);
			soft.assertEquals(url, "//www.flipkart.com/viewcart?exploreMode"
									+ "=true&preference=FLIPKART");         
			soft.assertAll();
			
			
		}
		
		@Test  (enabled =  false )
		public void verifyMouse() throws InterruptedException
		{
			// Verify mouse --> Add to cart
			testID=2002;
			homePage.moveToElectronics();Thread.sleep(1000);
			homePage.moveToGaming();Thread.sleep(1000);
			homePage.moveToGamingMouseAndClick();Thread.sleep(1000);
			
			productCatageryPage.selectMinimumValue();Thread.sleep(2000);
			productCatageryPage.selectMaximumValue();Thread.sleep(2000);
			productCatageryPage.selectAssured();Thread.sleep(2000);
			productCatageryPage.selectHp();Thread.sleep(2000);
			productCatageryPage.selectOmen();Thread.sleep(2000);
			
			
			String a1=adds.get(1);
			driver.switchTo().window(a1);
			
			
			productDetailPage.CheckPincode();Thread.sleep(2000);
			productDetailPage.SelectAddtoCart();
			
		}
		
		/*
		 @Test 
		public void verifyLaptop() throws InterruptedException
		{
			// Verify laptop --> Add to cart
			SearchBar searchBar=new SearchBar(driver);
			searchBar.ClickonSearch();
			//searchBar.SearchForLaptop();Thread.sleep(2000);
			searchBar.ClickonSubmit();
			
			ProductCatageryPage productCatageryPage=new ProductCatageryPage(driver);
			productCatageryPage.selectPriceRange();Thread.sleep(2000);
			productCatageryPage.selectAssuredlaptop();Thread.sleep(2000);
			productCatageryPage.selectBrand();
			productCatageryPage.selectAsus();
			productCatageryPage.selectLaptop();Thread.sleep(1000);
			

			ArrayList<String> adds=new ArrayList<String> (driver.getWindowHandles());
			String a1=adds.get(2);
			driver.switchTo().window(a1);
			
			ProductDetailPage productDetailPage = new ProductDetailPage(driver);
			productDetailPage.CheckPincode();Thread.sleep(1000);
			productDetailPage.SelectAddtoCart();
			System.out.println("test1");
		}
		
	
		
		@Test 
		public void verifyTravel() throws InterruptedException
		{
			// Verify travel functionality
			
			TravelPage travelPage = new TravelPage(driver);
			travelPage.clickonTravel();Thread.sleep(2000);
			travelPage.clickonRoundTrip();
			travelPage.clickonFrom();Thread.sleep(1000);
			travelPage.clickonTo();
			travelPage.clickDepartOnDate();Thread.sleep(1000);
			travelPage.selectNextMonth();Thread.sleep(1000);
			travelPage.selectReturnOnDate();
			travelPage.selectTravelClass();Thread.sleep(1000);
			travelPage.selectAdults();Thread.sleep(1000);
			travelPage.selectChildren();Thread.sleep(1000);
			travelPage.selectBusinessclass();
			travelPage.clickOnDone();
			travelPage.clickOnSearch();Thread.sleep(5000);
			
		}
		*/
		
		@AfterMethod
		public void aftermethod(ITestResult result)
				throws InterruptedException, IOException
		{
			if(ITestResult.FAILURE == result.getStatus())
			{
				Utility.screenShot(driver, testID);
			}
			logoutPage.clickonMainPage();Thread.sleep(2000);
			driver.navigate().refresh();Thread.sleep(2000);
			logoutPage.movetoAccount();
			logoutPage.clicktoLogout();Thread.sleep(2000);
			
		}
		
		@AfterClass
		public void removeObject()
		{
			loginPage=null;
			cartPage = null;
			homePage=null;
			logoutPage=null;
			productCatageryPage=null;
			adds=null;
			productDetailPage =null;
			
		}
		
		@AfterTest
		public void clisebrowser()
		{
			driver.quit();
			driver=null;
			System.gc();
		}
		
			
		

}
