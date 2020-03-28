: How to work Java Stream API internally :

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
	
: Documentation : 
-----------------------------------------------------------------------------------------------------------------------------------

1)	What is Java Lambda Expression ?

=>	The expression through which we can represent an Anonymous function.

2)	What is Anonymous function ?

=>	A method who don't have any name or modifier.

	Anonymous : Nameless / Unknown

	Sysntex : Parameter Rxpression Body => () -> System.out.println("Lambda Sysntex !")

Example of Normal Method :

	public void example()	{
		System.out.println("Normal Method");
	}
	
Example of Anonymous Method :

	()	{
		System.out.println("Anonymous Method");
	}
	
3)	What is Functional Interface ?

=>	The function who contains only one abstarct method but can have multiple default and static method is called functional interface.

	Functional Interface define as @FunctionalInterface	<= But it's not mendatory.
	
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
		MyFunctionalInterface mfi = (n1, n2) -> n2 - n1;	//Implement method substruct & create reference variable
		
		System.out.println(mfi.substruct(12, 20));
	}
	
4) Java 8 - Consumer, Predicate, Supplier 

=> Consumer, Predicate, Supplier there are theree Functional Interfaces
--------------------------------------------------------------------------------------------
	Consumer : Whenever we need to a object as a inpunt and base on the input you do some operation and you dont return anything.
	--------------------------------------
	@FunctionalInterface
	public inferface Consumer
	{
		void accept(T t);
	}
	---------------------------------------
	Consumer consumer = t -> System.out.println("Data : "+t);
	consumer.accept(10);
	
			OR
			
	Ex : list.stream().forEach(t -> System.out.println("Marks : "+t));
---------------------------------------------------------------------------------------------	
	Predicate : This interface normaly we are used for conditional statement. when we check any condition and response as true/ false then we used that inferface.
	
	@FunctionalInterface
	public inferface Predicate
	{
		boolean test(T t);
	}
	
	Supplier : Here we are not input any thing but expected output.
	
	@FunctionalInterface
	public inferface Supplier
	{
		T get();
	}
	
4)	What is Java Stream API ?

=>	Java Stream API introduce in java 8, It is used to process collections of objects.

	A stream is not a data substruct instead it takes input from the Collections, Arrays or I/O channels.
	
	Stream don't change the original data substruct, they only provide the result as per the pipelined methods.

5) 	Why we need Stream API ?

=>	1) Functional Programming : i.e. We can achive FunctionalInterface with lambda.

	2) Code Reduce : We can reduce code length using lambda.
	
	3) Bulk Operation :	Compare to our triditional approch Stream give us better performance.
	
6)	Java Stream API's Methods :

=>	

A)	forEach :- For Iteration

	friends.stream().forEach(f -> System.out.println("Friend name : "+f));	//--Use Stream API : List Iteration--
	
	subjects.forEach((key, value)  -> System.out.println("Sub Code - Name : "+ key +" - "+value));	//--Traditional Way : Map Iteration--
	subjects.entrySet().stream().forEach(obj -> System.out.println("Sub Code - Name : "+obj.getKey()+" - "+obj.getValue())); //--Use Stream API : Map Iteration--

B)	Filter :- For Conditional Chek

	friends.stream().filter(f -> f.startsWith("R")).forEach(f -> System.out.println("Friend name : "+f));	//--Use Stream API : List Filter--
	
	List<String> filterList = friends.stream().filter(f -> f.startsWith("R")).collect(Collectors.toList());	//------Use Stream API : Store List of Filter data into another List-----
	
	str.startsWith("R");		=> String Class Method
	str.endsWith("b");
	
	subjects.entrySet().stream().filter(s -> s.getKey() <= 204).forEach(obj -> System.out.println("Common Sub Code - Name : "+obj.getKey()+" - "+obj.getValue())); //---Use Stream API : Map Filter---
	
C)	Sort :- For Sorting Order 

	Sort From Primitive ArrayList :
	
	Collections.sort(marks);	//---In Traditional Way => Sort on Ascending order
	marks.stream().sorted().forEach(m -> System.out.print(m+" "));	//---Using Stream API => Sort on Ascending order
	
	Collections.reverse(marks);	//---In Traditional Way => Sort on Descending order
	marks.stream().sorted(Comparator.reverseOrder()).forEach(m -> System.out.print(m+" "));	//---Using Stream API => Sort on Descending order
	
	Sort From Object ArrayList :
	
	Collections.sort(employees, (emp1, emp2) -> emp1.getSalary() - emp2.getSalary());	//---In Traditional Way => Sort List of Object base on one property salary <= Ascending order
	
	employees.stream().sorted((emp1, emp2) -> emp1.getSalary() - emp2.getSalary()).forEach(System.out::println);	// Using Stream API		<= For Descending Order (emp2 - emp1)**
	OR
	employees.stream().sorted(Comparator.comparing(emp -> emp.getSalary())).forEach(System.out::println);		// Using Java Stream - comparing function
	OR
	employees.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);	
	
D)	Sorting For Map :
	
	List<Entry<String, Integer>> entries = new ArrayList<>(numbers.entrySet());		//------Traditional Approach------		
	Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
	
	numbers.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);	//------Using Stream API------Sort By Key
	numbers.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);	//------Using Stream API------Sort By Value
	
	Sort of Map Objects :
	
	employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName))).forEach(System.out::println);	// Ascending Order
	employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName).reversed())).forEach(System.out::println);	// Descending Order
