package Client_Module;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.HOPESTAR.GenericUtility.BaseClass;
import com.HOPESTAR.GenericUtility.ExcelUtility;
import com.HOPESTAR.GenericUtility.FileUtility;
import com.HOPESTAR.GenericUtility.WebDriverUtility;
import com.HOPESTAR.ObjectRepo.AddNomineePage;
import com.HOPESTAR.ObjectRepo.ClientStatusPage;
import com.HOPESTAR.ObjectRepo.LoginToHopestarPage;
import com.HOPESTAR.ObjectRepo.NomineesInformationPage;
import com.HOPESTAR.ObjectRepo.SearchForClientPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddNomineeUsingClientStatusLinkTest extends BaseClass{

	//public static void main(String[] args) throws Throwable {
	@Test(groups = "System")

	public void AddNomineeUsingClientStatusLinkFunctionTest() throws Throwable
	{	
		/*ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		WebDriver driver = null;
		
		//Open the browser and enter the url

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
				
				wLib.implicitWait(driver);driver.get(URL);
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//Enter the valid data in the required Fields

				/*driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
				driver.findElement(By.xpath("//button[text()='login']")).click();*/
				
				//LoginToHopestarPage lthp = new LoginToHopestarPage(driver);
				//lthp.loginToApplication(USERNAME,PASSWORD);
				
				//Click on 'CLIENTS' module

				//driver.findElement(By.xpath("//a[@href='client.php']")).click();
				SearchForClientPage sfcp = new SearchForClientPage(driver);
				sfcp.clickOnClientModule();
				
				/*FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				Workbook wb = WorkbookFactory.create(fis1);
				Sheet sh = wb.getSheet("AddNomineeUsingClientStatusLink");*/
				
				int clientId = eUtil.readDataFromExcelReturnInt("AddNomineeUsingClientStatusLink", 1, 0);
				System.out.println("client id --->"+clientId);
				
				/*int clientId = (int) sh.getRow(1).getCell(0).getNumericCellValue();
				System.out.println("client id value is --->"+clientId);*/
				
				//Click on 'Client Status' link of particular client 
				
				//driver.findElement(By.xpath("//a[@href='clientStatus.php?client_id=1666852816']")).click();

				ClientStatusPage csp = new ClientStatusPage(driver);
				csp.reachClientStatusPageOfRespectiveClientId(String.valueOf(clientId), driver);
				
				//Click on 'Add Nominee' link in the Client Status page
				csp.clickOnAddNomineesLinkInStatusPage(driver);
				
				//Enter all the nominee related details and click on Submit button
				
				String name = eUtil.readDataFromExcel("AddNomineeUsingClientStatusLink", 1, 1);
				//String name = sh.getRow(1).getCell(1).getStringCellValue();
				//driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
				
				String gender = eUtil.readDataFromExcel("AddNomineeUsingClientStatusLink", 1, 2);
				//String gender = sh.getRow(1).getCell(2).getStringCellValue();
				//driver.findElement(By.xpath("//input[@name='sex']")).sendKeys(gender);
				
				String dob = eUtil.readDataFromExcel("AddNomineeUsingClientStatusLink", 1, 3);
				//String dob = sh.getRow(1).getCell(3).getStringCellValue();
				//driver.findElement(By.xpath("//input[@name='birth_date']")).sendKeys(dob);
				
				int nid = eUtil.readDataFromExcelReturnInt("AddNomineeUsingClientStatusLink", 1, 4);
				//int nid = (int) sh.getRow(1).getCell(4).getNumericCellValue();
				//driver.findElement(By.xpath("//input[@name='nid']")).sendKeys(String.valueOf(nid));
				
				String relationship = eUtil.readDataFromExcel("AddNomineeUsingClientStatusLink", 1, 5);
				//String relationship = sh.getRow(1).getCell(5).getStringCellValue();
				//driver.findElement(By.xpath("//input[@name='relationship']")).sendKeys(relationship);
				
				int priority = eUtil.readDataFromExcelReturnInt("AddNomineeUsingClientStatusLink", 1, 6);
				//int priority = (int) sh.getRow(1).getCell(6).getNumericCellValue();
				//driver.findElement(By.xpath("//input[@name='priority']")).sendKeys(String.valueOf(priority));
				
				String phone = eUtil.readDataFromExcel("AddNomineeUsingClientStatusLink", 1, 7);
				//String phone = sh.getRow(1).getCell(7).getStringCellValue();
				//driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);
				
				//driver.findElement(By.xpath("//input[@type='submit']")).click();
				
				AddNomineePage anp = new AddNomineePage(driver);
				anp.addNomineeDetailsUsingClientStatusLink(name,gender,dob,String.valueOf(nid),relationship,String.valueOf(priority), phone);
				
				//Click on 'NOMINEE' module

				//driver.findElement(By.xpath("//a[@href='nominee.php']")).click();
				sfcp.clickOnNomineeModule();
				
				NomineesInformationPage nip = new NomineesInformationPage(driver);
				nip.validateAddedNominee(driver, phone);
				
				
	}

}
