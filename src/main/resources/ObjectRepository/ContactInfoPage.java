package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{
	//Rule 1:
	
	//Rule 2: Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	
			
	//Rule 3: Initialization
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Utilization
	public WebElement getContactHeaderText() 
	{
		return contactHeaderText;
	}
	
	/**
	 * This method will capture the header return it to the caller
	 * 
	 */
	
	public String ContactsListPage()//check this
	{
		return(contactHeaderText.getText());
	}

	
	
	
	

}
