package com.Pages;
/*
 * This class has all the details of login page


*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

import com.Constants.Credentials;


public class LoginPage {
	WebDriver driver;
	public By usernameField = By.xpath("//*[@name='uid' and @type='text']");
	public By passwordField = By.xpath("//*[@name='password' and @type='password']");
	public By loginSubmitButton = By.xpath("//*[@name='btnLogin' and @type='submit']");
	Credentials creds =  new Credentials();
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	public void SignIntoAppWithValidUsrPwd(WebDriver driver) {
		driver.findElement(usernameField).sendKeys(creds.VALID_LOGIN_ID);
		driver.findElement(passwordField).sendKeys(creds.VALID_PASSWORD);
		driver.findElement(loginSubmitButton).click();
	}
	
	public void typeUsername(WebDriver driver) {
		driver.findElement(usernameField).sendKeys(creds.VALID_LOGIN_ID);
	}

	public void typePassword(WebDriver driver) {
		driver.findElement(passwordField).sendKeys(creds.VALID_PASSWORD);
	}
	public void loginApp(WebDriver driver) {
		driver.findElement(loginSubmitButton).click();
		
	}
	
	public void typeInvalidUsername(WebDriver driver) {
		driver.findElement(usernameField).sendKeys(creds.INVALID_LOGIN_ID);
	}

	public void typeinvalidPassword(WebDriver driver) {
		driver.findElement(passwordField).sendKeys(creds.INVALID_PASSWORD);
	}
}
