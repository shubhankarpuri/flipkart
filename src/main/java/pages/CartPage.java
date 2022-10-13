package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CartPage {
	
	//variable declaration
	
	@FindBy(xpath = "//span[text()='Cart']") 
	private WebElement cart;
	
	@FindBy(xpath = "//div[@class='_1LCJ1U']") 
	private WebElement cartisempty;
	
//=====================================================
	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

//=====================================================

	
	public void clickonCart()
	{
		cart.click();
	}
	public void checkCartisEmpty ()
	{
		String str=cartisempty.getText();
		System.out.println(str);
		if(str.equals("Your cart is empty!"))
		{
			System.out.println("Cart is Empty");
		}else 
		{
			System.out.println("Cart is Not Empty");
			
		
		}
		
		
	}
}
