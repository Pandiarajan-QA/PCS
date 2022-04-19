package com.qa.pcs.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	WebDriver driver;
	
	public ElementUtil(WebDriver driver) {

	this.driver=driver;
	
	}
	
	public WebElement GetElement(By locator) {
		return driver.findElement(locator);
		
	}
	
	public List<WebElement> getElements(By locator){
		
		return driver.findElements(locator);
	}
	

	public String doGetElementText(By locator) {
		return GetElement(locator).getText();
		
	}
	
	public void doSendKeys(By locator, String value) {
		
		WebElement ele=GetElement(locator);
		ele.clear();
		ele.sendKeys(value);
	}
	
	public void doClick(By locator) {
		
		GetElement(locator).click();
		
	}
	
	public void doClickWhenReady(By locator,int timeout) {
		
		doWaitForElementToBeClickable(locator, timeout).click();
		
	}
	
	public WebElement doWaitForElementToBeClickable(By locator, int timeout) {
		
		return new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void doLinkClick(By locator, String linkName) {
		
		List<WebElement> links=getElements(locator);
		for(WebElement ele: links) {
			if(ele.getText().equalsIgnoreCase(linkName)) {
				ele.click();
				break;
			}
			
		}
	}
	
public void doSelectDropdown(By locator, String dropdownvalue) {
		
		List<WebElement> dropdownlist=getElements(locator);
		for(WebElement ele: dropdownlist) {
			if(ele.getText().equalsIgnoreCase(dropdownvalue)) {
				ele.click();
				break;
			}
			
		}
	}
	
public WebElement doWaitForVisiblityOfElement(By locator,int timeout) {
	
	return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(GetElement(locator)));
}

public List<WebElement> doWaitForVisiblityOfElements(By locator,int timeout) {
	
	return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
}

public boolean doFindThePresenceOfValueInGrid(By locator, String valueToCheck) {
	
	boolean status = false;
	
	List<WebElement> values=getElements(locator);
	for(WebElement ele:values) {
		if(ele.getText().equals(valueToCheck)) {
			status=true;
			break;
		}else
			status=false;
		
	}
	
	return status;
}

}
