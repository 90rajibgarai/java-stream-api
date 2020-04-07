: How to work Java Stream API internally :
-------------------------------------------------------------------------------------------------------------------------------

1) How internaly work Java Functional Interface :

		A) Consumer
		B) Predicate
		C) Supplier
		D) Comparator

2) How it's work - "forEach" Iteration

3) How it's work - "filter" Conditional Chek

4) How it's work - "sort" - Traditional way and using Stream API

		i) Sort ArrayList (Primitive/Object)
		ii) Sort Map (Primitive/Object)
-----------------------------------------------------------------------------------------------------------------------------------

What is Java Lambda Expression ?
---------------------------------------------------------------------------------------------------------------------------
The expression through which we can represent an Anonymous function.

---------------------------------------------------------------------------------------------------------------------------
What is Anonymous function ?
---------------------------------------------------------------------------------------------------------------------------
A method who don't have any name or modifier.

 Anonymous : Nameless/Unknown
 
 Sysntex : 	Parameter Rxpression Body => () -> System.out.println("Lambda Sysntex !")

Example of Normal Method :

	public void example() {
		System.out.println("Normal Method");
	}	
Example of Anonymous Method :

	() {
		System.out.println("Anonymous Method");
	}
---------------------------------------------------------------------------------------------------------------------------
What is Functional Interface ?
---------------------------------------------------------------------------------------------------------------------------
The interface who contains only one abstarct method but can have multiple default and static method is called functional interface.

Functional Interface define as @FunctionalInterface	<= But annotation is not mendatory.
	
Example :

	Runnable	=> run()
	Callable	=> call()
	Comparable	=> compareTo()
	Comparator	=> compare()
	
Example of custome Functional Interface :

	public interface MyFunctionalInterface
	{
		void substruct(int num1, num2);	// One abstract method
		
		default void method2() {
			System.out.println("Default Method 1");
		}
		
		default void method3() {
			System.out.println("Default Method 2");
		}
		
		static void method4() {
			System.out.println("Static Method !");
		}
	}
	
	public class MyFunctionalInterfaceImpl
	{
		MyFunctionalInterface mfi = (n1, n2) -> n2 - n1; //Implement method substruct & create reference variable
		
		System.out.println(mfi.substruct(12, 20));
	}
---------------------------------------------------------------------------------------------------------------------------
What do you know about - Consumer, Predicate, Supplier in Java 8 ?
---------------------------------------------------------------------------------------------------------------------------
-> Consumer, Predicate, Supplier there are theree Functional Interfaces internally used in java stream API.

----------------------------------------------------------------------------------------------------------------------------------
Consumer : 
----------------------------------------------------------------------------------------------------------------------------------
Whenever we need to a object as a inpunt and base on the input you do some operation and you don't return anything.

	-------------------------------------------------------------------------------------------
	@FunctionalInterface
	public inferface Consumer
	{
		void accept(T t);
	}
	-------------------------------------------------------------------------------------------
	Consumer consumer = t -> System.out.println("Data : "+t);
	consumer.accept(10);
	
			OR
			
	list.stream().forEach(t -> System.out.println("Marks : "+t));	// In Java Stream Example
	-------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------------------	
Predicate : 
----------------------------------------------------------------------------------------------------------------------------------
This interface normaly we are used for conditional statement. when we check any condition and response as true/ false then we used that inferface.
	
	-------------------------------------------------------------------------------------------
	@FunctionalInterface
	public inferface Predicate
	{
		boolean test(T t);
	}
	-------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------	
Supplier : 
----------------------------------------------------------------------------------------------------------------------------------
Here we are not input any thing but expected output.

	-------------------------------------------------------------------------------------------
	@FunctionalInterface
	public inferface Supplier
	{
		T get();
	}
	-------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------	
What is Java Stream API ?
----------------------------------------------------------------------------------------------------------------------------------
Java Stream API introduce in java 8, It is used to process collections of objects.

A stream is not a data substruct instead it takes input from the Collections, Arrays or I/O channels.
	
Stream don't change the original data substruct, they only provide the result as per the pipelined methods.

--------------------------------------------------------------------------------------------------------------------------------------
Why we need Stream API ?
----------------------------------------------------------------------------------------------------------------------------------
Advantages following below :

1) Functional Programming : i.e. We can achive FunctionalInterface with lambda.

2) Code Reduce : We can reduce code length using lambda.
	
3) Bulk Operation : Compare to our triditional approch Stream give us better performance.
	
--------------------------------------------------------------------------------------------------------------------------------------
Java Stream API's Methods :
----------------------------------------------------------------------------------------------------------------------------------
A) forEach :- For Iteration
----------------------------------------------------------------------------------------------------------------------------------

	----------------------------------------------------------------------------------------------------------------------
									//--Use Stream API : List Iteration--
									
	friends.stream().forEach(f -> System.out.println("Friend name : "+f));
	
									//--Traditional Way : Map Iteration--
									
	subjects.forEach((key, value)  -> System.out.println("Sub Code - Name : "+ key +" - "+value));	
	
					 				//--Use Stream API : Map Iteration--
	subjects.entrySet().stream()
				.forEach(obj -> System.out.println("Sub Code - Name : "+obj.getKey()+" - "+obj.getValue()));
				
	----------------------------------------------------------------------------------------------------------------------
	
B) Filter :- For Conditional Chek
----------------------------------------------------------------------------------------------------------------------------------

	----------------------------------------------------------------------------------------------------------------------
										//--Use Stream API : List Filter--
	friends.stream()
		.filter(f -> f.startsWith("R"))
		.forEach(f -> System.out.println("Friend name : "+f));	
	
								//---Use Stream API : Store List of Filter data into another List
	List<String> filterList = friends.stream()
						.filter(f -> f.startsWith("R"))
						.collect(Collectors.toList());	
	
	str.startsWith("R");		=> String Class Method
	str.endsWith("b");	
											//---Use Stream API : Map Filter---
	subjects.entrySet().stream()					
				.filter(s -> s.getKey() <= 204)
				.forEach(obj -> System.out.println("Common Sub Code - Name : "+obj.getKey()+" - "+obj.getValue())); 
	
	----------------------------------------------------------------------------------------------------------------------
C) Sort :- For Sorting Order 
----------------------------------------------------------------------------------------------------------------------------------
	Sort From Primitive ArrayList :
	----------------------------------------------------------------------------------------------------------------------
	
	Collections.sort(marks);	//---In Traditional Way => Sort on Ascending order
	
	marks.stream().sorted()
			.forEach(m -> System.out.print(m+" "));	//---Using Stream API => Sort on Ascending order
	
	Collections.reverse(marks);	//---In Traditional Way => Sort on Descending order
	
	marks.stream()
		.sorted(Comparator.reverseOrder())
		.forEach(m -> System.out.print(m+" "));	//---Using Stream API => Sort on Descending order
	
	----------------------------------------------------------------------------------------------------------------------
	Sort From Object ArrayList :
	----------------------------------------------------------------------------------------------------------------------
	
	//---In Traditional Way => Sort List of Object base on one property salary <= Ascending order
	
	Collections.sort(employees, (emp1, emp2) -> emp1.getSalary() - emp2.getSalary()); 
				
	
	employees.stream()
			.sorted((emp1, emp2) -> emp1.getSalary() - emp2.getSalary())
			.forEach(System.out::println);	// Using Stream API  <= For Descending Order (emp2 - emp1)**
	//OR
	
	employees.stream()
			.sorted(Comparator.comparing(emp -> emp.getSalary()))
			.forEach(System.out::println);		// Using Java Stream - comparing function
	
	//OR
	employees.stream()
			.sorted(Comparator.comparing(Employee::getName))
			.forEach(System.out::println);	
			
	----------------------------------------------------------------------------------------------------------------------
D) Sorting For Map :
----------------------------------------------------------------------------------------------------------------------------------
	----------------------------------------------------------------------------------------------------------------------
	
	List<Entry<String, Integer>> entries = new ArrayList<>(numbers.entrySet());	//------Traditional Approach------
	
	Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
	
	numbers.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.forEach(System.out::println);	//------Using Stream API------Sort By Key
				
	numbers.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.forEach(System.out::println);	//------Using Stream API------Sort By Value
	
	----------------------------------------------------------------------------------------------------------------------
	Sort of Map Objects :
	----------------------------------------------------------------------------------------------------------------------
	
	employeeMap.entrySet().stream()
			.sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName)))
			.forEach(System.out::println);	// Ascending Order
			
	employeeMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName).reversed()))
				.forEach(System.out::println);	// Descending Order
				
	----------------------------------------------------------------------------------------------------------------------
	
==============================================================================================================================
[Tech Primers]

E) Java Streams | Filter & ForEach :
------------------------------------
	public class ExSimpleFilter 
	{
		public static void main(String[] args)
		{
			List<String> names = Arrays.asList("Rahul", "Dipok", "Probir", "Pritam", 
								"Sunil", "Anil", "Rajib", "Tulsi");

			names.stream().filter(s -> !s.equals("Rajib"))
					.forEach(System.out::println);

			names.stream().filter(ExSimpleFilter::notEquals)
					.forEach(System.out::println);	// Using Functional Programming
		}

		private static boolean notEquals(String name)
		{
			return !name.equals("Rajib");
		}
	}

F) Java Streams | Map :
------------------------------------

Create List of Objects from a List using Map :
----------------------------------------------
	List<User> users = names.stream().filter(s -> !s.equals("Rajib"))
					.map(User::new)
					.collect(Collectors.toList()); // Using Map to Create User(String name) Objects

Summation of Specific field from a list :
-----------------------------------------
mapToInt()
mapToDouble()

	Integer sumation = users.stream().mapToInt(User::getSalary)
						.sum(); // Get Summation of Specific field

G) Java Streams | FlatMap & Optional :
--------------------------------------
	List<User> users = Arrays.asList(new User("Sudip", 25, Arrays.asList("1000", "2000", "3000")),
						new User("Prodip", 21, Arrays.asList("5000", "6000", "7000")),
						new User("Babul", 20, Arrays.asList("3000", "7000")),
						new User("Koushik", 32, Arrays.asList("8000", "5000", "3000")),
						new User("Susmita", 23, Arrays.asList("9000", "2000")));

	Optional<String> result = users.stream().map(u -> u.getMobileNos().stream())
						.flatMap(ml -> ml.filter(m -> m.equals("7000")))
						.findAny();

	result.ifPresent(System.out::println);

H) Java Streams | Usefull Methods :
-----------------------------------
.distinct()
.sorted()
.skip()

	List<String> names = Arrays.asList("Rahul", "Dipak", "Probir", "Pritam", 
						"Sunil", "Anil", "Rajib", "Tulsi", 
						"Sunil", "Hari", "Dipak", "Rajib");

	names.stream().distinct()
			.forEach(System.out::println);

	names.stream().distinct()
			.sorted()
			.forEach(System.out::println);	// Ascending Order

	names.stream().distinct()
			.sorted(Comparator.reverseOrder())
			.forEach(System.out::println);	// Descending Order	

	names.stream().skip(2)
			.filter(name -> name.length() > 5)
			.forEach(System.out::println);	// You can skip before/after Filtering
		
I) Read File and Replace String :
---------------------------------
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

J) Java Streams | Unuse Methods :
---------------------------------
.peek()

	List<String> result = Stream.of("One", "Two", "Three", "Four", "Five")
					.filter(s -> !s.equals("One"))														.peek(System.out::println)														.collect(Collectors.toList());
		
* Peek is used for internal Stream result. Peek don't interrupt you functional logic -> It's used for print log

