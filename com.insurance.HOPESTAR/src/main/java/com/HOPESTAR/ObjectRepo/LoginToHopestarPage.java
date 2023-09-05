package com.HOPESTAR.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToHopestarPage {

	@FindBy(name="username")
	private WebElement usernameEdt;
	
	@FindBy(name="password")
	private WebElement passwordEdt;
	
	@FindBy(xpath="//button[text()='login']")
	private WebElement loginEdt;
	
	public LoginToHopestarPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginEdt() {
		return loginEdt;
	}
	//business libraries
	public void loginToApplication(String USERNAME, String PASSWORD)
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginEdt.click();
	}
}
