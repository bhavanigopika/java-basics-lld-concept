package scalerStreams;

import scalerCollections.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        //forEach in streams

        List<Integer> numbers = List.of(1,2,3,4,5);

        List<Integer> num = List.of(2,5,7,9,10);

        //normally this is how we traverse a list
        for(Integer i : numbers){
            System.out.println(i);
        }

        //Here using streams we have to traverse a list , then my data source here is my list
        //stream() function is represent in the list class...Collection is parent of list
        //So we see stream() function in collection class
        numbers.stream()
                .forEach(System.out::println);//1 2 3 4 5

        //or
        Stream stream = numbers.stream();
        stream.forEach(System.out::println);//1 2 3 4 5
        //The following line not works, because all items are  already processed in previous statement. It is not processed again because we are using the streams and this streams are already exhausted
        //stream.forEach(System.out::println);//exception -> IllegalStateException -> stream has already been operated upon or closed.

        System.out.println("*************************");

        num.stream().forEach((ele) -> System.out.println(ele));

        //Two type of operations we can do on streams
        //1. Terminal Operation - End
        //2. Intermediate Operation - inbetween

        //ForEach - it reaches the end, so it is terminal operation (i.e) ends the stream
        //ForEach - it consumes the stream and does an action with each and every element(e.g., printing the elements)

        System.out.println("*************************");

        num.parallelStream().forEach((ele) -> System.out.println(ele));

        System.out.println("*************************");

        //filter - intermediate operation  - followed by many operation we can do
        numbers.stream()
                .filter(ele -> ele % 2 == 0)
                .forEach(System.out::println);//2, 4

        System.out.println("*************************");

        List<Integer> numbers2 = List.of(7, 8, 10, 12, 15, 20);

        System.out.println("Try filtering numbers grater than 2 or odd numbers and print them using forEach");
        numbers2.stream()
                .filter(n -> n > 2 && n % 2 != 0)
                .forEach(System.out::println);//7, 15

        System.out.println("*************************");

        //map -> Transform each element
        numbers.stream()
                .map( n -> n * 2)
                .forEach(System.out::println);

        System.out.println("*************************");

        //Write a stream code to turn a list of words into uppercase
        List<String> words = List.of("apple", "banana", "cherry");
        System.out.println("Words in uppercase");
        words.stream()
                .map(String::toUpperCase) /* map(n -> n.toUpperCase()) */
                .forEach(System.out::println);

        System.out.println("*************************");

        List<Student> students = new ArrayList<>();
        students.addAll(List.of(new Student(1, 25, "Krish", 85),
                new Student(2, 30, "Vidhu", 90),
                new Student(3, 29, "Shekara", 99),
                new Student(4, 21, "Jack", 82)));

        students.stream()
                .filter(s -> s.getPsp() < 90)
                /*.forEach(System.out::println)*/
                .forEach(s -> System.out.println(s.getName()));

        System.out.println("*************************");

        //chaining the operations
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 3)
                .forEach(System.out::println);//2, 4 -> 2 * 3, 4 * 3 -> 6, 12


    }
}
