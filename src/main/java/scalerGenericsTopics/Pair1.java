package scalerGenericsTopics;

public class Pair1<F, S>{
    F first;
    S second;

    public Pair1(F first, S second){
        this.first = first;
        this.second = second;
    }

    public F getFirst(){
        return first;
    }
    public void setFirst(F first){
        this.first = first;
    }
    public S getSecond(){
        return second;
    }
    public void setSecond(S second){
        this.second = second;
    }

}
