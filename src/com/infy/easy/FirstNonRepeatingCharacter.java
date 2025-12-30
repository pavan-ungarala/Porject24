package com.infy.easy;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/*
 Write a function that returns the first non-repeating character in String.
Example 1:
Input: "apple"
Output: 'a'
Example 2:
Input: "papaya"
Output: 'y'
Test cases:
i) return '0' if all the characters are repeating
ii) return " " if null string passed
Questions asked: What is the default value can be returned if all the characters are repeating.
 */
public class FirstNonRepeatingCharacter {

	public static char firstNonRepeating(String input) {
		char output = ' ';
		if(input == null) {
			return ' ';
		}
		int length = input.length();
		if(length == 1) {
			return input.charAt(0);
		}
		Map<Character, Integer> charsMap = new ConcurrentHashMap<>();
		charsMap.put(input.charAt(0), 1);
		for(int i=1; i<length; i++) {
			char ch = input.charAt(i);
			if(charsMap.containsKey(ch)) {
				int value = charsMap.get(ch) +1;
				charsMap.replace(ch, value);
				continue;
			}
			charsMap.put(ch, 1);
		}
		Set<Entry<Character, Integer>> entrys = charsMap.entrySet();
		for(Entry<Character, Integer> entry : entrys) {
			if(entry.getValue() == 1) {
				output = entry.getKey();
				break;
			}
		}
		
		return output;
	}
	public static void main(String[] args) {
		String input = "papaya";
		char output = firstNonRepeating(input);
		if(output == ' ') {
			System.out.println("String is empty");
		}else {
			System.out.println("First non repeated character of this string is: "+output);
		}

	}

}
