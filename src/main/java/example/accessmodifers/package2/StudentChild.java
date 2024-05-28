package example.accessmodifers.package2;

import example.accessmodifers.package1.Student;

public class StudentChild extends Student {
    //This StudentChild can access the protected attributes of Student Class
    void doSomething2(){
        //univName is protected and now we can access this.
        univName = "CIT";
        //rollNo is public, so we can access
        rollNo = 10;
        //roomNo is private, so we cannot access
        //default psp cannot access since default will work in the same package


    }
}
