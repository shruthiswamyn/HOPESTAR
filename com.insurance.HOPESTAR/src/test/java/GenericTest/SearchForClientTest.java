package GenericTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.HOPESTAR.GenericUtility.BaseClass;
import com.HOPESTAR.GenericUtility.ExcelUtility;
import com.HOPESTAR.GenericUtility.FileUtility;
import com.HOPESTAR.GenericUtility.WebDriverUtility;
import com.HOPESTAR.ObjectRepo.ClientStatusPage;
import com.HOPESTAR.ObjectRepo.LoginToHopestarPage;
import com.HOPESTAR.ObjectRepo.SearchForClientPage;
import com.HOPESTAR.ObjectRepo.SearchResultsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchForClientTest extends BaseClass{

	@Test(groups = "System")
//public static void main(String[] args) throws Throwable {
	public void SearchForClientTest() throws Throwable {
		
		//login
		/*ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		String BROWSER = fLib.readDataFromPropertyFile("browser");
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
		
		/*driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='login']")).click();*/
		
		/*LoginToHopestarPage lthp = new LoginToHopestarPage(driver);
		lthp.loginToApplication(USERNAME,PASSWORD);

		//click on search text field and enter the  client id
		/*FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Search");*/
		
		int clientId = eUtil.readDataFromExcelReturnInt("Search", 1, 0);
		//int clientId = (int) sh.getRow(1).getCell(0).getNumericCellValue();
		//driver.findElement(By.xpath("//input[@name='key']")).sendKeys(String.valueOf(clientId));
		
		SearchForClientPage sfclp = new SearchForClientPage(driver);
		sfclp.searchBasedOnClientId(String.valueOf(clientId));
		Thread.sleep(2000);
		
	//step-03 Click On Search Button
		//driver.findElement(By.xpath("//input[@class='searchBtn']")).click();
	Thread.sleep(3000);	
		
	//step-04 Click On Client Status Link in Nominee Panel
		//driver.findElement(By.xpath("//table[@class='table']/following-sibling::table//a[text()='Client Status']")).click();
		SearchResultsPage srp = new SearchResultsPage(driver);
		srp.clickOnClientStatusLinkInSearchResultsPage();
			
	//validation
	
		srp.validate(driver,clientId);
	
	}
}
