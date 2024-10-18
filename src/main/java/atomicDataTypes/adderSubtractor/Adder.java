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
            //perming atomic integer
            count.value.addAndGet(i);
        }
    }
}
