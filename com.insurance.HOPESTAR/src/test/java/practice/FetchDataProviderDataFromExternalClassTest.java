package practice;

import org.testng.annotations.Test;

public class FetchDataProviderDataFromExternalClassTest {

	
	@Test(dataProviderClass = DataProviderSingleClassTest.class,dataProvider="info")
	public void fetchData(String source, String destination)
	{
		System.out.println("From:"+source+"\t"+"To:"+destination);
	}
	
	@Test(dataProviderClass = DataProviderSingleClassTest.class,dataProvider="data")
	public void fetchData(String source, String destination, int price)
	{
		System.out.println("From:"+source+"\t"+"To:"+destination+"\t"+"Price:"+price);
	}
	
}
