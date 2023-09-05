package practice;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class CalendarTrial {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		String monthyear="April 2024";
		String date="30";
		
		driver.get("https:\\www.makemytrip.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Actions act=new Actions(driver);
		act.moveByOffset(25, 25).click().perform();
		Thread.sleep(7000);
		act.moveByOffset(25, 25).click().perform();
		
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		
		String actual="//div[.='"+monthyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
		
		String arrow="//span[@class='DayPicker-NavButton DayPicker-NavButton--next']";
		
		try {
			
			driver.findElement(By.xpath(actual)).click();
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath(arrow)).click();
		}
			
	}

}