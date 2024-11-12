package scalerException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Doer {
    public void fetchStudentInfo(int rollNo){//-1 rollno is exceptional situation
        //Code that fetches the student data

    }
    //There are 2 types of exceptions
    /*
    1) Checked Exception -> Compile time exception
            E.g., File Not Found Exception, IO(Input Output) Exception, SQL Exception
    2) Unchecked Exception -> Runtime Exception -> compiler allows it even it can unhandled, but it shows the exception during runtime
            E.g., Null Pointer Exception, Array Index Of Bound Exception

    I have to handle the exception in my own class or I have to throw it to method signature

    */

    //Example of Checked Exception - check it at compile time itself
    public void readFile() throws FileNotFoundException {
        File file = new File("hello.txt");
        Scanner sc = new Scanner(file);//here exception (i.e) file not found, so throws the exception...now error has gone...
    }

    //Example of Unchecked Exception
    public void divide(int a, int b){
        //handle it by manually
        if(b == 0){
            System.out.println("Actually b should not be zero");
            return;
        }
        int res = a / b; //Risk of division by zero(This is unchecked Exception(Runtime exception -> compiler not able to find out) - Here, it is Arithmetic Exception) -> java doesn't require to handle it but shows in runtime
    }

    //Handling the exception using try catch block

    //Using this, we can wrap your risky code in a try block
    //use catch block/s to specify how to handle various exceptions that might occur within your try block
    //Syntax:
    /*
    try{
        //code that may throw an exception
    }catch(Exception e){
        //handle the exception
    }
    */

    //can we handle multiple exception in a single try-catch block? YES
    public void readData(){
        try {
            File file = new File("Data.txt");
            //Scanner object to read
            Scanner sc = new Scanner(file);
        }catch(FileNotFoundException e){
            System.out.println("File not found. Please check the file path...");
        }
    }


    //can we handle multiple exception in a multiple try-catch block? YES, we can catch multiple exceptions by using multiple catch block
    public void readData2(){
        try {
            File file = new File("Data.txt");
            //Scanner object to read
            Scanner sc = new Scanner(file);

            //some code which can throw SQL Exception
            throw new SQLException();
        }
//       catch(IOException e){
//            System.out.println("I/O exception. Please check the file path...");
//        }
        catch(FileNotFoundException e){
            System.out.println("File not found. Please check the file path...");
        }
        //FileNotFoundException extends IOException...so, File Not Found exception is child of IO exception
        catch(SQLException e){ //Exception 'java.sql.SQLException' is never thrown in the corresponding try block...so throw it in try
            System.out.println("Problem connection to SQL Server");
        }
    }

}
