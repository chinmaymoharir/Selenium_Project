import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ValidateLoginPage extends ReadDataFromProperties{

	@Test
	@Parameters({ "URL","username", "password" })
	public void loginValidationwithValidParameters(String URL, String username, String password) throws Exception{
		
		
		WebDriver driver;
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
		driver.findElement(By.xpath("//*[@class='barone' and contains(text(),'Guru99 Bank')]")).isDisplayed();
		driver.findElement(By.xpath("//li[@class='orange']//a[contains(text(),'Manager')]")).isDisplayed();
		
		//logout of application
		driver.findElement(By.xpath("//li//a[contains(text(),'Log out')]")).isDisplayed();
		driver.findElement(By.xpath("//li//a[contains(text(),'Log out')]")).click();
		driver.close();
	}
	
	@Test
	@Parameters({ "URL","username", "password", "invalidUsername", "invalidPassword" })
	public void loginValidationwithInvalidParameters(String URL, String username, String password, String invalidUsername, String invalidPassword) throws Exception{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chinmay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//Open URL
		driver.get(URL);
		
		//verify if login page is displayed
		Assert.assertTrue(driver.findElement(By.xpath("//*[@name='uid' and @type='text']")).isDisplayed(), "Username is displayed on login page");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@name='password' and @type='password']")).isDisplayed(), "Password is displayed on login page");
		
		
		//Enter invalid username and valid password and click login
		driver.findElement(By.xpath("//*[@name='uid' and @type='text']")).sendKeys(invalidUsername);
		driver.findElement(By.xpath("//*[@name='password' and @type='password']")).sendKeys(password);
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@name='btnLogin' and @type='submit']")).isDisplayed(), "Login putton is displayed");
		driver.findElement(By.xpath("//*[@name='btnLogin' and @type='submit']")).click();
		
		//Verify popup is displayed for invalid username and valid password
		Assert.assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid", "Alert message not displayed correctly");
		
		driver.switchTo().alert().accept();
		
		driver.get(URL);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@name='uid' and @type='text']")).isDisplayed(), "Username is displayed on login page");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@name='password' and @type='password']")).isDisplayed(), "Password is displayed on login page");
		
		
		//Enter valid username and invalid password and click login
		driver.findElement(By.xpath("//*[@name='uid' and @type='text']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@name='password' and @type='password']")).sendKeys(invalidPassword);
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@name='btnLogin' and @type='submit']")).isDisplayed(), "Login putton is displayed");
		driver.findElement(By.xpath("//*[@name='btnLogin' and @type='submit']")).click();
		
		//Verify popup is displayed for invalid username and valid password
		Assert.assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid", "Alert message not displayed correctly");
		
		driver.switchTo().alert().accept();
		
		driver.get(URL);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@name='uid' and @type='text']")).isDisplayed(), "Username is displayed on login page");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@name='password' and @type='password']")).isDisplayed(), "Password is displayed on login page");
		
		
		//Enter valid invalid username and invalid password and click login
		driver.findElement(By.xpath("//*[@name='uid' and @type='text']")).sendKeys(invalidUsername);
		driver.findElement(By.xpath("//*[@name='password' and @type='password']")).sendKeys(invalidPassword);
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@name='btnLogin' and @type='submit']")).isDisplayed(), "Login putton is displayed");
		driver.findElement(By.xpath("//*[@name='btnLogin' and @type='submit']")).click();
		
		//Verify popup is displayed for invalid username and valid password
		Assert.assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid", "Alert message not displayed correctly");
		
		driver.switchTo().alert().accept();
		
		driver.close();
	}
}
