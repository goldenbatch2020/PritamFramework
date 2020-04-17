package com.test;

class Test3
{
	private String name = "Pritam";
	
	private void m1()
	{
		System.out.println("m1 is a private method");
	}
	
	public void m2()
	{
		m1();
	}
	
}

public class Test2 
{
	public static void main(String[] args)
	{
		Test3 t1 = new Test3();
		t1.m2();
	}
}

