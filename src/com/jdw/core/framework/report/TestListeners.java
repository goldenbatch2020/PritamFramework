package com.jdw.core.framework.report;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


public class TestListeners implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result)
	{
		Reporter.log(result.getName()+" --->Test script is started : ");
		System.out.println("Test");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log(result.getName()+" ---> Test script is Passed : ");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log(result.getName()+" ---> Test script is Failed : ");
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log(result.getMethod().getMethodName()+" ---> Test script is Skipped : ");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{

	}

	@Override
	public void onStart(ITestContext context) 
	{

	}

	@Override
	public void onFinish(ITestContext context) 
	{

	}

}
