package collections;


import polymorphism.runtimepolymorphism.C;

import java.util.*;

public class Client {
    public static void main(String[] args) {
       /*<<Collection>> -> Collection interface -> << >> represents interface
        Collection interface having <<list>>, <<set>>, <<queue>>
        list interface having 4 classes called ArrayList, LinkedList, Vector, Stack*/

        //List Interface:
        /*
        ArrayList  is Resizable implementation of List interface
        ArrayList is actually implemented using Arrays
        ArrayList is not synchronized, so ArrayList is not thread safe
        Arrays is having index...so random access(retrieve the data is fast)
         */
        List<String> ls1 = new ArrayList<>();
        ls1.add("Krish");
        ls1.add("Raj");
        ls1.add("Sam");
        ls1.add("Moon");
        ls1.add("Jack");
        System.out.println(ls1);//same order return the list

        /*
        LinkedList is actually implemented using Doubly-linked list(DLL) not by Arrays
        LinkedList is not synchronized so, it is not thread safe
        DLL is not having index...so no random access possible -> Random access using index is slower in  LinkedList as compared to in Array List
         */
        List<String> ls2 = new LinkedList<>();


        /*
        Vector is thread safe and preferable in multithreaded environment
         */
        List<String> ls3 = new Vector<>();

        /*
        Stack - Extended from vector only and it supports LIFO principle -> push, pop
        Stack is thread safe
         */
        List<String> ls4 = new Stack<>();

        //Set interface
        /*
        No duplicate elements
        set provides constant time operations for search, insert, delete - O(1)(Time complexity)
        HashSet has no order confirmation...it's random.
        */
        Set<String> s1 = new HashSet<>();
        s1.add("Raj");
        s1.add("Ram");
        s1.add("Jack");
        s1.add("John");
        s1.add("Abi");
        System.out.println(s1);

        /*
        LinkedHashSet is well-defined encounter order.
        order will be retained here
         */
        Set<String> s2 = new LinkedHashSet<>();
        s2.add("Abi");
        s2.add("Hanu");
        s2.add("Krish");
        s2.add("Ram");
        s2.add("John");
        System.out.println(s2);

        /*
        TreeSet - elements are ordered using their natural ordering or by a Comparator provided at set creation time, depending on which constructor is used.
        natural ordering - alphabetical ordering(lexicographical order)
         */
        Set<String> s3 = new TreeSet<>();
        s3.add("Hanu");
        s3.add("Raj");
        s3.add("Ram");
        s3.add("Krish");
        s3.add("Anu");
        System.out.println(s3);

        /*
        EnumSet and Enum -> both are differ
        Enum - Enums are nothing but constants. Whenever you have some predefined strings or constants. you use enums
         */
        Payment p1 = new Payment();
        p1.status = PaymentStatus.APPROVED;
        Payment p2 = new Payment();
        p2.status = PaymentStatus.REJECTED;

        /*
        ENUMSET is to play around with enums
         */
        Set<PaymentStatus> s4 = EnumSet.allOf(PaymentStatus.class);
        System.out.println(s4); //order also maintained

        EnumSet<PaymentStatus> s5 = EnumSet.of(PaymentStatus.WHICH_ONE, PaymentStatus.REJECTED, PaymentStatus.IN_PROGRESS, PaymentStatus.DONE);
        System.out.println(s5);//order not maintained

        EnumSet<PaymentStatus> s6 = EnumSet.complementOf(s5);
        System.out.println(s6);//displayed all enums except in s5

        /*
        Queue Interface
         */
        Queue<String> q = new PriorityQueue<>(); //priority queue is in natural ordering(lexicographical order(alphabetical order))
        q.add("Krish");
        q.add("Vikki");
        q.add("Abi");
        q.add("John");
        q.add("Ram");

        /*
        Priority Queue is nothing but heap data structure
        min heap and max heap, by default priority queue is min heap.
         */

//        we should  not do like this in priority queue
//        System.out.println(q);//order will be abi, john, krish, vikki, ram

        System.out.println(q.peek());//abi
        while(!q.isEmpty()){
            System.out.print(q.peek() + " ");//natural order - ascending order-> abi, john, krish, ram, vikki
            q.poll();
        }
        System.out.println();
        //I want to make it work like a max heap

        Queue<String> q1 = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String a, String b){//here we can define the custom order(we can create our own order in this method)
              /*if(a > b){
                    return -1; //a comes first(first element comes first)
                }else if(b > a){
                    return 1;//b comes first(second element comes first in the final output
                }else if(a == b){
                    return 0;//anything comes first
                }*/

                //or we can use it as -> a.compareTo(b);

                /*
                    -1 -> a comes first(first element comes first)
                    +1 -> b comes first(second element comes first in the final output
                    0 -> anything comes first
                 */

                //return a.compareTo(b);//natural order -> abi, john, krish, ram, vikki
                return b.compareTo(a);//descending order -> vikki, ram, krish, john, abi
            }
        });
        q1.add("Krish");
        q1.add("Vikki");
        q1.add("Abi");
        q1.add("John");
        q1.add("Ram");
        while(!q1.isEmpty()){
            System.out.print(q1.peek() + " ");
            q1.poll();
        }
        System.out.println();

        /*
        Done with List, Set, Queue Interfaces
        */

        /*
        Comparable and Comparator Interface - These two interfaces are in collection interface
         */
        //Collections.sort method is sorting the elements of ArrayList in ascending order
        //Collections.sort(al); //TC: O(n logn), auxiliary space: O(1)

        //Collections.sort method is sorting the elements of ArrayList in descending order
        //Collections.sort(al, Collections.reverseOrder()); //TC: O(n logn), auxiliary space: O(1)

        Collections.sort(ls1);
        System.out.println(ls1); //[jack, krish, moon, raj, sam]

        //If we want in non-decreasing order then we can use comparator in collections.sort
        Collections.sort(ls1, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a); //b.compreTo(a) is impt, then only non-decreasing order
            }
        });
        System.out.println(ls1);//sam, raj, moon, krish, jack

        //bring out the list with our own object Student
        List<Student> ls5 = new ArrayList<Student>();
        //since it is a student type...write it as
        Student st1 = new Student("Humpy", 97.5, "Amritha");
        Student st2 = new Student("Kiwi", 99.6, "scaler");
        Student st3 = new Student("Rocky", 99.6, "delhi university");
        //add all students in list
        ls5.add(st1);
        ls5.add(st2);
        ls5.add(st3);
        //java not able to understand in what expect student have to sort since student object which has created
        //by ourselves. So, make students implements comparable interface and add all methods of comparable interface
        //in student class.
        Collections.sort(ls5);

        //Collections of student, so iterate
        for(Student s:ls5){
            System.out.println(s);//gives object reference
            System.out.println(s.name + " " + s.psp + " " + s.univName);//sorted as per the psp first, if same psp, then sorted via name

        }

        /*
        Comparator interface
         */
        System.out.println("********************");

        //sort it by psp
        Collections.sort(ls5, new StudentPSPComparator());
        for(Student s:ls5){
            System.out.println(s.name + " " + s.psp + " " + s.univName);
        }

        System.out.println("********************");
        //sort it by combination of UnivName and PSP -> first psp then  univName
        Collections.sort(ls5, new StudentPSPUnivNameComparator());
        for(Student s:ls5){
            System.out.println(s.name + " " + s.psp + " " + s.univName);
        }
        //However, I can directly create the comparator here itself - lambda expression
        /*  Collections.sort(ls5, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        });*/
        /*
        To add syntactic sugar to coat, there is a beautiful thing in java known as Lambdas.
        It makes your code less bulky.
         */
    }
}
