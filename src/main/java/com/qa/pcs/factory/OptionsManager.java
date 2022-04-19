package com.qa.pcs.factory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import com.qa.pcs.utils.PropertyUtil;

public class OptionsManager {

	ChromeOptions co;
	FirefoxOptions fo;

public ChromeOptions getChromeOption() {
	
	co=new ChromeOptions();
PropertyUtil putil=new PropertyUtil();

if(Boolean.parseBoolean(putil.getPropertyValue("headless")))
	co.addArguments("--headless");
if(Boolean.parseBoolean(putil.getPropertyValue("incognito")))
	co.addArguments("--incognito");

if(Boolean.parseBoolean(putil.getPropertyValue("certificate_error")))
	
	co.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	co.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	return co;
	
}

}
