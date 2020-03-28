package com.java.stram.api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//---------------------------------------------------------------STEP-1 Normal Interface Implementation-----------------
/*
public class PredicateImpl implements Predicate<Integer>
{
	@Override
	public boolean test(Integer num) 
	{
		if(num % 2 == 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) 
	{
		Predicate<Integer> predicate = new PredicateImpl();
		
		System.out.println(predicate.test(28));
	}
}
*/

//-------------------------------------------------------------STEP-2 Functional Interface Implementation with Lambda-----
/*
public class PredicateImpl //implements Predicate<Integer>
{
	public static void main(String[] args) 
	{
		Predicate<Integer> predicate = num -> {
			if(num % 2 == 0)
				return true;
			else
				return false;
		};
		
		System.out.println(predicate.test(28));
	}
}
*/
//--------------------------------------------------------------STEP-3 Used Predicate Interface in Filter Method---------
/*
public class PredicateImpl
{
	public static void main(String[] args) 
	{
		Predicate<Integer> predicate = num -> {
			if(num % 2 == 0)
				return true;
			else
				return false;
		};
		
		List<Integer> numbers = Arrays.asList(12, 25, 36, 47, 85);
		
		numbers.stream().filter(predicate).forEach(t -> System.out.println("Event Number : "+t));
	}
}
*/

//--------------------------------------------------------------STEP-4 Direct Call Predicate's test method in filter----

public class PredicateImpl
{
	public static void main(String[] args) 
	{		
		List<Integer> numbers = Arrays.asList(12, 25, 36, 47, 85, 78);
		
		numbers.stream().filter(num -> num % 2 == 0).forEach(t -> System.out.println("Event Number : "+t));
	}
}