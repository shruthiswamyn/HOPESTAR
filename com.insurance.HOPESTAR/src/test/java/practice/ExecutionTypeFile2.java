package practice;

import org.testng.annotations.Test;

public class ExecutionTypeFile2 {

	@Test(groups="Smoke")
	public void PolicyCreate()throws Throwable
	{
		System.out.println("create policy---------->");
	}
	
	@Test(groups= {"Smoke","Regression"})
	public void PolicyDelete()throws Throwable
	{
		System.out.println("delete policy ----------->");
	}
	
}
