package scalerCollections;

public class Student implements Comparable<Student>{
    private int id;
    private int age;
    private String name;
    private double psp;

    Student(int id, int age, String name, double psp) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.psp = psp;
    }

    //Let's add getters and setters


    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getPsp() {
        return psp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    //Goal to order in a natural ordering for a leaderboard
    @Override
    public int compareTo(Student otherStudentObject) {
        //We want the natural order based on psp
        //this - current student object and
        //next one - otherStudentObject
        if(this.getPsp() == otherStudentObject.getPsp()){
            return 0;
        }
        else if(this.getPsp() < otherStudentObject.getPsp()){
            //other...this
            return 1;
        }

        return -1; // else if(this.getPsp() > otherStudentObject.getPsp()) => this...other

        //return (int)(this.psp - otherStudentObject.psp);
    }


    /*
    * this student object and otherStudentObject
    * < 0 -> current student object is smaller than the other student object -> this...other
    * = 0 -> both students are equal -> this...other or other...this
    * > 0 -> current student object is greater than other student object -> other...this
    * */
}
