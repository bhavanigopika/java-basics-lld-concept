package Threads1;

public class PrintNumber implements Runnable {
    int noToPrint;
    PrintNumber(int noToPrint) {
        this.noToPrint = noToPrint;
    }

    @Override
    public void run() {
        System.out.println(noToPrint + "current thread executing in " + Thread.currentThread().getName());
    }
}
