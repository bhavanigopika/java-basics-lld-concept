package scalerGenericsTopics;

import ScalerGenerics.Pair;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Pair p1 = new Pair(1L, " Hello");//Long, String
        Pair p2 = new Pair(1.4, 1.5);//Double, Double
        Pair p3 = new Pair(false, 1L);//Boolean, Long

        List<Pair> pairs = List.of(p1, p2, p3);
        //Let's iterate  all pairs
     /*   for(Pair p: pairs){
            String first = (String) p.getFirst();//typecast to string but there is no compile time error
            String second = (String) p.getSecond();//typecast to string but there is no compile time error

            System.out.println(first + " " + second);//Error because long cannot be cast to String...Exception: Class Cast Exception
        }*/

        Pair1<Integer, String> p5 = new Pair1<>(1, "Hello");
        Pair1<Double, Double> p6 = new Pair1<>(1.4, 1.9);
        Pair1<Long, Boolean> p7 = new Pair1<>(1L, true);

        //Raw type - pari1
        Pair1 p4 = new Pair1(1,2);
        p4.getFirst();//see, this is returning object type internally and it used raw type
        p4.getSecond();//see, this is returning object type internally and it used raw type

        //Generic data type - pair1
        //List<Pair1> pairList = List.of(p5, p6, p7);//Each pair1 have different data types
        List<Pair1> pair1List = new ArrayList<>();
        pair1List.add(p5);
        pair1List.add(p6);
        pair1List.add(p7);

        Integer first = p5.getFirst();//compile time error...Earlier we have no compile time error

        Demo<Integer, String> demo1 = new Demo<>();
        demo1.doSomething(1, "Hello");

        System.out.println("*************************************************");

        Demo.<Long, Boolean>getValue(2L, true);

        System.out.println("*************************************************");

        String s = Demo.<String, Integer> getValue2("This is code", 4);
        System.out.println(s);

        System.out.println("*************************************************");

        Long lg = Demo.<Long, Boolean> getValue3(3L, false);
        System.out.println(lg);


    }
}
