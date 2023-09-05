package com.HOPESTAR.GenericUtility;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.HOPESTAR.ObjectRepo.LoginToHopestarPage;
import com.HOPESTAR.ObjectRepo.SearchForClientPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public DatabaseUtility dUtil = new DatabaseUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public FileUtility fUtil = new FileUtility();
	public ExcelUtility eUtil = new ExcelUtility();
	public static WebDriver driver = null;
	public static WebDriver sdriver = null;
	
	@BeforeSuite(alwaysRun = true)
	public void config_BS() throws Throwable
	{
		System.out.println("Open database connection");
		//dUtil.connectToDB();
	}
	//@Parameters("BROWSER")
	
	@BeforeClass(alwaysRun = true)
	public void config_BC()throws Throwable
	{
		System.out.println("Launch browser");
		String BROWSER = fUtil.readDataFromPropertyFile("browser");
		//commented above line while implementing cross browser execution
		String URL = fUtil.readDataFromPropertyFile("url");
		
		if(BROWSER.equals("chrome"))
		{
			System.out.println("Chrome browser launched successfully");
			WebDriverManager.chromedriver().setup();	
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
		
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equals("edge"))
		{
		
			System.out.println("Edge browser launched successfully");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid browser");
		}
		
		//for listener code..use sdriver=driver;
		//sdriver=driver;
		wUtil.maximizeWindow(driver);
		wUtil.implicitWait(driver);
		driver.get(URL);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void config_BM()throws Throwable
	{
		System.out.println("Login to application");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		LoginToHopestarPage lthp = new LoginToHopestarPage(driver);
		lthp.loginToApplication(USERNAME,PASSWORD);
	}
	
	@AfterMethod(alwaysRun = true)
	public void config_AM()throws Throwable
	{
		System.out.println("Logout from application");
		SearchForClientPage sfcp = new SearchForClientPage(driver);
		sfcp.logout();
	}
	
	@AfterClass(alwaysRun = true)
	public void config_AC()throws Throwable
	{
		System.out.println("Close browser");
		driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
	public void config_AS()throws Throwable
	{
		System.out.println("Close database connection");
		//dUtil.closeDB();
	}
}
