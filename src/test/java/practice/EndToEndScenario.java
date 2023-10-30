package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelSheetUtility;
import genericUtilities.JavaFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EndToEndScenario {

	public static void main(String[] args) throws Throwable 
	{
		//Step 1: Create all the required objects
		
				ExcelSheetUtility eutil = new ExcelSheetUtility();
				JavaFileUtility jutil = new JavaFileUtility();
				PropertyFileUtility putil = new PropertyFileUtility();
				WebDriverUtility wutil = new WebDriverUtility();
				WebDriver driver=null;
				
				//Step 2: Read the required data
				String BROWSER = putil.readDataFromPropertyFiles("Browser");
				String URL = putil.readDataFromPropertyFiles("Url");
				String USERNAME = putil.readDataFromPropertyFiles("username");
				String PASSWORD = putil.readDataFromPropertyFiles("password");
				
				String ORGNAME = eutil.readDataFromExcel("organisation", 1, 2)+jutil.getRandomNumber();
				
				System.out.println(ORGNAME);
				
				//Step 3: Launch the browser.
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
				
				wutil.maximizeWindow(driver);
				wutil.WaitForPageLoad(driver);
				
				//Step 4: Load the URL
				driver.get(URL);
				
				//Step 5: Login to the Application
				driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.TAB);
				
				driver.findElement(By.id("submitButton")).click();
				
				//Step 6: Navigate to Organisation link
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step 7: Click on organisation look up image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//Step 8: Create Organisation with mandatory fields
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
				//Step 9: Save
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Step 10: Validate
				
				String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

				if(OrgHeader.contains(ORGNAME))
				{
					System.out.println(ORGNAME);
					System.out.println("Pass");
					
				}
				else
				{
					System.out.println("Fail");
				}
				
				//Step 11:Logout from the application
				
				WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			
				wutil.mouseHoverAction(driver, signout);
				
				driver.findElement(By.linkText("Sign Out")).click();
				
				System.out.println("Logout successfully");
		
	}

}
