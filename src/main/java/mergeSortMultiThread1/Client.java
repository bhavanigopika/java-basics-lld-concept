package mergeSortMultiThread1;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> ls = List.of(5,6,7,1,3,9,4,2);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //Create the task
        MergeSorter1 task = new MergeSorter1(ls, executorService);
        Future<List<Integer>> sortedListFuture = executorService.submit(task);

        List<Integer> sortedList = sortedListFuture.get();
        System.out.println(sortedList);

        executorService.shutdown();//shutdown the executorService, otherwise it's keep on running
    }
}
