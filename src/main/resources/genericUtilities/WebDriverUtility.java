package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of all generic methods related to web driver action
 * @author Pallavi Shetty
 *
 */
public class WebDriverUtility 
{
	/**This method will maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**This method will minimize the window
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**This method will wait for the window to load
	 * 
	 * @param driver
	 */
	public void WaitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**This method will wait for the particular element  to load in the DOM
	 * 
	 * @param driver
	 */
	public void WaitForElementTobeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**This method will wait for the particular element  to be clickable
	 * 
	 * @param driver
	 */
	public void WaitForElementTobeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//select class
	
	/**
	 * This method will handle the dropdown by index
	 * @param element
	 * @param index
	 */
	
	public void handleDropdown(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
				
	}
	/**
	 * This method will handle the dropdown by value
	 * @param element
	 * @param value
	 */
	
	public void handleDropdown(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
				
	}
	/**
	 * This method will handle the dropdown by visibletext
	 * @param element
	 * @param visibletext
	 */
	
	public void handleDropdown(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
				
	}
	/**
	 * This method will perform mouse hover action
	 * 
	 */
	
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	
	
	/**
	 * This method will perform mouse hover action
	 * 
	 */
	
	public void moveAndClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
	}
	
	/**
	 * This method will perform right click action
	 * 
	 */
	
	public void rightClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
		
	}
	/**
	 * This method will perform double click action
	 * 
	 */
	
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform drag and drop action
	 * 
	 */
	
	public void dragAndDropAction(WebDriver driver,WebElement srcEle,WebElement tarEle)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcEle, tarEle).perform();
	}
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param index
	 * 
	 */
	
	
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame by Name or ID
	 * @param driver
	 * @param index
	 * 
	 */
	
	public void switchToFrame(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);
	}
	
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param element
	 * 
	 */
	
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will scroll down by 500 units
	 * @param driver
	 */
	
	public void scrolldownAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);", "");
	}
	/**
	 * This method will scroll up by 500 units
	 * @param driver
	 */
	
	public void scrollUpAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500);", "");
	}
	
	
	/* Alert popup*/
	
	/**
	 * This method will accept the alert popup
	 * @param driver
	 * 
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will cancel the alert popup
	 * @param driver
	 * 
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will accept the alert Text
	 * @param driver
	 * 
	 */
	public void getAlertText(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	
	// Screenshots
	
	public String captureScreenShot(WebDriver driver,String Screenshotname) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File srs=ts.getScreenshotAs(OutputType.FILE); //temporary location
		File dts=new File(".\\Screenshot"+Screenshotname+".png");
		
		FileUtils.copyFile(srs, dts);
		return dts.getAbsolutePath(); //used for extent reports
		
	}
	
	//Window handling
	
	/**
	 * this method handle all the windows
	 * 
	 */
	
	public void swithToHandle(WebDriver driver,String partialWinTitle)
	{
		//step 1: Get all window ID's
		
		Set<String> allwindows = driver.getWindowHandles();
		
		//step 2: Navigate throgh each window
		for(String WinId: allwindows)
		{
			//Step 3: Switch to each window to capture the title
			String actTitle=driver.switchTo().window(WinId).getTitle();
			
			//Step 4: Compare the title with partial title
			
			if(actTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	

}


