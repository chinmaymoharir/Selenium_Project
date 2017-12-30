import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class LoginThroughDataDriven {
	public static WebDriver driver;
	
	
	public void Login() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chinmay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//Open URL
		driver.get(Constant.URL);
		String username = ExcelDataDrivenCodeToReadTestData.getCellData(1,1);
		String password = ExcelDataDrivenCodeToReadTestData.getCellData(1,2);
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
}
