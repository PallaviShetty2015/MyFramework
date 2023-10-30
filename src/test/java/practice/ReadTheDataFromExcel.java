package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheDataFromExcel {

	public static void main(String[] args) throws Throwable 
	{
		//Step:1 Open the doc in the Java readable format
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step:2 Create WorkBook		
		Workbook wb = WorkbookFactory.create(file);
		
		//Step: 3 Navigate to the required sheet
		Sheet sh = wb.getSheet("Sheet2");
		
		//Step: 4 Navigate to the required row	
		Row row = sh.getRow(0);
		
		//Step: 5 Navigate to the required cell
		Cell cell = row.getCell(0);
		
		//Step: 6 Capture the value and print
		String value = cell.getStringCellValue();
		System.out.println(value);
			

	}

}
