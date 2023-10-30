package practice;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/** 
 * This class will provide implentation to the RetryAnalyser interface of Test
 * @author Pallavi
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer
{
	int count=0;
	int retryCount=3;
	public boolean retry(ITestResult result) {
		
		while(count<3)
		{
			count++;
			return true;
		}
		return false;
	}

}
