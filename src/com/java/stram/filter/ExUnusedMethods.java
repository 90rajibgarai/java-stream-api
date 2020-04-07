package com.java.stram.filter;

import java.util.stream.Stream;
import java.util.List;
import java.util.stream.Collectors;

public class ExUnusedMethods {

	public static void main(String[] args) 
	{
		List<String> result = Stream.of("One", "Two", "Three", "Four", "Five").filter(s -> !s.equals("One"))
														.peek(System.out::println)
														.collect(Collectors.toList());
		
		// Peek is used for internal Stream result. Peek don't interrupt you functional logic -> It's used for print log

		result.forEach(System.out::println);
	}

}
