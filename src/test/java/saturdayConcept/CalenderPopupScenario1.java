package saturdayConcept;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopupScenario1 {

	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com");
		
		
		Thread.sleep(2000);
		
		Actions act=new Actions(driver);
		act.moveByOffset(10, 20).click().perform();
		WebElement from = driver.findElement(By.xpath("//input[@id='fromCity']"));
		WebElement to = driver.findElement(By.xpath("//input[@id='toCity']"));
		
		from.sendKeys("pune");
		from.click();
		
		
		to.sendKeys("Bangalore");
		
		//driver.findElement(By.xpath("//div[@class='fsw_inputBox dates inactiveWidget ']")).click();
		
		
		//scenario 1
		
		//driver.findElement(By.xpath("//div[@aria-label='Thu Oct 05 2023']")).click();
		
		//Scenario 2
		
		/*while (true) 
		{
			try
			{
				driver.findElement(By.xpath("//div[@aria-label='Fri Dec 08 2023']")).click();
				break;  
			 
			}
			catch(Exception e)
			{	
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}		
				
				
		}*/
		
		//Scenario 3
		
		/*Date d=new Date();
		System.out.println(d);
		String date[]=d.toString().split(" ");
		String currdate=date[0]+" "+date[1]+" "+date[2]+" "+date[5];
		System.out.println(currdate);
		
		driver.findElement(By.xpath("//div[@aria-label='"+currdate+"']")).click();*/
		
		
		

	}

}
