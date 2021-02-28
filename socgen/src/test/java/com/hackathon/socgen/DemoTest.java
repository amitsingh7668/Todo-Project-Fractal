package com.hackathon.socgen;

public class DemoTest {
	
	
	public void fizzBuzz()
	{
		
		for ( int i =0 ;i <=20;i++)
		{
			 if (i%3 ==0 && i%5==0)
			{
			System.out.println("FizzBuzz");
			}
			
			else if(i% 5 ==0)
			{
			System.out.println("Buzz");
			}
			else if(i% 3 ==0)
			{
			System.out.println("Fizz");
			}

		}
	}
	public static void main(String[] args) {
		DemoTest dv = new DemoTest();
		dv.fizzBuzz();
	}
	

}
