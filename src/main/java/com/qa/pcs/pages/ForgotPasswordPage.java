package com.qa.pcs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.pcs.utils.Constants;
import com.qa.pcs.utils.ElementUtil;

public class ForgotPasswordPage {
	
	private WebDriver driver;
	ElementUtil eutil;
	
	private By email=By.xpath("//label[contains(text(),'Email')]//following-sibling::input[@class='md-input']");
	private By send=By.xpath("//button//div[text()='Send recovery link']");
	private By popup=By.xpath("//span[text()='Success']/parent::div");
	private By popup_msg=By.xpath("//span[text()='Success']/parent::div/child::div[1]");
	private By Ok_btn=By.xpath("//div[text()='Ok']");

	public ForgotPasswordPage(WebDriver driver) {

	this.driver=driver;
	eutil=new ElementUtil(driver);
	
	}

	public boolean doResetPwd(String email) {
		
		eutil.GetElement(this.email).sendKeys(email);
		eutil.doClickWhenReady(send, 5);
		eutil.doWaitForVisiblityOfElement(popup, 10);
		String msg=eutil.doGetElementText(popup_msg);
		eutil.doClickWhenReady(Ok_btn, 5);
		
		if(msg.equals(Constants.FORGOT_PASSWORD_SUCCESS_MSG))
			return true;
		else
			return false;
	}
	
}
