package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchInfoOlympics {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		String teamName="Australia";
		String gold = driver.findElement(By.xpath("//span[.='"+teamName+"']/../following-sibling::div[1]//span//span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq']")).getText();
		String silver = driver.findElement(By.xpath("//span[.='"+teamName+"']/../following-sibling::div[2]//span//span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq']")).getText();
		String bronze = driver.findElement(By.xpath("//span[.='"+teamName+"']/../following-sibling::div[3]//span//span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq']")).getText();
		String total = driver.findElement(By.xpath("//span[.='"+teamName+"']/../following-sibling::div[4]//span//span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq']")).getText();
		
		
		System.out.println(teamName+"\t"+gold+"\t"+silver+"\t"+bronze +"\t"+total);
	
	
	}
}
