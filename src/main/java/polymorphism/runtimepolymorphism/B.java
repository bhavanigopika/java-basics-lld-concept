package polymorphism.runtimepolymorphism;

public class B extends A{
    //@Override
    void doSomething(String x) {
        //When we run the application, we get only "inside B", if we use super function, see below stmt...we get output as Inside A, Inside B
        //super.doSomething(x);
        System.out.println("Inside B");
    }
}
