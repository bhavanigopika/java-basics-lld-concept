package desingPattern.builder;

public class Student {
    private String name;
    private int age;
    private double psp;
    private String batch;
    private int gradYear;
    private String univName;
    private int rollNo;
    private String address;

    private Student(Builder builder /*helper*/){
        //inside student constructor, I am going to pass helper class (i.e) builder class
        this.name = builder.getName();
        this.age = builder.getAge();
        this.psp = builder.getPsp();
        this.batch = builder.getBatch();
        this.gradYear = builder.getGradYear();
        this.univName = builder.getUnivName();
        this.rollNo = builder.getRollNo();
        this.address = builder.getAddress();
        //builder is inner class (i,e) in student class, so we no need to mention get(), we can also mentio as "this.address = builder.address;" instead of "this.address = builder.getAddress();"
    }

    //in student class itself, I have a method which provides builder (i.e) it returns builder
    //To create new student builder without object creation, I mentioned static in getStudentBuilder() method
    public static Builder getBuilder(){
        return new Builder(); //here why red line means I am trying to create an object of internal class Builder here in the same student class.
                              //Trying to create a new builder and return back to the client - So, make static in line no:33
    }
    //Internal class
    //copy entire builder class here
    static class Builder {
        //helper - helping us to build the object of student. This is actually a builder class. So, let's change the class name helper to builder
        private String name;
        private int age;
        private double psp;
        private String batch;
        private int gradYear;
        private String univName;
        private int rollNo;
        private String address;

        public String getName() {
            return name;
        }

        /*
        public void setName(String name) {
            this.name = name;
        }
        */
        public Builder setName(String name) {
            this.name = name;
            return this;//(return the builer object, so I used this(current object) which is in under the builder class)
        }

        public int getAge() {
            return age;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public double getPsp() {
            return psp;
        }

        public Builder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public String getBatch() {
            return batch;
        }

        public Builder setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public int getGradYear() {
            return gradYear;
        }

        public Builder setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public String getUnivName() {
            return univName;
        }

        public Builder setUnivName(String univName) {
            this.univName = univName;
            return this;
        }

        public int getRollNo() {
            return rollNo;
        }

        public Builder setRollNo(int rollNo) {
            this.rollNo = rollNo;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Student build(){
            //Goal is to check the validation, then create the student object

            //start validation

            //this means current object = builder (i.e) builder going to call the build method here
            if(this.getGradYear() >= 2024){
                throw new RuntimeException("Graduation year should be less than 2024");
            }
            if(this.getPsp() < 85){
                throw new RuntimeException("psp should be greater than 85");
            }
            //end validation

            //here the following line student not create student object here. Because student is private constructor
            return new Student(this);

        }
    }

}
