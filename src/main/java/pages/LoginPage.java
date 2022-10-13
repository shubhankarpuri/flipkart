package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Variable declaration
	
	@FindBy (xpath="(//input[@autocomplete='off'])[2]")
	private WebElement username;
	
	@FindBy (xpath="(//input[@autocomplete='off'])[3]")
	private WebElement password;
	
	@FindBy (xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	private WebElement loginbutton;
	
	//Variable initialization
	
	 public LoginPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	
	 //variable use
	 
	
	 public void sendusername(String name)
	 {
		 username.sendKeys(name);
	 }
	 public void sendpasword(String pass)
	 { 
		 password.sendKeys(pass);
	 }
	 public void loginbutton()
	 {
		 loginbutton.click();
	 }
	
	 //************* OR *************//
	 
	 public void logintoFlipkart() throws InterruptedException
	 {
		 username.sendKeys("8412881028");Thread.sleep(1000);
		 password.sendKeys("8412881028@123");Thread.sleep(1000);
		 loginbutton.click();Thread.sleep(1000);
	 }
	
	
	
	
	
	
	
}
