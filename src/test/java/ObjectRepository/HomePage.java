package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	//Rule 1:
	
	//Rule 2: Declaration
	@FindBy(linkText="Organizations")
	private WebElement orgnizationLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLnk;
	
	@FindBy(linkText="Products")
	private WebElement productLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLnk;
	
	
	//Rule 3: Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Utilization
	
	public WebElement getOrgnizationLnk() {
		return orgnizationLnk;
	}


	public WebElement getContactLnk() {
		return contactLnk;
	}


	public WebElement getProductLnk() {
		return productLnk;
	}


	public WebElement getAdmministratorLnk() {
		return adminImg;
	}


	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	
	//Business Library -generic methods according to the project
	
	/**
	 * This method will click on Organization click
	 */
	
	public void ClickOnOrganizationLnk()
	{
		orgnizationLnk.click();
	}
	/**
	 * This method will click on Contact click
	 */
	
	public void ClickOnContactsLnk()
	{
		contactLnk.click();
	}
	/**
	 * This method will click on Product click
	 */
	
	public void ClickOnProductLnk()
	{
		productLnk.click();
	}
	
	/**
	 * This method will logout of the application
	 * @param driver
	 * @throws InterruptedException 
	 * @throws InteruptedException
	 */
	
	public void logoutOfApp(WebDriver driver) throws InterruptedException
	{
		mouseHoverAction(driver, adminImg);
		Thread.sleep(3000);
		//mouseHoverAction(driver, signoutLnk);
		signoutLnk.click();
		
	}

}
