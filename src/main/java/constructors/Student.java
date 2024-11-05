package constructors;

public class Student {
    int rollNo = 4;
    double psp;
    String univName;
    int roomNo;

    //accepting empty coffee / empty object Student st here
    void fillCoffee(Student st){
        //st.univName = SRM University and this.univName = SRM University so, st4 value has shown here
        System.out.println("Pass by reference");
        System.out.println("Coffee filled for student st.univName is " + st.univName + " and this.univName is " + this.univName);
        //updating the coffee mug with new student
        //empty constructor
        //Pass by value
        st = new Student();
        System.out.println("Pass by Value");
        System.out.println("Coffee not filled for student st.univName is " + st.univName + " and this.univName is " + this.univName); //st.univName = null but this.univName(current object is SRM University

    }

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
    /*Student(String heyMan){
        //here you should write valid code
        this.univName = heyMan;
    }*/

 /*   //Return the value
    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", psp=" + psp +
                ", univName='" + univName + '\'' +
                ", roomNo=" + roomNo +
                '}';
    }*/
//or

    /*Student(String univName){
        this.univName = univName;
    }*/

}
