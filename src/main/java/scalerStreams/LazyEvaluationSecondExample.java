package scalerStreams;

import java.util.ArrayList;
import java.util.List;

public class LazyEvaluationSecondExample {
    public static void main(String[] args) {
        //We want to understand the effect of lazy evaluation on performance

        List<Integer> largeNumbers = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            largeNumbers.add(i);
        }

        largeNumbers.stream()
                .filter(n -> {
                    return n % 2 == 0;
                })
                .forEach(System.out::println);//printed 1...100

        System.out.println("********************************************");

        //Lazy Evaluation:
        //limit - intermediate operation - return stream...like to limit first 5 stream (so, limit take maxSize)
        largeNumbers.stream()
                //this filter process only first 5 even elements
                .filter(n -> {
                    try {
                        System.out.println(n);
                        Thread.sleep(50);//simulated the delay in between...thread will sleep fo 50 ms. So, simulating an expensive operation
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return n % 2 == 0;
                })
                .limit(5)//limit the first 5 numbers, here we filter out even numbers...so, limit the first 5 even numbers
                .forEach(System.out::println);//first 5 which are even numbers we want...2, 4, 6, 8, 10

        //if there is no lazy evaluation in stream, all 100 elements are going to filter taking significantly more time
        //Here, we have used lazy evaluation -> so processed only 5 element based on 30the line and then 38the line

        //output:
        /*
        1
        2
        2
        3
        4
        4
        5
        6
        6
        7
        8
        8
        9
        10
        10
         */


    }
}
