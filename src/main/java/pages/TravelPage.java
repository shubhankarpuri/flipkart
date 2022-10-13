package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelPage {

	
	//Variable declaration
	
	
	@FindBy (xpath="//div[text()='Travel']")
	private WebElement travel;
	
	@FindBy (xpath="(//div[@class='_1XFPmK'])[2]")
	private WebElement roundTrip;
	
	@FindBy (xpath="(//input[@type='text'])[1]")
	private WebElement from;
	
	@FindBy (xpath="//div[text()='BOM']")
	private WebElement mumbai;
	
	@FindBy (xpath="(//input[@type='text'])[2]")
	private WebElement to;
	
	@FindBy (xpath="(//div[text()='PNQ'])[2]")
	private WebElement pune;
	
	@FindBy (xpath="(//button[text()='20'])[2]")
	private WebElement departOn;
	
	@FindBy (xpath="(//button[@class='_3CTB5G'])[2]")
	private WebElement nextMonth;
	
	@FindBy (xpath="(//button[text()='1'])[2]")
	private WebElement returnOn;
	
	@FindBy (xpath="//input[@name='0-travellerclasscount']")
	private WebElement travelClass;
	
	@FindBy (xpath="(//button[@class='_2KpZ6l _34K0qG _37Ieie'])[1]")
	private WebElement adults;
	
	@FindBy (xpath="(//button[@class='_2KpZ6l _34K0qG _37Ieie'])[2]")
	private WebElement adults1;
	
	@FindBy (xpath="(//button[@class='_2KpZ6l _34K0qG _37Ieie'])[3]")
	private WebElement children;
	
	@FindBy (xpath="(//button[@class='_2KpZ6l _34K0qG _37Ieie'])[4]")
	private WebElement children1;
	
	@FindBy (xpath="//div[text()='Business']")
	private WebElement businessclass;
	
	@FindBy (xpath="//button[text()='Done']")
	private WebElement done;
	
	@FindBy (xpath="//span[text()='SEARCH']")
	private WebElement search;
	
	
//=========================================================================	
	
	//Variable initialization
	
	public TravelPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
		 
	 }
//==========================================================================
	
	 //variable use
	
	 	
	 public	void clickonTravel()
		 {
	 		travel.click();
		 }
	 public	void clickonRoundTrip()
	 {
 		roundTrip.click();
	 }
	 
		 public void clickonFrom()
		 { 
			 from.click();
			 from.sendKeys("Mumbai");
			 mumbai.click();
			 
		 }
		 public void clickonTo()
		 {
			 to.click();
			 to.sendKeys("Pune");
			 pune.click();
		 }
		 public void clickDepartOnDate()
		 {
			 departOn.click(); 
		 }
		 public void selectNextMonth()
		 {
			 nextMonth.click();
		 }
		 public void selectReturnOnDate()
		 {
			 returnOn.click();
		 }
		 public void selectTravelClass()
		 {
			 travelClass.click();
		 }
		 public void selectAdults() throws InterruptedException
		 {
			 adults.click();Thread.sleep(2000);
			 adults1.click();Thread.sleep(2000);
			 adults1.click();
		 }
		 public void selectChildren() throws InterruptedException
		 {
			 children.click();Thread.sleep(2000);
			 children1.click();
		 }
		 public void selectBusinessclass()
		 {
			 businessclass.click();
		 } 
		 public void clickOnDone()
		 {
			 done.click();
		 }
		 public void clickOnSearch()
		 {
			 search.click();
		 }
	
	
	
	
	
}
