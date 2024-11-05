package builder;

public class Student {
    String name;
    int age;
    int gradYear;
    String batch_name;
    String univName;
    String phoneNo;
    double psp;

    public static Builder getBuilder(){
        return new Builder();
    }

    //accept helper object in student constructor...helper object is known as Builder object
    //Builder class helps us to build the object of Student
    private Student(Builder builder){

/*
        //validation check -> prevent the creation of student object  not builder object...before the student object created, the validation check has to be performed.
        if(builder.gradYear <= 2020){
            throw new RuntimeException("grad year is less than 2020. Provide grad year greater than 2020 ");
        }
        if(builder.psp < 85){
            throw new RuntimeException("psp is less than 85. Provide psp greater than 85");
        }
*/

        //after validation check, initialize the attributes...
        this.name = builder.name;
        this.age = builder.age;
        this.psp = builder.psp;
        this.gradYear = builder.gradYear;
        this.batch_name = builder.batch_name;
        this.univName = builder.univName;
        this.phoneNo = builder.phoneNo;

    }

    //Builder class move to the Student clas because we want to call the constructor of student which is private and it will be called within the same class.
    public static class Builder {
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

        // Students.Builder setAge ->  class.Builderobject -> like firebase Options

        // All setter methods should return Students.Builder -> Inside the student class, we have builder class

        /* public Builder setName(String name) {

            this.name = name;
            return this;
        }*/
        public Student.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public int getGradYear() {
            return gradYear;
        }

        public Builder setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public String getBatch_name() {
            return batch_name;
        }

        public Builder setBatch_name(String batch_name) {
            this.batch_name = batch_name;
            return this;
        }

        public String getUnivName() {
            return univName;
        }

        public Builder setUnivName(String univName) {
            this.univName = univName;
            return this;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public Builder setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public double getPsp() {
            return psp;
        }

        public Builder setPsp(double psp) {
            this.psp = psp;
            return this;
        }


        public Student build() {
            /*
            build() -> buildStudent()
            here, we do the validation check, because 3rd person have to see the validation check before the student object create. Here we did the student object creation...see 129th line
            validation check -> prevent the creation of student object  not builder object...before the student object created, the validation check has to be performed.
            change builder.gradYear to this,gradYear and builder.psp to this.psp
            */
            if(this.gradYear <= 2020){
                throw new RuntimeException("grad year is less than 2020. Provide grad year greater than 2020 ");
            }
            if(this.psp < 85){
                throw new RuntimeException("psp is less than 85. Provide psp greater than 85");
            }

            return new Student(this);//return new student and pass this(builder) object -> this represent current object(i.e) builder object
                                            // see constructor of student
        }
    }
}
