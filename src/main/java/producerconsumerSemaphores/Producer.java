package producerconsumerSemaphores;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Store store;
    private Semaphore prodSemaphore;
    private Semaphore consSemaphore;

    Producer(Store st, Semaphore prodSemaphore, Semaphore consSemaphore){
        this.store = st;
        this.prodSemaphore = prodSemaphore;
        this.consSemaphore = consSemaphore;

    }

    @Override
    public void run() {
        while(true) {
            //Here, sync issues  happened, what section of code happened? Critical Section
            //entire if condition is critical section...apply synchronized here


                //e.g.,
                //100 threads/producers are here, current size(current number of items) is 10 and maxSize is 80
                //so, 70 producers can produce the item, so they are elgibile to add item
                //but as per synchronized, I can add 1 item (i.e) 1 item can produce at the time.....so speed is low
                //we can solve it by semaphore -- where multiple threads enter into critical section...still no sync issues has happened....

            try {
                prodSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            store.addItem();
            consSemaphore.release();

            //prodSemaphore.acquire();
            //store.addItem();
            //consSemaphore.release();

        }
    }
}
