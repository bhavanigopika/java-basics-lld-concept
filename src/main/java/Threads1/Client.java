package Threads1;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        PrintHelloWorld task1 = new PrintHelloWorld();
        for(int i = 1; i < 1000; i++) {
            //Thread.sleep(100);//see, now threads will be in order till 1000 times, because the thread is sleep, cpu cannot schedule whatever free threads are available
            Thread t = new Thread(task1);
            t.start();//see, we get order is different, because all threads are actively waiting. So, CPU can schedule it...
        }


        for(int i = 1; i <= 1000; i++) {
            PrintNumber task2 = new PrintNumber(i);
            Thread t = new Thread(task2);
            t.run();//this is normal function call, so, creating a thread in main and this is occurring in linear order
            t.start();//here, threads are created in any order
        }

        for(int i = 1; i <= 1000; i++) {
            PrintNumber task3 = new PrintNumber(i);
            task3.run();//implement in main  thread, here we didn't do multithreading (i.e) creating a new thread and submit the task and all
            //task allocating in linear order
        }

        //Another way of implementing thread concept (i.e) extend Thread class
        Thread t10 = new AnotherWayPrintHelloWorld();
        t10.start();

        for(int i = 0; i < 1000; i++){
            Thread t11 = new AnotherWayPrintHelloWorld();
            t11.start();
        }
    }
}
/*
Now, let us do the sleep in PrintHelloWorld and comment in main thread. See 8th line...
In main function, main thread not wait anything to create a task. We didn't apply sleep here...1000 threads available/created at same time
See, in printHelloWorld, we apply thread.sleep here...Hence, all 1000 threads are waiting for 20 sec
Here, solution become cpu allocate random thread only...
 */

/*
Implements Runnable interface vs by extend Thread class
Extend Thread class:
    Since you can inherit only 1 class, actually. Here we are using the Thread clas, you will not be the best use of inheritance.
    When I am extending Thread class, we are tightly coupling the thread class.
    Here, in thread class(Thread.java) we have a lot of function. Why we need to extend Thread class. We want only one method that is run(). So, just implements runnable interface and use run() method.

Implements Runnable interface:
    Here, we have only method which is run()...This was one of the best design pattern. The only one method we have in an interface called Runnable interface
    Task is separated from threading part
    So, implements Runnable interface is better as my business logic is separate from Thread related things.
 */