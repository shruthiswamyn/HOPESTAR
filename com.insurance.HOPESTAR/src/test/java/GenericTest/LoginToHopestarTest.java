package GenericTest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.HOPESTAR.GenericUtility.BaseClass;
import com.HOPESTAR.GenericUtility.ExcelUtility;
import com.HOPESTAR.GenericUtility.FileUtility;
import com.HOPESTAR.GenericUtility.WebDriverUtility;
import com.HOPESTAR.ObjectRepo.LoginToHopestarPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginToHopestarTest extends BaseClass{

	//public static void main(String[] args) throws Throwable {

	@Test
public void LoginToHopestarTest() {
	
		
		/*String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		
		/*FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Hopestar.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");*/
		
		/*if(BROWSER.equals("chrome"))
		{
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else
		{
			System.out.println("Invalid browser");
		}
		
		wLib.maximizeWindow(driver);
		//driver.manage().window().maximize();
		driver.get(URL);
		wLib.implicitWait(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//optimize code using POM classes
		
		/*driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='login']")).click();*/

		/*LoginToHopestarPage lthp = new LoginToHopestarPage(driver);
		lthp.loginToApplication(USERNAME,PASSWORD);*/
	}

}
