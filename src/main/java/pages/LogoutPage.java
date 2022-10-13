package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	//Variable declaration
		Actions mouse;
	
		@FindBy (xpath="//img[@title='Flipkart']")
		private WebElement flipkart;
	
		@FindBy (xpath="(//div[@class='exehdJ'])[1]")
		private WebElement account;
	
		@FindBy (xpath="//div[text()='Logout']")
		private WebElement logout;
	
		
		//Variable initialization
		
		 public LogoutPage(WebDriver driver)
		 {
			 PageFactory.initElements(driver, this);
			 mouse=new Actions(driver);
		 }
		
		 //variable use
		 
		  public void clickonMainPage()
			 {
		 		flipkart.click();
			 }
			public void movetoAccount()
			 {
				mouse.moveToElement(account).perform();
			 }
			
			public void clicktoLogout()
			 {
				mouse.moveToElement(logout).click().build().perform();
			 }
			
			
			
			
			
			
			
			
			
			
}
