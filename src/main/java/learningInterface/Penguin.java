package learningInterface;


public class Penguin implements Animal,Bird {
    @Override
    public void produceSound() {
        System.out.println("Penguin produceSound");
    }

    @Override
    public void run() {
        System.out.println("Penguin run");
    }
    @Override
    public void fly() {
        System.out.println("Penguin can't fly");
    }

    public void jump(){
        System.out.println("Penguin jump");
    }
}
