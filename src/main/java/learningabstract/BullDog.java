package learningabstract;

public class BullDog extends Dog {
    @Override
    public void walk(){
        System.out.println("Bull Dog walking is different ");
    }
    @Override
    public void produceSound(){
        super.produceSound();
        System.out.println("Bull dog produce sound in vow-vow");
    }

    BullDog(){
        System.out.println("BullDog constructor");
    }
}
