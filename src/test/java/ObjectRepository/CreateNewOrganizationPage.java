package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility
{
	//Rule 1:
	
	//Rule 2: Declaration
	
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDwn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]'][1]")
	private WebElement SaveBtn;
	
	
	//Rule 3: Initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Utilization
	
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}


	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}


	public WebElement getTypeDropDwn() {
		return typeDropDwn;
	}


	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	/**
	 * This method will create oraganization with mandatory fields
	 * @param ORGNAME
	 */
	
	public void CreateNewOrg(String ORGNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	
	/**
	 * This method will create oraganization with industry dropdown
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	
	public void CreateNewOrg(String ORGNAME, String INDUSTRY)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropdown(industryDropDown, INDUSTRY);
		SaveBtn.click();
	}
	
	/**
	 * This method will create oraganization with industry dropdown and type dropdown
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @p
	 */
	
	public void CreateNewOrg(String ORGNAME, String INDUSTRY,String TYPE)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropdown(industryDropDown, INDUSTRY);
		handleDropdown(typeDropDwn,TYPE );
		SaveBtn.click();
	}
	
	

}
