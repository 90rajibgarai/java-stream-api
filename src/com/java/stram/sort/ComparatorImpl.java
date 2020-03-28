package com.java.stram.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.java.stram.datasource.Employee;
import com.java.stram.datasource.EmployeeDao;

// Comparator is another FunctionalInterface

//---------------------------------------------------------------STEP-1 Normal Interface Implementation-----------------
/*
public class ComparatorImpl implements Comparator<Employee>
{	
	@Override
	public int compare(Employee emp1, Employee emp2)
	{
		return emp1.getSalary() - emp2.getSalary();
	}
	
	public static void main(String[] args)
	{
		List<Employee> employees = EmployeeDao.getEmployee();		
		
		Comparator<Employee> comparator = new ComparatorImpl();
		
		Collections.sort(employees, comparator);
		
		System.out.println(employees);
	}
}*/

//-------------------------------------------------------------STEP-2 Functional Interface Implementation with Lambda-----
/*
public class ComparatorImpl //implements Comparator<Employee>
{	
	public static void main(String[] args)
	{
		List<Employee> employees = EmployeeDao.getEmployee();		
		
		Comparator<Employee> comparator = (emp1, emp2) -> emp1.getSalary() - emp2.getSalary();	// Ascending Order -> Need Descending (emp2 - emp1)
		
		Collections.sort(employees, comparator);
		
		System.out.println(employees);
	}
}*/

//--------------------------------------------------------------STEP-3 Used Comparator Interface compare method call directly----[In Traditional Way]
/*
public class ComparatorImpl
{	
	public static void main(String[] args)
	{
		List<Employee> employees = EmployeeDao.getEmployee();		
		
		Collections.sort(employees, (emp1, emp2) -> emp1.getSalary() - emp2.getSalary());
		
		System.out.println(employees);
	}
}
*/
//---------------------------------------------------------------Now using Stream API-------------------------------

public class ComparatorImpl
{	
	public static void main(String[] args)
	{
		List<Employee> employees = EmployeeDao.getEmployee();		
		//employees.stream().sorted((emp1, emp2) -> emp1.getSalary() - emp2.getSalary()).forEach(System.out::println);
		//OR
		//employees.stream().sorted(Comparator.comparing(emp -> emp.getSalary())).forEach(System.out::println);
		// OR
		employees.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
	}
}

