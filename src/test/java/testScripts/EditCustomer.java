package testScripts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Constants.Constant;
import com.Constants.Credentials;
import pageActions.*;

import testBase.*;

public class EditCustomer {

	public WebDriver driver;
	//method to initialize browser before test
	@BeforeMethod
	public void browserSetUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chinmay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		InvokeBrowserSettings invoke = new InvokeBrowserSettings();
		driver = invoke.invokeBrowser("chrome", Constant.URL);
		}
		
		//method to close browser session
	@AfterMethod
	public void cleanUpBrowser() {
			 if (driver != null) {
			        TemporaryFilesystem.getDefaultTmpFS().deleteTemporaryFiles();
			        driver.manage().deleteAllCookies();
			        driver.close();
			        driver.quit();
			    }
		}
	@Test
	public void TC_01() throws Exception{
		//Creating instance of the classes
				LoginPagePF loginpage = PageFactory.initElements(driver, LoginPagePF.class);
				HomePagePF homepage = PageFactory.initElements(driver, HomePagePF.class);
				NewCustomerPF newcust = PageFactory.initElements(driver, NewCustomerPF.class);
				Credentials creds = new Credentials();
				
				//verify if login page is displayed
				Assert.assertTrue(loginpage.usernameField.isDisplayed(), "Login username text box is not displayed");
				Assert.assertTrue(loginpage.passwordField.isDisplayed(), "Login password box is not displayed");
				Assert.assertTrue(loginpage.submit_botton.isDisplayed(), "Login submit button is not displayed");
				
				//login to app
				loginpage.loginApplication(creds.VALID_LOGIN_ID, creds.VALID_PASSWORD);
				
				//login and wait until home page is displayed
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOf(homepage.homePageLogo));
				
				
				//verify home page displayed after valid credentials
				Assert.assertTrue(homepage.homePageLogo.isDisplayed(), "Home page logo is not displayed");
				Assert.assertTrue(homepage.managerButton.isDisplayed(), "Login is not successful");
				Assert.assertTrue(homepage.newCustomerButton.isDisplayed(), "Login is not successful");
				
				//Create new customer
				homepage.clickNewCustomerButton();
				newcust.createNewCustomer();
				String customerId = newcust.customerID.getText();
				System.out.println(customerId);
				
				homepage.searchCustomer(customerId);
				
				
	}
}
