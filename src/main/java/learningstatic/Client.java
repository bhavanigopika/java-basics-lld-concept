package learningstatic;

public class Client{
    // static void main
    // so, we didn't create object of Client class to call main method
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        //non-static attributes...so I have to use object as s1.name = "Krish",  s2.name = "Ram"
        //Student.name = "Krish";
        s1.name = "Krish";
        s1.address = "mm area";
        s1.email = "krish@gmail.com";
        s1.age = 21;
        s1.psp = 90;

        s2.name = "Ram";
        s2.address = "xyz area";
        s2.email = "ram@gmail.com";
        s2.age = 24;
        s2.psp = 80;
        //static attribute, so directly call with class name, no need to call via object since it is object independent
        Student.domainName = "scaler.com";
        Student.dressCode = "Blue";
        Student.univName = "Scaler University";
        Student.classRoomSize = 60.30;

        System.out.println(Student.univName);//Scaler University

        //The following this also possible, no matter it is because univName is always same and the object is not dependent
        System.out.println(s1.domainName); //scaler.com
        System.out.println(s2.domainName);//scaler.com
        s1.univName = "Amritha University";
        s1.domainName = "outlook.com";
        System.out.println(s1.univName);//Amritha University
        System.out.println(s1.domainName);//outlook.com
        //static attributes is common to all object...so  domainName applicable to s1 and s2...
        System.out.println(s2.domainName);//outlook.com
        //Better way to access static attributes through class not through object
        System.out.println(Student.domainName);//outlook.com

        //I  have to use static method...If I remove static in Student class, then here definitely error
        Student.changeDomainName("gmail.com");
        //Now, check for two different student
        System.out.println(s1.domainName);//gmail.com
        System.out.println(s2.domainName);//gmail.com
        System.out.println(Student.domainName);//gmail.com

        //If I want to use non-static here, then independently object mention...static usage or without static usage in Student class, here no problem
        s1.changeDomainName("bha.com");
        System.out.println(s1.domainName);//bha.com
        System.out.println(s2.domainName);//bha.com
        System.out.println(Student.domainName);//bha.com


    }
}
