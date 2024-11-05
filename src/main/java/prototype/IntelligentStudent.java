package prototype;

public class IntelligentStudent extends Student{
    //let's add its own attribute
    int iQLevel;
    double intelligenceScore;

    IntelligentStudent(){

    }

    IntelligentStudent(IntelligentStudent  intelligentStudent){ /* oldObjectIntelligentStudent */
        //initialize the parent attribute
        //call the constructor of parent - using super keyword -> here, to use parent attribute
        super(intelligentStudent); //super of intelligentStudent(children) is Student(parent)
        this.iQLevel = intelligentStudent.iQLevel;
        this.intelligenceScore = intelligentStudent.intelligenceScore;
    }
    @Override
    public IntelligentStudent clone() {
        /*
        //return the same IntelligentStudent
        IntelligentStudent iSt = new IntelligentStudent();

       /* copy all attributes of parent and then child



        //parent attribute

        iSt.name= this.name;
        iSt.age= this.age;
        ist.psp = this.age;
        .
        .*/
        //but is this good idea to copy all parent attribute in the children clone() method? No
        //All the parent attributes are already present in Student.java...However, we can do like this so, it is not a good idea let's see the better implementation to redundant code duplication...
        //remove the parent attributes here and make a call in Student.java...Hence change all the attributes to private in Student.java



        //children attribute
        /*
        iSt.iQLevel = this.iQLevel;
        iSt.intelligenceScore = this.intelligenceScore;

        return iSt;
        */

        // Here, I am creating a new IntelligentStudent and this new IntelligentStudent object will have same attributes as the object who has called me (i.e)
        // how can we access the object who has called the clone method? - using "this" keyword(existing IntelligentStudent object)
        return new IntelligentStudent(this); //this means IntelligentStudent
    }
}