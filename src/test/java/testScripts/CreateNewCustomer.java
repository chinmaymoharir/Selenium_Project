package testScripts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class CreateNewCustomer {
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
	public void TC_01_Positive() throws Exception{
		
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
		WebElement waitelement = wait.until(ExpectedConditions.visibilityOf(homepage.homePageLogo));
		
		
		//verify home page displayed after valid credentials
		Assert.assertTrue(homepage.homePageLogo.isDisplayed(), "Home page logo is not displayed");
		Assert.assertTrue(homepage.managerButton.isDisplayed(), "Login is not successful");
		Assert.assertTrue(homepage.newCustomerButton.isDisplayed(), "Login is not successful");
		
		//click on UI to bring in the warning
		homepage.newCustomerButton.click();


		//check if add new customer tab is present
		Assert.assertTrue(newcust.addNewCustomerLabel.isDisplayed(), "Add new customer option is not visible");
		//check if customer name textbox is present		
		Assert.assertTrue(newcust.customerNameTxtField.isDisplayed(), "Customer name text box is not presernt");

		//type name of customer
		newcust.typeCustomerName("Chinmay");
		
		
		//check if male female radio button is visible
		Assert.assertTrue(newcust.maleRadioButton.isDisplayed(), "Male chekbox not visible");
		Assert.assertTrue(newcust.femaleRadioButton.isDisplayed(), "Female chekbox not visible");
		
		//select female gender radio button
		newcust.checkRadioButtonGender("f");
		//select male gender radio button
		newcust.checkRadioButtonGender("mAlE");

		//inout date of birth
		Assert.assertTrue(newcust.dobField.isDisplayed(), "Date of birth field is no visible");
		newcust.setDob("12", "02", "1990");
		
		//input address field
		Assert.assertTrue(newcust.addrressTxtField.isDisplayed(), "Address text box is not visible");
		newcust.typeAddress("2404 Nutwood Avenue");
		
		//input city field
		Assert.assertTrue(newcust.cityTxtField.isDisplayed(), "City text box is not visible");
		newcust.typeCity("Fullerton");
		
		//input state field
		Assert.assertTrue(newcust.stateTxtField.isDisplayed(), "State text box is not visible");
		newcust.typeState("California");
	
		//input pin number field
		Assert.assertTrue(newcust.pinNoField.isDisplayed(), "Postal code text box is not visible");
		newcust.typePinNo("928311");

		//input telephone number
		Assert.assertTrue(newcust.telephoneField.isDisplayed(), "Telephone Number text box is not visible");
		newcust.typeTelephone("1234567890");

		//input email id
		Assert.assertTrue(newcust.emailIDField.isDisplayed(), "Email text box is not visible");
		newcust.typevalidEmailID();
		
		//inout password
		Assert.assertTrue(newcust.passwordField.isDisplayed(), "Password box is not visible");
		newcust.typePassword("abcde12345");

		//submit new customer details
		Assert.assertTrue(newcust.submitNewCustButton.isDisplayed(), "Submit button is not displayed");
		newcust.submitNewCust();

		//validate customer creation
		Assert.assertTrue(newcust.customerRegistrationSuccess.isDisplayed(), "Customer was not created successfully");
		String customerId = newcust.customerID.getText();
		System.out.println(customerId);
		
	}
	
	@Test
	public void TC_02_Negative() throws Exception{
		
			//Creating instance of the classes
			HomePagePF homepage = PageFactory.initElements(driver, HomePagePF.class);
			NewCustomerPF newcust = PageFactory.initElements(driver, NewCustomerPF.class);
			LoginPagePF loginpage = PageFactory.initElements(driver, LoginPagePF.class);
			Credentials creds = new Credentials();
			
			//verify if login page is displayed
			Assert.assertTrue(loginpage.usernameField.isDisplayed(), "Username text field is not displayed on UI");
			Assert.assertTrue(loginpage.passwordField.isDisplayed(), "Password text field is not displayed on UI");
			Assert.assertTrue(loginpage.submit_botton.isDisplayed(), "Submit button is not displayed on UI");
			loginpage.loginApplication(creds.VALID_LOGIN_ID, creds.VALID_PASSWORD);
			
			//verify home page displayed after valid credentials
			Assert.assertTrue(homepage.homePageLogo.isDisplayed(), "Homepage logo is not displayed login not successful");
			Assert.assertTrue(homepage.managerButton.isDisplayed(), "Manager button is not displayed login not successful");
			Assert.assertTrue(homepage.newCustomerButton.isDisplayed(), "New customer button is not displayed login not successful");
			
			//Click on New customer cuutton to create new customer
			homepage.clickNewCustomerButton();
			
			//check if add new customer tab is present
			Assert.assertTrue(newcust.addNewCustomerLabel.isDisplayed(), "Add new customer option is not visible");
			
			//check if customer name textbox is present		
			Assert.assertTrue(newcust.customerNameTxtField.isDisplayed(), "Customer name text box is not presernt");
			
			//validate name field
			newcust.typeCustomerName("");
			//click else where on UI to simulate warning message
			newcust.clickAddNewCustLabel();
			Assert.assertTrue(newcust.warningBlankName.isDisplayed(), "Customer name must not be blank message is not appearing on UI");
			newcust.typeCustomerName("@#!@$");
			newcust.clickAddNewCustLabel();
			Assert.assertTrue(newcust.warningSpecialCharactersGeneric.isDisplayed(), "Customer name must not contain special characters message is not appearing on UI");
			
			
			//check if male female radio button is visible
			Assert.assertTrue(newcust.maleRadioButton.isDisplayed(), "Male chekbox not visible");
			Assert.assertTrue(newcust.femaleRadioButton.isDisplayed(), "Female chekbox not visible");
			
			newcust.checkRadioButtonGender("m");

			
			//validate date of birth
			newcust.setDob("", "", "");
			newcust.clickAddNewCustLabel();
			Assert.assertTrue(newcust.warningBlankDOB.isDisplayed(), "Date field must not be blank message is not appearing on UI");
			
			//validate addressfield
			Assert.assertTrue(newcust.addrressTxtField.isDisplayed(), "Address text box is not visible");
			newcust.typeAddress("");
			newcust.clickAddNewCustLabel();
			Assert.assertTrue(newcust.warningBlankAddress.isDisplayed(), "Address Field must not be blank message is not appearing on UI");
			newcust.typeAddress("%^&$#");
			newcust.clickAddNewCustLabel();
			Assert.assertTrue(newcust.warningSpecialCharactersGeneric.isDisplayed(), "Address Field must not have special characters message is not appearing on UI");
			
			//validate city field
			Assert.assertTrue(newcust.cityTxtField.isDisplayed(), "City text box is not visible");
			newcust.typeCity("");
			newcust.clickAddNewCustLabel();
			Assert.assertTrue(newcust.warningBlankCity.isDisplayed(), "City field must not be blank message is not appearing on UI");
			newcust.typeCity("@^%#&");
			newcust.clickAddNewCustLabel();
			Assert.assertTrue(newcust.warningSpecialCharactersGeneric.isDisplayed(), "Address Field must not contain special characters is not appearing on UI");

			//validate state field
			Assert.assertTrue(newcust.stateTxtField.isDisplayed(), "State text box is not visible");
			newcust.typeState("");
			newcust.clickAddNewCustLabel();
			Assert.assertTrue(newcust.warningBlankState.isDisplayed(), "State field must not be blank message is not appearing on UI");
			newcust.typeState("@^*@!");
			newcust.clickAddNewCustLabel();
			Assert.assertTrue(newcust.warningSpecialCharactersGeneric.isDisplayed(), "State field must not contain special characters message is not appearing on UI");

			//validate pin number
			Assert.assertTrue(newcust.pinNoField.isDisplayed(), "Postal code text box is not visible");
			newcust.typePinNo("");
			newcust.clickAddNewCustLabel();
			Assert.assertTrue(newcust.warningBlankPinNo.isDisplayed(), "PIN Code field must not be blank message is not appearing on UI");
			newcust.typePinNo("abcd");
			Assert.assertTrue(newcust.warningCharGeneric.isDisplayed(), "PIN Code field characters are not allowed is not appearing on UI");
			newcust.typePinNo("#%!^@*");
			newcust.clickAddNewCustLabel();
			Assert.assertTrue(newcust.warningSpecialCharactersGeneric.isDisplayed(), "PIN Code field must not contain special characters message is not appearing on UI");
			
			//validate telephone number
			Assert.assertTrue(newcust.telephoneField.isDisplayed(), "Telephone Number text box is not visible");
			newcust.typeTelephone("");
			newcust.clickAddNewCustLabel();
			Assert.assertTrue(newcust.warningBlankTelephone.isDisplayed(), "Mobile number field must not be blank message is not appearing on UI");
			newcust.typeTelephone("abcd");
			Assert.assertTrue(newcust.warningCharGeneric.isDisplayed(), "Telephone number field characters are not allowed is not appearing on UI");
			
			//validate email id
			Assert.assertTrue(newcust.emailIDField.isDisplayed(), "Email text box is not visible");
			newcust.typeEmailID("abcdefgh");
			Assert.assertTrue(newcust.warningInvalidEmail.isDisplayed(), "Invalid email id message is not appearing on UI");
								
	}
}
