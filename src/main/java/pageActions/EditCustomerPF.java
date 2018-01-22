/*
 * This page has the objects related to edit customer tab using page factory
*/
package pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditCustomerPF {
	WebDriver driver;
	public EditCustomerPF(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//input[@type='text'][@name='name']")
	public WebElement customerNameTxtField;

}
