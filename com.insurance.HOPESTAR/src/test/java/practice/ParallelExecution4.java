package practice;

import org.testng.annotations.Test;

import com.HOPESTAR.GenericUtility.BaseClass;

public class ParallelExecution4 extends BaseClass{
	public void nomineeCreate()throws Throwable
	{
		System.out.println("create nominee---------->");
	}
	
	@Test
	public void nomineeDelete()throws Throwable
	{
		System.out.println("delete nominee ----------->");
	}
}
