package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OraganizationPage 
{
	//Rule 1:
	
	//Rule 2: Declaration
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookUpImg;
			
	//Rule 3: Initialization
	public OraganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4:Utilization
	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}
	
	/**
	 * This method click on CreateOrgLookUp Image
	 * 
	 */
	public void ClickOnOrgLookUpImg()
	{
		CreateOrgLookUpImg.click();
	}
	

}
