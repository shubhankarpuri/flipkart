package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailPage {
	
	//Variable declaration
	
		// for Mouse and laptop
	
	@FindBy (xpath="//input[@id='pincodeInputId']")
	private WebElement pincode;
	
	@FindBy (xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addtocart;
		
	@FindBy (xpath="//span[text()='Check']")
	private WebElement check;
		
	
	
	//Variable initialization
	
	 public ProductDetailPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	
	 //variable use
	 
	  public void CheckPincode()
		 {
	 		pincode.sendKeys("413102");
	 		check.click();
		 }
		public void SelectAddtoCart()
		 {
			addtocart.click();
		 }
		
	
	
	
	
	
	
	
	
	
	
	
	
}
