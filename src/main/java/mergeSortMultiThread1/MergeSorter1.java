package mergeSortMultiThread1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSorter1 implements Callable<List<Integer>>{

    private List<Integer> arrayToSort;
    private ExecutorService executorService;

    MergeSorter1(List<Integer> arrayToSort, ExecutorService executorService){
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }
    @Override
    public List<Integer> call() throws Exception {
        //Base condition
        if(arrayToSort.size() <= 1){
            return arrayToSort;
        }

        //find the mid to divide the array
        int mid = arrayToSort.size() / 2;

        List<Integer> leftArray = new ArrayList<>();
        for(int i = 0; i < mid; i++){
            leftArray.add(arrayToSort.get(i));
        }
        List<Integer> rightArray = new ArrayList<>();
        for(int i = mid; i < arrayToSort.size(); i++){
            rightArray.add(arrayToSort.get(i));
        }

        /*
        Take the left part and sort on different thread - task1
        Take the right part and sort on different thread - task2
        */
        MergeSorter1 leftMergeSorter = new MergeSorter1(leftArray, executorService);
        MergeSorter1 rightMergeSorter = new MergeSorter1(rightArray, executorService);

        //create the executorService
        //ExecutorService executorService = Executors.newFixedThreadPool(10);

        //If doing on same thread
        /*List<Integer> leftSortedArrayList = leftSortedArray.call();
        List<Integer> rightSortedArrayList = rightSortedArray.call();*/

        //If doing on multithread
        /*expect to sort and return into future later
        In 44th line, we assigned 10 threads...Thread1 takes leftMergeSorter and Thread2 takes rightMergeSorter
        We don't create executor Service every time. We don't create thread pool everytime.
        So, use same executor service in client itself. Pass the executor service in constructor */

        Future<List<Integer>> leftSortedArrayFuture = executorService.submit(leftMergeSorter);
        Future<List<Integer>> rightSortedArrayFuture = executorService.submit(rightMergeSorter);

        //Merge the two sorted Array
        List<Integer> leftSortedArray = leftSortedArrayFuture.get();
        List<Integer> rightSortedArray = rightSortedArrayFuture.get();

        //add to the final sorted array
        List<Integer> finalSortedArray = new ArrayList<>();

        int i = 0, j = 0;
        while(i < leftSortedArray.size() && j < rightSortedArray.size()){
            if(leftSortedArray.get(i) < rightSortedArray.get(j)){
                finalSortedArray.add(leftSortedArray.get(i));
                i++;
            }else{
                finalSortedArray.add(rightSortedArray.get(j));
                j++;
            }
        }
        while(i < leftSortedArray.size()){
            finalSortedArray.add(leftSortedArray.get(i));
            i++;
        }
        while(j < rightSortedArray.size()){
            finalSortedArray.add(rightSortedArray.get(j));
            j++;
        }
        return finalSortedArray;
    }
}
