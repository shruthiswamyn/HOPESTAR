package Client_Module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.HOPESTAR.GenericUtility.BaseClass;
import com.HOPESTAR.GenericUtility.ExcelUtility;
import com.HOPESTAR.GenericUtility.FileUtility;
import com.HOPESTAR.GenericUtility.WebDriverUtility;
import com.HOPESTAR.ObjectRepo.ClientStatusPage;
import com.HOPESTAR.ObjectRepo.LoginToHopestarPage;
import com.HOPESTAR.ObjectRepo.SearchForClientPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindClientStatusUsingNomineesLinkTest extends BaseClass{
	//public static void main(String []args) throws Throwable {
	@Test(groups = "Smoke")
	public void findClientStatusUsingNomineesTest() throws Throwable
	{
	/*WebDriver driver = null;
	
	ExcelUtility eLib = new ExcelUtility();
	FileUtility fLib = new FileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
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
			
		/*	if(BROWSER.equals("chrome"))
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
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			wLib.implicitWait(driver);
			
			//Enter the valid data in the required Fields

			/*driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
			driver.findElement(By.xpath("//button[text()='login']")).click();*/
			
			//LoginToHopestarPage lthp = new LoginToHopestarPage(driver);
			//lthp.loginToApplication(USERNAME,PASSWORD);
			
			//Click on 'Nominees' Module
			//driver.findElement(By.xpath("//a[@href='nominee.php']")).click();
			SearchForClientPage sfcp = new SearchForClientPage(driver);
			sfcp.clickOnNomineeModule();
			
			Thread.sleep(5000);
			//Click on 'Client Status' hyperlink.
			//driver.findElement(By.xpath("//a[@href='clientStatus.php?client_id=1511987011']")).click();//do not hard code client id
			
			//user can pick specific record of which client status is to be known.
			//this data can be fetched from excel file as shown below.
			
			int clientId = eUtil.readDataFromExcelReturnInt("EditClientUsingNominees", 1, 0);
			System.out.println("client id value is --->"+clientId);
			
			
			//click on respective client status and do validation
			
			ClientStatusPage csp = new ClientStatusPage(driver);
			csp.forValidatingClientStatusPageUsingNomineesLink(String.valueOf(clientId), driver);
			
			/*driver.findElement(By.xpath("//td[.='"+clientId+"']/following-sibling::td/a[.='Client Status']")).click();
			
			String search = driver.findElement(By.xpath("//h1[@class='page-head-line']")).getText();
			if(search.contains("STATUS"))
			{
				System.out.println("Client details successfully populated in Client Status page");
			}*/
			

}
}
