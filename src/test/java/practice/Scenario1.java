package practice;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genericUtilities.JavaFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;

public class Scenario1 
{
	public static void main(String[] args) throws Throwable
	{
		
		
		//Read data from Property file
		FileInputStream file = new FileInputStream("src\\test\\resources\\CommonData.Properties");
		
		Properties pr = new Properties();
		pr.load(file);
		
		String URL=pr.getProperty("Url");
		String BROWSER=pr.getProperty("Browser");
		String USERNAME=pr.getProperty("username");
		String PASSWORD=pr.getProperty("password");
		
		System.out.println(URL);
		
		//read the data from the excel sheet
		
		FileInputStream Exfile = new FileInputStream("C:\\Users\\Dell\\Desktop\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(Exfile);
		String LASTNAME = wb.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
		
		WebDriver driver=null;
		
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println(BROWSER+" launched");
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println(BROWSER+" launched");
		}
		else if(BROWSER.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println(BROWSER+" launched");
		}
		else
		{
			System.out.println("Invalid browser name");
		}
				
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver=new FirefoxDriver();
		
		/*WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();*/
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverUtility WDmethod = new WebDriverUtility();
		WDmethod.maximizeWindow(driver);
		
		//driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin",Keys.TAB,"admin",Keys.TAB);
		//driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//contacts link
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Pallavi");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(LASTNAME);
		
		WebElement mrs=driver.findElement(By.xpath("//select[@name='salutationtype']"));
		
		//Select firstname = new Select(mrs);
		//firstname.selectByIndex(2);
		
		WDmethod.handleDropdown(mrs, 2);
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Shetty");
		driver.findElement(By.xpath("//input[@name='account_name']")).sendKeys("Qspiders");
		driver.findElement(By.xpath("//input[@type='submit'][1]")).click();
		
		String namevalidate=driver.findElement(By.id("mouseArea_First Name")).getText();
		
		if(namevalidate.contains("Pallavi"))
		
			System.out.println("Script Pass");
		else
			System.out.println("Script Fail");
		
		WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(signout).click().perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("Signout successfully");
		
		
	}
	 
	
	
	
}
