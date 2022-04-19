package com.qa.pcs.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.pcs.utils.Constants;
import com.qa.pcs.utils.ElementUtil;

public class EnrollmentUploadPage {

	private WebDriver driver;
	ElementUtil eutil;

	private By fileUpload=By.xpath("//input[@type='file']");
	private By upload_btn=By.xpath("(//div[@class='uploadedFile-info']//button/i)[1]");
	private By dialog_box = By.xpath("(//div[@class='md-dialog']//child::div)[1]");
	private By popup_msg = By.xpath("//div/p");
	private By OK_btn = By.xpath("//button[contains(text(),'OK')]");
	
	public EnrollmentUploadPage(WebDriver driver) {

		this.driver = driver;
		eutil = new ElementUtil(driver);

	}
	
	public boolean doFileUpload(String filePath) throws Exception {
		Actions act=new Actions(driver);
		act.moveToElement(eutil.GetElement(fileUpload)).click().perform();
		Thread.sleep(3000);
		Runtime.getRuntime().exec(filePath);
		
		//eutil.GetElement(fileUpload).sendKeys(filePath);
		eutil.doWaitForVisiblityOfElement(upload_btn, 5);
		eutil.doClick(upload_btn);
		eutil.doWaitForVisiblityOfElement(dialog_box, 5);
		String msg=eutil.doGetElementText(popup_msg);
		eutil.doClick(OK_btn);
		if(msg.equals(Constants.FILE_UPLOAD_SUCCESS_MSG))
			return true;
		else
			return false;
		
	}

}
