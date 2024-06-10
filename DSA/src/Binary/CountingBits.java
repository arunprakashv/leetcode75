package Binary;

import java.util.Arrays;

public class CountingBits {

    public static void main(String[] args){

        int n = 5;
        int[] count = countingBits(n);
        System.out.println(Arrays.toString(count));

    }

    public static int[] countingBits(int n){
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=arr[i>>1]+(i&1);
        }
        return arr;
    }
}
