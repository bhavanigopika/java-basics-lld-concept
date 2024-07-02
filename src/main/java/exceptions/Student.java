package exceptions;

import java.sql.SQLException;

public class Student {
    public int findStudentByRollNo(int rollNo) throws ClassNotFoundException, OddNumberException/*, EvenNumberException*/ {
        //return 1/0; //no compiler error, but run time error(Arithmetic exception - this is one type of runtime exception)
        if(rollNo < 30) {
            //CheckedException- definitely handle or throw it further, you cannot ignore these type of checked exceptions,
            //because it detects at compile time...so here compile time error...soln for this is either handle it here or throws an exception
            throw new ClassNotFoundException();
        }else if(rollNo % 2 == 1){
            throw new OddNumberException();//this is red color, because it is checkedException, either handle it here or throws an exception
        }else if(rollNo % 2 == 0){
            throw new EvenNumberException();
        }
        /*
        else{
            //runtime exception, so java not force to handle this exception that is no compiler time error but may occur run time error
            throw new IndexOutOfBoundsException();
        }
        */

//            int a = 10, b = 5;
//            if(b != 0){
//                int temp = a/b;
//            }

        return 1;
    }


    //handle the exception here itself(not in main method), instead of throwing  it, I will put it in the try block
    public void doSomething(int rollNo) throws SQLException {
        try {
            if (rollNo < 30) {
                //CheckedException- definitely handle or throw it further, you cannot ignore these type of checked exceptions,
                //because it detects at compile time...so here compile time error...soln for this is either handle it here or throws an exception
                throw new ClassNotFoundException();
            } else if (rollNo % 2 == 1) {
                throw new OddNumberException();//this is red color, because it is checkedException, either handle it here or throws an exception
            } else if (rollNo % 2 == 0) {
                throw new EvenNumberException();
            } else {
                throw new SQLException();
            }
        }
        //single exception -> just say catch(Exception ex) because everything comes under Exception and no need to write other catch blocks...we can all children into parent itself
        //that is all ClassNotFoundException, OddNumberException, EvenNumberException under Exception itself
        //developer catch them differently.
        /*  catch(Exception ex){

        }*/
        catch(ClassNotFoundException ex1){
            System.out.println("I am in class not found exception:" + ex1);
        } catch(OddNumberException ex2){
            System.out.println("I am in odd number exception:" + ex2);
        } catch(EvenNumberException ex3){
            System.out.println("I am in even number exception:" + ex3);
        }
        //either we have to handle SQLException here or throw it parent method, see above
        //we have mentioned throws SQLException
        //let's comment here and write the line "throws SQLException" at the method
        /* catch(SQLException ex4){

        }*/

        //handle all other exception here
        catch(Exception ex4){
            System.out.println("I am in unexpected exception:" + ex4);
        }
    }


    //Difference between error and exception
    //The following code once called, it keeps on calling since it is recursive code but doesn't have base value
    //Here, it doesn't throw the exception but the following code doesn't have meaning, so the following code is called error and stack overflow happens
    public void doShit(int x){
        doShit(x);
    }
}

/*
Types of exception:
    a) runtime exception - unchecked exception(does not try and catch), no comipiler error/check...run time error
            Example: Arithmetic Exception, IndexOutOfBounds etc.,
    b) checked exception(Need try and catch) -> definitely need to handle, compiler error will occur(either caller method handle it or throws the exception)
            Example: ClassNotFoundException, SQLException

Ideally, your code should  not have run time exception

Suppose, if Exception in -> A -> B -> C
then we have to handle C first, then B, then A, then Exception

 */