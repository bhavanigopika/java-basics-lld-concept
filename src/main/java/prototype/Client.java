package prototype;

public class Client {
    //create prototype and filled the StudentRegistry
    private static void fillRegistry(StudentRegistry studentRegistry) {

        //I am creating prototype for any one who is joining in batch
        //I am creating a new Student using the empty constructor and initialize the attributes - actually we do it here which are all common attributes
        Student july23BeginnerBatch = new Student();
        //apply common attributes here
        july23BeginnerBatch.setBatch("July23BeginnerBatch"); //batch is private, so I used setBatch("");
        july23BeginnerBatch.setInstructorName("Umang Agrawal"); //instructorName is default so, I can use setInstructorName(""); or instructorName = "Umang Agrawal");
        july23BeginnerBatch.setAvgBatchPsp(40); //avgBatchPsp is private so, I have used setAvgBatchPsp("");
        july23BeginnerBatch.moduleName = "LLD2"; // module name is default so, I have used moduleName = "LL2";

        //put the prototype in registry -> key, value -> key is name of the prototype and value is prototype object
        studentRegistry.register("july23BeginnerBatch", july23BeginnerBatch);


        //I can create one more registry/prototype for IntelligentStudent
        //all the intelligent student are same batch
        IntelligentStudent july23IntelligentStudents = new IntelligentStudent();
        //apply common attributes -> use parent (here, I have used few attributes of parent) and children attribute
        july23IntelligentStudents.instructorName = "Umang Agrawal";
        july23IntelligentStudents.iQLevel = 160;
        july23IntelligentStudents.intelligenceScore = 100;
        july23IntelligentStudents.setBatch("July23IntelligentBatch");

        //put the prototype in registry -> key, value -> key is name of the prototype and value is prototype object
        studentRegistry.register("july23IntelligentStudents", july23IntelligentStudents);

    }


    public static void main(String[] args) {
        //create registry before actually create object copies
        //we can create different registry
        StudentRegistry studentRegistry = new StudentRegistry();
        //Client itself fill the registry (i.e) create copies. So, no need to apply again and again because these are all common
        fillRegistry(studentRegistry);

        //apply the uncommon attributes one by one
        //july23BeginnerBatch, july23IntelligentStudents - key name
        //using studentRegistry.get("july23BeginnerBatch") ->  we return the object and using this, I cloned...so I get a copy of that object
        Student krish = studentRegistry.get("july23BeginnerBatch").clone();
        krish.setName("krish");
        krish.setAge(25);
        krish.setPsp(99);

        Student ram = studentRegistry.get("july23BeginnerBatch").clone();
        ram.setName("Sri ram"); // if it is not private, I have used as ram.name = "ram"
        ram.setAge(34);
        ram.setPsp(94);

        Student raghav = studentRegistry.get("july23IntelligentStudents").clone();
        raghav.setName("raghav kumar");
        raghav.setAge(35);
        raghav.psp = 90; // This is private, I have used as ram.psp = 90;
        //raghav.iQLevel -> this will not work because I have created the registry for Student not for IntelligentStudent in StudentRegistry

        /*
        how to modify the moduleName, iqLevel
        if we want to change the iqLevel -> then create the intelligentStudentRegistry in StudentRegistry  because type we have set as Student
        private Map<String, Student> map = new HashMap<>(), if we want intelligentStudent, then we can type intelligentStudent instead of Student.
        Ofcourse, we can do typecast, but is not good idea for production code...
        */
        Student prototype = studentRegistry.get("july23BeginnerBatch");
        prototype.moduleName = "LLD4";
        studentRegistry.register("july23BeginnerBatch", prototype);

        Student abi = studentRegistry.get("july23BeginnerBatch").clone();
        abi.setName("Abi Anu"); // if it is not private, I have used as ram.name = "ram"
        abi.setAge(26);
        abi.setPsp(89);

        System.out.println("Debug");
    }
}
