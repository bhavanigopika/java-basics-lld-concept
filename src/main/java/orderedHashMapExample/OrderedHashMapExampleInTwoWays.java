package orderedHashMapExample;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class OrderedHashMapExampleInTwoWays {
    //The sstandard hashmap does not guarantee any specific order of its elements.
    //If you need an order map, 2 ways (i.e) LinkedHashMap and TreeMap
    public static void main(String[] args) {
        Map<String, Integer> linkedMap = new LinkedHashMap<>();
        linkedMap.put("one", 1);
        linkedMap.put("two", 2);
        linkedMap.put("three", 3);

        for(Map.Entry<String, Integer> e : linkedMap.entrySet()){
            System.out.println(e.getKey() + ": " + e.getValue());
        }
        // Output will be:
        // one: 1
        // two: 2
        // three: 3

        System.out.println("***************************************************");

        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("one", 1);
        treeMap.put("two", 2);
        treeMap.put("three", 3);

        for(Map.Entry<String, Integer> e : treeMap.entrySet()){
            System.out.println(e.getKey() + ": " + e.getValue());
        }
        // Output will be:
        // one: 1
        // three: 3
        // two: 2

        // Performing basic operations on TreeMap

        System.out.println("***************************************************");


        Map<String, Integer> tm = new TreeMap<>();

        // Adding elements to the tree map
        tm.put("A", 1);
        tm.put("C", 3);
        tm.put("B", 2);

        // Getting values from the tree map
        int ans = tm.get("A");
        System.out.println("Value of A: " + ans);

        // Removing elements from the tree map
        //tm.remove("B");

        // Iterating over the elements of the tree map
        for (String key : tm.keySet()) {
            System.out.println("Key: " + key + ", Value: " + tm.get(key));
        }
        //output is
        //Value of A: 1
        //Key: A, Value: 1
        //Key: B, Value: 2
        //Key: C, Value: 3
    }
}
/*
1. LinkedHashMap:
         -> Maintains the order of insertion. When you iterate over a LinkedHashMap, the elements will be returned
            in the same order they were added.
         -> It is implemented as a hash table with a doubly-linked list running through it, which preserves the insertion order.
         -> It's suitable when you need to maintain the order in which key-value pairs were put into the map.

2. TreeMap:
         -> Sorts the keys in natural order or by a custom Comparator.
         -> It is implemented as a red-black tree, which ensures the keys are always sorted.
         -> It's suitable when you need to keep the keys in a sorted order, not necessarily the insertion order.

Key Differences:
         -> LinkedHashMap preserves insertion order, while TreeMap sorts keys.
         -> LinkedHashMap has a slight performance overhead compared to HashMap due to the linked list.
            TreeMap has a performance overhead due to the sorting process.
         -> Choose LinkedHashMap when you need to iterate in the same order as insertion.
            Choose TreeMap when you need to iterate in key-sorted order.
 */
