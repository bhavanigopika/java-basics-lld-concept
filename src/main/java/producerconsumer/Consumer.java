package producerconsumer;

public class Consumer implements Runnable {
    private Store store;

    Consumer(Store st) {
        this.store = st;
    }
    @Override
    public void run() {
        //Thread.currentThread().setName("Consumer");
        while(true) {
            //Here, sync issues  happened, what section of code happened? Critical Section
            //entire if condition is critical

            //e.g.,
            //100 threads/producers are here, current size is 10 and maxSize is 80
            //10 consumers are here and current size is 5...so I can add 5 consumers at the time
            //but because of synchronized, I can consume 1 item at the time...so, problem-consumer pblm where semphore will come into picture
            //Semaphore - multiple threads enter into critical section...still no sync issues has happened. see other package with example

            synchronized (store) {
                //only 1 of them will come here at a time
                //all 3 consumers have come at the same time but only 2 items are present...
                //so, all of them 3 consumers read current size as 2...hence 2 > 0 and all of them try to remove
                if (store.getItems().size() > 0) {
                    store.removeItem();
                }
                //System.out.println("**" + Thread.currentThread().getName() + "**");
            }
        }
    }
}
