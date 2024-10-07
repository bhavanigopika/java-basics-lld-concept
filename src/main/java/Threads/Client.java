package Threads;

//When I run this method, is my CPU execute the client class piece of code? Yes
public class Client {
    static void doSomething() {
        System.out.println("Printing something in thread and current thread name: " + Thread.currentThread().getName());
        //doSmething execute in which thread: main
        //And we didn't create any external thread here.
    }
    public static void main(String[] args) {

        System.out.println("Current thread name: " + Thread.currentThread().getName());
        doSomething(); //since it is static, I didn't create any object

        //Now, I don't want to print a thread as a main thread and I want to give a task
        //to a different thread rather than my main thread
        System.out.println("Hello World");

        PrintHelloWorld task1 = new PrintHelloWorld();
        /*
        task1.run(); //still it is main thread  output: Hello Word... Printing hello world in thread and the thread name is main
        */

        //To create the thread…use thread object…it accepts the task
        Thread t1 = new Thread(task1);
        /*
        Inside Thread, we have see below and check with click ctrl+B

        public Thread(Runnable task) {
            this(null, null, 0, task, 0, null);
        }
        */
        //We have to start the thread
        t1.start(); //output: Hello Word... Printing hello world in thread and the thread name is Thread-0


        //Create the thread for printing the number (PrintNumber)
        //No, default constructor, so, I have to pass the number to print
        PrintNumber task2 = new PrintNumber(5);
        Thread t2 = new Thread(task2);
        t2.start();//execute the thread

        System.out.println("Check the number what thread it is:");

        //number 5 which I have used and below will print, so the total number of threads will be 11 not 10, including the thread are adding for above print number also.

        // Now, let's Print all numbers form 1 to 100 which used 100 different threads

        for(int i = 1; i <= 10; i++) {
            PrintNumber task = new PrintNumber(i);
            Thread t = new Thread(task);//Doing the multithreading
            t.start();
        }

//        PrintHelloWorld task3 = new PrintHelloWorld();
//        for(int i = 1; i <= 1000; i++) {
//            Thread thread = new Thread(task3);
//            thread.start();
//        }


        /*
        t.start();//execute the task that you have created in new thread
        t.run(); //directly calls within your thread
         */

    }
}
