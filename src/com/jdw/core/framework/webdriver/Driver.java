package com.jdw.core.framework.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.jdw.core.framework.utils.Global;

public class Driver 
{
	public static WebDriver driver;
	
	public static WebDriver getDriver()
	{
		String browserType = Global.browserName;
		
		switch(browserType)
		{
			case "chrome":
				System.setProperty("webdriver.chrome.driver", Global.chromeServer);
				driver = new ChromeDriver();
				break;
				
			case "ie":
				System.setProperty("webdriver.ie.driver", Global.ieServer);
				driver = new InternetExplorerDriver();
				break;
				
			case "firefox":
				System.setProperty("webdriver.gecko.driver", Global.ffServer);
				driver = new FirefoxDriver();
				break;
				
			default:
			try {
				throw new Exception("Invalid Browser Type "+browserType);
			}catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return driver;
	}
}
