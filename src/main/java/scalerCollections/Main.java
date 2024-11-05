package scalerCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();

        students.addAll(List.of(new Student(1, 25, "Krish", 85),
                new Student(2, 30, "Vidhu", 90),
                new Student(3, 29, "Shekara", 99),
                new Student(4, 21, "Jack", 82)));

        List<String> stringList = new ArrayList<>();
        stringList.addAll(List.of("Krish", "Vidhu", "Shekara", "Jack"));

        //Strings have natural order defined...So, when we define collections.sort(stringList) then it works
        Collections.sort(stringList);

        //Student not have natural order defined...So, when we define collections.sort(students) then it will not work. So, do the comparable work here
        //Make the student in natural ordering defined in Student class(descending order of psp)
        Collections.sort(students);

        //custom ordering defined in ascending order of name
        Collections.sort(students, new StudentOrderingByName());
    }
}
