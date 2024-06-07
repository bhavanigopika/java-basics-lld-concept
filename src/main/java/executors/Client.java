package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        //We didn't create 100 task to 100 threads here...That we saw already.
        //Threads executed by Executor Framework...This is part of jdk
        //we have CachedThreadPool which does not have parameter and FixedThreadPool which accepts parameter(number of threads(size))
        //Say, we give 10 threads....see below.

        // ExecutorService ex = Executors.newFixedThreadPool(10);
        ExecutorService ex = Executors.newCachedThreadPool();
        //ExecutorService ex1 = Executors.newFixedThreadPool(10);
        ExecutorService ex2 = Executors.newCachedThreadPool();

        //Let's print 1 to 100 and executor will create a thread
        for(int i = 1; i <=100; i++){
            //ex.execute(new Worker(i));

            PrintNumber t = new PrintNumber(i);
            //We are applying executor... executor will create a thread for use... we submit the task to executor
            ex.submit(t);
            //same thing work as like previous line ex.submit(t) --> print 1 to 100 in pool1 based on what thread method we have given and next line ex.submit(t) --> print 1 to 100 in pool1 based on what thread we have given
            ex.submit(t);
            //ex1.submit(t);
            ex2.submit(t);
        }
    }
}
