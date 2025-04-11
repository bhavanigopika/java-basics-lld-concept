package desingPattern.prototype;

public class IntelligentStudent extends Student {
    private int iQLevel;
    private double intelligenceScore;

    IntelligentStudent() {

    }

    //how will you clone(copy) the intelligent student? using copy constructor
    IntelligentStudent(IntelligentStudent intelligentStudent){
        super(intelligentStudent);//It takes me to the parent class (i.e) Student, here it goes to copy constructor of Student and get all the values
        this.iQLevel = intelligentStudent.iQLevel;
        this.intelligenceScore = intelligentStudent.intelligenceScore;
    }

    //use the clone(copy) method but it should return the same Intelligent Student heree
    @Override
    public IntelligentStudent clone() {
        //in order to make a clone(copy) of intelligent student, then can I use the copy constructor of intelligent student? YES

        return new IntelligentStudent(this);
    }

    public int getiQLevel() {
        return iQLevel;
    }

    public void setiQLevel(int iQLevel) {
        this.iQLevel = iQLevel;
    }

    public double getIntelligenceScore() {
        return intelligenceScore;
    }

    public void setIntelligenceScore(double intelligenceScore) {
        this.intelligenceScore = intelligenceScore;
    }
}
