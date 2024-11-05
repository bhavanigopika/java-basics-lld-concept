package exceptions;

import java.sql.SQLException;

public class Client {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Student st1 = new Student();
        //System.out.println(st1.findStudentByRollNo(4)); //Arithmetic Exception
        //st1.findStudentByRollNo(26);

        /*
        try catch
         */

        try {
            st1.findStudentByRollNo(50); //Arithmetic Exception
        } catch (ClassNotFoundException ex1) {
            System.out.println("I am handling class not found exception");
            //let's say again throw an exception
            throw new ClassNotFoundException();
            //Actual error in real time will be
                //System.out.println("There is an error at" + ex1.getStackTrace());
            /*
            Handling will be done here as per your business use case
             */
        } catch (OddNumberException ex2) {
            System.out.println("I am handling odd number exception");
        } catch (EvenNumberException ex3) {
            System.out.println("I am handling even number exception");
        } finally {
            System.out.println("I am inside finally block, will execute irrespective of what happens");
        }

            System.out.println("I am outside try catch");

        //st1.doShit(5);

        /*
        finally is something which will run irrespective of what happens - finally will definitely execute whatever try and catch occur

        in switch case -> we have default
        Similarly, in try-catch block -> we have finally
         */

        /*
        CALL DOSOMETHING HERE and go with try and catch
         */

        /*

        try{
            st1.doSomething(20);
        }catch(SQLException ex1){

//            If you want to make a decision with connection to database(if connection has failed with database, then you make a reestablish the connection)
//            Business decision(logic comes here), retry,

            System.out.println("I am doing some workaround");//piece of code is working around
            throw new SQLException(); //further throwing an exception here and this main method also throws an exception(see main method line) because we have throw here
                                        //we can throw the exception in catch block also...
        }

        */


    }
}
