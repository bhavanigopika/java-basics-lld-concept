package scalerLambdas.lambdaExample;

public class Main {
    public static void main(String[] args) {
        //v1
        //Here, I have to create a separate class SomethingDoer for this
        SomethingDoer somethingDoer = new SomethingDoer();
        Thread t1 = new Thread(somethingDoer);
        t1.start();

        //v2
        //Here, I didn't create a new class
        Runnable r = () -> {
            System.out.println("Do something v1");
        };
        Thread t2 = new Thread(r);
        t2.start();

        //v3
        Thread t3 = new Thread(
                () -> {
                    System.out.println("Do something v1");
                }
        );
        t3.start();

    }
}
