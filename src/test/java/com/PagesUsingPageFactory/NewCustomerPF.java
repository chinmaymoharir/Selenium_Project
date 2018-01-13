package com.PagesUsingPageFactory;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NewCustomerPF {
public WebDriver driver;
	
	public NewCustomerPF(WebDriver driver) {
		this.driver=driver;
			PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//p[contains(text(),'Add New Customer')]")
	public WebElement addNewCustomerLabel;
	
	@FindBy(how=How.XPATH, using="//input[@type='text'][@name='name']")
	public WebElement customerNameTxtField;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Special characters are not allowed')]")
	public WebElement warningSpecialCharactersGeneric;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Customer name must not be blank')]")
	public WebElement warningBlankName;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'New Customer')]")
	public WebElement newCustomerButton;
	
	@FindBy(how=How.XPATH, using="//input[@type='radio'][@name='rad1'][@value='f']")
	public WebElement femaleRadioButton;
	
	@FindBy(how=How.XPATH, using="//input[@type='radio'][@name='rad1'][@value='m']")
	public WebElement maleRadioButton;
	
	@FindBy(how=How.XPATH, using="//input[@type='date' and @name='dob']")
	public WebElement dobField;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Date Field must not be blank')]")
	public WebElement warningBlankDOB;
	
	@FindBy(how=How.NAME, using="addr")
	public WebElement addrressTxtField;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Address Field must not be blank')]")
	public WebElement warningBlankAddress;
	
	@FindBy(how=How.NAME, using="city")
	public WebElement cityTxtField;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'City Field must not be blank')]")
	public WebElement warningBlankCity;
	
	@FindBy(how=How.NAME, using="state")
	public WebElement stateTxtField;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'State must not be blank')]")
	public WebElement warningBlankState;
	
	@FindBy(how=How.NAME, using="pinno")
	public WebElement pinNoField;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'PIN Code must not be blank')]")
	public WebElement warningBlankPinNo;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Characters are not allowed')]")
	public WebElement warningCharGeneric;
	
	@FindBy(how=How.NAME, using="telephoneno")
	public WebElement telephoneField;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Mobile no must not be blank')]")
	public WebElement warningBlankTelephone;
	
	
	@FindBy(how=How.NAME, using="emailid")
	public WebElement emailIDField;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Email-ID is not valid')]")
	public WebElement warningInvalidEmail;
	
	
	@FindBy(how=How.NAME, using="password")
	public WebElement passwordField;

	@FindBy(how=How.XPATH, using="//input[@type='submit' and @value='Submit' and @name='sub']")
	public WebElement submitNewCustButton;
	
	@FindBy(how=How.XPATH, using="//p[contains(text(),'Customer Registered Successfully!!!')]")
	public WebElement customerRegistrationSuccess;
	
	@FindBy(how=How.XPATH, using="//*[@id='customer']/tbody/tr[4]/td[2]")
	public WebElement customerID;
	
	
	
	
	
	
	public void clickAddNewCustLabel() {
		addNewCustomerLabel.click();
	}
	
	public void typeCustomerName(String customername){
		customerNameTxtField.sendKeys(customername);
	}
	
	
	public void checkRadioButtonGender(String gender) throws Exception{
		try {
			if(gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("female"))
				femaleRadioButton.click();
			else if(gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("male"))
				maleRadioButton.click();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void setDob(String MM, String DD, String YYYY) {
		dobField.sendKeys(MM);
		dobField.sendKeys(DD);
		dobField.sendKeys(YYYY);
	}
	
	public void typeAddress(String address) {
		addrressTxtField.sendKeys(address);
	}
	
	public void typeCity(String city) {
		cityTxtField.sendKeys(city);
	}
	
	public void typeState(String state) {
		stateTxtField.sendKeys(state);
	}
	
	public void typePinNo(String pinno) {
		pinNoField.sendKeys(pinno);
	}
	
	public void typeTelephone(String telephone) {
		telephoneField.sendKeys(telephone);
	}
	
	public void typeEmailID(String email) {
		emailIDField.sendKeys(email);
	}
	
	public void typevalidEmailID() {
		String emailID = RandomStringUtils.randomAlphanumeric(7);
		emailIDField.sendKeys(emailID +"@gmail.com");
	}
	
	public void typePassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void submitNewCust() {
		submitNewCustButton.click();
	}

}
