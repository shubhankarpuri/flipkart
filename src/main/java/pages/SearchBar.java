package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBar {
	
	//Variable declaration
		
		
	@FindBy (xpath="//input[@class='_3704LK']")
	private WebElement search;
		
	@FindBy (xpath="//button[@type='submit']")
	private WebElement submit;
	
	public SearchBar(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void ClickonSearch() throws InterruptedException
	{
		search.click();
		search.sendKeys("Laptop");Thread.sleep(1000);
	}
	
	
	public void  ClickonSubmit()
	{
		submit.click();
	}
}
