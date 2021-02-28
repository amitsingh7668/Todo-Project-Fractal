package com.hackathon.socgen.unitTest;

public class wordInDict {

//  Input
//  s = "catsanddog"
//  wordDict = ["cat", "cats", "and", "sand", "dog"]
//	Output:
//	[
//		  "cats and dog",
//		  "cat sand dog"
//	]
	public void handle() {
		String s = "catsanddog";
		String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
		String temp ="";
		String tr = "";
		int count =0;
		for(int i =0;i<wordDict.length;i++)
		{
		for(int j =0;j<wordDict.length;j++)
		{
		        tr = tr + wordDict[j];
				String b = wordDict[j];
				if(s.contains(b))
				{
					temp = temp +" "+ b;
				}
				else
				{
					break;
				}

	}
		}
		System.out.println(temp);
	}
	public static void main(String[] args) {
		wordInDict word = new wordInDict();
		word.handle();
	}
}
