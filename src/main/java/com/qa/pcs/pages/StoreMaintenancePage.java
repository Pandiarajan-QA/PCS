package com.qa.pcs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.pcs.utils.Constants;
import com.qa.pcs.utils.ElementUtil;

public class StoreMaintenancePage {

	private WebDriver driver;
	ElementUtil eutil;

	private By add_btn = By.xpath("//button/i[@class='fas fa-plus-circle green_1']");
	private By storeName = By.xpath("//label[text()='Store name']//following-sibling::input[@class='md-input']");
	private By branchName = By.xpath("//label[text()='Branch name']//following-sibling::input[@class='md-input']");
	private By telephoneNo = By.xpath("//label[text()='Telephone no']//following-sibling::input[@class='md-input']");
	private By postalCode = By.xpath("//label[text()='Postal code']//following-sibling::input[@class='md-input']");
	private By address = By.xpath("//label[text()='Address']//following-sibling::input[@class='md-input']");
	private By EmailId = By.xpath("//label[text()='Email ID']//following-sibling::input[@class='md-input']");
	private By Save_btn = By.xpath("//div/button[contains(text(),'Save')]");
	
	private By dialog_box = By.xpath("(//div[@class='md-dialog']//child::div)[1]");
	private By popup_msg = By.xpath("//div[text()='The record was created successfully.']");
	private By OK_btn = By.xpath("//div[text()='Ok']");
	
	
	public StoreMaintenancePage(WebDriver driver) {
		this.driver = driver;
		eutil=new ElementUtil(driver);

	}
	
	public boolean doStoreCreation(String storeName, String branchName, String telephoneNo,String postalCode,String address, String EmailId) {
		
		eutil.doClickWhenReady(add_btn, 5);
		
		eutil.doSendKeys(this.storeName, storeName);
		eutil.doSendKeys(this.branchName, branchName);
		eutil.doSendKeys(this.telephoneNo, telephoneNo);
		eutil.doSendKeys(this.postalCode, postalCode);
		eutil.doSendKeys(this.address, address);
		eutil.doSendKeys(this.EmailId, EmailId);
		eutil.doClickWhenReady(Save_btn, 5);
		eutil.doWaitForVisiblityOfElement(dialog_box, 5);
		String actual_msg=eutil.doGetElementText(popup_msg);
		eutil.doClickWhenReady(OK_btn, 5);
		if(actual_msg.equals(Constants.STORE_CREATION_SUCCESS_MSG))
			return true;
		else 
			return false;
		
		
	}

}
