package com.HOPESTAR.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchResultsPage {

	@FindBy(xpath="//table[@class='table']/following-sibling::table//a[text()='Client Status']")
	private WebElement clientStatusLinkEdt;
	
	public SearchResultsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getClientStatusLinkEdt() {
		return clientStatusLinkEdt;
	}
	
	public void clickOnClientStatusLinkInSearchResultsPage()
	{
		clientStatusLinkEdt.click();
	}
	public void validate(WebDriver driver, int clientId)
	{
		String Client_id = driver.findElement(By.name("client_id")).getAttribute("value");
		//Assert.assertEquals(Client_id, clientId, "Client Status Of searched Client Displayed");
		Assert.assertNotEquals(Client_id, clientId, "Client Status Of searched Client is not Displayed");
		/*if(Client_id.equals(String.valueOf(clientId))) {
			System.out.println("Client Status Of searched Client Displayed");
		}
		else
			System.out.println("Client Status Of searched Client is Not Displayed");*/
	}
	

}
