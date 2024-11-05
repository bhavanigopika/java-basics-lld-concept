package scalerLambdas.adderSubtractor;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

        /*Adder task1 = new Adder(count);
        Subtractor task2 = new Subtractor(count);*/

        //Since we create the run function of adder and subtractor in lambda body...we don't need adder and subtractor class

        //
        /*
        1. Create an anonymous class -> adderLambdaAnonymous
        2. It will implement the interface Runnable in the Anonymous class it created
        3. It will pass all the variables being shared.
        4. It will copy the code from the lambda body into the method we implement in the anonymous class
         */
        Runnable task1  = () -> {
            //lambda body
            for(int i = 1; i <= 10000; i++){
                synchronized (count) {
                    count.value = count.value + i;
                }
            }
        };

        Runnable task2 = () -> {
            //lambda body
            for(int i = 1; i <= 10000; i++){
                synchronized (count) {
                    count.value = count.value - i;
                }
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        //The following code will wait for thread t1 and t2 to finish execution
        t1.join();
        t2.join();

        System.out.println(count.value);

        //interface - blueprint of behaviour...not holding anything...it is just a pointer
        //Animal
        //Dog implements Animal
        //Animal a = new Dog();

        //do we create an animal class (i.e) animal object? No, because animal is an interface
    }
}
