package lld.synchronization.adderSubtractor;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

        Adder task1 = new Adder(count);
        Subtractor task2 = new Subtractor(count);

       Thread t1 = new Thread(task1);
       Thread t2 = new Thread(task2);

       t1.start();
       t2.start();

       //The following code will waits for thread t1 and t2 to finish execution
        t1.join();
        t2.join();

        System.out.println(count.value);
    }
}
