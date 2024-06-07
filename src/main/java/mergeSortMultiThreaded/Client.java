package mergeSortMultiThreaded;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //we have to submit both of the task(task1 and task2) in Executor Service...So, use executor service in Client.java...It will better
        // Because, we don't want to create multiple executor service for each class...So, commonly created ExecutorService in Client.jav
        ExecutorService ex = Executors.newCachedThreadPool();


        List<Integer> ls = List.of(1, 4, 10, 9, 5, 12, 20, 15, 99, 67, 58, 21, 60, 25);
        Sorter t = new Sorter(ls, ex);
        //submit the task to executor service
        Future<List<Integer>> res = ex.submit(t);
        //get the futrue list of integer
        ls = res.get();
        System.out.println(ls);
    }
}
