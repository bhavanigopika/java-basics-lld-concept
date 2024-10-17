package mergeSortMultiThreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

//let's create sorter task that is using class sorter
//I have to tell the callable that I have to return the list of Integer
public class Sorter implements Callable<List<Integer>> {

    //sort the list of array which is Integer
    List<Integer> arrayToSort;
    ExecutorService ex;

    //Constructor says that whatever list of integer you want to sort, accept it into the constructor
    //so, whoever create the class Sorter/task, will give the array
    Sorter(List<Integer> arrayToSort, ExecutorService ex) {
        this.arrayToSort = arrayToSort;
        this.ex = ex;
    }

    //In call method, we should return definitely a return type...and we have call() method here
    @Override
    public List<Integer> call() throws Exception {
        //we have to write the entire merge sort code

        //Base condtion:
        //if array size is <= 1 or after dividing into no of sub-problem where array size is <=1...no need to divide further then
        if(arrayToSort.size() <= 1){
            return arrayToSort;
        }
        //else, we have to find the mid of the array to divide
        int mid = arrayToSort.size() / 2;

        //Divide the array into two halves
        /*First half = 0 to mid-1
        second half = mid to ar.size()-1;
         */
        List<Integer> leftHalf = new ArrayList<>();
        for(int i = 0; i < mid; i++){
            leftHalf.add(arrayToSort.get(i));
        }

        List<Integer> rightHalf = new ArrayList<>();
        for(int i = mid; i < arrayToSort.size(); i++){
            rightHalf.add(arrayToSort.get(i));

        }

        //Now, we have to sort both of them (leftHalf array and rightHalf array), but we already have task/class who accept the array and sorted for us.
        //see below, which we represent above.
        /*
            Sorter(List<Integer> arrayToSort) {
                this.arrayToSort = arrayToSort;
            }
         */
        //here, create two task, one for sorting leftHalf and one for sorting rightHalf......
        //and divided array will do recursion also. In DSA, we do recursive merge function for left[] and right[]...here,we are doing sorter task for leftHalf and rightHalf
        //that is make a call to the same call() method ---> calling the Sorter task and this will execute the call method here
        //The Sorter task code are inside the call() method.
        Sorter task1 = new Sorter(leftHalf, ex);//pass left array
        Sorter task2 = new Sorter(rightHalf, ex);//pass right array

        //we have to submit both of the task(task1 and task2) in Executor Service...So, use executor service in Client.java...It will better
        // Because, we don't want to create multiple executor service for each class...So, commonly created ExecutorService in Client.java

        //submit the task1 and task2 to ExecuteService ex or thread
        Future<List<Integer>> leftSortedArray = ex.submit(task1);
        Future<List<Integer>> rightSortedArrray = ex.submit(task2);
        //.get() --> waiting for the thread to complete and get the sorted array
        //update in leftHalf and rightHalf
        leftHalf = leftSortedArray.get();
        rightHalf = rightSortedArrray.get();

        //As of now, we sorted both left and right, now we have to merge both the leftSortedArray and rightSortedArray
        List<Integer> finalMergedArray = new ArrayList<>();

        //use two pointer technique
        int i = 0, j = 0;
        while(i < leftHalf.size() && j < rightHalf.size()){
            if(leftHalf.get(i) < rightHalf.get(j)){
                finalMergedArray.add(leftHalf.get(i));
                i++;
            }else{
                finalMergedArray.add(rightHalf.get(j));
                j++;
            }
        }
        //balanced in leftHalf and in rightHalf array
        while(i < leftHalf.size()){
            finalMergedArray.add(leftHalf.get(i));
            i++;
        }
        while(j < rightHalf.size()){
            finalMergedArray.add(rightHalf.get(j));
            j++;
        }
        //finally mergedArray is sorted.
        return finalMergedArray;
        //return null;
    }
}
