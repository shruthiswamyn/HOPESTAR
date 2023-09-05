package com.HOPESTAR.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditClientPage {

	@FindBy(xpath="//input[@placeholder='clients NID..']")
	private WebElement nidEdt;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitButton;
	
	public EditClientPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getNidEdt() {
		return nidEdt;
	}


	public WebElement getSubmitButton() {
		return submitButton;
	}


	public void editRequiredDetailsOfClient(String nid)
	{
		nidEdt.clear();
		nidEdt.sendKeys(nid);
		submitButton.click();
	}
}
