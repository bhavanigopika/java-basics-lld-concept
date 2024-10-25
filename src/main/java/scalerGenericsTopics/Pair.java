package scalerGenericsTopics;

public class Pair {
    Object first;
    Object second;

    public Pair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    public Object getFirst() {
        return first;
    }
    public Object getSecond() {
        return second;
    }

}

//Pro: You get to store generics
//Cons: There is no compile time safety
