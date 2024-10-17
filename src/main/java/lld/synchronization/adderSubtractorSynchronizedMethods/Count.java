package lld.synchronization.adderSubtractorSynchronizedMethods;

public class Count {
    //This is like third party service(application). This third party service will handle the synchronized part.
    // So, apply synchronized method in increamentCount function only because this was the critical section code.
    //Aslo, in adder and subtractor...I've used count.incrementCount(this was the critical section code)
    private int value = 0;

    public synchronized void incrementCount(int x) {
        this.value = this.value + x; //like count.value = count.value + i;
    }

    public int getValue(){
        return this.value;
    }
}
