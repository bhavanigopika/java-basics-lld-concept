package executors;

public class PrintNumber implements Runnable {
    int noToPrint;
    PrintNumber(int noToPrint) {
        this.noToPrint = noToPrint;
    }
    @Override
    public void run(){
        System.out.println("Print the number:" + noToPrint + " and print number in thread is " + Thread.currentThread().getName());
    }
}
