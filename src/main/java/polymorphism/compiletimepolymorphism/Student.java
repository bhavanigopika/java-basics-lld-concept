package polymorphism.compiletimepolymorphism;

public class Student {
    int rollNo;
    String name;
    String univName;

    //Think this:
    //compiler time polymorphism -> This is achieved through method overloading, operator overloading

    //method overloading - Below is method overloading, this means same method name, different parameter, don't worry of return type.

    void doSomething(int x){

    }
    void doSomething(String s){

    }
    void doSomething(String s, int x){

    }
    void doSomething(int x, String s){
        System.out.println("Enter the value here:" + x + " " + s);
    }
    String doSomething(int x, String s, String s1){

        return null;
    }

    int doSomething(int x, int y, String s, String s1 ){
        return 0;
    }
}
