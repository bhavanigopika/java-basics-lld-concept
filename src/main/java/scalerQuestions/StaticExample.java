package scalerQuestions;

public class StaticExample {
    int x = 10;
    static int y = 20;

    static int z = 0;

    public static void main(String[] args) {
        StaticExample firstObject = new StaticExample();
        StaticExample secondObject = new StaticExample();
        firstObject.x = 20;
        firstObject.y = 20;
        System.out.println(firstObject.x + " " + secondObject.x);//20 10
        System.out.println(firstObject.y + " " + secondObject.y);//20 20

        z++;
        StaticExample t = new StaticExample();
        t.z++;
        System.out.println(z);

    }
}
