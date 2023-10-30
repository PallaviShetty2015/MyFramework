package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.devtools.v113.database.Database;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteTable {

	public static void main(String[] args) throws Throwable 
	{
		Driver driver = new Driver();
		
		//Step:1 Register the driver
		DriverManager.registerDriver(driver);
		
		//Step:2 Get connection with Database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb","root","tiger");

		//Step:3 issue create statement
		Statement state = con.createStatement();
		
		//Step:4 execute a query
		ResultSet result = state.executeQuery("select * from customerinfo");
		
		while(result.next())
		{
			String value=result.getString(1)+" "+result.getInt(2)+" "+result.getString(3);
			System.out.println(value);
		}
		
		//Step:5 close the database
		con.close();
	}
	

}
