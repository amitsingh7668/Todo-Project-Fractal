package com.hackathon.socgen.unitTest;

import java.util.Scanner;

public class distinctSubstring {

	public void handle() 
{
	String[] testCasesValue = userInput();
	iterateOverTestCaseandCount(testCasesValue);
}
	private String[] userInput() {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		String[] testCasesValue = new String[testCases];
		for(int i =0 ; i<testCases ;i++)
		{
			Scanner sc1 = new Scanner(System.in);
			String value = sc1.nextLine();
			testCasesValue[i]= value;
		}
		return testCasesValue;
	}
	
	private void iterateOverTestCaseandCount(String[] testCasesValue) {
		for(int j =0;j<testCasesValue.length;j++)
		{
			String testCasesValues = testCasesValue[j];
			char[] intoChar = testCasesValues.toCharArray();
			String longestString ="";
			int count =0;
			int temp =0;
			String convertString = "";
			count = longestDistinctStringLength(intoChar, longestString, count, temp, convertString);
			System.out.println(count);
		}
	}
	
	private int longestDistinctStringLength(char[] intoChar, String longestString, int count, int temp,
			String convertString) {
		for (int k =0;k < intoChar.length;k++)
			{
			    
				convertString = convertString+intoChar[k];
				if(!longestString.contains(convertString))
				{
					longestString = longestString+intoChar[k];	
					temp ++;
					convertString = "";
				}
				else
				{
					if(temp>count)
					{
						count =temp ;
						temp =0;
						longestString ="";
						longestString = longestString+intoChar[k];	
						temp++;
						convertString = "";
					}
					
					else
					{
						temp =0;
						longestString ="";
						convertString = "";
					}
					
				}
				if(k==intoChar.length-1)
				{
					if(temp>count)
					{
						count =temp;
					}
				}
		}
		return count;
	}
	public static void main(String[] args) {
		distinctSubstring distSub = new distinctSubstring();
		distSub.handle();
	}
	
}
