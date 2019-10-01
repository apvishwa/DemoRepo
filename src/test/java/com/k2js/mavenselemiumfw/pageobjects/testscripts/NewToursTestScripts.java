package com.k2js.mavenselemiumfw.pageobjects.testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.language.bm.Rule.RPattern;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.k2js.mavenselemiumfw.pageobjects.pageobjects.HomePage;
import com.k2js.mavenselemiumfw.pageobjects.pageobjects.RegestrationPage;
import com.k2js.mavenselemiumfw.pageobjects.pageobjects.ReservationPage;
import com.k2js.mavenselemiumfw.pageobjects.util.BrowserFactory;
import com.k2js.mavenselemiumfw.pageobjects.util.CommonUtil;


public class NewToursTestScripts {

	@Test
	public void verifyThePageTitel() throws Throwable {
		String errormsg="",result="fail";
		WebDriver driver=null;
		
		try {
			String bn=CommonUtil.getPropertiesValue("config","config.browsername");
			System.out.println(bn);
			String rm=CommonUtil.getPropertiesValue("config","config.runmode");
			System.out.println(rm);
			String url=CommonUtil.getPropertiesValue("config","config.URL");
			System.out.println(url);
			driver=BrowserFactory.getBrowser(bn, rm);
			
			BrowserFactory.OpenURL(url);
			
			String ExpTitel=CommonUtil.getPropertiesValue("homepage", "homepage.title");
			System.out.println(ExpTitel);
			
			HomePage hp=PageFactory.initElements(driver, HomePage.class);
			
			String actual=hp.getThePageTitel();
			
			assert ExpTitel.equalsIgnoreCase(actual);
			result="pass";
			
		}catch (Throwable e) {
			errormsg=e.getMessage();
			System.out.println(e);
			e.printStackTrace();
			CommonUtil.takeScreenShot(driver);
			throw e;
		}
		
		finally {
			System.out.println(result);
			if(!errormsg.isEmpty()) {
				System.out.println(errormsg);
			}
		}
	}
	
	@Test
	public void verifyConfirmationMsg() throws IOException {
		
		WebDriver driver=null;
		String errormsg="",result="fail";
		
		try {
			
			String bn=CommonUtil.getPropertiesValue("config", "config.browsername");
			System.out.println(bn);
			String rm=CommonUtil.getPropertiesValue("config", "config.runmode");
			System.out.println(rm);
			String url=CommonUtil.getPropertiesValue("config", "config.URL");
			System.out.println(url);
			
			driver=BrowserFactory.getBrowser(bn, rm);
			BrowserFactory.OpenURL(url);
			
			
			HomePage hp=PageFactory.initElements(driver, HomePage.class);
			RegestrationPage rp=hp.clickRegesterLink();
			
			String fn=CommonUtil.getPropertiesValue("regestrationpage", "regestrationpage.FirstName");
			rp.enterFirstName(fn);
			String lastnam=CommonUtil.getPropertiesValue("regestrationpage", "regestrationpage.LastName");
			rp.enterLastName(lastnam);
			String phonum=CommonUtil.getPropertiesValue("regestrationpage", "regestrationpage.Phone");
			rp.enterPhoneNum(phonum);
			String emid=CommonUtil.getPropertiesValue("regestrationpage", "regestrationpage.Email");
			rp.enterEmail(emid);
			String addr=CommonUtil.getPropertiesValue("regestrationpage", "regestrationpage.Address");
			rp.enterAddress(addr);
			System.out.println(addr);
			String city=CommonUtil.getPropertiesValue("regestrationpage", "regestrationpage.City");
			rp.enterCity(city);
			String state=CommonUtil.getPropertiesValue("regestrationpage", "regestrationpage.State/Province");
			rp.enterState(state);
			String postalcode=CommonUtil.getPropertiesValue("regestrationpage","regestrationpage.PostalCode");
			rp.enterPostalCode(postalcode);
			
			rp.selectCountry();
			rp.clickSubmit();
			String exptext=CommonUtil.getPropertiesValue("confirmationpage", "confirmationpage.conf_msg");
			System.out.println(exptext);
			String actualtext=rp.getText();
			
			assert exptext.equalsIgnoreCase(actualtext);
			result="pass";
		
		}catch (Exception e) {
			errormsg=e.getMessage();
			System.out.println(e);
			e.printStackTrace();
			CommonUtil.takeScreenShot(driver);
			throw e;
		}
		
		finally {
			System.out.println(result);
			if(!errormsg.isEmpty()) {
				System.out.println(errormsg);
			}	
		}
	}
	
	@Test
	public void verifyReservationPageHeading() throws IOException{
		
		WebDriver driver=null;
		String errormsg="",result="fail";
		
		try {
			
			String bn=CommonUtil.getPropertiesValue("config", "config.browsername");
			System.out.println(bn);
			String rm=CommonUtil.getPropertiesValue("config","config.runmode");
			System.out.println(rm);
			String url=CommonUtil.getPropertiesValue("config", "config.URL");
			System.out.println(url);
			
		    driver=BrowserFactory.getBrowser(bn, rm);
		    BrowserFactory.OpenURL(url);
		    
		    //HomePage hp=PageFactory.initElements(driver, HomePage.class);
		    String un=CommonUtil.getPropertiesValue("reservationpage","reservationpage.Username");
		    String ps=CommonUtil.getPropertiesValue("reservationpage", "reservationpage.Password");
		    System.out.println(un);
		    System.out.println(ps);
		    HomePage hp=PageFactory.initElements(driver, HomePage.class);
		    hp.enterusername(un);
		    hp.enterPassword(ps);
		    hp.clickSigIn();
		    
		    String expectedtext1=CommonUtil.getPropertiesValue("reservationpage","reservationpage.Heading1");
		    String expectedtext2=CommonUtil.getPropertiesValue("reservationpage", "reservationpage.Heading2");
		    System.out.println(expectedtext1);
		    System.out.println(expectedtext2);
		    
		    ReservationPage rp=PageFactory.initElements(driver, ReservationPage.class);
		    String actualtext1=rp.getHeadingText1();
		    System.out.println(actualtext1);
		    String actualtext2=rp.getHeading2();
		    System.out.println(actualtext2);
		    
		    assert expectedtext1.equalsIgnoreCase(actualtext1)&&expectedtext2.equalsIgnoreCase(actualtext2);
		    result="pass";
		    
	
		}catch (Exception e) {
			errormsg=e.getMessage();
			System.out.println(e);
			e.printStackTrace();
			CommonUtil.takeScreenShot(driver);
			throw e;
		}
		finally {
			System.out.println(result);
			if(!errormsg.isEmpty()) {
				System.out.println(errormsg);
			}	
		}
		
		
		
	}
	
}
