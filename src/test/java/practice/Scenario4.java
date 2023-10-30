package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario4 {

	public static void main(String[] args) throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Swift");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement sel = driver.findElement(By.xpath("//select[@name='industry']"));
		
		Select indus = new Select(sel);
		indus.selectByVisibleText("Energy");
		
		String org = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		WebElement acctype=driver.findElement(By.xpath("//select[@name='accounttype']"));
		
		acctype.click();
		
		Thread.sleep(2000);
		Select type = new Select(acctype);
		type.selectByVisibleText("Customer");
		
		if(org.contains("Swift"))
		   System.out.println("Script pass");
		else
			System.out.println("Script fail");
		
		WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(signout).click().perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("Signout successfully");
	}

}
