package Threads;

//Runnable-> I want this class to be a task, so I implement Runnable
public class PrintNumber implements Runnable {
    int noToPrint;

    PrintNumber(int noToPrint) {
        this.noToPrint = noToPrint;
    }

    @Override
    public void run() {
        System.out.println("Print the number:" + noToPrint + " and print number in thread is " + Thread.currentThread().getName());
        //System.out.println("Printing number in thread:" + Thread.currentThread().getName());
    }

}
