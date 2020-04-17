package com.jdw.core.framework.webdriver;

import org.openqa.selenium.By;

public class FindBy 
{
	public static By getLocator(String locator, String locatorValue)
	{
		By by = null;
		switch(locator.toLowerCase())
		{
			case "id":
				by = By.id(locatorValue);
				break;
				
			case "name":
				by = By.name(locatorValue);
				break;
				
			case "classname":
				by = By.className(locatorValue);
				break;
				
			case "link_text":
				by = By.linkText(locatorValue);
				break;
				
			case "partial_link_text":
				by = By.partialLinkText(locatorValue);
				break;
				
			case "xpath":
				by = By.xpath(locatorValue);
				break;
			
			case "css-selector":
				by = By.cssSelector(locatorValue);
				break;
				
			default:
				try
				{
					throw new Exception("Invalid Locator : "+locator);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
		}
		return by;
	}
}
