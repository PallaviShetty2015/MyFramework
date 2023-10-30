package organizationTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class CreateOrganizationTest extends BaseClass {
	@Test
	public void CreateOrganizationTest() throws Throwable
	{	
		
		String ORGNAME = eUtil.readDataFromExcel("Organisation", 1, 2) + jUtil.getRandomNumber();
		
		//String ORGNAME = eUtil.readDataFromExcel("Organisation",1,2)+jUtil.getRandomNumber();
		System.out.println(ORGNAME);
		
		
		//Step 6: Click on Organization
		HomePage hp = new HomePage(driver);
		hp.ClickOnOrganizationLnk();
		
		//Step 7: click oraganization lookup imgae
		OraganizationPage op = new OraganizationPage(driver);
		op.ClickOnOrgLookUpImg();
		
		//Step 8: Create organization with mandatory fields
		CreateNewOrganizationPage cnorg = new CreateNewOrganizationPage(driver);
		cnorg.CreateNewOrg(ORGNAME);
		
		//Step 9: Validation
		OrgInfoPage oip = new OrgInfoPage(driver);
		String orgHeader=oip.getHeaderText();
		AssertJUnit.assertTrue(orgHeader.contains(ORGNAME));
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
