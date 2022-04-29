package com.qa.pcs.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	WebDriver driver;
	int headValue;
	
	By table_headers_list=By.xpath("//table//thead//th");
	By next_btn=By.xpath("//button[@aria-label='Next page']");
	By previous_btn=By.xpath("//button[@aria-label='Previous page']");
	
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

public int doFindPositionOfHeader(String headName) {

	headValue = 0;
	List<WebElement> headers = getElements(table_headers_list);
	for (WebElement ele : headers) {
		headValue++;
		if (ele.getText().equals(headName)) {

			System.out.println("The column" + headName + "is located at column of" + headValue);
			break;
		}

	}
	return headValue;

}

public By doFindColumnValuesOfOneHeader(String headName) {

	headValue=doFindPositionOfHeader(headName);
	By col_value_list = By.xpath("//table//tbody//tr//td[" + headValue + "]");
	return col_value_list;
}

public int doFindNoOfPages() {

	int no_of_pages = 1;

	boolean next_btn_status = GetElement(next_btn).isEnabled();

	if (!next_btn_status) {

		no_of_pages = 1;
	} else {
		loop: for (int i = 0; i <= 1; i++) {
			if (next_btn_status) {
				doClickWhenReady(next_btn, 10);
				no_of_pages++;

			} else
				break loop;
			i = 0;
			next_btn_status = GetElement(next_btn).isEnabled();

		}

		System.out.println("No.of.Pages in the list are:" + no_of_pages);
	}

	boolean prev_btn_status = GetElement(previous_btn).isEnabled();

	loop: for (int i = 0; i <= 1; i++) {

		if (prev_btn_status) {
			doClick(previous_btn);
		} else
			break loop;

		i = 0;
		prev_btn_status = GetElement(previous_btn).isEnabled();
	}
	return no_of_pages;
}

public void doSelectColumn(String headName, String expectedColumnValue) {

	By checkbox = By.xpath("(//td[text()='"+ expectedColumnValue +"']/parent::tr/child::td)[1]");

	int no_of_pages = doFindNoOfPages();

	List<WebElement> columnValues = getElements(doFindColumnValuesOfOneHeader(headName));
	System.out.println("No.of.Elements in the list are" + columnValues.size());

	outerloop: for (int i = 1; i <= no_of_pages; i++) {

		try {

			for (WebElement ele : columnValues) {
				String value = ele.getText();
				System.out.println(value);
				if (value.equals(expectedColumnValue)) {

					doClick(checkbox);
					break outerloop;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			doClickWhenReady(next_btn, 10);
			columnValues = getElements(doFindColumnValuesOfOneHeader(headName));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}


}
