package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchInfoKabaddi {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.prokabaddi.com/standings");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		String teamName="Jaipur Pink Panthers";
		List<WebElement> played = driver.findElements(By.xpath("//p[.='"+teamName+"']/ancestor::div[@class='table standings-table']/descendant::div[@class='table-data matches-play']"));
		List<WebElement> won = driver.findElements(By.xpath("//p[.='"+teamName+"']/ancestor::div[@class='table standings-table']/descendant::div[@class='table-data matches-won']"));
		List<WebElement> lost = driver.findElements(By.xpath("//p[.='"+teamName+"']/ancestor::div[@class='table standings-table']/descendant::div[@class='table-data matches-lost']"));
		List<WebElement> drawn = driver.findElements(By.xpath("//p[.='"+teamName+"']/ancestor::div[@class='table standings-table']/descendant::div[@class='table-data matches-draw']"));
		List<WebElement> scoreDifference = driver.findElements(By.xpath("//p[.='"+teamName+"']/ancestor::div[@class='table standings-table']/descendant::div[@class='table-data score-diff']"));
		
		System.out.println(teamName+"\t"+played.get(1).getText()+"\t"+won.get(1).getText()+"\t"+lost.get(1).getText()
				+"\t"+drawn.get(1).getText()+"\t"+scoreDifference.get(1).getText());
		
	}
}
