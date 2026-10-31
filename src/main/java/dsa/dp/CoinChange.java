package dsa.dp;

import java.sql.SQLOutput;

public class CoinChange {

    static int dummyIndent = 0;

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3};
        int numOfWays = coinChange(A,0, 4);
        System.out.println(numOfWays);
    }

    public static int coinChange(int[] A, int s, int B) {
        printDummySpace();
        printSubArray(A, s, A.length - 1);
        printDummySpace();
        System.out.println("Current Target: " + B);
        int count = 0;
        if(B <= 0){
            return count;
        }
        for(int i = s; i <= A.length - 1; i++) {
            printDummySpace();
            System.out.println("Starting with A[i]: " + A[i]);
           // case 1: Within the array, Current element is part of the sum to achieve target number
           // divisibility
           if(B % A[i] == 0){
               printDummySpace();
               System.out.print(A[i]+ " is divisible by " + B + ". ");
               count++;
               printDummySpace();
               System.out.println("Increased count: " + count);
           }
           int nextTarget = B - A[i];
           int nextIndex = s+ 1;
           if(nextTarget > 0){
               printDummySpace();
               System.out.println("Considering current element " + A[i] + " Calculating reminder of current element");
               dummyIndent++;
               count = count + coinChange(A, nextIndex, nextTarget);
               dummyIndent--;
               printDummySpace();
               System.out.println("Count after considering current element:" + count);
           }

           // case 2: Within the array, current element is not part of the sum
           if(B > 0) {
               printDummySpace();
               System.out.println("Calculating without considering current element");
               dummyIndent++;
               count = count + coinChange(A, nextIndex, B);
               dummyIndent--;
               printDummySpace();
               System.out.println("Count after not considering current element:" + count);
           }
        }
        return count;
    }

    private static void printSubArray(int[] A, int start, int end) {
        System.out.print("[");
        for (int i = start; i <= end; i++) {
            System.out.print(A[i] + "-");
        }
        System.out.print("]");
    }

    private static void printDummySpace(){
        for(int i = 0; i < dummyIndent; i++){
            System.out.print(" ");
        }
    }

    public static int coinchange2(int[] A, int B) {

        int count = 0;
        for(int i = 0; i < A.length; i++){
            //Divisibility check
            if(B % A[i] == 0){
                count = count + 1;
            }
            count = count + checkInSubArray(A, (i + 1), (A.length - 1), B - A[i]);
            int nextEle = A[i] + A[i];
            while(nextEle < B){
                if(B - nextEle <= 0){
                    break;
                }
                count = count + checkInSubArray(A, (i + 1), (A.length - 1), B - nextEle);
                nextEle = nextEle + A[i];
            }
        }

        return count;
    }

    private static int checkInSubArray(int[] A, int startIndex, int endIndex, int B){
        int count = 0;
        //Divisibility check
        if(B % A[startIndex] == 0){
            count = count + 1;
        }

        count = count + checkInSubArray(A, startIndex+1, endIndex, B-A[startIndex]);
        int nextEle = A[startIndex] + A[startIndex];
        while(nextEle < B && startIndex + 1 < endIndex ){
            if(B - nextEle <= 0){
                break;
            }
            count = count + checkInSubArray(A, (startIndex + 1), (A.length - 1), B - nextEle);
            nextEle = nextEle + A[startIndex];
        }

        return count;

    }
}
