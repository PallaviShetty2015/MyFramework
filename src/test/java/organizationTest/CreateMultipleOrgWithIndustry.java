package organizationTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ObjectRepository.CreateNewOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OraganizationPage;
import ObjectRepository.OrgInfoPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelSheetUtility;
import genericUtilities.JavaFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateMultipleOrgWithIndustry extends BaseClass
{
	/*// Step 1: Create all the required objects
	
		ExcelSheetUtility eUtil = new ExcelSheetUtility();
		JavaFileUtility jUtil = new JavaFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();*/
		
	@Test(dataProvider="getData")
	public void createMultipleOrg(String ORG,String INDUSTRYTYPE) throws Throwable
	{
		String ORGNAME=ORG+jUtil.getRandomNumber();
		
		
		/*//Step 2: Read the recquired data
		String BROWSER = pUtil.readDataFromPropertyFiles("Browser");
		String URL = pUtil.readDataFromPropertyFiles("Url");
		String USERNAME = pUtil.readDataFromPropertyFiles("username");
		String PASSWORD = pUtil.readDataFromPropertyFiles("password");
		WebDriver driver=null;
		
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
				
		//Step 4: Load the URL
		driver.get(URL);
				
		//Step 5: Launch the application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);	*/
		
				
		//Step 6: Click on Organization
		HomePage hp = new HomePage(driver);
		hp.ClickOnOrganizationLnk();
				
		//Step 7: click oraganization lookup imgae
		OraganizationPage op = new OraganizationPage(driver);
		op.ClickOnOrgLookUpImg();
		
		//Step 8: Create Organization with with Mandatory fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.CreateNewOrg(ORGNAME, INDUSTRYTYPE);
		wUtil.captureScreenShot(driver, ORGNAME);
		
		//Step 9: Vlidation
		OrgInfoPage oip = new OrgInfoPage(driver);
		String orgHeader=oip.getHeaderText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		/*if(orgHeader.contains(ORGNAME))
		{
			System.out.println("Organization created");
		}
		else
		{
			System.out.println("Organization not created");
		}*/
		System.out.println(orgHeader);
		
		//Step 10: Signout from application
		hp.logoutOfApp(driver);
		
		System.out.println("Logout successfully");
			
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		return eUtil.readMultipleData("MultipleOrganization");
	}
		
		
		
		
		
		

}
