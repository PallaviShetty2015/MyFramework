package practice;

import genericUtilities.ExcelSheetUtility;
import genericUtilities.JavaFileUtility;
import genericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Throwable 
	{
		PropertyFileUtility pru=new PropertyFileUtility();
		String un=pru.readDataFromPropertyFiles("username");
		System.out.println(un);
		
		un=pru.readDataFromPropertyFiles("Browser");
		System.out.println(un);
		
		un=pru.readDataFromPropertyFiles("Url");
		System.out.println(un);
		
		un=pru.readDataFromPropertyFiles("password");
		System.out.println(un);

		
		// From excel sheet
		
		/*ExcelSheetUtility ex=new ExcelSheetUtility();
		ex.readDataFromExcel("Sheet1", 1, 3);*/
		
		//from java utility
		JavaFileUtility jv=new JavaFileUtility();
		int r=jv.getRandomNumber();
		System.out.println(r);
		
		String date = jv.getSystemDate();
		System.out.println(date);
		
		
		
		
	}

}
