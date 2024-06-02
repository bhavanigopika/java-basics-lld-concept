package learningstatic;

public class Student {
    //Let's try static variables
    //say scaler create entity student

    //Below things are different...Are they dependent on object? Yes...these are object dependent

    //so, we have copies of all the attribute with each object
    //Every student information is unique
    String name;
    int age;
    String address;
    double psp;
    String email;

    //Below things are remains same...Are they dependent on object? No...these are object independent

    //So, put static before (String univame, String dressCode, String domainName)
    //Here all student information is same
    //Inside student class, we create univName --so, here univName will be remained same for all students inside the object
    static String univName;
    //dressCode will be same inside the organization
    static String dressCode;
    //domain name in email id will be same inside the organization @scaler.com
    static String domainName;
    static double classRoomSize;

    //Let's try static method
    //This method, no need to call for all the students, call it only once, so domain name has changed
    //If I do not want to call every object, and I want this method into object independent...
    //So, I add static in front of void changeDomainName(String newDomainName)
    static void changeDomainName(String newDomainName) {
        //this.domainName = newDomainName;
        domainName = newDomainName;
    }
}
