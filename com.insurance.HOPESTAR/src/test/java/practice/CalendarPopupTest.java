package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPopupTest {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String monthYear = "August 2023";
		
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		
		driver.navigate().refresh();
		driver.findElement(By.xpath("//span[@class='sc-12foipm-22 oSYrJ fswDownArrow']")).click();
		
		//Thread.sleep(1000);
		 String screenDate = driver.findElement(By.xpath("//div[text()='"+monthYear+"']/ancestor::div[@class='DayPicker-Months']")).getText();
		System.out.println("-------------"+screenDate);
		for(;;) { 
		 if(screenDate.equalsIgnoreCase(monthYear))
		 {
			 System.out.println("---enter into if loop----------");
			 //driver.findElement(By.xpath("//div[text()='"+monthYear+"']/ancestor::div[@class='DayPicker-Month']/descendant:://div[@aria-label='Thu Aug 17 2023']]")).click();
			 driver.findElement(By.xpath("//div[text()='"+monthYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='16']"));
			 break;
		 }
		 else
		 {
			 System.out.println("---enter into else loop----------");
			 driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			 //DayPicker-NavButton DayPicker-NavButton--next
			 //driver.findElement(By.xpath("DayPicker-NavButton DayPicker-NavButton--next")).click();
			 
		 }
		}
	}

}
