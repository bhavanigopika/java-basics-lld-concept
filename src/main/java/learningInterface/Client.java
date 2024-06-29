package learningInterface;

public class Client {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.produceSound();
        d.run();
        //Animal a = new Animal();

        Penguin p = new Penguin();
        p.produceSound();
        p.run();
        p.fly();
        p.jump();
    }
}
