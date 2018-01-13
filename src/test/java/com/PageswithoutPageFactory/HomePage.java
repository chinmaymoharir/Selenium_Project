package com.PageswithoutPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;
	public By homePageLogo = By.xpath("//*[@class='barone' and contains(text(),'Guru99 Bank')]");
	public By managerButton = By.xpath("//li[@class='orange']//a[contains(text(),'Manager')]");
	public By newCustomerButton = By.xpath("//a[contains(text(),'New Customer')]");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void validateHomePageLogo(WebDriver driver) {
		Assert.assertTrue(driver.findElement(homePageLogo).isDisplayed(), "Home page logo is not displayed");
	}
	
	public void validateManagerButton(WebDriver driver) {
		Assert.assertTrue(driver.findElement(managerButton).isDisplayed(), "Manager button is not displayed");
	}
	
	public void validatenewCustomerButton(WebDriver driver) {
		Assert.assertTrue(driver.findElement(newCustomerButton).isDisplayed(), "Manager button is not displayed");
	}
	
	public void clickNewCustomer(WebDriver driver) {
		driver.findElement(newCustomerButton).click();
	}

}
