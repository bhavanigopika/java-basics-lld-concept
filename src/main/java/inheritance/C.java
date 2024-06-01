package inheritance;

public class C extends B{
    //Once call a C object, then it make a call to C constructor and take care of all the attributes here/ initialize the attibutes here.
    int x = 10;
    //let's create the default constructor
    C(){
        System.out.println("Constructor of C is called");
    }
    C(int x){
        System.out.println("Consturctor of C with int param, this.x is " + this.x + " and x is " + x);
        this.x = x;
        System.out.println("Now, constructor of C with int param, x is " + x + " and this.x is " + this.x);
    }
    C(String a){
        super(2,3);
        System.out.println("Constructor of C with a string param");
    }
    C(int p, int q){

    }
}
