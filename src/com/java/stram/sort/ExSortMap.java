package com.java.stram.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ExSortMap
{
	public static void main(String[] args)
	{
		Map<String, Integer> numbers = new HashMap<>();
		
		numbers.put("One", 1);
		numbers.put("Two", 2);
		numbers.put("Five", 5);
		numbers.put("Seven", 7);
		numbers.put("Ten", 10);
		numbers.put("Zero", 0);
		numbers.put("Nine", 9);
		numbers.put("Three", 3);
		numbers.put("Fore", 4);
		numbers.put("Six", 6);
		
		//-------------------------------------------------------------------------------Traditional Approach-----------------------
		
		/*List<Entry<String, Integer>> entries = new ArrayList<>(numbers.entrySet());
		
		Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
		
		for(Entry<String, Integer> entry : entries)
		{
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}*/
		
		//-----------------------------------------------------------------------------Using Stream API-----------------------------
		
		numbers.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		System.out.println("-------------------------BY Value--------------------");
		numbers.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
	}
}
