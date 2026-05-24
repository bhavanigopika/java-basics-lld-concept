package practiceOnMyOwn;

import java.util.Arrays;

public class Client {
    public static void main(String[] args){
        String arr1[] = {"Rat", "Dog", "Cat", "Elephant","Ant"};
        //1) using case-insensitive order
        Arrays.sort(arr1, String.CASE_INSENSITIVE_ORDER);
        //Arrays.sort(arr1);
        Print p = new Print();
        p.print(arr1);

        //2) using compare to ignore case
        Sort s = new Sort();
        s.sort(arr1);
        Print pr = new Print();
        pr.print(arr1);

        //3) using customer comparator
        Arrays.sort(arr1, (a,b) -> a.compareToIgnoreCase(b));
        Print p1= new Print();
        p1.print(arr1);

        //4) using stream API(Java 8 and above)
        String[] ans = Arrays.stream(arr1)
                .sorted(String.CASE_INSENSITIVE_ORDER)//using a comparator for case-insensitive sorting
                .toArray(String[]::new); //collect back into an array
        Print pri = new Print();
        pri.print(ans);


    }
}
