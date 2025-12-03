package doubtSolving;
/*
Write a simple multithreaded program to print 1 - 100 such that even thread
will point even numbers and odd thread will print odd numbers but 1 - 100 will be in sequence.

E.g., Let's print from 1-10. Hence, have to do as
1 by Odd(Thread 1)
2 by Even(Thread 2)
3 by Odd(Thread 1)
4 by Even(Thread2)
5 by Odd(Thread 1)
6 by Even(Thread 2)
7 by Odd(Thread 1)
8 by Even(Thread 2)
9 by Odd(Thread 1)
10 by Even(Thread 2)

Split the problem into 2 sub-problem ->
Problem 1: Print out the number in sequence with the help of multi threading
Problem 2: Print out odd number by odd thread and even number by even thread */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SequencePrinterAnotherQuestion {

     public static void main(String[] args) {

        PrintTask evenTask = new PrintTask(0);
        Thread t1 = new Thread(evenTask, "Even Thread");//Pass the thread name as Even Thread instead of Thread-0
        t1.start();

        PrintTask oddTask = new PrintTask(1);
        Thread t2 = new Thread(oddTask, "Odd Thread");//Pass the thread name as Odd Thread instead of Thread-0
        t2.start();

     }
}

// Problem 1: Print out the number in sequence with the help of multi threading
class PrintTask1 implements Runnable {
    int counter = 1;
    public void printer(){
        //System.out.println(counter);//1 continuously print
        //System.out.println(counter++);//continuously increment the value and print
        System.out.println(Thread.currentThread().getName() + " " + counter++);//continuously increment the value and print
    }
    @Override
    public void run() {
        /*while(true){
            printer();
        }*/
        for(int i = 1; i <= 10; i++){
            printer();
        }
    }
}

//Problem 1: Print out the number in sequence with the help of multi threading
//Problem 2: Print out odd number by odd thread and even number by even thread

class PrintTask implements Runnable {
    static int counter = 1;// to make it sequential(counter value from 1 to 20 for two threads continuously),apply as static variable instead of member variable
                           // otherwise we have counter value from 1 to 10 for thread 0 and again 1 to 10 for thread 1
    int remainder;
    static Object lock = new Object();//lock object is single instance within entire code

    PrintTask(int reminder) {
        this.remainder = reminder;
    }
    public void printer(){
        System.out.println(Thread.currentThread().getName() + " " + counter++);//continuously increment the value and print
    }
    @Override
    public void run() {
        for(int i = 1; i <= 10; i++){
            //critical section of the code, apply synchronized lock
            synchronized (lock) {
                while (counter % 2 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                printer();
                lock.notifyAll();
            }
        }
    }
}