package com.java.stram.filter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ExSomeUsefulMethods 
{
	public static void main(String[] args)
	{
		List<String> names = Arrays.asList("Rahul", "Dipankar", "Probir", "Pritam", "Sunil", "Anil", "Rajib", "Tushar", "Sunil", "Susmita", "Hari", "Dipak");
		
		names.stream().distinct().forEach(System.out::println);
		
		System.out.println("------------------Sorted Ascending Order-----------------------");
		
		names.stream().distinct().sorted().forEach(System.out::println);	// Ascending Order
		
		System.out.println("------------------Sorted Descending Order-----------------------");
		
		names.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);	// Descending Order	
		
		System.out.println("------------------Skip some values-----------------------");
		
		names.stream().skip(2).filter(name -> name.length() > 5).forEach(System.out::println);
	}
}
