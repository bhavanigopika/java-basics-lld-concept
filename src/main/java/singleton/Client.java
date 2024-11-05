package singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        //make a call to the getinstance
        DatabaseConnection dbc1 = DatabaseConnection.getInstance(lock);
        DatabaseConnection dbc2 = DatabaseConnection.getInstance(lock);

        DatabaseConnection dbc3 = DatabaseConnection.getInstance();
        DatabaseConnection dbc4 = DatabaseConnection.getInstance();

        System.out.println(dbc1);
        System.out.println(dbc2);
        System.out.println(dbc3);
        System.out.println(dbc4);
    }
}
