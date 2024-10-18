package semaphore.producerConsumer;

import java.util.Queue;

public class Producer implements Runnable {
    private Queue<Object> store;
    private int maxSize;
    private String name;

    public Producer(Queue<Object> store, int maxSize, String name) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        while(true){//keep on adding the shirt(object) until you can
            synchronized(store){
                if(store.size() < maxSize) {
                    System.out.println(this.name + " Adding an element: " + store.size());
                    store.add(new Object());//store.add(new Shirt())
                }
            }
        }
    }
}
