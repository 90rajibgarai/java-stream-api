package com.java.stram.filter;

import java.util.Arrays;
import java.util.List;

public class ExSimpleFilter 
{
	public static void main(String[] args)
	{
		List<String> names = Arrays.asList("Rahul", "Dipok", "Probir", "Pritam", "Sunil", "Anil", "Rajib", "Tulsi");
		
		names.stream().filter(s -> !s.equals("Rajib")).forEach(System.out::println);
		
		names.stream().filter(ExSimpleFilter::notEquals).forEach(System.out::println);	// Using Functional Programming
	}
	
	private static boolean notEquals(String name)
	{
		return !name.equals("Rajib");
	}
}

