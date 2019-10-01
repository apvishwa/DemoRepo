package com.k2js.mavenselemiumfw.pageobjects.util;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

		
	private static WebDriver driver=null;
		
	public static WebDriver getBrowser(String bn,String rm) {
		
		if(rm.equalsIgnoreCase("local")) {
			if(bn.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
			}
			else if(bn.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
			}
			else if(bn.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver= new InternetExplorerDriver();
			}
			else if(bn.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver= new EdgeDriver();
			}
		}
		
		if(rm.equalsIgnoreCase("remote")) {
			if(bn.equalsIgnoreCase("Chrome")) {
				try {
				ChromeOptions co=new ChromeOptions();
				driver= new RemoteWebDriver(new URL("http://192.168.31.73:4444/wd/hub") , co);
				}catch (Exception e) {
				}	
			}
			else if(bn.equalsIgnoreCase("firefox")) {
				try {
				FirefoxOptions fo=new FirefoxOptions();
				driver= new RemoteWebDriver(new URL("http://192.168.31.73:4444/wd/hub"), fo);
				}catch (Exception e) {
				}
			}
			else if(bn.equalsIgnoreCase("ie")) {
				try {
				InternetExplorerOptions  io=new InternetExplorerOptions();
				driver= new RemoteWebDriver(new URL("http://192.168.31.73:4444/wd/hub"), io);
				}catch (Exception e) {
				}
			}
			else if(bn.equalsIgnoreCase("edge")) {
				try {
				EdgeOptions eo=new EdgeOptions();
				driver = new RemoteWebDriver(new URL("http://192.168.31.73:4444/wd/hub"), eo);
				}catch (Exception e) {
				}
			}
		}
		return driver;
	}
	
	public static void OpenURL(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public static void closeBrowser(){
		driver.close();
	}
}
