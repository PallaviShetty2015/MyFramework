package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class provide implementation to ITestListener interface
 * 
 * @author Pallavi Shetty
 *
 */
public class ListenersImplementationClass implements ITestListener
{
	ExtentReports reports;
	ExtentTest test;

	public void onTestStart(ITestResult result) 
	{
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"==test script execution started====");
		
		//Create a test Script-recognise each @Test
		test=reports.createTest(testScriptName);
		
	}

	public void onTestSuccess(ITestResult result) {
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"== Pass====");
		
	}

	public void onTestFailure(ITestResult result) 
	{
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"==Fail====");
		
		//Exception for failure
		System.out.println(result.getThrowable());
		
		//log for failure
		
		test.log(Status.FAIL,testScriptName+"== Fail ==");
		test.log(Status.INFO,result.getThrowable());
		
		//Screenshot
		String screenShotName = testScriptName+new JavaFileUtility().getSystemDate();
		
		WebDriverUtility w = new WebDriverUtility();
		
		try
		{
			w.captureScreenShot(BaseClass.sdriver,screenShotName);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		} 
		catch (Throwable e) {
			
			e.printStackTrace();
		} 
	}

	public void onTestSkipped(ITestResult result) {
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"==Skipped====");
		
		//log for Skip
		test.log(Status.SKIP,testScriptName+"== Skipped ==");
		test.log(Status.INFO,result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) 
	{
		
		System.out.println("=====Suite execution start====");
		
		ExtentSparkReporter html=new ExtentSparkReporter(".\\ExtentReport\\Report-"+new JavaFileUtility().getSystemDate()+".html");
		html.config().setTheme(Theme.DARK);
		html.config().setDocumentTitle("Exception Report");
		html.config().setReportName("Vtiger execution report");
		
		reports=new ExtentReports();
		
		reports.attachReporter(html);
		reports.setSystemInfo("Base Browser", "Chrome");
		reports.setSystemInfo("Base platform", "Windows");
		reports.setSystemInfo("Base environment", "Testing");
		reports.setSystemInfo("Reporter Name", "Pallavi Shetty");
		
		
	}
	

	public void onFinish(ITestContext context) 
	{
		System.out.println("=====Suite execution start====");
		
		//Report generation
		reports.flush();
		
	}
	
}
