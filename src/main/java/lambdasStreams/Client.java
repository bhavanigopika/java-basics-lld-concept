package lambdasStreams;

import com.fasterxml.jackson.core.JsonToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) {
        /* we have seen 4 interfaces
        Callable, Runnable, Comparator, Comparable - Each of these interface, we have to implement 1 method respectively.

        Functional interface - The interfaces which demand one method to implement is called Functional interfaces.
        Lambdas – Lambdas are way to create the objects of classes who implement functional interface.

        () -> {} - syntax of a lambda expression in java
        (input to the function/method) -> {output from the method}
         */

        List<Student> ls = new ArrayList<Student>();
        ls.add(new Student("Humpy", 97.5, "Amritha"));
        ls.add(new Student("Kiwi", 88.6, "scaler"));
        ls.add(new Student("Rocky", 88.6, "delhi university"));

        /*
        I want to sort this student list
         */
        //As per what parameter, the list is going to be sort -> it will sort based on what we tell in student class
        //to compare(we use comparable) that will be natural ordering(ascending order)
        Collections.sort(ls);
        //If I want to sort based on student psp or combination of student psp and univName, then I will create the
        // new class and create the comparator(we use comparator)
        Collections.sort(ls, new StudentPSPComparator());
        Collections.sort(ls, new StudentPSPUnivNameComparator());
        //It is not good idea to create separate class for custom sorting…So no need to create a class and pass an object. We can do as, see below
        Collections.sort(ls, new Comparator<Student>() {
            @Override
            public int compare(Student student, Student o2) {
                // return (int)(student.psp-o2.psp); //if we want to sort it as psp as we did this same as in StudentPSPComparator class.
                return student.univName.compareTo(o2.univName);//if we want to sort it as univName
            }
        });

        //We can beautify the above code by Lambdas - Lambdas are just syntactical sugars
        //Collections.sort(ls, () -> {});
        Collections.sort(ls, (Student student, Student o2) -> {
            return student.univName.compareTo(o2.univName);
        });


        /*
        Let's use lambdas in runnable interface
        */

        //I want to print hello world using a thread
        PrintHelloWorld task1 = new PrintHelloWorld();
        Thread t1 = new Thread(task1);
        t1.start();

        //the above code implement in runnable interface which is having only one method so this is functional interface.
        // So, I will do the above code work in lambdas.
        //no input -> () ->  here, see run() method in PrintHelloWorld and output is sout in {}
        //Thread t2 = new Thread(() -> {});
        Thread t2 = new Thread(() -> {
            System.out.println("Hello World");
        });
        t2.start();

        //If it is 1 stmt in curly braces{}, then we can write it without curly braces {}
        Thread t3 = new Thread(() -> System.out.println("Hello World"));
        t3.start();//submit the task, then only we will get output.(CPU will take it)

        //Runnable is also functional interface, we can give lambda expression and implement a task as
        Runnable r = () -> {
            System.out.println("Hello World");
        };
        Thread tx = new Thread(r);
        tx.start();


        /* Problem on Arithmetic Operations
        Addition
        Subtraction
        Multiplication
        Division
         */

        //MathematicalOperations - It is functional interface here
        //MathematicalOperation additionOperation = ()->{;}  /*(input) -> {output}*/
        MathematicalOperation additionOperation = (int a, int b) -> {return a + b;};//we can give datatypes here
        // or MathematicalOperation additionOperation = (int a, int b) -> a + b;
        // or MathematicalOperation additionOperation = (a, b) -> {return a + b;};

        MathematicalOperation subtractionOperation = (int a, int b) -> {return a - b;};
        MathematicalOperation multiplicationOperation = (int a, int b) ->  a * b;
        MathematicalOperation divisionOperation = (int a, int b) -> {return a / b;};
        MathematicalOperation moduloOperation = (int a, int b) -> {return a % b;};

        //we can do as many mathematical operation we want using lambda expression if we have two inputs
        MathematicalOperation complexOperation = (int a, int b) -> {
            if(a < b){
                return a * b;
            }else if(b < a){
                return a - b;
            }else{
                return a / b;
            }
        };

        //let's use any of the above operation
        System.out.println(additionOperation.operate(2,4));
        System.out.println(subtractionOperation.operate(5,6));
        System.out.println(multiplicationOperation.operate(7,45));
        divisionOperation.operate(24,12); //if you want to print, use System.out.println(...) like above line
        moduloOperation.operate(12,5); //if you want to print, use System.out.println(...) like above line

        System.out.println(complexOperation.operate(9,3));

        //we can create the task unique, so create a seperate class
        //public class Addition implements MathematicalOperation{...}
        Addition op = new Addition();
        System.out.println(op.operate(12,3));

        /*
        Lambdas are going to help create objects of classes which implement functional interfaces
        This is also about Lambdas
         */

        /*
        Streams - like a pipeline
        Data entering at one end and leaving at one end
        Data(pipeline attached to some data source)
        Let's print 1000 rows
        for(int i = 1; i <= 1000; i++){
	        if(i == 500th){
	            ....
            }
        }
        Here, we won’t care about previous 500th row…Looking ahead…
        Streams will affect / improve performance on a positive side
        Usage of stream: Stream uses very complex tree like data structures which makes stream smart enough to optimize things.
         */

        List<Integer> lst = List.of(2,5,3,10,8,9,1); //This is data source(Anything which has data is datasource)
        //Attach pipeline(stream) to the list datasource
        Stream<Integer> stm = lst.stream();//my stream in integer...
        //We can create as many streams as I want with the same data source(lst)
        Stream<Integer> stm2 = lst.stream();
        Stream<Integer> stm3 = lst.stream();

        /*
        stm is nothing but like a pipeline attached to the list.
        It is actually a stream reference
         */
        System.out.println(stm); //output: java.util.stream.ReferencePipeline$Head@26a1ab54

        /*
        How can we access the stream. There are some methods by which you can read data from the stream
        2 types of methods:
        Intermediate methods - methods which returns stream reference
        Terminal methods - methods which returns the data. Once used terminal methods at last, all stream get closed after this.
         */

        System.out.println(stm.limit(3).count());//terminal method - limit upto 3 integer (2,5,3)-> count is 3
        //System.out.println(stm2.count());//terminal method - returns the data - total elements of list of integer
        System.out.println(stm3.limit(3)); //intermediate method -  limit upto 3 integer (2,5,3) -> return stream reference, output: java.util.stream.SliceOps$1@306a30c7

        //System.out.println(stm.count());//Error
        //System.out.println(stm3.limit(4));//Error

        /*
        You can have as many methods as you want on top of stream
         */

        /*
        Let's use stream2(stm2)-> so I comment 165th line
        forEach - one of the stream methods and have to iterate over the stream
        For each element, I am going to print it, so we use lambda expression
        */
        for(int i = 0; i < lst.size(); i++){
            System.out.print(lst.get(i) + " ");/* 2 5 3 10 8 9 1 */
        }
        System.out.println();

        //elem is lst.get(i)
        stm2.forEach((elem) -> {
            System.out.print(elem + " "); /* 2 5 3 10 8 9 1 */
        });
        System.out.println();
        //once used stm2, this stream has closed
        //System.out.println(stm2.count());//Error: Exception in thread, stream has already been operated upon or closed
        
        /*
        Let's see
        map(), filter(), sorted() -> few intermediate operations
        collect(), forEach(), reduce() -> few terminal operations
         */

        /*
        we know that, every stream gets closed after it is operated upon,
        so, instead of creating the stream and performing the methods, directly create stream that is
        lst.stream().filter.....instead of stm2.filter....
        */

        /*
        filter -> filter out some elements from list
        every element is iterated, and for every element I am going to filter even number in the list. Here,we do lambda expression () -> {}
        after filter, I am going to collect all the elements in Collectors.list
        now, I am going to return this in List<Integer>
        */
        List<Integer> res = lst.stream()
                                .filter( (elem) ->  elem % 2 == 0)/*  .filter( (elem) -> {return elem % 2 == 0;}) */
                                .collect(Collectors.toList());

        System.out.println(res);

        /*
        map
        Here, I am going to map -> one element to square of element
        Also, I am going to sort that element
         */
        List<Integer> res2 = lst.stream()
                                .filter( (elem) -> elem % 2 == 0)
                                .map((elem) ->  elem * elem )/*.map((elem) -> {return elem * elem;} )*/
                                .sorted()
                                .collect(Collectors.toList());
        System.out.println(res2);//once terminal operated, streams gets closed

        /*
        If I want to sort in descending order, use lambda expression here
         */

        List<Integer> res3 = lst.stream()
                                .filter((elem) -> elem % 2 == 0)
                                .map((elem) -> elem * elem)
                                .sorted((x,y) -> y - x) /* .sorted((x,y) -> {return y - x;}) */
                                .collect(Collectors.toList());
        System.out.println(res3);

        /*
        The above condition is similar to number of for loop we can use to get answer that is
        for loop to filter even elements - store in a list
        for loop to map each of them to their squares - store in list
        sorting logic to store
        So, the importance of streams is useful.
         */

        /*
        Let's see about findFirst(), reduce
         */
        /*
        Instead of collect all the list, I am going to select the first element so, do findFirst()
        But, here datatype is Integer
         */
        //Say, in the list - [3,5,7,9] - no even elements in the list so after filter, no even number, we cannot map, sort...so, to avoid error...
        // so, we say this is not list of integer (List<Integer>) and this is optional of integer (Optional<Integer>)
        Optional<Integer> res4 = lst.stream()
                                .filter((elem) -> elem % 2 == 0)
                                .map((elem) -> elem * elem)
                                .sorted((x, y) -> y - x)
                                .findFirst();
        System.out.println(res4); //optional[100] -> 100 is first element in the list
        //since it is optional, we should mention with if-else condition
        if(res4.isPresent()){
            System.out.println("Here's the filtered first final element " + res4.get());//.get() -> extract the integer only
        }else{
            System.out.println("Nothing is left");
        }

        /*
        reduce method
        Say, have to sum up all elements of a list
         */
        //Method 1:
        Integer ans = 0;
        for(int i = 0; i < lst.size(); i++){
            ans = ans + lst.get(i);
        }
        System.out.println(ans);// 38
        System.out.println(lst);// [2,5,3,10,8,9,1]

        /*
        No matter how many pipelines are attach to the datasource(here, datasource is list of data in List<Integer>)
        So, streams does not affect the actual data source.
         */

        /*
        Method 2:
            using stream -> reduce method-> reduce  means group of all elements into one element
            reduce take two params 1) initial value(i.e) (0) , 2) lambda expression(i.e) (a,b) -> a + b
            here, not list<Integer> only use Integer because we have return one integer value.
        */
        Integer res5 = lst.stream().reduce(0, (a, b) -> a + b); /*lst.stream().reduce(0, (a, b) -> {return a + b;});*/
        System.out.println(res5);// 38

        //we can reduce -> one of terminal method and after number of intermediate method.
        Integer res6 = lst.stream()
                            .filter((elem) -> elem % 2 != 0)
                            .map((elem) -> elem * elem * elem)
                            .reduce(0, (a,b) -> a + b);
        System.out.println(res6); // odd ele = 5,3,9,1 -> 125 + 27 + 729 + 1 = 882

        /*
        I want to find minimum from the final output
         */
        //Method 1:
        Integer finalres = Integer.MAX_VALUE;
        for(Integer i: lst){
            finalres = Math.min(i, finalres);
        }
        //Method 2: achieve it via lambda and stream
        //reduce it to one value, first take initial value(i.e) (Integer.MAX_VALUE) and second, lambda expression(i.e) (a,b) -> Math.min(a,b)
        Integer res7 = lst.stream()
                            .filter((elem) -> elem % 2 == 0)
                            .map((elem) -> elem * elem)
                            .sorted((x, y) -> y - x)
                            .reduce(Integer.MAX_VALUE, (a,b) -> Math.min(a,b));
        System.out.println(res7); //even ele among list(2,5,3,10,8,9,1) is 2,10,8 -> map: 4, 100, 64 -> sorted: 4,64,100 -> min: 4
      /*
      Does the order of applying the stream methods matter? YES. The order will definitely affect the performance because the output of current stream method will become input of the next method
      .sorted depend on .map and .map depend on filter…
       */

    }
}
