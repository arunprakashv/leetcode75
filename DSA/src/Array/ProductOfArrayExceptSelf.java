package Array;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4};
        int[] answer = productOfArrayExceptSelf(nums);
    }
    //prefix product, suffix product
    public static int[] productOfArrayExceptSelf(int[] nums){
        int len = nums.length;

        /*int[] pp = new int[len];
        int[] sp = new int[len];
        int[] product = new int[len];

        pp[0]=1;
        sp[len-1]=1;

        for(int i=1;i<len;i++) pp[i] = pp[i-1]*nums[i-1];
        for(int i=nums.length-2;i>=0;i--) sp[i] = nums[i+1]*sp[i+1];
        for(int i=0;i<nums.length;i++) product[i] = pp[i] * sp[i];*/

        int[] pp = new int[len];
        int[] product = new int[len];
        for(int i=1;i<len;i++) pp[i] = pp[i-1]*nums[i-1];
        int temp=1;
        for(int i = len-1;i>=0;i--){
            product[i]=temp*pp[i];
            temp = temp*nums[i];
        }
        return product;
    }
}
