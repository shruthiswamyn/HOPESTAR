package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HOPESTAR.GenericUtility.IPathConstantsUtility;

public class GetDataFromExcelFileTest {

	@Test(dataProvider = "getDatafromExcel")
	public void getData(String client, String location, String phone, String duration)
	{
	
		System.out.println("Client--->"+client+"\t"+"Location--->"+location+"\t"+"Phone number-->"+phone+"\t"+"Duration-->"+duration);
	}
	
	@DataProvider
	public Object[][] getDatafromExcel() throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DP");
		int lastRowNumber = sh.getLastRowNum();
		System.out.println("Last row number"+lastRowNumber);
		int lastCellNumber = sh.getRow(0).getLastCellNum();
		System.out.println("Last cell number"+lastCellNumber);
		
		Object[][] obj = new Object[lastRowNumber][lastCellNumber];
		for(int i=1;i<=lastRowNumber;i++)
		{
			for(int j=0;j<lastCellNumber;j++)
			{
				obj[i-1][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return obj;
		
	}
}
