package com.infy.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*String ss[][]={{"Boddy","87"},
{"Charles", "100"},
{"Eric","64"},
{"Charles", "22"}}; */

public class BestAverages {

	public static void main(String[] args) {
		String ss[][]={{"Boddy","87"},
        {"Charles", "100"},
        {"Eric","64"},
        {"Charles", "22"}};
		Map<String, List<Double>> marksMap = new HashMap<>();
		double average = 0;
		double bestAverage =0;
		
		for(String[] record : ss) {
			if(!marksMap.containsKey(record[0])) {
				List<Double> marksList = new ArrayList<>();
				marksList.add(Double.parseDouble(record[1]));
				marksMap.put(record[0], marksList);
			}else {
				List<Double> marksList = marksMap.get(record[0]);
				marksList.add(Double.parseDouble(record[1]));
				marksMap.replace(record[0], marksList);
			}
		}
		
		Set<Entry<String, List<Double>>> entrys = marksMap.entrySet();
		for(Entry<String, List<Double>> entry : entrys) {
			List<Double> marksList = entry.getValue();
			int length = marksList.size();
			average = 0;
			if(length == 1) {
				average = marksList.get(0);
			}else {
				for(int i=0; i<length; i++) {
					average += marksList.get(i);
				}
				average = average/length;
			}			
			if(bestAverage < average) {
				bestAverage = average;
			}
		}
		
		System.out.println("Best average is: "+bestAverage);
	}

}
