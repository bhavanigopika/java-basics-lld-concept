package scalerGenericsTopics.TripletExample;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        //Triplet triplet = new Triplet(1.0, 2.0, 3.0);//I have to give only double value, because I didn't use generic data type
        Triplet<String> idNameEmail = new Triplet<>("1", "Krish", "krish@scaler.com"); //I am passing the string only here
        Triplet<Integer> idAgeRollNo = new Triplet<>(1, 15, 21);
        Triplet<Long> idAgeRollNoLong = new Triplet<>(3L, 10L, 29L);

        //System.out.println(idNameEmail + " " +  idAgeRollNo + " " + idAgeRollNoLong);//get object address for 3 things
        print(idNameEmail);//I am using only string here in print function

        //The following things are not accept because of compile time type-safety
        /*
        print(idAgeRollNoLong);//Required Type: Triplet<String> But provided Triplet<Long>
        print(idAgeRollNo);//Required Type: Triplet<String> But provided Triplet<Integer>
        */

        printInGenericType(idNameEmail);
        printInGenericType(idAgeRollNo);
        printInGenericType(idAgeRollNoLong);

        //Let's do the triplet of string type in list (idNameEmail, idNameEmail). Note: idNameEmail which I mentioned in 2 times have same address...Having shallow copy not deep copy
        List<Triplet<String>> list = List.of(idNameEmail, idNameEmail);
        printList(list);

        List<Triplet<Long>> list1 = List.of(idAgeRollNoLong, idAgeRollNoLong);//I can use long here and pass it in genericType
        printListGenericType(list1);

        System.out.println("Average value: " + getAverage(idAgeRollNo));

        System.out.println("Average value using generic: " + getAverageGeneric(idAgeRollNo));

        System.out.println("Average value using generic: " + getAverageGeneric(idAgeRollNoLong));


    }


    public static void print(Triplet<String> triplet){
        System.out.println(triplet.getLeft() + " " + triplet.getRight() + " " + triplet.getMiddle());
    }

    //Let's make the above print function in generic based function - define it in method signature
    public static <TYPE> void printInGenericType(Triplet<TYPE> triplet){
        System.out.println(triplet.getLeft() +" " + triplet.getRight() + " " + triplet.getMiddle());
    }

    //The following things are not generic
    public static void printList(List<Triplet<String>> triplets){
        for(Triplet<String> triplet: triplets){
            System.out.println(triplet.getLeft() + " " + triplet.getRight() + " " + triplet.getMiddle());
        }
    }

    //Let's make the things are generic
    public static <E> void printListGenericType(List<Triplet<E>> triplets){
        for(Triplet<E> triplet: triplets){
            System.out.println(triplet.getLeft() + " " + triplet.getRight() + " " + triplet.getMiddle());
        }
    }

    //The following function are not generic. It is integer specific. Tomorrow, it might be  long or double etc.,
    public static double getAverage(Triplet<Integer> triplet){
        //double avg = (double) (triplet.getLeft() + triplet.getRight() + triplet.getMiddle()) /3;//Convert integer to double. So, typecast into double
        //another way to typecast into double
        double avg = (triplet.getLeft().doubleValue() + triplet.getRight().doubleValue() + triplet.getMiddle().doubleValue())/3;
        return avg;
    }

    //Let's make the following function as generic.

    //So, use wild card notation(?). If you use T in place of ?, then you also define it as -> static<T>
    /*? - accept any data type and this is wildcard. You can put anything, so I'll accept all...It is not defined by use.
    T - accept any data type and it is generic. Generic is more like, you are defining that these function accept these things*/

    /*we calculate the average of numbers
    Integer, Long, Double, Short, Byte, Float are all extends Number abstract class, String not extends Number.
    Number class is the parent of all the classes allowing numeric values
    getAverageGeneric should be allowing Triplet of type Number or child class of Number
    So, upperBound is Number -> ? extends Number*/

    public static double getAverageGeneric(Triplet<? extends  Number> triplet){
        return (triplet.getLeft().doubleValue() + triplet.getRight().doubleValue() + triplet.getMiddle().doubleValue())/3;
    }


    /*
    Type erasure:

    Type erasure happens whenever you run your code. So, type erasure will erases the type...
    Whenever you run your code in run time, everything behaves as raw type
    Type erasure happens because of backward compatibility...
    In run time, everything runs as object
     */
}
