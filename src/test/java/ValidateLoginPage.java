import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Constants.Alerts;
import com.Pages.HomePage;
import com.Pages.LoginPage;

/*Test Case Created By Chinmay Moharir
 * Title: Validate Login for the application
*/
public class ValidateLoginPage extends ReadDataFromProperties{
	public static WebDriver driver;
	@Test
	@Parameters({ "URL"})
	public void TC01_ValidLoginCredentials(String URL) throws Exception{
		/*InvokeBrowserSettings invoke = new InvokeBrowserSettings();
		invoke.invokeBrowser(driver, URL);
		*/LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chinmay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//Open URL
		driver.get(URL);
		
		//verify if login page is displayed correctly
		Assert.assertTrue(driver.findElement(login.usernameField).isDisplayed(), "login box is not present on UI");
		Assert.assertTrue(driver.findElement(login.passwordField).isDisplayed(), "password box is not present on UI");
		Assert.assertTrue(driver.findElement(login.loginSubmitButton).isDisplayed(), "login button is not present on UI");
		
		//login to app
		login.typeUsername(driver);
		login.typePassword(driver);
		
		login.loginApp(driver);
		
		//validate login page
		Assert.assertTrue(driver.findElement(home.homePageLogo).isDisplayed(), "Home page logo is not displayed");
		Assert.assertTrue(driver.findElement(home.managerButton).isDisplayed(), "Manager button is not displayed");
		Assert.assertTrue(driver.findElement(home.newCustomerButton).isDisplayed(), "New Customer button is not displayed");
		
		driver.close();
	}
	
	@Test
	@Parameters({ "URL"})
	public void TC02_InValidLoginCredentials(String URL) throws Exception{
		LoginPage login = new LoginPage(driver);
		Alerts alert = new Alerts();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chinmay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//Open URL
		driver.get(URL);
		
		//verify if login page is displayed correctly
		Assert.assertTrue(driver.findElement(login.usernameField).isDisplayed(), "login box is not present on UI");
		Assert.assertTrue(driver.findElement(login.passwordField).isDisplayed(), "password box is not present on UI");
		Assert.assertTrue(driver.findElement(login.loginSubmitButton).isDisplayed(), "login button is not present on UI");
		
		//Enter invalid username and valid password and click login
		login.typeInvalidUsername(driver);
		login.typePassword(driver);
		
		login.loginApp(driver);
		
		//Verify popup is displayed for invalid username and valid password
		Assert.assertEquals(driver.switchTo().alert().getText(), alert.LOGIN_ALERT_POPUP, "Alert message not displayed correctly");
		
		driver.switchTo().alert().accept();

		driver.navigate().to(URL);
		
		//verify if login page is displayed correctly
		Assert.assertTrue(driver.findElement(login.usernameField).isDisplayed(), "login box is not present on UI");
		Assert.assertTrue(driver.findElement(login.passwordField).isDisplayed(), "password box is not present on UI");
		Assert.assertTrue(driver.findElement(login.loginSubmitButton).isDisplayed(), "login button is not present on UI");
				
		//Enter valid username and invalid password and click login
		login.typeUsername(driver);
		login.typeinvalidPassword(driver);
				
		login.loginApp(driver);
		//Verify popup is displayed for valid username and invalid password
		Assert.assertEquals(driver.switchTo().alert().getText(), alert.LOGIN_ALERT_POPUP, "Alert message not displayed correctly");
		
		driver.switchTo().alert().accept();
		
		driver.navigate().to(URL);
		
		//verify if login page is displayed correctly
		Assert.assertTrue(driver.findElement(login.usernameField).isDisplayed(), "login box is not present on UI");
		Assert.assertTrue(driver.findElement(login.passwordField).isDisplayed(), "password box is not present on UI");
		Assert.assertTrue(driver.findElement(login.loginSubmitButton).isDisplayed(), "login button is not present on UI");
				
		//Enter valid username and invalid password and click login
		login.typeInvalidUsername(driver);
		login.typeinvalidPassword(driver);
				
		login.loginApp(driver);
		//Verify popup is displayed for invalid username and invalid password
		Assert.assertEquals(driver.switchTo().alert().getText(), alert.LOGIN_ALERT_POPUP, "Alert message not displayed correctly");
		
		driver.switchTo().alert().accept();
		
		driver.close();
		
		
	}
}
