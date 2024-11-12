package scalerException;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            System.out.println("Attempting to open a file");
            throw new FileNotFoundException();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        finally{
            //clean any resoures
            //closing a file
            //closing a network connection
            System.out.println("closing resources");
        }

        System.out.println("*******************************************");

        try{
            System.out.println("Attempting to open a file");
            File file = new File("db.txt");
            Scanner sc = new Scanner(file);
            return;//still finally block executed
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        finally{
            //clean any resoures
            //closing a file
            //closing a network connection
            System.out.println("closing resources");
        }
    }
}
