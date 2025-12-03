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

        System.out.println("Now a = " + a + " and b = " + b);
        //Swap two numbers without temporary variables
        System.out.println("Again we have to do swap. So,");
        System.out.println("Before swapping a = " + a + " and b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swapping a = " + a + " and b = " + b);
    }
}
