package com.k2js.mavenselemiumfw.pageobjects.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.hamcrest.core.SubstringMatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.k2js.mavenselemiumfw.pageobjects.testscripts.NewToursTestScripts;

public class CommonUtil {

	public static String getPropertiesValue(String fileName, String Key) throws FileNotFoundException {
		try (FileInputStream fis = new FileInputStream("./testdata/" + fileName + ".Properties")) {
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(Key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getCurrentDate() {
		LocalDateTime ld = LocalDateTime.now();
		String a=ld.toString();
		System.out.println(a);
		String dt = ld.toString().replace(":", "-").substring(0, ld.toString().indexOf("."));
		return dt;
	}

	public static void takeScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/" + getCurrentDate() + ".png");
		FileUtils.copyFile(src, dest);
	}

	/*public static void main(String[] args) throws Throwable {

		String a = CommonUtil.getPropertiesValue("config", "config.browsername");
		String b = CommonUtil.getCurrentDate();
		System.out.println(a);
		System.out.println(b);

		try {
			//String bname = CommonUtil.getPropertiesValue("config", "config.browsername");
		//	System.out.println(bname);
			//String runmode = CommonUtil.getPropertiesValue("config", "config.runmode");
			//System.out.println(runmode);
			//WebDriver a1 = BrowserFactory.getBrowser(bname, runmode);
			// BrowserFactory.getBrowser(bname, runmode);

			//String url = CommonUtil.getPropertiesValue("config", "config.URL");
		//	System.out.println(url);
		//	BrowserFactory.OpenURL(url);
			//CommonUtil.takeScreenShot(a1);
			
			NewToursTestScripts ntts=new NewToursTestScripts();
		//	ntts.verifyThePageTitel();
			ntts.verifyConfirmationMsg();
			
		} catch (Exception e) {
			
		}
	}*/

}