package learningOnYourOwn;

public class SwappingExample {
    public static void main(String[] args) {
        int a = 20;
        int b = 5;
        System.out.println("Before swapping a = " + a + " and b = " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After swapping a = " + a + " and b = " + b);
    }
}
