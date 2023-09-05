
package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MatchesMoreThan30 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		List<WebElement> listOfMatches = driver.findElements(By.xpath("//span[.='Matches']/ancestor::div[@class='rankings-block__container full rankings-table']//tr[*]/td[3][text()>30]"));
		for(int i=0;i<listOfMatches.size();i++)
		{
			System.out.println(listOfMatches.get(i).getText());
		}
		System.out.println("Number of countries who have played more than 30 matches:-->"+listOfMatches.size());//15 countries
}
}
