package com.HOPESTAR.ObjectRepo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HOPESTAR.GenericUtility.ExcelUtility;
import com.HOPESTAR.GenericUtility.JavaUtility;

public class FillAllFieldsToAddNewClientPage extends ExcelUtility{
	JavaUtility j=new JavaUtility();

	@FindBy(xpath="//input[@name='client_id']")
	private WebElement clientIdFieldEdt;
	
	@FindBy(xpath="//input[@name='client_password']")
	private WebElement passwordEdt;
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement nameEdt;
	
	@FindBy(xpath="//input[@name='fileToUpload']")
	private WebElement fileToUploadEdt;
	
	@FindBy(xpath="//input[@name='sex']")
	private WebElement genderEdt;
	
	@FindBy(xpath="//input[@name='birth_date']")
	private WebElement birthDateEdt;
	
	@FindBy(xpath="//input[@name='maritial_status']")
	private WebElement maritalStatusEdt;
	
	@FindBy(xpath="//input[@name='nid']")
	private WebElement nidEdt;
	
	@FindBy(xpath="//input[@name='phone']")
	private WebElement phoneEdt;
	
	@FindBy(xpath="//input[@name='address']")
	private WebElement addressEdt;
	
	@FindBy(xpath="//input[@name='policy_id']")
	private WebElement policyIdEdt;
	
	@FindBy(xpath="//input[@name='agent_id']")
	private WebElement agentIdEdt;
	
	@FindBy(xpath="//input[@name='nominee_id']")
	private WebElement nomineeIdEdt;
	
	@FindBy(xpath="//input[@name='nominee_name']")
	private WebElement nomineeNameEdt;
	
	@FindBy(xpath="//input[@name='nominee_sex']")
	private WebElement nomineeGenderEdt;
	
	@FindBy(xpath="//input[@name='nominee_birth_date']")
	private WebElement nomineeBirthDateEdt;
	
	@FindBy(xpath="//input[@name='nominee_nid']")
	private WebElement nomineeNidEdt;
	
	@FindBy(xpath="//input[@name='nominee_relationship']")
	private WebElement relationshipEdt;
	
	@FindBy(xpath="//input[@name='priority']")
	private WebElement priorityEdt;
	
	@FindBy(xpath="//input[@name='nominee_phone']")
	private WebElement nomineePhoneEdt;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitButtoneEdt;
	
	public FillAllFieldsToAddNewClientPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getClientIdFieldEdt() {
		return clientIdFieldEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getNameEdt() {
		return nameEdt;
	}

	public WebElement getFileToUploadEdt() {
		return fileToUploadEdt;
	}

	public WebElement getGenderEdt() {
		return genderEdt;
	}

	public WebElement getBirthDateEdt() {
		return birthDateEdt;
	}

	public WebElement getMaritalStatusEdt() {
		return maritalStatusEdt;
	}

	public WebElement getNidEdt() {
		return nidEdt;
	}

	public WebElement getPhoneEdt() {
		return phoneEdt;
	}

	public WebElement getAddressEdt() {
		return addressEdt;
	}

	public WebElement getPolicyIdEdt() {
		return policyIdEdt;
	}

	public WebElement getAgentIdEdt() {
		return agentIdEdt;
	}

	public WebElement getNomineeIdEdt() {
		return nomineeIdEdt;
	}

	public WebElement getNomineeNameEdt() {
		return nomineeNameEdt;
	}

	public WebElement getNomineeGenderEdt() {
		return nomineeGenderEdt;
	}

	public WebElement getNomineeBirthDateEdt() {
		return nomineeBirthDateEdt;
	}

	public WebElement getNomineeNidEdt() {
		return nomineeNidEdt;
	}

	public WebElement getRelationshipEdt() {
		return relationshipEdt;
	}

	public WebElement getPriorityEdt() {
		return priorityEdt;
	}

	public WebElement getNomineePhoneEdt() {
		return nomineePhoneEdt;
	}

	public WebElement getSubmitButtoneEdt() {
		return submitButtoneEdt;
	}
	public void fillAllFieldsToAddNewClient(String clientIdPassed, String password, String name, String fileLink,
			String gender, String birthDate, String maritalStatus, String nid, String phone, String address,
			String policyId, String agentId, String nomineeId, String nomineeName, String nomineeGender,
			String nomineeBirthDate, String nomineeNid, String relationship, String priority, String phoneNom)
	
	{
		clientIdFieldEdt.clear();
		clientIdFieldEdt.sendKeys(clientIdPassed);
		passwordEdt.sendKeys(password);
		nameEdt.sendKeys(name);
		fileToUploadEdt.sendKeys(fileLink);
		genderEdt.sendKeys(gender);
		birthDateEdt.sendKeys(birthDate);
		maritalStatusEdt.sendKeys(maritalStatus);
		nidEdt.sendKeys(nid);
		phoneEdt.sendKeys(phone);
		addressEdt.sendKeys(address);
		policyIdEdt.sendKeys(policyId);
		agentIdEdt.clear();
		agentIdEdt.sendKeys(agentId);
		nomineeIdEdt.clear();
		nomineeIdEdt.sendKeys(nomineeId);
		nomineeNameEdt.sendKeys(nomineeName);
		nomineeGenderEdt.sendKeys(nomineeGender);
		nomineeBirthDateEdt.sendKeys(nomineeBirthDate);
		nomineeNidEdt.sendKeys(nomineeNid);
		relationshipEdt.sendKeys(relationship);
		priorityEdt.sendKeys(priority);
		nomineePhoneEdt.sendKeys(phoneNom);
		submitButtoneEdt.click();
	}
	/*public void readAllFieldsFromMap(WebDriver driver, HashMap<String, String> hm) throws Throwable 
	{
		
		for(Entry<String, String> set:hm.entrySet())
			{
				
				//driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+j.randomNumberGeneration());
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
		
	}*/
}
