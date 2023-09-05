package com.HOPESTAR.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNomineePage {

	@FindBy(xpath="//input[@name='name']")
	private WebElement nameEdt;
	
	@FindBy(xpath="//input[@name='sex']")
	private WebElement genderEdt;
	
	@FindBy(xpath="//input[@name='birth_date']")
	private WebElement birthDateEdt;
	
	@FindBy(xpath="//input[@name='nid']")
	private WebElement nidEdt;
	
	@FindBy(xpath="//input[@name='relationship']")
	private WebElement relationshipEdt;
	
	@FindBy(xpath="//input[@name='priority']")
	private WebElement priorityEdt;
	
	@FindBy(xpath="//input[@name='phone']")
	private WebElement phoneEdt;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitButton;
	
	public AddNomineePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getNameEdt() {
		return nameEdt;
	}

	public WebElement getGenderEdt() {
		return genderEdt;
	}

	public WebElement getBirthDateEdt() {
		return birthDateEdt;
	}

	public WebElement getNidEdt() {
		return nidEdt;
	}

	public WebElement getRelationshipEdt() {
		return relationshipEdt;
	}

	public WebElement getPriorityEdt() {
		return priorityEdt;
	}

	public WebElement getPhoneEdt() {
		return phoneEdt;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	public void addNomineeDetailsUsingClientStatusLink(String name,String gender,String dob,String nid,
			String relationship,String priority, String phone)
	{
		nameEdt.sendKeys(name);
		genderEdt.sendKeys(gender);
		birthDateEdt.sendKeys(dob);
		nidEdt.sendKeys(nid);
		relationshipEdt.sendKeys(relationship);
		priorityEdt.sendKeys(priority);
		phoneEdt.sendKeys(phone);
		submitButton.click();
	}
	
}
