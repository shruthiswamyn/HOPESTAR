package practice;

import org.testng.annotations.Test;

import com.HOPESTAR.GenericUtility.BaseClass;

public class ParallelExecution3 extends BaseClass{

	public void PaymentCreate()throws Throwable
	{
		System.out.println("create Payment---------->");
	}
	
	@Test
	public void PaymentDelete()throws Throwable
	{
		System.out.println("delete Payment ----------->");
	}
}
