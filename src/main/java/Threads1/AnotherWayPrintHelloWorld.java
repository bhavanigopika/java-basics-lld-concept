package Threads1;

public class AnotherWayPrintHelloWorld extends Thread{//Here, class extend class. Actually we able to extend only 1 class
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Another way of hello world");
    }
}

/*Earlier:
    Step1: Create the task
    Step2: Submit the task in thread
    Step3: Start the thread
  Now:
    Directly extends Thread class and override run method.

    //Another way of implementing thread concept
    Thread t10 = new AnotherWayPrintHelloWorld();
    t10.start();
 */
