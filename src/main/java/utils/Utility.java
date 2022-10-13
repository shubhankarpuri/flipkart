package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	// 2methods of ScreenShot and Excel file	
	
	// ScreenShot
	
	
	
	public static void screenShot(WebDriver driver,int testID) throws IOException
	{
		
		DateTimeFormatter d= DateTimeFormatter.ofPattern("dd-MM-yyyy HH mm ss");
		LocalDateTime now= LocalDateTime.now();
		String str=d.format(now);
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		File dest= new File("D:\\Shubhankar Puri\\IT Software\\Software "
								+ "Testing\\Automation\\"
							+ "Selenium\\Test-"+testID+" "+str+".jpg");
		
		FileHandler.copy(source,dest);
	}
	
	public static String excelSheet(String a,int b,int e) 
			throws EncryptedDocumentException, IOException 
	{
		String path = "D:\\Shubhankar Puri\\IT Software\\Software "
							+ "Testing\\Automation\\Selenium\\Demo.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		Cell c = WorkbookFactory.create(file).getSheet(a).getRow(b).getCell(e);
		
		try 
		{
			String s = c.getStringCellValue();
			return s;
		}
		catch(Exception r)
		{
			double d = c.getNumericCellValue();
			String st=Double.toString(d);
			return st;
		}
		
	}
	
	
	
}
