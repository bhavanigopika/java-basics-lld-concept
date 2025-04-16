package designPattern.prototype;

public class Client {

    private static final StudentRegistry studentRegistry = new StudentRegistry();

    public static void main(String[] args) {
        /*
        Student st = new Student();//This student has already values initialized
        Student stCopy = st.clone();
        */

        //To avoid which class should call either Student(parent class) or intelligentStudent(child class), then it might handle in the getStudentFromUserService() method. In this method, what we class we define, then that class will call
        //Student student = getStudentFromUserService();
        //Student studentCopy = student.clone();

        //till now, we have seen clone() method and used basics of Object oriented programming(oops).

        /****/

        //Now, we are going to see the prototype design pattern.
        //There are some attributes of student, that client want to initialize and there are some attributes, it wants to make a prototype of student
        /*
        Student sep24APBeginner =  new Student();
        //The following batch name and average batch psp is common to all Sep24APBeginner batch
        sep24APBeginner.setBatch("September24APBeginnerBatch");
        sep24APBeginner.setAvgBatchPsp(86.24);
        */

        fillRegistry();

        Student firstPrototype = studentRegistry.get("September24APBeginnerBatch");
        //copy the batch and avgBatchPsp to the person say "Vidhu" because it is common, and it is not dynamic
        //Student vidhu = sep24APBeginner.clone();
        Student vidhu = firstPrototype.clone();
        vidhu.setName("Vidhu");
        vidhu.setAge(25);
        vidhu.setPsp(90.5);

        //There will be multiple prototype that I want to create, so store them and retrieve whenever I need - use Map - This come to create a class Registry. Here, let's create StudentRegistry(store student prototype(parent), intelligent prototype(child))
        //Now, comment from 20 to 23 line, add this prototype in fillRegistry() method
        //create the studentRegistry object outside the function

        //Let's create another student in firstPrototype
        Student krish = firstPrototype.clone();
        krish.setName("Krish");
        krish.setAge(33);
        krish.setPsp(87.5);

        /***/

        Student secondPrototype = studentRegistry.get("Fep25APBeginnerBatch");

        Student naren = secondPrototype.clone();
        naren.setName("Naren");
        naren.setAge(34);
        naren.setPsp(84.5);

        //Let's create another student in secondPrototype
        Student arun = secondPrototype.clone();
        arun.setName("Arun");
        arun.setAge(35);
        arun.setPsp(98.5);

        Student thirdPrototype = studentRegistry.get("Mar25APBeginnerBatch");
        Student sam = thirdPrototype.clone();
        sam.setName("Sam");
        sam.setAge(21);
        sam.setPsp(98.65);

        Student ram = thirdPrototype.clone();
        ram.setName("Ram Sri");
        ram.setAge(28);
        ram.setPsp(99.5);

        System.out.println("DEBUG");

    }

    public static void fillRegistry(){
        //The going to create a prototype
        Student sep24APBeginner = new Student();
        sep24APBeginner.setBatch("September24APBeginnerBatch");
        sep24APBeginner.setAvgBatchPsp(86.24);
        //key is Sept24APBeginnerBatch, value - actual object that is sep24APBeginner
        studentRegistry.register("September24APBeginnerBatch", sep24APBeginner);

        //Let's create 1 more object
        Student Fep25APBeginner = new Student();
        Fep25APBeginner.setBatch("Fep25APBeginnerBatch");
        Fep25APBeginner.setAvgBatchPsp(90.89);
        //now register in hashmap
        studentRegistry.register("Fep25APBeginnerBatch", Fep25APBeginner);

        //Let's create intelligentStudent
        IntelligentStudent Mar25APBeginner = new IntelligentStudent();
        Mar25APBeginner.setBatch("March25APBeginnerBatch");
        Mar25APBeginner.setAvgBatchPsp(88.87);
        Mar25APBeginner.setIntelligenceScore(90);
        Mar25APBeginner.setiQLevel(100);
        //now register in hashMap
        studentRegistry.register("Mar25APBeginnerBatch", Mar25APBeginner);
    }

}
