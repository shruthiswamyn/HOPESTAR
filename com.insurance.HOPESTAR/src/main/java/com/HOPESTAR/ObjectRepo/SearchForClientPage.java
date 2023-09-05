package com.HOPESTAR.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchForClientPage {

	@FindBy(xpath="//input[@name='key']")
	private WebElement clientIdEdt;
	
	@FindBy(xpath="//input[@class='searchBtn']")
	private WebElement searchButtonEdt;
	
	@FindBy(xpath="//a[@href='client.php']")
	private WebElement clientModuleLink;
	
	@FindBy(xpath="//a[@href='payment.php']")
	private WebElement paymentModuleLink;
	
	@FindBy(xpath="//a[@href='agent.php']")
	private WebElement agentModuleLink;
	
	@FindBy(xpath="//a[@href='nominee.php']")
	private WebElement nomineeModuleLink;
	
	@FindBy(xpath="//a[@href='logout.php']")
	private WebElement logoutLink;
	
	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getClientIdEdt() {
		return clientIdEdt;
	}

	public WebElement getSearchButtonEdt() {
		return searchButtonEdt;
	}

	public WebElement getPaymentModuleLink() {
		return paymentModuleLink;
	}

	public WebElement getAgentModuleLink() {
		return agentModuleLink;
	}

	public WebElement getNomineeModuleLink() {
		return nomineeModuleLink;
	}
	
	public WebElement getSearchButton() {
		return searchButtonEdt;
	}
	public WebElement getClientModuleLink() {
		return clientModuleLink;
	}


	public SearchForClientPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//business login
	public void searchBasedOnClientId(String clientId)
	{
		clientIdEdt.sendKeys(clientId);
		searchButtonEdt.click();
	}
	public void clickOnClientModule()
	{
		clientModuleLink.click();
	}
	public void clickOnPaymentModule()
	{
		paymentModuleLink.click();
	}
	public void clickOnAgentModule()
	{
		agentModuleLink.click();
	}
	public void clickOnNomineeModule()
	{
		nomineeModuleLink.click();
	}
	public void logout()
	{
		logoutLink.click();
	}
}
