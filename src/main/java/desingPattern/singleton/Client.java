package desingPattern.singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        DbConnection dbc1 = DbConnection.getInstance(lock);
        DbConnection dbc2 = DbConnection.getInstance(lock);
        DbConnection dbc3 = DbConnection.getInstance();
        DbConnection dbc4 = DbConnection.getInstance();

        System.out.println("DEBUG");
        System.out.println(dbc1);
        System.out.println(dbc2);
        System.out.println(dbc3);
        System.out.println(dbc4);

    }
}
