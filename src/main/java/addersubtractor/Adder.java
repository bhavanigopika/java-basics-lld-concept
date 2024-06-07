package addersubtractor;

import java.util.concurrent.Callable;

//If the adder be a task, then implement here as Callabale where we have to return something...
// otherwise we use runnable
public class Adder implements Callable<Void> {
    //we have count reference
    private Count count;
    //whoever create the adder task, they have to pass the count reference
    Adder(Count count){
        this.count = count;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1; i <= 100; i++){
            //add the values to count
            //in count. java, we have declared value = 0...so  count.value = 0 initially
            count.value = count.value + i;
        }
        return null;
    }
}
