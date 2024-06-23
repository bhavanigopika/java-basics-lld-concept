package generics;

import polymorphism.runtimepolymorphism.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        //no inbuilt pair (object datatype) in java.util package.....javafx.util.pair is something different
        //hence we have to declare a pair.
        Pair p1 = new Pair();
        /*
        Used this type of datatype till Java5...(i.e) we didn't mention any data type here as Pair<int, string> p1 = new Pair();
        This is called Raw Types.
        By default, if we don't pass the data type, it can take any value (i.e) it will be of Object data type(any object data type)
        */
        p1.first = "ABC";
        p1.second = 87893;

        //The  following code also acceptable ...This is also Raw type (i.e) we can put any data type.
        HashMap hm = new HashMap();
        hm.put("hanu", "man"); //string, string
        hm.put(12, 90.4); // int, double
        hm.put("krish", 87); //string, int

        //The above things are use at older version of java...now, defining with data type.
        //To safeguard the previous version of java (i.e) Backward compatability - older things should not break
        //The above things can be used but for the current java version, we have used enhanced version of declaring data type explicitly (i.e)
        HashMap<Integer, String> hm2 = new HashMap(); //mentioning the object data type here explicitly
        hm2.put(15, "hello");
        hm2.put(123, "welcome");



        //Now, using generics - parameterized data type
        Pair<Integer, String> p2 = new Pair<>();
        //or, we can use the below line but the following line looks redundant...so we use the above line generally...
        //Pair<Integer, String> p2 = new Pair<Integer, String>();

        //Pair<Integer, String, Float, Integer, String> p2 = new Pair<Integer, String, Float, Integer, String>();

        //pass the value
        p2.first = 78;//It is accepting only integer since we gave as Pair<Integer, String>
        p2.second = "Krish";//It is accepting only integer since we gave as Pair<Integer, String>

        //use generics in method
        // we can't do int x = p2.second...since, we use the return type as String...Is it applying a compile time check? YES
        String res = p2.second;
        //int res1 = Integer.parseInt(p2.second);(since it is String, so we can wrap it by Integer.parseInt)

        /*
        Generics - at compile time, it will apply data type check
        */

        Pair<Integer, Integer> p11 = new Pair<>();
        Pair<Integer, String> p12 = new Pair<>();
        Pair<Integer, Long> p13 = new Pair<>();
        Pair<Integer, Double> p14 = new Pair<>();
        //So, V is different for each data object


        //call doSomethingStatic without creating the object...
        //So, static methods cannot use class level generics data type...To call these methods, we don't need a object
        //and because of which we will not be able to know the respective data type you are referring...

        //So, we create method level generics and apply generic data types.
        //To accept any datatypes, give as
        Pair.doSomethingStatic(23, "Krish");
        Pair.doSomethingStatic("anything", 89.0);
        //To declare particular data types
        Pair.<String, Integer>doSomethingStatic("Hanuman", 99);


        //call doSomethingNonStatic by creating the object...
        //So, non-static methods use class level generics data type...To call these methods, we need a object
        //and because of which we will be able to know the respective data type you are referring...
        //p11.doSomethingNonStatic("Bhavani"); //Error: since p11 is <Integer> not <Static>
        p12.doSomethingNonStatic("Krish");//This accepts, because p12 having <String> also

        //let's return as string and if we want to return as Integer, then we can do it...<Arun> generic doesn't have own data type.
        String res2 = p13.doSomethingForLearning("Anything");
        Integer res3 = p13.doSomethingForLearning(80);
        Long res4 = p13.doSomethingForLearning(972L);

        //explicitly we are telling to pass this datatype in non static...
        p13.<Integer>doSomethingForLearning(565);
        //To wrap string by integer
        p13.<Integer>doSomethingForLearning(Integer.valueOf("Myself"));

        /*
        Inheritance and Generics
         */

        //call here
        Utils.simpleDoSomething(new Animal());//accept animal definitely
        Utils.simpleDoSomething(new Dog());//dog, cat...since it is a child of animal and animal can hold the value of its children types
        Utils.simpleDoSomething(new Cat());//dog, cat...since it is a child of animal and also accept object of cat.

        //can we pass list of dog, list of cat here
        List<Dog> dogs = new ArrayList<>();
        //add some dogs in this list
        dogs.add(new Dog());
        dogs.add(new Dog());
        dogs.add(new Dog());

        //we have list of cat
        List<Cat> cats = new ArrayList<>();
        //add some cats in this list
        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());

        //can we pass list of dogs in doSomething method
//        Utils.doSomething(dogs);
//        Utils.doSomething(cats);
        /*
        we cannot store List<Dog> or List<Cat> in List<Animal> -> Not allowed
        But we can store only Dog or only cat in Animal, not list of dog List<Dog>, not list of cat List<Cat>
         */

        //list of animals are allowed
        List<Animal> animals = new ArrayList<>();
        Utils.doSomething(animals);

        Utils.doSomething(dogs);
        Utils.doSomething(cats);

        //name attribute copied to this children class that is dog and cat.
        Utils.printAnimalNames(animals);
        Utils.printAnimalNames(dogs);
        Utils.printAnimalNames(cats);

        //we can pass List<Dog> in doSomething2? YES
        Utils.doSomething2(animals);
        Utils.doSomething2(dogs);
        Utils.doSomething2(cats);

    }
}
