package com.Constants;

import org.openqa.selenium.WebDriver;

public class Alerts {
	WebDriver driver;
	
	public String LOGIN_ALERT_POPUP = "User or Password is not valid";
	public Alerts(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getAlertmessageofpopuup(WebDriver driver){
		String alertmsg = driver.switchTo().alert().getText();
		
		return alertmsg;
	}
	
	public void acceptAlertMessage(WebDriver driver){
		driver.switchTo().alert().accept();
	}
	
}
