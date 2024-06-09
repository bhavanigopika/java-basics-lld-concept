package addersubtractorusingSynchronised;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

//If the adder be a task, then implement here as Callabale where we have to return something...
// otherwise we use runnable
public class Subtractor implements Callable<Void> {
    //we have count reference
    private Count count;
    //whoever create the subtractor task, they have to pass the count reference
    Subtractor(Count count) {
        this.count = count;

    }

    @Override
    public Void call() throws Exception {
        for (int i = 1; i <= 10000; i++) {
            //subtract the values to count
            //in count. java, we have declared value = 0...so  count.value = 0 initially
            //since it is critical section of code...use synchronized keyword
            //adder and subtractor working on the same share count object...count is object not attribute
            //In java, we have synchronized keyword, in which, pass the count object and wrap your critical section inside this
            synchronized (count) {
                count.value = count.value - i;
            }
        }
        return null;
    }
}
