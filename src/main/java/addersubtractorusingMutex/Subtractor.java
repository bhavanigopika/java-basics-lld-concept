package addersubtractorusingMutex;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

//If the adder be a task, then implement here as Callabale where we have to return something...
// otherwise we use runnable
public class Subtractor implements Callable<Void> {
    //we have count reference
    private Count count;
    Lock lock;
    //whoever create the subtractor task, they have to pass the count reference
    Subtractor(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {
        for (int i = 1; i <= 10000; i++) {
            //subtract the values to count
            //in count. java, we have declared value = 0...so  count.value = 0 initially
            //since it is critical section of code, so we have to lock this.
            lock.lock();
            count.value = count.value - i;
            lock.unlock();
        }
        return null;
    }
}
