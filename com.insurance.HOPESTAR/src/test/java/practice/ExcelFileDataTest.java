package practice;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ExcelFileDataTest {

public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Organization");
		int num = sh.getLastRowNum();
		System.out.println(num);
		
		//read data from excel sheet
		for(int i=1;i<=num;i++)
		{
		Row ro = sh.getRow(i);
		
		Cell ce=ro.getCell(2);
		
		DataFormatter df = new DataFormatter();
		String s=df.formatCellValue(ce);
		System.out.println(s);
		}
		
		//write data into excel sheet
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		Cell cw = sh.createRow(4).createCell(10);
		cw.setCellValue("HOPESTAR life insurance");
		wb.write(fos);
		System.out.println("New data added to excel sheet");
		
		
	}

}