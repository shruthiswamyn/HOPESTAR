package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TestNGSingleTest {

	@BeforeSuite
	public void config_BS() throws Throwable
	{
		System.out.println("Open database connection");
	}
	
	@BeforeClass
	public void config_BC()throws Throwable
	{
		System.out.println("Launch browser");
	}
	
	@BeforeMethod
	public void config_BM()throws Throwable
	{
		System.out.println("Login to application");
	}
	@Test
	public void TestScript1()throws Throwable
	{
		System.out.println("Executing the first and only test script");
	}
	@AfterMethod
	public void config_AM()throws Throwable
	{
		System.out.println("Logout from application");
	}
	@AfterClass
	public void config_AC()throws Throwable
	{
		System.out.println("Close browser");
	}
	@AfterSuite
	public void config_AS()throws Throwable
	{
		System.out.println("Close database connection");
	}
}
