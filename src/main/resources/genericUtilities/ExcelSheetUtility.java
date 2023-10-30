package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of  Generic methods related Excel sheet
 * @author Pallavi Shetty
 *
 */
public class ExcelSheetUtility 
{
	/**This method will return the data from property file and return the value
	 * caller
	 * @throws Throwable 
	*/
	
	public String readDataFromExcel(String SheetName,int rownum,int cellnum) throws Throwable
	{
		FileInputStream file=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		String value = wb.getSheet(SheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
		return value;
		
	}
	
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		//Sheet sheet = wb.getSheet("MultipleOrganization");
		Sheet sheet = wb.getSheet(sheetName);
		int lastrow = sheet.getLastRowNum();
		int lastcell = sheet.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastrow][lastcell];
		
		for (int i = 0; i < lastrow; i++) 
		{
			for (int j = 0; j < lastcell; j++) 
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		
		}
		return data;
	}
	
}
