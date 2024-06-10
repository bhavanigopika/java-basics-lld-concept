package producerconsumer;

public class Producer implements Runnable {
    private Store store;

    Producer(Store st){
        this.store = st;
    }

    @Override
    public void run() {
        while(true) {
            //Here, sync issues  happened, what section of code happened? Critical Section
            //entire if condition is critical...apply synchronized here

            synchronized(store) {
                //e.g.,
                //100 threads/producers are here, current size(current number of items) is 10 and maxSize is 80
                //so, 70 producers can produce the item, so they are elgibile to add item
                //at max, actually add 1 item at a time...at the same time, all 70 producers can enter and produce the item since we have balance 70 item to produce
                //but as per synchronized, I can add 1 item (i.e) 1 item can produce at the time.....so speed is low
                //we can solve it by semaphore -- where multiple threads enter into critical section...still no sync issues has happened....see other package with example

                if (store.getItems().size() < store.getMaxSize()) {
                    store.addItem();
                }
            }
            //System.out.println("***" + Thread.currentThread().getName() + "***");
        }
    }
}
