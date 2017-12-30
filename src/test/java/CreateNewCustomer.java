import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateNewCustomer {
	public WebDriver driver;
	@Test
	@Parameters({ "URL","username", "password" })
	public void TC_01(String URL, String username, String password) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chinmay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//Open URL
		driver.get(URL);
		
		//verify if login page is displayed
		//We are using assert instead of verify statement because this will help prevent the code from stopping at this point if it fails.
		//It will continue execution even if it fails at this point
		Assert.assertTrue(driver.findElement(By.xpath("//*[@name='uid' and @type='text']")).isDisplayed(), "login box is not present on UI");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@name='password' and @type='password']")).isDisplayed(), "password box is not present on UI");
		
		
		//Enter valid username password and click login
		driver.findElement(By.xpath("//*[@name='uid' and @type='text']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@name='password' and @type='password']")).sendKeys(password);
		
		//Verify if login button is displayed
		Assert.assertTrue(driver.findElement(By.xpath("//*[@name='btnLogin' and @type='submit']")).isDisplayed(), "Login button is displayed");
		
		//login to the app and wait
		driver.findElement(By.xpath("//*[@name='btnLogin' and @type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//verify home page displayed after valid credentials
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='barone' and contains(text(),'Guru99 Bank')]")).isDisplayed(), "Login is not successful");
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='orange']//a[contains(text(),'Manager')]")).isDisplayed(), "Login is not successful");
						
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).isDisplayed(), "New customer tab is not visible");
		driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
		
		//check if add new customer tab is present
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Add New Customer')]")).isDisplayed(), "Add new customer option is not visible");
		//check if customer name textbox is present		
		Assert.assertTrue(driver.findElement(By.name("name")).isDisplayed(), "Customer name text box is not presernt");
		driver.findElement(By.name("name")).sendKeys("Chinmay Moharir");
		
		
		//check if male female radio button is visible
		Assert.assertTrue(driver.findElement(By.xpath("//input[@type='radio'][@name='rad1'][@value='m']")).isDisplayed(), "Male chekbox not visible");
		Assert.assertTrue(driver.findElement(By.xpath("//input[@type='radio'][@name='rad1'][@value='f']")).isDisplayed(), "Female chekbox not visible");
		
		driver.findElement(By.xpath("//input[@type='radio'][@name='rad1'][@value='m']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@type='date' and @name='dob']")).isDisplayed(), "Date of birth field is no visible");
		driver.findElement(By.xpath("//input[@type='date' and @name='dob']")).sendKeys("12");
		driver.findElement(By.xpath("//input[@type='date' and @name='dob']")).sendKeys("01");
		driver.findElement(By.xpath("//input[@type='date' and @name='dob']")).sendKeys("1990");
		
		
		Assert.assertTrue(driver.findElement(By.name("addr")).isDisplayed(), "Address text box is not visible");
		driver.findElement(By.name("addr")).sendKeys("2404 Nutwood Avenue");
		
		Assert.assertTrue(driver.findElement(By.name("city")).isDisplayed(), "City text box is not visible");
		driver.findElement(By.name("city")).sendKeys("Fullerton");
		
		Assert.assertTrue(driver.findElement(By.name("state")).isDisplayed(), "State text box is not visible");
		driver.findElement(By.name("state")).sendKeys("California");
	
		Assert.assertTrue(driver.findElement(By.name("pinno")).isDisplayed(), "Postal code text box is not visible");
		driver.findElement(By.name("pinno")).sendKeys("928311");
		
		Assert.assertTrue(driver.findElement(By.name("telephoneno")).isDisplayed(), "Telephone Number text box is not visible");
		driver.findElement(By.name("telephoneno")).sendKeys("1234567890");
		
		
		String email = RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
		System.out.println(email);
		Assert.assertTrue(driver.findElement(By.name("emailid")).isDisplayed(), "Email text box is not visible");
		driver.findElement(By.name("emailid")).sendKeys(email);
		
		
		
		Assert.assertTrue(driver.findElement(By.name("password")).isDisplayed(), "Email text box is not visible");
		driver.findElement(By.name("password")).sendKeys("abcde12345");
		Assert.assertTrue(driver.findElement(By.xpath("//input[@type='submit' and @value='Submit' and @name='sub']")).isDisplayed(), "Submit button is not displayed");
		driver.findElement(By.xpath("//input[@type='submit' and @value='Submit' and @name='sub']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Customer Registered Successfully!!!')]")).isDisplayed(), "Customer was not created successfully");
		String customerId = driver.findElement(By.xpath("//*[@id='customer']/tbody/tr[4]/td[2]")).getText();
		System.out.println(customerId);
		
		//
		driver.close();

	}
	/*
	@Test
	public void TC_02(String URL, String username, String password) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chinmay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//Open URL
		driver.get(URL);
		
		//verify if login page is displayed
		//We are using assert instead of verify statement because this will help prevent the code from stopping at this point if it fails.
		//It will continue execution even if it fails at this point
		Assert.assertTrue(driver.findElement(By.xpath("//*[@name='uid' and @type='text']")).isDisplayed(), "login box is not present on UI");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@name='password' and @type='password']")).isDisplayed(), "password box is not present on UI");
		
		
		//Enter valid username password and click login
		driver.findElement(By.xpath("//*[@name='uid' and @type='text']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@name='password' and @type='password']")).sendKeys(password);
		
		//Verify if login button is displayed
		Assert.assertTrue(driver.findElement(By.xpath("//*[@name='btnLogin' and @type='submit']")).isDisplayed(), "Login button is displayed");
		
		//login to the app and wait
		driver.findElement(By.xpath("//*[@name='btnLogin' and @type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//verify home page displayed after valid credentials
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='barone' and contains(text(),'Guru99 Bank')]")).isDisplayed(), "Login is not successful");
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='orange']//a[contains(text(),'Manager')]")).isDisplayed(), "Login is not successful");
						
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).isDisplayed(), "New customer tab is not visible");
		driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
		
		//check if add new customer tab is present
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Add New Customer')]")).isDisplayed(), "Add new customer option is not visible");
		//check if customer name textbox is present		
		Assert.assertTrue(driver.findElement(By.name("name")).isDisplayed(), "Customer name text box is not presernt");
		
		
		driver.findElement(By.name("name")).sendKeys("@#@%#");
		driver.findElement(By.xpath("//p[contains(text(),'Add New Customer')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Special characters are not allowed')]")).isDisplayed(), "Customer name must not contain special characters message is not appearing on UI");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.name("name"))).doubleClick().build().perform();
		
		driver.findElement(By.name("name")).sendKeys("");
		driver.findElement(By.xpath("//p[contains(text(),'Add New Customer')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Customer name must not be blank')]")).isDisplayed(), "Customer name must not be blank message is not appearing on UI");
		
		driver.findElement(By.name("name")).sendKeys("Chinmay Moharir");
		
		
		//check if male female radio button is visible
		Assert.assertTrue(driver.findElement(By.xpath("//input[@type='radio'][@name='rad1'][@value='m']")).isDisplayed(), "Male chekbox not visible");
		Assert.assertTrue(driver.findElement(By.xpath("//input[@type='radio'][@name='rad1'][@value='f']")).isDisplayed(), "Female chekbox not visible");
		
		driver.findElement(By.xpath("//input[@type='radio'][@name='rad1'][@value='m']")).click();
		
		driver.findElement(By.name("dob")).sendKeys("");
		driver.findElement(By.xpath("//p[contains(text(),'Add New Customer')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Date Field must not be blank')]")).isDisplayed(), "Date field must not be blank message is not appearing on UI");
		
		
		driver.findElement(By.xpath("//input[@type='date' and @name='dob']")).sendKeys("12");
		driver.findElement(By.xpath("//input[@type='date' and @name='dob']")).sendKeys("01");
		driver.findElement(By.xpath("//input[@type='date' and @name='dob']")).sendKeys("1990");
		
		
		Assert.assertTrue(driver.findElement(By.name("addr")).isDisplayed(), "Address text box is not visible");
		
		driver.findElement(By.name("addr")).sendKeys("!@$#");
		driver.findElement(By.xpath("//p[contains(text(),'Add New Customer')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Special characters are not allowed')]")).isDisplayed(), "Address Field must not have special characters message is not appearing on UI");
		
		driver.findElement(By.name("addr")).sendKeys("");
		driver.findElement(By.xpath("//p[contains(text(),'Add New Customer')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Address Field must not be blank')]")).isDisplayed(), "Address Field must not be blank message is not appearing on UI");
		
		driver.findElement(By.name("addr")).sendKeys("2404 Nutwood Avenue");
		
		Assert.assertTrue(driver.findElement(By.name("city")).isDisplayed(), "City text box is not visible");
		
		driver.findElement(By.name("city")).sendKeys("!@$#");
		driver.findElement(By.xpath("//p[contains(text(),'Add New Customer')]")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Special characters are not allowed')]")).isDisplayed(), "Address Field must not be blank message is not appearing on UI");
		
		driver.findElement(By.name("city")).sendKeys("");
		driver.findElement(By.xpath("//p[contains(text(),'Add New Customer')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'City Field must not be blank')]")).isDisplayed(), "City field must not be blank message is not appearing on UI");
		
		driver.findElement(By.name("city")).sendKeys("Fullerton");
		
		Assert.assertTrue(driver.findElement(By.name("state")).isDisplayed(), "State text box is not visible");
		driver.findElement(By.name("state")).sendKeys("");
		driver.findElement(By.xpath("//p[contains(text(),'Add New Customer')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'State must not be blank')]")).isDisplayed(), "State field must not be blank message is not appearing on UI");
		driver.findElement(By.name("state")).sendKeys("California");
	
		Assert.assertTrue(driver.findElement(By.name("pinno")).isDisplayed(), "Postal code text box is not visible");
		driver.findElement(By.name("pinno")).sendKeys("");
		driver.findElement(By.xpath("//p[contains(text(),'Add New Customer')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'PIN Code must not be blank')]")).isDisplayed(), "PIN Code field must not be blank message is not appearing on UI");
		driver.findElement(By.name("pinno")).sendKeys("abcd");
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Characters are not allowed')]")).isDisplayed(), "PIN Code field characters are not allowed is not appearing on UI");
		driver.findElement(By.name("pinno")).sendKeys("92831");
		
		Assert.assertTrue(driver.findElement(By.name("telephoneno")).isDisplayed(), "Telephone Number text box is not visible");
		driver.findElement(By.name("telephoneno")).sendKeys("");
		driver.findElement(By.xpath("//p[contains(text(),'Add New Customer')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Mobile no must not be blank')]")).isDisplayed(), "Mobile number field must not be blank message is not appearing on UI");
		driver.findElement(By.name("telephoneno")).sendKeys("abcd");
		driver.findElement(By.name("telephoneno")).sendKeys("1234567890");
		
		Assert.assertTrue(driver.findElement(By.name("emailid")).isDisplayed(), "Email text box is not visible");
		driver.findElement(By.name("emailid")).sendKeys("asdasdasd");
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Email-ID is not valid')]")).isDisplayed(), "Invalid email id message is not appearing on UI");
		
		
		
		
		driver.close();
		
	}*/
}
