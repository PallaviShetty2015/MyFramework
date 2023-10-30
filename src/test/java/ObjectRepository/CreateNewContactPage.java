package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility
{
	//Rule 1:
	
	//Rule 2: Declaration
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]'][1]")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//img[@alt='Select'][1]")
	private WebElement OrgLookUpPage;
	
	@FindBy(name="search_text")
	private WebElement OrgSearchEdt;
	
	@FindBy(name="search")
	private WebElement OrgSearchBtn;
	
	
				
	//Rule 3: Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);		
	}

	//Rule 4: Utilization
	
	public WebElement getLastNameEdt() 
	{
		return lastNameEdt;
	}

	public WebElement getSaveBtn() 
	{
		return SaveBtn;
	}

	public WebElement getOrgLookUpPage() 
	{
		return OrgLookUpPage;
	}

	public WebElement getOrgSearchEdt() 
	{
		return OrgSearchEdt;
	}

	public WebElement getOrgSearchBtn() 
	{
		return OrgSearchBtn;
	}
	
	/**
	 * This method will create contact with organization
	 * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 */
	
	public void createNewContact(String LASTNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	
	public void createNewContact(WebDriver driver,String LASTNAME,String ORGNAME)
	{
		
		lastNameEdt.sendKeys(LASTNAME);
		OrgLookUpPage.click();
		swithToHandle(driver, "Accounts");
		OrgSearchEdt.sendKeys(ORGNAME);
		OrgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		swithToHandle(driver, "Contacts");
		SaveBtn.click();
	}
	
	
	
	

}
