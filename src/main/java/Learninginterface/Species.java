package Learninginterface;

//interface can extedn multiple interfaces
public interface Species extends Animal,Bird {
    public void fly();
    public void run();
    public void producesound();
}
