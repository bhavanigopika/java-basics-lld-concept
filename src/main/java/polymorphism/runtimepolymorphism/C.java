package polymorphism.runtimepolymorphism;

public class C extends B {
    void doSomething(String x) {
        System.out.println("Inside C");
    }
    //Think this:
    //run time polymorphism -> This is achieved through method overriding

    //method overriding - same method name, same parameter, same return type as declared in the parent class
}
