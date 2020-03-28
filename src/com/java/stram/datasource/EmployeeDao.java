package com.java.stram.datasource;

import java.util.Arrays;
import java.util.List;

public class EmployeeDao 
{
	public static List<Employee> getEmployee()
	{
		return Arrays.asList(new Employee(102, "Surojit Roy", "Male", 25000),
				new Employee(303, "Pritam Roy", "Male", 60000),
				new Employee(501, "Hari Das", "Male", 10000),
				new Employee(302, "Puja Chatterjee", "Female", 70000),
				new Employee(401, "Susmita Boss", "Female", 25000),
				new Employee(706, "Rajib Garai", "Male", 35000),
				new Employee(404, "Amita Banerjee", "Female", 65000));
	}
}
