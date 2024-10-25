package ScalerGenerics;

public class Client{
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("One", 1);
        System.out.println(pair.getFirst() + ", " + pair.getSecond());
    }
}
