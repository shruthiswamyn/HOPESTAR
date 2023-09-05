package com.HOPESTAR.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewPaymentPage {

	@FindBy(xpath="//input[@name='recipt_no']")
	private WebElement receiptNumberEdt;
	
	@FindBy(xpath="//input[@name='client_id']")
	private WebElement clientIdEdt;
	
	@FindBy(xpath="//input[@name='month']")
	private WebElement monthEdt;
	
	@FindBy(xpath="//input[@name='amount']")
	private WebElement amountEdt;
	
	@FindBy(xpath="//input[@name='due']")
	private WebElement dueEdt;
	
	@FindBy(xpath="//input[@name='fine']")
	private WebElement fineEdt;
	
	@FindBy(xpath="//input[@name='agent_id']")
	private WebElement agentIdEdt;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitButtonEdt;
	
	public AddNewPaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getReceiptNumberEdt() {
		return receiptNumberEdt;
	}

	public WebElement getClientIdEdt() {
		return clientIdEdt;
	}

	public WebElement getMonthEdt() {
		return monthEdt;
	}

	public WebElement getAmountEdt() {
		return amountEdt;
	}

	public WebElement getDueEdt() {
		return dueEdt;
	}

	public WebElement getFineEdt() {
		return fineEdt;
	}
	
	public WebElement getAgentIdEdt() {
		return agentIdEdt;
	}

	public WebElement getSubmitButtonEdt() {
		return submitButtonEdt;
	}

	public void fillAllFieldsToAddPayment(String clientId,String month, String amount, String due, String fine)
	{
		clientIdEdt.sendKeys(clientId);
		monthEdt.sendKeys(month);
		amountEdt.sendKeys(amount);
		dueEdt.sendKeys(due);
		fineEdt.sendKeys(fine);
		
	}
	public void submitAction()
	{
		submitButtonEdt.click();
	}
	public void addPaymentDetailsAndChangeAgentId(String agentId)
	{
		agentIdEdt.clear();
		agentIdEdt.sendKeys(agentId);
	}
}
