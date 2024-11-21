package scalerQuestions;

public class TestThreads {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();

        int x = 10;
        x = 20;
        int finalA = x;
        Runnable r = () -> System.out.println(finalA);
        Thread t = new Thread(r);
        t.start();
    }
}
