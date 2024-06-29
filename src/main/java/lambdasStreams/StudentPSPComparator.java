package lambdasStreams;

import java.util.Comparator;

public class StudentPSPComparator implements Comparator<Student> {
    @Override
    public int compare(Student student, Student o2) {
        return (int) (student.psp - o2.psp);
        /*public int compare(Student a, Student b){
        if(a > b){
            return -1; //a comes first(first element comes first)
        }else if(b > a){
            return 1;//b comes first(second element comes first in the final output
        }else if(a == b){
            return 0;//anything comes first
        }

        //or we can use it as -> return a-b;
        }*/
    }
}
