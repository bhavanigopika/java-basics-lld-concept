package example.accessmodifers.package1;

public class Client {
    public static void main(String[] args) {
        Student st = new Student();
        //We cannot access the private attributes outside the class
        //st.roomNo = 2;
        //we can access the public, protected, default in the same pacakge
        st.univName = "Anna University";
        st.rollNo = 12;
        st.psp = 89;
    }
}
