package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class consists of methods to read the data from Property file
 * @author Pallavi Shetty
 *
 */
public class PropertyFileUtility 
{
	/**
	 * This method will return the data from property file and reutn the value
	 * caller
	 * @throws Throwable 
	 */
	public String readDataFromPropertyFiles(String key) throws Throwable
	{
		FileInputStream file=new FileInputStream("src\\test\\resources\\CommonData.Properties");
		Properties pr=new Properties();
		pr.load(file);
		return(pr.getProperty(key));
		
		
		
	}
	

}
