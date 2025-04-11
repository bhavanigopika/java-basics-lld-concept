package desingPattern.prototype;

public class Student implements Prototype<Student> {
    private String name;
    private int age;
    private String batch;
    private double psp;
    private double avgBatchPsp;

    Student(){ //Here, using default constructor because I'm using it in line no:27
                      // which is empty student object taking default value of all attributes in student object

    }
    Student(Student oldObjectStudent){//this is using it in line no:35 (i.e) used copy constructor - saying please create a copy of the student
        //that student is copied to current one(this)
        this.name = oldObjectStudent.name; //here, "this" is the copy of the student
        this.age = oldObjectStudent.age;
        this.psp = oldObjectStudent.psp;
        this.batch = oldObjectStudent.batch;
        this.avgBatchPsp = oldObjectStudent.avgBatchPsp;
    }

    @Override
    public Student clone() {//
        /*

        //I am going to create a new student which should copy all the methods of student
        Student student = new Student();//This is a new object altogether
        return new Student(student); //Here, this was calling a copy constructor here actually, see it is new Student(student) - copying the same attributes of student with new object

        */

        /* I am going to copy a same attributes of student object but with new object reference. So, instead of above things, I've written as
        Here, I am creating a new Student and this new Student object will have same attributes as the object who has called me (i.e)
        how can we access the object who has called the clone method? - using "this" keyword(existing student object)*/
        //here, "this" is the student from client
        return new Student(this);
    }

    //Apply getter and setter to access from client.java

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

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public double getPsp() {
        return psp;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    public double getAvgBatchPsp() {
        return avgBatchPsp;
    }

    public void setAvgBatchPsp(double avgBatchPsp) {
        this.avgBatchPsp = avgBatchPsp;
    }
}
