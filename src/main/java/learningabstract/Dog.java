package learningabstract;

public abstract class Dog extends Animal {
    int age;
    int weight;
    String color;
    public abstract void walk();
    public void produceSound(){
        System.out.println("Dog produce sound");
    }

    Dog(){
        System.out.println("Dog constructor");
    }
}
