package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HOPESTAR.GenericUtility.ExcelUtility;

public class HandlingExcelDataProviderGenericClassTest {

	@Test(dataProvider="genericData_excel")
	public void getDataFromOutsideClass(String client, String location, String phone, String duration)
	{
	
		System.out.println("Client:"+client+"\t"+"Location:"+location+"\t"+"Phone number:"+phone+"\t"+"Duration:"+duration);
	}
	
	@DataProvider
	public Object[][] genericData_excel() throws Throwable
	{
		ExcelUtility eUtil = new ExcelUtility();
		Object[][] obj = eUtil.getDatafromExcel("DP");
		return obj;
		
	}
}
