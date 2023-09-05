package Payments_Module;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.HOPESTAR.GenericUtility.BaseClass;
import com.HOPESTAR.GenericUtility.ExcelUtility;
import com.HOPESTAR.GenericUtility.FileUtility;
import com.HOPESTAR.GenericUtility.WebDriverUtility;
import com.HOPESTAR.ObjectRepo.AddNewPaymentPage;
import com.HOPESTAR.ObjectRepo.ClientStatusPage;
import com.HOPESTAR.ObjectRepo.ClientsInformationPage;
import com.HOPESTAR.ObjectRepo.LoginToHopestarPage;
import com.HOPESTAR.ObjectRepo.PaymentsInformationPage;
import com.HOPESTAR.ObjectRepo.SearchForClientPage;

import static org.testng.Assert.fail;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddNewPaymentTest extends BaseClass {

	//public static void main(String[] args) throws Throwable {
	@Test(groups="Integration")
	public void AddNewPaymentMethodTest() throws Throwable
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
		
		//Click on 'PAYMENTS' module 

		//driver.findElement(By.xpath("//a[@href='payment.php']")).click();
		SearchForClientPage sfcp = new SearchForClientPage(driver);
		sfcp.clickOnPaymentModule();
		
		//Click on 'Add Payment' Button 

		//driver.findElement(By.xpath("//a[@href='addPayment.php']")).click();
		PaymentsInformationPage pip = new PaymentsInformationPage(driver);
		pip.clickOnAddClientButton();
		
		//Enter the valid data in the required fields(existing client) and click on 'Submit' button
		
		/*FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("AddPayment");*/
		
		//get the recipt number
		String recieptNumber = driver.findElement(By.xpath("//input[@name='recipt_no']")).getText();
		System.out.println(recieptNumber);
		
		int clientId = eUtil.readDataFromExcelReturnInt("AddPayment", 1, 0);
		//int clientId = (int) sh.getRow(1).getCell(0).getNumericCellValue();
		System.out.println("client id--->"+clientId);
		
		//driver.findElement(By.xpath("//input[@name='client_id']")).sendKeys(String.valueOf(clientId));
		
		String month = eUtil.readDataFromExcel("AddPayment", 1, 1);
		//String month = sh.getRow(1).getCell(1).getStringCellValue();
		//driver.findElement(By.xpath("//input[@name='month']")).sendKeys(month);
		
		
		//adding fail() to test listeners
		//fail();
		
		int amount = eUtil.readDataFromExcelReturnInt("AddPayment", 1, 2);
		//int amount = (int) sh.getRow(1).getCell(2).getNumericCellValue();
		//driver.findElement(By.xpath("//input[@name='amount']")).sendKeys(String.valueOf(amount));
		
		int due = eUtil.readDataFromExcelReturnInt("AddPayment", 1, 3);
		//int due = (int) sh.getRow(1).getCell(3).getNumericCellValue();
		//driver.findElement(By.xpath("//input[@name='due']")).sendKeys(String.valueOf(due));
		
		int fine = eUtil.readDataFromExcelReturnInt("AddPayment", 1, 4);
		//int fine = (int) sh.getRow(1).getCell(4).getNumericCellValue();
		//driver.findElement(By.xpath("//input[@name='fine']")).sendKeys(String.valueOf(fine));
		
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		AddNewPaymentPage anpp = new AddNewPaymentPage(driver);
		anpp.fillAllFieldsToAddPayment(String.valueOf(clientId),month, String.valueOf(amount), String.valueOf(due),
				String.valueOf(fine));
		anpp.submitAction();
		
		//validation starts here
		//Click On 'CLIENTS' module 

		//driver.findElement(By.xpath("//a[@href='client.php']")).click();
		sfcp.clickOnClientModule();
		
		//click on 'client status' hyper link 

		//driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/clientStatus.php?client_id=1511986912");
		//driver.findElement(By.xpath("//td[.='"+clientId+"']/following-sibling::td/a[.='Client Status']")).click();
		ClientsInformationPage cip = new ClientsInformationPage(driver);
		cip.clickOnClientStatusOfClientId(driver, String.valueOf(clientId));
		
		//validation
		ClientStatusPage csp = new ClientStatusPage(driver);
		csp.validateAddedPaymentReceiptNumberInClientStatusPage(driver, recieptNumber);
		
		//Click On Logout Button
		//driver.findElement(By.xpath("//a[@href='logout.php']")).click();
	}

}
