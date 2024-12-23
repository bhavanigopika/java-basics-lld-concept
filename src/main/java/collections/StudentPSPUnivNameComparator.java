package collections;

import java.util.Comparator;

public class StudentPSPUnivNameComparator implements Comparator<Student> {

    @Override
    public int compare(Student student, Student o2) {//prefer psp first and then univName
        if(student.psp < o2.psp){
            return -1;
        }else if(o2.psp < student.psp){
            return 1;
        }else{
            return student.univName.compareTo(o2.univName);
        }

    }

//    @Override
//    public int compare(Student o1, Student o2) {
//        return 0;
//    }
}
