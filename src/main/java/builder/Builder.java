package builder;

public class Builder {
    //same attributes as like student class
    //use case of builder/helper class - pass the attributes of student as a parameter in the constructor of student.
    String name;
    int age;
    int gradYear;
    String batch_name;
    String univName;
    String phoneNo;
    double psp;

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

    public int getGradYear() {
        return gradYear;
    }

    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }

    public String getBatch_name() {
        return batch_name;
    }

    public void setBatch_name(String batch_name) {
        this.batch_name = batch_name;
    }

    public String getUnivName() {
        return univName;
    }

    public void setUnivName(String univName) {
        this.univName = univName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public double getPsp() {
        return psp;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

//    public Student build(){
//          //build() -> buildStudent()
//        return new Student(this);//return new student and pass this(builder) object -> this represent current object(i.e) builder object
//    }
}
