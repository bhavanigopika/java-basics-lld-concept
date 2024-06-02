package learningabstract;

public class Horse extends Animal {
    @Override
    public void walk() {
        System.out.println("Horse walk in different way");
    }
    @Override
    public void produceSound() {
        System.out.println("Horse produce sound: neigh");
    }

    Horse(){
        super(2, "Bujji" );
        System.out.println("Horse constructor is calling");
    }
}
