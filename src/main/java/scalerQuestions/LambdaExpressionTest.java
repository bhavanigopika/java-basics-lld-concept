package scalerQuestions;

public class LambdaExpressionTest {
    public static void main(String[] args){
        int x = 10;
        Runnable r = () -> System.out.println(x);
        Thread t = new Thread(r);
        t.start();
    }
}
