package lld.synchronization.producerConsumer;

import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<Object> store;
    private int maxSize;
    private String name;

    public Consumer(Queue<Object> store, int maxSize, String name) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {//keep on removing the shirt(object) until you can
            synchronized (store) {
                if(!store.isEmpty()) {//if(store.size() > 0)
                    System.out.println(this.name + " Removing an element: " + store.size());
                    store.remove();
                }
            }
        }
    }
}
