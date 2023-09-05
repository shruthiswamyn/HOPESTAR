package Client_Module;

import static org.testng.Assert.fail;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.HOPESTAR.GenericUtility.BaseClass;
import com.HOPESTAR.GenericUtility.ExcelUtility;
import com.HOPESTAR.GenericUtility.FileUtility;
import com.HOPESTAR.GenericUtility.WebDriverUtility;
import com.HOPESTAR.ObjectRepo.ClientsInformationPage;
import com.HOPESTAR.ObjectRepo.FillAllFieldsToAddNewClientPage;
import com.HOPESTAR.ObjectRepo.LoginToHopestarPage;
import com.HOPESTAR.ObjectRepo.SearchForClientPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.HOPESTAR.GenericUtility.ListenerImplementationClass.class)
public class AddNewClientTest extends BaseClass{

//public static void main(String[] args) throws Throwable {
//@Test(groups = "Smoke")
@Test //(retryAnalyzer = com.HOPESTAR.GenericUtility.IRetryListenerImplClass.class)
public void AddNewClientFunctionTest() throws Throwable
{
	
		
		//Navigate to application and login as Agent

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
		//driver.manage().window().maximize();
		wLib.maximizeWindow(driver);
		driver.get(URL);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wLib.implicitWait(driver);
		
		//Enter the valid data in the required Fields

		/*driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='login']")).click();*/
		
		/*LoginToHopestarPage lthp = new LoginToHopestarPage(driver);
		lthp.loginToApplication(USERNAME,PASSWORD);*/
		
		//Click on 'CLIENTS' Module 
		
		SearchForClientPage sfcp = new SearchForClientPage(driver);
		sfcp.clickOnClientModule();
		
		//driver.findElement(By.xpath("//a[@href='client.php']")).click();
		
		
		//Click on 'Add Client' Button 

		ClientsInformationPage cip = new ClientsInformationPage(driver);
		cip.clickOnAddClientButton();
		//driver.findElement(By.xpath("//a[@href='addClient.php']")).click();

		//adding intentional fail() here to test listener file
		fail();
		
		//Enter valid data into all fields and click on 'Submit' button
		
		int clientId = eUtil.readDataFromExcelReturnInt("AddClient", 1, 0);
		System.out.println("client id--->"+clientId);
		
		/*FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("AddClient");
		
		//get the recipt number
		//String recieptNumber = driver.findElement(By.xpath("//input[@name='recipt_no']")).getText();
		//System.out.println(recieptNumber);
		
		int clientId = (int) sh.getRow(1).getCell(0).getNumericCellValue();*/
		
		//driver.findElement(By.xpath("//input[@name='client_id']")).clear();
		//driver.findElement(By.xpath("//input[@name='client_id']")).sendKeys(String.valueOf(clientId));


		String password = eUtil.readDataFromExcel("AddClient", 1, 1);
		
		//String password = sh.getRow(1).getCell(1).getStringCellValue();
		//driver.findElement(By.xpath("//input[@name='client_password']")).sendKeys(password);
		
		String name = eUtil.readDataFromExcel("AddClient", 1, 2);
		
		//String name = sh.getRow(1).getCell(2).getStringCellValue();
		//driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
		
		//for file upload
		/*WebElement fileElement = driver.findElement(By.xpath("//input[@name='fileToUpload']"));
		fileElement.sendKeys("C:\\Users\\ckvin\\Downloads\\SampleJPGImage_50kbmb.jpg");*/
		
		String fileLink = eUtil.readDataFromExcel("AddClient", 1, 19);
		
		//String fileLink = sh.getRow(1).getCell(19).getStringCellValue();
		//driver.findElement(By.xpath("//input[@name='fileToUpload']")).sendKeys(fileLink);
		
		//end of file upload
		
		String gender = eUtil.readDataFromExcel("AddClient", 1, 3);
		//String gender = sh.getRow(1).getCell(3).getStringCellValue();
		//driver.findElement(By.xpath("//input[@name='sex']")).sendKeys(gender);
		
		String birthDate = eUtil.readDataFromExcel("AddCLient", 1, 4);
		//String birthDate = sh.getRow(1).getCell(4).getStringCellValue();
		//driver.findElement(By.xpath("//input[@name='birth_date']")).sendKeys(birthDate);
		
		String marital_status = eUtil.readDataFromExcel("AddCLient", 1, 5);
		//String marital_status = sh.getRow(1).getCell(5).getStringCellValue();
		//driver.findElement(By.xpath("//input[@name='maritial_status']")).sendKeys(marital_status);
		
		int nid = eUtil.readDataFromExcelReturnInt("AddClient", 1, 6);
		//int nid = (int) sh.getRow(1).getCell(6).getNumericCellValue();
		//driver.findElement(By.xpath("//input[@name='nid']")).sendKeys(String.valueOf(nid));
		
		String phone = eUtil.readDataFromExcel("AddCLient", 1, 7);
		//String phone = sh.getRow(1).getCell(7).getStringCellValue();
		//driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);
		
		String address = eUtil.readDataFromExcel("AddCLient", 1, 8);
		//String address = sh.getRow(1).getCell(8).getStringCellValue();
		//driver.findElement(By.xpath("//input[@name='address']")).sendKeys(address);
		
		int policyId = eUtil.readDataFromExcelReturnInt("AddClient", 1, 9);
		//int policyId = (int) sh.getRow(1).getCell(9).getNumericCellValue();
		//driver.findElement(By.xpath("//input[@name='policy_id']")).sendKeys(String.valueOf(policyId));
		
		int agentId = eUtil.readDataFromExcelReturnInt("AddClient", 1, 10);
		//int agentId = (int) sh.getRow(1).getCell(10).getNumericCellValue();
		//driver.findElement(By.xpath("//input[@name='agent_id']")).clear();
		//driver.findElement(By.xpath("//input[@name='agent_id']")).sendKeys(String.valueOf(agentId));
		
		//start of nominee information
		int nomineeId = eUtil.readDataFromExcelReturnInt("AddClient", 1, 11);
		//int nomineeId = (int) sh.getRow(1).getCell(11).getNumericCellValue();
		//driver.findElement(By.xpath("//input[@name='nominee_id']")).clear();
		//driver.findElement(By.xpath("//input[@name='nominee_id']")).sendKeys(String.valueOf(nomineeId));
		
		String nameNom = eUtil.readDataFromExcel("AddCLient", 1, 12);
		//String nameNom = sh.getRow(1).getCell(12).getStringCellValue();
		//driver.findElement(By.xpath("//input[@name='nominee_name']")).sendKeys(nameNom);
		
		String genderNom = eUtil.readDataFromExcel("AddCLient", 1, 13);
		//String genderNom = sh.getRow(1).getCell(13).getStringCellValue();
		//driver.findElement(By.xpath("//input[@name='nominee_sex']")).sendKeys(genderNom);
		
		String birthDateNom = eUtil.readDataFromExcel("AddCLient", 1, 14);
		//String birthDateNom = sh.getRow(1).getCell(14).getStringCellValue();
		//driver.findElement(By.xpath("//input[@name='nominee_birth_date']")).sendKeys(birthDateNom);
		
		int nidNom = eUtil.readDataFromExcelReturnInt("AddClient", 1, 15);
		//int nidNom = (int) sh.getRow(1).getCell(15).getNumericCellValue();
		//driver.findElement(By.xpath("//input[@name='nominee_nid']")).sendKeys(String.valueOf(nidNom));
		
		String relationship = eUtil.readDataFromExcel("AddCLient", 1, 16);
		//String relationship = sh.getRow(1).getCell(16).getStringCellValue();
		//driver.findElement(By.xpath("//input[@name='nominee_relationship']")).sendKeys(relationship);
		
		int priority = eUtil.readDataFromExcelReturnInt("AddClient", 1, 17);
		//int priority = (int) sh.getRow(1).getCell(17).getNumericCellValue();
		//driver.findElement(By.xpath("//input[@name='priority']")).sendKeys(String.valueOf(priority));
		
		String phoneNom = eUtil.readDataFromExcel("AddCLient", 1, 18);
		//String phoneNom = sh.getRow(1).getCell(18).getStringCellValue();
		//driver.findElement(By.xpath("//input[@name='nominee_phone']")).sendKeys(phoneNom);
		
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		/*HashMap<String, String> hm = eLib.getMultipleDataFromExcelFile("AddClientMap", 0, 1, driver);
		FillAllFieldsToAddNewClientPage faftanc = new FillAllFieldsToAddNewClientPage(driver);
		faftanc.readAllFieldsFromMap(driver, hm);*/
		
		FillAllFieldsToAddNewClientPage faftanc = new FillAllFieldsToAddNewClientPage(driver);
		faftanc.fillAllFieldsToAddNewClient(String.valueOf(clientId),password,name, fileLink, gender, birthDate,marital_status,
				String.valueOf(nid), phone, address, String.valueOf(policyId), String.valueOf(agentId), String.valueOf(nomineeId),nameNom, genderNom,
				birthDateNom, String.valueOf(nidNom), relationship,String.valueOf(priority), phoneNom);
		
		//validation
		//go to clients module
		
		sfcp.clickOnClientModule();
		//driver.findElement(By.xpath("//a[@href='client.php']")).click();
		cip.validateAddNewClient(driver,String.valueOf(clientId));
	}
  }

