package Binary;

import java.util.Arrays;
import java.util.Set;

public class MissingNumber {

    public static void main(String[] args){

        int[] arr = new int[]{2,0,1};
        int missingNumber = missingNumber(arr);
        System.out.println(missingNumber);

    }


    public static int missingNumber(int[] arr){

        int xor = 0;//arr.length;
        for(int i=0;i<arr.length;i++){
            xor = xor ^ arr[i] ;
        }
        for(int i=0;i<=arr.length;i++){
            xor = xor ^ i ;
        }

        return xor;
    }
}
