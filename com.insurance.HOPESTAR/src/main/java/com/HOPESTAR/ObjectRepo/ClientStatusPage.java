package com.HOPESTAR.ObjectRepo;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HOPESTAR.GenericUtility.WebDriverUtility;

public class ClientStatusPage{
	

	public ClientStatusPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void reachClientStatusPageOfRespectiveClientId(String clientId,WebDriver driver)
	{
		driver.findElement(By.xpath("//td[.='"+clientId+"']/following-sibling::td/a[.='Client Status']")).click();
		
	}
	public void clickOnAddNomineesLinkInStatusPage(WebDriver driver)
	{
		driver.findElement(By.xpath("//a[.='Add Nominee']")).click();
	}
	public void forValidatingClientStatusPageUsingNomineesLink(String clientId,WebDriver driver)
	{
		driver.findElement(By.xpath("//td[.='"+clientId+"']/following-sibling::td/a[.='Client Status']")).click();
				String search = driver.findElement(By.xpath("//h1[@class='page-head-line']")).getText();
		assertTrue(search.contains("STATUS"),"Client details NOT populated in Client Status page - failure");
		/*if(search.contains("STATUS"))
		{
			System.out.println("Client details successfully populated in Client Status page");
		}*/
	}
	public void validateAddedPaymentReceiptNumberInClientStatusPage(WebDriver driver, String receiptNumber)
	{
		String search = driver.findElement(By.xpath("//table[@class='table']")).getText();
		assertTrue(search.contains(receiptNumber),"New payment not added - failure");
		/*if(search.contains(receiptNumber))
		{
			System.out.println("Successfully added new payment");
		}*/
	}
	
}


