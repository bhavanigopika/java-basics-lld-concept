package designPattern.singleton;

import java.util.concurrent.locks.Lock;

public class DbConnection {
    private static DbConnection instance = null;
    Lock lock;
    String url;
    String username;
    String password;
    private DbConnection(){

    }
    public static DbConnection getInstance(Lock lock){
        if(instance == null){
            lock.lock();
            if(instance == null){
                instance = new DbConnection();
            }
            lock.unlock();
        }
        return instance;
    }

    public static DbConnection getInstance(){
        if(instance == null){
            synchronized(DbConnection.class){
                if(instance == null){
                    instance = new DbConnection();
                }
            }
        }
        return instance;
    }
}
