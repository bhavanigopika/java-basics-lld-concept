package practiceOnMyOwn;

public class Sort {
    public void sort(String s[]){

        for(int i=0;i<s.length-1;i++){

            for(int j=i+1;j<s.length;j++){

                if(s[i].compareToIgnoreCase(s[j]) <= 0){
                    String temp=s[i];
                    s[i]=s[j];
                    s[j]=temp;
                }
            }
        }

    }
}
