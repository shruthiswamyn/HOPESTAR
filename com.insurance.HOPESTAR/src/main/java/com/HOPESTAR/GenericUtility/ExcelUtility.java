package com.HOPESTAR.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class ExcelUtility {

	/**
	 * This method reads data from excel file
	 * @author Shruthi
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fi);
		String value = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
	public int readDataFromExcelReturnInt(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fi);
		int value = (int)wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
		return value;
	}
	/**
	 * This method writes data into excel file
	 * @author Shruthi
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 */
	
	public void writeIntoExcel(String sheetName, int rowNum, int cellNum,String data) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fi);
		wb.getSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(IPathConstantsUtility.excelFilePath);
		wb.write(fos);
		wb.close();
	}
	
	/**
	 * This method gets last row number
	 * @author Shruthi
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNumber(String sheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fi);
		int rowNumberLast = wb.getSheet(sheetName).getLastRowNum();
		return rowNumberLast;
	}
	
	/**
	 * This method fetches multiple data from excel file using Hashmap collection
	 * @param sheetName
	 * @param lastRowNum
	 * @param cellNumKey
	 * @param cellNumValue
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public HashMap<String, String> getMultipleDataFromExcelFile(String sheetName, int cellNumKey,int cellNumValue, WebDriver driver) throws Throwable, IOException
	{
		FileInputStream fi = new FileInputStream(IPathConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fi);
		int count = wb.getSheet(sheetName).getLastRowNum();
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		for(int i=0;i<=count;i++)
		{
			String key = wb.getSheet(sheetName).getRow(i).getCell(cellNumKey).getStringCellValue();
			String value = wb.getSheet(sheetName).getRow(i).getCell(cellNumValue).getStringCellValue();
			map.put(key, value);
		}
//		for(Entry<String, String> set:map.entrySet())
//		{
//			JavaUtility jLib = new JavaUtility();
//			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+jLib.randomNumberGeneration());
//		}
	
		return map;
	}
	/**
	 * This method is for data provider - taking excel data from utility file
	 * @return
	 * @throws Throwable
	 */
	
	public Object[][] getDatafromExcel(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
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
