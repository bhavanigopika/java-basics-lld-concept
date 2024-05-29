package constructors;

public class Student {
    int rollNo = 4;
    double psp;
    String univName;
    int roomNo;

//    Student(){
//        rollNo = 10;
//        psp = 88;
//        univName = "IIT";
//        roomNo = 108;
//    }


    /*
    Without constructor, we can’t create the object…
    Constructor create the object
     */


    Student(int rollNo, String univName){
        this.rollNo = rollNo;
        this.univName = univName;
    }

    Student(int rollNo){
        this.rollNo = rollNo;
    }

    Student(){
        //work like a default constructor
    }
    Student(Student oldObject){ //Copy Constructor accepts an object of the same class.
        this.rollNo = oldObject.rollNo;
        this.univName = oldObject.univName;
        this.psp = oldObject.psp;
        this.roomNo = oldObject.roomNo;
    }
    /*
    Student(String heyMan){
        //here you should write valid code
        this.univName = heyMan;
    }
    //or
    Student(String univName){
        this.univName = univName;
    }

    */
}
