package atomicDataTypes.adderSubtractor;

public class Adder implements Runnable {
    private Count count;
    public Adder(Count count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i = 1; i <= 10000; i++){
            //count.value = count.value + i;
            //performing atomic integer - this itself internally do locks, concurrency and all
            count.value.addAndGet(i);
        }
    }
}
