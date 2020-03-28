package com.java.stram.filter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExFilter 
{
	public static void main(String[] args)
	{
		List<String> friends = Arrays.asList("Asit", "Probir", "Hari", "Rohim", "Tanmoy", "Anubha", "Siuli", "Pritam", "Rajib", "Susmita");
		
		for(String friend : friends)											//----------------In Traditional Way : List Filter-------------
		{	
			if(friend.startsWith("R"))
				System.out.println("Friend name : "+friend);
		}
			
		System.out.println("\n---------------USE STREAM API---------------\n");
		
		friends.stream().filter(f -> f.startsWith("R")).forEach(f -> System.out.println("Friend name : "+f));	//-----------Use Stream API : List Filter-----
	
		List<String> filterList = friends.stream().filter(f -> f.startsWith("R")).collect(Collectors.toList());	//------Use Stream API : Store List of Filter data into another List-----
		
		System.out.println(filterList);
		
		//----------------------------------------------------------------------------------------------------------------------
		
		Map<Integer, String> subjects = new HashMap();
		
		subjects.put(201, "Bengali");
		subjects.put(202, "English");
		subjects.put(207, "Math");
		subjects.put(205, "Geography");
		
		System.out.println("\n-----------USE STREAM API---------------\n");
		
		subjects.entrySet().stream().filter(s -> s.getKey() <= 204).forEach(obj -> System.out.println("Common Sub Code - Name : "+obj.getKey()+" - "+obj.getValue())); //---Use Stream API : Map Filter---
	}
}
