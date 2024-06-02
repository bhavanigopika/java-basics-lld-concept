package learningabstract;

public class Giraffee extends Animal{
    @Override
    public void walk() {
        System.out.println("Giraffee walk in different way");
    }
    @Override
    public void produceSound() {
        System.out.println("Girafe produce sound: snort");
    }
}
