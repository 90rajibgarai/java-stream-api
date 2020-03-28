package com.java.stram.sort;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import com.java.stram.datasource.Employee;

//-----------------------------------------------Sort Functionality For Object map Values------[Traditional Approach]-----------------------------
/*
public class ComparatorMapImpl 
{
	public static void main(String[] args)
	{
		Map<Employee, Integer> employeeMap = new TreeMap<>(new Comparator<Employee>() 
		{
			@Override
			public int compare(Employee o1, Employee o2) 
			{			
				return o1.getSalary() - o2.getSalary();
			}		
		});
		
		employeeMap.put(new Employee(102, "Surojit Roy", "Male", 25000), 101);
		employeeMap.put(new Employee(303, "Pritam Roy", "Male", 60000), 107);
		employeeMap.put(new Employee(501, "Hari Das", "Male", 10000), 105);
		employeeMap.put(new Employee(302, "Puja Chatterjee", "Female", 70000), 102);
		employeeMap.put(new Employee(401, "Susmita Boss", "Female", 25000), 108);
		employeeMap.put(new Employee(706, "Rajib Garai", "Male", 35000), 104);
		employeeMap.put(new Employee(404, "Amita Banerjee", "Female", 65000), 105);
		
		System.out.println(employeeMap);
	}
}*/
//-------------------------------------------Sort Functionality For Object map Values--Using Lambda----[Traditional Approach]-------------------
/*public class ComparatorMapImpl 
{
	public static void main(String[] args)
	{
		Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) -> o1.getSalary() - o2.getSalary());
		
		employeeMap.put(new Employee(102, "Surojit Roy", "Male", 25000), 101);
		employeeMap.put(new Employee(303, "Pritam Roy", "Male", 60000), 107);
		employeeMap.put(new Employee(501, "Hari Das", "Male", 10000), 105);
		employeeMap.put(new Employee(302, "Puja Chatterjee", "Female", 70000), 102);
		employeeMap.put(new Employee(401, "Susmita Boss", "Female", 25000), 108);
		employeeMap.put(new Employee(706, "Rajib Garai", "Male", 35000), 104);
		employeeMap.put(new Employee(404, "Amita Banerjee", "Female", 65000), 105);
		
		System.out.println(employeeMap);
	}
}
*/
//-------------------------------------------Sort Functionality For Object map Values--Using Lambda----[Stream API]-------------------
public class ComparatorMapImpl 
{
	public static void main(String[] args)
	{
		Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) -> o1.getSalary() - o2.getSalary());
		
		employeeMap.put(new Employee(102, "Surojit Roy", "Male", 25000), 101);
		employeeMap.put(new Employee(303, "Pritam Roy", "Male", 60000), 107);
		employeeMap.put(new Employee(501, "Hari Das", "Male", 10000), 105);
		employeeMap.put(new Employee(302, "Puja Chatterjee", "Female", 70000), 102);
		employeeMap.put(new Employee(401, "Susmita Boss", "Female", 25000), 108);
		employeeMap.put(new Employee(706, "Rajib Garai", "Male", 35000), 104);
		employeeMap.put(new Employee(404, "Amita Banerjee", "Female", 65000), 105);
		
		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName))).forEach(System.out::println);	// Ascending Order
		
		System.out.println("--------------------Descending Order------------------");
		
		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName).reversed())).forEach(System.out::println);	// Descending Order
	}
}
