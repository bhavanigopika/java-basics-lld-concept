package producerconsumerSemaphores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Store {
    //cloth store or store have shelf and item to keep on shelf.
    private int maxSize; //no. of shelf in the store --> 1 item we can keep in 1 shelf here...maxSize is fixed
    //private ArrayList<Integer> items;
    private ConcurrentLinkedDeque<Object> items; //list of items --> store have list of item

    Store(int maxSize) {
        this.maxSize = maxSize;
        //whoever create a store, will pass the items
        //ArrayList<Object> al = new ArrayList<>(); or List<Object> al = new ArrayList<>();
        this.items = new ConcurrentLinkedDeque<>();

    }
    public int getMaxSize() {

        return maxSize;
    }

    public ConcurrentLinkedDeque<Object> getItems() {

        return items;
    }
    //List is not a thread safe data structure
    //In multithreaded environment, we should always use thread-safe data structure or concurrent data structure to avoid inconsistent state

    public void addItem() {
        System.out.println("Producer production time, current size is: " + this.items.size());
        //System.out.println("add item: " + Thread.currentThread().getName());
        //producer adding item to the store
        this.items.add(new Object()); // 1 producer will be allowed to add 1 item(1 shelf = 1 item)
    }

    public void removeItem() {
        //3 threads are running the remove() method at the same time
        //but the actual list of size is 2(only 2 items are present to consume) --> [2,3]
        //first thread will remove 3, second thread will remove 2, last thread will remove what index? -1(because size is 0 and (this.item.size() -1) -> -1)
        System.out.println("Consumer consuming time, current size is: "  + this.items.size());
        //System.out.println("remove item: " + Thread.currentThread().getName());

        //consumer removing item on the store.
        //let us remove 1(last) item here.
        //this.items.remove(this.items.size() - 1);
        //since, we use concurrent data structure, we can use remove() with no parameters itself(remove item from the list
        this.items.remove();
    }

}


