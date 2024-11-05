package polymorphism.compiletimepolymorphism;

public class Client {
    public static void main(String[] args) {
        //Think this:
        //compiler time polymorphism -> This is achieved through method overloading, operator overloading

        //method overloading - Below is method overloading, this means same method name, different parameter, don't worry of return type.

        Student s1 = new Student();
        s1.rollNo = 1;
        s1.name = "Ram";
        s1.univName = "Amritha University";

        s1.doSomething(5,"hello");
    }

}
