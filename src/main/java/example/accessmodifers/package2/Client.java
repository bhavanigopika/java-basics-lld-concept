package example.accessmodifers.package2;

import example.accessmodifers.package1.Student;

public class Client {
    public static void main(String[] args) {
        Student st = new Student();
        //rollNo is public
        st.rollNo = 15;
        //roomNo is private
        //st.roomNo = 20;
        //univName is protected and here we cannot access since this current Client class is not child class of Student class and
        //univName is protected...so, we can access client class through child class only
        //st.univName
        //psp is default and default access modifier can access only in the same package
        //st.psp

        StudentChild st1 = new StudentChild();



    }
}
