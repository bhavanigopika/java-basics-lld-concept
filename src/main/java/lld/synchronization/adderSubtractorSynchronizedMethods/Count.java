package lld.synchronization.adderSubtractorSynchronizedMethods;

public class Count { //This is like third party service
    private int value = 0;

    public synchronized void incrementCount(int x) {
        this.value = this.value + x; //like count.value = count.value + i;
    }

    public int getValue(){
        return this.value;
    }
}
