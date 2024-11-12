package scalerQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentMapExample {
    public static ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        concurrentMap.put("A", 1);
        int valueA = concurrentMap.get("A");
        int valueB = concurrentMap.compute("B", (key, oldValue) -> (oldValue == null) ? 1 : oldValue + 1);
        int valueC = concurrentMap.merge("C", 1, Integer::sum);
        concurrentMap.remove("A");
        boolean containsKeyB = concurrentMap.containsKey("B");

        System.out.println(valueA);
        System.out.println(valueB);
        System.out.println(valueC);
        System.out.println(containsKeyB);
        System.out.println(valueA);

        AtomicInteger sum = new AtomicInteger();
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        numbers.forEach(n -> sum.addAndGet(n));
        System.out.println(sum.get());

        List<String> lt = new ArrayList<>(List.of("apple", "mango", "guava"));
        Comparator<String> cmp = (s1, s2) ->  s2.compareTo(s1);
        Collections.sort(lt, cmp);
        System.out.println(lt);
    }
}
