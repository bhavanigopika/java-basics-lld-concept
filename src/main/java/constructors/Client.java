package constructors;

public class Client {
    public static void main(String[] args) {
      /*  //create the new Object
        Student st1 = new Student(19, "Amritha University");

        Student st2 = new Student(11);
        st2.roomNo = 15;

        Student st3 = new Student();*/

        Student st4 = new Student();
        st4.rollNo = 6;
        st4.univName = "SRM University";
        st4.roomNo = 199;
        st4.psp = 76;

        //pass by reference, adding the content of st4 to fillCoffee
        st4.fillCoffee(st4);

        /*
         	I want to create a copy of this same object with exactly the same set of values for the attributes and
         	copy means with new(different) object reference with same value
         	So, Student st5 = st4; will not work because st5 have same object reference id as like st4.
         	So, here we use copy constructor.
        */
        Student st5 = st4;
        //here rollNo changes... so, changes happen in both st4 and st5
        st5.rollNo = 46;
        System.out.println(st4);
        System.out.println(st5);

        //copy constructor...do the work in Student class also for this.
        Student st4Copy = new Student(st4);

        // we get the same univName both in st4 and st4Copy but string is immutable(unchangeable) so, we can use StringBuilder.
        //StringBuilder sb = new StringBuilder(st4Copy.univName = "Anna");
        //sb.append(st4.univName);

        // we get the diff object reference id for univName and univName is changed to only st4Copy not in st4.
        st4Copy.rollNo = 3;
        st4Copy.univName = "Anna University";

        System.out.println(st4.univName);
        System.out.println(st4Copy.univName);

        Student s5 = new Student();
        s5.rollNo=20;
        s5.univName="Anna University";
        s5.psp = 90;
        s5.roomNo = 181;

        /*Student s10 = new Student("Delhi University");
        System.out.println(s10.univName);*/
    }
}
