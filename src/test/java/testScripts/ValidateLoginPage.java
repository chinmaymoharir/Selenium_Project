package testScripts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Constants.*;
import pageActions.*;
import testBase.*;
/*Test Case Created By Chinmay Moharir
 * Title: Validate Login for the application
 * 
 * 
*/
public class ValidateLoginPage{
	public static WebDriver driver;
	
	//method to set browser properties
	@BeforeMethod
	public void browserSetUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chinmay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		InvokeBrowserSettings invoke = new InvokeBrowserSettings();

		driver = invoke.invokeBrowser("chrome", Constant.URL);
	}
	
	//method to close session
	@AfterMethod
	public void cleanUpBrowser() {
		 if (driver != null) {
		        TemporaryFilesystem.getDefaultTmpFS().deleteTemporaryFiles();
		        driver.close();
		        driver.quit();
		    }
	}
	
	@Test
	public void TC01_ValidLoginCredentials() throws Exception{
		
		//creating instance of the constructor classes
		HomePage home = new HomePage(driver);
		Credentials creds = new Credentials();
		LoginPagePF logpg = PageFactory.initElements(driver, LoginPagePF.class);
		
		//verify if login page is displayed correctly
		Assert.assertTrue(logpg.usernameField.isDisplayed(), "login box is not present on UI");
		Assert.assertTrue(logpg.passwordField.isDisplayed(), "password box is not present on UI");
		Assert.assertTrue(logpg.submit_botton.isDisplayed(), "login button is not present on UI");
		
		//login to app
		logpg.loginApplication(creds.VALID_LOGIN_ID, creds.VALID_PASSWORD);
		
		//validate login page
		Assert.assertTrue(driver.findElement(home.homePageLogo).isDisplayed(), "Home page logo is not displayed");
		Assert.assertTrue(driver.findElement(home.managerButton).isDisplayed(), "Manager button is not displayed");
		Assert.assertTrue(driver.findElement(home.newCustomerButton).isDisplayed(), "New Customer button is not displayed");
		
	}
	
	@Test
	public void TC02_InValidLoginCredentials() throws Exception{
		
		//Creating instances for constructor classes
		Alerts alert = new Alerts(driver);
		LoginPage loginpg = new LoginPage(driver);
		Credentials creds = new Credentials();
		
		//verify if login page is displayed correctly
		Assert.assertTrue(driver.findElement(loginpg.usernameField).isDisplayed(), "login box is not present on UI");
		Assert.assertTrue(driver.findElement(loginpg.passwordField).isDisplayed(), "password box is not present on UI");
		Assert.assertTrue(driver.findElement(loginpg.loginSubmitButton).isDisplayed(), "login button is not present on UI");
		
		
		
		//Enter invalid username and valid password and click login
		loginpg.loginApp(driver, creds.INVALID_LOGIN_ID, creds.VALID_PASSWORD);
		
		//Verify popup is displayed for invalid username and valid password
		Assert.assertEquals(alert.getAlertmessageofpopuup(driver), alert.LOGIN_ALERT_POPUP, "Alert message not displayed correctly");
		
		alert.acceptAlertMessage(driver);

		driver.navigate().to(Constant.URL);
		
		//verify if login page is displayed correctly
		Assert.assertTrue(driver.findElement(loginpg.usernameField).isDisplayed(), "login box is not present on UI");
		Assert.assertTrue(driver.findElement(loginpg.passwordField).isDisplayed(), "password box is not present on UI");
		Assert.assertTrue(driver.findElement(loginpg.loginSubmitButton).isDisplayed(), "login button is not present on UI");
				
		//Enter valid username and invalid password and click login
		loginpg.loginApp(driver, creds.VALID_LOGIN_ID, creds.INVALID_PASSWORD);
		//Verify popup is displayed for valid username and invalid password
		Assert.assertEquals(driver.switchTo().alert().getText(), alert.LOGIN_ALERT_POPUP, "Alert message not displayed correctly");
		
		driver.switchTo().alert().accept();
		
		driver.navigate().to(Constant.URL);
		
		//verify if login page is displayed correctly
		Assert.assertTrue(driver.findElement(loginpg.usernameField).isDisplayed(), "login box is not present on UI");
		Assert.assertTrue(driver.findElement(loginpg.passwordField).isDisplayed(), "password box is not present on UI");
		Assert.assertTrue(driver.findElement(loginpg.loginSubmitButton).isDisplayed(), "login button is not present on UI");
		
		//Enter valid username and invalid password and click login
		loginpg.loginApp(driver, creds.INVALID_LOGIN_ID, creds.INVALID_PASSWORD);
		//Verify popup is displayed for invalid username and invalid password
		Assert.assertEquals(driver.switchTo().alert().getText(), alert.LOGIN_ALERT_POPUP, "Alert message not displayed correctly");
		
		driver.switchTo().alert().accept();
		
		
	}
}