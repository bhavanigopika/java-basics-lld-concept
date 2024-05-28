package example.accessmodifers.package1;

public class Student {
    //public access modifier
    public int rollNo;
    //default access modifier
    double psp;
    //protected access modifier
    protected String univName;
    //private access modifier
    private int roomNo;

    //can access all access modifier in the same class
    void doSomething(){
        rollNo = 1;
        psp = 88;
        univName = "Scaler";
        roomNo = 142;
    }

}
