package polymorphism.runtimepolymorphism;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        B b = new B();
        b.doSomething("Krish"); //output: Inside B and I didn't use super() in B...otherwise, I get output as Inside A, Inside B
        // because super means call the immediate parent class method or immediate parent class instance variable or immediate parent class constructor.

        System.out.println("******************");

        A a = new A();
        a.doSomething("Abi"); //output: Inside A
        System.out.println("******************");

        //The below statement also run time polymorphism//

        //If I am using attributes of B via A, then compiler error comes,
        //here, I am calling the method of void doSomething which has overridden by B
        //and new B() --> new object is created at run time only...during run time only knows whose doSomething() going to call.
        A a2 = new B();
        a2.doSomething("Ram");//ouptut: Inside B
        //typecast
        //((B)a2).doSomething("Ram");
        System.out.println("******************");

        //Suppose we have list of A
        List<A> ls = new ArrayList<>();
        //object A,B,C has created during run time only
        ls.add(new A());//decided which doSomething() call during run time....So, A doSomething() -> A aa = new A();
        ls.add(new B());//decided which doSomething() call during run time....So, B doSomething() -> A aa = new B();
        ls.add(new C());//decided which doSomething() call during run time....So, C doSomething() -> A aa = new C();

        for(A aa : ls){
            aa.doSomething("hello");

            //use typecase because we have no doSomething in A...but here error comes...because however for A, it calls A object only.
            //((B)aa).doSomething("hello");
            //or ((C)aa).doSomething("hello");
        }
        System.out.println("******************");
    }
}
