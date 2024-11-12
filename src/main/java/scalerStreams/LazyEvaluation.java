package scalerStreams;

import java.util.List;

public class LazyEvaluation {
    public static void main(String[] args) {

        /*

        filter always take condition whether true or false. Then decides we can pick that element or not
        filter returns stream, and it is intermediate operation
        filter, map are intermediate operation
        forEach is terminal operation

        */
        //map...filter
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        numbers.stream()
                .map(n -> {
                    System.out.println("Doubling " + n);
                    return n * 2;
                })
                .filter(n -> {
                    System.out.println("Filtering " + n);
                    return n > 5;
                })
                .forEach(System.out::println);//this results as 6, 8, 10, 12

        //output:
        /*
        Doubling 1
        Filtering 2
        Doubling 2
        Filtering 4
        Doubling 3
        Filtering 6
        6
        Doubling 4
        Filtering 8
        8
        Doubling 5
        Filtering 10
        10
        Doubling 6
        Filtering 12
        12
         */

        System.out.println(" ");
        System.out.println("Order of map and filter reversed");
        System.out.println(" ");
        //filter...map
        List<Integer> numbers2 = List.of(1,2,3,4,5,6);
        numbers2.stream()

                .filter(n -> {
                    System.out.println("Filtering " + n);
                    return n > 5;
                })
                .map(n -> {
                    System.out.println("Doubling " + n);
                    return n * 2;
                })
                .forEach(System.out::println);//this results as 12
        /*
        output:
        Filtering 1
        Filtering 2
        Filtering 3
        Filtering 4
        Filtering 5
        Filtering 6
        Doubling 6
        12
        */

    }
}
