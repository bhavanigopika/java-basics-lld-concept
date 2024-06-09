package adderSubtractorSyncMethods;

public class Count {
    long value = 0;
    //create a method
   public synchronized void increamentByX(int x){
        value = value + x;
   }
   public synchronized void decreamentByX(int x){
        value = value -x;
   }
}
