package atomicDataTypes.adderSubtractor;

public class Subtractor implements Runnable {
    private Count count;
    public Subtractor(Count count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i = 1; i <= 10000; i++){
            //count.value = count.value - i;
            //use atomic integer - this itself internally do locks, concurrency and all
            count.value.addAndGet(-i);
        }
    }
}
