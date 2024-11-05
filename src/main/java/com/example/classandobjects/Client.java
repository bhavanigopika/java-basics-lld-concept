package com.example.classandobjects;

//@SpringBootApplication
public class Client {

	public static void main(String[] args) {
		//SpringApplication.run(JavaBasicsApplication.class, args);
		Student s1 = new Student();
		//new Student() -> create an object of Student class and returns the object reference.
		//This object contains copy of all the attributes and present inside the class.

		s1.name = "Krish";
		s1.psp = 99.12;
		s1.univName = "Anna University";
		s1.attend_class();
		//we can change the batch_id also here.
		//default batch_id of student s1 here is 0 and I change the batch_id = 2;
		s1.change_batch(2);

		Student s2 = new Student();
		s2.name = "Ram";
		s2.psp = 80;
		s2.batch_id = 1;

		System.out.println(s1); //object reference
		System.out.println(s2); //object reference
		//till now, we have different object have unique values what I gave.
		//Now, I am pointing the s2 object reference to the s1 object reference.
		//So, I get same object reference and value for s2 which is same as s1
		s2 = s1;

		/*

		s1.age = 10;
		s1.name = "Krish";
//		s1.display();

//		Student s2 = s1;
//		s2.age = 20;
//		s2.name = "Ram";
//
//		s2.display();
//		s1.display();
//
//		s1.sayHello("Krish");
//		s2.sayHello("Ram");


//		Student s2 = new Student();
//		Student temp = s1;
//		s1 = s2;
//		s2 = temp;
//		s2.display();

		Student s2 = new Student();

		int tempAge = s1.age;
		s1.age = s2.age;
		s2.age = tempAge;

		s2.display();

		*/


	}

}
