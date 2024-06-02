package learningabstract;

public class Client {
    public static void main(String[] args) {
        BullDog bd = new BullDog();
        bd.produceSound();
        bd.walk();

        Horse p = new Horse();

        //We cannot create object for Dog since Dog is abstract class
        //Dog d = new Dog();

//        We cannot create object for Animal since animal is abstract class
//        Animal a = new Animal();
//        other wise, I have do following work here
//        Animal a = new Animal() {
//            @Override
//            public void walk() {
//                System.out.println("walk");
//            }
//
//            @Override
//            public void produceSound() {
//                System.out.println("produce sound");
//            }
//        };
    }
}
