package producerconsumerSemaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool();

        //max size of store is 5 here(at max, shelf is 5)
        Store st = new Store(5);

        //implement semaphore for producer and consumer
        //if no. of shelf we have given in Store is 5, so pass same in produce Semaphore
        Semaphore prodSemaphore = new Semaphore(5);
        Semaphore consSemaphore = new Semaphore(0);

        //created 8 producer/threads at a time....multiple threads occurring here
        for(int i = 1; i <= 8; i++){
            Producer task = new Producer(st, prodSemaphore, consSemaphore);
            //executor will create a thread for us. We execute the runnable command
            ex.execute(task);

            //or
            //ex.execute(new Producer(st, prodSemaphore, consSemaphore));
        }

        //created 20 consumer/threads at a time....multiple threads occurring here
        for(int i = 1; i <= 20; i++){

            Consumer task = new Consumer(st, prodSemaphore, consSemaphore);
            //executor will create a thread for us. We execute the runnable command
            ex.execute(task);

            //or
            //ex.execute(new Consumer(st, prodSemaphore, consSemaphore));
        }



    }
}
