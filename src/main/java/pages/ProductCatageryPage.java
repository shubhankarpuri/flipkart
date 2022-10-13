package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductCatageryPage {
	
	 private Actions mouse;
	// for mouse
	@FindBy (xpath="(//select[@class='_2YxCDZ'])[1]")
	private WebElement minimum;
	
	@FindBy (xpath="(//select[@class='_2YxCDZ'])[2]")
	private WebElement maximum;
	
	@FindBy (xpath="//div[@class='_24_Dny _3tCU7L']")
	private WebElement assured;
	
	@FindBy (xpath="(//div[@class='_24_Dny'])[2]")
	private WebElement hp;
	
	@FindBy (xpath="//a[text()='HP OMEN Photon Wireless Gaming Custom RGB Lighting Wire...']")
	private WebElement omen;
	
	
	// for Laptop *******************************************************************
	
	
	@FindBy (xpath="//div[@class='_24_Dny _3tCU7L']")
	private WebElement assuredlaptop;
	
	@FindBy (xpath="//div[text()='Brand']")
	private WebElement brand;
	
	@FindBy (xpath="//div[text()='ASUS']")
	private WebElement asus;
	
	@FindBy (xpath="(//div[@class='_4rR01T'])[1]")
	private WebElement laptop;
	
	@FindBy (xpath="(//div[@class='_3FdLqY'])[1]")
	private WebElement scrollbarA;
	
	@FindBy (xpath="(//div[@class='_1ftpgI'])[4]")
	private WebElement scrollbarB;
	
	//Variable initialization
	
	 public ProductCatageryPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
		 mouse= new Actions(driver);
	 }
	
	 //variable use
	   //for mouse
	 	public void selectMinimumValue()
		 {
	 		minimum.click();
	 		Select s=new Select(minimum);
	 		s.selectByValue("700");
		 }
		public void selectMaximumValue()
		 {
	 		maximum.click();
	 		Select s=new Select(maximum);
	 		s.selectByVisibleText("₹2500+");
		 }
		 public void selectAssured()
		 {
			 assured.click();
		 }
		 public void selectHp()
		 {
			 hp.click();
		 }
		 public void selectOmen()
		 {
			 omen.click();
		 }
		 
		 // for laptop *****************************************************
		 public void selectPriceRange()
		 {
			 mouse.dragAndDropBy(scrollbarA, 115, 0).perform();
		 }
		 public void selectAssuredlaptop()
		 {
			 assuredlaptop.click();
		 }
		 public void selectBrand()
		 {
			 brand.click();
		 }
		 public void selectAsus()
		 {
			 asus.click();
		 }
		 public void selectLaptop()
		 {
			 laptop.click();
		 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
