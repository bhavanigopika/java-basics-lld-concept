package scalerQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        obj.display();


        List<String> list = new ArrayList<>(List.of("apple", "mango", "guava"));
        List<String> ls = List.of("apple", "mango", "guava");

        Comparator<String> cmp = (s1, s2) -> s2.compareTo(s1);
        Comparator<String> cmp1 = (s1, s2) -> s2.compareTo(s1);

        Collections.sort(list, cmp);
        Collections.sort(ls, cmp1);

        System.out.println(list);
        System.out.println(ls);//Exception in thread
    }
    static void display(){
        System.out.println("Static methods");
    }

}
