package com.PagesUsingPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageUsingPageFactory {
	WebDriver driver;
	
	public LoginPageUsingPageFactory(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//*[@name='uid' and @type='text']")
	public WebElement usernameField;
	
	@FindBy(how=How.NAME, using="password")
	public WebElement passwordField;
	
	@FindBy(how=How.XPATH, using="//*[@name='btnLogin' and @type='submit']")
	public WebElement submit_botton;
	
	public void loginApplication(String username, String password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		submit_botton.click();
	}

}
