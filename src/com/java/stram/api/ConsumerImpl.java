package com.java.stram.api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

//---------------------------------------------------------------STEP-1 Normal Interface Implementation-----------------

/*public class ConsumerImpl implements Consumer<Integer>
{
	@Override
	public void accept(Integer t) 
	{
		System.out.println("Print : "+t);		
	}
	
	public static void main(String[] args) 
	{
		Consumer<Integer> consumer = new ConsumerImpl();
		consumer.accept(1012);
	}
}*/

//-------------------------------------------------------------STEP-2 Functional Interface Implementation with Lambda-----

/*public class ConsumerImpl
{	
	public static void main(String[] args) 
	{
		Consumer<Integer> consumer = t -> System.out.println("Print : "+t);
		consumer.accept(1012);
	}
}*/

//--------------------------------------------------------------STEP-3 Used Consumer Interface in ForEach Method---------

/*public class ConsumerImpl
{	
	public static void main(String[] args) 
	{
		Consumer<Integer> consumer = t -> System.out.println("Print : "+t);		
		
		List<Integer> marks = Arrays.asList(12, 25, 36, 47, 85);
		
		marks.stream().forEach(consumer);		// Automatically call accept method.
	}
}*/

//--------------------------------------------------------------STEP-4 Direct Call Consumer's accept method in ForEach---

public class ConsumerImpl
{	
	public static void main(String[] args) 
	{	
		List<Integer> marks = Arrays.asList(12, 25, 36, 47, 85);
		
		marks.stream().forEach(t -> System.out.println("Print : "+t));		// Automatically Create Consumer & call accept method.
	}
}

