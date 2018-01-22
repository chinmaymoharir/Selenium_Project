package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InvokeBrowserSettings {
	public WebDriver driver;
	
	
	
	public WebDriver invokeBrowser(String Browsername, String URL) {
		
		if(Browsername.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
		}
		else if (Browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
		}
		else if (Browsername.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
			driver.manage().deleteAllCookies();
		}
		
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;
	}
	
}
