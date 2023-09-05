package practice;

import org.testng.annotations.Test;

import com.HOPESTAR.GenericUtility.BaseClass;

public class ParallelExecution1 extends BaseClass{


	@Test
	public void PolicyCreate()throws Throwable
	{
		System.out.println("create policy---------->");
	}
	
	@Test
	public void PolicyDelete()throws Throwable
	{
		System.out.println("delete policy ----------->");
	}
}
