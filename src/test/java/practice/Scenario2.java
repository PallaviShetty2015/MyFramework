package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario2 
{
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("ABC");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String org = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(org.contains("ABC"))
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
