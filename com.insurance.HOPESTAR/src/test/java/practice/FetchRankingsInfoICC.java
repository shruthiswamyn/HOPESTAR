package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchRankingsInfoICC {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		List<WebElement> posIds = driver.findElements(By.xpath("//tbody//tr/td[1]"));
		List<WebElement> countries = driver.findElements(By.xpath("//tbody//tr/td[2]//span[2]"));
		List<WebElement> matches = driver.findElements(By.xpath("//tbody//tr/td[3]"));
		List<WebElement> points = driver.findElements(By.xpath("//tbody//tr/td[4]"));	
		List<WebElement> rating = driver.findElements(By.xpath("//tbody//tr/td[5]"));
	
		for(int i=0;i<posIds.size();i++)
		{
		System.out.println(posIds.get(i).getText()+"\t"+countries.get(i).getText()+"\t"+matches.get(i).getText()+"\t"+points.get(i).getText()+"\t"+rating.get(i).getText());
		}
	}
}
