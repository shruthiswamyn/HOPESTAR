package com.HOPESTAR.ObjectRepo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ClientsInformationPage {

	@FindBy(xpath="//a[@href='addClient.php']")
	private WebElement addClientButtonLink;
	
	public ClientsInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddClientButtonLink() {
		return addClientButtonLink;
	}
	
	public void clickOnAddClientButton()
	{
		addClientButtonLink.click();
	}
	public void validateAddNewClient(WebDriver driver, String clientId)
	{
		String searchForClientId = driver.findElement(By.xpath("//table[@class='table']")).getText();
		
		assertTrue(searchForClientId.contains(String.valueOf(clientId)),"Client not added - failure");
		/*if(searchForClientId.contains(String.valueOf(clientId)))
		{
			System.out.println("Successfully added new client");
		}*/
	}
	public void clickOnClientStatusOfClientId(WebDriver driver, String clientId)
	{
		driver.findElement(By.xpath("//td[.='"+clientId+"']/following-sibling::td/a[.='Client Status']")).click();
		
	}
}
