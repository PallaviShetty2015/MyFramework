package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage 
{
	//Rule 1:
	
	//Rule 2: Declaration
	
	@FindBy(xpath="//span[@class='dvHeaderText']")	
	private WebElement OrgHeaderTxt;
	
	//Rule 3: Initialization
	public OrgInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Utilization
	public WebElement getOrgHeaderTxt() 
	{
		return OrgHeaderTxt;
	}
	
	//Bussiness library
	
	/**
	 * This method will capture the header text and return it to caller
	 * @return
	 */
	public String getHeaderText()
	{
		return OrgHeaderTxt.getText();
	}
	

}
