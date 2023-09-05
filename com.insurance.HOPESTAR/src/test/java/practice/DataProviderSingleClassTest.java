package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSingleClassTest {

	
	@Test(dataProvider = "info")
	public void getData(String source, String destination)
	{
	
		System.out.println("From--->"+source+"\t"+"To--->"+destination);
	}
	@Test(dataProvider = "data")
	public void getData(String source, String destination, int price)
	{
	
		System.out.println("From--->"+source+"\t"+"To--->"+destination+"\t"+"Price is:--->"+price);
	}
	@DataProvider
	public Object[][] info()
	{
		Object[][] obj = new Object[2][2];
		
		obj[0][0]="Bangalore";
		obj[0][1]="Mysore";
		
		obj[1][0]="Bangalore";
		obj[1][1]="Pune";
		
		return obj;
		
	}
	@DataProvider
	public Object[][] data()
	{
		Object[][] obj = new Object[2][3];
		
		obj[0][0]="Bangalore";
		obj[0][1]="Mysore";
		obj[0][2]=400;
		
		obj[1][0]="Bangalore";
		obj[1][1]="Pune";
		obj[1][2]=2000;
		return obj;
		
	}
	
}
