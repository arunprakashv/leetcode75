package Array;

public class MaximumSubarray {
    public static void main(String[] args){
        int[] input = new int[]{5,4,-1,7,8};

        int profit = maximumSubarray(input);
        System.out.println(profit);
    }

    public static int maximumSubarray(int[] nums){
        int temp=nums[0];
        int max=temp;
        for(int i=1;i<nums.length;i++){
        /*if(nums[i] > temp+nums[i] ){
                temp = nums[i];
            }else {
                temp = temp + nums[i];
            }
            if (max<temp) max = temp;*/

            temp=Math.max(temp+nums[i], nums[i]);
            max = Math.max(max,temp);
        }

        return max;
    }
}
