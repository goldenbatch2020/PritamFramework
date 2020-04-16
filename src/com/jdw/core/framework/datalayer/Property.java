package com.jdw.core.framework.datalayer;

import java.io.FileInputStream;
import java.util.Properties;

public class Property
{
	public String propertyFilePath;
	
	public Property(String propertyFilePath)
	{
		this.propertyFilePath = propertyFilePath;
	}
	
	public String getProperty(String key)
	{
		String data = "";
		try
		{
			FileInputStream fis = new FileInputStream(propertyFilePath);
			Properties pro = new Properties();
			pro.load(fis);
			data = pro.getProperty(key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
}
