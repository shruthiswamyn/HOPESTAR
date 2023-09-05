package Nominee_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.HOPESTAR.GenericUtility.BaseClass;
import com.HOPESTAR.GenericUtility.ExcelUtility;
import com.HOPESTAR.GenericUtility.FileUtility;
import com.HOPESTAR.GenericUtility.WebDriverUtility;
import com.HOPESTAR.ObjectRepo.EditClientPage;
import com.HOPESTAR.ObjectRepo.LoginToHopestarPage;
import com.HOPESTAR.ObjectRepo.SearchForClientPage;
import com.HOPESTAR.ObjectRepo.UpdateClientSuccessPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditClientUsingNomineesTest extends BaseClass {

//public static void main(String[] args) throws Throwable {
	@Test(groups = "System")
	public void EditClientUsingNomineesLinkTest() throws Throwable
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
				driver.get(URL);
				wLib.implicitWait(driver);
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//Enter the valid data in the required Fields

				/*driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
				driver.findElement(By.xpath("//button[text()='login']")).click();*/
				
				//LoginToHopestarPage lthp = new LoginToHopestarPage(driver);
				//lthp.loginToApplication(USERNAME,PASSWORD);
				
				//Click on 'NOMINEES' module

				//driver.findElement(By.xpath("//a[@href='nominee.php']")).click();
				SearchForClientPage sfcp = new SearchForClientPage(driver);
				sfcp.clickOnNomineeModule();
				
				/*FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				Workbook wb = WorkbookFactory.create(fis1);
				Sheet sh = wb.getSheet("EditClientUsingNominees");*/
				
				int clientId = eUtil.readDataFromExcelReturnInt("EditClientUsingNominees", 1, 0);
				//int clientId = (int) sh.getRow(1).getCell(0).getNumericCellValue();
				System.out.println("client id value is --->"+clientId);
				
				//Click on 'Client Status' link of particular client 
				
				driver.findElement(By.xpath("//a[@href='clientStatus.php?client_id=1511987011']")).click();
				
				
				//Click on 'Edit Client' hyperlink present in the Client's Status' page .
				driver.findElement(By.xpath("//a[@href='editClient.php?client_id=1511987011']")).click();
				Thread.sleep(5000);
				//Modify data in the required fields and click on 'UPDATE button.

				int nid = eUtil.readDataFromExcelReturnInt("EditClientUsingNominees", 1, 1);
				//int nid = (int) sh.getRow(1).getCell(1).getNumericCellValue();
				//driver.findElement(By.xpath("//input[@placeholder='clients NID..']")).clear();
				//driver.findElement(By.xpath("//input[@placeholder='clients NID..']")).sendKeys(String.valueOf(nid));
				System.out.println("nid value is:"+nid);		
				//driver.findElement(By.xpath("//input[@type='submit']")).click();
				
				EditClientPage ecp = new EditClientPage(driver);
				ecp.editRequiredDetailsOfClient(String.valueOf(nid));
				
				Thread.sleep(2000);
				//validation
				//UPDATE CLIENT'   page must be displayed with success message 'Client record updated successfully'
				UpdateClientSuccessPage ucsp = new UpdateClientSuccessPage(driver);
				ucsp.validateUpdatedClientDetails(driver);
				
						
	}
}
