package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IPhoneNamesPricesListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).submit();

		//get list of all phone names
		List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"
				+ "//span[@class='a-price-whole']"));
		
		List<WebElement> allNames = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//h2"));
		
		System.out.println("Number of items in list:"+allPrices.size());
		
		for(int i=0;i<allPrices.size();i++)
		{
			System.out.println(allNames.get(i).getText()+"--------->"+allPrices.get(i).getText());
		}
		
	}
	

}
