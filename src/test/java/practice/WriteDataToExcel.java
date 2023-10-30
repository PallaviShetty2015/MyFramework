package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcel {

	public static void main(String[] args) throws Throwable 
	{
		//Step:1 Open a doc in java format
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step:2 Create a workbook
		Workbook wb = WorkbookFactory.create(file);
		
		//Step:2 navigate required sheet
		Sheet sheet = wb.getSheet("Sheet2");
		
		//Step:4 create to required row
		Row row = sheet.createRow(0);
		
		//Step:5 create a required cell
		Cell cell = row.createCell(0);
		
		//Step:6 set the value
		cell.setCellValue("Product");
		
		FileOutputStream f1 = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(f1);
		wb.close();
		

	}

}
