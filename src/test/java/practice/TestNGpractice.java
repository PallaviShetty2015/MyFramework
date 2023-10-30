package practice;

import org.testng.annotations.Test;

public class TestNGpractice 
{
	@Test(invocationCount=3,priority = 1)
	public void CreateCustomer()
	{
		System.out.println("created");
	}
	@Test(invocationCount=2,priority = -2)
	public void modifyCustomer()
	{
		System.out.println("modify");
	}
	@Test(dependsOnMethods ="CreateCustomer")
	public void deleteCustomer()
	{
		System.out.println("deleted");
	}
}