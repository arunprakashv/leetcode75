package Binary;

public class SumOfTwoIntegers {
    public static void main(String[] args){

        int a =1;
        int b =-3;
        int sum = sumOfTwoIntegers(a,b);
        System.out.println(sum);

    }

    public static int sumOfTwoIntegers(int a, int b){

        while(b!=0){
            int carry = a&b;
            a=a^b;
            b=carry<<1;
        }

        return a;
    }
}
