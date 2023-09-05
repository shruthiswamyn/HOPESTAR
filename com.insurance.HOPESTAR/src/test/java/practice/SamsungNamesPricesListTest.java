package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SamsungNamesPricesListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[.='✕']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("samsung mobiles");
		driver.findElement(By.xpath("//button[@type='submit']")).submit();

		//get list of all phone names
		List<WebElement> allNames = driver.findElements(By.xpath("//div[@class='_3pLy-c row']/descendant::div[@class='_4rR01T']"));
		
		List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='_3pLy-c row']/descendant::div[@class='_30jeq3 _1_WHN1']"));
		
		System.out.println("Number of items in list:"+allNames.size());
		
		for(int i=0;i<allNames.size();i++)
		{
			System.out.println(allNames.get(i).getText()+"----------->"+allPrices.get(i).getText());
		}
		
	}
	
}
