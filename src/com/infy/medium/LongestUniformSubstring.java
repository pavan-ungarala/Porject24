package com.infy.medium;

import java.util.ArrayList;
import java.util.List;

public class LongestUniformSubstring {

	public static void main(String[] args) {
		String input = "10000111";
		//String input = "";
		int[] output = new int[2];
		List<String> longestStrList = new ArrayList<>();
		int startIndex = 0;
		int endIndex = 0;
		int longestString = 0;
		int length = input.length();
		for(int i=1; i<length; i++) {
			if(input.charAt(startIndex) == input.charAt(i)) {
				endIndex = i;
				continue;
			}
			if(endIndex != 0) {
				longestStrList.add(input.substring(startIndex, endIndex+1));
				endIndex =0;
			}
			startIndex = i;
		}
		if(endIndex != 0) {
			longestStrList.add(input.substring(startIndex, endIndex+1));
		}
		for(String str : longestStrList) {
			if(str.length() > longestString) {
				longestString = str.length();
			}
		}
		if(longestString != 0) {
			output[0] = 1;
			output[1] = longestString;
		}else {
			output[0] = -1;
			output[1] = 0;
		}
		
		if(output[0] == 1) {
			System.out.println("Longest uniform substring is found ["+output[0]+", "+output[1]+"]");
		}else {
			System.out.println("No longest uniform substring is found ["+output[0]+", "+output[1]+"]");
		}
	}

}
