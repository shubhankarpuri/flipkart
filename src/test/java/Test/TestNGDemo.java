package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.LoginPage;


public class TestNGDemo {
	private WebDriver driver;
	
	@BeforeClass
	public void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Shubhankar Puri\\IT Software\\Software Testing\\Automation\\Selenium\\All Drivers\\Chromedriver\\chromedriver.exe");		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException 
	{
		driver.get("https://www.flipkart.com/");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.logintoFlipkart();
		Thread.sleep(2000);
	}
	
	@Test 
	public void test_1() throws InterruptedException 
	{
		CartPage cartPage=new CartPage(driver);
		cartPage.clickonCart();Thread.sleep(1000);
		cartPage.checkCartisEmpty();
	}
	
	@Test 
	public void test_3() 
	{
		System.out.println("Test 3 PASS");
	}
	
	@Test 
	public void test_2() 
	{
		System.out.println("Test 2 PASS");
		//Assert.fail();
	}
	
	@Test 
	public void test_4() 
	{
		System.out.println("Test 4 PASS");
	}
	
	@AfterMethod
	public void aftermethod() 
	{
		System.out.println("After method PASS");
	}
	
	@AfterClass
	public void afterclass()
	{
		System.out.println("After class PASS");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
