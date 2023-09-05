package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoIbibo {

	public static void main(String[] args) {
		
		String monthAndYear = "December 2023";
		int date = 24;
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		System.out.println("Chrome browser launched");
		
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		String act = "//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		String next = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']";
		
		
		for(;;) {
			try
			{
				System.out.println("---try block---");
				driver.findElement(By.xpath(act)).click();
				break;
			}
			catch (Exception e) {
				System.out.println("---catch block---");
				driver.findElement(By.xpath(next)).click();
			}
		}
		
		
		
		
	}
}
