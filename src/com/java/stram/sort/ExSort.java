package com.java.stram.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExSort
{	
	public static void main(String[] args)
	{
		List<Integer> marks = Arrays.asList(12, 25, 36, 47, 85, 19, -91, 33, 77);
		
		Collections.sort(marks);	//---In Traditional Way => Sort on Ascending order
		
		System.out.println("Ascending Order : "+marks);
		
		marks.stream().sorted().forEach(m -> System.out.print(m+" "));	//---Using Stream API => Sort on Ascending order
		
		System.out.println("\n-------------------------------------------\n");
		
		Collections.reverse(marks);	//---In Traditional Way => Sort on Descending order
		
		System.out.println("Descending order : "+marks);
		
		marks.stream().sorted(Comparator.reverseOrder()).forEach(m -> System.out.print(m+" "));	//---Using Stream API => Sort on Descending order		
	}
}
