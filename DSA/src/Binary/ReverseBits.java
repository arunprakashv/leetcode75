package Binary;

public class ReverseBits {

    public static void main(String[] args){
        int num = 3;
        int reverseNum = reverseBits(num);
        System.out.println(reverseNum);
    }

    public static int reverseBits(int n){
        int num = 0;
        for(int i=0;i<32;i++){
            num = num<<1;
            num=num | (1&n);
            n=n>>1;

        }
        return num;
    }

}
