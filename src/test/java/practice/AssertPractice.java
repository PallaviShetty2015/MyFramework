package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice 
{
	@Test
	public void practice()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		
		Assert.assertEquals(false, true);
		System.out.println("Step 3");
		System.out.println("Step 4");
		System.out.println("Step 5");

	}
	
	@Test
	public void softPractice()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("Step 1");
		System.out.println("Step 2");
		sa.assertEquals(1, 2);
		
		
		System.out.println("Step 3");
		System.out.println("Step 4");
		sa.assertEquals(false, true);
		System.out.println("Step 5");
		sa.assertAll();
	}
}
