package scalerTest;

public class MyRunnableTask implements Runnable{
    public static int counter = 0;
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            counter++;
        }
    }
}
