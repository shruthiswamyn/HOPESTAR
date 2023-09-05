package practice;

import org.testng.annotations.Test;

public class ExecutionTypeFile1 {

	@Test
	
	public void AgentCreate()throws Throwable
	{
		System.out.println("create agent---------->");
	}
	
	@Test(groups="Regression")
	public void AgentDelete()throws Throwable
	{
		System.out.println("delete agent ----------->");
	}
	
	
}
