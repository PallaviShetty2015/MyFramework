package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario5 {

	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin",Keys.TAB,"admin",Keys.TAB);
		//driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//contacts link
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Santhu");
		WebElement mrs=driver.findElement(By.xpath("//select[@name='salutationtype']"));
		
		Select firstname = new Select(mrs);
		firstname.selectByIndex(2);
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Shetty");
		driver.findElement(By.xpath("//input[@name='account_name']")).sendKeys("Qspiders");
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		Thread.sleep(2000);
		
		String mainid = driver.getWindowHandle();
		
		System.out.println(mainid);
		
		Set<String> allwin = driver.getWindowHandles();
		System.out.println(allwin);
		
		for(String a: allwin)
		{
			if(!mainid.equals(a))
			{
				driver.switchTo().window(a);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[.='TCS']")).click();
			}
		}
		driver.switchTo().window(mainid);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		driver.findElement(By.xpath("(//td[@class='small' and @valign='bottom'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		/*driver.findElement(By.xpath("//input[@type='submit'][1]")).click();
		
		String namevalidate=driver.findElement(By.id("mouseArea_First Name")).getText();
		
		if(namevalidate.contains("Pallavi"))
		
			System.out.println("Script Pass");
		else
			System.out.println("Script Fail");
		
		WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(signout).click().perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("Signout successfully");*/
		
		
	}

}
