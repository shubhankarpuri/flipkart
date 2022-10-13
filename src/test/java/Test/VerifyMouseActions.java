package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;

public class VerifyMouseActions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","D:\\Shubhankar Puri\\IT Software\\Software Testing\\Automation\\Selenium\\Chromedriver\\chromedriver.exe");		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Verify Mouse Actions on main Menu
		
		HomePage homePage=new HomePage(driver);
		//Actions mouse=new Actions(driver);
		homePage.moveToElectronics();	
		homePage.moveToGaming();
		homePage.moveToGamingMouseAndClick();
		
		
		
		
		
		
		
	}

}
