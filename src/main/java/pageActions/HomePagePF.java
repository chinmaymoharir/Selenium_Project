/*
 * This page has the objects related to Home page tab using page factory
*/
package pageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePagePF {
	WebDriver driver;
	
	public HomePagePF(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//*[@class='barone' and contains(text(),'Guru99 Bank')]")
	public WebElement homePageLogo;
	
	@FindBy(how=How.XPATH, using="//li[@class='orange']//a[contains(text(),'Manager')]")
	public WebElement managerButton;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'New Customer')]")
	public WebElement newCustomerButton;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Edit Customer')]")
	public WebElement editCustomerButton;
	
	@FindBy(how=How.XPATH, using="//input[@name='cusid'][@type='text']")
	public WebElement customerIdField;
	
	@FindBy(how=How.XPATH, using="//input[@type='submit'][@name='AccSubmit'][@value='Submit']")
	public WebElement submitCustomerIDButton;
	
	@FindBy(how=How.XPATH, using="//input[@type='reset'][@name='res'][@value='Reset']")
	public WebElement resetCustomerIDButton;
	
	public void clickNewCustomerButton() {
		newCustomerButton.click();
	}
	
	
	
	public void searchCustomer(String custID) {
		editCustomerButton.click();
		customerIdField.sendKeys(custID);
		submitCustomerIDButton.click();
	}

}
