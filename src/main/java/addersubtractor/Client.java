package addersubtractor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //create the count reference
        Count count = new Count();
        //we have Executor Service
        ExecutorService ex = Executors.newCachedThreadPool();

        //we have to add the task
        //pass the count reference, because we have to work on the same data
        Adder task1 = new Adder(count);
        Subtractor task2 = new Subtractor(count);

        //submit the task1, task2 in ExecutorService
        //ofcourse, the task will not immediately, we have to work on them
        //so, use Future
        Future<Void> res1 = ex.submit(task1);
        Future<Void> res2 = ex.submit(task2);
        //wait for the task to complete and add exception aslo
        res1.get();
        res2.get();

        //we get the values from count
        System.out.println(count.value);
    }


}
