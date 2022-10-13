package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductRemovePage {
	
	JavascriptExecutor js;
	
	@FindBy (xpath="(//div[text()='Remove'])[1]")
	private WebElement remove;
	
	@FindBy (xpath="(//div[text()='Remove'])[1]")
	private WebElement removeagain;
	
	
	
	
	//Variable initialization
	
		 public ProductRemovePage (WebDriver driver)
		 {
			 PageFactory.initElements(driver, this);
			 js= (JavascriptExecutor)driver;
		 }
		
	 //variable use
		   
	 	public void clickOnRemove() throws InterruptedException
		{
	 		js.executeScript("window.scrollBy(0,500)");
		 	remove.click(); Thread.sleep(2000);
			removeagain.click();
		}
			
	
	
	

}
