package Binary;

public class NumberOf1Bits {

    public static void main(String[] args){

        int a = 11;
        int count = numberOf1Bits(a);
        System.out.println(count);

    }
    public static int numberOf1Bits(int a){
        int count = 0;
        for(int i = 0;i<32;i++){
            /*int mask = 1 << i;
            if((a&mask)!=0){
                count++;
            }*/

            if((a&1)==1){
                count++;
            }
            a=a>>1;
        }

        return count;
    }
}
