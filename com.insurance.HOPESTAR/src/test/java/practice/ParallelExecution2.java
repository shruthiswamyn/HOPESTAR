package practice;

import org.testng.annotations.Test;

import com.HOPESTAR.GenericUtility.BaseClass;

public class ParallelExecution2 extends BaseClass {

	public void AgentCreate()throws Throwable
	{
		System.out.println("create agent---------->");
	}
	
	@Test
	public void AgentDelete()throws Throwable
	{
		System.out.println("delete agent ----------->");
	}
}
