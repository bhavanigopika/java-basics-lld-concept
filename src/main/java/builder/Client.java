package builder;


public class Client {
    public static void main(String[] args) {
        //create builder/helper object -> builder will create the student object
        //Builder builder = new Builder();

        //Instead of builder will create the student object -> This is the work of developer where he/she create the builder...
        // so, student himself asking the client to build the builder object and thereby student gets created.
        //hence, I have created a new method as getBuilder in Student.java which creates a new Builder object. We just use this here. so above stmts get fulfilled.

/*
        Builder builder = Student.getBuilder();

        //now, set all the attributes
        builder.setName("Krish");
        builder.setAge(21);
        builder.setBatch_name("Monday Evening Academy");
        builder.setGradYear(2024);
        //let's not set phone number, it gives default as null
        //builder.setPhoneNo("8787878979");
        builder.setPsp(89);
        builder.setUnivName("Amritha University");

        //Student st = new Student(builder);
        //Avoid 26th line of code, use below 29th line of code
        //Once I have the builder, I can create the student with builder object
        Student st = builder.buildStudent();
*/

        Student st = Student.getBuilder().setName("Krish")
                .setAge(21)
                .setGradYear(2024)
                .setBatch_name("Monday Morning Academy")
                .setUnivName("Sastra University")
                .setPsp(89)
                .setPhoneNo("8956556759")
                .build();

        //to check whether do we have a student object or not
        System.out.println("Debug here");
    }
}
