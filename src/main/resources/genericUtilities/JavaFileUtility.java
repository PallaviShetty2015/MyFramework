package genericUtilities;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.*;

/**
 * This class consists of generic method related to java
 * @author Pallavi Shetty
 *
 */

public class JavaFileUtility 
{
/**
 * This method will generate a random number and return it
 * @return
 */

	public int getRandomNumber() 
	{
		Random ran=new Random();
		int value=ran.nextInt(1000);
		return value;		
	}
	
/**
 * This method will capture current system date in required format
 * 
 */

	public String getSystemDate()
	{
		Date d=new Date(0);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String date = formatter.format(d);
		return date;
	}
}
