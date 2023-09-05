package practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BrokenLinks {

	public static void main(String[] args)
	{
		//editing in local branch "shruthi"
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("http://rmgtestingserver:8888/"); //vtiger application link
		driver.get("http://localhost:8888");
		//driver.get("http://www.amazon.in/");
		//driver.get("https://automationbookstore.dev/");
		//driver.get("https://demoqa.com/");
		//driver.get("https://ultimateqa.com/automation");
		//driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);//deprecated for Java 20
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		List<WebElement> listlink=driver.findElements(By.xpath("//a"));//get all links with anchor tag (//a)
		System.out.println(listlink.size());
		
		ArrayList<String> links=new ArrayList<String>();
		
		
		for(int i=0;i<listlink.size();i++)
		{
			String eachlink=listlink.get(i).getAttribute("href");
				
			URL url=null;
			int statusCode=0;
			
			try 
			{
				
				url=new URI(eachlink).toURL();// load the url
								
			   HttpURLConnection httpurlconnection=(HttpURLConnection) url.openConnection();//open the url connnection
			   
				statusCode=httpurlconnection.getResponseCode();
				
				if(statusCode >= 400)//condition for broken link
				{
					links.add(eachlink+"----->"+statusCode+"\n");
				}
			}
			catch(Exception e)
			{
				links.add(eachlink+"----->"+statusCode+"\n");
				
			}
		}
	System.out.println(links);
	}

}
