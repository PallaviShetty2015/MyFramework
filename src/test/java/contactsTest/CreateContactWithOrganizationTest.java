package contactsTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
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

public class CreateContactWithOrganizationTest extends BaseClass
{
	//public static void main(String[] args) throws Throwable 
	@Test(groups="RegressionTesting")
	public void CreateContactWithOrgTest() throws Throwable
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
				String PASSWORD = putil.readDataFromPropertyFiles("password");*/
				
				
				String ORGNAME = eUtil.readDataFromExcel("Contacts", 7, 3) + jUtil.getRandomNumber();
				String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2);
				
				System.out.println(ORGNAME);
				
				/*//Step 3: Launch the browser.
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
				
				wutil.maximizeWindow(driver);
				wutil.WaitForPageLoad(driver);
				
				//Step 4: Load the URL
				driver.get(URL);
				
				//Step 5: Login to Apllication
				LoginPage lp=new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);*/
				
				//Step 6: Click on organization
				HomePage hp=new HomePage(driver);
				hp.ClickOnOrganizationLnk();
				
				//Step 7: Click on OrganizationLookUpImage
				OraganizationPage op=new OraganizationPage(driver);
				op.ClickOnOrgLookUpImg();
				
				//Step 8: Create organization with mandatory fields
				CreateNewOrganizationPage corg=new CreateNewOrganizationPage(driver);
				corg.CreateNewOrg(ORGNAME);
				
				//Step 9: Validation for Organization
				OrgInfoPage oin=new OrgInfoPage(driver);
				String orgHeader=oin.getHeaderText();
				
				if(orgHeader.contains(ORGNAME))
				{
					System.out.println(orgHeader);
					System.out.println("Organization created");
				}
				else
				{
					System.out.println("Fail");
				}
				
				//Step 10: Click on Contacts Link
				hp.ClickOnContactsLnk();
				
				//Step 11:Click on CreateContactLookUpImage
				
				ContactsPage cp=new ContactsPage(driver);
				cp.clickOnCreateContactLookUpImg();
				
				//Step 12: Create contact with organization
				
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.createNewContact(driver, LASTNAME, ORGNAME);
				
				//Step 13: Validation for Contacts
				OrgInfoPage oip = new OrgInfoPage(driver);
				String conHeader = oip.getHeaderText();
				
				
				AssertJUnit.assertTrue(conHeader.contains(LASTNAME));
				System.out.println("Contacts created");
				
				/*if(conHeader.contains(LASTNAME))
				{
					System.out.println("Contacts created");
					System.out.println(conHeader);
				}
				else
				{
					System.out.println("Fail");
				}*/
				
				//Step 14:Logout from the Application
				hp.logoutOfApp(driver);
				System.out.println("Sign out successfully");
				
				//Step 15:Close the browser
				driver.quit();
				System.out.println("Browser closed");
				
				
				
				
				
				
				

	}

}
