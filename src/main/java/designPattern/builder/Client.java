package designPattern.builder;

public class Client {
    public static void main(String[] args) {
        //client want to create a student object
        //See, here it is allowing to create object using student constructor. Here, builder doing this(See student.java).
        //Actually student himself asking the client to build the builder object and thereby student gets created. So make the builder as private (i.e) make
        //the student constructor as private in Student class(See student.java) and now not able to create student object using student constructor. Rather, method getBuilder create a new studentBuilder object.
        //To create new studentBuilder without object creation, I mentioned static in getBuilder() method which returns Builder not Student

        //Student st = new Student();
        //Builder builder = Student.getBuilder();
  /*
        Student.Builder builder = Student.getBuilder();

        builder.setName("Vidhu");
        builder.setAge(32);
        builder.setAddress("MM Area");
        builder.setPsp(92.78);
        builder.setBatch("Academy Sep batch");
        builder.setGradYear(2015);
        builder.setUnivName("Goodwell University");
        builder.setRollNo(12);

        //Student student = new Student(builder);//this new students expects builder object but which is coming from student class

        Student student = builder.build(); //this build do all validaton, then create new student object and return back to client
*/
        //Actually in production environment, the code will be
        //Note: If I set age then what should setName return back? same Builder object. So change "void setName into Builder setName" in Student class
        //The following conditions using dot(.) is method chaining
        Student student = Student.getBuilder()
                .setName("Vidhu")
                .setAge(32)
                .setPsp(92.78)/*if the psp is < 85, then it is showing Run Time Exception*/
                .setAddress("MM Area")
                .setBatch("Academy Sep batch")
                .setGradYear(2015) /*if grad year is >= 2024, then it is showing Run Time Exception*/
                .setUnivName("Goodwell University")
                .setRollNo(12)
                .build();

        System.out.println("Debug");

/*      Builder builder = new Builder();

        builder.setName("Vidhu");
        builder.setAge(32);
        builder.setAddress("MM Area");
        builder.setPsp(92.78);
        builder.setBatch("Academy Sep batch");
        builder.setGradYear(2015);
        builder.setUnivName("Goodwell University");
        builder.setRollNo(12);

        Student st = new Student(builder);//this new student expects helper class (i.e) builder class. Helper is actually a builder by the way

*/
        //In reality, client is going to building the object not builder or student class going to build the object. So, comment 13 to 22 line
        //Is this extra work? (i.e) checking the builder object, from builder it goes to student class and create the student class? YES. So, in student class itself
        //we are going to provide method which something gives/returns builder

    }
}
