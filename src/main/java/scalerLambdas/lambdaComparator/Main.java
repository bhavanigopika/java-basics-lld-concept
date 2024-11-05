package scalerLambdas.lambdaComparator;

import scalerCollections.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();

        students.addAll(List.of(new Student(1, 25, "Krish", 85),
                new Student(2, 30, "Vidhu", 90),
                new Student(3, 29, "Shekara", 99),
                new Student(4, 21, "Jack", 82)));

        //Do the custom ordering without creating the new class...That is let's try via lambda
        //Because we do that is comparator is functional interface and that's why we have to use via lambda

        //v1
        //Comparator<Student> comparator2 = (Student o1, Student o2) -> {
        //or automatically takes student object
        Comparator<Student> comparator2 = (o1, o2) -> {
            if(o1.getName().equals(o2.getName())){
                return 0;
            }
            //let's have in alphabetical order
            if(o1.getName().compareTo(o2.getName()) < 0){
                //this...other -> o1...o2
                return -1;
            }
            return 1;
        };
        Collections.sort(students, comparator2);

        //v2
        Collections.sort(students, (o1, o2) -> {
                if (o1.getName().equals(o2.getName())) {
                    return 0;
                }
                //let's have in alphabetical order
                if (o1.getName().compareTo(o2.getName()) < 0) {
                //this...other -> o1...o2
                    return -1;
                }
                    return 1;
                }
        );
    }
}
