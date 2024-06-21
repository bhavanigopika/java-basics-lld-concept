package producerconsumerSemaphores;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Store store;
    //consumer use both semaphores that is producer Semaphore, Consumer Semaphore
    private Semaphore prodSemaphore;
    private Semaphore consSemaphore;
    Consumer(Store st, Semaphore prodSemaphore, Semaphore consSemaphore) {
        this.store = st;
        this.prodSemaphore = prodSemaphore;
        this.consSemaphore = consSemaphore;
    }
    @Override
    public void run() {
        while(true) {
            //Here, sync issues  happened, what section of code happened? Critical Section
            //entire if condition is critical

            //e.g.,
            //100 threads/producers are here, current size is 10 and maxSize is 80
            //10 consumers are here and current size is 5...so I can add 5 5 consumers at the time
            //but because of synchronized, I can consume 1 item at the time...so, problem-consumer pblm where semphore will come into picture
            //Semaphore - multiple threads enter into critical section...still no sync issues has happened...
            try {
                consSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            store.removeItem();
            prodSemaphore.release();

//            consSemaphore.acquire();
//            store.removeItem();
//            prodSemaphore.release();
        }
    }
}
