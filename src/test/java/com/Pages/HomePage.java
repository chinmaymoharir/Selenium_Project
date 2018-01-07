package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	public By homePageLogo = By.xpath("//*[@class='barone' and contains(text(),'Guru99 Bank')]");
	public By managerButton = By.xpath("//li[@class='orange']//a[contains(text(),'Manager')]");
	public By newCustomerButton = By.xpath("//a[contains(text(),'New Customer')]");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}

}
