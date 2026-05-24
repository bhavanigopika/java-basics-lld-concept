package practiceOnMyOwn;

public class Print {
    public void print(String[] arr){
        for(int i=0;i<arr.length - 1;i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length-1]);

        //or
        for(String s: arr){
            System.out.println(s);
        }


    }
}
