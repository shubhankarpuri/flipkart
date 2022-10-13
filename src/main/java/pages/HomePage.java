package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Variable declaration
	private Actions mouse;
	
	@FindBy (xpath="//div[text()='Electronics']")
	private WebElement electronics;
	
	@FindBy (xpath="//a[text()='Gaming']")
	private WebElement gaming;
	
	@FindBy (xpath="(//a[@class='_6WOcW9 _3YpNQe'])[4]")
	private WebElement gamingmouse;
	
	//Variable initialization
	
	public HomePage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
		 mouse=new Actions(driver);
	 }
	
	 //variable use
	
	 	
	 public	void moveToElectronics() throws InterruptedException
		 {
	 		mouse.moveToElement(electronics).perform();Thread.sleep(2000);
		 }
		 public void moveToGaming() throws InterruptedException
		 { 
			 mouse.moveToElement(gaming).perform();Thread.sleep(2000);
		 }
		 public void moveToGamingMouseAndClick() throws InterruptedException
		 {
			 mouse.moveToElement(gamingmouse).click().build().perform();Thread.sleep(2000);
		 }
		
	
	
	
	
	
	
	
	
	
}
