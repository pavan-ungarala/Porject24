package com.infy.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Set;

public class MaxIPAddress {

	public static void main(String[] args) {
		String[] urls = {"10.0.1.45 -/d/in/intheclass", "10.0.1.45 -/a/facts/final.../bhgahf", "10.3.54.123 -/d/xyz/bcc/yes"};
		Map<String, Integer> ipsMap = new HashMap<>();
		for(String url : urls) {
			String ip = url.substring(0, url.indexOf(" "));
			if(!(ipsMap.containsKey(ip))) {
				ipsMap.put(ip, 1);
				continue;
			}
			ipsMap.replace(ip, ipsMap.get(ip)+1);
		}
		
		System.out.println("Most repeated ip address is ::");
		Set<Entry<String, Integer>> entrys = ipsMap.entrySet();
		String repetedIP = null;
		int max = 0;
		for(Entry<String, Integer> entry : entrys) {
			if(entry.getValue() > max) {
				max = entry.getValue();
				repetedIP = entry.getKey();
			}
		}
		System.out.println(repetedIP);
		
		/*
		//Logic implemented by using stream api
		Map<Object, Integer> ipAddresses = Arrays.stream(urls)
										         .map(url -> url.substring(0, url.indexOf(" ")))
										         .collect(Collectors.toMap(ip -> ip, ip -> 1, Integer::sum));
		int maxValue = ipAddresses.values()
						.stream()
						.max(Integer::compare)
						.orElse(0);
		System.out.println("Most repeated ip address is ::");
		ipAddresses.entrySet().stream()
		.filter(entry -> entry.getValue() == maxValue)
		.map(Map.Entry::getKey)
		.toList().forEach(System.out::println);
		*/
	}

}
