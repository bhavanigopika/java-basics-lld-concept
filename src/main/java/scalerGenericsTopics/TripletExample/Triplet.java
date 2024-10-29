package scalerGenericsTopics.TripletExample;

//To accept all type of data type, then use common placeholder such as K, T, TYPE, V
public class Triplet<TYPE>{
    private TYPE left;
    private TYPE right;
    private TYPE middle;
    public Triplet(TYPE left, TYPE right, TYPE middle) {
        this.left = left;
        this.right = right;
        this.middle = middle;
    }
    public TYPE getLeft() {
        return left;
    }

    public TYPE getRight() {
        return right;
    }

    public TYPE getMiddle() {
        return middle;
    }

}
/*public class Triplet {

    private Double left;
    private Double right;
    private Double middle;

    public Triplet(Double left, Double right, Double middle) {
        this.left = left;
        this.right = right;
        this.middle = middle;
    }

    public Double getLeft(){
        return left;
    }

    public Double getRight(){
        return right;
    }

    public Double getMiddle(){
        return middle;
    }
}*/
