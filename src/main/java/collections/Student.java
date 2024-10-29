package collections;

public class Student implements Comparable<Student>{
    String name;
    double psp;
    String univName;
    Student(String name, double psp, String univName){
        this.name = name;
        this.psp = psp;
        this.univName = univName;
    }

    /*
    comparable interface is to define the natural ordering of user defined classes.
    //The following code here is natural ordering bec we implement Student class via comparable.
     */
    @Override
    public int compareTo(Student o) {
        //o means student here
        //apply the ordering now, if I want to order based on student name
        //return this.name.compareTo(o.name);

        //suppose, if two student psp is same, then I want to sort (custom sort) as
        if(this.psp < o.psp){
            return -1; //this.psp comes first since it is -1
        }else if(this.psp > o.psp){
            return 1;//o.psp comes first since it is 1
        }else/*if both are equal, I want to decide it by name*/
        {
            return this.name.compareTo(o.name);
        }
    }

//    @Override
//    public int compareTo(Student o) {
//        return 0;
//    }
}
