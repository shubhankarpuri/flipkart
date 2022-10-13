package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
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

import BrowserSetup.Base;
import pages.CartPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ProductCatageryPage;
import pages.ProductDetailPage;
import pages.ProductRemovePage;
import pages.SearchBar;
import pages.TravelPage;
import utils.Utility;

public class TestNGLaptopandTravel extends Base{

	
	private WebDriver driver;
	private LoginPage loginPage;
	private SearchBar searchBar;
	private ProductCatageryPage productCatageryPage;
	private ProductDetailPage productDetailPage;
	
	private TravelPage travelPage;
	private LogoutPage logoutPage;
	private ProductRemovePage productRemovePage;
	private CartPage cartPage;
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
		searchBar=new SearchBar(driver);
		productCatageryPage=new ProductCatageryPage(driver);
		productDetailPage = new ProductDetailPage(driver);
		
		travelPage = new TravelPage(driver);
		logoutPage= new LogoutPage(driver);
		productRemovePage =new ProductRemovePage(driver);
		cartPage = new CartPage(driver);
		
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
	

	@Test (priority = 1 )
	public void verifyLaptop() throws InterruptedException
	{
		// Verify laptop --> Add to cart
		testID=1001;
		searchBar.ClickonSearch();Thread.sleep(2000);
		//searchBar.SearchForLaptop();Thread.sleep(2000);
		searchBar.ClickonSubmit();
		
		
		productCatageryPage.selectPriceRange();Thread.sleep(2000);
		productCatageryPage.selectAssuredlaptop();Thread.sleep(2000);
		productCatageryPage.selectBrand();Thread.sleep(2000);
		productCatageryPage.selectAsus();Thread.sleep(2000);
		productCatageryPage.selectLaptop();Thread.sleep(2000);
		
		ArrayList<String> adds=new ArrayList<String> (driver.getWindowHandles());
		String a1=adds.get(1);
		driver.switchTo().window(a1);
		
		
		productDetailPage.CheckPincode();Thread.sleep(1000);
		productDetailPage.SelectAddtoCart();Thread.sleep(2000);
		
	}
	

	@Test (priority = 2 )
	public void verifyTravel() throws InterruptedException
	{
		// Verify travel functionality
		testID=1002;
		
		travelPage.clickonTravel();Thread.sleep(2000);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.flipkart.com/travel/flights?otracker=nmenu_Flights","travel not working"); 	
		travelPage.clickonRoundTrip();Thread.sleep(2000);
		travelPage.clickonFrom();Thread.sleep(1000);
		travelPage.clickonTo();Thread.sleep(2000);
		travelPage.clickDepartOnDate();Thread.sleep(1000);
		travelPage.selectNextMonth();Thread.sleep(1000);
		travelPage.selectReturnOnDate();Thread.sleep(2000);
		travelPage.selectTravelClass();Thread.sleep(1000);
		travelPage.selectAdults();Thread.sleep(1000);
		travelPage.selectChildren();Thread.sleep(1000);
		travelPage.selectBusinessclass();Thread.sleep(2000);
		travelPage.clickOnDone();Thread.sleep(2000);
		travelPage.clickOnSearch();Thread.sleep(6000);
		logoutPage.clickonMainPage();Thread.sleep(2000);
	}
	
	@Test (priority = 3)
	public void verifyProductRemovel() throws InterruptedException
	{
		testID=1003;
		cartPage.clickonCart();Thread.sleep(1000);
		productRemovePage.clickOnRemove();
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) 
			throws InterruptedException, IOException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.screenShot(driver, testID);
		}
		logoutPage.clickonMainPage();Thread.sleep(2000);
		driver.navigate().refresh();Thread.sleep(3000);
		logoutPage.movetoAccount();Thread.sleep(2000);
		logoutPage.clicktoLogout();Thread.sleep(2000);
		
	}
	
	@AfterClass
	public void afterclass()
	{
		loginPage=null;
		searchBar=null;
		productCatageryPage=null;
		productDetailPage = null;
		
		travelPage =null;
		logoutPage=null;
		
	}
	
	@AfterTest
	public void clisebrowser()
	{
		driver.quit();
		driver=null;
		System.gc();
	}
}
