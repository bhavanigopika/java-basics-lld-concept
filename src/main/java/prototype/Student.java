package prototype;

public class Student implements Prototype<Student> {
    private String name;
    private int age;
    double psp;
    private String batch;
    private double avgBatchPsp;
    String instructorName;
    String moduleName;

    //To create a just normal student
    Student(){

    }

    /*
    Now, we need a copy method as per the prototype model
    In programming, the standard term for copy() method is clone()
     */

    // constructor is the one which initialize the attributes of any class
    //copy constructor - who accepts an older object and copies the attributes from the older object to a newer one
    //here, "this" is the newer object
    Student(Student oldObjectStudent){
        this.name = oldObjectStudent.getName();
        this.age = oldObjectStudent.getAge();
        this.psp = oldObjectStudent.getPsp();
        this.batch = oldObjectStudent.getBatch();
        this.avgBatchPsp = oldObjectStudent.getAvgBatchPsp();
        this.instructorName = oldObjectStudent.getInstructorName();
        this.moduleName = oldObjectStudent.getModuleName();
    }
    //or
    /*  Student(Student student){
        this.name = student.name;
        this.age = student.age;
        this.psp = student.psp;
        this.batch = student.batch;
        this.avgBatchPsp = student.avgBatchPsp;
        this.instructorName = student.instructorName;
        this.moduleName = student.moduleName;
    }*/

    @Override
    public Student clone() {
        /*
        //return the same Student itself
        //Here, we are not using the copy constructor here and you yourself copying all the attributes for the new Student
        Student st = new Student();
        st.name = this.name;
        st.age = this.age;
        st.psp = this.psp;
        st.batch = this.batch;
        st.avgBatchPsp = this.avgBatchPsp;
        st.instructorName = this.instructorName;
        st.moduleName = this.moduleName;
        */

        /* here we use the copy constructor, so, just comment above 40-47, and replace it as return new Student(this)
           Here, I am creating a new Student and this new Student object will have same attributes as the object who has called me (i.e)
           how can we access the object who has called the clone method? - using "this" keyword(existing student object)
         */

//      Student st = new Student(this);
//      return st;
        return new Student(this); //this means oldObjectStudent (i.e) student
    }

    /*
    clone() -> copy() -> remember it - getting a copy of already existing object
    If someone says, I want the clone the student(st) object (i.e) st.clone(); -> clone() method will call this(line no:36)...
    This clone()(line no:30) says that ->  see line no: 57 -> I will not initialize anything. I will just create the new object Student and I will let the copy constructor
    and take the student that you passed(current reference - this) and copy all the attributes to the student...
     */

    //Apply getter and setter for Client.java

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPsp() {
        return psp;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public double getAvgBatchPsp() {
        return avgBatchPsp;
    }

    public void setAvgBatchPsp(double avgBatchPsp) {
        this.avgBatchPsp = avgBatchPsp;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
