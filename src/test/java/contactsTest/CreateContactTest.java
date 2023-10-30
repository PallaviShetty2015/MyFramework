package contactsTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelSheetUtility;
import genericUtilities.JavaFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(genericUtilities.ListenersImplementationClass.class)
public class CreateContactTest extends BaseClass
{
	//public static void main(String[] args) throws Throwable 
	
	@Test(groups="Smokesuite")
	public void CreateContact() throws Throwable 
	{
		/*//Step 1: Create all the required objects
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
		
		//String ORGNAME = eutil.readDataFromExcel("Contacts", 7, 3) + jutil.getRandomNumber();*/
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2) + jUtil.getRandomNumber();
		
		System.out.println(LASTNAME);
		
		//Step 3: Launch the browser.
		/*if(BROWSER.equalsIgnoreCase("Chrome"))
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
		
		wutil.maximizeWindow(driver);
		wutil.WaitForPageLoad(driver);
		
		//Step 4: Load the URL
		driver.get(URL);

		//Step 5: Login to Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);*/
		
		//Step 6: Click on contacts link
		HomePage hp = new HomePage(driver);
		hp.ClickOnContactsLnk();
		Reporter.log("Contacs clicked");
		
		//Step 7: Click on contacts look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		Reporter.log("Contacs look up image clicked");
		
		//Step 8: Create contacts with mandatory fields
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		Reporter.log("Contacts created");
		
		//Step 9:  Validation for Organization
		ContactInfoPage cip = new ContactInfoPage(driver);
		String conHeader=cip.ContactsListPage();
		Reporter.log("Contacs Header");
		//AssertJUnit.assertTrue(conHeader.contains(LASTNAME));
		//Assert.fail();
		//Reporter.log("Contacs failed");
		
		/*if(conHeader.contains(LASTNAME))
		{
			System.out.println("Contacts created");
		}
		else
		{
			System.out.println("Contact not created");
		}*/
		System.out.println(conHeader);
		
		//Step 10: Signout from application
		hp.logoutOfApp(driver);
		
		System.out.println("Logout successfully");
		
		//driver.quit();
		
	}
	@Test
	public void demo()
	{
		System.out.println("demo");
	}

}
