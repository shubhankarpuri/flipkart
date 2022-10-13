package BrowserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public static WebDriver openChromeDriver() 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Shubhankar Puri\\IT Software\\Software Testing\\Automation\\Selenium\\All Drivers\\Chromedriver\\chromedriver.exe");		
		WebDriver driver= new ChromeDriver();
		return driver;
	}
	
	public static WebDriver openFirefoxDriver() 
	{
		System.setProperty("webdriver.gecko.driver","D:\\Shubhankar Puri\\IT Software\\Software Testing\\Automation\\Selenium\\All Drivers\\Firefordriver\\geckodriver.exe");		
		WebDriver driver= new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver openEdgeDriver() 
	{
		System.setProperty("webdriver.edge.driver","D:\\Shubhankar Puri\\IT Software\\Software Testing\\Automation\\Selenium\\All Drivers\\Edgedriver\\edgedriver_win64\\msedgedriver.exe");		
		WebDriver driver= new EdgeDriver();
		return driver;
	}
	
	
	
}
