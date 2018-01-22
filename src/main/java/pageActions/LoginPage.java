/*
 * This page has the objects related to Login page tab using page object
*/
package pageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Constants.Credentials;


public class LoginPage {
	WebDriver driver;
	public By usernameField = By.xpath("//*[@name='uid' and @type='text']");
	public By passwordField = By.xpath("//*[@name='password' and @type='password']");
	public By loginSubmitButton = By.xpath("//*[@name='btnLogin' and @type='submit']");
	public By resetButton  = By.xpath("//*[@name='btnReset' and @type='reset']");

	Credentials creds =  new Credentials();
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void SignIntoAppWithValidUsrPwd(WebDriver driver) {
		driver.findElement(usernameField).sendKeys(creds.VALID_LOGIN_ID);
		driver.findElement(passwordField).sendKeys(creds.VALID_PASSWORD);
		driver.findElement(loginSubmitButton).click();
	}
	
	public void typeUsername(WebDriver driver, String username) {
		driver.findElement(usernameField).sendKeys(username);
	}

	public void typePassword(WebDriver driver, String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	public void clickLoginButton(WebDriver driver) {
		driver.findElement(loginSubmitButton).click();
		
	}
	
	public void typeInvalidUsername(WebDriver driver) {
		driver.findElement(usernameField).sendKeys(creds.INVALID_LOGIN_ID);
	}

	public void typeinvalidPassword(WebDriver driver) {
		driver.findElement(passwordField).sendKeys(creds.INVALID_PASSWORD);
	}
	public void loginApp(WebDriver driver, String username, String password) {
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginSubmitButton).click();
	}
}