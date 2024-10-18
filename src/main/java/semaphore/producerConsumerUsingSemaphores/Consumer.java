package semaphore.producerConsumerUsingSemaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Queue<Object> store;
    private int maxSize;
    private String name;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public Consumer(Queue<Object> store, int maxSize, String name, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while (true) {//keep on removing the shirt(object) until you can
            try {
                consumerSemaphore.acquire();//consumerSemaphore take a lock
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.name + " Removing an element: " + store.size());
            store.remove();
            producerSemaphore.release();
        }
    }
}
