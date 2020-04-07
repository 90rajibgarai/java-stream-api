package com.java.stram.filter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ExampleFlatMap
{
	public static void main(String[] args)
	{
		List<User> users = Arrays.asList(new User("Sudip", 25, Arrays.asList("1000", "2000", "3000")),
				new User("Prodip", 21, Arrays.asList("5000", "6000", "7000")),
				new User("Babul", 20, Arrays.asList("3000", "7000")),
				new User("Koushik", 32, Arrays.asList("8000", "5000", "3000")),
				new User("Susmita", 23, Arrays.asList("9000", "2000")));
		
		Optional<String> result = users.stream().map(u -> u.getMobileNos().stream()).flatMap(ml -> ml.filter(m -> m.equals("7000"))).findAny();
		
		result.ifPresent(System.out::println);
		
		
		//Optional.ofNullable(); // If You expect Stream value with null -> Then you used Optional.ofNullable()
		//Optional.of(); // If you don't expect any null value then you used Optional.of()
	}
	
	private static class User
	{
		private String name;
		
		private Integer age;
		
		private List<String> mobileNos;		

		public User() {}
		
		public User(String name, Integer age, List<String> mobileNos) {
			super();
			this.name = name;
			this.age = age;
			this.mobileNos = mobileNos;
		}		

		@Override
		public String toString() {
			return "User [name=" + name + ", age=" + age + ", mobileNos=" + mobileNos + "]";
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public List<String> getMobileNos() {
			return mobileNos;
		}

		public void setMobileNos(List<String> mobileNos) {
			this.mobileNos = mobileNos;
		}
		
		
	}
}
