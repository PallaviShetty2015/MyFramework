package practice;

import org.testng.Assert;
import org.testng.annotations.Test;


public class RetryPractice {

	@Test(retryAnalyzer=practice.RetryAnalyserImplementation.class)
	
public void analyserPractice()
{
	Assert.fail();
	System.out.println("Hi");
}

}
