package com.HOPESTAR.ObjectRepo;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NomineesInformationPage {


	public NomineesInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void validateAddedNominee(WebDriver driver, String phone)
	{
		String search = driver.findElement(By.xpath("//table[@class='table']")).getText();
		assertTrue(search.contains(phone), "Nominee not added - failure");
		/*if(search.contains(phone))
		{
			System.out.println("Successfully added nominee");
		}*/
	}
	
}
