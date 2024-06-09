package producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cient {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool();

        //max size of store is 5 here(at max, shelf is 5)
        Store st = new Store(5);

        //created 8 producer/threads at a time....multiple threads occurring here
        for(int i = 1; i <= 8; i++){
            Producer t = new Producer(st);
            //submitted all of them to the thread pool
            ex.submit(t);
        }

        ////created 20 consumer/threads at a time....multiple threads occurring here
        for(int i = 1; i <= 20; i++){
            Consumer t = new Consumer(st);
            //submitted all of them to the thread pool
            ex.submit(t);
        }



    }
}
