/*
 * This page has the objects related to edit customer tab using page factory
*/
package pageActions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class EditCustomerPF {
	WebDriver driver;
	public EditCustomerPF(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//p[@class='heading3'][contains(text(),'Edit Customer')]")
	public WebElement editCustomerTitle;
	
	@FindBy(how=How.XPATH, using="//input[@type='text'][@name='name']")
	public WebElement customerNameTxtField;
	
	@FindBy(how=How.XPATH, using="//input[@type='text'][@name='gender']")
	public WebElement customerGenderField;
	
	@FindBy(how=How.XPATH, using="//input[@type='text'][@name='dob']")
	public WebElement customerDOBField;
	
	@FindBy(how=How.XPATH, using="//textarea[@onkeyup='validateAddress();'][@name='addr']")
	public WebElement customerAddressField;
	
	@FindBy(how=How.XPATH, using="//input[@type='text'][@name='city']")
	public WebElement customerCityField;
	
	@FindBy(how=How.XPATH, using="//input[@type='text'][@name='state']")
	public WebElement customerStateField;
	
	@FindBy(how=How.XPATH, using="//input[@type='text'][@name='pinno']")
	public WebElement customerPinNoField;
	
	@FindBy(how=How.XPATH, using="//input[@type='text'][@name='telephoneno']")
	public WebElement customerTelephoneNoField;
	
	@FindBy(how=How.XPATH, using="//input[@type='text'][@name='emailid']")
	public WebElement customerEmailIdField;
	
	@FindBy(how=How.XPATH, using="//input[@type='submit'][@value='Submit']")
	public WebElement submitButton;
	
	@FindBy(how=How.XPATH, using="//input[@type='reset'][@value='Reset']")
	public WebElement resetButton;
	
	
	
	public void updateAndCheckResetButton() {
		String address = customerAddressField.getAttribute("value");
		String city = customerCityField.getAttribute("value");
		String state = customerStateField.getAttribute("value");
		String pin = customerPinNoField.getAttribute("value");
		String mobilenum = customerTelephoneNoField.getAttribute("value");
		String emailid = customerEmailIdField.getAttribute("value");
		
		clearAndUpdateAddress();
		clearAndUpdateCity();
		clearAndUpdatePIN();
		clearAndUpdateState();
		clearAndUpdateMobile();
		clearAndUpdateEmail();
		
		String updated_address = customerAddressField.getAttribute("value");
		String updated_city = customerCityField.getAttribute("value");
		String updated_state = customerStateField.getAttribute("value");
		String updated_pin = customerPinNoField.getAttribute("value");
		String updated_mobilenum = customerTelephoneNoField.getAttribute("value");
		String updated_emailid = customerEmailIdField.getAttribute("value");
		
		Assert.assertTrue((address!=updated_address)&&(city!=updated_city)&&(state!=updated_state)&&(pin!=updated_pin)&&(mobilenum!=updated_mobilenum)&&(emailid!=updated_emailid), "Update is unsuccessful");
		resetButton.click();
		
		String reset_address = customerAddressField.getAttribute("value");
		String reset_city = customerCityField.getAttribute("value");
		String reset_state = customerStateField.getAttribute("value");
		String reset_pin = customerPinNoField.getAttribute("value");
		String reset_mobilenum = customerTelephoneNoField.getAttribute("value");
		String reset_emailid = customerEmailIdField.getAttribute("value");
		
		Assert.assertTrue((address.equals(reset_address))&&(city.equals(reset_city))&&(state.equals(reset_state))&&(pin.equals(reset_pin))&&(mobilenum.equals(reset_mobilenum))&&(emailid.equals(reset_emailid)), "Reset button is not working");
	}
	
	public void checkEditCustomerTitle() {
		Assert.assertTrue(editCustomerTitle.isDisplayed(), "Edit customer window is not displayed");
	}
	
	
	
	public void checkNameFieldNotEditable(){
		Assert.assertTrue(customerNameTxtField.getAttribute("disabled").toString().contains("true"), "Name field is editable");
		
	}
	
	public void checkGenderNotEditable(){
		Assert.assertTrue(customerGenderField.getAttribute("disabled").toString().contains("true"), "Gender field is editable");
		
	}
	
	public void checkDateOfBirthNotEditable(){
		Assert.assertTrue(customerDOBField.getAttribute("disabled").toString().contains("true"), "Gender field is editable");
		
	}
	
	public void clearAndUpdateAddress(){
		customerAddressField.clear();
		customerAddressField.sendKeys("Updated address");
	}
	
	public void clearAndUpdateCity(){
		customerCityField.clear();
		customerCityField.sendKeys("Updated city");
	}
	
	public void clearAndUpdateState(){
		customerStateField.clear();
		customerStateField.sendKeys("Updated state");
	}
	
	public void clearAndUpdatePIN(){
		customerPinNoField.clear();
		customerPinNoField.sendKeys("543210");
	}
	
	public void clearAndUpdateMobile(){
		customerTelephoneNoField.clear();
		customerTelephoneNoField.sendKeys("9876543210");
	}
	
	public void clearAndUpdateEmail(){
		String email = RandomStringUtils.randomAlphanumeric(7) + "updated@gmail.com";
		customerEmailIdField.clear();
		customerEmailIdField.sendKeys(email);
	}
	
	public void submitEdittedCustomer() {
		submitButton.click();
	}
	

}
