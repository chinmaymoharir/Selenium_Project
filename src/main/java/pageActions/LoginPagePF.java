/*
 * This page has the objects related to Login page tab using page factory
*/
package pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPagePF {
	WebDriver driver;
	
	public LoginPagePF(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//*[@name='uid' and @type='text']")
	public WebElement usernameField;
	
	@FindBy(how=How.NAME, using="password")
	public WebElement passwordField;
	
	@FindBy(how=How.XPATH, using="//*[@name='btnLogin' and @type='submit']")
	public WebElement submit_botton;
	
	@FindBy(how=How.XPATH, using="//*[@name='btnReset' and @type='reset']")
	public WebElement reset_botton;
	
	public void loginApplication(String username, String password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		submit_botton.click();
	}

}
