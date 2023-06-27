import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelData {

	//Since the data is from excel, if we don't use dataProvider then whole excel data will be consumed in 1 test only and we may not know which data from excel has issue
	//if we integrate data provider and excel then each row in excel can be runned in seperate test case and the row containing bug can be found easily 
	
	@DataProvider
	public Object[][] getDataExcel() throws IOException
	{
		FileInputStream fs= new FileInputStream("D:\\CODES\\JAVA\\Eclipse\\Locators\\Test Data.xlsx");
		
		XSSFWorkbook book = new XSSFWorkbook(fs);
		XSSFSheet sh = book.getSheetAt(0);
		XSSFRow row = sh.getRow(0);
		
		//to convert cell data(int) to string
		DataFormatter df = new DataFormatter();
		
		int rowCount = sh.getPhysicalNumberOfRows();
		int columnCount = row.getPhysicalNumberOfCells();
		
		Object data[][] = new Object[rowCount-1][columnCount];
		
		for(int i=0; i<rowCount-1; i++)
		{
			row = sh.getRow(i+1);
			for(int j=0; j<columnCount; j++)
			{				
				data[i][j] = df.formatCellValue(row.getCell(j));
			}
		}
		
		return data;
	
	}
	
	@Test(dataProvider = "getDataExcel")
	public void excelDataTest(String name, String age, String loc, String gen)
	{
		System.out.println(name);
		System.out.println(age);
		System.out.println(loc);
		System.out.println(gen);
	}

}
