package organizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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

public class CreateOranizationWithIndustryTest extends BaseClass {

	//public static void main(String[] args) throws Throwable 
	//{
		// Step 1: Create all the required objects
		@Test
		public void CreateOranizationWithIndustry() throws Throwable
		{
				/*ExcelSheetUtility eUtil = new ExcelSheetUtility();
				JavaFileUtility jUtil = new JavaFileUtility();
				PropertyFileUtility pUtil = new PropertyFileUtility();
				WebDriverUtility wUtil = new WebDriverUtility();
				WebDriver driver=null;
				
				//Step 2: Extract required data 
				
				String BROWSER = pUtil.readDataFromPropertyFiles("Browser");
				String URL = pUtil.readDataFromPropertyFiles("Url");
				String USERNAME = pUtil.readDataFromPropertyFiles("username");
				String PASSWORD = pUtil.readDataFromPropertyFiles("password");*/
				
				String ORGNAME = eUtil.readDataFromExcel("Organisation", 1, 2) + jUtil.getRandomNumber();
				String INDUSTRY=eUtil.readDataFromExcel("Organisation", 7, 3);
				//String ORGNAME = eUtil.readDataFromExcel("Organisation",1,2)+jUtil.getRandomNumber();
				System.out.println(ORGNAME);
				
				//Step 3: Launch the browser
				
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
					
				
				wUtil.maximizeWindow(driver);
				wUtil.WaitForPageLoad(driver);
				
				//Step 4: Load the URL
				driver.get(URL);
				
				//Step 5: Launch the application
				LoginPage lp=new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);*/
				
				//Step 6: Click on Organization
				HomePage hp = new HomePage(driver);
				hp.ClickOnOrganizationLnk();
				
				//Step 7: click oraganization lookup imgae
				OraganizationPage op = new OraganizationPage(driver);
				op.ClickOnOrgLookUpImg();
				
				//Step 8: Create organization with mandatory fields
				CreateNewOrganizationPage cnorg = new CreateNewOrganizationPage(driver);
				cnorg.CreateNewOrg(ORGNAME, INDUSTRY);
				
				//Step 9: Validation
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

}
