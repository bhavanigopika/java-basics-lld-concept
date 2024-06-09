package adderSubtractorSyncMethods;

import java.util.concurrent.Callable;

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
        for (int i = 1; i <= 100; i++) {
            //subtract the values to count
            //in count. java, we have declared value = 0...so  count.value = 0 initially
            //this is critical section count.value -= i; ->  subtract the value to count
            //count.value = count.value - i;
            count.decreamentByX(i);
        }
        return null;
    }
}
