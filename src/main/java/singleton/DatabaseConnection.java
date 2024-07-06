package singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DatabaseConnection {
    private static DatabaseConnection instance = null;
    Lock lock; //we can use lock object here, otherwise, we can use synchronized keyword in getInstance() method...no need lock in synchronized keyword
    String dbUrl;
    String userName;
    String password;

    public static void setInstance(DatabaseConnection instance) {
        DatabaseConnection.instance = instance;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //using synchronized keyword
    public static DatabaseConnection getInstance() {
        //Double check locking
        if(instance == null){
            //instead of lock, we can use synchronized...this also lock it and allow one thread at a time.
            //I do not want multiple thread entering at the same time
            //synchronized accept the DatabaseConnection.class since initially instance will be null; -> so, you cannot the synchronize null object (i.e) synchronized(instance)
            //pass the not null synchronized object that is we synchronize the entire class
            synchronized(DatabaseConnection.class) {
                if(instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    //using lock
    public static DatabaseConnection getInstance(Lock lock) {
        //Double check locking
        if(instance == null){
            //I do not want multiple thread entering at the same time

            lock.lock();
            if(instance == null) {
                instance = new DatabaseConnection();
            }
            lock.unlock();

        }
        return instance;
    }

    //if the manual constructor created, is there default constructor will create? No
    private DatabaseConnection(){

    }

}
