package com.java.stram.filter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ExReadFileAndReplaceContent {

	public static void main(String[] args) 
	{
		try
		{
			List<String> lineOfString = Files.lines(Paths.get("src/resources/sample.txt"))
												.filter(line -> line.contains("name"))
												.map(line -> line.replaceAll("name", "")
																.replaceAll("<", "")
																.replaceAll(">", "")
																.replaceAll("/", ""))
												.collect(Collectors.toList());
			
			lineOfString.forEach(System.out::println);
		}
		catch(Exception e) {e.printStackTrace();}
	}

}
