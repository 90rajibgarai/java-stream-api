package com.java.stram.api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

//---------------------------------------------------------------STEP-1 Normal Interface Implementation-----------------
/*
public class SupplierImpl implements Supplier<String>
{
	@Override
	public String get() 
	{		
		return "Nothing Input but return Some Data !";
	}
	
	public static void main(String[] args)
	{
		Supplier<String> supplier = new SupplierImpl();
		
		System.out.println("Return result from Supplier : "+supplier.get());
	}
}
*/

//-------------------------------------------------------------STEP-2 Functional Interface Implementation with Lambda-----
/*
public class SupplierImpl //implements Supplier<String>
{	
	public static void main(String[] args)
	{
		Supplier<String> supplier = () -> "Nothing Input but return Some Data !";
		
		System.out.println("Return result from Supplier : "+supplier.get());
	}
}
*/
//--------------------------------------------------------------STEP-3 Used Supplier Interface in orElseGet() Method---------
/*
public class SupplierImpl
{	
	public static void main(String[] args)
	{
		Supplier<String> supplier = () -> "Didn't find any match !";
		
		//List<String> chars = Arrays.asList("a", "b", "c");
		
		List<String> chars = Arrays.asList();
		
		System.out.println("Return result from Supplier : "+chars.stream().findAny().orElseGet(supplier));		
	}
}
*/
//--------------------------------------------------------------STEP-4 Direct Call Supplier's get() method in orElseGet----

public class SupplierImpl
{	
	public static void main(String[] args)
	{		
		//List<String> chars = Arrays.asList("a", "b", "c");		
		List<String> chars = Arrays.asList();
		
		System.out.println("Return result from Supplier : "+chars.stream().findAny().orElseGet(() -> "Didn't find any match !"));		
	}
}