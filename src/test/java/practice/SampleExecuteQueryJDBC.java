package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteQueryJDBC {

	public static void main(String[] args) throws SQLException 
	{
		Driver driver = new Driver();
		
		//Step:1 Register the driver
		DriverManager.registerDriver(driver);
		
		//Step:2 Get the connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb","root","tiger");
		
		//Step:3 issue create statement
		Statement state = con.createStatement();
		
		
		//Step:4 Execute any Query
		String query="insert into customerinfo values('Avani',105,'Jaya');";
		
		System.out.println("created");
			
		state.executeUpdate(query);
		
		//Step:5 Close the database
		state.close();

	}

}
