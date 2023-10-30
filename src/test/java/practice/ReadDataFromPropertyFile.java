package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Throwable 
	{
		//Step:1 open the document in java readable format
		
		FileInputStream File = new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");

		//Step: 2 Create object of properties form util.package
		
		Properties pro = new Properties();
		
		//Step: 3 Load the file input stream into properties
		pro.load(File);
		
		//Step: 4 provide the key and read value
		String value = pro.getProperty("Browser");
		System.out.println(value);
		
	}

}
