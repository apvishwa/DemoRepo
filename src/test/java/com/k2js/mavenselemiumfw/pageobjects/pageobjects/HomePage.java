package com.k2js.mavenselemiumfw.pageobjects.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String getThePageTitel() {
		
		return driver.getTitle();
	}
	
	@FindBy(linkText = "REGISTER")
	private WebElement reglink;
	public RegestrationPage clickRegesterLink() {
		reglink.click();
		return PageFactory.initElements(driver, RegestrationPage.class);
		
	}
	
	@FindBy(name="userName")private WebElement username;
	public  void enterusername(String un) {
		
		username.sendKeys(un);
	}
	
	@FindBy(name="password")private WebElement pass;
	public void enterPassword(String ps) {
		pass.sendKeys(ps);
	}
	
	@FindBy(name = "login")private WebElement singin;
	public void clickSigIn() {
		singin.click();
	}
	
	
	
}
