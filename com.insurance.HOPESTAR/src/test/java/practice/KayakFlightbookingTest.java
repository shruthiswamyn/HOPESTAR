package practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KayakFlightbookingTest {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//div[@class='nrc6-price-section']/descendant::div[@class='oVHK']/child::a/descendant::div[@class='f8F1-price-text-container']/child::div[.='₹ 5,155']	
		driver.get("https://www.kayak.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		
		//click on Flights link
		driver.findElement(By.xpath("//a[@aria-label='Search for flights ']")).click();
		
		//Click on destination flight text field to get airport options
		driver.findElement(By.xpath("//div[@class='zEiP-formField zEiP-destination']"
				+ "/descendant::input[@aria-label='Flight destination input']")).click();
		
		//select destination airport related to Mumbai - click checkbox
		driver.findElement(By.xpath("//ul[@id='flight-destination-smarty-input-list']/child::li[@aria-label='Mumbai, Maharashtra, India']"
				+ "/descendant::span[@class='PVIO PVIO-mod-theme-default PVIO-mod-size-base ']")).click();
		
		driver.findElement(By.xpath("//div[@class='zEiP-formField zEiP-submit']")).click();
		
		
		String flightAmount= driver.findElement(By.xpath("//div[@class='nrc6-price-section']/ancestor::div[@class='yuAt yuAt-pres-rounded']/descendant::div[@class='Oihj-bottom-booking']"+ "/descendant::a[@class='oVHK-fclink']/descendant::div[@class='f8F1-price-text']")).getText();
		//driver.findElement(By.xpath("//div[@class='nrc6']/child::div[2]/descendant::div[@class='f8F1-price-text-container']/div"));
		System.out.println("Flight amount-------->"+flightAmount);
	}
}
