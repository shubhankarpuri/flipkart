package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LogoutPage;

public class VerifyLogoutPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver","D:\\Shubhankar Puri\\IT Software\\Software Testing\\Automation\\Selenium\\Chromedriver\\chromedriver.exe");		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LogoutPage logoutPage= new LogoutPage(driver);
		logoutPage.clickonMainPage();
		logoutPage.movetoAccount();
		logoutPage.clicktoLogout();
		
	}

}
