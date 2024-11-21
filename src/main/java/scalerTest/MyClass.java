package scalerTest;

public class MyClass {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.display();
        display();

        String str = "Java";
        str = str + " Scaler";
        System.out.println(str);
        str.concat(" Programming");
        System.out.println(str);
    }
    static void display(){
        System.out.println("Static method");
    }
}
