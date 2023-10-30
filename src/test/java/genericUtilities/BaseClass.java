package genericUtilities;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public ExcelSheetUtility eUtil = new ExcelSheetUtility();
	public JavaFileUtility jUtil = new JavaFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver=null;
	
	public static WebDriver sdriver;
	
	//@BeforeTest
	@BeforeSuite(alwaysRun = true)//(groups={"RegressionTesting","Smokesuite"})
	public void bfConfig()
	{
		System.out.println("-------DB connection established-------");		
	}
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String BROWSER*/) throws Throwable
	{
		String URL = pUtil.readDataFromPropertyFiles("Url");
		String BROWSER = pUtil.readDataFromPropertyFiles("Browser");
			
		//Step 3: Launch the browser
		
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
		System.out.println(driver);
					
				
		wUtil.maximizeWindow(driver);
		wUtil.WaitForPageLoad(driver);
		driver.get(URL);
		
		sdriver=driver;
		System.out.println("Browser is launched");
	}
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws Throwable
	{
		
		String USERNAME = pUtil.readDataFromPropertyFiles("username");
		String PASSWORD = pUtil.readDataFromPropertyFiles("password");
		
		
		//Step 5: Launch the application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);	
		
		System.out.println("Log in successfully.....");
		
	}
	@AfterMethod(alwaysRun=true)
	public void amConfig() throws Throwable
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("Logout successfully");
	}

	//@BeforeTest
	@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("Browser closed");
	}
	
	//@AfterTest
	@AfterSuite(alwaysRun=true)
	public void afConfig()
	{
		System.out.println("DB connection closed");
	}
	

}
