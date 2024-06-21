package generics;

public class Pair<T, V> {
    T first;
    V second;


    void setFirst(T x){
        first = x;
    }

    //say, I want to return second value
    V getSecond(){
        return second ;
    }

    //call doSomethingStatic without creating the object...
    //So, static methods cannot use class level generics...hence we use method level generics
    public static<A,B> void doSomethingStatic(A a, B b){

    }
    public void doSomethingNonStatic(V x){

    }

    //we can use class level generics in non static method also...Non-static methods also have own generics.
    //Here,class level generics we can give <A>, <B>, <T> <V> <P> <Q> <Arun> <Hanumna> as our wish...and return type is Arun
    public <Arun> Arun doSomethingForLearning(Arun p1){
        return p1;
    }
    //Here, class level generics we can give as <Kiwi> and let's give no return type.
    public <Kiwi> void doSomething2(Kiwi p2){
        return;
    }
}
