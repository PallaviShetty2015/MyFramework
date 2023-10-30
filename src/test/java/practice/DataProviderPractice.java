package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice 
{
@Test(dataProvider="getData")
 public void addProductToCart(String name,int pri,int qty,String model)
 {
	 System.out.println("Phone name is "+name+" Price-"+pri+" Quantity- "+qty+"Model - "+model);
 }
@DataProvider
public Object[][] getData()
{
	Object[][] data=new Object[3][4];
	
	data[0][0]="Samasung";
	data[0][1]=10000;
	data[0][2]=20;
	data[0][3]="A20";
	
	data[1][0]="Nokia";
	data[1][1]=12000;
	data[1][2]=40;
	data[1][3]="B6";
	
	data[2][0]="IPhone";
	data[2][1]=15000;
	data[2][2]=60;
	data[2][3]="S14";
	
	return data;
	
}

	

	

}
