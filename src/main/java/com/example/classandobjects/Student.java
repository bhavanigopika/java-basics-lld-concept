package com.example.classandobjects;


public class Student {
    //instance variables/attributes
    int rollNo;
    int age;
    String name;
    String univName;
    int batch_id;
    double psp;


    //methods/behaviours
    void attend_class(){
        System.out.println("Student is attending the class");
    }
    //if some student want to change the batch.
    //So, I will ask the new batch_id -> change_batch(int new_batch_id)
    //change the new_batch_id to previous batch_id as batch_id = new_batch_id

    void change_batch(int new_batch_id){
        batch_id = new_batch_id;
    }

    //student can pause the course
    void pause_course(){
        System.out.println("Student  is requesting for a pause");
    }
    void display(){
        System.out.println("My name is " + this.name + ". I am " + this.age + " years old");
    }
    void sayHello(String name){
        System.out.println(this.name + " says hello to " + name);
    }
}
