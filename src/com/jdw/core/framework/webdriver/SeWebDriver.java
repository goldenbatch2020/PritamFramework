package com.jdw.core.framework.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jdw.core.framework.utils.Constants;

public class SeWebDriver
{
	public WebDriver driver;
	public SeWebDriver(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/*
	 * this method is use to pass the url in the browser
	 * paramName : Browser Url
	 */
	public void get(String url)
	{
		try
		{
			driver.get(url);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public WebElement findWebElement(String locator, String locatorValue)
	{
		WebElement w1=null;
		try
		{
			w1 = driver.findElement(FindBy.getLocator(locator, locatorValue));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return w1;
	}
	
	public List<WebElement> findWebElements(String locator, String locatorValue)
	{
		List<WebElement> w1=null;
		try
		{
			w1 = driver.findElements(FindBy.getLocator(locator, locatorValue));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return w1;
	}
	
	/*
	 * Capture the title at run time  
	 */
	
	public String getPageTitle()
	{
		String title = null;
		try
		{
			title = driver.getTitle();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return title;
	}
	
	public String getPageSource()
	{
		String source = null;
		try 
		{
			source = driver.getPageSource();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return source;
	}
	
	public String getCurrentPageUrl()
	{
		String url = null;
		try 
		{
			url = driver.getCurrentUrl();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return url;
	}
	
	public void implicitlyWait()
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(Constants.syncTime, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void explicitlyWait(String locator, String locatorValue)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Constants.syncTime);
			wait.until(ExpectedConditions.presenceOfElementLocated(FindBy.getLocator(locator, locatorValue)));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
}
