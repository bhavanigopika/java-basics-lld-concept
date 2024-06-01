package inheritance;

public class Client {
    public static void main(String[] args) {
//        User user1 = new User();
//        user1.name = "Krish";
//        user1.userName = "blueberry";
//        user1.email = "krish192@gmail.com";

        //default, shown all the attributes of user in instructor when you type .(dot) then you can see all the attributes of user
        //note: actually we didn't have any attributes in instructor....
        // since it is child class, I can see all the attributes of user which I can use in instructor also.
        Instructor i1 = new Instructor();
        //I can add all the attributes of user class
        System.out.println(i1.email);
        i1.email = "kirsh192@gmail.com";
        i1.name = "Krish";
        i1.userName = "blueberry";
        //also, I can add specific attributes of instructor also
        i1.avgRating = 4.98;
        i1.batchName = "May23 Beginner";
        i1.scheduleClass();

        D d = new D();
        d.x = 80; //it appears because,  I have initialzed x is variable in C class since D is the child of C...x variable accepts here.
        d.understandConcepts("hjhk");
        d.understandConcepts();


    }
}
