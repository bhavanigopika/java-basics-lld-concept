package Learninginterface;

public class Dog implements Animal {
    String name;
    int age;

    Dog(){
        //super();
        System.out.println("Dog Constructor");
    }

    @Override
    public void produceSound() {
        System.out.println("Dog sound is vow vow");
    }

    @Override
    public void run(){
        System.out.println("Dog run 25-30 km/hr by average");
    }
}
