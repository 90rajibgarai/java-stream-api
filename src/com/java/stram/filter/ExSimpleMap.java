package com.java.stram.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExSimpleMap
{
	public static void main(String[] args)
	{
		List<String> names = Arrays.asList("Rahul", "Dipok", "Probir", "Pritam", "Sunil", "Anil", "Rajib", "Tulsi");
		
		//names.stream().filter(s -> !s.equals("Rajib")).forEach(System.out::println);
		
		List<User> users = names.stream().filter(s -> !s.equals("Rajib")).map(User::new).collect(Collectors.toList()); // Using Map Create User Objects
		
		users.forEach(System.out::println);
		
		Integer sumation = users.stream().mapToInt(User::getSalary).sum();
		
		System.out.println("Salary Sumation : "+sumation);
	}
	
	
	private static class User
	{
		private String name;
		private Integer salary = 30000;
		
		public User() {}
		
		public User(String name) {
			super();
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getSalary() {
			return salary;
		}
		public void setSalary(Integer salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "User [name=" + name + ", salary=" + salary + "]";
		}	
	}
}
