package com.HOPESTAR.ObjectRepo;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentsInformationPage {

	@FindBy(xpath="//a[@href='addPayment.php']")
	private WebElement addPaymentButtonLink;
	
	public PaymentsInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddPaymentButtonLink() {
		return addPaymentButtonLink;
	}
	
	public void clickOnAddClientButton()
	{
		addPaymentButtonLink.click();
	}
	public void validateAddedPaymentReceiptNumberInPaymentInformationsPage(WebDriver driver, String receiptNumber)
	{
		String search = driver.findElement(By.xpath("//table[@class='table']")).getText();
		assertTrue(search.contains(receiptNumber), "Payment NOT added using agents id");
		/*if(search.contains(receiptNumber))
		{
			System.out.println("Successfully added new payment using agents id");
		}*/
	}
}
