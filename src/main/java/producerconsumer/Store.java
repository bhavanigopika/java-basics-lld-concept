package producerconsumer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Store {
    //cloth store or store have shelf and item to keep on shelf.
    private int maxSize; //no. of shelf in the store --> 1 item we can keep in 1 shelf here...maxSize is fixed
    //private ArrayList<Integer> items;
    private List<Object> items; //list of items --> store have list of item

    Store(int maxSize) {
        this.maxSize = maxSize;
        //whoever create a store, will pass the items
        //ArrayList<Object> al = new ArrayList<>(); or List<Object> al = new ArrayList<>();
        this.items = new ArrayList<>();

    }
    public int getMaxSize() {
        return maxSize;
    }

    public List<Object> getItems() {
        return items;
    }

    public void addItem() {
        System.out.println("Producer production time, current size before production time is: " + this.items.size());
        //System.out.println("add item: " + Thread.currentThread().getName());
        //producer adding item to the store
        this.items.add(new Object());// 1 producer will be allowed to add 1 item(1 shelf = 1 item)
        System.out.println("Producer production time, current size after production time is: " + this.items.size());
    }

    public void removeItem() {
        //3 threads are running the remove() method at the same time
        //but the actual list of size is 2(only 2 items are present to consume) --> [2,3]
        //first thread will remove 3, second thread will remove 2, last thread will remove what index? -1(because size is 0 and (this.item.size() -1) -> -1)
        System.out.println("Consumer consuming time, current size before consumption time is: "  + this.items.size());
        //System.out.println("remove item: " + Thread.currentThread().getName());

        //consumer removing item on the store.
        //let us remove 1(last) item here.
        this.items.remove(this.items.size() - 1);
        System.out.println("Consumer consuming time, current size after consumption time is: "  + this.items.size());
    }

}


