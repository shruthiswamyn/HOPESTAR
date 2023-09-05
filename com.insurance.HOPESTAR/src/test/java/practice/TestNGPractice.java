package practice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGPractice {

	/*@Test(priority=-1)
	public void createData()
	{
		System.out.println("create data..........");
	}
	
	//@Test(priority=0, enabled = false)....TestNG exception results when this method is called because of enabled=false
	//@Ignore....TestNG exception results when this method is called because of @Ignore
	//Test(invocationCount=0)....runs but no execution...no TestNG exception
	@Test()
	public void editData()
	{
		int a[]= {3,4};
		System.out.println(a[9]);
		System.out.println("edit data..........");
	}
	
	@Test(dependsOnMethods= "editData")
	public void deleteData()
	{
		System.out.println("delete data..........");
	}*/
	@Test()
	public void method1()
	{
		System.out.println(" method1..........");
	}
	@Test(dependsOnMethods = "method3")
	public void method2()
	{
		System.out.println(" method2..........");
	}
	@Test()
	public void method3()
	{
		System.out.println(" method3..........");
	}
}
