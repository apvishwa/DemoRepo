package com.k2js.mavenselemiumfw.pageobjects.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservationPage extends BasePage {

	public ReservationPage(WebDriver driver) {
		
		super(driver);
	}
	
	@FindBy(xpath = "//b//font[contains(text(),'Flight')]")private WebElement heading1;
	public String getHeadingText1() {
		
		return heading1.getText();
	}
	
	@FindBy(xpath = "//font[contains(text(),'Preferences')]")private WebElement heading2;
	public String getHeading2() {
		
		return heading2.getText();
	}
	
}
