package scalerGenericsTopics;

public class Demo <K, V>{
    public void doSomething(K key, V value){
        System.out.println(key);
        System.out.println(value);
    }
    public static <A, B> void getValue(A key, B value){
        System.out.println(key);
        System.out.println(value);
    }

    public static <A, B> String getValue2(A key, B value){
        System.out.println(key);
        System.out.println(value);

        return "hi";
    }

    public static <A, B> A getValue3(A key, B value){
        System.out.println(key);
        System.out.println(value);

        return key;
    }
}
