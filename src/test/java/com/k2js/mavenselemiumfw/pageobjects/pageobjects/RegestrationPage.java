package com.k2js.mavenselemiumfw.pageobjects.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegestrationPage extends BasePage{
	
	public RegestrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="firstName")private WebElement firstname;
	public void enterFirstName(String fn) {
		firstname.sendKeys(fn);
	}
	
	@FindBy(name="lastName")private WebElement ln;
	public void enterLastName(String lastname) {
		ln.sendKeys(lastname);
	}
	
	@FindBy(name="phone")private WebElement ph;
	public void enterPhoneNum(String phnum) {
		ph.sendKeys(phnum);
	}
	
	@FindBy(name="userName")private WebElement em;
	public void enterEmail(String emid) {
		em.sendKeys(emid);
	}
	
	@FindBy(name="address1")private WebElement ad;
	public void enterAddress(String add) {
		ad.sendKeys(add);
	}
	
	@FindBy(name="city")private WebElement ct;
	public void enterCity(String city) {
		ct.sendKeys(city);
	}

	@FindBy(name="state")private WebElement st;
	public void enterState(String state) {
		st.sendKeys(state);
	}
	
	@FindBy(name="postalCode")private WebElement pc;
	public void enterPostalCode(String postcode) {
		pc.sendKeys(postcode);
	}
	
	@FindBy(name="country")private WebElement country;
	public void selectCountry() {
		Select s=new Select(country);
		s.getOptions().parallelStream().filter(x->x.getText().equalsIgnoreCase("India ")).forEach(y->y.click());
	
	}
	
	@FindBy(name="register")private WebElement sub;
	public ConfirmPage clickSubmit() {
		sub.click();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		return PageFactory.initElements(driver, ConfirmPage.class);
	}
	
	@FindBy(xpath = "//b[contains(text(),'Dear')]/../../..")private WebElement text;
	public String getText() {
		String te=text.getText();
		System.out.println(te);
		return te;
	}
}
