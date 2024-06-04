package Threads;

public class PrintHelloWorld implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello World...");
        System.out.println("Printing hello world in thread and the thread name is " + Thread.currentThread().getName());
    }
}
