package com.HOPESTAR.ObjectRepo;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UpdateClientSuccessPage {

	public UpdateClientSuccessPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void validateUpdatedClientDetails(WebDriver driver)
	{
		String search = driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();
		System.out.println(search);
		assertTrue(search.contains("Client record updated successfully"), "Nominee not added - failure");
		/*if(search.contains("Client record updated successfully"))
		{
			System.out.println("Successfully added nominee");
		}*/
	}
	
}
