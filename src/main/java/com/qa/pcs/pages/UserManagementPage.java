package com.qa.pcs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.pcs.utils.Constants;
import com.qa.pcs.utils.ElementUtil;
import com.qa.pcs.utils.Log;

public class UserManagementPage {

	// public static final Logger
	// logger=LogManager.getLogger(UserManagementPage.class);

	private WebDriver driver;
	ElementUtil eutil;

	private By add_btn = By.xpath("//button/i[@class='fas fa-plus-circle green_1']");
	private By firstName = By.xpath("//label[text()='First name']//following-sibling::input[@class='md-input']");
	private By lastName = By.xpath("//label[text()='Last name']//following-sibling::input[@class='md-input']");
	private By emailId = By.xpath("//label[text()='Email ID']//following-sibling::input[@class='md-input']");
	private By role_dd = By.xpath("//label[text()='User role']//following-sibling::div//child::input[@type='text']");
	private By role_list = By.xpath("//ul/li/button");
	private By store_dd = By.xpath("//label[text()='Store']//following-sibling::div//child::input[@type='text']");
	private By store_list = By.xpath("//ul/li/button");
	private By Save_btn = By.xpath("//div/button[contains(text(),'Save')]");
	private By email_id_col = By.xpath("//table/thead//th[6]");
	private By email_id_col_values = By.xpath("//table/tbody//tr//td[6]");
	private By dialog_box = By.xpath("(//div[@class='md-dialog']//child::div)[1]");
	private By popup_msg = By.xpath("//div[@class='md-dialog-actions']/preceding-sibling::div");
	private By OK_btn = By.xpath("//div[text()='Ok']");
	private By links_list = By.xpath("//a//i/following-sibling::div");
	private By back_btn = By.xpath("//button[contains(text(),'Back')]");

	public UserManagementPage(WebDriver driver) {

		this.driver = driver;
		eutil = new ElementUtil(driver);

	}
	
	public void navigateToUserManagementAddPage() {
		eutil.doClickWhenReady(add_btn, 5);
		Log.info("Add button is clicked");
	}

	
	  public boolean userCreationSetUp(String fname, String lname, String email,
	  String roleName, String StoreName) {
	  
	  boolean status;
	  
		/*
		 * //eutil.doClickWhenReady(add_btn, 5); //
		 * logger.info("Add button is clicked");
		 */
	  
	  // logger.fatal("Sample fatal message"); 
	  eutil.doSendKeys(firstName, fname);
	  Log.info("First Name value is entered"); 
	  eutil.doSendKeys(lastName, lname);
	  Log.info("Last Name value is entered"); 
	  eutil.doSendKeys(emailId, email);
	  Log.info("Email id value is entered"); 
	  eutil.doClickWhenReady(role_dd, 5);
	  Log.info("Role dropdown is Clicked");
	  eutil.doWaitForVisiblityOfElements(role_list, 5);
	  eutil.doSelectDropdown(role_list, roleName);
	  Log.info("Role value is selected");
	  
	  if (roleName.equals("Store user")) {
	  
	  eutil.doClickWhenReady(store_dd, 5);
	  Log.info("Storename dropdown is Clicked"); 
	  eutil.doSelectDropdown(store_list,StoreName); 
	  Log.info("Storename value is selected");
	  
	  eutil.doClickWhenReady(Save_btn, 5); 
	  Log.info("Save button is Clicked");
	  
	  } else 
	  { eutil.doClickWhenReady(Save_btn, 0);
	  Log.info("Save button is Clicked"); 
	  }
	  
	  eutil.doWaitForVisiblityOfElement(dialog_box, 5); 
	  String popup_text =eutil.GetElement(popup_msg).getText(); 
	  System.out.println(popup_text);
	  eutil.doClick(OK_btn);
	  
	  if (popup_text.equals(Constants.USER_CREATION_SUCCESS_MSG)) { 
		  status =eutil.doFindThePresenceOfValueInGrid(email_id_col_values, email);
	  //System.out.println("#############User Creation in Successful############");
	  Log.info("User Creation is successful"); 
	  return status; 
	  } 
	  else {
	  eutil.doClickWhenReady(back_btn, 5); 
	  Log.error("User Creation is failure");
	  return false;
	  
	  }
	  
	  }
	 
public void editUserDetails(String headName, String expectedColumnValue) {
	
	eutil.doSelectColumn(headName, expectedColumnValue);
	
}
	
	
	public StoreMaintenancePage navigateToStoreMaintenancePage() {

		eutil.doLinkClick(links_list, "Store Maintenance");
		return new StoreMaintenancePage(driver);
	}

	public EnrollmentUploadPage navigateToEnrollmentUploadPage() {

		eutil.doLinkClick(links_list, "Enrollment Upload");
		return new EnrollmentUploadPage(driver);
	}

}
