package com.PagesUsingPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageUsingPageFactory {
	WebDriver driver;
	
	public HomePageUsingPageFactory(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//*[@class='barone' and contains(text(),'Guru99 Bank')]")
	public WebElement homePageLogo;
	
	@FindBy(how=How.XPATH, using="//li[@class='orange']//a[contains(text(),'Manager')]")
	public WebElement managerButton;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'New Customer')]")
	public WebElement newCustomerButton;
	
	public void clickNewCustomerButton() {
		newCustomerButton.click();
	}

}
