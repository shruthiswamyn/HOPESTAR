package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchCheckboxPhoneNames {

public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	
	driver.get("https://www.amazon.in/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("phones");
	driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).submit();
	
	driver.findElement(By.xpath("//span[.='Brand']/../../child::ul/child::span[@data-csa-c-content-id='p_89/Nokia']"
			+ "/descendant::div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']")).click();

}
}
