package com.java.stram.foreach;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExIteration
{	
	public static void main(String[] args) 
	{
		List<String> friends = Arrays.asList("Asit", "Probir", "Hari", "Rohim", "Tanmoy", "Anubha", "Siuli", "Pritam", "Rajib", "Susmita");
				
		for(String friend : friends)											//----------------Traditional Way : List Iteration-------------
		{			
			System.out.println("Friend name : "+friend);
		}
			
		System.out.println("\n-----------USE STREAM API--------------\n");
		
		friends.stream().forEach(f -> System.out.println("Friend name : "+f));	//-----------Use Stream API : List Iteration-------------------
		
	//----------------------------------------------------------------------------------------------------------------------
		
		Map<Integer, String> subjects = new HashMap();
		
		subjects.put(201, "Bengali");
		subjects.put(202, "English");
		subjects.put(207, "Math");
		subjects.put(205, "Geography");
		
		subjects.forEach((key, value)  -> System.out.println("Sub Code - Name : "+ key +" - "+value));	//----Traditional Way : Map Iteration----
		
		System.out.println("\n----------USE STREAM API-------------\n");
		
		subjects.entrySet().stream().forEach(obj -> System.out.println("Sub Code - Name : "+obj.getKey()+" - "+obj.getValue())); //---Use Stream API : Map Iteration---
	}
}