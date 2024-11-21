package scalerTest;

import java.util.List;

public class TestParallelExecution {
    public static void main(String[] args) {
//        Runnable task = new MyRunnableTask();
//        Thread t1 = new Thread(task);
//        Thread t2 = new Thread(task);
//        t1.start();
//        t2.start();
//
//        try{
//            t1.join();
//            t2.join();
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }
//        System.out.println("Final Counter: " + MyRunnableTask.counter);

        int x = 10;
        Runnable r = () -> System.out.println(x);
        Thread t3 = new Thread(r);
        t3.start();

        List<String> list = List.of("apple", "mango", "guava");
        list.stream()
                .map(String::toUpperCase)
                .distinct()
                .forEach(System.out::println);
    }
}
