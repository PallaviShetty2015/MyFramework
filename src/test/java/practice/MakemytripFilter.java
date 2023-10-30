package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakemytripFilter {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com");
		
		Actions act=new Actions(driver);
		act.moveByOffset(10, 20).click().perform();
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		act.moveByOffset(10, 20).click().perform();
		
		driver.findElement(By.xpath("//span[@class='check']//ancestor::div[@class='filtersOuter'][1]")).click();
		

	}

}
