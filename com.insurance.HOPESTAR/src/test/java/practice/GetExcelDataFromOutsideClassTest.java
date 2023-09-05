package practice;

import org.testng.annotations.Test;

public class GetExcelDataFromOutsideClassTest {

	
	@Test(dataProviderClass = GetDataFromExcelFileTest.class,dataProvider="getDatafromExcel")
	public void getDataFromOutsideClass(String client, String location, String phone, String duration)
	{
	
		System.out.println("Client:"+client+"\t"+"Location:"+location+"\t"+"Phone number:"+phone+"\t"+"Duration:"+duration);
	}
	
}
