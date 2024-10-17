package lld.synchronization.adderSubtractorMutex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Lock lock = new ReentrantLock();

        Adder task1 = new Adder(count, lock);
        Subtractor task2 = new Subtractor(count, lock);

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        //The following code will waits for thread t1 and t2 to finish execution
        t1.join();
        t2.join();

        System.out.println(count.value);
    }
}
