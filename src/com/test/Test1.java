package com.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.jdw.core.framework.utils.Constants;
import com.jdw.core.framework.webdriver.Driver;
import com.jdw.core.framework.webdriver.FindBy;
import com.jdw.core.framework.webdriver.SeWebDriver;

public class Test1
{
	@Test
	public void searchProduct()
	{
		WebDriver driver = Driver.getDriver();
		
		SeWebDriver sdriver = new SeWebDriver(driver);
		sdriver.get("https://www.jdwilliams.co.uk/");
		sdriver.implicitlyWait();
		WebElement w1 = sdriver.findWebElement("xpath", "//input[@name='searchString']");
		w1.sendKeys("Jeans");
		WebElement searchBtn = sdriver.findWebElement("id", "searchButton");
		searchBtn.click();
		sdriver.explicitlyWait("xpath", "(//img[contains(@id,'imageProduct')])[1]");
		
		
	}
}
