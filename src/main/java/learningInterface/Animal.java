package learningInterface;

public interface Animal {
    public void produceSound();
    public void run();
    //no Animal constructor for interface.

    //default allow to define implementation/body
    //public default void eat(){
    //
    //}
    public default void ride(){
        System.out.println("Some animals using for riding");
    }
}
