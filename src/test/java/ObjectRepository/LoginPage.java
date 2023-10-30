package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{

	

	//Rule :1
		
	//Rule 2: Declaration
		
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passWordEdt;	
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement loginBtn;
	
	//Rule 3: Intialization
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}

	//Rule 4:Utilization
	
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPassWordEdt() {
		return passWordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Bussiness Library-- generic methods according to the project
	
	/**This method login to the page
	 * @param USERNAME
	 * @param PASSWORD
	 */
	
	public void loginToApp(String USERNAME,String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passWordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
	
	

}
