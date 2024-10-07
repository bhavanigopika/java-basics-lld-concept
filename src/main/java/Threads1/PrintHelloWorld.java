package Threads1;

public class PrintHelloWorld implements Runnable {//Here, we implements Runnable interface. We can extend no. of interfaces
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("This is hello world " + Thread.currentThread().getName());
    }
}
