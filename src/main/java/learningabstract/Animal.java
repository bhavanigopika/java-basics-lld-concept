package learningabstract;

public abstract class Animal {
    int age;
    String name;

    public abstract void walk();
    public abstract void produceSound();
    public void eat(){
        System.out.println("Lick the food");
    }

    Animal(){
        System.out.println("Animal constructor");
    }
    Animal(int age, String name){
        this.age = age;
        this.name = name;
        System.out.println("Animal constructor is calling by Horse, age is " + age + ", name is " + name);
    }
}
