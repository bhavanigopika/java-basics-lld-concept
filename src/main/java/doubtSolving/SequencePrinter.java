package doubtSolving;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SequencePrinter {
    //Write a java program to print a sequence of numbers upto 10 using 3 threads
    private static final int max = 10;
    private static int number = 1;//tracks the current number to be printed
    private static final Lock lock = new ReentrantLock();//lock for synchronization

    static class PrintTask implements Runnable{
        private final int threadId;
        PrintTask(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            //while loop is better than for loop
            while(true){
                synchronized(lock) {
                    if (number > max) {
                        break;
                    }
                    //3 threads are created with different thread is:(0,1,2)
                    //number % 3 == threadId ==> I can determine which threadId have to use
                    //I want to execute 3 threads only thread0, thread1, thread2. So, I have used the modularity 3
                    if (number % 3 == threadId) {
                        System.out.println("Thread: " + threadId + ": " + number);
                        number++;
                        //once thread work completed, then it nofify to other threads that you can proceed further
                        lock.notifyAll();
                    } else {
                        //if not this thread's turn, then we should wait here (i.e) some thread executed parallel
                        try {
                            /*
                            When a thread calls wait(), then
                            1. Releases the lock it holds on the lock object
                            2. Goes into a waiting state until another thread calls notify() or notifyAll() on the same lock object

                             */
                            lock.wait();//I am not executing in critical section. I will wait for pgm to run unitl that
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        //3 threads are created with thread 0,1,2
        PrintTask task1 = new PrintTask(0);
        Thread t1 = new Thread(task1);
        t1.start();

        PrintTask task2 = new PrintTask(1);
        Thread t2 = new Thread(task2);
        t2.start();

        PrintTask task3 = new PrintTask(2);
        Thread t3 = new Thread(task3);
        t3.start();
    }
}