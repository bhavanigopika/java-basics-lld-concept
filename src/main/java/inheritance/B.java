package inheritance;

public class B extends A{

    //let's create the default constructor
    B(){
        System.out.println("Constructor of B is called");

    }
    B(int x, int y){
        System.out.println("Constructor of B is called " + x + " " + y);
    }
    @Override
    void understandConcepts(String x){
        System.out.println("I am understanding the inheritance, polymorphism...Here, I am in /* B */");
    }
}
