package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		
		String monthAndYear = "September 2023";
		int date = 22;
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		System.out.println("Chrome browser launched");
		
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		
		driver.navigate().refresh();
		
		Actions act = new Actions(driver);
		act.moveByOffset(40, 40).click().perform();
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		System.out.println("done with departure dropdown");
		String actualDate = "//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		
		String nextArrow = "//span[@aria-label='Next Month']";
		
		for(;;) 
		{
			try {
				System.out.println("entering try block");
				driver.findElement(By.xpath(actualDate)).getText();
				break;
			}
			catch(Exception e)
			{
				System.out.println("entering catch block");
				Thread.sleep(1000);
				driver.findElement(By.xpath(nextArrow)).click();
			}
		}
	}
}
	

